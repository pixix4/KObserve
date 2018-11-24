package de.westermann.kobserve.list

class FilteredList<T>(
    parent: ObservableReadOnlyList<T>,
    predicate: (T) -> Boolean
) : RelationalList<T>(parent) {

    var predicate: (T) -> Boolean = predicate
        set(value) {
            if (value != field) {
                field = value
                updateRelation()
                onChange.emit(Unit)
            }
        }

    override fun updateRelation() {
        relation.clear()
        for (index in 0 until parent.size) {
            if (predicate(parent[index])) {
                relation += index
            }
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false

        other as FilteredList<*>

        if (parent != other.parent) return false
        if (predicate != other.predicate) return false

        return true
    }

    override fun hashCode(): Int {
        var result = parent.hashCode()
        result = 31 * result + predicate.hashCode()
        return result
    }

    init {
        updateRelation()
    }
}

fun <T> ObservableReadOnlyList<T>.filterObservable(predicate: (T) -> Boolean) = FilteredList(this, predicate)
