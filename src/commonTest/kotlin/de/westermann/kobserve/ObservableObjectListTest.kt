package de.westermann.kobserve

import de.westermann.kobserve.list.ObservableList
import de.westermann.kobserve.list.ObservableObjectList
import de.westermann.kobserve.list.observe
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class ObservableObjectListTest {

    private lateinit var mutableList: MutableList<Int>
    private lateinit var observableObjectList: ObservableList<Int>

    @BeforeTest
    fun setupTest() {
        val list = listOf(1, 2, 3, 2, 4)

        mutableList = list.toMutableList()
        observableObjectList = list.toMutableList().observe()
    }

    @Test
    fun equalsTest() {
        assertEquals(mutableList, observableObjectList)
    }

    @Test
    fun addTest() {
        var index = -1
        observableObjectList.onAdd {
            index = it
        }

        mutableList.add(6)
        observableObjectList.add(6)

        assertEquals(mutableList, observableObjectList)
        assertEquals(mutableList.size - 1, index)
    }

    @Test
    fun addIndexTest() {
        var index = -1
        observableObjectList.onAdd {
            index = it
        }

        mutableList.add(2, 6)
        observableObjectList.add(2, 6)

        assertEquals(mutableList, observableObjectList)
        assertEquals(2, index)
    }

    @Test
    fun addAllTest() {
        var index = emptySet<Int>()
        observableObjectList.onAdd {
            index += it
        }

        mutableList.addAll(listOf(6, 7))
        observableObjectList.addAll(listOf(6, 7))

        assertEquals(mutableList, observableObjectList)
        assertEquals((mutableList.size - 2 until mutableList.size).toSet(), index)
    }

    @Test
    fun addAllIndexTest() {
        var index = emptySet<Int>()
        observableObjectList.onAdd {
            index += it
        }

        mutableList.addAll(2, listOf(6, 7))
        observableObjectList.addAll(2, listOf(6, 7))

        assertEquals(mutableList, observableObjectList)
        assertEquals((2..3).toSet(), index)
    }

    @Test
    fun clearTest() {
        var index = emptySet<Int>()
        observableObjectList.onRemove {
            index += it
        }

        mutableList.clear()
        observableObjectList.clear()

        assertEquals(mutableList, observableObjectList)
        assertTrue(observableObjectList.isEmpty())
        assertEquals((0..4).toSet(), index)
    }

    @Test
    fun removeTest() {
        val targetIndex = mutableList.indexOf(2)
        var index = -1
        observableObjectList.onRemove {
            index = it
        }

        mutableList.remove(2)
        observableObjectList.remove(2)

        assertEquals(mutableList, observableObjectList)
        assertEquals(targetIndex, index)
    }

    @Test
    fun removeAllTest() {
        var removed = emptySet<Int>()
        observableObjectList.onRemove {
            removed += it
        }

        mutableList.removeAll(listOf(1, 2))
        observableObjectList.removeAll(listOf(1, 2))

        assertEquals(mutableList, observableObjectList)
        assertEquals(setOf(0, 1), removed)
    }

    @Test
    fun removeAtTest() {
        var index = -1
        observableObjectList.onRemove {
            index = it
        }

        mutableList.removeAt(2)
        observableObjectList.removeAt(2)

        assertEquals(mutableList, observableObjectList)
        assertEquals(2, index)
    }

    @Test
    fun retainAllTest() {
        var removed = emptySet<Int>()
        observableObjectList.onRemove {
            removed += it
        }

        mutableList.retainAll(listOf(1, 2))
        observableObjectList.retainAll(listOf(1, 2))

        assertEquals(mutableList, observableObjectList)
        assertEquals(setOf(2, 3), removed)
    }

    @Test
    fun subListTest1() {
        val subList = observableObjectList.subList(1, 3)

        var observeCall = 0
        var observeItem = -1

        var subCall = 0
        var subItem = -1

        observableObjectList.onUpdate {
            observeCall += 1
            observeItem = it
        }
        subList.onUpdate {
            subCall += 1
            subItem = it
        }

        observableObjectList[2] = 5

        assertEquals(observableObjectList.subList(1, 3), subList)
        assertEquals(1, observeCall)
        assertEquals(2, observeItem)

        assertEquals(1, subCall)
        assertEquals(1, subItem)
    }

    @Test
    fun subListTest2() {
        val subList = observableObjectList.subList(1, 3)

        var observeCall = 0
        var observeItem = -1

        var subCall = 0
        var subItem = -1

        observableObjectList.onUpdate {
            observeCall += 1
            observeItem = it
        }
        subList.onUpdate {
            subCall += 1
            subItem = it
        }

        subList[1] = 5

        assertEquals(observableObjectList.subList(1, 3), subList)
        assertEquals(1, observeCall)
        assertEquals(2, observeItem)

        assertEquals(1, subCall)
        assertEquals(1, subItem)
    }
}