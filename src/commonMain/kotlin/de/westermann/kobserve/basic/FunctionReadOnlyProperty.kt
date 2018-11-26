package de.westermann.kobserve.basic

import de.westermann.kobserve.EventHandler
import de.westermann.kobserve.ReadOnlyProperty
import de.westermann.kobserve.listenTo

open class FunctionReadOnlyProperty<T>(
    protected open val functionAccessor: FunctionReadOnlyAccessor<T>
) : ReadOnlyProperty<T> {
    override val onChange = EventHandler<Unit>()

    override fun get(): T = functionAccessor.get()

    fun listenTo(vararg properties: ReadOnlyProperty<*>) {
        properties.forEach {
            onChange.listenTo(it.onChange)
        }
    }

    constructor(
        functionAccessor: FunctionReadOnlyAccessor<T>,
        vararg properties: ReadOnlyProperty<*>
    ) : this(functionAccessor) {
        listenTo(*properties)
    }
}

interface FunctionReadOnlyAccessor<T> {
    fun get(): T
}

fun <T> property(
    functionAccessor: FunctionReadOnlyAccessor<T>,
    vararg properties: ReadOnlyProperty<*>
): ReadOnlyProperty<T> = FunctionReadOnlyProperty(functionAccessor, *properties)
