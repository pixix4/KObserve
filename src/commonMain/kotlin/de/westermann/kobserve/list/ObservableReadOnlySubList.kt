package de.westermann.kobserve.list

import de.westermann.kobserve.event.EventHandler

open class ObservableReadOnlySubList<T>(
    parent: ObservableReadOnlyList<T>,
    protected var range: IntRange
) : ObservableReadOnlyList<T> {

    protected open val parent: ObservableReadOnlyList<T> = parent.also {
        it.onAdd { parentIndex ->
            val index = parentIndex - range.first

            if (index in 0 until size) {
                onAdd.emit(index)
            }
        }

        it.onUpdate { parentIndex ->
            val index = parentIndex - range.first

            if (index in 0 until size) {
                onUpdate.emit(index)
            }
        }

        it.onRemove { parentIndex ->
            val index = parentIndex - range.first

            if (index in 0 until size) {
                onRemove.emit(index)
            }
        }
    }

    override val onAdd = EventHandler<Int>()
    override val onUpdate = EventHandler<Int>()
    override val onRemove = EventHandler<Int>()
    override val onChange = EventHandler<Unit>()

    override val size: Int
        get() = range.count()

    override fun contains(element: T): Boolean {
        return (0 until size).map(this::get).contains(element)
    }

    override fun containsAll(elements: Collection<T>): Boolean {
        return (0 until size).map(this::get).containsAll(elements)
    }

    override fun get(index: Int): T {
        if (index !in 0 until size) {
            throw IndexOutOfBoundsException()
        }

        return parent[index + range.first]
    }

    override fun indexOf(element: T): Int {
        return (0 until size).map(this::get).indexOf(element)
    }

    override fun isEmpty(): Boolean {
        return size == 0
    }

    override fun lastIndexOf(element: T): Int {
        return (0 until size).map(this::get).lastIndexOf(element)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false

        other as ObservableReadOnlySubList<*>

        if (range != other.range) return false
        if (parent != other.parent) return false

        return true
    }

    override fun hashCode(): Int {
        var result = range.hashCode()
        result = 31 * result + parent.hashCode()
        return result
    }

}
