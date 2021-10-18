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

    /* Basically, we need a ProducerFactory with all configs
     * Kafka Templates uses the DefaultKafkaProducerFactory
     * with the configs out of the application.properties
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
