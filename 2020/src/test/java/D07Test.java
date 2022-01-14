import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.file.Files;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


class D07Test {

    @Test
    void testCountContainsShinyBag() throws Exception {
        D07 d = new D07();
        File f = new File(this.getClass().getClassLoader().getResource("D07_test.txt").toURI());
        List<String> rules = Files.readAllLines(f.toPath());
        assertThat(d.countContainsShinyBag(rules), is(4));
    }

    @Test
    void one() throws Exception {
        D07 d = new D07();
        File f = new File(this.getClass().getClassLoader().getResource("D07.txt").toURI());
        List<String> rules = Files.readAllLines(f.toPath());
        System.out.println(d.countContainsShinyBag(rules));
    }

    @Test
    void testCountInsideBags() throws Exception {
        D07 d = new D07();
        File f = new File(this.getClass().getClassLoader().getResource("D07_test.txt").toURI());
        List<String> rules = Files.readAllLines(f.toPath());
        assertThat(d.countBagsInsideShiny(rules), is(32));
    }

    @Test
    void testCountInsideBags2() throws Exception {
        D07 d = new D07();
        File f = new File(this.getClass().getClassLoader().getResource("D07_2_test.txt").toURI());
        List<String> rules = Files.readAllLines(f.toPath());
        assertThat(d.countBagsInsideShiny(rules), is(126));
    }

    @Test
    void two() throws Exception {
        D07 d = new D07();
        File f = new File(this.getClass().getClassLoader().getResource("D07.txt").toURI());
        List<String> rules = Files.readAllLines(f.toPath());
        System.out.println(d.countBagsInsideShiny(rules));
    }
}