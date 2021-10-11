package kafkaStreams

import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.support.GenericApplicationContext
import org.springframework.kafka.config.TopicBuilder

/* Here, we take out all configs having the prefix "topic"
 * and creating them as a Singleton Bean
 */
@Configuration
@ConfigurationProperties("topic")
class KafkaTopics {
    lateinit var producer: String
    lateinit var consumer: String

    fun createList() = listOf(producer, consumer)
}

@Configuration
class TopicCreator(context: GenericApplicationContext) {

    val logger = KotlinLogging.logger("Topic Creator")
    val beanRegistry = context.beanFactory

    @Autowired
    lateinit var topics: KafkaTopics

    @Bean
    fun registerTopics() {
        topics.createList().forEach { createTopic(it) }
    }

    fun createTopic(name: String) {
        val newTopic = TopicBuilder.name(name).partitions(3).replicas(1).compact().build()
        beanRegistry.registerSingleton("KafkaTopic: $name", newTopic)
        logger.info { "Kafka topic: $name created" }
    }
}