package de.westermann.kobserve.map

import de.westermann.kobserve.base.ObservableMutableMap
import kotlin.test.*

class SimpleObservableMutableMapTest {

    private lateinit var observableMap: ObservableMutableMap<Int, Int>
    private lateinit var reconstructionMap: ReconstructionMap<Int, Int>

    @BeforeTest
    fun setup() {
        observableMap = observableMapOf(
            1 to 2,
            3 to 4,
            5 to 6
        )
        reconstructionMap = ReconstructionMap(observableMap)
    }

    @Test
    fun initTest() {
        val s1 = mapProperty(
            mutableMapOf(
                1 to 2,
                3 to 4,
                5 to 6
            )
        )
        val s2 = mutableMapOf(
            1 to 2,
            3 to 4,
            5 to 6
        ).asObservable()

        assertEquals(observableMap, s1)
        assertEquals(observableMap, s2)
    }

    @Test
    fun sizeTest() {
        assertEquals(3, observableMap.size)
    }

    @Test
    fun containsKeyTest() {
        assertTrue(observableMap.containsKey(3))
        assertFalse(observableMap.containsKey(4))
    }

    @Test
    fun containsValueTest() {
        assertTrue(observableMap.containsValue(4))
        assertFalse(observableMap.containsValue(3))
    }

    @Test
    fun isEmptyTest() {
        assertFalse(observableMap.isEmpty())

        observableMap.clear()

        assertTrue(observableMap.isEmpty())
    }

    @Test
    fun toStringTest() {
        val possibleToStringValues = listOf(
            "{1=2, 3=4, 5=6}",
            "{1=2, 5=6, 3=4}",
            "{3=4, 1=2, 5=6}",
            "{3=4, 5=6, 1=2}",
            "{5=6, 1=2, 3=4}",
            "{5=6, 3=4, 1=2}"
        )
        assertTrue(observableMap.toString() in possibleToStringValues)
    }

    @Test
    fun equalsTest() {
        assertEquals(observableMap, observableMap)
        assertEquals(
            observableMap, mapOf(
                1 to 2,
                3 to 4,
                5 to 6
            )
        )
        assertEquals(
            observableMap, observableMapOf(
                1 to 2,
                3 to 4,
                5 to 6
            )
        )

        assertFalse(observableMap.equals("Test"))
        assertFalse(observableMap.equals(null))
        assertNotEquals(
            observableMap, mapOf(
                1 to 2,
                4 to 8,
                5 to 6
            )
        )
        assertNotEquals(
            observableMap, observableMapOf(
                1 to 2,
                4 to 8,
                5 to 6
            )
        )
    }

    @Test
    fun hashCodeTest() {
        assertEquals(observableMap.hashCode(), observableMap.hashCode())

        assertEquals(
            observableMap.hashCode(), mapOf(
                1 to 2,
                3 to 4,
                5 to 6
            ).hashCode()
        )
        assertEquals(
            observableMap.hashCode(), observableMapOf(
                1 to 2,
                3 to 4,
                5 to 6
            ).hashCode()
        )

        assertNotEquals(
            observableMap.hashCode(), mapOf(
                1 to 2,
                4 to 8,
                5 to 6
            ).hashCode()
        )
        assertNotEquals(
            observableMap.hashCode(), observableMapOf(
                1 to 2,
                4 to 8,
                5 to 6
            ).hashCode()
        )
    }

    @Test
    fun iteratorTest() {
        val content = mutableMapOf<Int, Int>()

        for (element in observableMap) {
            val count = content[element.key] ?: 0
            content[element.key] = count + 1
        }

        assertEquals(3, content.size)
        assertTrue(content.values.all { it == 1 })
        assertEquals(observableMap.keys, content.keys)
    }

    @Test
    fun mutableIteratorTest() {
        val content = mutableMapOf<Int, Int>()

        val iterator = observableMap.iterator()
        while (iterator.hasNext()) {
            val element = iterator.next()

            val count = content[element.key] ?: 0
            content[element.key] = count + 1

            if (element.key == 3) {
                iterator.remove()
            }
        }

        assertEquals(3, content.size)
        assertTrue(content.values.all { it == 1 })
        assertTrue(content.keys.containsAll(observableMap.keys))

        assertEquals(mapOf(
            1 to 2,
            5 to 6
        ), observableMap)
    }

    @Test
    fun clearTest() {
        observableMap.clear()

        assertEquals<Map<Int, Int>>(emptyMap(), observableMap)
    }

    @Test
    fun putTest() {
        assertNull(observableMap.put(7, 8))
        assertEquals(8, observableMap.put(7, 9))

        assertEquals<Map<Int, Int>>(mapOf(
            1 to 2,
            3 to 4,
            5 to 6,
            7 to 9
        ), observableMap)
    }

    @Test
    fun putAllTest() {
        observableMap.putAll(mapOf(
            7 to 8,
            9 to 10
        ))
        observableMap.putAll(mapOf(
            7 to 8,
            9 to 10
        ))

        assertEquals<Map<Int, Int>>(mapOf(
            1 to 2,
            3 to 4,
            5 to 6,
            7 to 8,
            9 to 10
        ), observableMap)
    }

    @Test
    fun removeTest() {
        assertEquals(4, observableMap.remove(3))
        assertNull(observableMap.remove(3))

        assertEquals<Map<Int, Int>>(mapOf(
            1 to 2,
            5 to 6
        ), observableMap)
    }

    @Test
    fun invalidateTest() {
        observableMap.invalidate()

        assertEquals(mapOf(
            1 to 2,
            3 to 4,
            5 to 6
        ), observableMap)
    }
}
