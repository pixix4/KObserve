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

    fun notifyDatasetChanged() {
        for (i in indices) {
            onUpdate.emit(i)
        }
    }

    override fun subList(fromIndex: Int, toIndex: Int): ObservableReadOnlyList<T> {
        return ObservableReadOnlySubList(this, fromIndex until toIndex)
    }

    override fun iterator(): Iterator<T> {
        return ObservableReadOnlyListIterator(this)
    }

    override fun listIterator(): ListIterator<T> {
        return ObservableReadOnlyListIterator(this)
    }

    override fun listIterator(index: Int): ListIterator<T> {
        return ObservableReadOnlyListIterator(this, index)
    }

    override fun get(): ObservableReadOnlyList<T> {
        return this
    }
}
