package aoc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.file.Files;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class D07Test {
    D07 d;
    List<String> puzzleTest;
    List<String> puzzle;

    @BeforeEach
    void init() throws Exception {
        d = new D07();
        File testFile = new File(this.getClass().getClassLoader().getResource("D07Test.txt").toURI());
        puzzleTest = Files.readAllLines(testFile.toPath());
        File puzzleFile = new File(this.getClass().getClassLoader().getResource("D07.txt").toURI());
        puzzle = Files.readAllLines(puzzleFile.toPath());
    }

    @Test
    void order() {
        assertThat(d.compareHands("AA8AA","AAAAA"), is(-1));
        assertThat(d.compareHands("23332","AA8AA"), is(-1));
        assertThat(d.compareHands("TTT98","23332"), is(-1));
        assertThat(d.compareHands("23432","TTT98"), is(-1));
        assertThat(d.compareHands("A23A4","23432"), is(-1));
        assertThat(d.compareHands("23456","A23A4"), is(-1));

        assertThat(d.compareHands("2AAAA","33332"), is(-1));
        assertThat(d.compareHands("77788","77888"), is(-1));

        assertThat(d.compareHands("32T3K","KTJJT"), is(-1));
        assertThat(d.compareHands("KTJJT","KK677"), is(-1));
        assertThat(d.compareHands("KK677","T55J5"), is(-1));
        assertThat(d.compareHands("T55J5","QQQJA"), is(-1));

        assertThat(d.compareHands("236T9","229J8"), is(-1));
    }

    @Test
    void oneTest() throws Exception {
        assertThat(d.one(puzzleTest), is(6440));
    }

    @Test
    void one() throws Exception {
        System.out.println(d.one(puzzle));
    }

    @Test
    void order2() {
        assertThat(d.compareHandsWithJoker("JKKK2", "QQQQ2"), is(-1));

        assertThat(d.compareHandsWithJoker("32T3K","KK677"), is(-1));
        assertThat(d.compareHandsWithJoker("KK677","T55J5"), is(-1));
        assertThat(d.compareHandsWithJoker("T55J5","QQQJA"), is(-1));
        assertThat(d.compareHandsWithJoker("QQQJA","KTJJT"), is(-1));

        assertThat(d.compareHandsWithJoker("32T4K","32T4J"), is(-1));
        assertThat(d.compareHandsWithJoker("32T3K","32T3J"), is(-1));
        assertThat(d.compareHandsWithJoker("32T3T","3JT3T"), is(-1));
        assertThat(d.compareHandsWithJoker("3223T","3223J"), is(-1));
        assertThat(d.compareHandsWithJoker("3222T","3222J"), is(-1));
        assertThat(d.compareHandsWithJoker("32222","3222J"), is(-1));
        assertThat(d.compareHandsWithJoker("22222","2222J"), is(-1));
    }

    @Test
    void twoTest() throws Exception {
        assertThat(d.two(puzzleTest), is(5905));
    }

    @Test
    void two() throws Exception {
        System.out.println(d.two(puzzle));
    }

}
