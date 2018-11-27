package de.westermann.kobserve.basic

import de.westermann.kobserve.Binding
import de.westermann.kobserve.Property
import de.westermann.kobserve.ReadOnlyProperty
import de.westermann.kobserve.ValidationProperty

class FunctionProperty<T>(
    override val functionAccessor: FunctionAccessor<T>
) : FunctionReadOnlyProperty<T>(functionAccessor), ValidationProperty<T> {

    override fun set(value: T) {
        super.set(value)
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

    override var binding: Binding<T> = Binding.Unbound()
}

interface FunctionAccessor<T> : FunctionReadOnlyAccessor<T> {
    fun set(value: T): Boolean
}

fun <T> property(
    functionAccessor: FunctionAccessor<T>,
    vararg properties: ReadOnlyProperty<*>
): Property<T> = FunctionProperty(functionAccessor, *properties)

fun <A, B, C> ReadOnlyProperty<A>.join(
    property2: ReadOnlyProperty<B>,
    block: (A, B) -> C
): ReadOnlyProperty<C> {
    return FunctionReadOnlyProperty(object : FunctionReadOnlyAccessor<C> {
        override fun get(): C {
            return block(this@join.value, property2.value)
        }
    }, this, property2)
}
