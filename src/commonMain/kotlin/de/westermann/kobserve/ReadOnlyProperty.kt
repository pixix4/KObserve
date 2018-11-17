package de.westermann.kobserve

import kotlin.reflect.KProperty

/**
 * Represents a read only property of type 'T'.
 */
interface ReadOnlyProperty<T> {

    /**
     * Get the current value.
     */
    fun get(): T

    /**
     * Convenient access to the get method.
     */
    val value: T
        get() = get()

    operator fun getValue(container: Any?, property: KProperty<*>) = get()

    /**
     * Change event handler is called whenever the properties value is changed.
     */
    val onChange: EventHandler<Unit>
}
