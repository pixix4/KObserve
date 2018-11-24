package de.westermann.kobserve.list

import de.westermann.kobserve.EventHandler
import de.westermann.kobserve.bind

class ObservableObjectList<T>(
    private val list: MutableList<T>,
    private val parent: Pair<ObservableObjectList<T>, Int>? = null
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

    override fun iterator(): ObservableListIterator<T> {
        return ObservableListIterator(this)
    }

    override fun lastIndexOf(element: T): Int {
        return list.lastIndexOf(element)
    }

    override fun listIterator(): ObservableListIterator<T> {
        return ObservableListIterator(this)
    }

    override fun listIterator(index: Int): ObservableListIterator<T> {
        return ObservableListIterator(this)
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

    override fun subList(fromIndex: Int, toIndex: Int): ObservableObjectList<T> {
        return ObservableObjectList(list.subList(fromIndex, toIndex), this to fromIndex)
    }

    override fun toString(): String {
        return list.toString()
    }

    private var isNotifyLock = false
    private fun notifyLock(block: () -> Unit) {
        if (!isNotifyLock) {
            isNotifyLock = true
            block()
            isNotifyLock = false
        }
    }

    override fun notifyItemChanged(index: Int): Unit = notifyLock {
        emitOnUpdate(index)
        parent?.let { (p, offset) ->
            p.notifyItemChanged(offset + index)
        }
    }

    override fun notifyItemRangeChanged(indices: IntRange): Unit = notifyLock {
        for (i in indices) {
            emitOnUpdate(i)
        }
        parent?.let { (p, offset) ->
            p.notifyItemRangeChanged(offset + indices.first..offset + indices.last)
        }
    }

    override fun notifyDatasetChanged(): Unit = notifyLock {
        super.notifyDatasetChanged()
        parent?.let { (p, offset) ->
            p.notifyItemRangeChanged(offset until offset + size)
        }
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

    init {
        parent?.let { (p, offset) ->
            p.onUpdate {
                val index = it - offset
                if (index in 0 until size) {
                    notifyItemChanged(index)
                }
            }
        }
    }
}

fun <T> property(list: MutableList<T>) = ObservableObjectList(list)
fun <T> MutableList<T>.observe() = ObservableObjectList(this)
fun <T> observableListOf(vararg elements: T): ObservableObjectList<T> =
    ObservableObjectList(mutableListOf(*elements))
