class D05Test extends GroovyTestCase {

    D05 day = new D05()

    void testReact1() {
        assert "" == day.react("aA")
        assert "" == day.react("abBA")
        assert "abAB" == day.react("abAB")
        assert "aabAAB" == day.react("aabAAB")
    }

    void testReact2() {
        assert "dabCBAcaDA" == day.react("dabAaCBAcCcaDA")
    }

    void testFirst() {
        def input = Util.extractLines("5.txt")
        println day.react(input[0]).size()
    }

   void testFullReact() {
        assert 4 == day.fullReact("dabAaCBAcCcaDA")
    }

    void testSecond() {
        def input = Util.extractLines("5.txt")
        println day.fullReact(input[0])
    }

}