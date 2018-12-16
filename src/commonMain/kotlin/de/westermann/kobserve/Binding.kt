package de.westermann.kobserve

/**
 * Represents the current binding state,
 */
sealed class Binding<T>() {

    /**
     * Returns the current binding state.
     */
    val isBound: Boolean
        get() = this !is Unbound<T>

    /**
     * Unbound all corresponding properties.
     */
    abstract fun unbind()

    /**
     * Check if the property is writeable.
     *
     * @throws IllegalStateException if the property is bound in readonly mode.
     */
    open fun checkWrite(value: T) {}

    /**
     * Represents an unbound property state.
     */
    class Unbound<T> : Binding<T>() {
        override fun unbind() = throw IllegalStateException("Property is currently not bounded!")
    }

    /**
     * Represents an readonly binding state.
     */
    class ReadOnlyBinding<T>(val property: Property<T>, val target: ReadOnlyProperty<T>) : Binding<T>() {

        private var targetReference: ListenerReference<Unit>?

        override fun unbind() {
            targetReference?.remove()
        }

        override fun checkWrite(value: T) {
            if (value != target.value) {
                throw IllegalStateException("Property is bounded in readonly mode!")
            }
        }

        init {
            property.value = target.value

            targetReference = target.onChange.reference {
                val newValue = target.value
                if (property.value != newValue) {
                    property.value = newValue
                }
            }
        }
    }

    /**
     * Represents a bidirectional binding state.
     */
    class BidirectionalBinding<T>(val property: Property<T>, val target: Property<T>) : Binding<T>() {

        private var propertyReference: ListenerReference<Unit>?
        private var targetReference: ListenerReference<Unit>?

        override fun unbind() {
            propertyReference?.remove()
            targetReference?.remove()
        }

        init {
            property.value = target.value

            propertyReference = property.onChange.reference {
                val newValue = property.value
                if (target.value != newValue) {
                    target.value = newValue
                }
            }

            targetReference = target.onChange.reference {
                val newValue = target.value
                if (property.value != newValue) {
                    property.value = newValue
                }
            }
        }
    }
}
