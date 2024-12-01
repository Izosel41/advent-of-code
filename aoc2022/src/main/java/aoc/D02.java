package aoc;

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
            default -> throw new IllegalStateException("Unexpected value: " + match[0]);
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
            default -> throw new IllegalStateException("Unexpected value: " + match[0]);
        }
        return null;
    }
}
