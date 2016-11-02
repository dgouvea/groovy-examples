package example.basic

import org.junit.Test;

class RangeTest {

    @Test
    void testRange() {
        List list = []
        (1..10).each { num ->
            list << num
        }

        assert [1, 2, 3, 4, 5, 6, 7, 8, 9, 10] == list
    }

    @Test
    void testReverseRange() {
        List list = []
        (10..1).each { num ->
            list << num
        }

        assert [10, 9, 8, 7, 6, 5, 4, 3, 2, 1] == list
    }


    @Test
    void testRangeExclusive() {
        List list = []
        (1..<10).each { num ->
            list << num
        }

        assert [1, 2, 3, 4, 5, 6, 7, 8, 9] == list
    }

}
