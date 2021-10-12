package kafkaStreams

import mu.KotlinLogging
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component


@Component
class KafkaConsumer {

    val logger = KotlinLogging.logger("Kafka Consumer")

    @Autowired
    lateinit var sqlDatabase: JpaRepository<Person?, Int?>

    //    @KafkaListener(topics = ["\${topic.consumer}"], groupId = "\${spring.kafka.streams.application-id}")
    @KafkaListener(topics = ["\${topic.consumer}"], groupId = "tessss")
    fun consumeEvent(event: ConsumerRecord<String, Person>) {

        logger.info { "event consumed: ${event.value()} from topic: ${event.topic()}"}
        sqlDatabase.save(event.value())
        logger.info { "event stored: ${event.value()} in sql database" }
    }
}
