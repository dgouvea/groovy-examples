package example.basic

import static org.junit.Assert.*

import org.junit.Test

class OperatorTest {

	@Test
	void testPlus() {
		Operator o = new Operator(0)

		o = o + 1
		assertEquals 1, o.value

		o += 2
		assertEquals 3, o.value
	}

	@Test
	void testMinus() {
		Operator o = new Operator(10)
				
		o = o - 1
		assertEquals 9, o.value
		
		o -= 2
		assertEquals 7, o.value
	}

	@Test
	void testMultiply() {
		Operator o = new Operator(2)
				
		o = o * 2
		assertEquals 4, o.value
		
		o *= 2
		assertEquals 8, o.value
	}

	@Test
	void testDivide() {
		Operator o = new Operator(8)
				
		o = o / 2
		assertEquals 4, o.value
		
		o /= 2
		assertEquals 2, o.value
	}

	@Test
	void testNext() {
		Operator o = new Operator(0)
				
		o++
		assertEquals 1, o.value
	}

	@Test
	void testPrevious() {
		Operator o = new Operator(4)
				
		o--
		assertEquals 3, o.value
	}

	@Test
	void testNegative() {
		Operator o = new Operator(4)
		
		o = -o
		assertEquals(-4, o.value)
	}

	@Test
	void testLeftShift() {
		Operator o = new Operator(4)
				
		o << 2
		assertEquals(6, o.value)
	}
	
}
