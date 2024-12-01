package aoc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.file.Files;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class D06Test {
    D06 d;
    List<String> puzzleTest;
    List<String> puzzle;

    @BeforeEach
    void init() throws Exception {
        d = new D06();
        File testFile = new File(this.getClass().getClassLoader().getResource("D06Test.txt").toURI());
        puzzleTest = Files.readAllLines(testFile.toPath());
        File puzzleFile = new File(this.getClass().getClassLoader().getResource("D06.txt").toURI());
        puzzle = Files.readAllLines(puzzleFile.toPath());
    }

    @Test

    void countWays() {
        assertThat(d.countWays(7,9), is(4L));
        assertThat(d.countWays(15,40), is(8L));
        assertThat(d.countWays(30,200), is(9L));
    }

    @Test
    void oneTest() throws Exception {
        assertThat(d.one(puzzleTest), is(288L));
    }

    @Test
    void one() throws Exception {
        System.out.println(d.one(puzzle));
    }

    @Test
    void twoTest() throws Exception {
        assertThat(d.two(puzzleTest), is(71503L));
    }

    @Test
    void two() throws Exception {
        System.out.println(d.two(puzzle));
    }

}
