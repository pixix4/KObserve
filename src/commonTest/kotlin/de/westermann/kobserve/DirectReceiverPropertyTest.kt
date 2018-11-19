package de.westermann.kobserve

import kotlin.test.Test
import kotlin.test.assertEquals

class DirectReceiverPropertyTest {


    @Test
    fun directReceiverPropertyTest() {
        val user = Person("John", "Doe")

        val firstNameProperty = property(user::firstName)
        val firstName by firstNameProperty

        val lastNameProperty = user::lastName.observe()
        val lastName by lastNameProperty

        val ageProperty = property(user::age)
        var age by ageProperty

        var firstNameCount = 0
        firstNameProperty.onChange {
            firstNameCount += 1
        }
        var ageCount = 0
        ageProperty.onChange {
            ageCount += 1
        }

        assertEquals("John", user.firstName)
        assertEquals("John", firstName)
        assertEquals("Doe", lastName)
        assertEquals(21, age)

        age = 22

        assertEquals(0, firstNameCount)
        assertEquals(1, ageCount)

        assertEquals(22, age)
        assertEquals(22, user.age)
    }


    class Person(
        var firstName: String,
        val lastName: String
    ) {
        var age = 21
    }
}
