package de.westermann.kobserve.list

import de.westermann.kobserve.base.ObservableMutableList
import de.westermann.kobserve.base.ObservableMutableSet
import kotlin.test.*

class SimpleObservableMutableListTest {

    private lateinit var observableList: ObservableMutableList<Int>
    private lateinit var reconstructionList: ReconstructionList<Int>

    @BeforeTest
    fun setup() {
        observableList = observableListOf(1, 2, 3, 4, 5)
        reconstructionList = ReconstructionList(observableList)
    }

    @Test
    fun initTest() {
        val s1 = listProperty(mutableListOf(1, 2, 3, 4, 5))
        val s2 = mutableListOf(1, 2, 3, 4, 5).asObservable()

        assertEquals(observableList, s1)
        assertEquals(observableList, s2)
    }

    @Test
    fun sizeTest() {
        assertEquals(5, observableList.size)
    }

    @Test
    fun containsTest() {
        assertTrue(observableList.contains(3))
        assertFalse(observableList.contains(8))
    }

    @Test
    fun containsAllTest() {
        assertTrue(observableList.containsAll(listOf(3, 5, 1)))
        assertFalse(observableList.containsAll(listOf(3, 4, 8)))
        assertTrue(observableList.containsAll(listOf()))
    }

    @Test
    fun indexOfTest() {
        assertEquals(2, observableList.indexOf(3))
        assertEquals(-1, observableList.indexOf(8))
    }

    @Test
    fun lastIndexOfTest() {
        assertEquals(2, observableList.lastIndexOf(3))
        assertEquals(-1, observableList.lastIndexOf(8))
    }
    
    @Test
    fun isEmptyTest() {
        assertFalse(observableList.isEmpty())

        observableList.clear()

        assertTrue(observableList.isEmpty())
    }

    @Test
    fun toStringTest() {
        assertEquals("[1, 2, 3, 4, 5]", observableList.toString())
    }

    @Test
    fun equalsTest() {
        assertEquals(observableList, observableList)
        assertEquals(observableList, listOf(1, 2, 3, 4, 5))
        assertEquals(observableList, observableListOf(1, 2, 3, 4, 5))

        assertFalse(observableList.equals("Test"))
        assertFalse(observableList.equals(null))
        assertNotEquals(observableList, listOf(1, 2, 5, 8))
        assertNotEquals(observableList, observableListOf(1, 2, 5, 8))
    }

    @Test
    fun hashCodeTest() {
        assertEquals(observableList.hashCode(), observableList.hashCode())

        assertEquals(observableList.hashCode(), listOf(1, 2, 3, 4, 5).hashCode())
        assertEquals(observableList.hashCode(), observableListOf(1, 2, 3, 4, 5).hashCode())

        assertNotEquals(observableList.hashCode(), listOf(1, 2, 5, 8).hashCode())
        assertNotEquals(observableList.hashCode(), observableListOf(1, 2, 5, 8).hashCode())
    }

    @Test
    fun iteratorTest() {
        val content = mutableMapOf<Int, Int>()

        for (element in observableList) {
            val count = content[element] ?: 0
            content[element] = count + 1
        }

        assertEquals(5, content.size)
        assertTrue(content.values.all { it == 1 })
        assertEquals(observableList.groupingBy { it }.eachCount(), content)
    }

    @Test
    fun mutableIteratorTest() {
        val content = mutableMapOf<Int, Int>()

        val iterator = observableList.iterator()
        while (iterator.hasNext()) {
            val element = iterator.next()

            val count = content[element] ?: 0
            content[element] = count + 1

            if (element in listOf(2, 3, 4)) {
                iterator.remove()
            }
        }

        assertEquals(5, content.size)
        assertTrue(content.values.all { it == 1 })
        assertTrue(content.keys.containsAll(observableList))

        assertEquals(listOf(1, 5), observableList)
    }

    @Test
    fun clearTest() {
        observableList.clear()
        assertEquals<List<Int>>(emptyList(), observableList)

        observableList.clear()
        assertEquals<List<Int>>(emptyList(), observableList)
    }

    @Test
    fun addTest() {
        assertTrue(observableList.add(6))
        assertTrue(observableList.add(6))

        assertEquals<List<Int>>(listOf(1, 2, 3, 4, 5, 6, 6), observableList)
    }

    @Test
    fun addAllTest() {
        assertTrue(observableList.addAll(listOf(4, 5, 6, 7)))
        assertTrue(observableList.addAll(listOf(1, 2, 6)))

        assertEquals<List<Int>>(listOf(1, 2, 3, 4, 5, 4, 5, 6, 7, 1, 2, 6), observableList)
    }

    @Test
    fun addIndexTest() {
        observableList.add(0, 6)
        observableList.add(5, 8)

        assertEquals<List<Int>>(listOf(6, 1, 2, 3, 4, 8, 5), observableList)
    }

    @Test
    fun addAllIndexTest() {
        assertTrue(observableList.addAll(0, listOf(4, 5, 6, 7)))
        assertTrue(observableList.addAll(1, listOf(1, 2, 6)))

        assertEquals<List<Int>>(listOf(4, 1, 2, 6, 5, 6, 7, 1, 2, 3, 4, 5), observableList)
    }

    @Test
    fun removeTest() {
        assertTrue(observableList.remove(5))
        assertFalse(observableList.remove(5))

        assertEquals<List<Int>>(listOf(1, 2, 3, 4), observableList)
    }

    @Test
    fun removeAtTest() {
        assertEquals(5, observableList.removeAt(4))
        assertEquals(3, observableList.removeAt(2))
        assertEquals(4, observableList.removeAt(2))

        assertEquals<List<Int>>(listOf(1, 2), observableList)
    }

    @Test
    fun removeAllTest() {
        assertTrue(observableList.removeAll(listOf(4, 5, 6, 7)))
        assertFalse(observableList.removeAll(listOf(4, 5, 8)))

        assertEquals<List<Int>>(listOf(1, 2, 3), observableList)
    }

    @Test
    fun retainAllTest() {
        assertTrue(observableList.retainAll(listOf(4, 5, 6, 7)))
        assertFalse(observableList.retainAll(listOf(4, 5, 8)))

        assertEquals<List<Int>>(listOf(4, 5), observableList)
    }
    
    @Test
    fun setTest() {
        assertEquals(3, observableList.set(2, 5))
        assertEquals(5, observableList.set(2, 5))
        assertEquals(5, observableList.set(2, 7))

        assertEquals<List<Int>>(listOf(1, 2, 7, 4, 5), observableList)
    }

    @Test
    fun invalidateTest() {
        observableList.invalidate()

        assertEquals(listOf(1, 2, 3, 4, 5), observableList)
    }
}
