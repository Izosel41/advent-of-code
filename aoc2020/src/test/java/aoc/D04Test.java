package aoc;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


class D04Test {
    @Test
    void testValidateOnePassport(){
        D04 d = new D04();
        MatcherAssert.assertThat(d.validatePassport("ecl:gry pid:860033327 eyr:2020 hcl:#fffffd byr:1937 iyr:2017 cid:147 hgt:183cm"),is(true));

    }

    @Test
    void testScanPassport() throws Exception {
        D04 d = new D04();
        File f = new File(this.getClass().getClassLoader().getResource("D04_test.txt").toURI());

        MatcherAssert.assertThat(d.scanPassport(f), is(2));
    }

    @Test
    void one() throws Exception {
        D04 d = new D04();
        File f = new File(this.getClass().getClassLoader().getResource("D04.txt").toURI());

        System.out.println(d.scanPassport(f));
    }

    @Test
    void testInvalidPassport() throws Exception {
        D04 d = new D04();
        File f = new File(this.getClass().getClassLoader().getResource("D04_invalid.txt").toURI());

        MatcherAssert.assertThat(d.scanPassport(f), is(0));
    }

    @Test
    void testValidPassport() throws Exception {
        D04 d = new D04();
        File f = new File(this.getClass().getClassLoader().getResource("D04_valid.txt").toURI());

        MatcherAssert.assertThat(d.scanPassport(f), is(4));
    }

    @Test
    void two() throws Exception {
        D04 d = new D04();
        File f = new File(this.getClass().getClassLoader().getResource("D04.txt").toURI());

        System.out.println(d.scanPassport(f));
    }
}