package de.westermann.kobserve.basic

import de.westermann.kobserve.Property
import de.westermann.kobserve.ReadOnlyProperty
import kotlin.reflect.KMutableProperty1

class ReceiverProperty<R, T>(
    private val attribute: KMutableProperty1<R, T>,
    private val receiver: ReadOnlyProperty<R>
) : ReceiverReadOnlyProperty<R, T>(attribute, receiver), Property<T> {

    override var internal: T = attribute.get(receiver.value)

    override fun set(value: T) {
        if (internal != value) {
            attribute.set(receiver.value, value)
            receiver.onChange.emit(Unit)
        }
    }
}

fun <T, R> ReadOnlyProperty<R>.mapBinding(attribute: KMutableProperty1<R, T>): Property<T> =
    ReceiverProperty(attribute, this)
