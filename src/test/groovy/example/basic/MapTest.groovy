package example.basic

import static org.junit.Assert.*;

import org.junit.Test;

class MapTest {

	@Test
	void testSimpleMap() {
		def map = [:]
		map.put "firstName", "John"
		map["lastName"] = "Doe"
		
		assert map.size() == 2
		assert map["firstName"] == "John"
		assert map.get("firstName") == "John"
		assert map["lastName"] == "Doe"
		assert map.get("lastName") == "Doe"
	}
	
}
