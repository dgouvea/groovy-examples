package example.basic

import org.junit.AfterClass;
import org.junit.Test;

class IOTest {

	@Test
	void testWriteFile() {
		File file = new File("out.txt")
		assert !file.exists()
		
		file.write "it's a file"
		
		file = new File("out.txt")
		assert file.exists()
		
		byte[] bytes = file.readBytes()
		
		String text = new String(bytes)
		assert text == "it's a file"
	}
	
	@AfterClass
	static void afterAll() {
		File f = new File("out.txt")
		if (f.exists()) {
			f.delete()
		}
	}
	
}
