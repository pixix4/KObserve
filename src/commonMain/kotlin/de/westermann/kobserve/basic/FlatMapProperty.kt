package de.westermann.kobserve.basic

import de.westermann.kobserve.Binding
import de.westermann.kobserve.Property
import de.westermann.kobserve.ReadOnlyProperty
import kotlin.reflect.KProperty1


class FlatMapProperty<R, T>(
    val mutableTransform: (R) -> Property<T>,
    receiver: ReadOnlyProperty<R>
) : FlatMapReadOnlyProperty<R, T>(mutableTransform, receiver), Property<T> {

    override fun set(value: T) {
        super.set(value)
        mutableTransform(receiver.value).value = value
    }

    override var binding: Binding<T> = Binding.Unbound()
}

fun <T, R> ReadOnlyProperty<R>.flatMapBinding(transform: (R) -> Property<T>): Property<T> =
    FlatMapProperty(transform, this)
