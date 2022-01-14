class D01Test extends GroovyTestCase {

	D01 day = new D01()

	void testFirst(){
		def input = Util.extractLines("1.txt")
		println day.calibrate(input)
	}

	void testCcalibrateUntil(){
		assert 2 == day.calibrateUntil(["+1", "-2", "+3", "+1"])
	}

	void testSecond() {
		def input = Util.extractLines("1.txt")
		println("response is " + day.calibrateUntil(input))
	}
}