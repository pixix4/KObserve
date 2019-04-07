package de.westermann.kobserve.property

import kotlin.test.Test
import kotlin.test.assertEquals

class ObjectPropertyTest {

    @Test
    fun objectPropertyTest() {
        val testProperty = 1.observe()
        var test by testProperty

        assertEquals(1, test)

        var delayedValue = test

        assertEquals(1, delayedValue)

        testProperty.onChange {
            delayedValue = test
        }

        test = 2

        testProperty.invalidate()

        assertEquals(2, test)
        assertEquals(2, delayedValue)
    }
}
