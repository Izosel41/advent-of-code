package aoc;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


class D03Test {

    D03 d;
    private File test;
    private File puzzle;

    @BeforeEach
    void init() throws URISyntaxException {
        d = new D03();
        test = new File(this.getClass().getClassLoader().getResource("D03Test.txt").toURI());
        puzzle = new File(this.getClass().getClassLoader().getResource("D03.txt").toURI());
    }

    @Test
    void rucksack() throws Exception {
        List<String> cals = Files.readAllLines(test.toPath());
        MatcherAssert.assertThat(d.rucksack(cals), is(157));
    }

    @Test
    void one() throws Exception {
        List<String> cals = Files.readAllLines(puzzle.toPath());
        System.out.println(d.rucksack(cals));

    }

    @Test
    void byThree() throws Exception {
        List<String> cals = Files.readAllLines(test.toPath());
        MatcherAssert.assertThat(d.byThree(cals), is(70));
    }

    @Test
    void two() throws Exception {
        List<String> cals = Files.readAllLines(puzzle.toPath());
        System.out.println(d.byThree(cals));

    }
}
