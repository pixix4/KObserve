package de.westermann.kobserve.basic

import de.westermann.kobserve.Binding
import de.westermann.kobserve.EventHandler
import de.westermann.kobserve.Property

class ObjectProperty<T>(initValue: T) : Property<T> {
    private var internal: T = initValue

    override fun set(value: T) {
        super.set(value)
        if (internal != value) {
            internal = value
            onChange.emit(Unit)
        }
    }

    override fun get(): T = internal

    override val onChange = EventHandler<Unit>()
    override var binding: Binding<T> = Binding.Unbound()
}

fun <T> property(initValue: T): Property<T> = ObjectProperty(initValue)
fun <T> T.observe(): Property<T> = ObjectProperty(this)
