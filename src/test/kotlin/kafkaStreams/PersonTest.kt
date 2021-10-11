package kafkaStreams

import org.junit.Assert
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest


@SpringBootTest
class PersonTest {

    @Test
    fun calculateYearOfBirth() {

        val event = Person("id", "Paul", 20)
        val expectedEvent = Person("id", "Paul", 20, 2001)
        Assert.assertEquals(expectedEvent, event.calculateYearOfBirth())
    }
}
