package kafkaStreams

import mu.KotlinLogging
import org.apache.kafka.clients.admin.NewTopic
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component

@SpringBootApplication
class MainApplication {

    // Bean is mandatory otherwise function is not used
    @Bean
    fun run() {
        val logger = KotlinLogging.logger("Application")
        logger.info { "Lets give it a try" }

//        val topic: NewTopic = KafkaProducer.createTopic("person")
//        logger.info { "topic created $topic" }
    }
}

fun main() {
    runApplication<MainApplication>()
}

