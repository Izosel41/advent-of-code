class D07Test extends GroovyTestCase {

    D07 day = new D07()

    void testFindRoot() {
        def lines = Util.extractLines("D07_1Test.txt")
        assert 'tknk' == day.findRoot(lines).name
    }

    void testDay071() {
        def lines = Util.extractLines("D07.txt")
       println "Day 07 1 -> " + day.findRoot(lines).name
    }

    void testFindBalancedWeight(){
        def lines = Util.extractLines("D07_1Test.txt")
        def root = day.findRoot(lines)
        //assert 60
        day.findBalancedWeight(root).weight
    }

    void testDay072() {
        def lines = Util.extractLines("D07.txt")
        def root = day.findRoot(lines)
        println "Day 07 2 -> " + day.findBalancedWeight(root).weight
    }
}
