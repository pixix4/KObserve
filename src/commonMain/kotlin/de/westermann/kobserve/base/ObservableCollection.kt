package de.westermann.kobserve.base

import de.westermann.kobserve.event.EventHandler

interface ObservableCollection<out T>: ObservableValue<Collection<@UnsafeVariance T>>, Collection<T> {

    val onAdd: EventHandler<@UnsafeVariance T>
    val onRemove: EventHandler<@UnsafeVariance T>
    val onClear: EventHandler<Collection<@UnsafeVariance T>>

    override fun get(): Collection<T> {
        return this
    }
}
