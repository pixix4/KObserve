package de.westermann.kobserve

import kotlin.test.Test
import kotlin.test.assertEquals

class MappedPropertyTest {

    @Test
    fun mappedPropertyTest() {
        val numberProperty = property(1)
        var number by numberProperty

        val squareProperty = numberProperty.map { it * it }
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
}
