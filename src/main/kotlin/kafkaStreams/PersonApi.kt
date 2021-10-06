package kafkaStreams

import mu.KotlinLogging
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping


@Controller
class PersonApi {

    @GetMapping("/person")
    fun sendForm(person: Person?): String? {
        return "person"
    }

    @PostMapping("/person")
    fun processForm(person: Person?): String? {
        val logger = KotlinLogging.logger("Application")
        // TODO take user and produce to Kafka
        logger.info { person!!.name }
        return "result"
    }
}