package de.westermann.kobserve.list

import de.westermann.kobserve.property.property
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class RelationalListTest {

    private val list = listOf(5, 2, 3, 1, 4, 5, 7, 3, 5, 7, 9)
    private lateinit var observableObjectList: ObservableList<Int>

    @BeforeTest
    fun setupTest() {
        observableObjectList = list.toMutableList().asObservable()
    }

    @Test
    fun testSortedList() {
        val sortedList = observableObjectList.sortObservable(compareBy { it })

        val mutable = sortedList.toMutableList()
        sortedList.onAdd {
            mutable.add(it.index, it.element)
        }
        sortedList.onUpdate {
            mutable.removeAt(it.oldIndex)
            mutable.add(it.newIndex, it.element)
        }
        sortedList.onRemove {
            mutable.removeAt(it.index)
        }

        assertEquals(list.sorted(), sortedList)
        assertEquals(list.sorted(), mutable)
        assertEquals(list, observableObjectList)

        sortedList.comparator = compareBy { -it }

        assertEquals(list.sortedBy { -it }, sortedList)
        assertEquals(list.sortedBy { -it }, mutable)
        assertEquals(list, observableObjectList)


        val newList = list + listOf(10, 15, -5)

        observableObjectList.add(10)
        observableObjectList.add(15)
        observableObjectList.add(-5)

        assertEquals(newList.sortedBy { -it }, sortedList)
        assertEquals(newList.sortedBy { -it }, mutable)
        assertEquals(newList, observableObjectList)
    }

    @Test
    fun testFilteredList() {
        val filteredList = observableObjectList.filterObservable { it <= 5 }

        val mutable = filteredList.toMutableList()
        filteredList.onAdd {
            mutable.add(it.index, it.element)
        }
        filteredList.onUpdate {
            mutable.removeAt(it.oldIndex)
            mutable.add(it.newIndex, it.element)
        }
        filteredList.onRemove {
            mutable.removeAt(it.index)
        }

        assertEquals(list.filter { it <= 5 }, filteredList)
        assertEquals(list.filter { it <= 5 }, mutable)
        assertEquals(list, observableObjectList)

        filteredList.predicate = { it > 5 }

        assertEquals(list.filter { it > 5 }, filteredList)
        assertEquals(list.filter { it > 5 }, mutable)
        assertEquals(list, observableObjectList)

        val newList = list + listOf(10, 15, -5)

        observableObjectList.add(10)
        observableObjectList.add(15)
        observableObjectList.add(-5)

        assertEquals(newList.filter { it > 5 }, filteredList)
        assertEquals(newList.filter { it > 5 }, mutable)
        assertEquals(newList, observableObjectList)
    }

    @Test
    fun testFilteredSortedList() {
        val names = listOf(
            "Benno" to 5,
            "Leon" to 2,
            "Lars" to 10,
            "Puis" to 200,
            "Amy" to 8,
            "Jakob" to 1337
        )

        val observable = names.toMutableList().asObservable()

        val comparatorProperty = property(compareBy<Pair<String, Int>> { it.first })
        val searchProperty = property("")

        val final = observable.filterObservable(searchProperty) { element, filter ->
            filter.toLowerCase() in element.first.toLowerCase()
        }.sortObservable(comparatorProperty)

        assertEquals(
            names.filter { searchProperty.value.toLowerCase() in it.first.toLowerCase() }
                .sortedBy { it.first },
            final
        )

        searchProperty.value = "o"

        assertEquals(
            names.filter { searchProperty.value.toLowerCase() in it.first.toLowerCase() }
                .sortedBy { it.first },
            final
        )

        comparatorProperty.value = compareBy { it.second }

        assertEquals(
            names.filter { searchProperty.value.toLowerCase() in it.first.toLowerCase() }
                .sortedBy { it.second },
            final
        )
    }
}
