package de.westermann.kobserve.basic

import de.westermann.kobserve.EventHandler
import de.westermann.kobserve.ReadOnlyProperty
import kotlin.reflect.KProperty1

open class ReceiverReadOnlyProperty<R, T>(
    private val attribute: KProperty1<R, T>,
    private val receiver: ReadOnlyProperty<R>
) : ReadOnlyProperty<T> {

    protected open var internal: T = attribute.get(receiver.value)

    override fun get(): T {
        val newValue = attribute.get(receiver.value)
        if (newValue != internal) {
            receiver.onChange.emit(Unit)
        }
        return newValue
    }

    final override val onChange = EventHandler<Unit>()

    init {
        receiver.onChange {
            val newValue = attribute.get(receiver.value)
            if (newValue != internal) {
                internal = newValue
                onChange.emit(Unit)
            }
        }
    }
}

fun <T, R> ReadOnlyProperty<R>.mapBinding(attribute: KProperty1<R, T>): ReadOnlyProperty<T> =
    ReceiverReadOnlyProperty(attribute, this)
