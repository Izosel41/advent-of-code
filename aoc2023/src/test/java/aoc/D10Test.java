package aoc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class D10Test {
    D10 d;
    List<String> puzzleTest;
    List<String> puzzle;

    @BeforeEach
    void init() throws Exception {
        d = new D10();
        File testFile = new File(this.getClass().getClassLoader().getResource("D10Test.txt").toURI());
        puzzleTest = Files.readAllLines(testFile.toPath());
        File puzzleFile = new File(this.getClass().getClassLoader().getResource("D10.txt").toURI());
        puzzle = Files.readAllLines(puzzleFile.toPath());
    }

    @Test
    void farthest() {
        String input = """
                .....
                .S-7.
                .|.|.
                .L-J.
                .....
                """;
        assertThat(d.farthest(input), is(4));

        String input2 = """
                ..F7.
                .FJ|.
                SJ.L7
                |F--J
                LJ...
                """;
        assertThat(d.farthest(input2), is(8));
    }

    @Test
    void oneTest() throws Exception {
        assertThat(d.one(puzzleTest), is(114));
    }

    @Test
    void one() throws Exception {
        System.out.println(d.one(puzzle));
    }

    @Test
    void twoTest() throws Exception {
        assertThat(d.two(puzzleTest), is(2));
    }

    @Test
    void two() throws Exception {
        System.out.println(d.two(puzzle));
    }

}
