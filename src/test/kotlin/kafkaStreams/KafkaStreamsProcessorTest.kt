//package kafkaStreams
//
//import com.kafkaWithSpringBoot.Person
//import io.confluent.kafka.serializers.AbstractKafkaSchemaSerDeConfig
//import io.confluent.kafka.streams.serdes.avro.SpecificAvroSerde
//import org.apache.kafka.common.serialization.Serdes.StringSerde
//import org.apache.kafka.streams.*
//import org.junit.Assert
//import org.junit.jupiter.api.Test
//import org.mockito.Mock
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.boot.test.context.SpringBootTest
//import org.springframework.test.context.ActiveProfiles
//import java.util.*
//
//
//@SpringBootTest
////@ActiveProfiles("test")
////@TestPropertySource(locations=["classpath:application-test.properties"])
////@RunWith(SpringRunner.class)
//@ActiveProfiles("test")
//class KafkaStreamsProcessorTest {
//
//    @Mock
////    var jdbcTemplate: JpaRepository<PersonTable?, Int?>? = null
//
//    @Autowired
//    lateinit var processor: KafkaStreamsProcessor
//
//    @Test
//    fun calculateYearOfBirth() {
//
//        val event = Person("id", "Paul", 20, null)
//        val expectedEvent = Person("id", "Paul", 20, 2001)
//        Assert.assertEquals(expectedEvent, processor.calculateYearOfBirth(event))
//    }
//
//    @Test
//    fun processStream() {
//
//        // Properties
//        val schemaRegistryUrl = "mock://localhost:8081"
//
//        val props = Properties()
//        props[StreamsConfig.APPLICATION_ID_CONFIG] = "testApplicationId"
//        props[StreamsConfig.BOOTSTRAP_SERVERS_CONFIG] = "dummy:1234"
//        props[StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG] = StringSerde::class.java
//        props[StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG] = SpecificAvroSerde::class.java
//        props[AbstractKafkaSchemaSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG] = schemaRegistryUrl
//
//        // Topology
//        val kafkaTopics = KafkaTopics()
//        kafkaTopics.producer = "input"
//        kafkaTopics.consumer = "output"
//
//        val builder = StreamsBuilder()
//
//        processor.processStream(builder, kafkaTopics)
//        val topology: Topology = builder.build()
//
//        // Topology Test Driver
//        val testDriver = TopologyTestDriver(topology, props)
//
//        // Configure Serde
//        val serde: SpecificAvroSerde<Person> = processor.specificAvro()
//
//        // Create Input and Output Topics
//        val inputTopic: TestInputTopic<String, Person> =
//            testDriver.createInputTopic(kafkaTopics.producer, StringSerde().serializer(), serde.serializer())
//        val outputTopic =
//            testDriver.createOutputTopic(kafkaTopics.consumer, StringSerde().deserializer(), serde.deserializer())
//
//        // Test
//        val person = Person("id", "PeterParker", 31, null)
//        inputTopic.pipeInput(person)
//
//        person.setYearOfBirth(1990)
//        Assert.assertEquals(person, outputTopic.readKeyValue().value)
//        testDriver.close()
//    }
//}
