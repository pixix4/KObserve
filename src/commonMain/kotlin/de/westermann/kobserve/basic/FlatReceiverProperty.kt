package de.westermann.kobserve.basic

import de.westermann.kobserve.Binding
import de.westermann.kobserve.Property
import de.westermann.kobserve.ReadOnlyProperty
import kotlin.reflect.KProperty1


class FlatReceiverProperty<R, T>(
    val mutableAttribute: KProperty1<R, Property<T>>,
    receiver: ReadOnlyProperty<R>
) : FlatReceiverReadOnlyProperty<R, T>(mutableAttribute, receiver), Property<T> {

    override fun set(value: T) {
        super.set(value)
        mutableAttribute.get(receiver.value).value = value
    }

    override var binding: Binding<T> = Binding.Unbound()
}

fun <R, T> ReadOnlyProperty<R>.flatMapBinding(attribute: KProperty1<R, Property<T>>): Property<T> =
    FlatReceiverProperty(attribute, this)
