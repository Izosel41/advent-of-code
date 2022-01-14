import org.junit.jupiter.api.Test;

import javax.servlet.jsp.tagext.TagVariableInfo;
import java.io.File;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


class D05Test {

    @Test
    void testFindSeat() throws Exception {
        D05 d = new D05();
        assertThat(d.findSeat("FBFBBFFRLR"), is(357));
        assertThat(d.findSeat("BFFFBBFRRR"), is(567));
        assertThat(d.findSeat("FFFBBBFRRR"), is(119));
        assertThat(d.findSeat("BBFFBBFRLL"), is(820));
    }

    @Test
    void one() throws Exception {
        D05 d = new D05();
        File f = new File(this.getClass().getClassLoader().getResource("D05.txt").toURI());
        List<String> seats = Files.readAllLines(f.toPath());
        System.out.println(seats.stream().map(s -> d.findSeat(s)).max(Integer::compareTo).get());
    }

    @Test
    void two() throws Exception {
        D05 d = new D05();
        File f = new File(this.getClass().getClassLoader().getResource("D05.txt").toURI());
        List<String> seats = Files.readAllLines(f.toPath());
        // as we have to look taken seats not at front or back
        Set<Integer> taken = seats.stream().map(s -> d.findSeat(s)).filter(id -> id > 49 && id < 758).collect(Collectors.toSet());
        Set<Integer> available = IntStream.range(8, 800)
                .boxed()
                .collect(Collectors.toSet());

        available.removeAll(taken);
        System.out.println(available.toArray()[0]);
    }

}