package kafkaStreams

import org.springframework.stereotype.Component
import java.util.*
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Component
@Entity
@Table
data class Person(

    @Id
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
