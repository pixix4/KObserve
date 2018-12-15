package de.westermann.kobserve.basic

import de.westermann.kobserve.EventHandler
import de.westermann.kobserve.ListenerReference
import de.westermann.kobserve.ReadOnlyProperty
import kotlin.reflect.KProperty1

open class FlatMapReadOnlyProperty<R, T>(
    protected val transform: (R) -> ReadOnlyProperty<T>,
    protected val receiver: ReadOnlyProperty<R>
) : ReadOnlyProperty<T> {

    override fun get(): T {
        return transform(receiver.value).value
    }

    final override val onChange = EventHandler<Unit>()

    private lateinit var reference: ListenerReference<Unit>

    private fun updateReference() {
        if (this::reference.isInitialized && reference.isAdded) {
            reference.remove()
        }

        transform(receiver.value).onChange.reference {
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

fun <R, T> ReadOnlyProperty<R>.flatMapReadOnlyBinding(transform: (R) -> ReadOnlyProperty<T>): ReadOnlyProperty<T> =
    FlatMapReadOnlyProperty(transform, this)
