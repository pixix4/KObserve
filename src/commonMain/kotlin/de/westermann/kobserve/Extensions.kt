package de.westermann.kobserve

import de.westermann.kobserve.basic.join
import de.westermann.kobserve.basic.mapBinding
import de.westermann.kobserve.list.ObservableReadOnlyList
import de.westermann.kobserve.list.mapObservable
import kotlin.jvm.JvmName

// Boolean

infix fun ReadOnlyProperty<Boolean>.and(property: ReadOnlyProperty<Boolean>) =
    join(property, Boolean::and)

infix fun ReadOnlyProperty<Boolean>.or(property: ReadOnlyProperty<Boolean>) =
    join(property, Boolean::or)

infix fun ReadOnlyProperty<Boolean>.xor(property: ReadOnlyProperty<Boolean>) =
    join(property, Boolean::xor)

operator fun ReadOnlyProperty<Boolean>.not() =
    mapBinding(Boolean::not)

// Int - Int

@JvmName("propertyIntPlusInt")
operator fun ReadOnlyProperty<Int>.plus(property: ReadOnlyProperty<Int>) =
    join(property, Int::plus)

@JvmName("propertyIntMinusInt")
operator fun ReadOnlyProperty<Int>.minus(property: ReadOnlyProperty<Int>) =
    join(property, Int::minus)

@JvmName("propertyIntTimesInt")
operator fun ReadOnlyProperty<Int>.times(property: ReadOnlyProperty<Int>) =
    join(property, Int::times)

@JvmName("propertyIntDivInt")
operator fun ReadOnlyProperty<Int>.div(property: ReadOnlyProperty<Int>) =
    join(property, Int::div)

@JvmName("propertyIntRemInt")
operator fun ReadOnlyProperty<Int>.rem(property: ReadOnlyProperty<Int>) =
    join(property, Int::rem)

@JvmName("propertyIntUnaryMinusInt")
operator fun ReadOnlyProperty<Int>.unaryMinus() =
    mapBinding(Int::unaryMinus)

// Long - Long

@JvmName("propertyLongPlusLong")
operator fun ReadOnlyProperty<Long>.plus(property: ReadOnlyProperty<Long>) =
    join(property, Long::plus)

@JvmName("propertyLongMinusLong")
operator fun ReadOnlyProperty<Long>.minus(property: ReadOnlyProperty<Long>) =
    join(property, Long::minus)

@JvmName("propertyLongTimesLong")
operator fun ReadOnlyProperty<Long>.times(property: ReadOnlyProperty<Long>) =
    join(property, Long::times)

@JvmName("propertyLongDivLong")
operator fun ReadOnlyProperty<Long>.div(property: ReadOnlyProperty<Long>) =
    join(property, Long::div)

@JvmName("propertyLongRemLong")
operator fun ReadOnlyProperty<Long>.rem(property: ReadOnlyProperty<Long>) =
    join(property, Long::rem)

@JvmName("propertyLongUnaryMinusLong")
operator fun ReadOnlyProperty<Long>.unaryMinus() =
    mapBinding(Long::unaryMinus)

// Float - Float

@JvmName("propertyFloatPlusFloat")
operator fun ReadOnlyProperty<Float>.plus(property: ReadOnlyProperty<Float>) =
    join(property, Float::plus)

@JvmName("propertyFloatMinusFloat")
operator fun ReadOnlyProperty<Float>.minus(property: ReadOnlyProperty<Float>) =
    join(property, Float::minus)

@JvmName("propertyFloatTimesFloat")
operator fun ReadOnlyProperty<Float>.times(property: ReadOnlyProperty<Float>) =
    join(property, Float::times)

@JvmName("propertyFloatDivFloat")
operator fun ReadOnlyProperty<Float>.div(property: ReadOnlyProperty<Float>) =
    join(property, Float::div)

@JvmName("propertyFloatRemFloat")
operator fun ReadOnlyProperty<Float>.rem(property: ReadOnlyProperty<Float>) =
    join(property, Float::rem)

@JvmName("propertyFloatUnaryMinus")
operator fun ReadOnlyProperty<Float>.unaryMinus() =
    mapBinding(Float::unaryMinus)

// Double - Double

@JvmName("propertyDoublePlusDouble")
operator fun ReadOnlyProperty<Double>.plus(property: ReadOnlyProperty<Double>) =
    join(property, Double::plus)

