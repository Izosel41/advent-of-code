class D04Test extends GroovyTestCase {

	D04 day = new D04()

	void testAdjacent(){
		assert true == day.adjacent(122345.toInteger().toString().chars)
	}

	void testIncrease(){
		assert true == day.increase(111123.toInteger().toString().chars)
		assert true == day.increase(135679.toInteger().toString().chars)
	}

	void testFind(){
		assert true == day.findPassword(111111)
		assert false == day.findPassword(223450)
		assert false == day.findPassword(123789)
	}

	void testFirst(){
		List passwords = new ArrayList()
		def range = 246515..739105
		range.forEach({it -> day.findPassword(it)? passwords.add(it):null})
		println passwords.size()
	}

	void testAdjacent2(){
		assert true == day.adjacent2(112233.toInteger().toString().chars)
		assert false == day.adjacent2(123444.toInteger().toString().chars)
		assert true == day.adjacent2(111122.toInteger().toString().chars)
		assert false == day.adjacent2(246667.toInteger().toString().chars)
	}

	void testSecond() {
		List passwords = new ArrayList()
		def range = 246515..739105
		range.forEach({it -> day.findPassword2(it)? passwords.add(it):null})
		passwords.stream().forEach({println it})
		println passwords.size()
	}
}