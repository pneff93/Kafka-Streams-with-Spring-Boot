package kafkaStreams

import mu.KotlinLogging
import org.apache.kafka.common.serialization.Serdes
import org.apache.kafka.streams.StreamsBuilder
import org.apache.kafka.streams.kstream.Consumed
import org.apache.kafka.streams.kstream.Produced
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component


@Component
class KafkaStreamsProcessor {

    val logger = KotlinLogging.logger("Kafka Streams Processor")

    @Autowired
    fun process(builder: StreamsBuilder, kafkaTopic: KafkaTopics) {

        builder
            .stream<String, String>(kafkaTopic.producer, Consumed.with(Serdes.String(), Serdes.String()))
//            .mapValues { _, value: Person -> value.calculateYearOfBirth() }
            .peek { _, value -> logger.info { "event processed: $value from topic: ${kafkaTopic.producer} into ${kafkaTopic.consumer}" } }
            .to(kafkaTopic.consumer, Produced.with(Serdes.String(), Serdes.String()))
    }
}
