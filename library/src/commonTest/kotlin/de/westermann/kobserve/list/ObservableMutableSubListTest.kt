package de.westermann.kobserve.list

import de.westermann.kobserve.base.ObservableMutableList
import kotlin.test.*

class ObservableMutableSubListTest {

    private lateinit var observableSourceList: ObservableMutableList<Int>
    private lateinit var observableList: ObservableMutableList<Int>
    private lateinit var reconstructionList: ReconstructionList<Int>

    @BeforeTest
    fun setup() {
        observableSourceList = observableListOf(1, 2, 3, 4, 5)
        observableList = observableSourceList.subList(0, 2)
        reconstructionList = ReconstructionList(observableList)
    }

    @Test
    fun sizeTest() {
        assertEquals(2, observableList.size)
    }

    @Test
    fun containsTest() {
        assertTrue(observableList.contains(2))
        assertFalse(observableList.contains(8))
    }

    @Test
    fun containsAllTest() {
        assertTrue(observableList.containsAll(listOf(2, 1)))
        assertFalse(observableList.containsAll(listOf(1, 4, 2)))
        assertFalse(observableList.containsAll(listOf(8)))
        assertFalse(observableList.containsAll(listOf(3)))
        assertTrue(observableList.containsAll(listOf()))
    }

    @Test
    fun indexOfTest() {
        assertEquals(1, observableList.indexOf(2))
        assertEquals(-1, observableList.indexOf(3))
    }

    @Test
    fun lastIndexOfTest() {
        assertEquals(1, observableList.lastIndexOf(2))
        assertEquals(-1, observableList.lastIndexOf(3))
    }

    @Test
    fun isEmptyTest() {
        assertFalse(observableList.isEmpty())

        observableSourceList.clear()

        assertTrue(observableList.isEmpty())
    }

    @Test
    fun toStringTest() {
        assertEquals("[1, 2]", observableList.toString())
    }

    @Test
    fun equalsTest() {
        assertEquals(observableList, observableList)
        assertEquals(observableList, listOf(1, 2))
        assertEquals(observableList, observableListOf(1, 2))

        assertFalse(observableList.equals("Test"))
        assertFalse(observableList.equals(null))
        assertNotEquals(observableList, listOf(1, 2, 5, 8))
        assertNotEquals(observableList, observableListOf(1, 2, 5, 8))
    }

    @Test
    fun hashCodeTest() {
        assertEquals(observableList.hashCode(), observableList.hashCode())

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

        assertEquals(2, content.size)
        assertTrue(content.values.all { it == 1 })
        assertEquals(observableList.groupingBy { it }.eachCount(), content)
    }

    @Test
    fun mutableIteratorTest() {
        val content = mutableMapOf<Int, Int>()

        val iterator = observableSourceList.iterator()
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

        assertEquals(listOf(1), observableList)
    }

    @Test
    fun clearTest() {
        observableSourceList.clear()
        assertEquals<List<Int>>(emptyList(), observableList)

        observableSourceList.clear()
        assertEquals<List<Int>>(emptyList(), observableList)
    }

    @Test
    fun addTest() {
        assertTrue(observableSourceList.add(-1))
        assertTrue(observableSourceList.add(-1))

        assertEquals<List<Int>>(listOf(1, 2), observableList)
    }

    @Test
    fun addAllTest() {
        assertTrue(observableSourceList.addAll(listOf(4, 5, -6, 7)))
        assertTrue(observableSourceList.addAll(listOf(1, 2, -6)))

        assertEquals<List<Int>>(listOf(1, 2), observableList)
    }

    @Test
    fun addIndexTest() {
        observableSourceList.add(0, -5)
        observableSourceList.add(5, 8)

        assertEquals<List<Int>>(listOf(-5, 1,2 ), observableList)
    }

    @Test
    fun addAllIndexTest() {
        reconstructionList.groupOnChangeAssert {
            assertTrue(observableSourceList.addAll(0, listOf(4, -5, 6, -7)))
            assertTrue(observableSourceList.addAll(1, listOf(1, 2, 6)))
        }

        assertEquals<List<Int>>(listOf(4, 1, 2, 6, -5, 6, -7, 1, 2), observableList)
    }

    @Test
    fun removeTest() {
        assertTrue(observableSourceList.remove(1))
        assertFalse(observableSourceList.remove(1))

        assertEquals<List<Int>>(listOf(2), observableList)
    }

