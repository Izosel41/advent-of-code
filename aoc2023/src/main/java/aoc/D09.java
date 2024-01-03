package aoc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class D09 {
    public int one(List<String> puzzleTest) {
        return puzzleTest.stream()
                .map(s -> Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).boxed())
                .mapToInt(suite -> findNext(suite.toList()))
                .sum();
    }

    public int two(List<String> puzzleTest) {
        return puzzleTest.stream()
                .map(s -> Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).boxed())
                .mapToInt(suite -> findPrevious(suite.toList()))
                .sum();
    }

    public Integer findNext(List<Integer> suite) {
        if (suite.stream().mapToInt(Integer::intValue).sum() == 0) return 0;
        else {
            List<Integer> intermediateSteps = new ArrayList<>();
            for (int i = 0; i < suite.size() - 1; i++) {
                intermediateSteps.add(suite.get(i + 1) - suite.get(i));
            }
            return findNext(intermediateSteps) + suite.getLast();
        }
    }

    public Integer findPrevious(List<Integer> suite) {
        if (suite.stream().mapToInt(Integer::intValue).sum() == 0) {
            return 0;
        } else {
            List<Integer> intermediateSteps = new ArrayList<>();
            for (int i = 0; i < suite.size() - 1; i++) {
                intermediateSteps.add(suite.get(i + 1) - suite.get(i));
            }
            return suite.getFirst() - findPrevious(intermediateSteps);
        }
    }
}

