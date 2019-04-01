package de.westermann.kobserve.list

import kotlin.test.*

class RelationalListTest {

    private lateinit var observableObjectList: ObservableList<Int>

    @BeforeTest
    fun setupTest() {
        val list = listOf(5, 2, 3, 1, 4)

        observableObjectList = list.toMutableList().observe()
    }

    @Test
    fun testSortedList() {
        val sortedList = observableObjectList.sortObservable(compareBy { it })

        assertEquals(listOf(1,2,3,4,5), sortedList)
        assertNotEquals(listOf(1,2,3,4,5), observableObjectList)

        var indexes = emptyList<Int>()
        sortedList.onAdd {
            indexes += it
        }
        sortedList.onRemove {
            indexes += it
        }

        observableObjectList.add(6)
        observableObjectList.add(0)

        assertEquals(listOf(5, 0), indexes)

        indexes = emptyList()

        observableObjectList.remove(2)
        observableObjectList.remove(3)

        assertEquals(listOf(2, 2), indexes)
    }
}
