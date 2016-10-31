package example.basic

import org.junit.Test

class ListTest {

    @Test
    void testSimpleList() {
        def list = ["A", "B", "C"]

        List other = new ArrayList()
        other.add("A")
        other.add("B")
        other.add("C")

        assert List.class.isInstance(list)
        assert ["A", "B", "C"] == list
        assert list == other
    }

    @Test
    void testAdd() {
        def list = ["A", "B"]

        list << "C"
        list += "D"

        assert ["A", "B", "C", "D"] == list
    }

    @Test
    void testRemove() {
        def list = ["A", "B", "C"]

        list -= "B"

        assert ["A", "C"] == list
    }

    @Test
    void testGetByIndex() {
        def list = ["A", "B", "C"]

        assert "B", list[1]
        assert "C", list[-1]
    }

    @Test
    void testPrimitiveArray() {
        String[] list = ["A", "B", "C"] as String[]

        assert "B" == list[1]
        assert "C" == list[-1]
    }

}
