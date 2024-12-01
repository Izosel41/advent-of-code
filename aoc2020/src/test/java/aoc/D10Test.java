package aoc;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class D10Test {

    @Test
    void testJolt() throws Exception {
        D10 d = new D10();
        File f = new File(this.getClass().getClassLoader().getResource("D10_test.txt").toURI());
        List<Integer> input = Files.readAllLines(f.toPath()).stream().map(Integer::valueOf).collect(Collectors.toList());

        MatcherAssert.assertThat(d.jolt(input),is(35));
    }

    @Test
    void one() throws Exception {
        D10 d = new D10();
        File f = new File(this.getClass().getClassLoader().getResource("D10.txt").toURI());
        List<Integer> input = Files.readAllLines(f.toPath()).stream().map(Integer::valueOf).collect(Collectors.toList());
        System.out.println(d.jolt(input));
    }

    @Test
    void two() throws Exception {
        D10 d = new D10();
        File f = new File(this.getClass().getClassLoader().getResource("D10.txt").toURI());
        List<Integer> input = Files.readAllLines(f.toPath()).stream().map(Integer::valueOf).collect(Collectors.toList());
        System.out.println(d.jolt(input));
    }
}