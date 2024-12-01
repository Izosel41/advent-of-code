package aoc;

import aoc.D01;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.file.Files;
import java.util.List;
import java.util.Objects;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


class D01Test {

    D01 d;

    @BeforeEach
    void init() {
        d = new D01();
    }

    @Test
    void testOne() throws Exception {
        File df = new File(this.getClass().getClassLoader().getResource("D01test.txt").toURI());
        List<String> cals = Files.readAllLines(df.toPath());
        assertThat(d.one(cals), is(11));
    }

    @Test
    void one() throws Exception {
        File df = new File(this.getClass().getClassLoader().getResource("D01.txt").toURI());
        List<String> cals = Files.readAllLines(df.toPath());
        System.out.println(d.one(cals));
    }

    @Test
    void testTwo() throws Exception {
        File df = new File(this.getClass().getClassLoader().getResource("D01test.txt").toURI());
        List<String> cals = Files.readAllLines(df.toPath());
        assertThat(d.two(cals), is(31));
    }

    @Test
    void two() throws Exception {
        File df = new File(this.getClass().getClassLoader().getResource("D01.txt").toURI());
        List<String> cals = Files.readAllLines(df.toPath());
        System.out.println(d.two(cals));

    }
}