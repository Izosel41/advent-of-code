package aoc;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.file.Files;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class D11Test {

    @Test
    void testCountOccupied() throws Exception {
        D11 d = new D11();
        File f = new File(this.getClass().getClassLoader().getResource("D11_test.txt").toURI());
        List<String> input = Files.readAllLines(f.toPath());

        MatcherAssert.assertThat(d.countOccupied(input),is(37));
    }

    @Test
    void one() throws Exception {
        D11 d = new D11();
        File f = new File(this.getClass().getClassLoader().getResource("D11.txt").toURI());
        List<String> input = Files.readAllLines(f.toPath());
        System.out.println(d.countOccupied(input));
    }

    @Test
    void testCountOccupied2() throws Exception {
        D11 d = new D11();
        File f = new File(this.getClass().getClassLoader().getResource("D11_test.txt").toURI());
        List<String> input = Files.readAllLines(f.toPath());

        MatcherAssert.assertThat(d.countOccupied2(input),is(26));
    }

    @Test
    void two() throws Exception {
        D11 d = new D11();
        File f = new File(this.getClass().getClassLoader().getResource("D11.txt").toURI());
        List<String> input = Files.readAllLines(f.toPath());

        System.out.println(d.countOccupied2(input));
    }
}