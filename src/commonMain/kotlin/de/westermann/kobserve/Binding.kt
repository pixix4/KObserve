package de.westermann.kobserve

sealed class Binding<T>() {

    val isBound: Boolean
        get() = this !is Unbound<T>

    abstract fun unbind()
    open fun checkWrite(value: T) {}

    class Unbound<T> : Binding<T>() {
        override fun unbind() = throw IllegalStateException("Property is currently not bounded!")
    }

    class ReadOnlyBinding<T>(val property: Property<T>, val target: ReadOnlyProperty<T>) : Binding<T>() {

        private var targetReference: ListenerReference<Unit>?

        override fun unbind() {
            targetReference?.remove()
        }

        override fun checkWrite(value: T) {
            if (value != target.value) {
                throw IllegalStateException("Property is bounded in read only mode!")
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
