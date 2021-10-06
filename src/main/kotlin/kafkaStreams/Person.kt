package kafkaStreams

import java.util.*

class Person(

    private val id: String? = null,
    val name: String? = null,
    val age: Int? = null,
    var yearOfBirth: Int? = null
) {

    fun calculateYearOfBirth(): Person {
        yearOfBirth = Calendar.getInstance().get(Calendar.YEAR) - age!!
        return Person(id, name, age, yearOfBirth)
    }
}
