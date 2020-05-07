package de.westermann.kobserve.base

import de.westermann.kobserve.event.EventHandler

interface ObservableMap<K, V> : ObservableValue<Map<K, V>>, Map<K, V> {

    val onAdd: EventHandler<AddEvent<K, V>>
    val onUpdate: EventHandler<UpdateEvent<K, V>>
    val onRemove: EventHandler<RemoveEvent<K, V>>
    val onClear: EventHandler<Map<K, V>>

    override val entries: ObservableSet<Map.Entry<K, V>>

    override val keys: ObservableSet<K>

    override val values: ObservableCollection<V>
    
    override fun get(): Map<K, V> {
        return this
    }

    data class AddEvent<K, V>(
        val key: K,
        val value: V
    )

    data class UpdateEvent<K, V>(
        val key: K,
        val oldValue: V,
        val newElement: V
    )

    data class RemoveEvent<K, V>(
        val key: K,
        val value: V
    )
}
