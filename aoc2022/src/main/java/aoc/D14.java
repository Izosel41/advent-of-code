package aoc;

import java.util.Iterator;
import java.util.List;

class D14 {

    public int one(List<String> puzzle) {
        int res = 0;


        return res;
    }

    public char[][] createMap(List<String> puzzle, int square) {
        char[][] map = new char[square][square];
        //air
        for (int i = 0; i < square; i++) {
            for (int j = 0; j < square; j++) {
                map[i][j] = '.';
            }
        }
        //source
        map[0][500] = '+';

        //rock
        Iterator<String> puzzleIte = puzzle.iterator();
        while (puzzleIte.hasNext()) {
            String line = puzzleIte.next();
            String[] steps = line.split(" -> ");
            int xStart = -1, yStart = -1;
            for (String step : steps) {
                String[] coords = step.split(",");
                int xEnd = -1, yEnd = -1;
                //first step
                if (xStart == -1) {
                    xStart = Integer.parseInt(coords[0]);
                    yStart = Integer.parseInt(coords[1]);
                } else {
                    xEnd = Integer.parseInt(coords[0]);
                    yEnd = Integer.parseInt(coords[1]);

                    //draw line
                    int x0 = xStart<xEnd? xStart: xEnd;
                    int y0 = yStart<yEnd? yStart: yEnd;
                    int x1= xStart<xEnd? xEnd: xStart;
                    int y1= yStart<yEnd? yEnd: yStart;

                    for (int x = x0; x <= x1; x++) {
                        for (int y = y0; y <= y1; y++) {
                            map[x][y] = '#';
                        }
                    }
                }
            }
        }
        return map;
    }

    public int two(List<String> puzzle) {
        //divider packets
        puzzle.add("[[2]]");
        puzzle.add("[[6]]");

        return 1;

    }
}