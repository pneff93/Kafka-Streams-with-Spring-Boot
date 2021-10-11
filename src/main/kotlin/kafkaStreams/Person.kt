package kafkaStreams

import org.springframework.stereotype.Component
import java.util.*

@Component
data class Person(

    var id: String? = UUID.randomUUID().toString(),
    val name: String? = null,
    val age: Int? = null,
    var yearOfBirth: Int? = null
) {

    fun calculateYearOfBirth(): Person {
        yearOfBirth = Calendar.getInstance().get(Calendar.YEAR) - age!!
        return Person(id, name, age, yearOfBirth)
    }
}
