package de.westermann.kobserve

import de.westermann.kobserve.basic.FunctionAccessor
import de.westermann.kobserve.basic.FunctionReadOnlyAccessor
import de.westermann.kobserve.basic.property
import kotlin.test.Test
import kotlin.test.assertEquals

class FunctionPropertyTest {

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
        val age3Property = property(object : FunctionReadOnlyAccessor<Int> {
            override fun get(): Int {
                return age * 3
            }
        })
        val age4Property = property(object : FunctionAccessor<Int> {
            override fun get(): Int {
                return age * 4
            }

            override fun set(value: Int): Boolean {
                age = value / 4
                return true
            }
        })
    }
}
