class D03Test extends GroovyTestCase {
	
	D03 day = new D03()

    void testSpiralMemory() {
		assert day.spiralMemory(1) == 0
        println("-------------------")
		assert day.spiralMemory(9) == 2
        println("-------------------")
		assert day.spiralMemory(12) == 3
        println("-------------------")
		assert day.spiralMemory(23) == 2
        println("-------------------")
	}

	void testSpiralMemory2() {

		assert day.spiralMemory2(55) == 57
        assert day.spiralMemory2(100) == 122
        assert day.spiralMemory2(800) == 806
    }
	
	void testItem() {
		//475
		println("1=" + day.spiralMemory(277678))
        println("-------------------")
		//279138
		println("2=" + day.spiralMemory2(277678))
    }
}
