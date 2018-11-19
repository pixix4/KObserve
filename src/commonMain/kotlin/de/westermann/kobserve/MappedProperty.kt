package de.westermann.kobserve

class MappedProperty<T, R>(
    private val transform: (R) -> T,
    private val dependency: ReadOnlyProperty<R>
) : ReadOnlyProperty<T> {

    override fun get(): T = transform(dependency.value)

    override val onChange = EventHandler<Unit>()

    init {
        dependency.onChange {
            onChange.emit(Unit)
        }
    }
}

fun <T, R> ReadOnlyProperty<R>.map(transform: (R) -> T) =
    MappedProperty(transform, this)
