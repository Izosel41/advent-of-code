class D08Test extends GroovyTestCase {

    D08 day = new D08()

    void testInstruct() {
        def lines = Util.extractLines("D08_1Test.txt")
        lines.forEach{day.instruct(it)}
        assert( 1 == day.registry.max {it.value}.value)
    }

    void testDay081() {
        def lines = Util.extractLines("D08.txt")
        lines.forEach{day.instruct(it)}
        println "Day 08 1 -> " + day.registry.max {it.value}.value
    }

    void testMax() {
        def lines = Util.extractLines("D08_1Test.txt")
        lines.forEach{day.instruct(it)}
        assert( 10 == day.maximum)
    }

    void testDay082() {
        def lines = Util.extractLines("D08.txt")
        lines.forEach{day.instruct(it)}
        println "Day 08 1 -> " + day.maximum
    }
}
