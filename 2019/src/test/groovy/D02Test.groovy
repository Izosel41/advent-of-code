class D02Test extends GroovyTestCase {

	D02 day = new D02()

	void testIntCode(){
		assert 3500 == day.intcode(Util.convertStringToIntArray("1,9,10,3,2,3,11,0,99,30,40,50"))
		assert 2 == day.intcode(Util.convertStringToIntArray("1,0,0,0,99"))
/*		assert 6 == day.intcode("2,3,0,3,99")
		assert 9801 == day.intcode("2,4,4,5,99,0")*/
		assert 30 == day.intcode(Util.convertStringToIntArray("1,1,1,4,99,5,6,0,99"))
	}

	void testFirst(){
		def input = Util.convertStringToIntArray(Util.extractLines("2.txt").get(0))
		input[1] = 12
		input[2] = 2
		println day.intcode(input)
	}

	void testSecond() {
		def input = Util.convertStringToIntArray(Util.extractLines("2.txt").get(0))

			for(int noun = 0; noun<100; noun++) {
				for (int verb = 0; verb < 100; verb++){
					input[1] = noun
					input[2] = verb

					if (day.intcode(input) == 19690720) {
						println "[" + noun + " " + verb + "]"
						verb = 100
						noun = 100
					}else {
						input = Util.convertStringToIntArray(Util.extractLines("2.txt").get(0))
					}
				}
			}

	}
}