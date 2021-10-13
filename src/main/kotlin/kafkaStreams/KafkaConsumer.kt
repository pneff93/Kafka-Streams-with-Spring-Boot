package kafkaStreams

import mu.KotlinLogging
import org.apache.avro.generic.GenericRecord
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

    //    @KafkaListener(topics = ["\${topic.consumer}"], groupId = "\${spring.kafka.streams.application-id}")
    @KafkaListener(topics = ["\${topic.producer}"], groupId = "tessss")
    fun consumeEvent(event: ConsumerRecord<String, GenericRecord>) {

        logger.info { "event consumed: ${event.value()} from topic: ${event.topic()}" }

        val person = PersonTable(
            event.value()["id"].toString(),
            event.value()["name"].toString(),
            event.value()["age"].toString().toInt(),
//            event.value()["yearOfBirth"].toString().toInt()
        )
        sqlDatabase.save(person)
        logger.info { "event stored: $person in sql database" }
    }
}
