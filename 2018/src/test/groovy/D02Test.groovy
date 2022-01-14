class D02Test extends GroovyTestCase {

    D02 day = new D02()

    void testCount() {
        assert [2:0, 3:0] == day.count("abcdef")
        assert [2:2, 3:3] == day.count("bababc")
        assert [2:2, 3:0] == day.count("abbcde")
        assert [2:0, 3:3] == day.count("abcccd")
        assert [2:2, 3:0] == day.count("aabcdd")
        assert [2:2, 3:0] == day.count("abcdee")
        assert [2:0, 3:3] == day.count("ababab")
    }

    void testChecksum() {
        assert 12 == day.checksum(["abcdef", "bababc", "abbcde", "abcccd", "aabcdd", "abcdee", "ababab"])
    }

    void testFirst() {
        def input = Util.extractLines("2.txt")
        println day.checksum(input)
    }

    void testFindCommon() {
        assert "fgij" == day.findCommon(["abcde", "fghij", "klmno", "pqrst", "fguij", "axcye", "wvxyz"])
    }

    void testSecond() {
        def input = Util.extractLines("2.txt")
        println day.findCommon(input)
    }
}