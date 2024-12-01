package aoc;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


class D06Test {

    @Test
    void testSumYes() throws Exception {
        D06 d = new D06();
        File f = new File(this.getClass().getClassLoader().getResource("D06_test.txt").toURI());
        MatcherAssert.assertThat(d.sumYes(f), is(11));
    }

    @Test
    void one() throws Exception {
        D06 d = new D06();
        File f = new File(this.getClass().getClassLoader().getResource("D06.txt").toURI());
        System.out.println(d.sumYes(f));
    }

    @Test
    void testSumAllYes() throws Exception {
        D06 d = new D06();
        File f = new File(this.getClass().getClassLoader().getResource("D06_test.txt").toURI());
        MatcherAssert.assertThat(d.sumAllYes(f), is(6));
    }

    @Test
    void two() throws Exception {
        D06 d = new D06();
        File f = new File(this.getClass().getClassLoader().getResource("D06.txt").toURI());
        System.out.println(d.sumAllYes(f));
    }
}