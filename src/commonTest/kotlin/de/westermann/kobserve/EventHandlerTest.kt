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

        var count = 0
        handler.onAttach = { count += 1 }
        handler.onDetach = { fail() }
        val listener: (Int) -> Unit = {}
        assertEquals(0, count)
        handler.addListener {}
        assertEquals(1, count)
        handler += listener
        assertEquals(2, count)
        assertEquals(2, handler.size, "Listener was not added!")
    }

    @Test
    fun addListenerMultipleTimesTest() {
        assertEquals(0, handler.size, "Handler was not empty!")
        assertTrue(handler.isEmpty(), "Handler was not empty!")

        val listener = handler.addListener {}
        assertNotNull(listener)

        val nullListener = handler.addListener(listener)
        assertNull(nullListener)
        assertNull(handler.reference(listener))
        assertEquals(1, handler.size, "Listener was not added!")
        assertFalse(handler.isEmpty(), "Listener was not added!")
    }

    @Test
    fun removeListenerTest() {
        assertEquals(0, handler.size, "Handler was not empty!")

        val listener = handler.addListener {
            fail("The listener was not removed!")
        }
        assertNotNull(listener)
        assertEquals(1, handler.size, "Listener was not added!")
        assertFalse(handler.isEmpty(), "Listener was not added!")

        var count = 0
        handler.onDetach = { count += 1 }
        handler.onAttach = { fail() }
        assertEquals(0, count)

        handler.removeListener(listener)
        assertEquals(0, handler.size, "Listener was not removed!")
        assertTrue(handler.isEmpty(), "Listener was not removed!")

        assertEquals(1, count)

        handler -= listener

        assertEquals(1, count)

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

    @Test
    fun referenceTest() {
        val reference = handler.reference { }

        assertNotNull(reference)
        assertTrue(reference.isAdded)
    }

    @Test
    fun multipleListenersTest() {
        var listener1Count = 0
        val listener1: (Int) -> Unit = { listener1Count += it }
        var listener2Count = 0
        val listener2: (Int) -> Unit = { listener2Count += it }
        var listener3Count = 0
        val listener3: (Int) -> Unit = { listener3Count += it }

        handler += listener1
        handler += listener2
        handler += listener3

        handler.emit(5)

        assertEquals(5, listener1Count)
        assertEquals(5, listener2Count)
        assertEquals(5, listener3Count)

        assertTrue(handler.containsAll(listOf(listener1, listener2, listener3)))

        var elementsInIterator = 0
        for (listener in handler) {
            elementsInIterator++
        }
        assertEquals(3, elementsInIterator)
    }

    @Test
    fun withDependenciesTest() {
        val second = EventHandler(handler)

        var handlerCount = 0
        var secondCount = 0

        handler { handlerCount++ }
        second { secondCount++ }

        handler.emit(1)
        second.emit(2)

        assertEquals(1, handlerCount)
        assertEquals(2, secondCount)
    }
}
