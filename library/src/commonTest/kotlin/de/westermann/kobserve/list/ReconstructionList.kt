package de.westermann.kobserve.list

import de.westermann.kobserve.base.ObservableList
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals

class ReconstructionList<T>(
    private val reference: ObservableList<T>
) {
    
    private val referenceValue by reference

    private val list = mutableListOf<T>()
    
    private var onChangeAssert = true
    fun groupOnChangeAssert(block: () -> Unit) {
        onChangeAssert = false
        block()
        onChangeAssert = true

        assertContentEquals(referenceValue, reference.value)
        assertContentEquals(referenceValue, list)
    }

    init {
        list.addAll(reference)

        assertEquals<List<T>>(list, reference)

        reference.onAddIndex { (index, element) ->
            list.add(index, element)
        }
        reference.onSetIndex { (index, oldElement, newElement) ->
            assertEquals(oldElement, list.set(index, newElement))
        }
        reference.onRemoveIndex { (index, element) ->
            assertEquals(element, list.removeAt(index))
        }
        reference.onClear { elements ->
            assertContentEquals(list, elements)
            list.clear()
        }

        reference.onChange {
            if (onChangeAssert) {
                assertContentEquals(referenceValue, reference.value)
                assertContentEquals(referenceValue, list)
            }
        }
    }
}
