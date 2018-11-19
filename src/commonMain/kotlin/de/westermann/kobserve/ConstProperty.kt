package de.westermann.kobserve

class ConstProperty<T>(private val internal: T) : ReadOnlyProperty<T> {

    override fun get(): T = internal

    override val onChange = EventHandler<Unit>()
}
