package de.westermann.kobserve

import kotlin.test.*

class ListenerReferenceTest {

    lateinit var handler: EventHandler<Int>
    lateinit var reference: ListenerReference<Int>
    var callCount: Int = 0

    @BeforeTest
    fun setup() {
        handler = EventHandler()
        callCount = 0
        reference = handler.reference {
            callCount += 1
        }!!
    }

    @Test
    fun triggerTest() {
        assertEquals(0, callCount)
        reference.trigger(5)
        assertEquals(1, callCount)
    }

    @Test
    fun stateTest() {
        assertTrue(reference.isAdded)
        assertFalse(reference.isRemoved)

        reference.remove()

        assertFalse(reference.isAdded)
        assertTrue(reference.isRemoved)

        reference.add()

        assertTrue(reference.isAdded)
        assertFalse(reference.isRemoved)
    }
}
