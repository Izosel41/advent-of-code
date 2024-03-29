package aoc;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


class D11Test {

    D11 d;

    List<D11.Monkey> puzzleTest;
    List<D11.Monkey> puzzle;

    @BeforeEach
    void init() throws Exception {
        d = new D11();

        initPuzzleTest();
        puzzle = new ArrayList<>();
        D11.Monkey m0 = new D11.Monkey();
        m0.setItems(new LinkedList<>());
        m0.getItems().add(83L);
        m0.getItems().add(88L);
        m0.getItems().add(96L);
        m0.getItems().add(79L);
        m0.getItems().add(86L);
        m0.getItems().add(88L);
        m0.getItems().add(70L);

        m0.setOp((x) -> x * 5);
        m0.setTest((x) -> x % 11 == 0 ? 2 : 3);
        puzzle.add(m0);

        D11.Monkey m1 = new D11.Monkey();
        m1.setItems(new LinkedList<>());
        m1.getItems().add(59L);
        m1.getItems().add(63L);
        m1.getItems().add(98L);
        m1.getItems().add(85L);
        m1.getItems().add(68L);
        m1.getItems().add(72L);

        m1.setOp((x) -> x * 11);
        m1.setTest((x) -> x % 5 == 0 ? 4 : 0);
        puzzle.add(m1);

        D11.Monkey m2 = new D11.Monkey();
        m2.setItems(new LinkedList<>());
        m2.getItems().add(90L);
        m2.getItems().add(79L);
        m2.getItems().add(97L);
        m2.getItems().add(52L);
        m2.getItems().add(90L);
        m2.getItems().add(94L);
        m2.getItems().add(71L);
        m2.getItems().add(70L);
        m2.setOp((x) -> x + 2);
        m2.setTest((x) -> x % 19 == 0 ? 5 : 6);
        puzzle.add(m2);

        D11.Monkey m3 = new D11.Monkey();
        m3.setItems(new LinkedList<>());
        m3.getItems().add(97L);
        m3.getItems().add(55L);
        m3.getItems().add(62L);

        m3.setOp((x) -> x + 5);
        m3.setTest((x) -> x % 13 == 0 ? 2 : 6);
        puzzle.add(m3);

        D11.Monkey m4 = new D11.Monkey();
        m4.setItems(new LinkedList<>());
        m4.getItems().add(74L);
        m4.getItems().add(54L);
        m4.getItems().add(94L);
        m4.getItems().add(76L);

        m4.setOp((x) -> x * x);
        m4.setTest((x) -> x % 7 == 0 ? 0 : 3);
        puzzle.add(m4);

        D11.Monkey m5 = new D11.Monkey();
        m5.setItems(new LinkedList());
        m5.getItems().add(58l);

        m5.setOp((x) -> x + 4);
        m5.setTest((x) -> x % 17 == 0 ? 7 : 1);
        puzzle.add(m5);

        D11.Monkey m6 = new D11.Monkey();
        m6.setItems(new LinkedList<>());
        m6.getItems().add(66L);
        m6.getItems().add(63L);
        m6.setOp((x) -> x + 6);
        m6.setTest((x) -> x % 2 == 0 ? 7 : 5);
        puzzle.add(m6);

        D11.Monkey m7 = new D11.Monkey();
        m7.setItems(new LinkedList<>());
        m7.getItems().add(56L);
        m7.getItems().add(56L);
        m7.getItems().add(90L);
        m7.getItems().add(96L);
        m7.getItems().add(68L);

        m7.setOp((x) -> x + 7);
        m7.setTest((x) -> x % 3 == 0 ? 4 : 1);
        puzzle.add(m7);
    }

    private void initPuzzleTest() {
        puzzleTest = new ArrayList<>();
        D11.Monkey m0 = new D11.Monkey();
        m0.setItems(new LinkedList<>());
        m0.getItems().add(79L);
        m0.getItems().add(98L);
        m0.setOp((x) -> x * 19);
        m0.setTest((x) -> x % 23 == 0 ? 2 : 3);
        puzzleTest.add(m0);

        D11.Monkey m1 = new D11.Monkey();
        m1.setItems(new LinkedList<>());
        m1.getItems().add(54L);
        m1.getItems().add(65L);
        m1.getItems().add(75L);
        m1.getItems().add(74L);
        m1.setOp((x) -> x + 6);
        m1.setTest((x) -> x % 19 == 0 ? 2 : 0);
        puzzleTest.add(m1);

        D11.Monkey m2 = new D11.Monkey();
        m2.setItems(new LinkedList<>());
        m2.getItems().add(79L);
        m2.getItems().add(60L);
        m2.getItems().add(97L);
        m2.setOp((x) -> x * x);
        m2.setTest((x) -> x % 13 == 0 ? 1 : 3);
        puzzleTest.add(m2);

        D11.Monkey m3 = new D11.Monkey();
        m3.setItems(new LinkedList<>());
        m3.getItems().add(74L);
        m3.setOp((x) -> x + 3);
        m3.setTest((x) -> x % 17 == 0 ? 0 : 1);
        puzzleTest.add(m3);
    }

    @Test
    void oneTest() throws Exception {
        MatcherAssert.assertThat(d.one(puzzleTest, 20), is(10605));
    }

    @Test
    void one() throws Exception {
        System.out.println(d.one(puzzle, 20));
    }

    @Test
    void twoTest() throws Exception {
        int gcd = 23 * 19 * 13 * 17;
        MatcherAssert.assertThat(d.two(puzzleTest, 10000, gcd), is(2713310158L));
    }

    @Test
    void two() throws Exception {

        int gcd = 11 * 5 * 19 * 13 * 7 * 17 * 2 * 3;
        System.out.println(d.two(puzzle, 10000, gcd));
    }
}
