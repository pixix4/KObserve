package de.westermann.kobserve.list

import de.westermann.kobserve.event.EventHandler

class ObservableObjectList<T>(
    private val list: MutableList<T>
) : ObservableList<T> {

    override val onAdd = EventHandler<Int>()
    override val onUpdate = EventHandler<Int>()
    override val onRemove = EventHandler<Int>()

    override val onChange = EventHandler<Unit>()

    private fun emitOnAdd(index: Int) {
        onAdd.emit(index)
        onChange.emit(Unit)
    }

    private fun emitOnUpdate(index: Int) {
        onUpdate.emit(index)
        onChange.emit(Unit)
    }

    private fun emitOnRemove(index: Int) {
        onRemove.emit(index)
        onChange.emit(Unit)
    }

    override val size: Int
        get() = list.size

    override fun add(element: T): Boolean {
        val isAdded = list.add(element)
        if (isAdded) {
            emitOnAdd(size - 1)
        }
        return isAdded
    }

    override fun add(index: Int, element: T) {
        list.add(index, element)
        emitOnAdd(index)
    }

    override fun addAll(index: Int, elements: Collection<T>): Boolean {
        val isAdded = list.addAll(index, elements)
        if (isAdded) {
            for (i in index until index + elements.size) {
                emitOnAdd(i)
            }
        }
        return isAdded
    }

    override fun addAll(elements: Collection<T>): Boolean {
        val isAdded = list.addAll(elements)
        if (isAdded) {
            for (i in size - elements.size until size) {
                emitOnAdd(i)
            }
        }
        return isAdded
    }

    override fun clear() {
        val oldSize = size
        list.clear()
        for (i in (0 until oldSize).reversed()) {
            emitOnRemove(i)
        }
    }

    override fun contains(element: T): Boolean {
        return list.contains(element)
    }

    override fun containsAll(elements: Collection<T>): Boolean {
        return list.containsAll(elements)
    }

    override fun get(index: Int): T {
        return list[index]
    }

    override fun indexOf(element: T): Int {
        return list.indexOf(element)
    }

    override fun isEmpty(): Boolean {
        return list.isEmpty()
    }

    override fun lastIndexOf(element: T): Int {
        return list.lastIndexOf(element)
    }

    override fun remove(element: T): Boolean {
        val index = list.indexOf(element)
        val isRemoved = list.remove(element)
        if (isRemoved) {
            emitOnRemove(index)
        }
        return isRemoved
    }

    override fun removeAll(elements: Collection<T>): Boolean {
        var isChanged = false

        var index = 0

        while (index < list.size) {
            if (list[index] !in elements) {
                index += 1
            } else {
                list.removeAt(index)
                isChanged = true
                emitOnRemove(index)
            }
        }

        return isChanged
    }

    override fun removeAt(index: Int): T {
        val element = list.removeAt(index)
        emitOnRemove(index)
        return element
    }

    override fun retainAll(elements: Collection<T>): Boolean {
        var isChanged = false

        var index = 0

        while (index < list.size) {
            if (list[index] in elements) {
                index += 1
            } else {
                list.removeAt(index)
                isChanged = true
                emitOnRemove(index)
            }
        }

        return isChanged
    }

    override fun set(index: Int, element: T): T {
        val s = list.set(index, element)
        if (s != element) {
            notifyItemChanged(index)
        }
        return s
    }

    override fun toString(): String {
        return list.toString()
    }

    override fun notifyItemChanged(index: Int) {
        emitOnUpdate(index)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false

        other as ObservableObjectList<*>

        if (list != other.list) return false

        return true
    }

    override fun hashCode(): Int {
        return list.hashCode()
    }
}

fun <T> listProperty(list: MutableList<T>): ObservableList<T> = ObservableObjectList(list)
fun <T> MutableList<T>.observe(): ObservableList<T> = ObservableObjectList(this)
fun <T> observableListOf(vararg elements: T): ObservableList<T> =
    ObservableObjectList(mutableListOf(*elements))
