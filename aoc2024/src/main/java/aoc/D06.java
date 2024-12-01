package aoc;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class D06 {
    public long one(List<String> puzzleTest) {

        List<Integer> times = Arrays.stream(puzzleTest.getFirst().split(": ")[1].split(" "))
                .filter(s -> !s.isEmpty())
                .mapToInt(Integer::parseInt)
                .boxed()
                .toList();

        List<Integer> distances = Arrays.stream(puzzleTest.getLast().split(": ")[1].split(" "))
                .filter(s -> !s.isEmpty())
                .mapToInt(Integer::parseInt)
                .boxed()
                .toList();

        long res = 1;
        for (int i = 0; i < times.size(); i++) {
            long way = countWays(times.get(i), distances.get(i));
            if (way != 0)
                res = res * way;
        }
        return res;
    }

    long countWays(Integer time, Integer distance) {
        return IntStream
                .range(0, time)
                .filter(t -> (time - t) * t > distance)
                .count();
    }

    public long two(List<String> puzzleTest) {
        Long time = Long.parseLong(Arrays.stream(puzzleTest.getFirst().split(": ")[1].split(""))
                .filter(s -> !s.equals(" "))
                .collect(Collectors.joining()));

        Long distance = Long.parseLong(Arrays.stream(puzzleTest.getLast().split(": ")[1].split(""))
                .filter(s -> !s.equals(" "))
                .collect(Collectors.joining()));

        return LongStream
                .range(1, time)
                .filter(t -> ((time - distance/t )> t))
                .count();
    }
}
