import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class D08 {

    public int getAccumulatorAtSecondLoop(List<String> lines) {
        Set<Integer> accIndex = new HashSet(lines.size());
        int acc =0;
        int i = 0;

        while(!accIndex.contains(i)){
            accIndex.add(i);
            String a = lines.get(i);
            String[]els = a.split(" ");
            if("nop".equals(els[0])) {
                i++;
            }else if("acc".equals(els[0])) {
                acc = acc + Integer.parseInt(els[1]);
                i++;
            }else if("jmp".equals(els[0]))
                i = i + Integer.parseInt(els[1]);
        }
        return acc;
    }

    public int getAccumulatorByChangeInstr(List<String> lines) {
        String old = null;

        //change nop to jmp or jmp to nop
        for(int j=0; j<lines.size();j++) {

            if(lines.get(j).contains("nop")) {
                old=lines.get(j);
                lines.set(j, lines.get(j).replace("nop", "jmp"));
            }
            else if(lines.get(j).contains("jmp")) {
                old = lines.get(j);
                lines.set(j, lines.get(j).replace("jmp", "nop"));
            }

            if(!lines.get(j).contains("acc")) {
                int i = 0;
                int acc =0;
                Set<Integer> accIndex = new HashSet(lines.size());
                while (!accIndex.contains(i)) {
                    if (i == lines.size())
                        return acc;

                    accIndex.add(i);
                    String a = lines.get(i);
                    String[] els = a.split(" ");
                    if ("nop".equals(els[0])) {
                        i++;
                    } else if ("acc".equals(els[0])) {
                        acc = acc + Integer.parseInt(els[1]);
                        i++;
                    } else if ("jmp".equals(els[0]))
                        i = i + Integer.parseInt(els[1]);
                }
                lines.set(j, old);
            }
        }
        return Integer.MIN_VALUE;
    }
}
