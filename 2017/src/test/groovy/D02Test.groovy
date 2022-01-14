class D02Test extends GroovyTestCase {

	D02 day = new D02()

    void testChecksum() {
		List<String> lines = Util.extractLines("D02_1Test.txt")
		assert day.checksum(lines) == 18
    }

	void testChecksum2() {
		def lines = Util.extractLines("D02_2Test.txt")
		assert day.checksum2(lines) == 9
    }
	
	void testItem() {
		def input = Util.extractLines("D02.txt")
		//46402
		println("1=" + day.checksum(input))
		println("-------------------")
		//1194
		println("2=" + day.checksum2(input))
    }
}
