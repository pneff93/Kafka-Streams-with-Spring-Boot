# Kafka Streams with Spring Boot

This project serves as a playground for me learning Spring Boot and its components.
I focussed on the following things:
* creating a RestController to send data via [HTML form]((https://spring.io/guides/gs/handling-form-submission/))
* creating [Kafka topics programmatically](https://developer.confluent.io/learn-kafka/spring/hands-on-create-kafka-topics/) using [BeanFactory](https://stackoverflow.com/questions/56770412/creating-multiple-kafka-topics-using-spring)
* producing and consuming data with Kafka Streams
* using [JSON Serde](https://howtodoinjava.com/kafka/spring-boot-jsonserializer-example/)  
* using Avro schema
* adding a HealthRoute
* testing functions

## Initialize project

https://start.spring.io/
* Spring Web
* Spring for Apache Kafka Streams
* Spring for Apache Kafka
* Thymeleaf

## Run project

```./gradlew bootRun```

## Additional Sources

* [Annotations](http://www.matthiassommer.it/programming/spring-konzepte-annotationen/)

### Spring Boot
* [Spring Boot Tutorial](https://spring.io/guides/gs/spring-boot/)
  
### Kafka Streams
* [developer.confluent.io](https://developer.confluent.io/learn-kafka/spring/confluent-cloud/)  

### Logging
* [logging](https://github.com/MicroUtils/kotlin-logging)