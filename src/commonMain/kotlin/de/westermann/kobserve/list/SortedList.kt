package de.westermann.kobserve.list

class SortedList<T>(
    parent: ObservableReadOnlyList<T>,
    comparator: Comparator<T>
) : RelationalList<T>(parent) {

    var comparator: Comparator<T> = comparator
        set(value) {
            if (value != field) {
                field = value
                updateRelation()
                onChange.emit(Unit)
            }
        }

    override fun updateRelation() {
        if (parent.size != relation.size) {
            relation.clear()
            relation.addAll(0 until parent.size)
        }

        sortSection(relation.toMutableList(), relation, 0, relation.size)
    }

    private fun mergeHalves(
        workA: MutableList<Int>,
        workB: MutableList<Int>,
        start: Int,
        mid: Int,
        exclusiveEnd: Int
    ) {
        var p1 = start
        var p2 = mid
        for (i in start until exclusiveEnd) {
            if (p1 < mid && (p2 == exclusiveEnd || comparator.compare(parent[workA[p1]], parent[workA[p2]]) <= 0)) {
                workB[i] = workA[p1]
                p1++
            } else {
                workB[i] = workA[p2]
                p2++
            }
        }
    }

    private fun sortSection(
        input: MutableList<Int>,
        output: MutableList<Int>,
        start: Int,
        exclusiveEnd: Int
    ) {
        if (exclusiveEnd - start <= 1) {
            return
        }
        val mid = (start + exclusiveEnd) / 2
        sortSection(output, input, start, mid)
        sortSection(output, input, mid, exclusiveEnd)
        mergeHalves(input, output, start, mid, exclusiveEnd)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false

        other as SortedList<*>

        if (parent != other.parent) return false
        if (comparator != other.comparator) return false

        return true
    }

    override fun hashCode(): Int {
        var result = parent.hashCode()
        result = 31 * result + comparator.hashCode()
        return result
    }

    init {
        updateRelation()
    }
}

fun <T> ObservableReadOnlyList<T>.sortObservable(comparator: Comparator<T>): ObservableReadOnlyList<T> = SortedList(this, comparator)
