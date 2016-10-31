package example.basic

import org.junit.Test

class ClassJavaTest {

    @Test
    public void testSimplePojo() {
        ClassJava java = new ClassJava()
        java.setName("John")
        java.setAge(30)

        assert "John" == java.getName()
        assert 30 == java.getAge()
    }

}
