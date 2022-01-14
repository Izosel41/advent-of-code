import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.file.Files;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


class D09Test {

    D09 d;

    List<String> puzzleTest;
    List<String> puzzle;

    @BeforeEach
    void init() throws Exception {
        d = new D09();
        File testFile = new File(this.getClass().getClassLoader().getResource("D09Test.txt").toURI());
        puzzleTest = Files.readAllLines(testFile.toPath());
        File puzzleFile = new File(this.getClass().getClassLoader().getResource("D09.txt").toURI());
        puzzle = Files.readAllLines(puzzleFile.toPath());
    }

    @Test
    void oneTest() throws Exception {

        assertThat(d.one(puzzleTest), is(13));
    }

    @Test
    void one() throws Exception {
        System.out.println(d.one(puzzle));
    }

    @Test
    void twoTest() throws Exception {
//        assertThat(d.two(puzzleTest), is(1));
        File testFile = new File(this.getClass().getClassLoader().getResource("D09Test2.txt").toURI());
        List<String> puzzleTest2 = Files.readAllLines(testFile.toPath());
        assertThat(d.two(puzzleTest2), is(36));
    }

    @Test
    void two() throws Exception {
        System.out.println(d.two(puzzle));
    }
}
