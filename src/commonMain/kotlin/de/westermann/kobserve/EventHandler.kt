package de.westermann.kobserve

/**
 * This class represents a simple event handler who manages listeners for an event of type 'T'.
 */
open class EventHandler<T>() : Collection<(T) -> Unit> {

    private var listeners: Set<(T) -> Unit> = emptySet()

    /**
     * Add an event listener to this handler if it is not already present.
     *
     * @param listener The event listener to add.
     *
     * @return The event listener that was added or null if it was already present.
     */
    fun addListener(listener: (T) -> Unit): ((T) -> Unit)? {
        if (listener in listeners) {
            return null
        }

        listeners += listener
        return listener
    }

    /**
     * Remove an event listener from this handler.
     *
     * @param listener The event listener to remove.
     */
    fun removeListener(listener: (T) -> Unit) {
        listeners -= listener
    }

    /**
     * Remove all event listeners from this handler.
     */
    fun clearListeners() {
        listeners = emptySet()
    }

    /**
     * Emit an event to all assigned event listeners.
     *
     * @param event The event to emit.
     */
    fun emit(event: T) {
        listeners.forEach {
            it(event)
        }
    }

    /**
     * @see addListener
     */
    operator fun invoke(listener: (T) -> Unit) {
        addListener(listener)
    }

    /**
     * @see addListener
     */
    operator fun plusAssign(listener: (T) -> Unit) {
        addListener(listener)
    }

    /**
     * @see removeListener
     */
    operator fun minusAssign(listener: (T) -> Unit) {
        removeListener(listener)
    }

    /**
     * Add an event listener to this handler if it is not already present.
     *
     * @param listener The event listener to add.
     *
     * @return A reference object to the added listener or null if it was already present.
     */
    fun reference(listener: (T) -> Unit): ListenerReference<T>? {
        return addListener(listener)?.let { ListenerReference(this, it) }
    }

    /**
     * Returns the count of assigned event listeners.
     */
    override val size: Int
        get() = listeners.size

    override fun contains(element: (T) -> Unit): Boolean {
        return listeners.contains(element)
    }

    override fun containsAll(elements: Collection<(T) -> Unit>): Boolean {
        return listeners.containsAll(elements)
    }

    override fun isEmpty(): Boolean {
        return listeners.isEmpty()
    }

    override fun iterator(): Iterator<(T) -> Unit> {
        return listeners.iterator()
    }

    constructor(vararg dependencies: EventHandler<T>) : this() {
        dependencies.forEach {
            it.addListener(this::emit)
        }
    }
}

/**
 * Utility function that allows simple event binding of an unit event to another generic event.
 *
 * @param handler An generic event handler to listen to.
 * @receiver The unit event handler that should listen.
 */
fun EventHandler<Unit>.listenTo(handler: EventHandler<*>) {
    handler {
        emit(Unit)
    }
}
