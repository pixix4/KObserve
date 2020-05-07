package de.westermann.kobserve.base

import de.westermann.kobserve.event.EventHandler
import de.westermann.kobserve.list.ObservableSubList
import de.westermann.kobserve.utils.ObservableListIterator

interface ObservableList<out T> : ObservableCollection<T>, List<T> {

    val onAddIndex: EventHandler<AddEvent<@UnsafeVariance T>>
    val onSetIndex: EventHandler<SetEvent<@UnsafeVariance T>>
    val onRemoveIndex: EventHandler<RemoveEvent<@UnsafeVariance T>>

    override fun subList(fromIndex: Int, toIndex: Int): ObservableList<T> {
        return ObservableSubList(this, fromIndex until toIndex)
    }

    override fun iterator(): Iterator<T> {
        return ObservableListIterator(this)
    }

    override fun listIterator(): ListIterator<T> {
        return ObservableListIterator(this)
    }

    override fun listIterator(index: Int): ListIterator<T> {
        return ObservableListIterator(this, index)
    }

    data class AddEvent<T>(
        val index: Int,
        val element: T
    )

    data class SetEvent<T>(
        val index: Int,
        val oldElement: T,
        val newElement: T
    )

    data class RemoveEvent<T>(
        val index: Int,
        val element: T
    )
}
