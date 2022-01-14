class D11Test extends GroovyTestCase {

    D11 day = new D11()

    void testStepAway1() {
        assert 3 == day.stepAway("ne,ne,ne")
    }
    void testStepAway2() {
        assert 0 == day.stepAway("ne,ne,sw,sw")
    }
    void testStepAway3() {
        assert 2 == day.stepAway("ne,ne,s,s")
    }
    void testStepAway4() {
        assert 3 == day.stepAway("se,sw,se,sw,sw")
    }

   void testDay111() {
       println day.stepAway(Util.extractLines("D11_1.txt"))
   }

    void testDay112() {
        println "Day 11.2 " + day.stepAway(Util.extractLines("D11_1.txt"))
    }
}
