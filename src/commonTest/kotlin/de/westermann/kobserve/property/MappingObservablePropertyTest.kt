package de.westermann.kobserve.property

import kotlin.test.Test
import kotlin.test.assertEquals

class MappingObservablePropertyTest {

    @Test
    fun mappedPropertyTest() {
        val numberProperty = property(1)
        var number by numberProperty

        val squareProperty = numberProperty.mapBinding { it * it }
        val square by squareProperty

        var delayedSquare = square
        squareProperty.onChange {
            delayedSquare = square
        }

        assertEquals(1, square)

        number = 2
        assertEquals(2, number)
        assertEquals(4, square)
        assertEquals(4, delayedSquare)
    }

    @Test
    fun receiverPropertyTest() {
        val userProperty = property(Person("John", "Doe"))
        var user by userProperty

        val firstNameProperty = userProperty.mapBinding(Person::firstName)
        val firstName by firstNameProperty

        val lastNameProperty = userProperty.mapBinding(Person::lastName)
        val lastName by lastNameProperty

        val ageProperty = userProperty.mapMutableBinding(Person::age)
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
