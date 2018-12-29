package de.westermann.kobserve.basic

import kotlin.test.Test
import kotlin.test.assertEquals

class ReceiverPropertyTest {

    @Test
    fun receiverPropertyTest() {
        val userProperty = property(Person("John", "Doe"))
        var user by userProperty

        val firstNameProperty = userProperty.mapBinding(Person::firstName)
        val firstName by firstNameProperty

        val lastNameProperty = userProperty.mapBinding(Person::lastName)
        val lastName by lastNameProperty

        val ageProperty = userProperty.mapBinding(Person::age)
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

        user = Person("Jana", "Doe")
        assertEquals("Jana", user.firstName)
        assertEquals("Jana", firstName)
        assertEquals(21, age)

        assertEquals(1, firstNameCount)
        assertEquals(2, ageCount)
    }


    class Person(
        var firstName: String,
        val lastName: String
    ) {
        var age = 21
    }
}
