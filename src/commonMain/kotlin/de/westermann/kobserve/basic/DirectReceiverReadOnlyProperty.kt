package de.westermann.kobserve.basic

import de.westermann.kobserve.EventHandler
import de.westermann.kobserve.ReadOnlyProperty
import kotlin.reflect.KProperty0

open class DirectReceiverReadOnlyProperty<T>(
    protected open val attribute: KProperty0<T>
) : ReadOnlyProperty<T> {

    override fun get(): T {
        return attribute.get()
    }

    override val onChange = EventHandler<Unit>()

}

fun <T> property(attribute: KProperty0<T>) =
    DirectReceiverReadOnlyProperty(attribute)

fun <T> KProperty0<T>.observe() = DirectReceiverReadOnlyProperty(this)
