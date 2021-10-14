package kafkaStreams

import com.kafkaWithSpringBoot.Person
import io.confluent.kafka.serializers.AbstractKafkaSchemaSerDeConfig
import io.confluent.kafka.streams.serdes.avro.SpecificAvroSerde
import mu.KotlinLogging
import org.apache.kafka.common.serialization.Serdes
import org.apache.kafka.streams.StreamsBuilder
import org.apache.kafka.streams.kstream.Consumed
import org.apache.kafka.streams.kstream.Produced
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.util.*


@Component
class KafkaStreamsProcessor {

    val logger = KotlinLogging.logger("Kafka Streams Processor")

    @Value("\${spring.kafka.properties.schema.registry.url}")
    lateinit var schemaRegistryUrl: String


    @Autowired
    fun processStream(builder: StreamsBuilder, kafkaTopic: KafkaTopics) {

        builder
            .stream(kafkaTopic.producer, Consumed.with(Serdes.String(), specificAvro()))
            .mapValues { _, value: Person -> calculateYearOfBirth(value) }
            .peek { _, value -> logger.info { "event processed: ${value.getName()}" } }
            .to(kafkaTopic.consumer, Produced.with(Serdes.String(), specificAvro()))
    }

    // For Kafka Streams we need to configure the SpecificAvroSerde
    fun specificAvro(): SpecificAvroSerde<Person> {

        val serde: SpecificAvroSerde<Person> = SpecificAvroSerde<Person>()
        val config = mapOf(AbstractKafkaSchemaSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG to schemaRegistryUrl)
        serde.configure(config, false)
        return serde
    }

    fun calculateYearOfBirth(person: Person): Person {

        person.setYearOfBirth(Calendar.getInstance().get(Calendar.YEAR) - person.getAge())
        return person
    }
}
