import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


class D04Test {

    D04 d;
    private File test;
    private File puzzle;

    @BeforeEach
    void init() throws URISyntaxException {
        d = new D04();
        test = new File(this.getClass().getClassLoader().getResource("D04Test.txt").toURI());
        puzzle = new File(this.getClass().getClassLoader().getResource("D04.txt").toURI());
    }

    @Test
    void contains() throws Exception {
        List<String> cals = Files.readAllLines(test.toPath());
        assertThat(d.contains(cals), is(2));
    }

    @Test
    void one() throws Exception {
        List<String> cals = Files.readAllLines(puzzle.toPath());
        System.out.println(d.contains(cals));

    }

    @Test
    void overlap() throws Exception {
        List<String> cals = Files.readAllLines(test.toPath());
        assertThat(d.overlap(cals), is(4));
    }

    @Test
    void two() throws Exception {
        List<String> cals = Files.readAllLines(puzzle.toPath());
        System.out.println(d.overlap(cals));

    }
}
