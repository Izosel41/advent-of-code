class D01Test extends GroovyTestCase {

	D01 day = new D01()

	void testFuel(){
		assert 2 == day.fuel(["12"])
		assert 2 == day.fuel(["14"])
		assert 654 == day.fuel(["1969"])
		assert 33583 == day.fuel(["100756"])
	}

	void testFirst(){
		def input = Util.extractLines("1.txt")
		println day.fuel(input)
	}

	void testExtraFuel(){
		assert 2 == day.calculateExtrafuel(14)
		assert 966 == day.calculateExtrafuel(1969)
		assert 50346 == day.calculateExtrafuel(100756)
	}

	void testSecond() {
		def input = Util.extractLines("1.txt")
		println input*.toInteger().inject(0) { total, arg ->
			def fuelForMass = day.calcFuel(arg)
			def fuelForFuel = day.calculateExtrafuel(fuelForMass)
			total +=  (fuelForMass + fuelForFuel) }
	}
}