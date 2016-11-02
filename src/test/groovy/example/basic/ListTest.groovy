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
    void testFlatten() {
        List list = [0, 1, 6, 4, [3, 1, 2, [4, 5]], 8]
        assert [0, 1, 6, 4, 3, 1, 2, 4, 5, 8] == list.flatten()
    }

    @Test
    void testSet() {
        Set list = [0, 1, 6, 8, 1, 2, 6, 7, 8]
        assert [0, 1, 6, 8, 2, 7] as Set == list
    }

    @Test
    void testPrimitiveArray() {
        String[] list = ["A", "B", "C"] as String[]

        assert "B" == list[1]
        assert "C" == list[-1]
    }

}
