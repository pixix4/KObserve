package de.westermann.kobserve.property

import kotlin.test.Test
import kotlin.test.assertEquals

class ConstantObservableValueTest {

    val property = constObservable(5)

    @Test
    fun constPropertyTest() {
        var counter = 0
        property.onChange {
            counter++
        }
        property.invalidate()
        assertEquals(5, property.value)
        assertEquals(0, counter)

        val value by property
        assertEquals(5, value)
    }
}
