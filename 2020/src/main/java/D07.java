import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class D07 {

    Map<String, Integer> references;

    public class Bag {
        String name;
        Integer occurrence;
        List<Bag> containees;
        Integer canHaveShiny = 0;

        public String getName() {
            return this.name;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    public Integer countContainsShinyBag(List<String> lines) {
        List<Bag> rules = mapLinesIntoRules(lines);

        this.references = rules.stream().collect(Collectors.toMap(Bag::getName, b -> b.canHaveShiny - b.canHaveShiny));

        //process all containees
        while (references.values().contains(0)) {
            for (String ref : references.keySet()) {
                if (references.get(ref) == 0) {
                    references.put(ref, processRules(rules.stream().filter(b -> b.name.equals(ref)).findFirst().get(), rules));
                }
            }
        }
        return references.values().stream().filter(i->i==1).collect(Collectors.summingInt(Integer::intValue));
    }

    private Integer processRules(Bag container, List<Bag> rules) {
        //Bag shiny = new Bag();
        //shiny.container =
        String shiny = "shiny gold";
        //shiny cannot contain itself
        if (container.name.equals(shiny))
            return -1;
        //has no child
        if (container.containees.size() == 0)
            return -1;

        //unknown
        if (this.references.get(container.name).intValue() == 0) {
            //one of the containees is shiny
            if (container.containees.stream().map(Bag::getName).filter(s -> s.equals(shiny)).count() > 0) {
                return 1;
            } else {
                //one of them can have shiny
                boolean unknown = false;
                for (Bag containee : container.containees) {
                    if (references.get(containee.name) == 1)
                        return 1;
                    else if (references.get(containee.name) == 0)
                        unknown = true;
                }
                if (unknown)
                    return 0;
                else
                    //none were shiny
                    return -1;
            }
        }else{
            return this.references.get(container.name).intValue();
        }
    }


    private List<Bag> mapLinesIntoRules(List<String> lines) {
        List<Bag> bags = new ArrayList<>();
        for (String line: lines) {
            Bag bigBag = new Bag();
            //muted yellow bags contain 2 shiny gold bags, 9 faded blue bags.
            line = line.replace("contain ", "");
            line = line.replace(",", "");
            line = line.replace("no other", "0");
            line = line.replace("bags", "bag");
            line = line.replace(".", " ");
            //muted yellow bag 2 shiny gold bag 9 faded blue bag .
            Pattern p = Pattern.compile(" bag ");
            String[] elements = p.split(line);
            //[muted yellow] bag [2 shiny gold] bag [9 faded blue] bag [.]
            bigBag.name = elements[0].trim();

            List<Bag> containees = new ArrayList<>();
            if(!"0".equals(elements[1])){
            //[2 shiny gold] bag [9 faded blue] bag [.]
            for(int i=1;i<elements.length; i++){
                Bag b = new Bag();
                String rule = elements[i];
                String[] elts = rule.split(" ");
                b.occurrence = Integer.valueOf(elts[0]);
                String re = elts[0]+" ";
                b.name = rule.replace(re, "");
                containees.add(b);
            }}
            bigBag.containees = containees;
            bigBag.occurrence = 1;
            bags.add(bigBag);
        }
        return bags;
    }


    public int countBagsInsideShiny(List<String> lines) {
        List<Bag> rules = mapLinesIntoRules(lines);

        this.references = rules.stream().collect(Collectors.toMap(Bag::getName, b -> b.canHaveShiny - b.canHaveShiny));

        //process all containees
        while (references.values().contains(0)) {
            for (String ref : references.keySet()) {
                if (references.get(ref) == 0) {
                    references.put(ref, processRules(rules.stream().filter(b -> b.name.equals(ref)).findFirst().get(), rules));
                }
            }
        }

        //now count
        int res = 0;
        //remove shiny
        res = -1 + countBagInside("shiny gold", rules);
        return res;
    }

    private int countBagInside(String name, List<Bag> rules) {
        System.out.println(name);
        //fetch rule for this bag
        Bag bag = rules.stream().filter(b->b.name.equals(name)).findFirst().get();
        if(bag.containees==null || bag.containees.size()==0)
            return 1;
        else{
            int nbChildren = bag.containees.stream().map(b->b.occurrence * countBagInside(b.name, rules)).collect(Collectors.summingInt(Integer::intValue));
            //itself + children
            return 1+ bag.occurrence * nbChildren;
        }

    }
}
