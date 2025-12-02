package io.github.pixix4.kobserve.property

import io.github.pixix4.kobserve.base.ObservableValue
import io.github.pixix4.kobserve.event.EventHandler
import io.github.pixix4.kobserve.event.emit
import kotlin.reflect.KProperty1

open class MappingObservableValue<R, T>(
    private val transform: (R) -> T,
    private val dependency: ObservableValue<R>
) : ObservableValue<T> {

    override val onChange = EventHandler<Unit>()

    protected var internal: T = transform(dependency.value)

    override fun get(): T = internal

    override fun invalidate() {
        val newValue = transform(dependency.value)

        if (newValue != internal) {
            internal = newValue
            onChange.emit()
        }
    }

    init {
        dependency.onChange {
            invalidate()
        }
    }
}

/**
 * Apply a transform function to the given property value and return a readonly property for the transformed value.
 * The returned property supports invalidation.
 */
fun <R, T> ObservableValue<R>.mapBinding(transform: (R) -> T): ObservableValue<T> =
    MappingObservableValue(transform, this)

fun <T> ObservableValue<T>.readOnly(): ObservableValue<T> =
    MappingObservableValue({ it }, this)

/**
 * Maps the given property to an readonly field attribute.
 * The returned property supports invalidation.
 *
 * @param attribute The readonly field attribute.
 */
fun <T, R> ObservableValue<R>.mapBinding(attribute: KProperty1<R, T>): ObservableValue<T> =
    MappingObservableValue(attribute::get, this)
