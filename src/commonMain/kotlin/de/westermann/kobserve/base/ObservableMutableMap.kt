package de.westermann.kobserve.base

interface ObservableMutableMap<K, V>: ObservableMap<K, V>, MutableMap<K, V> {

    override val entries: ObservableMutableSet<MutableMap.MutableEntry<K, V>>

    override val keys: ObservableMutableSet<K>

    override val values: ObservableMutableCollection<V>
}
