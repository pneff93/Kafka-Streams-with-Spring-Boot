package kafkaStreams

import com.kafkaWithSpringBoot.Person
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
    lateinit var sqlDatabase: JpaRepository<PersonTable?, Int?>

    @KafkaListener(topics = ["\${topic.consumer}"])
    fun consumeEvent(event: ConsumerRecord<String, Person>) {

        logger.info { "event consumed: ${event.value().getName()} from topic: ${event.topic()}" }

        val person = PersonTable(
            event.value().getId(),
            event.value().getName(),
            event.value().getAge(),
            event.value().getYearOfBirth()
        )
        sqlDatabase.save(person)
        logger.info { "event stored: ${person.name} in sql database" }
    }
}
