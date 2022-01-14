import org.apache.commons.lang3.StringUtils;

import java.util.List;

class D02 {

    public int run(List<String> puzzle) {
       return puzzle.stream().mapToInt(this::score).sum();
    }

    private Integer score(String puzzle) {
        String[] match = StringUtils.split(puzzle, " ");

        switch (match[0]) {
            case "A" -> {
                switch (match[1]) {
                    case "X":
                        return 1 + 3;
                    case "Y":
                        return 2 + 6;
                    case "Z":
                        return 3 + 0;
                }
            }
            case "B" -> {
                switch (match[1]) {
                    case "X":
                        return 1 + 0;
                    case "Y":
                        return 2 + 3;
                    case "Z":
                        return 3 + 6;
                }
            }
            case "C" -> {
                switch (match[1]) {
                    case "X":
                        return 1 + 6;
                    case "Y":
                        return 2 + 0;
                    case "Z":
                        return 3 + 3;
                }
            }
        }
        return null;
    }

    public Integer runStrategy(List<String> puzzle) {
        return puzzle.stream().mapToInt(this::scoreStrategy).sum();
    }

    private Integer scoreStrategy(String puzzle) {
        String[] match = StringUtils.split(puzzle, " ");

        switch (match[0]) {
            case "A" -> {
                switch (match[1]) {
                    case "X": //loose
                        return 3 + 0;
                    case "Y": //draw
                        return 1 + 3;
                    case "Z": //win
                        return 2 + 6;
                }
            }
            case "B" -> {
                switch (match[1]) {
                    case "X":
                        return 1 + 0;
                    case "Y":
                        return 2 + 3;
                    case "Z":
                        return 3 + 6;
                }
            }
            case "C" -> {
                switch (match[1]) {
                    case "X":
                        return 2 + 0;
                    case "Y":
                        return 3 + 3;
                    case "Z":
                        return 1 + 6;
                }
            }
        }
        return null;
    }
//    private List<List<Integer>> build(List<String> cals) {
//        List<List<Integer>> elves = new ArrayList<>();
//        List<Integer> elf = new ArrayList<>();
//        for (int i = 0; i < cals.size(); i++) {
//            if (cals.get(i).equals("")) {
//                elves.add(elf);
//                elf = new ArrayList<>();
//            } else
//                elf.add(Integer.parseInt(cals.get(i)));
//        }
//        //last one
//        elves.add(elf);
//        return elves;
//    }
//
//    public int threeMostCalories(List<String> cals) {
//        List<List<Integer>> elves = build(cals);
//
//        return elves.stream().mapToInt(e -> e.stream().collect(Collectors.summingInt(Integer::intValue))).boxed()
//                .sorted(Comparator.reverseOrder()).limit(3).collect(Collectors.summingInt(Integer::intValue));
//    }

}
