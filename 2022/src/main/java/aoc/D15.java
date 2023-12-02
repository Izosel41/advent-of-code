package aoc;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class D15 {
    public long one(List<String> puzzle, int line) {
        Map<Point, Integer> input = extractInput(puzzle);

        long fullRange = input.entrySet().stream()
                //compute only the one impacting the line
                .filter(entry -> "S".equals(entry.getKey().type) && Math.abs(entry.getKey().y - line) <= entry.getValue())
                // find range
                .map(entry -> {
                            int remainingRange = Math.abs(entry.getValue() - (Math.abs(entry.getKey().y - line)));
                            return IntStream.range(entry.getKey().x - remainingRange, entry.getKey().x + remainingRange + 1);
                        }
                )
                //flatMap for having one stream
                .flatMap(IntStream::boxed)
                .distinct()
                .count();

        //remove beacons
        long beaconsPresentOnLine = input.entrySet().stream()
                .filter(entry -> "B".equals(entry.getKey().type) && Objects.equals(entry.getKey().y, line))
                .count();
        return fullRange - beaconsPresentOnLine;
    }


    public int two(List<String> puzzle, int max) {
        Map<Point, Integer> input = extractInput(puzzle);

        Map<Integer, Set<Integer>> z = IntStream.range(0, max)
                .boxed()
                .map(line -> Map.of(line, findNotPossiblePosition(input, line)))
               // .filter(map -> map.)
                .findFirst()
                .get();
        Integer x = (Integer) z.keySet().toArray()[0];
        Object[] line = z.entrySet().toArray();
        Integer y = IntStream.range(0, max).boxed().filter(i -> !z.get(0).contains(i)).findAny().get();
        System.out.println(z);

        return 4000000 * x + y;
    }

    private static Set<Integer> findNotPossiblePosition(Map<Point, Integer> input, int line) {
        return input.entrySet().stream()
                //compute only the one impacting the line
                .filter(entry -> "S".equals(entry.getKey().type) && Math.abs(entry.getKey().y - line) <= entry.getValue())
                // create range
                .map(entry -> {
                            int remainingRange = Math.abs(entry.getValue() - (Math.abs(entry.getKey().y - line)));
                            return IntStream.range(entry.getKey().x - remainingRange, entry.getKey().x + remainingRange + 1);
                        }
                )
                //flatMap for having one stream
                .flatMap(IntStream::boxed)
                .collect(Collectors.toSet());
    }

    public Map<Point, Integer> extractInput(List<String> puzzle) {

        Map<Point, Integer> grid = new HashMap<>();
        for (String line : puzzle) {
            Pattern p = Pattern.compile("(?>Sensor at x=)(-?\\d+)(?>, y=)(-?\\d+)(?>: closest beacon is at x=)(-?\\d+)(?>, y=)(-?\\d+)");
            Matcher matcher = p.matcher(line);
            if (!matcher.find())
                throw new RuntimeException(line);
            Point beacon = new Point("B", Integer.parseInt(matcher.group(3)), Integer.parseInt(matcher.group(4)));
            Point sensor = new Point("S", Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)));
            grid.put(sensor, measureManhattanDistance(beacon, sensor));
            grid.put(beacon, 0);
        }
        return grid;
    }

    public record Point(String type, int x, int y) {
    }

    public int measureManhattanDistance(Point a, Point b) {
        return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
    }
}
