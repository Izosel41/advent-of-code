package aoc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class D09Test {
    D09 d;
    List<String> puzzleTest;
    List<String> puzzle;

    @BeforeEach
    void init() throws Exception {
        d = new D09();
        File testFile = new File(this.getClass().getClassLoader().getResource("D09Test.txt").toURI());
        puzzleTest = Files.readAllLines(testFile.toPath());
        File puzzleFile = new File(this.getClass().getClassLoader().getResource("D09.txt").toURI());
        puzzle = Files.readAllLines(puzzleFile.toPath());
    }

    @Test
    void oneTest() throws Exception {
        assertThat(d.one(puzzleTest), is(114));
    }

    @Test
    void findNext() {
        assertThat(d.findNext(Arrays.stream("0 3 6 9 12 15".split(" ")).mapToInt(Integer::parseInt).boxed().toList()), is(18));
        assertThat(d.findNext(Arrays.stream("1 3 6 10 15 21".split(" ")).mapToInt(Integer::parseInt).boxed().toList()), is(28));
        assertThat(d.findNext(Arrays.stream("10 13 16 21 30 45".split(" ")).mapToInt(Integer::parseInt).boxed().toList()), is(68));
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
