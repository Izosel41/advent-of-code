class D08Test extends GroovyTestCase {

    D08 day = new D08()

    void testSumMeta() {
        def input = Util.extractLines("8_1.txt")
        assert 138 == day.sumMeta(input[0])
    }

    void testFirst() {
        def input = Util.extractLines("8.txt")
        println day.sumMeta(input[0])
    }

    void testSumValue() {
        def input = Util.extractLines("8_1.txt")
        assert 66 == day.rootValue(input[0])
    }

    void testSecond() {
        def input = Util.extractLines("8.txt")
        println day.rootValue(input[0])
    }

}
