package de.westermann.kobserve

/**
 * This class represents a reference to a listener for the event handler.
 *
 * @property handler Reference to the parent event handler.
 * @property listener The referencing event listener.
 */
class ListenerReference<T>(
    val handler: EventHandler<T>,
    val listener: (T) -> Unit
) {

    /**
     * Trigger the referencing event listener.
     * This call does not affect the parent event handler.
     *
     * @param event The event listener call parameter.
     */
    fun trigger(event: T) {
        listener(event)
    }

    /**
     * Checks if the referencing event listener is part of the parent event handler.
     */
    val isAdded: Boolean
        get() = listener in handler

    /**
     * Checks if the referencing event listener is not part of the parent event handler.
     */
    val isRemoved: Boolean
        get() = !isAdded

    /**
     * Add the referencing event listener to parent event handler if it is not already present.
     *
     * @return True if the referencing event listener was added.
     */
    fun add(): Boolean {
        if (isAdded) {
            return false
        }

        handler.addListener(listener)
        return true
    }

    /**
     * Remove the referencing event listener to parent event handler if it is present.
     *
     * @return True if the referencing event listener was removed.
     */
    fun remove(): Boolean {
        if (isRemoved) {
            return false
        }

        handler.removeListener(listener)
        return true
    }
}
