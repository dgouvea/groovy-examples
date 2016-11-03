package example

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import org.springframework.web.client.RestTemplate

@SpringBootApplication
class ExampleSpringBootApplication {

    static void main(String[] args) {
        SpringApplication.run ExampleSpringBootApplication, args
    }
}

@Document(collection = "entities")
class Entity {
    @Id
    String id
    String name
}

@RepositoryRestResource
interface EntityRepository extends MongoRepository<Entity, String> {}

@Configuration
class RestConfig {

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

}


