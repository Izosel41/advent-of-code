package aoc;


import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static aoc.Utils.createMatrix;

public class D03 {

    public int one(List<String> puzzle) {
        int res = 0;

        char[][] grid = createMatrix(puzzle);

        for (int x = 0; x < grid.length; x++) {

            Pattern p = Pattern.compile("\\d+");
            Matcher matcher = p.matcher(puzzle.get(x));
            while (matcher.find()) {
                if (isAdjacent(grid, x, matcher.start(), matcher.end() - 1)) {
                    res += Integer.parseInt(String.valueOf(matcher.group()));
                }
            }
        }
        return res;
    }

    private static boolean isANumber(char grid) {
        return grid > 47 && grid < 58;
    }

    private boolean isAdjacent(char[][] grid, int line, int yStart, int yEnd) {
        boolean adjacent = false;

        int i = line - 1;
        if (i < 0)
            i = 0;

        for (; i <= line + 1 && i < grid.length; i++) {
            int j = yStart - 1;
            if (j < 0)
                j = 0;
            for (; j <= yEnd + 1 && j < grid[i].length; j++) {
                if (!isANumber(grid[i][j]) && grid[i][j] != 46)
                    adjacent = true;
            }
        }

        return adjacent;
    }

    public int two(List<String> puzzle) {
        char[][] grid = createMatrix(puzzle);

        Map<Point, Gear> gears = new HashMap<>();
        for (int x = 0; x < grid.length; x++) {

            Pattern p = Pattern.compile("\\d+");
            Matcher matcher = p.matcher(puzzle.get(x));

            while (matcher.find()) {
                int i = x - 1;
                if (i < 0)
                    i = 0;

                for (; i <= x + 1 && i < grid.length; i++) {
                    int j = matcher.start() - 1;
                    if (j < 0)
                        j = 0;
                    for (; j <= matcher.end() && j < grid[i].length; j++) {
                        if (grid[i][j] == '*') {
                            Point star = new Point(i, j);

                            if (gears.containsKey(star)) {
                                Gear g = gears.get(star);
                                g.setSecond(Integer.parseInt(String.valueOf(matcher.group())));
                            } else {
                                Gear g = new Gear(Integer.parseInt(String.valueOf(matcher.group())), null);
                                gears.put(star, g);
                            }
                        }
                    }

                }
            }
        }
        return gears.values().stream().filter(g -> g.getSecond() != null).mapToInt(g -> g.first * g.second).sum();
    }
}

record Point(int i, int j) {
}

@Data
class Gear {
    Integer first;
    Integer second;

    public Gear(Integer first, Integer second) {
        this.first = first;
        this.second = second;
    }
}