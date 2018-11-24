package de.westermann.kobserve.list

interface ObservableList<T> : ObservableReadOnlyList<T>, MutableList<T> {
    override fun subList(fromIndex: Int, toIndex: Int): ObservableList<T>
}
