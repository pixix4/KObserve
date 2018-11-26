package de.westermann.kobserve.basic

import de.westermann.kobserve.ReadOnlyProperty
import de.westermann.kobserve.ValidationProperty

class FunctionProperty<T>(
    override val functionAccessor: FunctionAccessor<T>
) : FunctionReadOnlyProperty<T>(functionAccessor), ValidationProperty<T> {

    override fun set(value: T) {
        validProperty.value = functionAccessor.set(value)
    }

    override val validProperty = property(true)
    override val valid by validProperty

    constructor(
        functionAccessor: FunctionAccessor<T>,
        vararg properties: ReadOnlyProperty<*>
    ) : this(functionAccessor) {
        listenTo(*properties)
    }
}

interface FunctionAccessor<T> : FunctionReadOnlyAccessor<T> {
    fun set(value: T): Boolean
}
