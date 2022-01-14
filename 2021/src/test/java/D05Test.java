import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


class D05Test {
    D05 d;
    private String tf = "D05Test.txt";
    private String f = "D05.txt";

    @BeforeEach
    void init() {
        d = new D05();
    }

    @Test
    void overlap() throws Exception {
        tf = "D05Test.txt";
        File df = new File(this.getClass().getClassLoader().getResource(tf).toURI());
        assertThat(d.overlap(df), is(5L));
    }

    @Test
    void one() throws Exception {
        File df = new File(this.getClass().getClassLoader().getResource(f).toURI());
        System.out.println(d.overlap(df));
    }

    @Test
    void diagOverlap() throws Exception {
        tf = "D05Test.txt";
        File df = new File(this.getClass().getClassLoader().getResource(tf).toURI());
        assertThat(d.diagOverlap(df), is(12L));
    }

    @Test
    void two() throws Exception {
        File df = new File(this.getClass().getClassLoader().getResource(f).toURI());
        System.out.println(d.diagOverlap(df));
    }
}