package aoc;

public class Utils {
    public static void drawMatrix(Object[][] map, int depth, int length) {
        for (int x = 0; x < depth; x++) {
            for (int y = 0; y < length; y++) {
                System.out.print(map[x][y]);
            }
            System.out.println();
        }
    }
}
