class D05Test extends GroovyTestCase {
	D05 day = new D05()

	void testJump() {
		def lines = Util.extractLines("D05_1Test.txt")
		assert day.jump(lines*.toInteger()) == 5
	}

	void testItem() {
		def lines = Util.extractLines("D05.txt")
		println day.jump(lines*.toInteger())
	}
}
