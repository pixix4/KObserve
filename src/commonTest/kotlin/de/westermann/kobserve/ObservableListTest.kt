package de.westermann.kobserve

import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class ObservableListTest {

    private lateinit var mutableList: MutableList<Int>
    private lateinit var observableList: ObservableList<Int>

    @BeforeTest
    fun setupTest() {
        val list = listOf(1, 2, 3, 2, 4)

        mutableList = list.toMutableList()
        observableList = list.toMutableList().observe()
    }

    @Test
    fun equalsTest() {
        assertEquals(mutableList, observableList)
    }

    @Test
    fun addTest() {
        var index = -1
        observableList.onAdd {
            index = it
        }

        mutableList.add(6)
        observableList.add(6)

        assertEquals(mutableList, observableList)
        assertEquals(mutableList.size - 1, index)
    }

    @Test
    fun addIndexTest() {
        var index = -1
        observableList.onAdd {
            index = it
        }

        mutableList.add(2, 6)
        observableList.add(2, 6)

        assertEquals(mutableList, observableList)
        assertEquals(2, index)
    }

    @Test
    fun addAllTest() {
        var index = -2..-1
        observableList.onAddRange {
            index = it
        }

        mutableList.addAll(listOf(6, 7))
        observableList.addAll(listOf(6, 7))

        assertEquals(mutableList, observableList)
        assertEquals(mutableList.size - 2 until mutableList.size, index)
    }

    @Test
    fun addAllIndexTest() {
        var index = -2..-1
        observableList.onAddRange {
            index = it
        }

        mutableList.addAll(2, listOf(6, 7))
        observableList.addAll(2, listOf(6, 7))

        assertEquals(mutableList, observableList)
        assertEquals(2..3, index)
    }

    @Test
    fun clearTest() {
        var index = -2..-1
        observableList.onRemoveRange {
            index = it
        }

        mutableList.clear()
        observableList.clear()

        assertEquals(mutableList, observableList)
        assertTrue(observableList.isEmpty())
        assertEquals(0..4, index)
    }

    @Test
    fun removeTest() {
        val targetIndex = mutableList.indexOf(2)
        var index = -1
        observableList.onRemove {
            index = it
        }

        mutableList.remove(2)
        observableList.remove(2)

        assertEquals(mutableList, observableList)
        assertEquals(targetIndex, index)
    }

    @Test
    fun removeAllTest() {
        var removed = emptySet<Int>()
        observableList.onRemove {
            removed += it
        }

        mutableList.removeAll(listOf(1, 2))
        observableList.removeAll(listOf(1, 2))

        assertEquals(mutableList, observableList)
        assertEquals(setOf(0, 1), removed)
    }

    @Test
    fun removeAtTest() {
        var index = -1
        observableList.onRemove {
            index = it
        }

        mutableList.removeAt(2)
        observableList.removeAt(2)

        assertEquals(mutableList, observableList)
        assertEquals(2, index)
    }

    @Test
    fun retainAllTest() {
        var removed = emptySet<Int>()
        observableList.onRemove {
            removed += it
        }

        mutableList.retainAll(listOf(1, 2))
        observableList.retainAll(listOf(1, 2))

        assertEquals(mutableList, observableList)
        assertEquals(setOf(2, 3), removed)
    }

    @Test
    fun subListTest1() {
        val subList = observableList.subList(1, 3)

        var observeCall = 0
        var observeItem = -1

        var subCall = 0
        var subItem = -1

        observableList.onUpdate {
            observeCall += 1
            observeItem = it
        }
        subList.onUpdate {
            subCall += 1
            subItem = it
        }

        observableList[2] = 5

        assertEquals(observableList.subList(1, 3), subList)
        assertEquals(1, observeCall)
        assertEquals(2, observeItem)

        assertEquals(1, subCall)
        assertEquals(1, subItem)
    }

    @Test
    fun subListTest2() {
        val subList = observableList.subList(1, 3)

        var observeCall = 0
        var observeItem = -1

        var subCall = 0
        var subItem = -1

        observableList.onUpdate {
            observeCall += 1
            observeItem = it
        }
        subList.onUpdate {
            subCall += 1
            subItem = it
        }

        subList[1] = 5

        assertEquals(observableList.subList(1, 3), subList)
        assertEquals(1, observeCall)
        assertEquals(2, observeItem)

        assertEquals(1, subCall)
        assertEquals(1, subItem)
    }
}