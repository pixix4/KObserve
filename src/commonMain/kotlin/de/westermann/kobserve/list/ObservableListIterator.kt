package de.westermann.kobserve.list

class ObservableListIterator<T>(
    private val objectList: ObservableObjectList<T>,
    private var index: Int = 0
) : MutableListIterator<T> {

    private var last = -1

    override fun hasNext(): Boolean = index < objectList.size

    override fun next(): T {
        if (!hasNext()) throw NoSuchElementException()
        last = index++
        return objectList[last]
    }

    override fun remove() {
        check(last != -1) { "Call next() or previous() before removing element from the iterator." }

        objectList.removeAt(last)
        index = last
        last = -1
    }

    override fun hasPrevious(): Boolean = index > 0

    override fun nextIndex(): Int = index

    override fun previous(): T {
        if (!hasPrevious()) throw NoSuchElementException()

        last = --index
        return objectList[last]
    }

    override fun previousIndex(): Int = index - 1

    override fun add(element: T) {
        objectList.add(index, element)
        index++
        last = -1
    }

    override fun set(element: T) {
        check(last != -1) { "Call next() or previous() before updating element value with the iterator." }
        objectList[last] = element
    }

}