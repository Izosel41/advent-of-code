package aoc;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;

class D05 {

    public String move(List<String> puzzles) {

        List<List<String>> stacks = buildStacks(puzzles);

        for (String puzzle : puzzles) {
            if (puzzle.startsWith("m")) {
                String[] cmd = puzzle.split(" ");
                int quantity = parseInt(cmd[1]);
                int from = parseInt(cmd[3]) - 1;
                int to = parseInt(cmd[5]) - 1;

                for (int q = 0; q < quantity; q++) {
                    stacks.get(to).add(0,
                            stacks.get(from).remove(0));
                }
            }
        }
        return stacks.stream().map(q -> q.get(0)).collect(Collectors.joining());

    }

    public String move1(List<String> puzzles) {

        List<List<String>> stacks = buildStacks(puzzles);

        for (String puzzle : puzzles) {
            if (puzzle.startsWith("m")) {
                String[] cmd = puzzle.split(" ");
                int quantity = parseInt(cmd[1]);
                int from = parseInt(cmd[3]) - 1;
                int to = parseInt(cmd[5]) - 1;

                List<String> c = new ArrayList<>(stacks.get(from).subList(0, quantity));
                stacks.get(from).subList(0, quantity).clear();
                c.addAll(stacks.get(to));
                stacks.set(to, c);
            }
        }

        return stacks.stream().map(q -> q.get(0)).collect(Collectors.joining());
    }


    private List<List<String>> buildStacks(List<String> puzzles) {
        List<List<String>> stacks = new ArrayList<>();

        int size = puzzles.stream()
                .filter(s -> s.startsWith(" 1"))
                .mapToInt(s -> parseInt(s.substring(s.length() - 2, s.length() - 1)))
                .findFirst()
                .orElse(0);
        for (int j = 0; j < size; j++) {
            List<String> s = new ArrayList<>();
            stacks.add(s);
        }

        int i = 0;
        while (!puzzles.get(i).startsWith(" 1")) {
            String[] crates = puzzles.get(i).split("");
            // [X] [Y] ...
            for (int j = 1; j < crates.length; j = j + 4) {
                if (!crates[j].equals(" ")) stacks.get(j / 4).add(crates[j]);
            }
            i++;
        }
        return stacks;
    }
}
