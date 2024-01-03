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

    public static long lcm(long number1, long number2) {
        if (number1 == 0 || number2 == 0) {
            return 0;
        }
        long absNumber1 = Math.abs(number1);
        long absNumber2 = Math.abs(number2);
        long absHigherNumber = Math.max(absNumber1, absNumber2);
        long absLowerNumber = Math.min(absNumber1, absNumber2);

        long lcm = absHigherNumber;
        while (lcm % absLowerNumber != 0) {
            lcm += absHigherNumber;
        }
        return lcm;
    }
}
