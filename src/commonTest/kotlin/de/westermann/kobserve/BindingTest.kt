package de.westermann.kobserve

import de.westermann.kobserve.basic.property
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class BindingTest {

    @Test
    fun testReadOnlyBinding() {
        val stateProperty = property(0)
        val indicatorProperty = property(5)

        var stateCalls = 0
        var indicatorCalls = 0

        stateProperty.onChange {
            stateCalls += 1
        }

        indicatorProperty.onChange {
            indicatorCalls += 1
        }

        assertEquals(0, stateCalls)
        assertEquals(0, indicatorCalls)

        assertFailsWith(IllegalStateException::class) {
            indicatorProperty.binding.unbind()
        }
        assertFailsWith(IllegalStateException::class) {
            indicatorProperty.unbind()
        }
        assertFailsWith(IllegalStateException::class) {
            stateProperty.unbind()
        }

        indicatorProperty.bind(stateProperty)

        assertFailsWith(IllegalStateException::class) {
            indicatorProperty.bind(stateProperty)
        }

        assertEquals(0, stateProperty.value)
        assertEquals(0, indicatorProperty.value)
        assertEquals(0, stateCalls)
        assertEquals(1, indicatorCalls)

        stateProperty.set(1)

        assertEquals(1, stateProperty.value)
        assertEquals(1, indicatorProperty.value)
        assertEquals(1, stateCalls)
        assertEquals(2, indicatorCalls)

        assertFailsWith(IllegalStateException::class) {
            indicatorProperty.value = 2
        }

        assertEquals(1, stateProperty.value)
        assertEquals(1, indicatorProperty.value)
        assertEquals(1, stateCalls)
        assertEquals(2, indicatorCalls)

        indicatorProperty.unbind()

        stateProperty.set(3)

        assertEquals(3, stateProperty.value)
        assertEquals(1, indicatorProperty.value)
        assertEquals(2, stateCalls)
        assertEquals(2, indicatorCalls)
    }

    @Test
    fun testBidrectionalBinding() {
        val stateProperty = property(0)
        val indicatorProperty = property(5)

        var stateCalls = 0
        var indicatorCalls = 0

        stateProperty.onChange {
            stateCalls += 1
        }

        indicatorProperty.onChange {
            indicatorCalls += 1
        }

        assertEquals(0, stateCalls)
        assertEquals(0, indicatorCalls)

        assertFailsWith(IllegalStateException::class) {
            indicatorProperty.unbind()
        }
        assertFailsWith(IllegalStateException::class) {
            stateProperty.unbind()
        }

        indicatorProperty.bindBidirectional(stateProperty)

        assertFailsWith(IllegalStateException::class) {
            indicatorProperty.bindBidirectional(stateProperty)
        }

        assertEquals(0, stateProperty.value)
        assertEquals(0, indicatorProperty.value)
        assertEquals(0, stateCalls)
        assertEquals(1, indicatorCalls)

        stateProperty.set(1)

        assertEquals(1, stateProperty.value)
        assertEquals(1, indicatorProperty.value)
        assertEquals(1, stateCalls)
        assertEquals(2, indicatorCalls)

        indicatorProperty.value = 2

        assertEquals(2, stateProperty.value)
        assertEquals(2, indicatorProperty.value)
        assertEquals(2, stateCalls)
        assertEquals(3, indicatorCalls)

        indicatorProperty.unbind()

        stateProperty.set(3)
        indicatorProperty.set(4)

        assertEquals(3, stateProperty.value)
        assertEquals(4, indicatorProperty.value)
        assertEquals(3, stateCalls)
        assertEquals(4, indicatorCalls)
    }
}
