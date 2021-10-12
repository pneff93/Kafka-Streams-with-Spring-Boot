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

## Initialize Project

https://start.spring.io/

### Dependencies:
* Spring Web
* Spring for Apache Kafka Streams
* Spring for Apache Kafka
* Thymeleaf

## Run Project

Start Kafka broker and schema registry with
`docker-compose up -d`

Run program then with `./gradlew bootRun`

Under `localhost:5555/person` you can produce data into Kafka via an HTML form.

The URL `localhost:5555/health` provides a health route for the streams processor. 


## Additional Sources

* [Annotations](http://www.matthiassommer.it/programming/spring-konzepte-annotationen/)

### Spring Boot
* [Spring Boot Tutorial](https://spring.io/guides/gs/spring-boot/)
  
### Kafka Streams
* [developer.confluent.io](https://developer.confluent.io/learn-kafka/spring/confluent-cloud/)  

### Logging
* [logging](https://github.com/MicroUtils/kotlin-logging)