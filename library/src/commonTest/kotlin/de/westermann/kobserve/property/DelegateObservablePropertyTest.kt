package de.westermann.kobserve.property

import kotlin.test.Test
import kotlin.test.assertEquals

class DelegateObservablePropertyTest {

    @Test
    fun functionTest() {
        val person = Person()
        assertEquals(person.ageProperty.value * 2, person.age2Property.value)
        assertEquals(person.ageProperty.value * 3, person.age3Property.value)
        assertEquals(person.ageProperty.value * 4, person.age4Property.value)
    }

    class Person() {
        val ageProperty = property(21)
        private var age by ageProperty

        val age2Property = property(ageProperty) {
            age * 2
        }
        val age3Property = property(object : DelegateValueAccessor<Int> {
            override fun get(): Int {
                return age * 3
            }
        })
        val age4Property = property(object : DelegatePropertyAccessor<Int> {
            override fun get(): Int {
                return age * 4
            }

            override fun set(value: Int) {
                age = value / 4
            }
        })
    }
}
