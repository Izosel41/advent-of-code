package aoc;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.file.Files;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class D09Test {

    @Test
    void findWeakness() throws Exception {
        D09 d = new D09();
        File f = new File(this.getClass().getClassLoader().getResource("D09_test.txt").toURI());
        Long[] input = Files.readAllLines(f.toPath()).stream().map(Long::valueOf).toArray(Long[]::new);

        MatcherAssert.assertThat(d.findWeakness(input,5),is(127L));
    }

    @Test
    void one() throws Exception {
        D09 d = new D09();
        File f = new File(this.getClass().getClassLoader().getResource("D09.txt").toURI());
        Long[] input = Files.readAllLines(f.toPath()).stream().map(Long::valueOf).toArray(Long[]::new);
        System.out.println(d.findWeakness(input,25));
    }

    @Test
    void findContiguous() throws Exception {
        D09 d = new D09();
        File f = new File(this.getClass().getClassLoader().getResource("D09_test.txt").toURI());
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