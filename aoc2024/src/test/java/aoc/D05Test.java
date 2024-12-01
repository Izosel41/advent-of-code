package aoc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.file.Files;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class D05Test {
    D05 d;
    List<String> puzzleTest;
    List<String> puzzle;

    @BeforeEach
    void init() throws Exception {
        d = new D05();
        File testFile = new File(this.getClass().getClassLoader().getResource("D05Test.txt").toURI());
        puzzleTest = Files.readAllLines(testFile.toPath());
        File puzzleFile = new File(this.getClass().getClassLoader().getResource("D05.txt").toURI());
        puzzle = Files.readAllLines(puzzleFile.toPath());
    }

    @Test
    void testSeedToSoil(){
        assertThat(d.seedToSoil("52 50 48", 0L),is(0L));

        assertThat(d.seedToSoil("52 50 48", 13L),is(13L));
        assertThat(d.seedToSoil("52 50 48", 14L),is(14L));

        assertThat(d.seedToSoil("52 50 48",48L),is(48L));
        assertThat(d.seedToSoil("52 50 48",49L),is(49L));
        assertThat(d.seedToSoil("52 50 48",50L),is(52L));
        assertThat(d.seedToSoil("52 50 48",51L),is(53L));
        assertThat(d.seedToSoil("52 50 48",52L),is(54L));
        assertThat(d.seedToSoil("52 50 48",55L),is(57L));

        assertThat(d.seedToSoil("52 50 48",79L),is(81L));

        assertThat(d.seedToSoil("52 50 48",96L),is(98L));
        assertThat(d.seedToSoil("52 50 48",97L),is(99L));
        assertThat(d.seedToSoil("50 98 2",98L),is(50L));
        assertThat(d.seedToSoil("50 98 2",99L),is(51L));

        assertThat(d.seedToSoil("50 98 2",100L),is(100L));

        assertThat(d.seedToSoil("0 262295201 34634737", 262295204L), is(3L));
        assertThat(d.seedToSoil("67314744 0 262295201", 3L), is(67314747L));
    }
    @Test
    void oneTest() throws Exception {
        assertThat(d.one(puzzleTest), is(35d));
    }

    @Test
    void one() throws Exception {
        System.out.println(d.one(puzzle));
    }

    @Test
    void twoTest() throws Exception {
        assertThat(d.two(puzzleTest), is(46L));
    }

    @Test
    void two() throws Exception {
        System.out.println(d.two(puzzle));
    }

}
