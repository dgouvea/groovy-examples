package example.basic

import static org.junit.Assert.*

import org.junit.Test;

class PojoTest {

	@Test
	void testGetterAndSetter() {
		Pojo pojo = new Pojo()
		pojo.name = "John Something Doe"
		
		assertEquals "Get John Doe", pojo.name
	}
	
}
