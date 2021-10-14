package kafkaStreams


import com.kafkaWithSpringBoot.Person
import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component
import java.util.*

@Component
class KafkaProducer {

    val logger = KotlinLogging.logger("Kafka Producer")

    /* Kafka Templates needs to initialize a ProducerFactory
     * Autowired uses the application.properties to create one
     * in the background and uses it when initializing the variable
     */
    @Autowired
    lateinit var kafkaTemplate: KafkaTemplate<String, Person>

    @Autowired
    lateinit var kafkaTopics: KafkaTopics

    fun sendEvent(person: Person) {

        person.setId(UUID.randomUUID().toString())
        kafkaTemplate.send(kafkaTopics.producer, person.getId()!!, person)
        logger.info { "event sent: ${person.getName()} to topic: ${kafkaTopics.producer}" }
    }
}
