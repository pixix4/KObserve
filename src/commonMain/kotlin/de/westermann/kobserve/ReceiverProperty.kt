package de.westermann.kobserve

import kotlin.reflect.KMutableProperty1


class ReceiverProperty<T, R>(
    private val attribute: KMutableProperty1<R, T>,
    private val receiver: ReadOnlyProperty<R>
) : Property<T> {
    override fun set(value: T) {
        attribute.set(receiver.value, value)
        onChange.emit(Unit)
    }

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

fun <T, R> ReadOnlyProperty<R>.map(attribute: KMutableProperty1<R, T>) =
    ReceiverProperty(attribute, this)
