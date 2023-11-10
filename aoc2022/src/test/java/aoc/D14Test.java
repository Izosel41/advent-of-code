package aoc;

import org.json.JSONArray;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.file.Files;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class D14Test {
    D14 d;
    List<String> puzzleTest;
    List<String> puzzle;

    @BeforeEach
    void init() throws Exception {
        d = new D14();
        File testFile = new File(this.getClass().getClassLoader().getResource("D14Test.txt").toURI());
        puzzleTest = Files.readAllLines(testFile.toPath());
        File puzzleFile = new File(this.getClass().getClassLoader().getResource("D14.txt").toURI());
        puzzle = Files.readAllLines(puzzleFile.toPath());
    }

    @Test
    void createMapAndDraw() throws Exception{
        d = new D14();
        File testFile = new File(this.getClass().getClassLoader().getResource("D14Test.txt").toURI());
        puzzleTest = Files.readAllLines(testFile.toPath());
        char[][] map = d.createMap(puzzleTest, 505);
        //draw line
        for (int x = 0; x < 505; x++) {
            for (int y = 0; y < 505; y++) {
                System.out.print(map[x][y]);
            }
            System.out.println();
        }
    }

    @Test
    void oneTest() throws Exception {
        assertThat(d.one(puzzleTest), is(13));
    }

    @Test
    void one() throws Exception {
        System.out.println(d.one(puzzle));
    }

    @Test
    void twoTest() throws Exception {
        assertThat(d.two(puzzleTest), is(140));
    }

    @Test
    void two() throws Exception {
        System.out.println(d.two(puzzle));
    }

}
