package example.basic

import static org.junit.Assert.*

import org.junit.Test

class ClassGroovyTest {

	@Test
	void testSimplePojo() {
		ClassGroovy groovy = new ClassGroovy()
		groovy.name = "John"
		groovy.age = 30
		
		assertEquals "John", groovy.name
		assertEquals 30, groovy.age
	}
	
}
