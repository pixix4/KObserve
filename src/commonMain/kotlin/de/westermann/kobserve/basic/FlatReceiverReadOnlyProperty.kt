package de.westermann.kobserve.basic

import de.westermann.kobserve.EventHandler
import de.westermann.kobserve.ListenerReference
import de.westermann.kobserve.ReadOnlyProperty
import kotlin.reflect.KProperty1

open class FlatReceiverReadOnlyProperty<R, T>(
    private val attribute: KProperty1<R, ReadOnlyProperty<T>>,
    protected val receiver: ReadOnlyProperty<R>
) : ReadOnlyProperty<T> {

    override fun get(): T {
        return attribute.get(receiver.value).value
    }

    final override val onChange = EventHandler<Unit>()

    private lateinit var reference: ListenerReference<Unit>

    private fun updateReference() {
        if (this::reference.isInitialized && reference.isAdded) {
            reference.remove()
        }

        attribute.get(receiver.value).onChange.reference {
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

fun <R, T> ReadOnlyProperty<R>.flatMapBinding(attribute: KProperty1<R, ReadOnlyProperty<T>>): ReadOnlyProperty<T> =
    FlatReceiverReadOnlyProperty(attribute, this)
