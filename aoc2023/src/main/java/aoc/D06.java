package aoc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class D06 {
    public long one(List<String> puzzleTest) {

        List<Integer> times = Arrays.stream(puzzleTest.getFirst().split(": ")[1].split(" "))
                .filter(s-> !s.isEmpty())
                .mapToInt(Integer::parseInt)
                .boxed()
                .toList();

        List<Integer> distances = Arrays.stream(puzzleTest.getLast().split(": ")[1].split(" "))
                .filter(s-> !s.isEmpty())
                .mapToInt(Integer::parseInt)
                .boxed()
                .toList();

        long res = 0;
        for (int i = 0; i < times.size(); i++) {

            Integer time = times.get(i);
            Integer distance = distances.get(i);
            res = res + IntStream
                    .range(0, time)
                    .filter(t -> time - t * t <= distance)
                    .count();
        }
        return res;
    }

    public int two(List<String> puzzleTest) {
        List<Rule> seedToSoilRules = new ArrayList<>();
        List<Rule> soilToFertilizer = new ArrayList<>();

        return -1;
    }

}
