package de.westermann.kobserve.list

import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class TransformListTest {

    private lateinit var mutableList: MutableList<Int>
    private lateinit var observableObjectList: ObservableList<Int>

    @BeforeTest
    fun setupTest() {
        val list = listOf(1, 2, 3, 2, 4)

        mutableList = list.toMutableList()
        observableObjectList = list.toMutableList().asObservable()
    }

    @Test
    fun addTest() {
        val squareList = observableObjectList.mapObservable {
            it * it
        }

        assertEquals(mutableList.map { it * it }, squareList)

        var count = 0

        squareList.onAdd {
            count++
            assertEquals(100, squareList[it.index])
        }

        observableObjectList.add(10)

        assertEquals(1, count)
    }
}