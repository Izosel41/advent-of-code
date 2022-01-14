import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


class D02Test {

    @Test
    void validateSled() {
        D02 d = new D02();

        assertThat(d.validateSled("1-3 a: abcde"), is(true));
    }

    @Test
    void countValidatedSled() {
        D02 d = new D02();
        List<String> input = Arrays.asList("1-3 a: abcde", "1-3 b: cdefg", "2-9 c: ccccccccc");

        assertThat(input.stream().filter(a -> d.validateSled(a)).count(), is(2L));
    }

    @Test
    void one() throws Exception {
        D02 d = new D02();
        File df = new File(this.getClass().getClassLoader().getResource("D02.txt").toURI());
        List<String> input = Files.readAllLines(df.toPath());

        System.out.println(input.stream().filter(a -> d.validateSled(a)).count());

    }

    @Test
    void validate() {
        D02 d = new D02();

        assertThat(d.validateToboggan("1-3 a: abcde"), is(true));
    }

    @Test
    void countValidated() {
        D02 d = new D02();
        List<String> input = Arrays.asList("1-3 a: abcde", "1-3 b: cdefg", "2-9 c: ccccccccc");

        assertThat(input.stream().filter(a -> d.validateToboggan(a)).count(), is(1L));
    }

    @Test
    void two() throws Exception {
        D02 d = new D02();
        File df = new File(this.getClass().getClassLoader().getResource("D02.txt").toURI());
        List<String> input = Files.readAllLines(df.toPath());

        System.out.println(input.stream().filter(a -> d.validateToboggan(a)).count());

    }
}