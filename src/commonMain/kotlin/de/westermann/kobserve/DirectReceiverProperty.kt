package de.westermann.kobserve

import kotlin.reflect.KMutableProperty0

class DirectReceiverProperty<T>(
    private val attribute: KMutableProperty0<T>
) : Property<T> {
    override fun set(value: T) {
        attribute.set(value)
        onChange.emit(Unit)
    }

    override fun get(): T {
        return attribute.get()
    }

    override val onChange = EventHandler<Unit>()

}

fun <T> property(attribute: KMutableProperty0<T>) =
    DirectReceiverProperty(attribute)

fun <T> KMutableProperty0<T>.observe() = DirectReceiverProperty(this)
