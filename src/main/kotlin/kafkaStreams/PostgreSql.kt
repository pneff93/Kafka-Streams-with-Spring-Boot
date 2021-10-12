package kafkaStreams

import org.springframework.data.jpa.repository.JpaRepository


interface SqlRepository : JpaRepository<Person?, Int?>
