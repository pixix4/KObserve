package de.westermann.kobserve

import kotlin.reflect.KProperty

/**
 * Represents a read and write property of type 'T'.
 */
interface Property<T> : ReadOnlyProperty<T> {

    /**
     * Set the current value
     */
    fun set(value: T)

    /**
     * Convenient access to the get and set method.
     */
    override var value: T
        get() = get()
        set(value) = set(value)

    operator fun setValue(container: Any?, property: KProperty<*>, value: T) = set(value)
}
