package de.westermann.kobserve

import de.westermann.kobserve.basic.*
import kotlin.math.pow
import kotlin.test.Test
import kotlin.test.assertEquals

class FlatPropertyTest {

    @Test
    fun flatReceiverTest() {
        val personProperty = property(Person("John", "Doe", 21))
        var person by personProperty

        val firstNameProperty = personProperty.flatMapBinding(Person::firstNameProperty)
        val lastNameProperty = personProperty.flatMapBinding(Person::lastNameProperty)

        val age2xProperty = personProperty.flatMapBinding { it.getAgeMultiplier(2) }
        val age4xProperty = personProperty.flatMapBinding { it.getAgeMultiplier(4) }
        val agePowerProperty = personProperty.flatMapReadOnlyBinding { it.getAgeReader(2.0) }

        assertEquals(person.age * 2, age2xProperty.value)
        assertEquals(person.age * 4, age4xProperty.value)

        person.age = 22

        assertEquals("Doe", lastNameProperty.value)
        assertEquals(person.age * 2, age2xProperty.value)
        assertEquals(person.age * 4, age4xProperty.value)
        assertEquals(person.age.toDouble().pow(2.0), agePowerProperty.value)

        person = Person("Max", "Mustermann", 25)

        assertEquals("Max", firstNameProperty.value)
        assertEquals(person.age * 2, age2xProperty.value)
        assertEquals(person.age * 4, age4xProperty.value)

        age2xProperty.value = 26
        assertEquals(13, person.age)
        assertEquals(52, age4xProperty.value)
        assertEquals(13.0.pow(2.0), agePowerProperty.value)
    }

    class Person(
        firstName: String,
        lastName: String,
        age: Int
    ) {
        val firstNameProperty = property(firstName)
        var firstName by firstNameProperty

        val lastNameProperty: ReadOnlyProperty<String> = property(lastName)
        val lastName by lastNameProperty

        private val ageProperty = property(age)
        var age by ageProperty

        fun getAgeMultiplier(factor: Int): Property<Int> {
            return property(object : FunctionAccessor<Int> {
                override fun set(value: Int): Boolean {
                    ageProperty.value = value / factor
                    return true
                }

                override fun get(): Int {
                    return ageProperty.value * factor
                }
            }, ageProperty)
        }

        fun getAgeReader(power: Double): ReadOnlyProperty<Double> {
            return ageProperty.mapBinding { it.toDouble().pow(power) }
        }
    }
}