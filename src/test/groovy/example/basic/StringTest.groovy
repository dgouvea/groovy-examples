package example.basic

import org.junit.Test

class StringTest {

    @Test
    void testSimple() {
        String simpleQuoteString = 'Simple Quote String'
        String doubleQuoteString = "Double Quote String"
        String multiQuoteString = '''Multi Quote String'''

        assert "Simple Quote String" == simpleQuoteString
        assert String.class == simpleQuoteString.class
        assert "Double Quote String" == doubleQuoteString
        assert String.class == doubleQuoteString.class
        assert "Multi Quote String" == multiQuoteString
        assert String.class == multiQuoteString.class
    }

    @Test
    void testMultiLine() {
        String multiQuoteString = '''Multi
Line
String'''

        assert "Multi\nLine\nString" == multiQuoteString
    }

    @Test
    void testConcat() {
        String firstName = "John"
        String lastName = "Doe"
        String fullName1 = firstName + " " + lastName
        String fullName2 = "$firstName ${lastName}"

        assert "John Doe" == fullName1
        assert "John Doe" == fullName2
    }

    @Test
    void testReplace() {
        String s = "Today is happy monday"
        String s1 = s - "happy "

        assert "Today is monday" == s1
    }

    @Test
    void testMultiply() {
        String s = "Tak "
        String s1 = s * 3

        assert "Tak Tak Tak " == s1
    }

    @Test
    void testChar() {
        char c = 'c'

        assert "c".charAt(0) == c
        assert 99 == (int) c
    }

    @Test
    void testStringBuilder() {
        StringBuilder s = new StringBuilder()
        s << "This "
        s << "is "
        s << "a " << "String"

        assert "This is a String" == s.toString()
    }

}
