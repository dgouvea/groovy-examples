package example.basic

import org.junit.Test

class PojoTest {

    @Test
    void testGetterAndSetter() {
        Pojo pojo = new Pojo()
        pojo.name = "John Something Doe"

        assert "Get John Doe" == pojo.name
    }

    @Test
    void testConstructor() {
        Pojo pojo = new Pojo(name: "John Something Doe")

        assert "Get John Doe" == pojo.name
    }

}
