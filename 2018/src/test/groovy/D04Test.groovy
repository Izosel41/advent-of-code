class D04Test extends GroovyTestCase {

    D04 day = new D04()

    void testFindSleepyHead1() {
        def input = Util.extractLines("4_1.txt")
        assert 240 == day.findSleepyHead1(input)
    }

    void testFirst() {
        def input = Util.extractLines("4.txt")
        println day.findSleepyHead1(input)
    }

    void testFindSleepyHead2() {
        def input = Util.extractLines("4_1.txt")
        assert 4455 == day.findSleepyHead2(input)
    }

    void testSecond() {
        def input = Util.extractLines("4.txt")
        println day.findSleepyHead2(input)
    }

}