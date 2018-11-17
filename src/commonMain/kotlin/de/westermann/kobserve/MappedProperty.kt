package de.westermann.kobserve

class MappedProperty<T, R>(
    private val compute: (R) -> T,
    private val dependency: ReadOnlyProperty<R>
) : ReadOnlyProperty<T> {

    override fun get(): T = compute(dependency.value)

    override val onChange = EventHandler<Unit>()

    init {
        dependency.onChange {
            onChange.emit(Unit)
        }
    }
}

fun <T, R> ReadOnlyProperty<R>.map(compute: (R) -> T) =
    MappedProperty(compute, this)
