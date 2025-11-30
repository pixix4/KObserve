package de.westermann.kobserve.event

import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class EventBusTest {

    lateinit var bus: EventBus

    @BeforeTest
    fun setup() {
        bus = EventBus()
    }

    @Test
    fun reifiedBusTest() {
        var intSum = 0
        val intListener = bus.subscribe<Int> {
            intSum += it
        }

        var doubleSum = 0.0
        val numberListener = bus.subscribe<Number> {
            doubleSum += it.toDouble()
        }

        var str = ""
        val stringListener = bus.subscribeReference<String> {
            str += it
        }

        val handler = bus.handler<String>()

        bus.emit(5)
        bus.emit(3.0)
        bus.emit("Lorem")

        assertEquals(5, intSum)
        assertEquals(8.0, doubleSum)
        assertEquals("Lorem", str)
        assertEquals(1, handler.size)

        bus.unsubscribe(intListener)

        bus.emit("Ipsum")
        bus.emit(2)

        assertEquals(5, intSum)
        assertEquals(10.0, doubleSum)
        assertEquals("LoremIpsum", str)

        bus.unsubscribe(numberListener)
        stringListener.detach()

        bus.emit(5)
        bus.emit(3.0)
        bus.emit("Lorem")

        assertEquals(5, intSum)
        assertEquals(10.0, doubleSum)
        assertEquals("LoremIpsum", str)
        assertEquals(0, handler.size)
    }

    @Test
    fun typeBusTest() {
        var intSum = 0
        val intListener = bus.subscribe(Int::class) {
            intSum += it
        }

        var doubleSum = 0.0
        val numberListener = bus.subscribe(Number::class) {
            doubleSum += it.toDouble()
        }

        var str = ""
        val stringListener = bus.subscribeReference(String::class) {
            str += it
        }

        val handler = bus.handler(String::class)

        bus.emit(5)
        bus.emit(3.0)
        bus.emit("Lorem")

        assertEquals(5, intSum)
        assertEquals(8.0, doubleSum)
        assertEquals("Lorem", str)
        assertEquals(1, handler.size)

        bus.unsubscribe(intListener)

        bus.emit("Ipsum")
        bus.emit(2)

        assertEquals(5, intSum)
        assertEquals(10.0, doubleSum)
        assertEquals("LoremIpsum", str)

        bus.unsubscribe(numberListener)
        stringListener.detach()

        bus.emit(5)
        bus.emit(3.0)
        bus.emit("Lorem")

        assertEquals(5, intSum)
        assertEquals(10.0, doubleSum)
        assertEquals("LoremIpsum", str)
        assertEquals(0, handler.size)
    }

    @Test
    fun globalBusTest() {
        var intSum = 0
        val intListener = subscribe<Int> {
            intSum += it
        }

        var doubleSum = 0.0
        val numberListener = subscribe<Number> {
            doubleSum += it.toDouble()
        }

        var str = ""
        val stringListener = subscribeReference<String> {
            str += it
        }

        val handler = GlobalEventBus.handler<String>()

        emit(5)
        emit(3.0)
        emit("Lorem")

        assertEquals(5, intSum)
        assertEquals(8.0, doubleSum)
        assertEquals("Lorem", str)
        assertEquals(1, handler.size)

        unsubscribe(intListener)

        emit("Ipsum")
        emit(2)

        assertEquals(5, intSum)
        assertEquals(10.0, doubleSum)
        assertEquals("LoremIpsum", str)

        unsubscribe(numberListener)
        stringListener.detach()

        emit(5)
        emit(3.0)
        emit("Lorem")

        assertEquals(5, intSum)
        assertEquals(10.0, doubleSum)
        assertEquals("LoremIpsum", str)
        assertEquals(0, handler.size)
    }
}
