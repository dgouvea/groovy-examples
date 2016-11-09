package example.spock

import example.basic.Operator
import example.basic.PointlessCategory
import example.basic.PointlessCategoryWithoutAnnotation
import groovy.json.JsonBuilder
import groovy.json.JsonSlurper
import groovy.xml.MarkupBuilder
import org.custommonkey.xmlunit.XMLUnit
import spock.lang.Ignore
import spock.lang.Specification
import spock.lang.Unroll

class SpockSpec extends Specification {
    def "Compare two same Strings in different format"() {

        given: " Two strings one three-quotes String and simple double quotes String containing HTML Code  "

            String tripleQuotesHtml =
                    '''<head>
                        <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
                        <meta charset="utf-8"/>
                        <title>Some title</title>
                        <meta name="google-site-verification" content="gA2FWdHlSDwzRgHOLkLJCXLVgdwMLrPqeCizGHf2iIY"/>
                        <link href="/main.4007d4155036b1298a43b988548ec61c.css" rel="stylesheet"/>
                    </head>'''

            String doubleQuotesHtml =
                    "<head>\n" +
                            "        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\"/>\n" +
                            "        <meta charset=\"utf-8\"/>\n" +
                            "        <title>Some title</title>\n" +
                            "        <meta name=\"google-site-verification\" content=\"gA2FWdHlSDwzRgHOLkLJCXLVgdwMLrPqeCizGHf2iIY\"/>\n" +
                            "        <link href=\"/main.4007d4155036b1298a43b988548ec61c.css\" rel=\"stylesheet\"/>\n" +
                            "    </head>"

        expect: "They should be equal"
            XMLUnit.compareXML(tripleQuotesHtml, doubleQuotesHtml)
    }


    def "JSON Builder generates JSON object"() {
        when:
            def builder = new JsonBuilder()
            builder.people {
                person {
                    firstName 'Guillame'
                    lastName 'Laforge'
                    // Named arguments are valid values for objects too
                    address(
                            city: 'Paris',
                            country: 'France',
                            zip: 12345,
                    )
                    married true
                    // a list of values
                    conferences 'JavaOne', 'Gr8conf'
                }
            }
        then:
            builder.toString() == '{"people":{"person":{"firstName":"Guillame","lastName":"Laforge","address":{"city":"Paris","country":"France","zip":12345},"married":true,"conferences":["JavaOne","Gr8conf"]}}}'
    }

    def "JSON Parser parse json strings"() {
        given:
            def slurper = new JsonSlurper()
            def result = slurper.parseText('{"person":{"name":"Guillaume","age":33,"pets":["dog","cat"]}}')
        expect:
            result.person.name == "Guillaume"
            result.person.age == 33
            result.person.pets.size() == 2
            result.person.pets[0] == "dog"
            result.person.pets[1] == "cat"

    }

    def "XML Builder generates valid node structure"() {
        when:
            def sw = new StringWriter()
            def xml = new MarkupBuilder(sw)
            xml.langs(type: "current") {
                language("Java")
                language("Groovy")
                language("JavaScript")
            }
        then:
            XMLUnit.compareXML('''<langs type='current'>
                                      <language>Java</language>
                                      <language>Groovy</language>
                                      <language>JavaScript</language>
                                    </langs>''', sw.toString())

    }

    def "XML Builder generates valid HTML"() {
        when:
            def sw = new StringWriter()
            def html = new MarkupBuilder(sw)
            html.html {
                head {
                    title("Links")
                }
                body {
                    h1("Here are my HTML bookmarks")
                    table(border: 1) {
                        tr {
                            th("what")
                            th("where")
                        }
                        tr {
                            td("Groovy Articles")
                            td {
                                a(href: "http://ibm.com/developerworks", "DeveloperWorks")
                            }
                        }
                    }
                }
            }
        then:
            XMLUnit.compareXML(sw.toString(),
                    '''<html>
                          <head>
                            <title>Links</title>
                          </head>
                          <body>
                            <h1>Here are my HTML bookmarks</h1>
                            <table border='1'>
                              <tr>
                                <th>what</th>
                                <th>where</th>
                              </tr>
                              <tr>
                                <td>Groovy Articles</td>
                                <td>
                                  <a href='http://ibm.com/developerworks'>DeveloperWorks</a>
                                </td>
                              </tr>
                            </table>
                          </body>
                        </html>''')

    }


    def "computing the maximum of two numbers with << operator at where"() {
        expect:
            Math.max(a, b) == c

        where:
            a << [5, 3]
            b << [1, 9]
            c << [5, 9]
    }

    @Unroll
    def "computing the maximum out of two numbers [#a, #b] with table where style"() {
        expect:
            Math.max(a, b) == c
        where:
            a | b | c
            5 | 1 | 5
            3 | 9 | 9
    }

    @Unroll("Checking image name #pictureFile")
    def "All kinds of JPEG file are accepted"() {

        given: "an image extension checker"
            ImageNameValidator validator = new ImageNameValidator();

        expect: "that all jpeg filenames are accepted regardless of case "
            validator.isValidImageExtension(pictureFile)

        where: "sample image names are"
            pictureFile << GroovyCollections.combinations([["sample.", "Sample.", " SAMPLE."], ['j', 'J'], ['p', 'P'], ['e', 'E', ''], ['g', 'G']])*.join()
    }

    def "Category test"() {
        given:
            def operator = new Operator(5)

        when: "Using with PointlessCategory written with @Category annotation"
            use(PointlessCategory) {
                operator.incrementMe()
            }
        then: "Must work fine, and no MissingMethodException was thrown"
            operator.value == 6
            notThrown(MissingMethodException)

        when: "Using without category, no method available"
            operator.incrementMe()
        then: "MissingMethodException should be thrown"
            thrown(MissingMethodException)

        when: "Using with PointlessCategory written with static methods and passing of instance as first parameter"
            use(PointlessCategoryWithoutAnnotation) {
                operator.incrementMe()
            }
        then: "Must work fine, and no MissingMethodException was thrown"
            operator.value == 7
            notThrown(MissingMethodException)
    }

    @Ignore
    def "Beautiful failure"() {
        when:
            def a = 5
        and:
            def b = 10
        then:
            (a + b) * b == 149
    }

}

class ImageNameValidator {
    boolean isValidImageExtension(String filename) {
        return filename
    }
}


