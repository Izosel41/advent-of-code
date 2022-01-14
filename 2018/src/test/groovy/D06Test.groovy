class D06Test extends GroovyTestCase {

    D06 day = new D06()

    void testFindSleepyHead1() {
        def input = Util.extractLines("6_1.txt")
        assert 17 == day.findLargestArea(input)
    }

}
