package de.westermann.kobserve

class ObservableList<T>(
    private val list: MutableList<T>,
    private val parent: Pair<ObservableList<T>, Int>? = null
) : MutableList<T> {

    val onAdd = EventHandler<Int>()
    val onAddRange = EventHandler<IntRange>()
    val onUpdate = EventHandler<Int>()
    val onUpdateRange = EventHandler<IntRange>()
    val onRemove = EventHandler<Int>()
    val onRemoveRange = EventHandler<IntRange>()

    override val size: Int
        get() = list.size

    override fun add(element: T): Boolean {
        val isAdded = list.add(element)
        if (isAdded) {
            onAdd.emit(size - 1)
        }
        return isAdded
    }

    override fun add(index: Int, element: T) {
        list.add(index, element)
        onAdd.emit(index)
    }

    override fun addAll(index: Int, elements: Collection<T>): Boolean {
        val isAdded = list.addAll(index, elements)
        if (isAdded) {
            onAddRange.emit(index until index + elements.size)
        }
        return isAdded
    }

    override fun addAll(elements: Collection<T>): Boolean {
        val isAdded = list.addAll(elements)
        if (isAdded) {
            onAddRange.emit(size - elements.size until size)
        }
        return isAdded
    }

    override fun clear() {
        val oldSize = size
        list.clear()
        onRemoveRange.emit(0 until oldSize)
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
            onRemove.emit(index)
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
                onRemove.emit(index)
            }
        }

        return isChanged
    }

    override fun removeAt(index: Int): T {
        val element = list.removeAt(index)
        onRemove.emit(index)
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
                onRemove.emit(index)
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

    override fun subList(fromIndex: Int, toIndex: Int): ObservableList<T> {
        return ObservableList(list.subList(fromIndex, toIndex), this to fromIndex)
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

    fun notifyItemChanged(index: Int): Unit = notifyLock {
        onUpdate.emit(index)
        parent?.let { (p, offset) ->
            p.notifyItemChanged(offset + index)
        }
    }

    fun notifyItemRangeChanged(indices: IntRange): Unit = notifyLock {
        onUpdateRange.emit(indices)
        parent?.let { (p, offset) ->
            p.notifyItemRangeChanged(offset + indices.first..offset + indices.last)
        }
    }

    fun notfiyDatasetChanged(): Unit = notifyLock {
        onUpdateRange.emit(0 until size)
        parent?.let { (p, offset) ->
            p.notifyItemRangeChanged(offset until offset + size)
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false

        other as ObservableList<*>

        if (list != other.list) return false

        return true
    }

    override fun hashCode(): Int {
        return list.hashCode()
    }

    private val indexRange: IntRange
        get() = 0 until size

    init {
        parent?.let { (p, offset) ->
            p.onUpdate {
                val index = it - offset
                if (index in indexRange) {
                    notifyItemChanged(index)
                }
            }

            p.onUpdateRange {
                val firstIndex = it.first - offset
                val lastIndex = it.last - offset
                if (firstIndex in indexRange && lastIndex in indexRange) {
                    notifyItemRangeChanged(firstIndex..lastIndex)
                }
            }
        }
    }
}

fun <T> property(list: MutableList<T>) = ObservableList(list)
fun <T> MutableList<T>.observe() = ObservableList(this)
fun <T> observableListOf(vararg elements: T): ObservableList<T> = ObservableList(mutableListOf(*elements))