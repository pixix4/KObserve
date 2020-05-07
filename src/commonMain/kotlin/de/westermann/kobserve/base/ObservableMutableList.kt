package de.westermann.kobserve.base

import de.westermann.kobserve.list.ObservableMutableSubList
import de.westermann.kobserve.utils.ObservableMutableListIterator

interface ObservableMutableList<T> : ObservableMutableCollection<T>, ObservableList<T>, MutableList<T> {

    override fun subList(fromIndex: Int, toIndex: Int): ObservableMutableList<T> {
        return ObservableMutableSubList(this, fromIndex until toIndex)
    }

    override fun iterator(): MutableIterator<T> {
        return ObservableMutableListIterator(this)
    }

    override fun listIterator(): MutableListIterator<T> {
        return ObservableMutableListIterator(this)
    }

    override fun listIterator(index: Int): MutableListIterator<T> {
        return ObservableMutableListIterator(this, index)
    }
}
