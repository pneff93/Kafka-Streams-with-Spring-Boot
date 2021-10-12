package kafkaStreams

import mu.KotlinLogging
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component


@Component
class KafkaConsumer {

    val logger = KotlinLogging.logger("Kafka Consumer")

    //    @KafkaListener(topics = ["\${topic.consumer}"], groupId = "\${spring.kafka.streams.application-id}")
    @KafkaListener(topics = ["\${topic.consumer}"], groupId = "tessss")
    fun consumeEvent(event: ConsumerRecord<String, Person>): Person {

        logger.info { "event consumed: ${event.value()} from topic: ${event.topic()} "}
        return event.value()

    }
}