@JvmName("propertyDoubleMinusDouble")
operator fun ReadOnlyProperty<Double>.minus(property: ReadOnlyProperty<Double>) =
    join(property, Double::minus)

@JvmName("propertyDoubleTimesDouble")
operator fun ReadOnlyProperty<Double>.times(property: ReadOnlyProperty<Double>) =
    join(property, Double::times)

@JvmName("propertyDoubleDivDouble")
operator fun ReadOnlyProperty<Double>.div(property: ReadOnlyProperty<Double>) =
    join(property, Double::div)

@JvmName("propertyDoubleRemDouble")
operator fun ReadOnlyProperty<Double>.rem(property: ReadOnlyProperty<Double>) =
    join(property, Double::rem)

@JvmName("propertyDoubleUnaryMinus")
operator fun ReadOnlyProperty<Double>.unaryMinus() =
    mapBinding(Double::unaryMinus)

// Int - Long

@JvmName("propertyIntPlusLong")
operator fun ReadOnlyProperty<Int>.plus(property: ReadOnlyProperty<Long>) =
    join(property, Int::plus)

@JvmName("propertyIntMinusLong")
operator fun ReadOnlyProperty<Int>.minus(property: ReadOnlyProperty<Long>) =
    join(property, Int::minus)

@JvmName("propertyIntTimesLong")
operator fun ReadOnlyProperty<Int>.times(property: ReadOnlyProperty<Long>) =
    join(property, Int::times)

@JvmName("propertyIntDivLong")
operator fun ReadOnlyProperty<Int>.div(property: ReadOnlyProperty<Long>) =
    join(property, Int::div)

@JvmName("propertyIntRemLong")
operator fun ReadOnlyProperty<Int>.rem(property: ReadOnlyProperty<Long>) =
    join(property, Int::rem)

// Long - Int

@JvmName("propertyLongPlusInt")
operator fun ReadOnlyProperty<Long>.plus(property: ReadOnlyProperty<Int>) =
    join(property, Long::plus)

@JvmName("propertyLongMinusInt")
operator fun ReadOnlyProperty<Long>.minus(property: ReadOnlyProperty<Int>) =
    join(property, Long::minus)

@JvmName("propertyLongTimesInt")
operator fun ReadOnlyProperty<Long>.times(property: ReadOnlyProperty<Int>) =
    join(property, Long::times)

@JvmName("propertyLongDivInt")
operator fun ReadOnlyProperty<Long>.div(property: ReadOnlyProperty<Int>) =
    join(property, Long::div)

@JvmName("propertyLongRemInt")
operator fun ReadOnlyProperty<Long>.rem(property: ReadOnlyProperty<Int>) =
    join(property, Long::rem)

// Float - Double

@JvmName("propertyFloatPlusDouble")
operator fun ReadOnlyProperty<Float>.plus(property: ReadOnlyProperty<Double>) =
    join(property, Float::plus)

@JvmName("propertyFloatMinusDouble")
operator fun ReadOnlyProperty<Float>.minus(property: ReadOnlyProperty<Double>) =
    join(property, Float::minus)

@JvmName("propertyFloatTimesDouble")
operator fun ReadOnlyProperty<Float>.times(property: ReadOnlyProperty<Double>) =
    join(property, Float::times)

@JvmName("propertyFloatDivDouble")
operator fun ReadOnlyProperty<Float>.div(property: ReadOnlyProperty<Double>) =
    join(property, Float::div)

@JvmName("propertyFloatRemDouble")
operator fun ReadOnlyProperty<Float>.rem(property: ReadOnlyProperty<Double>) =
    join(property, Float::rem)

// Double - Float

@JvmName("propertyDoublePlusFloat")
operator fun ReadOnlyProperty<Double>.plus(property: ReadOnlyProperty<Float>) =
    join(property, Double::plus)

@JvmName("propertyDoubleMinusFloat")
operator fun ReadOnlyProperty<Double>.minus(property: ReadOnlyProperty<Float>) =
    join(property, Double::minus)

@JvmName("propertyDoubleTimesFloat")
operator fun ReadOnlyProperty<Double>.times(property: ReadOnlyProperty<Float>) =
    join(property, Double::times)

