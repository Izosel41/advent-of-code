import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.function.IntFunction;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


class D01Test {

    @Test
    void findTwo() {
        D01 d = new D01();
        Integer[] expenses = {1721,
                979,
                366,
                299,
                675,
                1456};

        assertThat(d.findTwo(expenses), is(514579));
    }

    @Test
    void one() throws Exception {
        D01 d = new D01();
        File df = new File(this.getClass().getClassLoader().getResource("D01.txt").toURI());
        List<Integer> expenses = Files.readAllLines(df.toPath()).stream().map(Integer::valueOf).collect(Collectors.toCollection(ArrayList::new));

        System.out.println(d.findTwo(expenses.toArray(new Integer[0])));

    }

    @Test
    void findThree() {
        D01 d = new D01();
        Integer[] expenses = {1721,
                979,
                366,
                299,
                675,
                1456};

        assertThat(d.findThree(expenses), is(241861950));
    }

    @Test
    void two() throws Exception {
        D01 d = new D01();
        File df = new File(this.getClass().getClassLoader().getResource("D01.txt").toURI());
        List<Integer> expenses = Files.readAllLines(df.toPath()).stream().map(Integer::valueOf).collect(Collectors.toCollection(ArrayList::new));

        System.out.println(d.findThree(expenses.toArray(new Integer[0])));

    }

}