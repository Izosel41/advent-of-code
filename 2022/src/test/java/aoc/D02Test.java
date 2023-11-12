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


class D02Test {

    D02 d;
    private File test;
    private File puzzle;

    @BeforeEach
    void init() throws URISyntaxException {
        d = new D02();
        test = new File(this.getClass().getClassLoader().getResource("D02Test.txt").toURI());
        puzzle = new File(this.getClass().getClassLoader().getResource("D02.txt").toURI());
    }

    @Test
    void run() throws Exception {
        List<String> cals = Files.readAllLines(test.toPath());
        MatcherAssert.assertThat(d.run(cals), is(15));
    }

    @Test
    void one() throws Exception {
        List<String> cals = Files.readAllLines(puzzle.toPath());
        System.out.println(d.run(cals));

    }

    @Test
    void runStrategy() throws Exception {
        List<String> cals = Files.readAllLines(test.toPath());
        MatcherAssert.assertThat(d.runStrategy(cals), is(12));
    }

    @Test
    void two() throws Exception {
        List<String> cals = Files.readAllLines(puzzle.toPath());
        System.out.println(d.runStrategy(cals));

    }
}
