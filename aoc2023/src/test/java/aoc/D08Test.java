package aoc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.file.Files;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class D08Test {
    D08 d;
    List<String> puzzleTest;
    List<String> puzzle;

    @BeforeEach
    void init() throws Exception {
        d = new D08();
        File testFile = new File(this.getClass().getClassLoader().getResource("D08Test.txt").toURI());
        puzzleTest = Files.readAllLines(testFile.toPath());
        File puzzleFile = new File(this.getClass().getClassLoader().getResource("D08.txt").toURI());
        puzzle = Files.readAllLines(puzzleFile.toPath());
    }

    @Test
    void oneTest() throws Exception {
        assertThat(d.one(puzzleTest), is(2));
    }

    @Test
    void oneTest2() throws Exception {
        File testFile2 = new File(this.getClass().getClassLoader().getResource("D08Test2.txt").toURI());
        assertThat(d.one(Files.readAllLines(testFile2.toPath())), is(6L));
    }

    @Test
    void one() throws Exception {
        System.out.println(d.one(puzzle));
    }

    @Test
    void twoTest() throws Exception {
        File testFile3 = new File(this.getClass().getClassLoader().getResource("D08Test3.txt").toURI());
        assertThat(d.two(Files.readAllLines(testFile3.toPath())), is(6));
    }

    @Test
    void two() throws Exception {
        System.out.println(d.two(puzzle));
    }

}
