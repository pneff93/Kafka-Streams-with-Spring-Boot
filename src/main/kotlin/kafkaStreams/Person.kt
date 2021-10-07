package kafkaStreams

import org.springframework.stereotype.Component
import java.util.*

@Component
class Person(

    val id: String? = null,
    val name: String? = null,
    val age: Int? = null,
    var yearOfBirth: Int? = null
) {

    fun calculateYearOfBirth(): Person {
        yearOfBirth = Calendar.getInstance().get(Calendar.YEAR) - age!!
        return Person(id, name, age, yearOfBirth)
    }
}
