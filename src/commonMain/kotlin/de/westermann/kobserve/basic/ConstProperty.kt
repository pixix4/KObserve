package de.westermann.kobserve.basic

import de.westermann.kobserve.EventHandler
import de.westermann.kobserve.ReadOnlyProperty

class ConstProperty<T>(private val internal: T) : ReadOnlyProperty<T> {

    override fun get(): T = internal

    override val onChange = EventHandler<Unit>()
}

/**
 * Create an constant property that cannot change.
 *
 * @param value The constant value.
 */
fun <T> constProperty(value: T): ReadOnlyProperty<T> = ConstProperty(value)
