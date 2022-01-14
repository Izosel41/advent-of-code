import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


class D08Test {
    D08 d;
    private String tf = "D08Test.txt";
    private String f = "D08.txt";

    @BeforeEach
    void init() {
        d = new D08();
    }

    @Test
    void signal() throws Exception {
        assertThat(d.signal(tf), is(26L));
    }

    @Test
    void one() throws Exception {
        System.out.println(d.signal(f));
    }

//    @Test
//    void fuel2() throws Exception {
//        assertThat(d.fuel2(tf), is(168));
//    }
//
//    @Test
//    void two() throws Exception {
//        System.out.println(d.fuel2(f));
//    }
}