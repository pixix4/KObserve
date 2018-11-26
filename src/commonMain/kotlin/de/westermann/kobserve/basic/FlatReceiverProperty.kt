package de.westermann.kobserve.basic

import de.westermann.kobserve.Property
import de.westermann.kobserve.ReadOnlyProperty
import kotlin.reflect.KProperty1


class FlatReceiverProperty<R, T>(
    override val attribute: KProperty1<R, Property<T>>,
    receiver: ReadOnlyProperty<R>
) : FlatReceiverReadOnlyProperty<R, T>(attribute, receiver), Property<T> {

    override val property: Property<T>
        get() = attribute.get(receiver.value)

    override fun set(value: T) {
        property.value = value
    }
}

fun <T, R> ReadOnlyProperty<R>.flatMapBinding(attribute: KProperty1<R, Property<T>>): Property<T> =
    FlatReceiverProperty(attribute, this)