    @Test
    fun removeAtTest() {
        assertEquals(5, observableSourceList.removeAt(4))
        assertEquals(3, observableSourceList.removeAt(2))
        assertEquals(4, observableSourceList.removeAt(2))

        assertEquals<List<Int>>(listOf(1, 2), observableList)
    }

    @Test
    fun removeAllTest() {
        assertTrue(observableSourceList.removeAll(listOf(2, 5, 6, 7)))
        assertFalse(observableSourceList.removeAll(listOf(2, 5, 8)))

        assertEquals<List<Int>>(listOf(1), observableList)
    }

    @Test
    fun retainAllTest() {
        assertTrue(observableSourceList.retainAll(listOf(2, 5, 6, 7)))
        assertFalse(observableSourceList.retainAll(listOf(2, 5, 8)))

        assertEquals<List<Int>>(listOf(2), observableList)
    }

    @Test
    fun setTest() {
        assertEquals(2, observableSourceList.set(1, 5))
        assertEquals(5, observableSourceList.set(1, 5))
        assertEquals(5, observableSourceList.set(1, -1))
        assertEquals(-1, observableSourceList.set(1, -2))
        assertEquals<List<Int>>(listOf(1, -2), observableList)
    }

    @Test
    fun invalidateTest() {
        observableList.invalidate()

        assertEquals(listOf(1, 2), observableList)
    }


    @Test
    fun mutableSubIteratorTest() {
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

        assertEquals(2, content.size)
        assertTrue(content.values.all { it == 1 })
        assertTrue(content.keys.containsAll(observableList))

        assertEquals(listOf(1), observableList)
    }

    @Test
    fun clearSubTest() {
        observableList.clear()
        assertEquals<List<Int>>(emptyList(), observableList)

        observableList.clear()
        assertEquals<List<Int>>(emptyList(), observableList)
    }

    @Test
    fun addSubTest() {
        assertTrue(observableList.add(-1))
        assertTrue(observableList.add(-1))

        assertEquals<List<Int>>(listOf(1, 2, -1, -1), observableList)
    }

    @Test
    fun addAllSubTest() {
        assertTrue(observableList.addAll(listOf(4, 5, -6, 7)))
        assertTrue(observableList.addAll(listOf(1, 2, -6)))

        assertEquals<List<Int>>(listOf(1, 2, 4, 5, -6, 7, 1, 2, -6), observableList)
    }

    @Test
    fun addIndexSubTest() {
        assertFails {
            observableList.add(3, 8)
        }

        observableList.add(0, -5)
        observableList.add(3, 8)

        assertEquals<List<Int>>(listOf(-5, 1, 2, 8), observableList)
    }

    @Test
    fun addAllIndexSubTest() {
        assertFails {
            observableList.addAll(3, listOf(1,2,3))
        }

        reconstructionList.groupOnChangeAssert {
            assertTrue(observableList.addAll(0, listOf(4, -5, 6, -7)))
            assertTrue(observableList.addAll(1, listOf(1, 2, 6)))
        }

        assertEquals<List<Int>>(listOf(4, 1, 2, 6, -5, 6, -7, 1, 2), observableList)
    }

    @Test
    fun removeSubTest() {
        assertTrue(observableList.remove(1))
        assertFalse(observableList.remove(1))

        assertEquals<List<Int>>(listOf(2), observableList)
    }

    @Test
    fun removeAtSubTest() {
        assertFails { 
            observableList.removeAt(3)
        }
        assertEquals(2, observableList.removeAt(1))

        assertEquals<List<Int>>(listOf(1), observableList)
    }

    @Test
    fun removeAllSubTest() {
        assertTrue(observableList.removeAll(listOf(2, 5, 6, 7)))
        assertFalse(observableList.removeAll(listOf(2, 5, 8)))

        assertEquals<List<Int>>(listOf(1), observableList)
    }

    @Test
    fun retainAllSubTest() {
        assertTrue(observableList.retainAll(listOf(2, 5, 6, 7)))
        assertFalse(observableList.retainAll(listOf(2, 5, 8)))

        assertEquals<List<Int>>(listOf(2), observableList)
    }

    @Test
    fun setSubTest() {
        assertFails {
            observableList[3] = 8
        }

        assertEquals(2, observableList.set(1, 5))
        assertEquals(5, observableList.set(1, 5))
        assertEquals(5, observableList.set(1, -1))
        assertEquals(-1, observableList.set(1, -2))
        assertEquals<List<Int>>(listOf(1, -2), observableList)
    }
}
