package de.westermann.kobserve.list

import de.westermann.kobserve.event.EventHandler

abstract class RelationalList<T>(
    protected val parent: ObservableReadOnlyList<T>
) : ObservableReadOnlyList<T> {

    override val onAdd = EventHandler<Int>()
    override val onUpdate = EventHandler<Int>()
    override val onRemove = EventHandler<Int>()
    override val onChange = EventHandler<Unit>()

    protected val relation: MutableList<Int> = mutableListOf()
    abstract fun updateRelation()

    override val size: Int
            get() = relation.size

    override fun contains(element: T): Boolean {
        for (elem in iterator()) {
            if (elem == element) {
                return true
            }
        }
        return false
    }

    override fun containsAll(elements: Collection<T>): Boolean {
        var notFound = elements.toList()

        for (elem in iterator()) {
            notFound -= elem

            if (notFound.isEmpty()) {
                return true
            }
        }
        return false
    }

    override fun get(index: Int): T {
        return parent[relation[index]]
    }

    override fun indexOf(element: T): Int {
        var index = 0
        for (elem in iterator()) {
            if (elem == element) {
                return index
            }
            index += 1
        }
        return -1
    }

    override fun isEmpty(): Boolean = relation.isEmpty()

    override fun lastIndexOf(element: T): Int {
        var index = 0
        var lastIndex = -1
        for (elem in iterator()) {
            if (elem == element) {
                lastIndex = index
            }
            index += 1
        }
        return lastIndex
    }

    override fun notifyItemChanged(index: Int) {
        parent.notifyItemChanged(index)
    }

    override fun notifyDatasetChanged() {
        parent.notifyDatasetChanged()
    }

    init {
        parent.onAdd { oldIndex ->
            updateRelation()
            val index = relation.indexOf(oldIndex)
            if (index >= 0) {
                onAdd.emit(index)
                onChange.emit(Unit)
            }
        }
        parent.onUpdate { oldIndex ->
            updateRelation()
            val index = relation.indexOf(oldIndex)
            if (index >= 0) {
                onUpdate.emit(index)
                onChange.emit(Unit)
            }
        }
        parent.onRemove { oldIndex ->
            val index = relation.indexOf(oldIndex)
            updateRelation()
            if (index >= 0) {
                onRemove.emit(index)
                onChange.emit(Unit)
            }
        }
    }
}
