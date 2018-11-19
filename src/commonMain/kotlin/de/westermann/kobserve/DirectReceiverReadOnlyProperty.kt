package de.westermann.kobserve

import kotlin.reflect.KProperty0

class DirectReceiverReadOnlyProperty<T>(
    private val attribute: KProperty0<T>
) : ReadOnlyProperty<T> {

    override fun get(): T {
        return attribute.get()
    }

    override val onChange = EventHandler<Unit>()

}

fun <T> property(attribute: KProperty0<T>) =
    DirectReceiverReadOnlyProperty(attribute)

fun <T> KProperty0<T>.observe() = DirectReceiverReadOnlyProperty(this)
