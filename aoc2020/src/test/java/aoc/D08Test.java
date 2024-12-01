package aoc;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.file.Files;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class D08Test {

    @Test
    void getAccumulatorAtSecondLoop() throws Exception {
        D08 d = new D08();
        File f = new File(this.getClass().getClassLoader().getResource("D08_test.txt").toURI());
        List<String> rules = Files.readAllLines(f.toPath());
        MatcherAssert.assertThat(d.getAccumulatorAtSecondLoop(rules),is(5));
    }

    @Test
    void one() throws Exception {
        D08 d = new D08();
        File f = new File(this.getClass().getClassLoader().getResource("D08.txt").toURI());
        List<String> rules = Files.readAllLines(f.toPath());
        System.out.println(d.getAccumulatorAtSecondLoop(rules));
    }

    @Test
    void getAccumulatorByChangeInstr() throws Exception {
        D08 d = new D08();
        File f = new File(this.getClass().getClassLoader().getResource("D08_test.txt").toURI());
        List<String> rules = Files.readAllLines(f.toPath());
        MatcherAssert.assertThat(d.getAccumulatorByChangeInstr(rules),is(8));
    }

    @Test
    void two() throws Exception {
        D08 d = new D08();
        File f = new File(this.getClass().getClassLoader().getResource("D08.txt").toURI());
        List<String> rules = Files.readAllLines(f.toPath());
        System.out.println(d.getAccumulatorByChangeInstr(rules));
    }
}