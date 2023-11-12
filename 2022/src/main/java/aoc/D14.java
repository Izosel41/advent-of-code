package aoc;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

class D14 {

    public static final Character AIR = '.';
    public static final Character ROCK = '#';
    public static final Character SOURCE = '+';
    public static final Character SAND = 'o';

    public int one(List<String> puzzle, int square) {

        Character[][] map = createMap(puzzle, square, new Character[square][square], false);
        int res = fallSand(map);
        Utils.drawMatrix(map, 200, 520);
        return res;
    }

    public int fallSand(Character[][] map) {
        int count = 0;
        boolean fallenIntoAbyss = false;

        while (!fallenIntoAbyss) {
            int x = 0;
            int y = 500;
            boolean stop = false;

            while (!stop) {
                if (Objects.equals(map[x + 1][y], AIR)) {
                    x++;
                    fallenIntoAbyss = hasFallenIntoAbyss(x, y, map);
                } else if (Objects.equals(map[x + 1][y - 1], AIR)) {
                    x++;
                    y--;
                } else if (Objects.equals(map[x + 1][y + 1], AIR)) {
                    x++;
                    y++;
                } else if (!Objects.equals(map[x][y], SOURCE)) {
                    map[x][y] = SAND;
                    stop = true;
                    count++;
                } else {
                    //no more sand from source, stop everything
                    map[x][y] = SAND;
                    count++;
                    stop = true;
                    fallenIntoAbyss = true;
                }
                if (fallenIntoAbyss)
                    stop = true;
            }
        }
        return count;
    }

    private boolean hasFallenIntoAbyss(int x, int y, Character[][] map) {
        return Arrays.stream(Arrays.copyOfRange(map, x + 1, map.length))
                .flatMap(characters -> Stream.of(characters[y]))
                .allMatch(character -> Objects.equals(character, AIR));
    }

    public Character[][] createMap(List<String> puzzle, int square, Character[][] map, boolean isThereFloor) {
        //air
        for (int i = 0; i < square; i++) {
            for (int j = 0; j < square; j++) {
                map[i][j] = AIR;
            }
        }
        //source
        map[0][500] = SOURCE;

        int minFloor = 0;
        //rock
        for (String line : puzzle) {

            String[] steps = line.split(" -> ");
            int xStart = -1;
            int yStart = -1;
            for (String step : steps) {
                String[] coords = step.split(",");
                int xEnd = -1;
                int yEnd = -1;
                //first step
                if (xStart == -1) {
                    xStart = Integer.parseInt(coords[0]);
                    yStart = Integer.parseInt(coords[1]);
                } else {
                    xEnd = Integer.parseInt(coords[0]);
                    yEnd = Integer.parseInt(coords[1]);

                    //draw line
                    int x0 = Math.min(xStart, xEnd);
                    int y0 = Math.min(yStart, yEnd);

                    minFloor = Math.max(y0, minFloor);

                    int x1 = Math.max(xStart, xEnd);
                    int y1 = Math.max(yStart, yEnd);

                    for (int x = x0; x <= x1; x++) {
                        for (int y = y0; y <= y1; y++) {
                            map[y][x] = ROCK;
                        }
                    }
                    xStart = Integer.parseInt(coords[0]);
                    yStart = Integer.parseInt(coords[1]);
                }
            }
        }
        if(isThereFloor)
            for (int y = 0; y < square; y++) {
                map[minFloor+2][y] = ROCK;
            }
        return map;
    }

    public int two(List<String> puzzle, int square) {
        Character[][] map = createMap(puzzle, square, new Character[square][square], true);
        int res = fallSand(map);
        Utils.drawMatrix(map, 200, 520);
        return res;

    }

}