package de.westermann.kobserve

import kotlin.test.*

class EventHandlerTest {

    lateinit var handler: EventHandler<Int>

    @BeforeTest
    fun setup() {
        handler = EventHandler()
    }

    @Test
    fun addListenerTest() {
        assertEquals(0, handler.size, "Handler was not empty!")

        handler.addListener {}
        assertEquals(1, handler.size, "Listener was not added!")
    }

    @Test
    fun addListenerMultipeTimesTest() {
        assertEquals(0, handler.size, "Handler was not empty!")

        val listener = handler.addListener {}
        handler.addListener(listener)
        assertEquals(1, handler.size, "Listener was not added!")
    }

    @Test
    fun removeListenerTest() {
        assertEquals(0, handler.size, "Handler was not empty!")

        val listener = handler.addListener {
            fail("The listener was not removed!")
        }
        assertEquals(1, handler.size, "Listener was not added!")

        handler.removeListener(listener)
        assertEquals(0, handler.size, "Listener was not removed!")

        handler.emit(0)
    }

    @Test
    fun emitTest() {
        var sum = 0

        handler.addListener {
            sum += it
        }

        handler.emit(5)

        assertEquals(5, sum, "Event listener was not executed!")
    }

    @Test
    fun clearListenersTest() {
        assertEquals(0, handler.size, "Handler was not empty!")

        handler.addListener { }
        handler.addListener { }
        handler.addListener { }
        assertEquals(3, handler.size, "Listener was not added!")

        handler.clearListeners()
        assertEquals(0, handler.size, "Handler was not cleared!")
    }
}