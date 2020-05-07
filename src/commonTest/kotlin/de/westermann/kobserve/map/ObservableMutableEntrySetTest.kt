package de.westermann.kobserve.map

import de.westermann.kobserve.base.ObservableMutableMap
import de.westermann.kobserve.base.ObservableMutableSet
import kotlin.test.*

class ObservableMutableEntrySetTest {

    private lateinit var observableMap: ObservableMutableMap<Int, Int>
    private lateinit var reconstructionMap: ReconstructionMap<Int, Int>

    private lateinit var entrySet: ObservableMutableSet<MutableMap.MutableEntry<Int, Int>>

    @BeforeTest
    fun setup() {
        observableMap = observableMapOf(
            1 to 2,
            3 to 4,
            5 to 6
        )
        reconstructionMap = ReconstructionMap(observableMap)

        entrySet = observableMap.entries
    }


    @Test
    fun sizeTest() {
        assertEquals(3, entrySet.size)
    }

    @Test
    fun containsTest() {
        assertTrue(entrySet.contains(MutableMapEntry(3, 4, observableMap::put)))
        assertFalse(entrySet.contains(MutableMapEntry(4, 5, observableMap::put)))
    }

    @Test
    fun isEmptyTest() {
        assertFalse(entrySet.isEmpty())

        entrySet.clear()

        assertTrue(entrySet.isEmpty())
    }

    @Test
    fun toStringTest() {
        val possibleToStringValues = listOf(
            "[1=2, 3=4, 5=6]",
            "[1=2, 5=6, 3=4]",
            "[3=4, 1=2, 5=6]",
            "[3=4, 5=6, 1=2]",
            "[5=6, 1=2, 3=4]",
            "[5=6, 3=4, 1=2]"
        )
        assertTrue(entrySet.toString() in possibleToStringValues)
    }

    @Test
    fun equalsTest() {
        assertEquals(entrySet, entrySet)
        assertEquals(
            entrySet, mapOf(
                1 to 2,
                3 to 4,
                5 to 6
            ).entries
        )
        assertEquals(
            entrySet, observableMapOf(
                1 to 2,
                3 to 4,
                5 to 6
            ).entries
        )

        assertFalse(entrySet.equals("Test"))
        assertFalse(entrySet.equals(null))
        assertNotEquals(
            entrySet, mapOf(
                1 to 2,
                4 to 8,
                5 to 6
            ).entries
        )
        assertNotEquals(
            entrySet, observableMapOf(
                1 to 2,
                4 to 8,
                5 to 6
            ).entries
        )
    }

    @Test
    fun hashCodeTest() {
        assertEquals(entrySet.hashCode(), entrySet.hashCode())

        assertEquals(
            entrySet.hashCode(), mapOf(
                1 to 2,
                3 to 4,
                5 to 6
            ).entries.hashCode()
        )
        assertEquals(
            entrySet.hashCode(), observableMapOf(
                1 to 2,
                3 to 4,
                5 to 6
            ).entries.hashCode()
        )

        assertNotEquals(
            entrySet.hashCode(), mapOf(
                1 to 2,
                4 to 8,
                5 to 6
            ).entries.hashCode()
        )
        assertNotEquals(
            entrySet.hashCode(), observableMapOf(
                1 to 2,
                4 to 8,
                5 to 6
            ).entries.hashCode()
        )
    }

    @Test
    fun iteratorTest() {
        val content = mutableMapOf<Int, Int>()

        for (element in entrySet) {
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

        val iterator = entrySet.iterator()
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

        assertEquals(
            mapOf(
                1 to 2,
                5 to 6
            ).entries, entrySet
        )
    }

    @Test
    fun clearTest() {
        entrySet.clear()

        assertEquals(emptyMap<Int, Int>().entries, entrySet)
    }

    @Test
    fun putTest() {
        assertFails {
            entrySet.add(MutableMapEntry(7, 8, observableMap::put))
        }

        assertEquals(
            mapOf(
                1 to 2,
                3 to 4,
                5 to 6
            ).entries, entrySet
        )
    }

    @Test
    fun putAllTest() {
        assertFails {
            entrySet.addAll(listOf(
                MutableMapEntry(7, 8, observableMap::put),
                MutableMapEntry(9, 10, observableMap::put)
            ))
        }

        assertEquals(
            mapOf(
                1 to 2,
                3 to 4,
                5 to 6
            ).entries, entrySet
        )
    }

    @Test
    fun removeTest() {
        assertTrue(entrySet.remove(MutableMapEntry(3,4, observableMap::put)))
        assertFalse(entrySet.remove(MutableMapEntry(3,4, observableMap::put)))

        assertEquals(
            mapOf(
                1 to 2,
                5 to 6
            ).entries, entrySet
        )
    }

    @Test
    fun removeAllTest() {
        assertTrue(entrySet.removeAll(listOf(MutableMapEntry(3,4, observableMap::put))))
        assertFalse(entrySet.removeAll(listOf(MutableMapEntry(3,4, observableMap::put))))

        assertEquals(
            mapOf(
                1 to 2,
                5 to 6
            ).entries, entrySet
        )
    }

    @Test
    fun retainAllTest() {
        assertTrue(entrySet.retainAll(listOf(MutableMapEntry(3,4, observableMap::put))))
        assertFalse(entrySet.retainAll(listOf(MutableMapEntry(3,4, observableMap::put))))

        assertEquals(
            mapOf(
                3 to 4
            ).entries, entrySet
        )
    }

    @Test
    fun invalidateTest() {
        entrySet.invalidate()

        assertEquals(
            mapOf(
                1 to 2,
                3 to 4,
                5 to 6
            ).entries, entrySet
        )
    }
}
