package io.github.pixix4.kobserve.utils

import io.github.pixix4.kobserve.base.ObservableCollection
import io.github.pixix4.kobserve.base.ObservableList
import io.github.pixix4.kobserve.base.ObservableMap
import io.github.pixix4.kobserve.base.ObservableSet
import io.github.pixix4.kobserve.list.observableListOf
import io.github.pixix4.kobserve.map.observableMapOf
import io.github.pixix4.kobserve.set.mapObservable
import io.github.pixix4.kobserve.set.observableSetOf

fun <T> ObservableCollection<T>.toObservableList(): ObservableList<T> {
    val list = observableListOf<T>()

    list.addAll(this)

    onAdd {
        list.add(it)
    }
    onRemove {
        list.remove(it)
    }
    onClear {
        list.clear()
    }

    return list
}

fun <T> ObservableCollection<T>.toObservableSet(): ObservableSet<T> {
    val set = observableSetOf<T>()

    set.addAll(this)

    onAdd {
        set.add(it)
    }
    onRemove {
        set.remove(it)
    }
    onClear {
        set.clear()
    }

    return set
}

fun <K, V> ObservableCollection<Pair<K, V>>.toObservableMap(): ObservableMap<K, V> {
    val map = observableMapOf<K, V>()

    map.putAll(this)

    onAdd { (key, value) ->
        map[key] = value
    }
    onRemove { (key, _) ->
        map.remove(key)
    }
    onClear {
        map.clear()
    }

    return map
}

fun <K, V> ObservableMap<K, V>.toObservableSet(): ObservableSet<Pair<K, V>> {
    return entries.mapObservable { it.toPair() }
}

fun <K, V> ObservableMap<K, V>.toObservableList(): ObservableList<Pair<K, V>> {
    return entries.mapObservable { it.toPair() }.toObservableList()
}