@JvmName("propertyDoubleDivFloat")
operator fun ReadOnlyProperty<Double>.div(property: ReadOnlyProperty<Float>) =
    join(property, Double::div)

@JvmName("propertyDoubleRemFloat")
operator fun ReadOnlyProperty<Double>.rem(property: ReadOnlyProperty<Float>) =
    join(property, Double::rem)

// Float - Int

@JvmName("propertyFloatPlusInt")
operator fun ReadOnlyProperty<Float>.plus(property: ReadOnlyProperty<Int>) =
    join(property, Float::plus)

@JvmName("propertyFloatMinusInt")
operator fun ReadOnlyProperty<Float>.minus(property: ReadOnlyProperty<Int>) =
    join(property, Float::minus)

@JvmName("propertyFloatTimesInt")
operator fun ReadOnlyProperty<Float>.times(property: ReadOnlyProperty<Int>) =
    join(property, Float::times)

@JvmName("propertyFloatDivInt")
operator fun ReadOnlyProperty<Float>.div(property: ReadOnlyProperty<Int>) =
    join(property, Float::div)

@JvmName("propertyFloatRemInt")
operator fun ReadOnlyProperty<Float>.rem(property: ReadOnlyProperty<Int>) =
    join(property, Float::rem)

// Int - Float

@JvmName("propertyIntPlusFloat")
operator fun ReadOnlyProperty<Int>.plus(property: ReadOnlyProperty<Float>) =
    join(property, Int::plus)

@JvmName("propertyIntMinusFloat")
operator fun ReadOnlyProperty<Int>.minus(property: ReadOnlyProperty<Float>) =
    join(property, Int::minus)

@JvmName("propertyIntTimesFloat")
operator fun ReadOnlyProperty<Int>.times(property: ReadOnlyProperty<Float>) =
    join(property, Int::times)

@JvmName("propertyIntDivFloat")
operator fun ReadOnlyProperty<Int>.div(property: ReadOnlyProperty<Float>) =
    join(property, Int::div)

@JvmName("propertyIntRemFloat")
operator fun ReadOnlyProperty<Int>.rem(property: ReadOnlyProperty<Float>) =
    join(property, Int::rem)

// Float - Long

@JvmName("propertyFloatPlusLong")
operator fun ReadOnlyProperty<Float>.plus(property: ReadOnlyProperty<Long>) =
    join(property, Float::plus)

@JvmName("propertyFloatMinusLong")
operator fun ReadOnlyProperty<Float>.minus(property: ReadOnlyProperty<Long>) =
    join(property, Float::minus)

@JvmName("propertyFloatTimesLong")
operator fun ReadOnlyProperty<Float>.times(property: ReadOnlyProperty<Long>) =
    join(property, Float::times)

@JvmName("propertyFloatDivLong")
operator fun ReadOnlyProperty<Float>.div(property: ReadOnlyProperty<Long>) =
    join(property, Float::div)

@JvmName("propertyFloatRemLong")
operator fun ReadOnlyProperty<Float>.rem(property: ReadOnlyProperty<Long>) =
    join(property, Float::rem)

// Long - Float

@JvmName("propertyLongPlusFloat")
operator fun ReadOnlyProperty<Long>.plus(property: ReadOnlyProperty<Float>) =
    join(property, Long::plus)

@JvmName("propertyLongMinusFloat")
operator fun ReadOnlyProperty<Long>.minus(property: ReadOnlyProperty<Float>) =
    join(property, Long::minus)

@JvmName("propertyLongTimesFloat")
operator fun ReadOnlyProperty<Long>.times(property: ReadOnlyProperty<Float>) =
    join(property, Long::times)

@JvmName("propertyLongDivFloat")
operator fun ReadOnlyProperty<Long>.div(property: ReadOnlyProperty<Float>) =
    join(property, Long::div)

@JvmName("propertyLongRemFloat")
operator fun ReadOnlyProperty<Long>.rem(property: ReadOnlyProperty<Float>) =
    join(property, Long::rem)

// Long - Double

@JvmName("propertyLongPlusDouble")
operator fun ReadOnlyProperty<Long>.plus(property: ReadOnlyProperty<Double>) =
    join(property, Long::plus)

@JvmName("propertyLongMinusDouble")
operator fun ReadOnlyProperty<Long>.minus(property: ReadOnlyProperty<Double>) =
    join(property, Long::minus)

