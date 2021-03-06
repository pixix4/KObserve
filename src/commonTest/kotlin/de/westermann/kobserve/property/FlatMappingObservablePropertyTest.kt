package de.westermann.kobserve.property

import de.westermann.kobserve.base.ObservableProperty
import de.westermann.kobserve.base.ObservableValue
import kotlin.math.pow
import kotlin.test.Test
import kotlin.test.assertEquals

class FlatMappingObservablePropertyTest {

    @Test
    fun flatReceiverTest() {
        val personProperty = property(Person("John", "Doe", 21))
        var person by personProperty

        val firstNameProperty = personProperty.flatMapMutableBinding(Person::firstNameProperty)
        val lastNameProperty = personProperty.flatMapBinding(Person::lastNameProperty)

        val age2xProperty = personProperty.flatMapMutableBinding { it.getAgeMultiplier(2) }
        val age4xProperty = personProperty.flatMapBinding { it.getAgeMultiplier(4) }
        val agePowerProperty = personProperty.flatMapBinding { it.getAgeReader(2.0) }

        assertEquals(person.age * 2, age2xProperty.value)
        assertEquals(person.age * 4, age4xProperty.value)


        var firstName by firstNameProperty
        val lastName by lastNameProperty

        var age2x by age2xProperty
        val agePower by agePowerProperty

        person.age = 22

        assertEquals("Doe", lastNameProperty.value)
        assertEquals("Doe", lastName)
        assertEquals(person.age * 2, age2xProperty.value)
        assertEquals(person.age * 2, age2x)
        assertEquals(person.age * 4, age4xProperty.value)
        assertEquals(person.age.toDouble().pow(2.0), agePowerProperty.value)
        assertEquals(person.age.toDouble().pow(2.0), agePower)

        person = Person("Max", "Mustermann", 25)

        assertEquals("Max", firstNameProperty.value)
        assertEquals("Max", firstName)
        firstName = "Maxa"
        firstNameProperty.value = "Maxa"
        assertEquals("Maxa", firstName)
        assertEquals(person.age * 2, age2xProperty.value)
        assertEquals(person.age * 4, age4xProperty.value)

        age2xProperty.value = 26
        age2x = 26
        assertEquals(13, person.age)
        assertEquals(52, age4xProperty.value)
        assertEquals(26, age2x)
        assertEquals(13.0.pow(2.0), agePowerProperty.value)
    }

    @Test
    fun nullableFlatReceiverTest() {
        val personProperty = property<Person?>(Person("John", "Doe", 21))
        var person by personProperty

        val firstNameProperty = personProperty.nullableFlatMapBinding(Person::firstNameProperty)
        val lastNameProperty = personProperty.nullableFlatMapBinding { it?.lastNameProperty }

        val age2xProperty = personProperty.nullableFlatMapBinding { it?.getAgeMultiplier(2) }
        val age4xProperty = personProperty.nullableFlatMapBinding { it?.getAgeMultiplier(4) }
        val agePowerProperty = personProperty.nullableFlatMapBinding { it?.getAgeReader(2.0) }

        assertEquals((person?.age ?: -1) * 2, age2xProperty.value)
        assertEquals((person?.age ?: -1) * 4, age4xProperty.value)


        val firstName by firstNameProperty
        val lastName by lastNameProperty

        val age2x by age2xProperty
        val agePower by agePowerProperty

        person?.age = 22

        assertEquals("Doe", lastNameProperty.value)
        assertEquals("Doe", lastName)
        assertEquals((person?.age ?: -1) * 2, age2xProperty.value)
        assertEquals((person?.age ?: -1) * 2, age2x)
        assertEquals((person?.age ?: -1) * 4, age4xProperty.value)
        assertEquals((person?.age ?: -1).toDouble().pow(2.0), agePowerProperty.value)
        assertEquals((person?.age ?: -1).toDouble().pow(2.0), agePower)

        person = Person("Max", "Mustermann", 25)

        assertEquals("Max", firstNameProperty.value)
        assertEquals("Max", firstName)
        person?.firstName = "Maxa"
        person?.firstNameProperty?.value = "Maxa"
        assertEquals("Maxa", firstName)
        assertEquals((person?.age ?: -1) * 2, age2xProperty.value)
        assertEquals((person?.age ?: -1) * 4, age4xProperty.value)

        person?.getAgeMultiplier(2)?.value = 26
        assertEquals(13, person?.age)
        assertEquals(52, age4xProperty.value)
        assertEquals(26, age2x)
        assertEquals(13.0.pow(2.0), agePowerProperty.value)
    }

    class Person(
        firstName: String,
        lastName: String,
        age: Int
    ) {
        val firstNameProperty = property(firstName)
        var firstName by firstNameProperty

        val lastNameProperty: ObservableValue<String> = property(lastName)
        val lastName by lastNameProperty

        private val ageProperty = property(age)
        var age by ageProperty

        fun getAgeMultiplier(factor: Int): ObservableProperty<Int> {
            return property(object : DelegatePropertyAccessor<Int> {
                override fun set(value: Int) {
                    ageProperty.value = value / factor
                }

                override fun get(): Int {
                    return ageProperty.value * factor
                }
            }, ageProperty)
        }

        fun getAgeReader(power: Double): ObservableValue<Double> {
            return ageProperty.mapBinding { it.toDouble().pow(power) }
        }
    }
}