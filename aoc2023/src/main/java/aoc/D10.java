package aoc;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class D10 {

    public int one(List<String> lines) {
        int width = lines.getFirst().length();
        int height = lines.size();

       /*
       List<List<Point>> grid = new ArrayList<>();

        for (int i = 0; i < height; i++) {
            List<Point> line = new ArrayList<>();
            for (int j = 0; j < width; j++) {
                line.add(new Point(i,j, lines.get(i).charAt(j)));
            }
            grid.add(line);
        }
        */
        List<Point> points = new ArrayList<>();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                points.add(new Point(i, j, lines.get(i).charAt(j)));
            }
        }

        Point start = points.stream().filter(point -> point.value().equals(Step.START.getValue())).findAny().orElseThrow();

        // follow loop
        int distance = 0;
        Point nextPoint = null;
        while (distance > 0 && !start.equals(start)) {
            nextPoint = findNext(points, nextPoint);
            distance++;
        }

        return distance;

    }

    private Point findNext(List<Point> points, Point nextPoint) {
        Step base = Arrays.stream(Step.values()).filter(step -> step.getValue() == grid[x][y]).findAny().orElseThrow();
        List<Character> nextSteps = new ArrayList<>();

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i != 0 || j != 0) {
                    nextSteps.add(grid[x + i][y + j]);
                }
            }
        }
        nextSteps.stream().filter(character -> base.next().contains(character)).findAny().orElseThrow();
    }

    public int two(List<String> puzzleTest) {
        return -1;
    }

}

@Getter
enum Step {

    NS('|') {
        @Override
        public List<Character> next() {
            return List.of(NS.value, SW.value, SE.value, START.value);
        }
    }, EW('-') {
        @Override
        public List<Character> next() {
            return List.of(NW.value, SW.value, EW.value, START.value);
        }
    }, NE('L') {
        @Override
        public List<Character> next() {
            return List.of(NS.value, SW.value, SE.value, START.value);
        }
    }, NW('J') {
        @Override
        public List<Character> next() {
            return List.of(NS.value, SW.value, SE.value, START.value);
        }
    }, SW('7') {
        @Override
        public List<Character> next() {
            return List.of(EW.value, NE.value, SE.value, START.value);
        }
    }, SE('F') {
        @Override
        public List<Character> next() {
            return List.of(EW.value, SW.value, START.value);
        }
    }, GROUND('.') {
        @Override
        public List<Character> next() {
            return List.of();
        }
    }, START('S') {
        @Override
        public List<Character> next() {
            return List.of(NS.value, EW.value, NE.value, NW.value, SW.value, SE.value, START.value);
        }
    };

    public abstract List<Character> next();

    private final char value;

    Step(char val) {
        this.value = val;
    }
}

