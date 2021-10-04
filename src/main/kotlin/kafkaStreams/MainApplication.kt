package kafkaStreams

import mu.KotlinLogging
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class MainApplication {

    // Bean is mandatory otherwise function is not used
    @Bean
    fun run() {
        val logger = KotlinLogging.logger("Application")
        logger.info { "Lets give it a try" }
    }
}

fun main() {
    runApplication<MainApplication>()
}

