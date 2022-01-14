class D12Test extends GroovyTestCase {

    D12 day = new D12()

    void testProgramConnected(){
        def pipes = Util.extractLines("/D12_1.txt")
        def registry = day.buildRegistry(pipes)
        assert 6 == day.programConnectedTo("0", registry).size
        assert day.programConnectedTo("0", registry).contains(0)
        assert day.programConnectedTo("0", registry).contains(2)
        assert day.programConnectedTo("0", registry).contains(3)
        assert day.programConnectedTo("0", registry).contains(4)
        assert day.programConnectedTo("0", registry).contains(5)
        assert day.programConnectedTo("0", registry).contains(6)

        assert false == day.programConnectedTo("0").contains(1)
    }

   void testDay121() {
       println day.stepAway(Util.extractLines("/D11_1.txt"))
   }

    void testDay122() {
        //println "Day 10.2 " + day.knotHash("192,69,168,160,78,1,166,28,0,83,198,2,254,255,41,12")
    }
}
