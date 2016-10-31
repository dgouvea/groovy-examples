package example.basic

import static org.junit.Assert.*

import org.junit.Test

class ListTest {

	@Test
	void testSimpleList() {
		def list = ["A", "B", "C"]
	
		List other = new ArrayList()
		other.add("A")
		other.add("B")
		other.add("C")
			
		assertTrue List.class.isInstance(list)
		assertEquals(["A", "B", "C"], list)
		assertEquals list, other
	}

	@Test
	void testAdd() {
		def list = ["A", "B"]
				
		list << "C"
		list += "D"
				
		assertEquals(["A", "B", "C", "D"], list)
	}

	@Test
	void testRemove() {
		def list = ["A", "B", "C"]
				
		list -= "B"
		
		assertEquals(["A", "C"], list)
	}

	@Test
	void testGetByIndex() {
		def list = ["A", "B", "C"]
				
		assertEquals "B", list[1]
		assertEquals "C", list[-1]
	}

	@Test
	void testPrimitiveArray() {
		String[] list = ["A", "B", "C"] as String[]
				
		assertEquals "B", list[1]
		assertEquals "C", list[-1]
	}

}
