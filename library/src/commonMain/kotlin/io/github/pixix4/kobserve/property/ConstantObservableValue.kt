package io.github.pixix4.kobserve.property

import io.github.pixix4.kobserve.base.ObservableValue
import io.github.pixix4.kobserve.event.EventHandler

class ConstantObservableValue<T>(private val internal: T) : ObservableValue<T> {

    override val onChange = EventHandler<Unit>()

    override fun get(): T = internal
}

/**
 * Create an constant property that cannot change.
 *
 * @param value The constant value.
 */
fun <T> constObservable(value: T): ObservableValue<T> = ConstantObservableValue(value)
fun <T> constObservable(): ObservableValue<T?> = ConstantObservableValue(null)

/**
 * Create an constant property that cannot change.
 *
 * @receiver value The constant value.
 */
fun <T> T.observeConst(): ObservableValue<T> = ConstantObservableValue(this)
