package de.westermann.kobserve.basic

import de.westermann.kobserve.Property
import de.westermann.kobserve.ReadOnlyProperty

class FunctionProperty<T>(
    override val functionAccessor: FunctionAccessor<T>
) : FunctionReadOnlyProperty<T>(functionAccessor), Property<T> {

    override fun set(value: T) = functionAccessor.set(value)

    constructor(
        functionAccessor: FunctionAccessor<T>,
        vararg properties: ReadOnlyProperty<*>
    ) : this(functionAccessor) {
        listenTo(*properties)
    }
}

interface FunctionAccessor<T> : FunctionReadOnlyAccessor<T> {
    fun set(value: T)
}
