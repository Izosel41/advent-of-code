class D07Test extends GroovyTestCase {

    D07 day = new D07()

    void testBuildInst() {
        def input = Util.extractLines("7_1.txt")
        assert "CABDFE" == day.buildInst(input)
    }

    void testFirst() {
        def input = Util.extractLines("7.txt")
        println day.buildInst(input)
    }

    void testExecute() {
        def input = Util.extractLines("7_1.txt")
        assert 15 == day.execute(input, 2, 0)
    }

    void testSecond() {
        def input = Util.extractLines("7.txt")
        println day.execute(input, 5, 60)
    }

}
