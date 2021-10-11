package kafkaStreams

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping


@Controller
class PersonApi {

    @Autowired
    lateinit var kafkaProducer: KafkaProducer

    @GetMapping("/person")
    fun sendForm(person: Person): String? {
        return "person"
    }

    @PostMapping("/person")
    fun processForm(person: Person): String? {
        kafkaProducer.sendEvent(person)
        return "result"
    }
}