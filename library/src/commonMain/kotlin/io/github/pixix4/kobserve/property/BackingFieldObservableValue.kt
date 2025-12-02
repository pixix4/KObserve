package io.github.pixix4.kobserve.property

import io.github.pixix4.kobserve.base.ObservableValue
import io.github.pixix4.kobserve.event.EventHandler
import io.github.pixix4.kobserve.event.emit
import kotlin.reflect.KProperty0

open class BackingFieldObservableValue<T>(
    private val attribute: KProperty0<T>
) : ObservableValue<T> {

    override val onChange = EventHandler<Unit>()

    protected open var internal: T = attribute.get()

    override fun get() = internal

    override fun invalidate() {
        val newValue = attribute.get()
        if (newValue != internal) {
            internal = newValue
            onChange.emit()
        }
    }
}

/**
 * Wrap this property in an ObservableValue. If the backing field changes, the invalidate() method needs to be called.
 */
fun <T> property(attribute: KProperty0<T>): ObservableValue<T> =
    BackingFieldObservableValue(attribute)

/**
 * Wrap this property in an ObservableValue. If the backing field changes, the invalidate() method needs to be called.
 */
fun <T> KProperty0<T>.observe(): ObservableValue<T> = BackingFieldObservableValue(this)
