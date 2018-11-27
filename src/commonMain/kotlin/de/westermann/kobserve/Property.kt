package de.westermann.kobserve

import kotlin.reflect.KProperty

/**
 * Represents a read and write property of type 'T'.
 */
interface Property<T> : ReadOnlyProperty<T> {

    var binding: Binding<T>

    /**
     * Set the current value
     */
    fun set(value: T) {
        binding.checkWrite(value)
    }

    /**
     * Convenient access to the get and set method.
     */
    override var value: T
        get() = get()
        set(value) = set(value)

    operator fun setValue(container: Any?, property: KProperty<*>, value: T) = set(value)

    fun bind(target: ReadOnlyProperty<T>) {
        if (binding.isBound) {
            throw IllegalStateException("Property is already bound!")
        }

        binding = Binding.ReadOnlyBinding(this, target)
    }

    fun bindBidirectional(target: Property<T>) {
        if (binding.isBound) {
            throw IllegalStateException("Property is already bound!")
        }

        binding = Binding.BidirectionalBinding(this, target)
    }

    fun unbind() {
        binding.unbind()
        binding = Binding.Unbound()
    }
}
