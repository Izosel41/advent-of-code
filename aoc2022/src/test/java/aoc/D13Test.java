package aoc;

import org.json.JSONArray;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.file.Files;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


class D13Test {

    D13 d;

    List<String> puzzleTest;
    List<String> puzzle;

    @BeforeEach
    void init() throws Exception {
        d = new D13();
        File testFile = new File(this.getClass().getClassLoader().getResource("D13Test.txt").toURI());
        puzzleTest = Files.readAllLines(testFile.toPath());
        File puzzleFile = new File(this.getClass().getClassLoader().getResource("D13.txt").toURI());
        puzzle = Files.readAllLines(puzzleFile.toPath());
    }

    @Test
    void oneTest() throws Exception {
        assertThat(d.one(puzzleTest), is(13));
    }

    @Test
    void isRightOrder() {
        assertThat(d.isRightOrder(new JSONArray("[1]"), new JSONArray("[2]"), false, false), is(1));
        assertThat(d.isRightOrder(new JSONArray("[1]"), new JSONArray("[1]"), false, false), is(1));
        assertThat(d.isRightOrder(new JSONArray("[2]"), new JSONArray("[1]"), false, false), is(-1));

        assertThat(d.isRightOrder(new JSONArray("[[1]]"), new JSONArray("[2]"), false, false), is(1));
        assertThat(d.isRightOrder(new JSONArray("[[1]]"), new JSONArray("[1]"), false, false), is(1));
        assertThat(d.isRightOrder(new JSONArray("[[2]]"), new JSONArray("[1]"), false, false), is(-1));

        assertThat(d.isRightOrder(new JSONArray("[1]"), new JSONArray("[[2]]"), false, false), is(1));
        assertThat(d.isRightOrder(new JSONArray("[1]"), new JSONArray("[[1]]"), false, false), is(1));
        assertThat(d.isRightOrder(new JSONArray("[2]"), new JSONArray("[[1]]"), false, false), is(-1));

        assertThat(d.isRightOrder(new JSONArray("[[]]"), new JSONArray("[1]"), false, false), is(1));
        assertThat(d.isRightOrder(new JSONArray("[[]]"), new JSONArray("[]"), false, false), is(-1));
        assertThat(d.isRightOrder(new JSONArray("[[1]]"), new JSONArray("[]"), false, false), is(-1));

        assertThat(d.isRightOrder(new JSONArray("[[1,1]]"), new JSONArray("[1,2]"), false, false), is(-1));
        assertThat(d.isRightOrder(new JSONArray("[[1,2]]"), new JSONArray("[1,2]"), false, false), is(-1));
        assertThat(d.isRightOrder(new JSONArray("[[2,1]]"), new JSONArray("[1,1]"), false, false), is(-1));

        assertThat(d.isRightOrder(new JSONArray("[1,[1]]"), new JSONArray("[1,[2]]"), false, false), is(1));
        assertThat(d.isRightOrder(new JSONArray("[1,[2]]"), new JSONArray("[1,[2]]"), false, false), is(1));
        assertThat(d.isRightOrder(new JSONArray("[2,[1]]"), new JSONArray("[1,[1]]"), false, false), is(-1));

        assertThat(d.isRightOrder(new JSONArray("[1,[1,2]]"), new JSONArray("[1,1,2]"), false, false), is(-1));
        assertThat(d.isRightOrder(new JSONArray("[1,[2]]"), new JSONArray("[1,[2]]"), false, false), is(1));
        assertThat(d.isRightOrder(new JSONArray("[2,[1]]"), new JSONArray("[1,[1]]"), false, false), is(-1));

        assertThat(d.isRightOrder(new JSONArray("[[],[1,2],1]"), new JSONArray("[1,[1,2],3]"), false, false), is(1));
        assertThat(d.isRightOrder(new JSONArray("[[0,0,0]]"), new JSONArray("[2]"), false, false), is(1));
        assertThat(d.isRightOrder(new JSONArray("[2,[1]]"), new JSONArray("[1,[1]]"), false, false), is(-1));

        assertThat(d.isRightOrder(new JSONArray("[[1,2,3]]"), new JSONArray("[[1,2]]"), false, false), is(-1));
        assertThat(d.isRightOrder(new JSONArray("[[1,2]]"), new JSONArray("[[1,2,3]]"), false, false), is(1));

        assertThat(d.isRightOrder(new JSONArray("[[1,2,3],1]"), new JSONArray("[[1,2,3],2]"), false, false), is(1));
        assertThat(d.isRightOrder(new JSONArray("[[1,2,3],3]"), new JSONArray("[[1,2,3],2]"), false, false), is(-1));
    }

    @Test
    void one() throws Exception {
        System.out.println(d.one(puzzle));
    }

    @Test
    void twoTest() throws Exception {
        assertThat(d.two(puzzleTest), is(140));
    }

    @Test
    void two() throws Exception {
        System.out.println(d.two(puzzle));
    }

}
