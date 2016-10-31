package example.basic

import org.junit.Test

class ClassGroovyTest {

    @Test
    void testSimplePojo() {
        ClassGroovy groovy = new ClassGroovy()
        groovy.name = "John"
        groovy.age = 30

        assert "John" == groovy.name
        assert 30 == groovy.age
    }

}
