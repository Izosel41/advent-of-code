import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.file.Files;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


class D01Test {

    D01 d;
    @BeforeEach
    void init() {
        d = new D01();
    }

    @Test
    void mostCalories() throws Exception {
        File df = new File(this.getClass().getClassLoader().getResource("D01Test.txt").toURI());
        List<String> cals = Files.readAllLines(df.toPath());
        assertThat(d.mostCalories(cals), is(24000));
    }

    @Test
    void one() throws Exception {
        D01 d = new D01();
        File df = new File(this.getClass().getClassLoader().getResource("D01.txt").toURI());
        List<String> cals = Files.readAllLines(df.toPath());
        System.out.println(d.mostCalories(cals));

    }

    @Test
    void threeMostCalories() throws Exception {
        File df = new File(this.getClass().getClassLoader().getResource("D01Test.txt").toURI());
        List<String> cals = Files.readAllLines(df.toPath());
        assertThat(d.threeMostCalories(cals), is(45000));
    }

    @Test
    void two() throws Exception {
        D01 d = new D01();
        File df = new File(this.getClass().getClassLoader().getResource("D01.txt").toURI());
        List<String> cals = Files.readAllLines(df.toPath());
        System.out.println(d.threeMostCalories(cals));

    }
}