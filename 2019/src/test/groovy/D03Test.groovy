class D03Test extends GroovyTestCase {

	D03 day = new D03()

	void testCrossing(){
		assert 6 == day.crossing("R8,U5,L5,D3", "U7,R6,D4,L4")
		assert 159 == day.crossing("R75,D30,R83,U83,L12,D49,R71,U7,L72", "U62,R66,U55,R34,D71,R55,D58,R83")
		assert 135 == day.crossing("R98,U47,R26,D63,R33,U87,L62,D20,R33,U53,R51", "U98,R91,D20,R16,D67,R40,U7,R15,U6,R7")
	}

	void testFirst(){
		def wires = Util.extractLines("3.txt")
		println day.crossing(wires.get(0), wires.get(1))
	}

	void testFastestCrossing(){
		assert 30 == day.fastestCrossing("R8,U5,L5,D3", "U7,R6,D4,L4")
		assert 610 == day.fastestCrossing("R75,D30,R83,U83,L12,D49,R71,U7,L72", "U62,R66,U55,R34,D71,R55,D58,R83")
		assert 410 == day.fastestCrossing("R98,U47,R26,D63,R33,U87,L62,D20,R33,U53,R51", "U98,R91,D20,R16,D67,R40,U7,R15,U6,R7")
	}

	void testSecond() {
		def wires = Util.extractLines("3.txt")
		println day.fastestCrossing(wires.get(0), wires.get(1))
	}
}