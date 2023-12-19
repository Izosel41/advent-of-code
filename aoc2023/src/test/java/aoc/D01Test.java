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
    void calibrate() throws Exception {
        File df = new File(Objects.requireNonNull(this.getClass().getClassLoader().getResource("D01Test.txt")).toURI());
        List<String> cals = Files.readAllLines(df.toPath());
        MatcherAssert.assertThat(d.one(cals), is(142));
    }

    @Test
    void one() throws Exception {
        D01 d = new D01();
        File df = new File(this.getClass().getClassLoader().getResource("D01.txt").toURI());
        List<String> cals = Files.readAllLines(df.toPath());
        System.out.println(d.one(cals));

    }

    @Test
    void fineCalibrate() throws Exception {
        File df = new File(this.getClass().getClassLoader().getResource("D01Test2.txt").toURI());
        List<String> cals = Files.readAllLines( df.toPath());
        MatcherAssert.assertThat(d.two(cals), is(281));
    }

    @Test
    void two() throws Exception {
        D01 d = new D01();
        File df = new File(this.getClass().getClassLoader().getResource("D01.txt").toURI());
        List<String> cals = Files.readAllLines(df.toPath());
        System.out.println(d.two(cals));

    }
}