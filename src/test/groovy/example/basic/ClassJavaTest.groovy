package example.basic

import static org.junit.Assert.*

import org.junit.Test

class ClassJavaTest {

	@Test
	public void testSimplePojo() {
		ClassJava java = new ClassJava();
		java.setName("John");
		java.setAge(30);
		
		assertEquals("John", java.getName());
		assertEquals(30, java.getAge());
	}

}
