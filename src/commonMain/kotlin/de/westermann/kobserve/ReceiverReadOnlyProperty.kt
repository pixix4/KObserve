package de.westermann.kobserve

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

fun <T, R> ReadOnlyProperty<R>.map(attribute: KProperty1<R, T>) =
    ReceiverReadOnlyProperty(attribute, this)
