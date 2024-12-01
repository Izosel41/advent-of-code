package aoc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


class D03Test {
    D03 d;

    @BeforeEach
    void init(){
        d = new D03();
    }

    @Test
    void consumption() throws Exception {
        File df = new File(this.getClass().getClassLoader().getResource("D03Test.txt").toURI());
        List<String> diags = d.buildDiag(df);
        int[] rates = d.consumption(diags);
        assertThat(rates[0] * rates[1], is(198));
    }

    @Test
    void one() throws Exception {
        File df = new File(this.getClass().getClassLoader().getResource("D03.txt").toURI());
        List<String> diags = d.buildDiag(df);
        int[] rates = d.consumption(diags);
        System.out.println(rates[0] * rates[1]);
    }

    @Test
    void lifeSupport() throws Exception {
        File df = new File(this.getClass().getClassLoader().getResource("D03Test.txt").toURI());
        List<String> diags = d.buildDiag(df);
        int[] rates = d.lifeSupport(diags);
        assertThat(rates[0] * rates[1], is(230));
    }

    @Test
    void two() throws Exception {
        File df = new File(this.getClass().getClassLoader().getResource("D03.txt").toURI());
        List<String> diags = d.buildDiag(df);
        int[] rates = d.lifeSupport(diags);
        System.out.println(rates[0] * rates[1]);
    }
}