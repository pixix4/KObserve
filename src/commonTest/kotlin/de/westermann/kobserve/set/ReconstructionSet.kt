package de.westermann.kobserve.set

import de.westermann.kobserve.base.ObservableSet
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class ReconstructionSet<T>(
    reference: ObservableSet<T>
) {
    
    private val referenceValue by reference

    val set = mutableSetOf<T>()

    init {
        set.addAll(reference)

        assertEquals<Set<T>>(set, reference)

        reference.onAdd { element ->
            assertTrue(set.add(element))
        }
        reference.onRemove { element ->
            assertTrue(set.remove(element))
        }
        reference.onClear { elements ->
            assertEquals(set, elements)
            set.clear()
        }

        reference.onChange {
            assertEquals(referenceValue, reference.value)
            assertEquals(referenceValue, set)
        }
    }
}
