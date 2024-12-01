package aoc;

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
    void createMapAndDraw() throws Exception {
        File testFile = new File(this.getClass().getClassLoader().getResource("D14Test.txt").toURI());
        puzzleTest = Files.readAllLines(testFile.toPath());
        Character[][] map = d.createMap(puzzleTest, 505, new Character[505][505], false);
        //draw line
        Utils.drawMatrix(map, 505, 505);
    }

    @Test
    void oneTest() throws Exception {
        assertThat(d.one(puzzleTest, 1000), is(24));
    }

    @Test
    void one() throws Exception {
        System.out.println(d.one(puzzle, 1000));
    }

    @Test
    void twoTest() throws Exception {
        assertThat(d.two(puzzleTest,1000), is(93));
    }

    @Test
    void two() throws Exception {
        System.out.println(d.two(puzzle,1000));
    }

}
