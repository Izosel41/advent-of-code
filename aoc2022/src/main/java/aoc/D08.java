package aoc;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class D08 {

    public int one(List<String> puzzle) {
        //build
        int side = puzzle.size();
        int[][] matrix = build(puzzle, side);

        Set<String> visible = parseVisibles(side, matrix);
        // debug
        for (int y = 0; y < side; y++) {
            System.out.println();
            for (int x = 0; x < side; x++) {
                if (visible.contains(y + ";" + x))
                    System.out.print((char) 27 + "[33m" + matrix[y][x] + (char) 27 + "[0m");
                else
                    System.out.print(matrix[y][x]);
            }
        }
        System.out.println();

        return visible.size() + (2 * side) + 2 * (side - 2);
    }

    private static Set<String> parseVisibles(int side, int[][] matrix) {
        Set<String> visible = new HashSet<>();
        //parse line
        for (int line = 1; line < side - 1; line++) {
            // left
            int highest = matrix[line][0];
            for (int y = 1; y < side - 1; y++) {
                highest = findVisible(matrix, visible, highest, line, y);
            }

            // right
            highest = matrix[line][side - 1];
            for (int y = side - 2; y > 0; y--) {
                highest = findVisible(matrix, visible, highest, line, y);
            }
        }

        //parse row
        for (int row = 1; row < side - 1; row++) {
            // up
            int highest = matrix[0][row];
            for (int x = 1; x < side - 1; x++) {
                highest = findVisible(matrix, visible, highest, x, row);
            }
            // down
            highest = matrix[side - 1][row];
            for (int x = side - 2; x > 0; x--) {
                highest = findVisible(matrix, visible, highest, x, row);
            }
        }
        return visible;
    }

    private static int[][] build(List<String> puzzle, int side) {
        int[][] matrix = new int[side][side];
        for (int x = 0; x < side; x++) {
            String[] line = puzzle.get(x).split("");
            for (int i = 0; i < side; i++) {
                matrix[x][i] = Integer.parseInt(line[i]);
            }
        }
        return matrix;
    }

    private static int findVisible(int[][] matrix, Set<String> visible, int highest, int x, int y) {
        if (matrix[x][y] > highest) {
            highest = matrix[x][y];
            visible.add(x + ";" + y);
        }
        return highest;
    }


    public int two(List<String> puzzle) {
        //build
        int side = puzzle.size();
        int[][] matrix = build(puzzle, side);

        Set<String> visible = parseVisibles(side, matrix);

        // highest scenic
        int h = 0;

        for (String peak : visible) {
            int up = 0;
            int down = 0;
            int left = 0;
            int right = 0;

            String[] v = peak.split(";");
            int lineP = Integer.parseInt(v[0]);
            int rowP = Integer.parseInt(v[1]);
            int visibleP = matrix[lineP][rowP];

            //up
            for (int y = lineP-1; y >= 0; y--) {
                if (visibleP > matrix[y][rowP]) {
                    up++;
                } else{
                    up++;
                    y = 0;
                }
            }

            //down
            for (int y = lineP+1; y <= side-1; y++) {
                if (visibleP > matrix[y][rowP]) {
                    down++;
                } else{
                    down++;
                    y = side;
                }
            }
            //left
            for (int x = rowP-1; x >= 0; x--) {
                if (visibleP > matrix[lineP][x]) {
                    left++;
                } else{
                    left++;
                    x = 0;
                }
            }
            //right
            for (int x = rowP+1; x <= side-1; x++) {
                if (visibleP > matrix[lineP][x]){
                    right++;
                } else{
                    right++;
                    x = side;
                }
            }

            if (h < (up * down * left * right))
                h = up * down * left * right;
        }
        return h;
    }

}
