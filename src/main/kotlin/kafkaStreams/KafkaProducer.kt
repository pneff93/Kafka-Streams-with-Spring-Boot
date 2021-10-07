package kafkaStreams


import org.springframework.context.annotation.Bean
import org.springframework.kafka.core.KafkaTemplate


class KafkaProducer(private val kafkaTemplate: KafkaTemplate<String, String>?) {


    @Bean
    fun sendEvent(person: Person) {

        kafkaTemplate?.send("person", person.name!!, person.name)
    }

}
