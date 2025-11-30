package de.westermann.kobserve.event

import kotlin.test.*

class EventListenerTest {

    lateinit var handler: EventHandler<Int>
    lateinit var reference: EventListener<Int>
    var callCount: Int = 0

    @BeforeTest
    fun setup() {
        handler = EventHandler()
        callCount = 0
        reference = handler.reference {
            callCount += 1
        }
    }

    @Test
    fun triggerTest() {
        assertEquals(0, callCount)
        reference.emit(5)
        assertEquals(1, callCount)
    }

    @Test
    fun stateTest() {
        assertTrue(reference.isAttached)

        assertTrue(reference.detach())

        assertFalse(reference.isAttached)

        assertFalse(reference.detach())

        assertTrue(reference.attach())

        assertTrue(reference.isAttached)

        assertFalse(reference.attach())
    }
}
