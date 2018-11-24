package de.westermann.kobserve.list

import de.westermann.kobserve.EventHandler
import de.westermann.kobserve.ReadOnlyProperty

interface ObservableReadOnlyList<T> : List<T>, ReadOnlyProperty<ObservableReadOnlyList<T>> {
    val onAdd: EventHandler<Int>
    val onUpdate: EventHandler<Int>
    val onRemove: EventHandler<Int>

    fun notifyItemChanged(index: Int) {
        onUpdate.emit(index)
    }

    fun notifyItemRangeChanged(indices: IntRange) {
        for (i in indices) {
            onUpdate.emit(i)
        }
    }

    fun notifyDatasetChanged() = notifyItemRangeChanged(0 until size)

    override fun subList(fromIndex: Int, toIndex: Int): ObservableReadOnlyList<T>

    override fun get(): ObservableReadOnlyList<T> {
        return this
    }
}
