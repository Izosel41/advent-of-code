package aoc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.file.Files;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class D15Test {
    D15 d;
    List<String> puzzleTest;
    List<String> puzzle;

    @BeforeEach
    void init() throws Exception {
        d = new D15();
        File testFile = new File(this.getClass().getClassLoader().getResource("D15Test.txt").toURI());
        puzzleTest = Files.readAllLines(testFile.toPath());
        File puzzleFile = new File(this.getClass().getClassLoader().getResource("D15.txt").toURI());
        puzzle = Files.readAllLines(puzzleFile.toPath());
    }

    @Test
    void oneTest() throws Exception {
        assertThat(d.one(puzzleTest, 10), is(26L));
    }

    @Test
    void one() throws Exception {
        System.out.println(d.one(puzzle, 2000000));
    }

    @Test
    void twoTest() throws Exception {
        assertThat(d.two(puzzleTest, 20), is(56000011));
    }

    @Test
    void two() throws Exception {
        System.out.println(d.two(puzzle, 4000000));
    }

}
