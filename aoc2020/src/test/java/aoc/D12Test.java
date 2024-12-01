package aoc;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.file.Files;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class D12Test {

    @Test
    void testNavigate() throws Exception {
        D12 d = new D12();
        File f = new File(this.getClass().getClassLoader().getResource("D12_test.txt").toURI());
        List<String> input = Files.readAllLines(f.toPath());

        MatcherAssert.assertThat(d.navigate(input),is(25));
    }

    @Test
    void one() throws Exception {
        D12 d = new D12();
        File f = new File(this.getClass().getClassLoader().getResource("D12.txt").toURI());
        List<String> input = Files.readAllLines(f.toPath());
        System.out.println(d.navigate(input));
    }

    @Test
    void testRelativeNavigate() throws Exception {
        D12 d = new D12();
        File f = new File(this.getClass().getClassLoader().getResource("D12_test.txt").toURI());
        List<String> input = Files.readAllLines(f.toPath());

        MatcherAssert.assertThat(d.navigateRelative(input),is(286));
    }

    @Test
    void two() throws Exception {
        D12 d = new D12();
        File f = new File(this.getClass().getClassLoader().getResource("D12.txt").toURI());
        List<String> input = Files.readAllLines(f.toPath());
        System.out.println(d.navigateRelative(input));
    }
}