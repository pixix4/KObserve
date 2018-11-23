package de.westermann.kobserve

class TransformProperty<T, R>(
    private val transform: (R) -> T,
    private val dependency: ReadOnlyProperty<R>
) : ReadOnlyProperty<T> {

    private var internal: T = transform(dependency.value)

    override fun get(): T = internal

    override val onChange = EventHandler<Unit>()

    init {
        dependency.onChange {
            val newValue = transform(dependency.value)

            if (newValue != internal) {
                internal = newValue
                onChange.emit(Unit)
            }
        }
    }
}

fun <T, R> ReadOnlyProperty<R>.mapBinding(transform: (R) -> T) =
    TransformProperty(transform, this)
