package de.westermann.kobserve.basic

import de.westermann.kobserve.*

class SimpleValidationProperty<T>(
    private val property: Property<T>,
    private val validator: (T) -> Boolean
) : ValidationProperty<T> {
    override val onChange = EventHandler<Unit>()

    override fun get(): T = property.get()

    override fun set(value: T) {
        super.set(value)
        validProperty.value = validator(value)
        if (valid) {
            property.set(value)
        }
    }

    override val validProperty = property(true)
    override val valid by validProperty
    override var binding: Binding<T> = Binding.Unbound()

    init {
        onChange.listenTo(property.onChange)
    }
}

fun <T> Property<T>.validate(validator: (T) -> Boolean): ValidationProperty<T> = SimpleValidationProperty(this, validator)
