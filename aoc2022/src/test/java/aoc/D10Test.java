package aoc;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.file.Files;
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
    void oneTest() throws Exception {

        MatcherAssert.assertThat(d.one(puzzleTest), is(13140));
    }

    @Test
    void one() throws Exception {
        System.out.println(d.one(puzzle));
    }

    @Test
    void twoTest() throws Exception {
        MatcherAssert.assertThat(d.two(puzzleTest), is(
                "##..##..##..##..##..##..##..##..##..##.." +
                "###...###...###...###...###...###...###." +
                "####....####....####....####....####...." +
                "#####.....#####.....#####.....#####....." +
                "######......######......######......####" +
                "#######.......#######.......#######....."));
    }

    @Test
    void two() throws Exception {
        System.out.println(d.two(puzzle));
    }
}
