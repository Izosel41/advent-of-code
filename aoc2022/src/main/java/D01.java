import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class D01 {

    public int mostCalories(List<String> cals) {
        List<List<Integer>> elves = build(cals);

        return elves.stream().mapToInt(e -> (Integer) e.stream().mapToInt(Integer::intValue).sum()).max()
                .getAsInt();
    }

    private List<List<Integer>> build(List<String> cals) {
        List<List<Integer>> elves = new ArrayList<>();
        List<Integer> elf = new ArrayList<>();
        for (String cal : cals) {
            if (cal.equals("")) {
                elves.add(elf);
                elf = new ArrayList<>();
            } else
                elf.add(Integer.parseInt(cal));
        }
        //last one
        elves.add(elf);
        return elves;
    }

    public int threeMostCalories(List<String> cals) {
        List<List<Integer>> elves = build(cals);

        return elves.stream().mapToInt(e -> (Integer) e.stream().mapToInt(Integer::intValue).sum()).boxed()
                .sorted(Comparator.reverseOrder()).limit(3).mapToInt(Integer::intValue).sum();
    }

}
