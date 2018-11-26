package de.westermann.kobserve.basic

import de.westermann.kobserve.EventHandler
import de.westermann.kobserve.Property
import de.westermann.kobserve.ValidationProperty
import de.westermann.kobserve.listenTo

class ValidationMappedProperty<T>(
    private val property: Property<T>,
    private val validator: (T) -> Boolean
) : ValidationProperty<T> {
    override val onChange = EventHandler<Unit>()

    override fun get(): T = property.get()

    override fun set(value: T) {
        validProperty.value = validator(value)
        if (valid) {
            property.set(value)
        }
    }

    override val validProperty = property(true)
    override val valid by validProperty

    init {
        onChange.listenTo(property.onChange)
    }
}

fun <T> Property<T>.validate(validator: (T) -> Boolean) = ValidationMappedProperty(this, validator)
