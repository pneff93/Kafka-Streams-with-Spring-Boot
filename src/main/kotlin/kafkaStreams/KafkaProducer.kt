package kafkaStreams


import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

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
        kafkaTemplate.send(kafkaTopics.producer, person.id!!, person)
        logger.info { "event sent: $person" }
    }
}