@JvmName("propertyLongTimesDouble")
operator fun ReadOnlyProperty<Long>.times(property: ReadOnlyProperty<Double>) =
    join(property, Long::times)

@JvmName("propertyLongDivDouble")
operator fun ReadOnlyProperty<Long>.div(property: ReadOnlyProperty<Double>) =
    join(property, Long::div)

@JvmName("propertyLongRemDouble")
operator fun ReadOnlyProperty<Long>.rem(property: ReadOnlyProperty<Double>) =
    join(property, Long::rem)

// Double - Long

@JvmName("propertyDoublePlusLong")
operator fun ReadOnlyProperty<Double>.plus(property: ReadOnlyProperty<Long>) =
    join(property, Double::plus)

@JvmName("propertyDoubleMinusLong")
operator fun ReadOnlyProperty<Double>.minus(property: ReadOnlyProperty<Long>) =
    join(property, Double::minus)

@JvmName("propertyDoubleTimesLong")
operator fun ReadOnlyProperty<Double>.times(property: ReadOnlyProperty<Long>) =
    join(property, Double::times)

@JvmName("propertyDoubleDivLong")
operator fun ReadOnlyProperty<Double>.div(property: ReadOnlyProperty<Long>) =
    join(property, Double::div)

@JvmName("propertyDoubleRemLong")
operator fun ReadOnlyProperty<Double>.rem(property: ReadOnlyProperty<Long>) =
    join(property, Double::rem)

// Int - Double

@JvmName("propertyIntPlusDouble")
operator fun ReadOnlyProperty<Int>.plus(property: ReadOnlyProperty<Double>) =
    join(property, Int::plus)

@JvmName("propertyIntMinusDouble")
operator fun ReadOnlyProperty<Int>.minus(property: ReadOnlyProperty<Double>) =
    join(property, Int::minus)

@JvmName("propertyIntTimesDouble")
operator fun ReadOnlyProperty<Int>.times(property: ReadOnlyProperty<Double>) =
    join(property, Int::times)

@JvmName("propertyIntDivDouble")
operator fun ReadOnlyProperty<Int>.div(property: ReadOnlyProperty<Double>) =
    join(property, Int::div)

@JvmName("propertyIntRemDouble")
operator fun ReadOnlyProperty<Int>.rem(property: ReadOnlyProperty<Double>) =
    join(property, Int::rem)

// Double - Int

@JvmName("propertyDoublePlusInt")
operator fun ReadOnlyProperty<Double>.plus(property: ReadOnlyProperty<Int>) =
    join(property, Double::plus)

@JvmName("propertyDoubleMinusInt")
operator fun ReadOnlyProperty<Double>.minus(property: ReadOnlyProperty<Int>) =
    join(property, Double::minus)

@JvmName("propertyDoubleTimesInt")
operator fun ReadOnlyProperty<Double>.times(property: ReadOnlyProperty<Int>) =
    join(property, Double::times)

@JvmName("propertyDoubleDivInt")
operator fun ReadOnlyProperty<Double>.div(property: ReadOnlyProperty<Int>) =
    join(property, Double::div)

@JvmName("propertyDoubleRemInt")
operator fun ReadOnlyProperty<Double>.rem(property: ReadOnlyProperty<Int>) =
    join(property, Double::rem)

// List

@JvmName("observableIntSum")
fun ObservableReadOnlyList<Int>.sumObservable() = mapBinding { it.sum() }

@JvmName("observableLongSum")
fun ObservableReadOnlyList<Long>.sumObservable() = mapBinding { it.sum() }

@JvmName("observableFloatSum")
fun ObservableReadOnlyList<Float>.sumObservable() = mapBinding { it.sum() }

@JvmName("observableDoubleSum")
fun ObservableReadOnlyList<Double>.sumObservable() = mapBinding { it.sum() }

@JvmName("observableIntAverage")
fun ObservableReadOnlyList<Int>.averageObservable() = mapBinding { it.average() }

@JvmName("observableLongAverage")
fun ObservableReadOnlyList<Long>.averageObservable() = mapBinding { it.average() }

@JvmName("observableFloatAverage")
fun ObservableReadOnlyList<Float>.averageObservable() = mapBinding { it.average() }

@JvmName("observableDoubleAverage")
fun ObservableReadOnlyList<Double>.averageObservable() = mapBinding { it.average() }
