package io.github.pixix4.kobserve.property

import io.github.pixix4.kobserve.Binding
import io.github.pixix4.kobserve.base.ObservableProperty
import io.github.pixix4.kobserve.base.ObservableValue
import kotlin.reflect.KProperty1


class FlatMapProperty<R, T>(
    private val transform: (R) -> ObservableProperty<T>,
    receiver: ObservableValue<R>
) : FlatMapObservableValue<R, T>(transform, receiver), ObservableProperty<T> {

    override var binding: Binding<T> = Binding.Unbound()

    override fun set(value: T) {
        super.set(value)
        transform(receiver.value).value = value
    }
}

fun <T, R> ObservableValue<R>.flatMapMutableBinding(transform: (R) -> ObservableProperty<T>): ObservableProperty<T> =
    FlatMapProperty(transform, this)

fun <T> ObservableValue<ObservableProperty<T>>.flattenMutableBinding(): ObservableProperty<T> =
    FlatMapProperty({ it }, this)

fun <R, T> ObservableValue<R>.flatMapMutableBinding(attribute: KProperty1<R, ObservableProperty<T>>): ObservableProperty<T> =
    FlatMapProperty(attribute::get, this)
