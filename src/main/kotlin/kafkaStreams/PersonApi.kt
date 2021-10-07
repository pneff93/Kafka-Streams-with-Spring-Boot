package kafkaStreams

import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping


@Controller
class PersonApi {

    /* Kafka Templates needs to initialize a ProducerFactory
     * Autowired uses the application.properties to create one
     * in the background and uses it when initializing the variable
     */
    @Autowired
    private val kafkaTemplate: KafkaTemplate<String, String>? = null

    @GetMapping("/person")
    fun sendForm(person: Person): String? {
        return "person"
    }

    @PostMapping("/person")
    fun processForm(person: Person): String? {
        val logger = KotlinLogging.logger("Application")

        KafkaProducer(kafkaTemplate).sendEvent(person)
        logger.info { person.name }

        return "result"
    }
}