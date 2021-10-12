package kafkaStreams

import org.apache.kafka.streams.KafkaStreams
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.config.StreamsBuilderFactoryBean
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class KafkaStreamsHealthRoute {

    @Autowired
    lateinit var factoryBean: StreamsBuilderFactoryBean

    @GetMapping("/health")
    fun isRunning(): KafkaStreams.State {
        return factoryBean.kafkaStreams.state()
    }
}