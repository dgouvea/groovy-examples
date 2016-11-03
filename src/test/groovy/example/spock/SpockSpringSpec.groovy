package example.spock

import example.Entity
import example.EntityRepository
import groovy.json.JsonSlurper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import spock.lang.Specification
import spock.lang.Stepwise

@Stepwise
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SpockSpringSpec extends Specification {

    @Autowired
    EntityRepository entityRepository;

    @Autowired
    TestRestTemplate restTemplate;

    def "Upload into the MongoDB some data and retrieve this data back"() {
        given:
            entityRepository.deleteAll()
            def entities = [new Entity(name: "First"), new Entity(name: "Second")]
        when:
            entityRepository.save(entities)
        then:
            def all = entityRepository.findAll()
            all.size() == 2
            all.first().name == "First"
            all.last().name == "Second"
    }

    def "Rest resource is available to query with HTTP"() {
        when:
            def result = restTemplate.getForObject("/entities", String.class)
        then:
            def json = new JsonSlurper().parseText(result)
            json._embedded.entities[0].name == "First"
    }
}


