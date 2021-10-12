# Kafka Streams with Spring Boot

This project serves as a playground for me learning Spring Boot and its components:

Basically, you can produce data via an HTML form under `localhost:5555/person`.

This data is produced to Apache Kafka,
processed by Kafka Streams, and finally consumed again. All Kafka topics are created
programmatically when starting the application. Moreover, we use Avro schema, and a
registry to move the data. `localhost:5555/health` provides a health route for Kafka Streams.

Finally, the data is stored in a PostgreSQL database `testDB`.

Functions as well as the topologies are being tested by unit tests.



* using [JSON Serde](https://howtodoinjava.com/kafka/spring-boot-jsonserializer-example/)  


## Initialize Project

https://start.spring.io/

### Dependencies:
* Spring Web
* Spring for Apache Kafka Streams
* Spring for Apache Kafka
* Thymeleaf
* PostgreSQL Driver
* Spring Data JPA

## Run Project

Start Kafka broker, Zookeeper, and schema registry

```docker-compose up -d```

Run program

```./gradlew bootRun```



## Additional Sources

* [Annotations](http://www.matthiassommer.it/programming/spring-konzepte-annotationen/)
* [PostgreSQL](https://www.bezkoder.com/spring-boot-postgresql-example/)
* [Logging](https://github.com/MicroUtils/kotlin-logging)

### Spring Boot
* [Spring Boot Tutorial](https://spring.io/guides/gs/spring-boot/)
* [HTML form]((https://spring.io/guides/gs/handling-form-submission/))
  
### Kafka Streams
* [developer.confluent.io](https://developer.confluent.io/learn-kafka/spring/confluent-cloud/)  
* [Kafka topics](https://stackoverflow.com/questions/56770412/creating-multiple-kafka-topics-using-spring)

### PostgreSQL
* 