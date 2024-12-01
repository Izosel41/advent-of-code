package aoc;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class D20Test {

    @Test
    void testArrange() throws Exception {
        D20 d = new D20();
        File f = new File(this.getClass().getClassLoader().getResource("D20_test.txt").toURI());
        List<String> input = Files.readAllLines(f.toPath());

        MatcherAssert.assertThat(d.arrangeTiles(input),is(20899048083289L));
    }

    @Test
    void one() throws Exception {
        D10 d = new D10();
        File f = new File(this.getClass().getClassLoader().getResource("D10.txt").toURI());
        List<Integer> input = Files.readAllLines(f.toPath()).stream().map(Integer::valueOf).collect(Collectors.toList());
        System.out.println(d.jolt(input));
    }

    @Test
    void findContiguous() throws Exception {
        D09 d = new D09();
        File f = new File(this.getClass().getClassLoader().getResource("D09_test.txt").toURI());
        List<String> rules = Files.readAllLines(f.toPath());
        Long[] input = Files.readAllLines(f.toPath()).stream().map(Long::valueOf).toArray(Long[]::new);

        MatcherAssert.assertThat(d.findContiguous(input,5),is(62L));
    }

    @Test
    void two() throws Exception {
        D09 d = new D09();
        File f = new File(this.getClass().getClassLoader().getResource("D09.txt").toURI());
        Long[] input = Files.readAllLines(f.toPath()).stream().map(Long::valueOf).toArray(Long[]::new);
        System.out.println(d.findContiguous(input,25));
    }
}