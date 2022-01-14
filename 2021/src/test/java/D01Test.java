import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


class D01Test {

    @Test
    void countIncreased() throws Exception {
        D01 d = new D01();
        File df = new File(this.getClass().getClassLoader().getResource("D01Test.txt").toURI());
        int[] depths = Files.readAllLines(df.toPath()).stream().mapToInt(num -> Integer.parseInt(num)).toArray();
        assertThat(d.countIncreased(depths), is(7));
    }

    @Test
    void one() throws Exception {
        D01 d = new D01();
        File df = new File(this.getClass().getClassLoader().getResource("D01.txt").toURI());
        int[] depths = Files.readAllLines(df.toPath()).stream().mapToInt(num -> Integer.parseInt(num)).toArray();
        System.out.println(d.countIncreased(depths));

    }

    @Test
    void countSliding() throws Exception {
        D01 d = new D01();
        File df = new File(this.getClass().getClassLoader().getResource("D01Test.txt").toURI());
        int[] depths = Files.readAllLines(df.toPath()).stream().mapToInt(num -> Integer.parseInt(num)).toArray();
        assertThat(d.countSliding(depths), is(5));
    }

    @Test
    void two() throws Exception {
        D01 d = new D01();
        File df = new File(this.getClass().getClassLoader().getResource("D01.txt").toURI());
        int[] depths = Files.readAllLines(df.toPath()).stream().mapToInt(num -> Integer.parseInt(num)).toArray();
        System.out.println(d.countSliding(depths));
    }
}