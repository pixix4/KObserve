package de.westermann.kobserve.property

import de.westermann.kobserve.Property
import de.westermann.kobserve.ValidationProperty
import kotlin.test.*

class SimpleValidationPropertyTest {

    lateinit var property: Property<Int>
    lateinit var validator: ValidationProperty<Int>

    @BeforeTest
    fun setup() {
        property = property(5)
        validator = property.validate { it in 0..9 }
    }

    @Test
    fun validTest() {
        assertEquals(5, validator.value)
        assertTrue(validator.valid)

        validator.value = 8

        assertEquals(8, validator.value)
        assertTrue(validator.valid)
    }

    @Test
    fun invalidTest() {
        assertEquals(5, validator.value)
        assertTrue(validator.valid)

        validator.value = 18

        assertEquals(5, validator.value)
        assertFalse(validator.valid)

        validator.invalidate()

        assertEquals(5, validator.value)
        assertTrue(validator.valid)
    }

    @Test
    fun test() {
        var value by validator
        assertEquals(5, value)
        value = 6
        assertEquals(6, value)

        val p = property(8)

        validator.bind(p)
        validator.unbind()
        validator.bindBidirectional(p)
        validator.unbind()
    }
}