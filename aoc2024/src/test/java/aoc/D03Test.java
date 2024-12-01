package aoc;

import aoc.D02;
import aoc.D03;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.file.Files;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class D03Test {
    D03 d;
    List<String> puzzleTest;
    List<String> puzzle;

    @BeforeEach
    void init() throws Exception {
        d = new D03();
        File testFile = new File(this.getClass().getClassLoader().getResource("D03Test.txt").toURI());
        puzzleTest = Files.readAllLines(testFile.toPath());
        File puzzleFile = new File(this.getClass().getClassLoader().getResource("D03.txt").toURI());
        puzzle = Files.readAllLines(puzzleFile.toPath());
    }

    @Test
    void oneTest() throws Exception {
        assertThat(d.one(puzzleTest), is(4361));

        File testFile2 = new File(this.getClass().getClassLoader().getResource("D03Test2.txt").toURI());
        List<String> puzzleTest2 = Files.readAllLines(testFile2.toPath());
        assertThat(d.one(puzzleTest2), is(43));
    }

    @Test
    void one() throws Exception {
        System.out.println(d.one(puzzle));
    }

    @Test
    void twoTest() throws Exception {
        assertThat(d.two(puzzleTest), is(467835));
    }

    @Test
    void two() throws Exception {
        System.out.println(d.two(puzzle));
    }

}
