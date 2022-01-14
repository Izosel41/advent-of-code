class D03Test extends GroovyTestCase {

    D03 day = new D03()

    void testCount() {
        assert 4 == day.count(["#1 @ 1,3: 4x4", "#2 @ 3,1: 4x4", "#3 @ 5,5: 2x2"])
    }

    void testFirst() {
        def input = Util.extractLines("3.txt")
        println day.count(input)
    }

    void testFindLoneClaim(){
        assert "#3" == day.findLoneClaim(["#1 @ 1,3: 4x4", "#2 @ 3,1: 4x4", "#3 @ 5,5: 2x2"])
    }

    void testSecond() {
        def input = Util.extractLines("3.txt")
        println day.findLoneClaim(input)
    }
}