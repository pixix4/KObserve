package de.westermann.kobserve.basic

import de.westermann.kobserve.EventHandler
import de.westermann.kobserve.ReadOnlyProperty
import kotlin.reflect.KProperty1

class ReceiverReadOnlyProperty<T, R>(
    private val attribute: KProperty1<R, T>,
    private val receiver: ReadOnlyProperty<R>
) : ReadOnlyProperty<T> {

    override fun get(): T {
        return attribute.get(receiver.value)
    }

    override val onChange = EventHandler<Unit>()

    init {
        receiver.onChange {
            onChange.emit(Unit)
        }
    }
}

fun <T, R> ReadOnlyProperty<R>.mapBinding(attribute: KProperty1<R, T>) =
    ReceiverReadOnlyProperty(attribute, this)
