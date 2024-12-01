package aoc;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.file.Files;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


class D03Test {

    @Test
    void meetTrees() throws Exception {
        D03 d = new D03();
        File df = new File(this.getClass().getClassLoader().getResource("D03_test.txt").toURI());
        List<String> input = Files.readAllLines(df.toPath());

        int width = input.get(0).length();
        int height = input.size();
        char[][] grid = new char[height][width];
        for (int x = 0; x < height; x++) {
            for (int y = 0; y < width; y++) {
                grid[x][y] = input.get(x).charAt(y);
            }
        }
        MatcherAssert.assertThat(d.meetTrees(3, 1, grid, width, height), is(7));
    }

    @Test
    void one() throws Exception {
        D03 d = new D03();
        File df = new File(this.getClass().getClassLoader().getResource("D03.txt").toURI());
        List<String> input = Files.readAllLines(df.toPath());

        int width = input.get(0).length();
        int height = input.size();
        char[][] grid = new char[height][width];
        for (int x = 0; x < height; x++) {
            for (int y = 0; y < width; y++) {
                grid[x][y] = input.get(x).charAt(y);
            }
        }

        System.out.println(d.meetTrees(3, 1, grid, width, height));
    }

    @Test
    void two() throws Exception {
        D03 d = new D03();
        File df = new File(this.getClass().getClassLoader().getResource("D03.txt").toURI());
        List<String> input = Files.readAllLines(df.toPath());

        int width = input.get(0).length();
        int height = input.size();
        char[][] grid = new char[height][width];
        for (int x = 0; x < height; x++) {
            for (int y = 0; y < width; y++) {
                grid[x][y] = input.get(x).charAt(y);
            }
        }

        System.out.println(d.meetTrees(1, 1, grid, width, height)
        * d.meetTrees(3, 1, grid, width, height)
        * d.meetTrees(5, 1, grid, width, height)
        * d.meetTrees(7, 1, grid, width, height)
        * d.meetTrees(1, 2, grid, width, height));
    }


}