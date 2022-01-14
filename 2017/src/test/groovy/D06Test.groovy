;


import org.junit.Test

import static org.junit.Assert.*

class D06Test {
	
	def D06 day = new D06();

//	@Test
//	public void testGetCycleRealloc() {
//		def banks = [0,2,7,0]
//		assert(5==day.getCycleRealloc(banks))
//	}

	@Test
	public void testRealloc() {
		def banks = [5,1,10,0,1,7,13,14,3,12,8,10,7,12,0,6]; 
		println day.getCycleRealloc(banks)
//		//renew lines as the jump method change the values
//		lines = new File(getClass().getClassLoader().getResource("D05.txt").toURI())*.toInteger().collect {it}
//		println(day.jump2(lines));
	}

}
