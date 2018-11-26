package de.westermann.kobserve.basic

import de.westermann.kobserve.Property
import de.westermann.kobserve.ReadOnlyProperty

interface ValidationProperty<T> : Property<T> {
    val validProperty: ReadOnlyProperty<Boolean>
    val valid: Boolean
}
