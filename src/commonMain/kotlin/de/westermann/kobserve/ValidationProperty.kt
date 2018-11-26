package de.westermann.kobserve

interface ValidationProperty<T> : Property<T> {
    val validProperty: ReadOnlyProperty<Boolean>
    val valid: Boolean
}
