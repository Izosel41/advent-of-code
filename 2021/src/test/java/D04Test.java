import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


class D04Test {
    D04 d;

    @BeforeEach
    void init() {
        d = new D04();
    }

    @Test
    void bingo() throws Exception {
        File df = new File(this.getClass().getClassLoader().getResource("D04Test.txt").toURI());
        List<Integer[][]> cards = d.initBingo(df);
        assertThat(d.bingo(cards), is(4512));
    }

    @Test
    void one() throws Exception {
        File df = new File(this.getClass().getClassLoader().getResource("D04.txt").toURI());
        List<Integer[][]> cards = d.initBingo(df);
        System.out.println(d.bingo(cards));
    }

    @Test
    void lastBingo() throws Exception {
        File df = new File(this.getClass().getClassLoader().getResource("D04Test.txt").toURI());
        List<Integer[][]> cards = d.initBingo(df);
        assertThat(d.lastBingo(cards), is(1924));
    }

    @Test
    void two() throws Exception {
        File df = new File(this.getClass().getClassLoader().getResource("D04.txt").toURI());
        List<Integer[][]> cards = d.initBingo(df);

        System.out.println(d.lastBingo(cards));
    }
}