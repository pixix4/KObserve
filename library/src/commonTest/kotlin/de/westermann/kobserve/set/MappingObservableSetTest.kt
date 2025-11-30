package de.westermann.kobserve.set

import de.westermann.kobserve.base.ObservableMutableSet
import de.westermann.kobserve.base.ObservableSet
import de.westermann.kobserve.property.property
import kotlin.test.*

class MappingObservableSetTest {

    private lateinit var observableSourceSet: ObservableMutableSet<Int>
    private lateinit var observableSet: ObservableSet<Int>
    private lateinit var reconstructionSet: ReconstructionSet<Int>

    @BeforeTest
    fun setup() {
        observableSourceSet = observableSetOf(1, 2, 3, 4, 5, 1, 2, 3, 4, 5)
        observableSet = observableSourceSet.mapObservable { -it }

        reconstructionSet = ReconstructionSet(observableSet)
    }

    @Test
    fun propertyTest() {
        val transformation = property { it: Int -> -it }
        val s1 = observableSourceSet.mapObservable(transformation)

        assertEquals(setOf(-1, -2, -3, -4, -5), s1)

        transformation.value = { it: Int -> it * 2 }

        assertEquals(setOf(2, 4, 6, 8, 10), s1)
    }

    @Test
    fun sizeTest() {
        assertEquals(5, observableSet.size)
    }

    @Test
    fun containsTest() {
        assertTrue(observableSet.contains(-2))
        assertFalse(observableSet.contains(3))
        assertFalse(observableSet.contains(-8))
    }

    @Test
    fun containsAllTest() {
        assertTrue(observableSet.containsAll(listOf(-1, -4)))
        assertFalse(observableSet.containsAll(listOf(3, -4, 8)))
        assertFalse(observableSet.containsAll(listOf(-3, -1, -8)))
        assertTrue(observableSet.containsAll(listOf()))
    }

    @Test
    fun isEmptyTest() {
        assertFalse(observableSet.isEmpty())

        observableSourceSet.clear()

        assertTrue(observableSet.isEmpty())
    }

    @Test
    fun toStringTest() {
        observableSourceSet.clear()
        observableSourceSet.add(1)
        observableSourceSet.add(2)
        observableSourceSet.add(3)

        val possibleToStringValues = listOf(
            "[-1, -2, -3]",
            "[-1, -3, -2]",
            "[-2, -1, -3]",
            "[-2, -3, -1]",
            "[-3, -1, -2]",
            "[-3, -2, -1]"
        )

        assertTrue(observableSet.toString() in possibleToStringValues)
    }

    @Test
    fun equalsTest() {
        assertEquals(observableSet, observableSet)
        assertEquals(observableSet, setOf(-1, -2, -3, -4, -5))
        assertEquals(observableSet, observableSetOf(-1, -2, -3, -4, -5))

        assertFalse(observableSet.equals("Test"))
        assertFalse(observableSet.equals(null))
        assertNotEquals(observableSet, setOf(-1))
        assertNotEquals(observableSet, observableSetOf(-1))
    }

    @Test
    fun hashCodeTest() {
        assertEquals(observableSet.hashCode(), observableSet.hashCode())

        assertEquals(observableSet.hashCode(), setOf(-1, -2, -3, -4, -5).hashCode())
        assertEquals(observableSet.hashCode(), observableSetOf(-1, -2, -3, -4, -5).hashCode())

        assertNotEquals(observableSet.hashCode(), setOf(1, -2, 5, 8).hashCode())
        assertNotEquals(observableSet.hashCode(), observableSetOf(1, -2, 5, 8).hashCode())
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
        assertEquals<Set<Int>>(observableSet, content.keys)
    }

    @Test
    fun clearTest() {
        observableSourceSet.clear()

        assertEquals<Set<Int>>(emptySet(), observableSet)
    }

    @Test
    fun addTest() {
        assertTrue(observableSourceSet.add(-1))
        assertFalse(observableSourceSet.add(-1))
        assertTrue(observableSourceSet.add(6))

        assertEquals<Set<Int>>(setOf(-6, -5, -4, -3, -2, -1, 1), observableSet)
    }

    @Test
    fun addAllTest() {
        assertTrue(observableSourceSet.addAll(listOf(4, 5, 6, 7, -1)))
        assertFalse(observableSourceSet.addAll(listOf(1, 2, 6, -1)))

        assertEquals<Set<Int>>(setOf(-7, -6, -5, -4, -3, -2, -1, 1), observableSet)
    }

    @Test
    fun removeTest() {
        assertTrue(observableSourceSet.remove(5))
        assertFalse(observableSourceSet.remove(5))

        assertTrue(observableSourceSet.remove(2))
        assertFalse(observableSourceSet.remove(2))

        assertEquals<Set<Int>>(setOf(-1, -3, -4), observableSet)
    }

    @Test
    fun removeAllTest() {
        assertTrue(observableSourceSet.removeAll(listOf(2, 5, 6, 7)))
        assertFalse(observableSourceSet.removeAll(listOf(2, 5, 8)))

        assertEquals<Set<Int>>(setOf(-1, -3, -4), observableSet)
    }

    @Test
    fun retainAllTest() {
        assertTrue(observableSourceSet.retainAll(listOf(2, 4, 5, 6, 7)))
        assertFalse(observableSourceSet.retainAll(listOf(2, 4, 5, 8)))

        assertEquals<Set<Int>>(setOf(-2, -4, -5), observableSet)
    }

    @Test
    fun invalidateTest() {
        observableSet.invalidate()

        assertEquals(setOf(-1, -2, -3, -4, -5), observableSet)
    }
}
