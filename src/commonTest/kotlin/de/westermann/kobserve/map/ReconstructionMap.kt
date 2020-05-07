package de.westermann.kobserve.map

import de.westermann.kobserve.base.ObservableMap
import de.westermann.kobserve.set.ReconstructionSet
import kotlin.test.assertEquals
import kotlin.test.assertNull

class ReconstructionMap<K, V>(
    reference: ObservableMap<K, V>
) {

    private val referenceValue by reference
    
    val reconstructionEntrySet = ReconstructionSet(reference.entries)
    val reconstructionKeySet = ReconstructionSet(reference.keys)

    val map = mutableMapOf<K, V>()

    init {
        map.putAll(reference)

        assertEquals<Map<K, V>>(map, reference)

        reference.onAdd { (key, value) ->
            assertNull(map.put(key, value))
        }
        reference.onUpdate { (key, oldValue, newValue) ->
            assertEquals(oldValue, map.put(key, newValue))
        }
        reference.onRemove { (key, value) ->
            assertEquals(value, map.remove(key))
        }
        reference.onClear { elements ->
            assertEquals(map, elements)
            map.clear()
        }

        reference.onChange {
            assertEquals(referenceValue, reference.value)
            assertEquals<Map<K, V>>(map, reference)

            assertEquals<Set<Map.Entry<K, V>>>(reference.entries, reconstructionEntrySet.set)
            assertEquals<Set<K>>(reference.keys, reconstructionKeySet.set)
        }
    }
}
