package example.basic

import static org.junit.Assert.*;
import org.junit.Test;

class StringTest {

	@Test
	void testSimple() {
		String simpleQuoteString = 'Simple Quote String'
		String doubleQuoteString = "Double Quote String"
		String multiQuoteString = '''Multi Quote String'''
		
		assertEquals "Simple Quote String", simpleQuoteString
		assertEquals String.class, simpleQuoteString.class
		assertEquals "Double Quote String", doubleQuoteString
		assertEquals String.class, doubleQuoteString.class
		assertEquals "Multi Quote String", multiQuoteString
		assertEquals String.class, multiQuoteString.class
	}

	@Test
	void testMultiLine() {
		String multiQuoteString = '''Multi
Line
String'''
		
		assertEquals "Multi\nLine\nString", multiQuoteString
	}
	
	@Test
	void testConcat() {
		String firstName = "John"
		String lastName = "Doe"
		String fullName1 = firstName + " " + lastName
		String fullName2 = "$firstName ${lastName}"
		
		assertEquals "John Doe", fullName1
		assertEquals "John Doe", fullName2
	}
	
	@Test
	void testReplace() {
		String s = "Today is happy monday"
		String s1 = s - "happy "
		
		assertEquals "Today is monday", s1
	}

	@Test
	void testMultiply() {
		String s = "Tak "
		String s1 = s * 3
		
		assertEquals "Tak Tak Tak ", s1
	}
	
	@Test
	void testChar() {
		char c = 'c'
		
		assertEquals "c".charAt(0), c
		assertEquals 99, (int) c
	}
	
	@Test
	void testStringBuilder() {
		StringBuilder s = new StringBuilder()
		s << "This "
		s << "is "
		s << "a " << "String"
		
		assertEquals "This is a String", s.toString()
	}
	
}
