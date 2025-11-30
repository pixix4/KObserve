package de.westermann.kobserve.map

import de.westermann.kobserve.base.ObservableMutableCollection
import de.westermann.kobserve.base.ObservableMutableMap
import kotlin.test.*

class ObservableMutableValueCollectionTest {

    private lateinit var observableMap: ObservableMutableMap<Int, Int>
    private lateinit var reconstructionMap: ReconstructionMap<Int, Int>

    private lateinit var valueCollection: ObservableMutableCollection<Int>

    @BeforeTest
    fun setup() {
        observableMap = observableMapOf(
            1 to 2,
            3 to 4,
            5 to 6
        )
        reconstructionMap = ReconstructionMap(observableMap)

        valueCollection = observableMap.values
    }


    @Test
    fun sizeTest() {
        assertEquals(3, valueCollection.size)
    }

    @Test
    fun containsTest() {
        assertTrue(valueCollection.contains(4))
        assertFalse(valueCollection.contains(3))
    }

    @Test
    fun isEmptyTest() {
        assertFalse(valueCollection.isEmpty())

        valueCollection.clear()

        assertTrue(valueCollection.isEmpty())
    }

    @Test
    fun toStringTest() {
        val possibleToStringValues = listOf(
            "[2, 4, 6]",
            "[2, 6, 4]",
            "[4, 2, 6]",
            "[4, 6, 2]",
            "[6, 2, 4]",
            "[6, 4, 2]"
        )
        assertTrue(valueCollection.toString() in possibleToStringValues)
    }

    @Test
    fun equalsTest() {
        assertCollectionEquals(valueCollection)
        assertCollectionEquals(
            mapOf(
                1 to 2,
                3 to 4,
                5 to 6
            ).values
        )
        assertCollectionEquals(
            observableMapOf(
                1 to 2,
                3 to 4,
                5 to 6
            ).values
        )

        assertFalse(valueCollection.equals("Test"))
        assertFalse(valueCollection.equals(null))
        assertCollectionNotEquals(
            mapOf(
                1 to 2,
                4 to 8,
                5 to 6
            ).values
        )
        assertCollectionNotEquals(
            observableMapOf(
                1 to 2,
                4 to 8,
                5 to 6
            ).values
        )
    }

    @Test
    fun hashCodeTest() {
        assertEquals(valueCollection.hashCode(), valueCollection.hashCode())
    }

    @Test
    fun iteratorTest() {
        val content = mutableMapOf<Int, Int>()

        for (element in valueCollection) {
            val count = content[element] ?: 0
            content[element] = count + 1
        }

        assertEquals(3, content.size)
        assertTrue(content.values.all { it == 1 })
        assertEquals(observableMap.values.toSet(), content.keys)
    }

    @Test
    fun mutableIteratorTest() {
        val content = mutableMapOf<Int, Int>()

        val iterator = valueCollection.iterator()
        while (iterator.hasNext()) {
            val element = iterator.next()

            val count = content[element] ?: 0
            content[element] = count + 1

            if (element == 4) {
                iterator.remove()
            }
        }

        assertEquals(3, content.size)
        assertTrue(content.values.all { it == 1 })
        assertTrue(content.keys.containsAll(observableMap.values))

        assertCollectionEquals(
            mapOf(
                1 to 2,
                5 to 6
            ).values
        )
    }

    @Test
    fun clearTest() {
        valueCollection.clear()

        assertCollectionEquals(emptyMap<Int, Int>().values)
    }

    @Test
    fun putTest() {
        assertFails {
            valueCollection.add(8)
        }

        assertCollectionEquals(
            mapOf(
                1 to 2,
                3 to 4,
                5 to 6
            ).values
        )
    }

    @Test
    fun putAllTest() {
        assertFails {
            valueCollection.addAll(listOf(
                8,
                10
            ))
        }

        assertCollectionEquals(
            mapOf(
                1 to 2,
                3 to 4,
                5 to 6
            ).values
        )
    }

    @Test
    fun removeTest() {
        assertTrue(valueCollection.remove(4))
        assertFalse(valueCollection.remove(4))

        assertCollectionEquals(
            mapOf(
                1 to 2,
                5 to 6
            ).values
        )
    }

    @Test
    fun removeAllTest() {
        assertTrue(valueCollection.removeAll(listOf(4)))
        assertFalse(valueCollection.removeAll(listOf(4)))

        assertCollectionEquals(
            mapOf(
                1 to 2,
                5 to 6
            ).values
        )
    }

    @Test
    fun retainAllTest() {
        assertTrue(valueCollection.retainAll(listOf(4)))
        assertFalse(valueCollection.retainAll(listOf(4)))

        assertCollectionEquals(
            mapOf(
                3 to 4
            ).values
        )
    }

    @Test
    fun invalidateTest() {
        valueCollection.invalidate()

        assertCollectionEquals(
            mapOf(
                1 to 2,
                3 to 4,
                5 to 6
            ).values
        )
    }
    
    fun assertCollectionEquals(other: Collection<Int>) {
        val m1 = other.groupingBy { it }.eachCount()
        val m2 = valueCollection.groupingBy { it }.eachCount()
        
        assertEquals(m1, m2)
    }

    fun assertCollectionNotEquals(other: Collection<Int>) {
        val m1 = other.groupingBy { it }.eachCount()
        val m2 = valueCollection.groupingBy { it }.eachCount()

        assertNotEquals(m1, m2)
    }
}
