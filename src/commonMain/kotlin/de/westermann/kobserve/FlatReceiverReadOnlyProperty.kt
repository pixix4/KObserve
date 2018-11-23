package de.westermann.kobserve

import kotlin.reflect.KProperty1

class FlatReceiverReadOnlyProperty<T, R>(
    private val attribute: KProperty1<R, ReadOnlyProperty<T>>,
    private val receiver: ReadOnlyProperty<R>
) : ReadOnlyProperty<T> {

    private val property: ReadOnlyProperty<T>
        get() = attribute.get(receiver.value)

    override fun get(): T {
        return property.value
    }

    override val onChange = EventHandler<Unit>()

    private lateinit var reference: ListenerReference<Unit>

    private fun updateReference() {
        if (this::reference.isInitialized && reference.isAdded) {
            reference.remove()
        }

        property.onChange.reference {
            onChange.emit(Unit)
        }?.let { reference = it }
    }

    init {
        receiver.onChange {
            updateReference()
            onChange.emit(Unit)
        }
        updateReference()
    }
}

fun <T, R> ReadOnlyProperty<R>.flatMap(attribute: KProperty1<R, ReadOnlyProperty<T>>) =
    FlatReceiverReadOnlyProperty(attribute, this)
