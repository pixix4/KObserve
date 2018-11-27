package de.westermann.kobserve.basic

import de.westermann.kobserve.Binding
import de.westermann.kobserve.Property
import kotlin.reflect.KMutableProperty0

class DirectReceiverProperty<T>(
    override val attribute: KMutableProperty0<T>
) : DirectReceiverReadOnlyProperty<T>(attribute), Property<T> {

    override fun set(value: T) {
        super.set(value)
        if (get() != value) {
            attribute.set(value)
            onChange.emit(Unit)
        }
    }

    override var binding: Binding<T> = Binding.Unbound()
}

fun <T> property(attribute: KMutableProperty0<T>): Property<T> =
    DirectReceiverProperty(attribute)

fun <T> KMutableProperty0<T>.observe(): Property<T> = DirectReceiverProperty(this)
