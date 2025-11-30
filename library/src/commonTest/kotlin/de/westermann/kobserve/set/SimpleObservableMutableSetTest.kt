package de.westermann.kobserve.set

import de.westermann.kobserve.base.ObservableMutableSet
import kotlin.test.*

class SimpleObservableMutableSetTest {

    private lateinit var observableSet: ObservableMutableSet<Int>
    private lateinit var reconstructionSet: ReconstructionSet<Int>

    @BeforeTest
    fun setup() {
        observableSet = observableSetOf(1, 2, 3, 4, 5, 1, 2, 3, 4, 5)
        reconstructionSet = ReconstructionSet(observableSet)
    }

    @Test
    fun initTest() {
        val s1 = setProperty(mutableSetOf(1, 2, 3, 4, 5))
        val s2 = mutableSetOf(1, 2, 3, 4, 5).asObservable()

        assertEquals(observableSet, s1)
        assertEquals(observableSet, s2)
    }

    @Test
    fun sizeTest() {
        assertEquals(5, observableSet.size)
    }

    @Test
    fun containsTest() {
        assertTrue(observableSet.contains(3))
        assertFalse(observableSet.contains(8))
    }

    @Test
    fun containsAllTest() {
        assertTrue(observableSet.containsAll(listOf(3, 5, 1)))
        assertFalse(observableSet.containsAll(listOf(3, 4, 8)))
        assertTrue(observableSet.containsAll(listOf()))
    }

    @Test
    fun isEmptyTest() {
        assertFalse(observableSet.isEmpty())

        observableSet.clear()

        assertTrue(observableSet.isEmpty())
    }

    @Test
    fun toStringTest() {
        observableSet.clear()
        observableSet.add(1)
        observableSet.add(2)
        observableSet.add(3)

        val possibleToStringValues = listOf(
            "[1, 2, 3]",
            "[1, 3, 2]",
            "[2, 1, 3]",
            "[2, 3, 1]",
            "[3, 1, 2]",
            "[3, 2, 1]"
        )
        assertTrue(observableSet.toString() in possibleToStringValues)
    }

    @Test
    fun equalsTest() {
        assertEquals(observableSet, observableSet)
        assertEquals(observableSet, setOf(1, 2, 3, 4, 5))
        assertEquals(observableSet, observableSetOf(1, 2, 3, 4, 5))

        assertFalse(observableSet.equals("Test"))
        assertFalse(observableSet.equals(null))
        assertNotEquals(observableSet, setOf(1, 2, 5, 8))
        assertNotEquals(observableSet, observableSetOf(1, 2, 5, 8))
    }

    @Test
    fun hashCodeTest() {
        assertEquals(observableSet.hashCode(), observableSet.hashCode())

        assertEquals(observableSet.hashCode(), setOf(1, 2, 3, 4, 5).hashCode())
        assertEquals(observableSet.hashCode(), observableSetOf(1, 2, 3, 4, 5).hashCode())

        assertNotEquals(observableSet.hashCode(), setOf(1, 2, 5, 8).hashCode())
        assertNotEquals(observableSet.hashCode(), observableSetOf(1, 2, 5, 8).hashCode())
    }

    @Test
    fun iteratorTest() {
        val content = mutableMapOf<Int, Int>()

        for (element in observableSet) {
            val count = content[element] ?: 0
            content[element] = count + 1
        }

        assertEquals(5, content.size)
        assertTrue(content.values.all { it == 1 })
        assertEquals(observableSet, content.keys)
    }

    @Test
    fun mutableIteratorTest() {
        val content = mutableMapOf<Int, Int>()

        val iterator = observableSet.iterator()
        while (iterator.hasNext()) {
            val element = iterator.next()

            val count = content[element] ?: 0
            content[element] = count + 1

            if (element in setOf(2, 3, 4)) {
                iterator.remove()
            }
        }

        assertEquals(5, content.size)
        assertTrue(content.values.all { it == 1 })
        assertTrue(content.keys.containsAll(observableSet))

        assertEquals(setOf(1, 5), observableSet)
    }

    @Test
    fun clearTest() {
        observableSet.clear()

        assertEquals<Set<Int>>(emptySet(), observableSet)
    }

    @Test
    fun addTest() {
        assertTrue(observableSet.add(6))
        assertFalse(observableSet.add(6))

        assertEquals<Set<Int>>(setOf(1, 2, 3, 4, 5, 6), observableSet)
    }

    @Test
    fun addAllTest() {
        assertTrue(observableSet.addAll(listOf(4, 5, 6, 7)))
        assertFalse(observableSet.addAll(listOf(1, 2, 6)))

        assertEquals<Set<Int>>(setOf(1, 2, 3, 4, 5, 6, 7), observableSet)
    }

    @Test
    fun removeTest() {
        assertTrue(observableSet.remove(5))
        assertFalse(observableSet.remove(5))

        assertEquals<Set<Int>>(setOf(1, 2, 3, 4), observableSet)
    }

    @Test
    fun removeAllTest() {
        assertTrue(observableSet.removeAll(listOf(4, 5, 6, 7)))
        assertFalse(observableSet.removeAll(listOf(4, 5, 8)))

        assertEquals<Set<Int>>(setOf(1, 2, 3), observableSet)
    }

    @Test
    fun retainAllTest() {
        assertTrue(observableSet.retainAll(listOf(4, 5, 6, 7)))
        assertFalse(observableSet.retainAll(listOf(4, 5, 8)))

        assertEquals<Set<Int>>(setOf(4, 5), observableSet)
    }

    @Test
    fun invalidateTest() {
        observableSet.invalidate()

        assertEquals(setOf(1, 2, 3, 4, 5), observableSet)
    }
}
