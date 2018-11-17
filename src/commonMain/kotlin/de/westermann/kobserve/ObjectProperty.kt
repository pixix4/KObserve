package de.westermann.kobserve

class ObjectProperty<T>(initValue: T) : Property<T> {
    private var internal: T = initValue

    override fun set(value: T) {
        if (internal != value) {
            internal = value
            onChange.emit(Unit)
        }
    }

    override fun get(): T = internal

    override val onChange = EventHandler<Unit>()
}

fun <T> property(initValue: T) = ObjectProperty(initValue)
fun <T> T.observe() = ObjectProperty(this)