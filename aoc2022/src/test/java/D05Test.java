import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


class D05Test {

    D05 d;
    private File test;
    private File puzzle;

    @BeforeEach
    void init() throws URISyntaxException {
        d = new D05();
        test = new File(this.getClass().getClassLoader().getResource("D05Test.txt").toURI());
        puzzle = new File(this.getClass().getClassLoader().getResource("D05.txt").toURI());
    }

    @Test
    void move() throws Exception {
        List<String> puzzles = Files.readAllLines(test.toPath());
        assertThat(d.move(puzzles), is("CMZ"));
    }

    @Test
    void one() throws Exception {
        List<String> puzzles = Files.readAllLines(puzzle.toPath());
        System.out.println(d.move(puzzles));

    }

    @Test
    void move1() throws Exception {
        List<String> puzzles = Files.readAllLines(test.toPath());
        assertThat(d.move1(puzzles), is("MCD"));
    }

    @Test
    void two() throws Exception {
        List<String> puzzles = Files.readAllLines(puzzle.toPath());
        System.out.println(d.move1(puzzles));

    }
}
