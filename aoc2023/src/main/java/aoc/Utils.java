package aoc;

import java.util.List;

public class Utils {
    public static void drawMatrix(Object[][] map, int depth, int length) {
        for (int x = 0; x < depth; x++) {
            for (int y = 0; y < length; y++) {
                System.out.print(map[x][y]);
            }
            System.out.println();
        }
    }

    public static char[][] createMatrix(List<String> lines) {
        int width = lines.get(0).length();
        int height = lines.size();
        char[][] grid = new char[height][width];
        for (int x = 0; x < height; x++) {
            for (int y = 0; y < width; y++) {
                grid[x][y] = lines.get(x).charAt(y);
            }
        }

        return grid;
    }
}
