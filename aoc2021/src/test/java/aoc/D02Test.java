package aoc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.file.Files;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


class D02Test {
    D02 d;

    @BeforeEach
    void init(){
        d = new D02();
    }

    @Test
    void pilot() throws Exception {
        File df = new File(this.getClass().getClassLoader().getResource("D02Test.txt").toURI());
        List<String> depths = Files.readAllLines(df.toPath());
        int[] pos = d.pilot(depths);
        assertThat(pos[0] * pos[1], is(150));
    }

    @Test
    void one() throws Exception {
        File df = new File(this.getClass().getClassLoader().getResource("D02.txt").toURI());
        List<String> depths = Files.readAllLines(df.toPath());
        int[] pos = d.pilot(depths);
        System.out.println(pos[0] * pos[1]);
    }

    @Test
    void pilotAim() throws Exception {
        File df = new File(this.getClass().getClassLoader().getResource("D02Test.txt").toURI());
        List<String> depths = Files.readAllLines(df.toPath());
        int[] pos = d.pilotAim(depths);
        assertThat(pos[0] * pos[1], is(900));
    }

    @Test
    void two() throws Exception {
        File df = new File(this.getClass().getClassLoader().getResource("D02.txt").toURI());
        List<String> depths = Files.readAllLines(df.toPath());
        int[] pos = d.pilotAim(depths);
        System.out.println(pos[0] * pos[1]);
    }
}