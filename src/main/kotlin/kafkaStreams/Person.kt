package kafkaStreams

import org.springframework.stereotype.Component
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

/* This class is only needed for the sql database storing
 * For (de)serialization with Avro the generated Java class is used
 */
@Component
@Entity
@Table(name = "Person")
data class PersonTable(

    @Id
    var id: String? = null,
    val name: String? = null,
    val age: Int? = null,
    var yearOfBirth: Int? = null
)

