package de.westermann.kobserve.map

import de.westermann.kobserve.base.ObservableMutableMap
import de.westermann.kobserve.base.ObservableMutableSet
import kotlin.test.*

class ObservableMutableKeySetTest {

    private lateinit var observableMap: ObservableMutableMap<Int, Int>
    private lateinit var reconstructionMap: ReconstructionMap<Int, Int>

    private lateinit var keySet: ObservableMutableSet<Int>

    @BeforeTest
    fun setup() {
        observableMap = observableMapOf(
            1 to 2,
            3 to 4,
            5 to 6
        )
        reconstructionMap = ReconstructionMap(observableMap)

        keySet = observableMap.keys
    }

    @Test
    fun sizeTest() {
        assertEquals(3, keySet.size)
    }

    @Test
    fun containsTest() {
        assertTrue(keySet.contains(3))
        assertFalse(keySet.contains(4))
    }

    @Test
    fun isEmptyTest() {
        assertFalse(keySet.isEmpty())

        keySet.clear()

        assertTrue(keySet.isEmpty())
    }

    @Test
    fun toStringTest() {
        val possibleToStringValues = listOf(
            "[1, 3, 5]",
            "[1, 5, 3]",
            "[3, 1, 5]",
            "[3, 5, 1]",
            "[5, 1, 3]",
            "[5, 3, 1]"
        )
        assertTrue(keySet.toString() in possibleToStringValues)
    }

    @Test
    fun equalsTest() {
        assertEquals(keySet, keySet)
        assertEquals(
            keySet, mapOf(
                1 to 2,
                3 to 4,
                5 to 6
            ).keys
        )
        assertEquals(
            keySet, observableMapOf(
                1 to 2,
                3 to 4,
                5 to 6
            ).keys
        )

        assertFalse(keySet.equals("Test"))
        assertFalse(keySet.equals(null))
        assertNotEquals(
            keySet, mapOf(
                1 to 2,
                4 to 8,
                5 to 6
            ).keys
        )
        assertNotEquals(
            keySet, observableMapOf(
                1 to 2,
                4 to 8,
                5 to 6
            ).keys
        )
    }

    @Test
    fun hashCodeTest() {
        assertEquals(keySet.hashCode(), keySet.hashCode())

        assertEquals(
            keySet.hashCode(), mapOf(
                1 to 2,
                3 to 4,
                5 to 6
            ).keys.hashCode()
        )
        assertEquals(
            keySet.hashCode(), observableMapOf(
                1 to 2,
                3 to 4,
                5 to 6
            ).keys.hashCode()
        )

        assertNotEquals(
            keySet.hashCode(), mapOf(
                1 to 2,
                4 to 8,
                5 to 6
            ).keys.hashCode()
        )
        assertNotEquals(
            keySet.hashCode(), observableMapOf(
                1 to 2,
                4 to 8,
                5 to 6
            ).keys.hashCode()
        )
    }

    @Test
    fun iteratorTest() {
        val content = mutableMapOf<Int, Int>()

        for (element in keySet) {
            val count = content[element] ?: 0
            content[element] = count + 1
        }

        assertEquals(3, content.size)
        assertTrue(content.values.all { it == 1 })
        assertEquals(observableMap.keys, content.keys)
    }

    @Test
    fun mutableIteratorTest() {
        val content = mutableMapOf<Int, Int>()

        val iterator = keySet.iterator()
        while (iterator.hasNext()) {
            val element = iterator.next()

            val count = content[element] ?: 0
            content[element] = count + 1

            if (element == 3) {
                iterator.remove()
            }
        }

        assertEquals(3, content.size)
        assertTrue(content.values.all { it == 1 })
        assertTrue(content.keys.containsAll(observableMap.keys))

        assertEquals(
            mapOf(
                1 to 2,
                5 to 6
            ).keys, keySet
        )
    }

    @Test
    fun clearTest() {
        keySet.clear()

        assertEquals(emptyMap<Int, Int>().keys, keySet)
    }

    @Test
    fun putTest() {
        assertFails {
            keySet.add(7)
        }

        assertEquals(
            mapOf(
                1 to 2,
                3 to 4,
                5 to 6
            ).keys, keySet
        )
    }

    @Test
    fun putAllTest() {
        assertFails {
            keySet.addAll(listOf(7, 9))
        }

        assertEquals(
            mapOf(
                1 to 2,
                3 to 4,
                5 to 6
            ).keys, keySet
        )
    }

    @Test
    fun removeTest() {
        assertTrue(keySet.remove(3))
        assertFalse(keySet.remove(3))

        assertEquals(
            mapOf(
                1 to 2,
                5 to 6
            ).keys, keySet
        )
    }

    @Test
    fun removeAllTest() {
        assertTrue(keySet.removeAll(listOf(3)))
        assertFalse(keySet.removeAll(listOf(3)))

        assertEquals(
            mapOf(
                1 to 2,
                5 to 6
            ).keys, keySet
        )
    }

    @Test
    fun retainAllTest() {
        assertTrue(keySet.retainAll(listOf(3)))
        assertFalse(keySet.retainAll(listOf(3)))

        assertEquals(
            mapOf(
                3 to 4
            ).keys, keySet
        )
    }

    @Test
    fun invalidateTest() {
        keySet.invalidate()

        assertEquals(
            mapOf(
                1 to 2,
                3 to 4,
                5 to 6
            ).keys, keySet
        )
    }
}
