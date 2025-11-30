package de.westermann.kobserve

import de.westermann.kobserve.list.observableListOf
import de.westermann.kobserve.property.property
import kotlin.test.Test
import kotlin.test.assertEquals

class ExtensionsTest {

    @Test
    fun booleanTest() {
        val boolA = property(false)
        val boolB = property(false)

        val and = boolA and boolB
        val or = boolA or boolB
        val xor = boolA xor boolB
        val implies = boolA implies boolB
        val not = !boolA

        assertEquals(false, and.value)
        assertEquals(false, or.value)
        assertEquals(false, xor.value)
        assertEquals(true, implies.value)
        assertEquals(true, not.value)

        boolB.value = true

        assertEquals(false, and.value)
        assertEquals(true, or.value)
        assertEquals(true, xor.value)
        assertEquals(true, implies.value)

        boolA.value = true

        assertEquals(true, and.value)
        assertEquals(true, or.value)
        assertEquals(false, xor.value)
        assertEquals(false, not.value)
        assertEquals(true, implies.value)

        boolB.value = false

        assertEquals(false, and.value)
        assertEquals(true, or.value)
        assertEquals(true, xor.value)
        assertEquals(false, implies.value)
    }

    @Test
    fun testCalc() {
        val number1 = property(2)
        val number2 = property(10)
        val number3 = property(5.0)
        val number4 = property(7)

        val calc = ((1 - number1) * number2 / 5) % number4 * number3 + 1337
        assertEquals(calc, calc)
    }

    /* The following part is auto generated. Do NOT edit it manually! */
    
    // Unary minus
    
    @Test
    fun propertyIntUnaryMinusTest() {
        val p1 = property(5)
        val p = -p1
        assertEquals(-p1.value, p.value)
    }
    
    @Test
    fun propertyLongUnaryMinusTest() {
        val p1 = property(4L)
        val p = -p1
        assertEquals(-p1.value, p.value)
    }
    
    @Test
    fun propertyFloatUnaryMinusTest() {
        val p1 = property(3.0f)
        val p = -p1
        assertEquals(-p1.value, p.value)
    }
    
    @Test
    fun propertyDoubleUnaryMinusTest() {
        val p1 = property(2.0)
        val p = -p1
        assertEquals(-p1.value, p.value)
    }
    
    @Test
    fun propertyShortUnaryMinusTest() {
        val p1 = property(6.toShort())
        val p = -p1
        assertEquals(-p1.value, p.value)
    }
    
    @Test
    fun propertyByteUnaryMinusTest() {
        val p1 = property(1.toByte())
        val p = -p1
        assertEquals(-p1.value, p.value)
    }
    
    // List sum
    
    @Test
    fun observableListIntSumTest() {
        val p1 = observableListOf(5, 5, 5)
        val p = p1.sumObservable()
        assertEquals(p1.value.sum(), p.value)
    }
    
    @Test
    fun observableListLongSumTest() {
        val p1 = observableListOf(4L, 4L, 4L)
        val p = p1.sumObservable()
        assertEquals(p1.value.sum(), p.value)
    }
    
    @Test
    fun observableListFloatSumTest() {
        val p1 = observableListOf(3.0f, 3.0f, 3.0f)
        val p = p1.sumObservable()
        assertEquals(p1.value.sum(), p.value)
    }
    
    @Test
    fun observableListDoubleSumTest() {
        val p1 = observableListOf(2.0, 2.0, 2.0)
        val p = p1.sumObservable()
        assertEquals(p1.value.sum(), p.value)
    }
    
    @Test
    fun observableListShortSumTest() {
        val p1 = observableListOf(6.toShort(), 6.toShort(), 6.toShort())
        val p = p1.sumObservable()
        assertEquals(p1.value.sum(), p.value)
    }
    
    @Test
    fun observableListByteSumTest() {
        val p1 = observableListOf(1.toByte(), 1.toByte(), 1.toByte())
        val p = p1.sumObservable()
        assertEquals(p1.value.sum(), p.value)
    }
    
    // List average
    
    @Test
    fun observableListIntAverageTest() {
        val p1 = observableListOf(5, 5, 5)
        val p = p1.averageObservable()
        assertEquals(p1.value.average(), p.value)
    }
    
    @Test
    fun observableListLongAverageTest() {
        val p1 = observableListOf(4L, 4L, 4L)
        val p = p1.averageObservable()
        assertEquals(p1.value.average(), p.value)
    }
    
    @Test
    fun observableListFloatAverageTest() {
        val p1 = observableListOf(3.0f, 3.0f, 3.0f)
        val p = p1.averageObservable()
        assertEquals(p1.value.average(), p.value)
    }
    
    @Test
    fun observableListDoubleAverageTest() {
        val p1 = observableListOf(2.0, 2.0, 2.0)
        val p = p1.averageObservable()
        assertEquals(p1.value.average(), p.value)
    }
    
    @Test
    fun observableListShortAverageTest() {
        val p1 = observableListOf(6.toShort(), 6.toShort(), 6.toShort())
        val p = p1.averageObservable()
        assertEquals(p1.value.average(), p.value)
    }
    
    @Test
    fun observableListByteAverageTest() {
        val p1 = observableListOf(1.toByte(), 1.toByte(), 1.toByte())
        val p = p1.averageObservable()
        assertEquals(p1.value.average(), p.value)
    }
    
    /*
     * Property - Property
     */
    
    @Test
    fun propertyIntPlusIntTest() {
        val p1 = property(5)
        val p2 = property(5)
        val p = p1 + p2
        assertEquals(p1.value + p2.value, p.value)
    }
    
    @Test
    fun propertyIntMinusIntTest() {
        val p1 = property(5)
        val p2 = property(5)
        val p = p1 - p2
        assertEquals(p1.value - p2.value, p.value)
    }
    
    @Test
    fun propertyIntTimesIntTest() {
        val p1 = property(5)
        val p2 = property(5)
        val p = p1 * p2
        assertEquals(p1.value * p2.value, p.value)
    }
    
    @Test
    fun propertyIntDivIntTest() {
        val p1 = property(5)
        val p2 = property(5)
        val p = p1 / p2
        assertEquals(p1.value / p2.value, p.value)
    }
    
    @Test
    fun propertyIntRemIntTest() {
        val p1 = property(5)
        val p2 = property(5)
        val p = p1 % p2
        assertEquals(p1.value % p2.value, p.value)
    }
    
    @Test
    fun propertyIntPlusLongTest() {
        val p1 = property(5)
        val p2 = property(4L)
        val p = p1 + p2
        assertEquals(p1.value + p2.value, p.value)
    }
    
    @Test
    fun propertyIntMinusLongTest() {
        val p1 = property(5)
        val p2 = property(4L)
        val p = p1 - p2
        assertEquals(p1.value - p2.value, p.value)
    }
    
    @Test
    fun propertyIntTimesLongTest() {
        val p1 = property(5)
        val p2 = property(4L)
        val p = p1 * p2
        assertEquals(p1.value * p2.value, p.value)
    }
    
    @Test
    fun propertyIntDivLongTest() {
        val p1 = property(5)
        val p2 = property(4L)
        val p = p1 / p2
        assertEquals(p1.value / p2.value, p.value)
    }
    
    @Test
    fun propertyIntRemLongTest() {
        val p1 = property(5)
        val p2 = property(4L)
        val p = p1 % p2
        assertEquals(p1.value % p2.value, p.value)
    }
    
    @Test
    fun propertyIntPlusFloatTest() {
        val p1 = property(5)
        val p2 = property(3.0f)
        val p = p1 + p2
        assertEquals(p1.value + p2.value, p.value)
    }
    
    @Test
    fun propertyIntMinusFloatTest() {
        val p1 = property(5)
        val p2 = property(3.0f)
        val p = p1 - p2
        assertEquals(p1.value - p2.value, p.value)
    }
    
    @Test
    fun propertyIntTimesFloatTest() {
        val p1 = property(5)
        val p2 = property(3.0f)
        val p = p1 * p2
        assertEquals(p1.value * p2.value, p.value)
    }
    
    @Test
    fun propertyIntDivFloatTest() {
        val p1 = property(5)
        val p2 = property(3.0f)
        val p = p1 / p2
        assertEquals(p1.value / p2.value, p.value)
    }
    
    @Test
    fun propertyIntRemFloatTest() {
        val p1 = property(5)
        val p2 = property(3.0f)
        val p = p1 % p2
        assertEquals(p1.value % p2.value, p.value)
    }
    
    @Test
    fun propertyIntPlusDoubleTest() {
        val p1 = property(5)
        val p2 = property(2.0)
        val p = p1 + p2
        assertEquals(p1.value + p2.value, p.value)
    }
    
    @Test
    fun propertyIntMinusDoubleTest() {
        val p1 = property(5)
        val p2 = property(2.0)
        val p = p1 - p2
        assertEquals(p1.value - p2.value, p.value)
    }
    
    @Test
    fun propertyIntTimesDoubleTest() {
        val p1 = property(5)
        val p2 = property(2.0)
        val p = p1 * p2
        assertEquals(p1.value * p2.value, p.value)
    }
    
    @Test
    fun propertyIntDivDoubleTest() {
        val p1 = property(5)
        val p2 = property(2.0)
        val p = p1 / p2
        assertEquals(p1.value / p2.value, p.value)
    }
    
    @Test
    fun propertyIntRemDoubleTest() {
        val p1 = property(5)
        val p2 = property(2.0)
        val p = p1 % p2
        assertEquals(p1.value % p2.value, p.value)
    }
    
    @Test
    fun propertyIntPlusShortTest() {
        val p1 = property(5)
        val p2 = property(6.toShort())
        val p = p1 + p2
        assertEquals(p1.value + p2.value, p.value)
    }
    
    @Test
    fun propertyIntMinusShortTest() {
        val p1 = property(5)
        val p2 = property(6.toShort())
        val p = p1 - p2
        assertEquals(p1.value - p2.value, p.value)
    }
    
    @Test
    fun propertyIntTimesShortTest() {
        val p1 = property(5)
        val p2 = property(6.toShort())
        val p = p1 * p2
        assertEquals(p1.value * p2.value, p.value)
    }
    
    @Test
    fun propertyIntDivShortTest() {
        val p1 = property(5)
        val p2 = property(6.toShort())
        val p = p1 / p2
        assertEquals(p1.value / p2.value, p.value)
    }
    
    @Test
    fun propertyIntRemShortTest() {
        val p1 = property(5)
        val p2 = property(6.toShort())
        val p = p1 % p2
        assertEquals(p1.value % p2.value, p.value)
    }
    
    @Test
    fun propertyIntPlusByteTest() {
        val p1 = property(5)
        val p2 = property(1.toByte())
        val p = p1 + p2
        assertEquals(p1.value + p2.value, p.value)
    }
    
    @Test
    fun propertyIntMinusByteTest() {
        val p1 = property(5)
        val p2 = property(1.toByte())
        val p = p1 - p2
        assertEquals(p1.value - p2.value, p.value)
    }
    
    @Test
    fun propertyIntTimesByteTest() {
        val p1 = property(5)
        val p2 = property(1.toByte())
        val p = p1 * p2
        assertEquals(p1.value * p2.value, p.value)
    }
    
    @Test
    fun propertyIntDivByteTest() {
        val p1 = property(5)
        val p2 = property(1.toByte())
        val p = p1 / p2
        assertEquals(p1.value / p2.value, p.value)
    }
    
    @Test
    fun propertyIntRemByteTest() {
        val p1 = property(5)
        val p2 = property(1.toByte())
        val p = p1 % p2
        assertEquals(p1.value % p2.value, p.value)
    }
    
    @Test
    fun propertyLongPlusIntTest() {
        val p1 = property(4L)
        val p2 = property(5)
        val p = p1 + p2
        assertEquals(p1.value + p2.value, p.value)
    }
    
    @Test
    fun propertyLongMinusIntTest() {
        val p1 = property(4L)
        val p2 = property(5)
        val p = p1 - p2
        assertEquals(p1.value - p2.value, p.value)
    }
    
    @Test
    fun propertyLongTimesIntTest() {
        val p1 = property(4L)
        val p2 = property(5)
        val p = p1 * p2
        assertEquals(p1.value * p2.value, p.value)
    }
    
    @Test
    fun propertyLongDivIntTest() {
        val p1 = property(4L)
        val p2 = property(5)
        val p = p1 / p2
        assertEquals(p1.value / p2.value, p.value)
    }
    
    @Test
    fun propertyLongRemIntTest() {
        val p1 = property(4L)
        val p2 = property(5)
        val p = p1 % p2
        assertEquals(p1.value % p2.value, p.value)
    }
    
    @Test
    fun propertyLongPlusLongTest() {
        val p1 = property(4L)
        val p2 = property(4L)
        val p = p1 + p2
        assertEquals(p1.value + p2.value, p.value)
    }
    
    @Test
    fun propertyLongMinusLongTest() {
        val p1 = property(4L)
        val p2 = property(4L)
        val p = p1 - p2
        assertEquals(p1.value - p2.value, p.value)
    }
    
    @Test
    fun propertyLongTimesLongTest() {
        val p1 = property(4L)
        val p2 = property(4L)
        val p = p1 * p2
        assertEquals(p1.value * p2.value, p.value)
    }
    
    @Test
    fun propertyLongDivLongTest() {
        val p1 = property(4L)
        val p2 = property(4L)
        val p = p1 / p2
        assertEquals(p1.value / p2.value, p.value)
    }
    
    @Test
    fun propertyLongRemLongTest() {
        val p1 = property(4L)
        val p2 = property(4L)
        val p = p1 % p2
        assertEquals(p1.value % p2.value, p.value)
    }
    
    @Test
    fun propertyLongPlusFloatTest() {
        val p1 = property(4L)
        val p2 = property(3.0f)
        val p = p1 + p2
        assertEquals(p1.value + p2.value, p.value)
    }
    
    @Test
    fun propertyLongMinusFloatTest() {
        val p1 = property(4L)
        val p2 = property(3.0f)
        val p = p1 - p2
        assertEquals(p1.value - p2.value, p.value)
    }
    
    @Test
    fun propertyLongTimesFloatTest() {
        val p1 = property(4L)
        val p2 = property(3.0f)
        val p = p1 * p2
        assertEquals(p1.value * p2.value, p.value)
    }
    
    @Test
    fun propertyLongDivFloatTest() {
        val p1 = property(4L)
        val p2 = property(3.0f)
        val p = p1 / p2
        assertEquals(p1.value / p2.value, p.value)
    }
    
    @Test
    fun propertyLongRemFloatTest() {
        val p1 = property(4L)
        val p2 = property(3.0f)
        val p = p1 % p2
        assertEquals(p1.value % p2.value, p.value)
    }
    
    @Test
    fun propertyLongPlusDoubleTest() {
        val p1 = property(4L)
        val p2 = property(2.0)
        val p = p1 + p2
        assertEquals(p1.value + p2.value, p.value)
    }
    
    @Test
    fun propertyLongMinusDoubleTest() {
        val p1 = property(4L)
        val p2 = property(2.0)
        val p = p1 - p2
        assertEquals(p1.value - p2.value, p.value)
    }
    
    @Test
    fun propertyLongTimesDoubleTest() {
        val p1 = property(4L)
        val p2 = property(2.0)
        val p = p1 * p2
        assertEquals(p1.value * p2.value, p.value)
    }
    
    @Test
    fun propertyLongDivDoubleTest() {
        val p1 = property(4L)
        val p2 = property(2.0)
        val p = p1 / p2
        assertEquals(p1.value / p2.value, p.value)
    }
    
    @Test
    fun propertyLongRemDoubleTest() {
        val p1 = property(4L)
        val p2 = property(2.0)
        val p = p1 % p2
        assertEquals(p1.value % p2.value, p.value)
    }
    
    @Test
    fun propertyLongPlusShortTest() {
        val p1 = property(4L)
        val p2 = property(6.toShort())
        val p = p1 + p2
        assertEquals(p1.value + p2.value, p.value)
    }
    
    @Test
    fun propertyLongMinusShortTest() {
        val p1 = property(4L)
        val p2 = property(6.toShort())
        val p = p1 - p2
        assertEquals(p1.value - p2.value, p.value)
    }
    
    @Test
    fun propertyLongTimesShortTest() {
        val p1 = property(4L)
        val p2 = property(6.toShort())
        val p = p1 * p2
        assertEquals(p1.value * p2.value, p.value)
    }
    
    @Test
    fun propertyLongDivShortTest() {
        val p1 = property(4L)
        val p2 = property(6.toShort())
        val p = p1 / p2
        assertEquals(p1.value / p2.value, p.value)
    }
    
    @Test
    fun propertyLongRemShortTest() {
        val p1 = property(4L)
        val p2 = property(6.toShort())
        val p = p1 % p2
        assertEquals(p1.value % p2.value, p.value)
    }
    
    @Test
    fun propertyLongPlusByteTest() {
        val p1 = property(4L)
        val p2 = property(1.toByte())
        val p = p1 + p2
        assertEquals(p1.value + p2.value, p.value)
    }
    
    @Test
    fun propertyLongMinusByteTest() {
        val p1 = property(4L)
        val p2 = property(1.toByte())
        val p = p1 - p2
        assertEquals(p1.value - p2.value, p.value)
    }
    
    @Test
    fun propertyLongTimesByteTest() {
        val p1 = property(4L)
        val p2 = property(1.toByte())
        val p = p1 * p2
        assertEquals(p1.value * p2.value, p.value)
    }
    
    @Test
    fun propertyLongDivByteTest() {
        val p1 = property(4L)
        val p2 = property(1.toByte())
        val p = p1 / p2
        assertEquals(p1.value / p2.value, p.value)
    }
    
    @Test
    fun propertyLongRemByteTest() {
        val p1 = property(4L)
        val p2 = property(1.toByte())
        val p = p1 % p2
        assertEquals(p1.value % p2.value, p.value)
    }
    
    @Test
    fun propertyFloatPlusIntTest() {
        val p1 = property(3.0f)
        val p2 = property(5)
        val p = p1 + p2
        assertEquals(p1.value + p2.value, p.value)
    }
    
    @Test
    fun propertyFloatMinusIntTest() {
        val p1 = property(3.0f)
        val p2 = property(5)
        val p = p1 - p2
        assertEquals(p1.value - p2.value, p.value)
    }
    
    @Test
    fun propertyFloatTimesIntTest() {
        val p1 = property(3.0f)
        val p2 = property(5)
        val p = p1 * p2
        assertEquals(p1.value * p2.value, p.value)
    }
    
    @Test
    fun propertyFloatDivIntTest() {
        val p1 = property(3.0f)
        val p2 = property(5)
        val p = p1 / p2
        assertEquals(p1.value / p2.value, p.value)
    }
    
    @Test
    fun propertyFloatRemIntTest() {
        val p1 = property(3.0f)
        val p2 = property(5)
        val p = p1 % p2
        assertEquals(p1.value % p2.value, p.value)
    }
    
    @Test
    fun propertyFloatPlusLongTest() {
        val p1 = property(3.0f)
        val p2 = property(4L)
        val p = p1 + p2
        assertEquals(p1.value + p2.value, p.value)
    }
    
    @Test
    fun propertyFloatMinusLongTest() {
        val p1 = property(3.0f)
        val p2 = property(4L)
        val p = p1 - p2
        assertEquals(p1.value - p2.value, p.value)
    }
    
    @Test
    fun propertyFloatTimesLongTest() {
        val p1 = property(3.0f)
        val p2 = property(4L)
        val p = p1 * p2
        assertEquals(p1.value * p2.value, p.value)
    }
    
    @Test
    fun propertyFloatDivLongTest() {
        val p1 = property(3.0f)
        val p2 = property(4L)
        val p = p1 / p2
        assertEquals(p1.value / p2.value, p.value)
    }
    
    @Test
    fun propertyFloatRemLongTest() {
        val p1 = property(3.0f)
        val p2 = property(4L)
        val p = p1 % p2
        assertEquals(p1.value % p2.value, p.value)
    }
    
    @Test
    fun propertyFloatPlusFloatTest() {
        val p1 = property(3.0f)
        val p2 = property(3.0f)
        val p = p1 + p2
        assertEquals(p1.value + p2.value, p.value)
    }
    
    @Test
    fun propertyFloatMinusFloatTest() {
        val p1 = property(3.0f)
        val p2 = property(3.0f)
        val p = p1 - p2
        assertEquals(p1.value - p2.value, p.value)
    }
    
    @Test
    fun propertyFloatTimesFloatTest() {
        val p1 = property(3.0f)
        val p2 = property(3.0f)
        val p = p1 * p2
        assertEquals(p1.value * p2.value, p.value)
    }
    
    @Test
    fun propertyFloatDivFloatTest() {
        val p1 = property(3.0f)
        val p2 = property(3.0f)
        val p = p1 / p2
        assertEquals(p1.value / p2.value, p.value)
    }
    
    @Test
    fun propertyFloatRemFloatTest() {
        val p1 = property(3.0f)
        val p2 = property(3.0f)
        val p = p1 % p2
        assertEquals(p1.value % p2.value, p.value)
    }
    
    @Test
    fun propertyFloatPlusDoubleTest() {
        val p1 = property(3.0f)
        val p2 = property(2.0)
        val p = p1 + p2
        assertEquals(p1.value + p2.value, p.value)
    }
    
    @Test
    fun propertyFloatMinusDoubleTest() {
        val p1 = property(3.0f)
        val p2 = property(2.0)
        val p = p1 - p2
        assertEquals(p1.value - p2.value, p.value)
    }
    
    @Test
    fun propertyFloatTimesDoubleTest() {
        val p1 = property(3.0f)
        val p2 = property(2.0)
        val p = p1 * p2
        assertEquals(p1.value * p2.value, p.value)
    }
    
    @Test
    fun propertyFloatDivDoubleTest() {
        val p1 = property(3.0f)
        val p2 = property(2.0)
        val p = p1 / p2
        assertEquals(p1.value / p2.value, p.value)
    }
    
    @Test
    fun propertyFloatRemDoubleTest() {
        val p1 = property(3.0f)
        val p2 = property(2.0)
        val p = p1 % p2
        assertEquals(p1.value % p2.value, p.value)
    }
    
    @Test
    fun propertyFloatPlusShortTest() {
        val p1 = property(3.0f)
        val p2 = property(6.toShort())
        val p = p1 + p2
        assertEquals(p1.value + p2.value, p.value)
    }
    
    @Test
    fun propertyFloatMinusShortTest() {
        val p1 = property(3.0f)
        val p2 = property(6.toShort())
        val p = p1 - p2
        assertEquals(p1.value - p2.value, p.value)
    }
    
    @Test
    fun propertyFloatTimesShortTest() {
        val p1 = property(3.0f)
        val p2 = property(6.toShort())
        val p = p1 * p2
        assertEquals(p1.value * p2.value, p.value)
    }
    
    @Test
    fun propertyFloatDivShortTest() {
        val p1 = property(3.0f)
        val p2 = property(6.toShort())
        val p = p1 / p2
        assertEquals(p1.value / p2.value, p.value)
    }
    
    @Test
    fun propertyFloatRemShortTest() {
        val p1 = property(3.0f)
        val p2 = property(6.toShort())
        val p = p1 % p2
        assertEquals(p1.value % p2.value, p.value)
    }
    
    @Test
    fun propertyFloatPlusByteTest() {
        val p1 = property(3.0f)
        val p2 = property(1.toByte())
        val p = p1 + p2
        assertEquals(p1.value + p2.value, p.value)
    }
    
    @Test
    fun propertyFloatMinusByteTest() {
        val p1 = property(3.0f)
        val p2 = property(1.toByte())
        val p = p1 - p2
        assertEquals(p1.value - p2.value, p.value)
    }
    
    @Test
    fun propertyFloatTimesByteTest() {
        val p1 = property(3.0f)
        val p2 = property(1.toByte())
        val p = p1 * p2
        assertEquals(p1.value * p2.value, p.value)
    }
    
    @Test
    fun propertyFloatDivByteTest() {
        val p1 = property(3.0f)
        val p2 = property(1.toByte())
        val p = p1 / p2
        assertEquals(p1.value / p2.value, p.value)
    }
    
    @Test
    fun propertyFloatRemByteTest() {
        val p1 = property(3.0f)
        val p2 = property(1.toByte())
        val p = p1 % p2
        assertEquals(p1.value % p2.value, p.value)
    }
    
    @Test
    fun propertyDoublePlusIntTest() {
        val p1 = property(2.0)
        val p2 = property(5)
        val p = p1 + p2
        assertEquals(p1.value + p2.value, p.value)
    }
    
    @Test
    fun propertyDoubleMinusIntTest() {
        val p1 = property(2.0)
        val p2 = property(5)
        val p = p1 - p2
        assertEquals(p1.value - p2.value, p.value)
    }
    
    @Test
    fun propertyDoubleTimesIntTest() {
        val p1 = property(2.0)
        val p2 = property(5)
        val p = p1 * p2
        assertEquals(p1.value * p2.value, p.value)
    }
    
    @Test
    fun propertyDoubleDivIntTest() {
        val p1 = property(2.0)
        val p2 = property(5)
        val p = p1 / p2
        assertEquals(p1.value / p2.value, p.value)
    }
    
    @Test
    fun propertyDoubleRemIntTest() {
        val p1 = property(2.0)
        val p2 = property(5)
        val p = p1 % p2
        assertEquals(p1.value % p2.value, p.value)
    }
    
    @Test
    fun propertyDoublePlusLongTest() {
        val p1 = property(2.0)
        val p2 = property(4L)
        val p = p1 + p2
        assertEquals(p1.value + p2.value, p.value)
    }
    
    @Test
    fun propertyDoubleMinusLongTest() {
        val p1 = property(2.0)
        val p2 = property(4L)
        val p = p1 - p2
        assertEquals(p1.value - p2.value, p.value)
    }
    
    @Test
    fun propertyDoubleTimesLongTest() {
        val p1 = property(2.0)
        val p2 = property(4L)
        val p = p1 * p2
        assertEquals(p1.value * p2.value, p.value)
    }
    
    @Test
    fun propertyDoubleDivLongTest() {
        val p1 = property(2.0)
        val p2 = property(4L)
        val p = p1 / p2
        assertEquals(p1.value / p2.value, p.value)
    }
    
    @Test
    fun propertyDoubleRemLongTest() {
        val p1 = property(2.0)
        val p2 = property(4L)
        val p = p1 % p2
        assertEquals(p1.value % p2.value, p.value)
    }
    
    @Test
    fun propertyDoublePlusFloatTest() {
        val p1 = property(2.0)
        val p2 = property(3.0f)
        val p = p1 + p2
        assertEquals(p1.value + p2.value, p.value)
    }
    
    @Test
    fun propertyDoubleMinusFloatTest() {
        val p1 = property(2.0)
        val p2 = property(3.0f)
        val p = p1 - p2
        assertEquals(p1.value - p2.value, p.value)
    }
    
    @Test
    fun propertyDoubleTimesFloatTest() {
        val p1 = property(2.0)
        val p2 = property(3.0f)
        val p = p1 * p2
        assertEquals(p1.value * p2.value, p.value)
    }
    
    @Test
    fun propertyDoubleDivFloatTest() {
        val p1 = property(2.0)
        val p2 = property(3.0f)
        val p = p1 / p2
        assertEquals(p1.value / p2.value, p.value)
    }
    
    @Test
    fun propertyDoubleRemFloatTest() {
        val p1 = property(2.0)
        val p2 = property(3.0f)
        val p = p1 % p2
        assertEquals(p1.value % p2.value, p.value)
    }
    
    @Test
    fun propertyDoublePlusDoubleTest() {
        val p1 = property(2.0)
        val p2 = property(2.0)
        val p = p1 + p2
        assertEquals(p1.value + p2.value, p.value)
    }
    
    @Test
    fun propertyDoubleMinusDoubleTest() {
        val p1 = property(2.0)
        val p2 = property(2.0)
        val p = p1 - p2
        assertEquals(p1.value - p2.value, p.value)
    }
    
    @Test
    fun propertyDoubleTimesDoubleTest() {
        val p1 = property(2.0)
        val p2 = property(2.0)
        val p = p1 * p2
        assertEquals(p1.value * p2.value, p.value)
    }
    
    @Test
    fun propertyDoubleDivDoubleTest() {
        val p1 = property(2.0)
        val p2 = property(2.0)
        val p = p1 / p2
        assertEquals(p1.value / p2.value, p.value)
    }
    
    @Test
    fun propertyDoubleRemDoubleTest() {
        val p1 = property(2.0)
        val p2 = property(2.0)
        val p = p1 % p2
        assertEquals(p1.value % p2.value, p.value)
    }
    
    @Test
    fun propertyDoublePlusShortTest() {
        val p1 = property(2.0)
        val p2 = property(6.toShort())
        val p = p1 + p2
        assertEquals(p1.value + p2.value, p.value)
    }
    
    @Test
    fun propertyDoubleMinusShortTest() {
        val p1 = property(2.0)
        val p2 = property(6.toShort())
        val p = p1 - p2
        assertEquals(p1.value - p2.value, p.value)
    }
    
    @Test
    fun propertyDoubleTimesShortTest() {
        val p1 = property(2.0)
        val p2 = property(6.toShort())
        val p = p1 * p2
        assertEquals(p1.value * p2.value, p.value)
    }
    
    @Test
    fun propertyDoubleDivShortTest() {
        val p1 = property(2.0)
        val p2 = property(6.toShort())
        val p = p1 / p2
        assertEquals(p1.value / p2.value, p.value)
    }
    
    @Test
    fun propertyDoubleRemShortTest() {
        val p1 = property(2.0)
        val p2 = property(6.toShort())
        val p = p1 % p2
        assertEquals(p1.value % p2.value, p.value)
    }
    
    @Test
    fun propertyDoublePlusByteTest() {
        val p1 = property(2.0)
        val p2 = property(1.toByte())
        val p = p1 + p2
        assertEquals(p1.value + p2.value, p.value)
    }
    
    @Test
    fun propertyDoubleMinusByteTest() {
        val p1 = property(2.0)
        val p2 = property(1.toByte())
        val p = p1 - p2
        assertEquals(p1.value - p2.value, p.value)
    }
    
    @Test
    fun propertyDoubleTimesByteTest() {
        val p1 = property(2.0)
        val p2 = property(1.toByte())
        val p = p1 * p2
        assertEquals(p1.value * p2.value, p.value)
    }
    
    @Test
    fun propertyDoubleDivByteTest() {
        val p1 = property(2.0)
        val p2 = property(1.toByte())
        val p = p1 / p2
        assertEquals(p1.value / p2.value, p.value)
    }
    
    @Test
    fun propertyDoubleRemByteTest() {
        val p1 = property(2.0)
        val p2 = property(1.toByte())
        val p = p1 % p2
        assertEquals(p1.value % p2.value, p.value)
    }
    
    @Test
    fun propertyShortPlusIntTest() {
        val p1 = property(6.toShort())
        val p2 = property(5)
        val p = p1 + p2
        assertEquals(p1.value + p2.value, p.value)
    }
    
    @Test
    fun propertyShortMinusIntTest() {
        val p1 = property(6.toShort())
        val p2 = property(5)
        val p = p1 - p2
        assertEquals(p1.value - p2.value, p.value)
    }
    
    @Test
    fun propertyShortTimesIntTest() {
        val p1 = property(6.toShort())
        val p2 = property(5)
        val p = p1 * p2
        assertEquals(p1.value * p2.value, p.value)
    }
    
    @Test
    fun propertyShortDivIntTest() {
        val p1 = property(6.toShort())
        val p2 = property(5)
        val p = p1 / p2
        assertEquals(p1.value / p2.value, p.value)
    }
    
    @Test
    fun propertyShortRemIntTest() {
        val p1 = property(6.toShort())
        val p2 = property(5)
        val p = p1 % p2
        assertEquals(p1.value % p2.value, p.value)
    }
    
    @Test
    fun propertyShortPlusLongTest() {
        val p1 = property(6.toShort())
        val p2 = property(4L)
        val p = p1 + p2
        assertEquals(p1.value + p2.value, p.value)
    }
    
    @Test
    fun propertyShortMinusLongTest() {
        val p1 = property(6.toShort())
        val p2 = property(4L)
        val p = p1 - p2
        assertEquals(p1.value - p2.value, p.value)
    }
    
    @Test
    fun propertyShortTimesLongTest() {
        val p1 = property(6.toShort())
        val p2 = property(4L)
        val p = p1 * p2
        assertEquals(p1.value * p2.value, p.value)
    }
    
    @Test
    fun propertyShortDivLongTest() {
        val p1 = property(6.toShort())
        val p2 = property(4L)
        val p = p1 / p2
        assertEquals(p1.value / p2.value, p.value)
    }
    
    @Test
    fun propertyShortRemLongTest() {
        val p1 = property(6.toShort())
        val p2 = property(4L)
        val p = p1 % p2
        assertEquals(p1.value % p2.value, p.value)
    }
    
    @Test
    fun propertyShortPlusFloatTest() {
        val p1 = property(6.toShort())
        val p2 = property(3.0f)
        val p = p1 + p2
        assertEquals(p1.value + p2.value, p.value)
    }
    
    @Test
    fun propertyShortMinusFloatTest() {
        val p1 = property(6.toShort())
        val p2 = property(3.0f)
        val p = p1 - p2
        assertEquals(p1.value - p2.value, p.value)
    }
    
    @Test
    fun propertyShortTimesFloatTest() {
        val p1 = property(6.toShort())
        val p2 = property(3.0f)
        val p = p1 * p2
        assertEquals(p1.value * p2.value, p.value)
    }
    
    @Test
    fun propertyShortDivFloatTest() {
        val p1 = property(6.toShort())
        val p2 = property(3.0f)
        val p = p1 / p2
        assertEquals(p1.value / p2.value, p.value)
    }
    
    @Test
    fun propertyShortRemFloatTest() {
        val p1 = property(6.toShort())
        val p2 = property(3.0f)
        val p = p1 % p2
        assertEquals(p1.value % p2.value, p.value)
    }
    
    @Test
    fun propertyShortPlusDoubleTest() {
        val p1 = property(6.toShort())
        val p2 = property(2.0)
        val p = p1 + p2
        assertEquals(p1.value + p2.value, p.value)
    }
    
    @Test
    fun propertyShortMinusDoubleTest() {
        val p1 = property(6.toShort())
        val p2 = property(2.0)
        val p = p1 - p2
        assertEquals(p1.value - p2.value, p.value)
    }
    
    @Test
    fun propertyShortTimesDoubleTest() {
        val p1 = property(6.toShort())
        val p2 = property(2.0)
        val p = p1 * p2
        assertEquals(p1.value * p2.value, p.value)
    }
    
    @Test
    fun propertyShortDivDoubleTest() {
        val p1 = property(6.toShort())
        val p2 = property(2.0)
        val p = p1 / p2
        assertEquals(p1.value / p2.value, p.value)
    }
    
    @Test
    fun propertyShortRemDoubleTest() {
        val p1 = property(6.toShort())
        val p2 = property(2.0)
        val p = p1 % p2
        assertEquals(p1.value % p2.value, p.value)
    }
    
    @Test
    fun propertyShortPlusShortTest() {
        val p1 = property(6.toShort())
        val p2 = property(6.toShort())
        val p = p1 + p2
        assertEquals(p1.value + p2.value, p.value)
    }
    
    @Test
    fun propertyShortMinusShortTest() {
        val p1 = property(6.toShort())
        val p2 = property(6.toShort())
        val p = p1 - p2
        assertEquals(p1.value - p2.value, p.value)
    }
    
    @Test
    fun propertyShortTimesShortTest() {
        val p1 = property(6.toShort())
        val p2 = property(6.toShort())
        val p = p1 * p2
        assertEquals(p1.value * p2.value, p.value)
    }
    
    @Test
    fun propertyShortDivShortTest() {
        val p1 = property(6.toShort())
        val p2 = property(6.toShort())
        val p = p1 / p2
        assertEquals(p1.value / p2.value, p.value)
    }
    
    @Test
    fun propertyShortRemShortTest() {
        val p1 = property(6.toShort())
        val p2 = property(6.toShort())
        val p = p1 % p2
        assertEquals(p1.value % p2.value, p.value)
    }
    
    @Test
    fun propertyShortPlusByteTest() {
        val p1 = property(6.toShort())
        val p2 = property(1.toByte())
        val p = p1 + p2
        assertEquals(p1.value + p2.value, p.value)
    }
    
    @Test
    fun propertyShortMinusByteTest() {
        val p1 = property(6.toShort())
        val p2 = property(1.toByte())
        val p = p1 - p2
        assertEquals(p1.value - p2.value, p.value)
    }
    
    @Test
    fun propertyShortTimesByteTest() {
        val p1 = property(6.toShort())
        val p2 = property(1.toByte())
        val p = p1 * p2
        assertEquals(p1.value * p2.value, p.value)
    }
    
    @Test
    fun propertyShortDivByteTest() {
        val p1 = property(6.toShort())
        val p2 = property(1.toByte())
        val p = p1 / p2
        assertEquals(p1.value / p2.value, p.value)
    }
    
    @Test
    fun propertyShortRemByteTest() {
        val p1 = property(6.toShort())
        val p2 = property(1.toByte())
        val p = p1 % p2
        assertEquals(p1.value % p2.value, p.value)
    }
    
    @Test
    fun propertyBytePlusIntTest() {
        val p1 = property(1.toByte())
        val p2 = property(5)
        val p = p1 + p2
        assertEquals(p1.value + p2.value, p.value)
    }
    
    @Test
    fun propertyByteMinusIntTest() {
        val p1 = property(1.toByte())
        val p2 = property(5)
        val p = p1 - p2
        assertEquals(p1.value - p2.value, p.value)
    }
    
    @Test
    fun propertyByteTimesIntTest() {
        val p1 = property(1.toByte())
        val p2 = property(5)
        val p = p1 * p2
        assertEquals(p1.value * p2.value, p.value)
    }
    
    @Test
    fun propertyByteDivIntTest() {
        val p1 = property(1.toByte())
        val p2 = property(5)
        val p = p1 / p2
        assertEquals(p1.value / p2.value, p.value)
    }
    
    @Test
    fun propertyByteRemIntTest() {
        val p1 = property(1.toByte())
        val p2 = property(5)
        val p = p1 % p2
        assertEquals(p1.value % p2.value, p.value)
    }
    
    @Test
    fun propertyBytePlusLongTest() {
        val p1 = property(1.toByte())
        val p2 = property(4L)
        val p = p1 + p2
        assertEquals(p1.value + p2.value, p.value)
    }
    
    @Test
    fun propertyByteMinusLongTest() {
        val p1 = property(1.toByte())
        val p2 = property(4L)
        val p = p1 - p2
        assertEquals(p1.value - p2.value, p.value)
    }
    
    @Test
    fun propertyByteTimesLongTest() {
        val p1 = property(1.toByte())
        val p2 = property(4L)
        val p = p1 * p2
        assertEquals(p1.value * p2.value, p.value)
    }
    
    @Test
    fun propertyByteDivLongTest() {
        val p1 = property(1.toByte())
        val p2 = property(4L)
        val p = p1 / p2
        assertEquals(p1.value / p2.value, p.value)
    }
    
    @Test
    fun propertyByteRemLongTest() {
        val p1 = property(1.toByte())
        val p2 = property(4L)
        val p = p1 % p2
        assertEquals(p1.value % p2.value, p.value)
    }
    
    @Test
    fun propertyBytePlusFloatTest() {
        val p1 = property(1.toByte())
        val p2 = property(3.0f)
        val p = p1 + p2
        assertEquals(p1.value + p2.value, p.value)
    }
    
    @Test
    fun propertyByteMinusFloatTest() {
        val p1 = property(1.toByte())
        val p2 = property(3.0f)
        val p = p1 - p2
        assertEquals(p1.value - p2.value, p.value)
    }
    
    @Test
    fun propertyByteTimesFloatTest() {
        val p1 = property(1.toByte())
        val p2 = property(3.0f)
        val p = p1 * p2
        assertEquals(p1.value * p2.value, p.value)
    }
    
    @Test
    fun propertyByteDivFloatTest() {
        val p1 = property(1.toByte())
        val p2 = property(3.0f)
        val p = p1 / p2
        assertEquals(p1.value / p2.value, p.value)
    }
    
    @Test
    fun propertyByteRemFloatTest() {
        val p1 = property(1.toByte())
        val p2 = property(3.0f)
        val p = p1 % p2
        assertEquals(p1.value % p2.value, p.value)
    }
    
    @Test
    fun propertyBytePlusDoubleTest() {
        val p1 = property(1.toByte())
        val p2 = property(2.0)
        val p = p1 + p2
        assertEquals(p1.value + p2.value, p.value)
    }
    
    @Test
    fun propertyByteMinusDoubleTest() {
        val p1 = property(1.toByte())
        val p2 = property(2.0)
        val p = p1 - p2
        assertEquals(p1.value - p2.value, p.value)
    }
    
    @Test
    fun propertyByteTimesDoubleTest() {
        val p1 = property(1.toByte())
        val p2 = property(2.0)
        val p = p1 * p2
        assertEquals(p1.value * p2.value, p.value)
    }
    
    @Test
    fun propertyByteDivDoubleTest() {
        val p1 = property(1.toByte())
        val p2 = property(2.0)
        val p = p1 / p2
        assertEquals(p1.value / p2.value, p.value)
    }
    
    @Test
    fun propertyByteRemDoubleTest() {
        val p1 = property(1.toByte())
        val p2 = property(2.0)
        val p = p1 % p2
        assertEquals(p1.value % p2.value, p.value)
    }
    
    @Test
    fun propertyBytePlusShortTest() {
        val p1 = property(1.toByte())
        val p2 = property(6.toShort())
        val p = p1 + p2
        assertEquals(p1.value + p2.value, p.value)
    }
    
    @Test
    fun propertyByteMinusShortTest() {
        val p1 = property(1.toByte())
        val p2 = property(6.toShort())
        val p = p1 - p2
        assertEquals(p1.value - p2.value, p.value)
    }
    
    @Test
    fun propertyByteTimesShortTest() {
        val p1 = property(1.toByte())
        val p2 = property(6.toShort())
        val p = p1 * p2
        assertEquals(p1.value * p2.value, p.value)
    }
    
    @Test
    fun propertyByteDivShortTest() {
        val p1 = property(1.toByte())
        val p2 = property(6.toShort())
        val p = p1 / p2
        assertEquals(p1.value / p2.value, p.value)
    }
    
    @Test
    fun propertyByteRemShortTest() {
        val p1 = property(1.toByte())
        val p2 = property(6.toShort())
        val p = p1 % p2
        assertEquals(p1.value % p2.value, p.value)
    }
    
    @Test
    fun propertyBytePlusByteTest() {
        val p1 = property(1.toByte())
        val p2 = property(1.toByte())
        val p = p1 + p2
        assertEquals(p1.value + p2.value, p.value)
    }
    
    @Test
    fun propertyByteMinusByteTest() {
        val p1 = property(1.toByte())
        val p2 = property(1.toByte())
        val p = p1 - p2
        assertEquals(p1.value - p2.value, p.value)
    }
    
    @Test
    fun propertyByteTimesByteTest() {
        val p1 = property(1.toByte())
        val p2 = property(1.toByte())
        val p = p1 * p2
        assertEquals(p1.value * p2.value, p.value)
    }
    
    @Test
    fun propertyByteDivByteTest() {
        val p1 = property(1.toByte())
        val p2 = property(1.toByte())
        val p = p1 / p2
        assertEquals(p1.value / p2.value, p.value)
    }
    
    @Test
    fun propertyByteRemByteTest() {
        val p1 = property(1.toByte())
        val p2 = property(1.toByte())
        val p = p1 % p2
        assertEquals(p1.value % p2.value, p.value)
    }
    
    /*
     * Property - primitive
     */
    
    @Test
    fun propertyIntPlusIntPrimitiveTest() {
        val p1 = property(5)
        val p2 = 5
        val p = p1 + p2
        assertEquals(p1.value + p2, p.value)
    }
    
    @Test
    fun propertyIntMinusIntPrimitiveTest() {
        val p1 = property(5)
        val p2 = 5
        val p = p1 - p2
        assertEquals(p1.value - p2, p.value)
    }
    
    @Test
    fun propertyIntTimesIntPrimitiveTest() {
        val p1 = property(5)
        val p2 = 5
        val p = p1 * p2
        assertEquals(p1.value * p2, p.value)
    }
    
    @Test
    fun propertyIntDivIntPrimitiveTest() {
        val p1 = property(5)
        val p2 = 5
        val p = p1 / p2
        assertEquals(p1.value / p2, p.value)
    }
    
    @Test
    fun propertyIntRemIntPrimitiveTest() {
        val p1 = property(5)
        val p2 = 5
        val p = p1 % p2
        assertEquals(p1.value % p2, p.value)
    }
    
    @Test
    fun propertyIntPlusLongPrimitiveTest() {
        val p1 = property(5)
        val p2 = 4L
        val p = p1 + p2
        assertEquals(p1.value + p2, p.value)
    }
    
    @Test
    fun propertyIntMinusLongPrimitiveTest() {
        val p1 = property(5)
        val p2 = 4L
        val p = p1 - p2
        assertEquals(p1.value - p2, p.value)
    }
    
    @Test
    fun propertyIntTimesLongPrimitiveTest() {
        val p1 = property(5)
        val p2 = 4L
        val p = p1 * p2
        assertEquals(p1.value * p2, p.value)
    }
    
    @Test
    fun propertyIntDivLongPrimitiveTest() {
        val p1 = property(5)
        val p2 = 4L
        val p = p1 / p2
        assertEquals(p1.value / p2, p.value)
    }
    
    @Test
    fun propertyIntRemLongPrimitiveTest() {
        val p1 = property(5)
        val p2 = 4L
        val p = p1 % p2
        assertEquals(p1.value % p2, p.value)
    }
    
    @Test
    fun propertyIntPlusFloatPrimitiveTest() {
        val p1 = property(5)
        val p2 = 3.0f
        val p = p1 + p2
        assertEquals(p1.value + p2, p.value)
    }
    
    @Test
    fun propertyIntMinusFloatPrimitiveTest() {
        val p1 = property(5)
        val p2 = 3.0f
        val p = p1 - p2
        assertEquals(p1.value - p2, p.value)
    }
    
    @Test
    fun propertyIntTimesFloatPrimitiveTest() {
        val p1 = property(5)
        val p2 = 3.0f
        val p = p1 * p2
        assertEquals(p1.value * p2, p.value)
    }
    
    @Test
    fun propertyIntDivFloatPrimitiveTest() {
        val p1 = property(5)
        val p2 = 3.0f
        val p = p1 / p2
        assertEquals(p1.value / p2, p.value)
    }
    
    @Test
    fun propertyIntRemFloatPrimitiveTest() {
        val p1 = property(5)
        val p2 = 3.0f
        val p = p1 % p2
        assertEquals(p1.value % p2, p.value)
    }
    
    @Test
    fun propertyIntPlusDoublePrimitiveTest() {
        val p1 = property(5)
        val p2 = 2.0
        val p = p1 + p2
        assertEquals(p1.value + p2, p.value)
    }
    
    @Test
    fun propertyIntMinusDoublePrimitiveTest() {
        val p1 = property(5)
        val p2 = 2.0
        val p = p1 - p2
        assertEquals(p1.value - p2, p.value)
    }
    
    @Test
    fun propertyIntTimesDoublePrimitiveTest() {
        val p1 = property(5)
        val p2 = 2.0
        val p = p1 * p2
        assertEquals(p1.value * p2, p.value)
    }
    
    @Test
    fun propertyIntDivDoublePrimitiveTest() {
        val p1 = property(5)
        val p2 = 2.0
        val p = p1 / p2
        assertEquals(p1.value / p2, p.value)
    }
    
    @Test
    fun propertyIntRemDoublePrimitiveTest() {
        val p1 = property(5)
        val p2 = 2.0
        val p = p1 % p2
        assertEquals(p1.value % p2, p.value)
    }
    
    @Test
    fun propertyIntPlusShortPrimitiveTest() {
        val p1 = property(5)
        val p2 = 6.toShort()
        val p = p1 + p2
        assertEquals(p1.value + p2, p.value)
    }
    
    @Test
    fun propertyIntMinusShortPrimitiveTest() {
        val p1 = property(5)
        val p2 = 6.toShort()
        val p = p1 - p2
        assertEquals(p1.value - p2, p.value)
    }
    
    @Test
    fun propertyIntTimesShortPrimitiveTest() {
        val p1 = property(5)
        val p2 = 6.toShort()
        val p = p1 * p2
        assertEquals(p1.value * p2, p.value)
    }
    
    @Test
    fun propertyIntDivShortPrimitiveTest() {
        val p1 = property(5)
        val p2 = 6.toShort()
        val p = p1 / p2
        assertEquals(p1.value / p2, p.value)
    }
    
    @Test
    fun propertyIntRemShortPrimitiveTest() {
        val p1 = property(5)
        val p2 = 6.toShort()
        val p = p1 % p2
        assertEquals(p1.value % p2, p.value)
    }
    
    @Test
    fun propertyIntPlusBytePrimitiveTest() {
        val p1 = property(5)
        val p2 = 1.toByte()
        val p = p1 + p2
        assertEquals(p1.value + p2, p.value)
    }
    
    @Test
    fun propertyIntMinusBytePrimitiveTest() {
        val p1 = property(5)
        val p2 = 1.toByte()
        val p = p1 - p2
        assertEquals(p1.value - p2, p.value)
    }
    
    @Test
    fun propertyIntTimesBytePrimitiveTest() {
        val p1 = property(5)
        val p2 = 1.toByte()
        val p = p1 * p2
        assertEquals(p1.value * p2, p.value)
    }
    
    @Test
    fun propertyIntDivBytePrimitiveTest() {
        val p1 = property(5)
        val p2 = 1.toByte()
        val p = p1 / p2
        assertEquals(p1.value / p2, p.value)
    }
    
    @Test
    fun propertyIntRemBytePrimitiveTest() {
        val p1 = property(5)
        val p2 = 1.toByte()
        val p = p1 % p2
        assertEquals(p1.value % p2, p.value)
    }
    
    @Test
    fun propertyLongPlusIntPrimitiveTest() {
        val p1 = property(4L)
        val p2 = 5
        val p = p1 + p2
        assertEquals(p1.value + p2, p.value)
    }
    
    @Test
    fun propertyLongMinusIntPrimitiveTest() {
        val p1 = property(4L)
        val p2 = 5
        val p = p1 - p2
        assertEquals(p1.value - p2, p.value)
    }
    
    @Test
    fun propertyLongTimesIntPrimitiveTest() {
        val p1 = property(4L)
        val p2 = 5
        val p = p1 * p2
        assertEquals(p1.value * p2, p.value)
    }
    
    @Test
    fun propertyLongDivIntPrimitiveTest() {
        val p1 = property(4L)
        val p2 = 5
        val p = p1 / p2
        assertEquals(p1.value / p2, p.value)
    }
    
    @Test
    fun propertyLongRemIntPrimitiveTest() {
        val p1 = property(4L)
        val p2 = 5
        val p = p1 % p2
        assertEquals(p1.value % p2, p.value)
    }
    
    @Test
    fun propertyLongPlusLongPrimitiveTest() {
        val p1 = property(4L)
        val p2 = 4L
        val p = p1 + p2
        assertEquals(p1.value + p2, p.value)
    }
    
    @Test
    fun propertyLongMinusLongPrimitiveTest() {
        val p1 = property(4L)
        val p2 = 4L
        val p = p1 - p2
        assertEquals(p1.value - p2, p.value)
    }
    
    @Test
    fun propertyLongTimesLongPrimitiveTest() {
        val p1 = property(4L)
        val p2 = 4L
        val p = p1 * p2
        assertEquals(p1.value * p2, p.value)
    }
    
    @Test
    fun propertyLongDivLongPrimitiveTest() {
        val p1 = property(4L)
        val p2 = 4L
        val p = p1 / p2
        assertEquals(p1.value / p2, p.value)
    }
    
    @Test
    fun propertyLongRemLongPrimitiveTest() {
        val p1 = property(4L)
        val p2 = 4L
        val p = p1 % p2
        assertEquals(p1.value % p2, p.value)
    }
    
    @Test
    fun propertyLongPlusFloatPrimitiveTest() {
        val p1 = property(4L)
        val p2 = 3.0f
        val p = p1 + p2
        assertEquals(p1.value + p2, p.value)
    }
    
    @Test
    fun propertyLongMinusFloatPrimitiveTest() {
        val p1 = property(4L)
        val p2 = 3.0f
        val p = p1 - p2
        assertEquals(p1.value - p2, p.value)
    }
    
    @Test
    fun propertyLongTimesFloatPrimitiveTest() {
        val p1 = property(4L)
        val p2 = 3.0f
        val p = p1 * p2
        assertEquals(p1.value * p2, p.value)
    }
    
    @Test
    fun propertyLongDivFloatPrimitiveTest() {
        val p1 = property(4L)
        val p2 = 3.0f
        val p = p1 / p2
        assertEquals(p1.value / p2, p.value)
    }
    
    @Test
    fun propertyLongRemFloatPrimitiveTest() {
        val p1 = property(4L)
        val p2 = 3.0f
        val p = p1 % p2
        assertEquals(p1.value % p2, p.value)
    }
    
    @Test
    fun propertyLongPlusDoublePrimitiveTest() {
        val p1 = property(4L)
        val p2 = 2.0
        val p = p1 + p2
        assertEquals(p1.value + p2, p.value)
    }
    
    @Test
    fun propertyLongMinusDoublePrimitiveTest() {
        val p1 = property(4L)
        val p2 = 2.0
        val p = p1 - p2
        assertEquals(p1.value - p2, p.value)
    }
    
    @Test
    fun propertyLongTimesDoublePrimitiveTest() {
        val p1 = property(4L)
        val p2 = 2.0
        val p = p1 * p2
        assertEquals(p1.value * p2, p.value)
    }
    
    @Test
    fun propertyLongDivDoublePrimitiveTest() {
        val p1 = property(4L)
        val p2 = 2.0
        val p = p1 / p2
        assertEquals(p1.value / p2, p.value)
    }
    
    @Test
    fun propertyLongRemDoublePrimitiveTest() {
        val p1 = property(4L)
        val p2 = 2.0
        val p = p1 % p2
        assertEquals(p1.value % p2, p.value)
    }
    
    @Test
    fun propertyLongPlusShortPrimitiveTest() {
        val p1 = property(4L)
        val p2 = 6.toShort()
        val p = p1 + p2
        assertEquals(p1.value + p2, p.value)
    }
    
    @Test
    fun propertyLongMinusShortPrimitiveTest() {
        val p1 = property(4L)
        val p2 = 6.toShort()
        val p = p1 - p2
        assertEquals(p1.value - p2, p.value)
    }
    
    @Test
    fun propertyLongTimesShortPrimitiveTest() {
        val p1 = property(4L)
        val p2 = 6.toShort()
        val p = p1 * p2
        assertEquals(p1.value * p2, p.value)
    }
    
    @Test
    fun propertyLongDivShortPrimitiveTest() {
        val p1 = property(4L)
        val p2 = 6.toShort()
        val p = p1 / p2
        assertEquals(p1.value / p2, p.value)
    }
    
    @Test
    fun propertyLongRemShortPrimitiveTest() {
        val p1 = property(4L)
        val p2 = 6.toShort()
        val p = p1 % p2
        assertEquals(p1.value % p2, p.value)
    }
    
    @Test
    fun propertyLongPlusBytePrimitiveTest() {
        val p1 = property(4L)
        val p2 = 1.toByte()
        val p = p1 + p2
        assertEquals(p1.value + p2, p.value)
    }
    
    @Test
    fun propertyLongMinusBytePrimitiveTest() {
        val p1 = property(4L)
        val p2 = 1.toByte()
        val p = p1 - p2
        assertEquals(p1.value - p2, p.value)
    }
    
    @Test
    fun propertyLongTimesBytePrimitiveTest() {
        val p1 = property(4L)
        val p2 = 1.toByte()
        val p = p1 * p2
        assertEquals(p1.value * p2, p.value)
    }
    
    @Test
    fun propertyLongDivBytePrimitiveTest() {
        val p1 = property(4L)
        val p2 = 1.toByte()
        val p = p1 / p2
        assertEquals(p1.value / p2, p.value)
    }
    
    @Test
    fun propertyLongRemBytePrimitiveTest() {
        val p1 = property(4L)
        val p2 = 1.toByte()
        val p = p1 % p2
        assertEquals(p1.value % p2, p.value)
    }
    
    @Test
    fun propertyFloatPlusIntPrimitiveTest() {
        val p1 = property(3.0f)
        val p2 = 5
        val p = p1 + p2
        assertEquals(p1.value + p2, p.value)
    }
    
    @Test
    fun propertyFloatMinusIntPrimitiveTest() {
        val p1 = property(3.0f)
        val p2 = 5
        val p = p1 - p2
        assertEquals(p1.value - p2, p.value)
    }
    
    @Test
    fun propertyFloatTimesIntPrimitiveTest() {
        val p1 = property(3.0f)
        val p2 = 5
        val p = p1 * p2
        assertEquals(p1.value * p2, p.value)
    }
    
    @Test
    fun propertyFloatDivIntPrimitiveTest() {
        val p1 = property(3.0f)
        val p2 = 5
        val p = p1 / p2
        assertEquals(p1.value / p2, p.value)
    }
    
    @Test
    fun propertyFloatRemIntPrimitiveTest() {
        val p1 = property(3.0f)
        val p2 = 5
        val p = p1 % p2
        assertEquals(p1.value % p2, p.value)
    }
    
    @Test
    fun propertyFloatPlusLongPrimitiveTest() {
        val p1 = property(3.0f)
        val p2 = 4L
        val p = p1 + p2
        assertEquals(p1.value + p2, p.value)
    }
    
    @Test
    fun propertyFloatMinusLongPrimitiveTest() {
        val p1 = property(3.0f)
        val p2 = 4L
        val p = p1 - p2
        assertEquals(p1.value - p2, p.value)
    }
    
    @Test
    fun propertyFloatTimesLongPrimitiveTest() {
        val p1 = property(3.0f)
        val p2 = 4L
        val p = p1 * p2
        assertEquals(p1.value * p2, p.value)
    }
    
    @Test
    fun propertyFloatDivLongPrimitiveTest() {
        val p1 = property(3.0f)
        val p2 = 4L
        val p = p1 / p2
        assertEquals(p1.value / p2, p.value)
    }
    
    @Test
    fun propertyFloatRemLongPrimitiveTest() {
        val p1 = property(3.0f)
        val p2 = 4L
        val p = p1 % p2
        assertEquals(p1.value % p2, p.value)
    }
    
    @Test
    fun propertyFloatPlusFloatPrimitiveTest() {
        val p1 = property(3.0f)
        val p2 = 3.0f
        val p = p1 + p2
        assertEquals(p1.value + p2, p.value)
    }
    
    @Test
    fun propertyFloatMinusFloatPrimitiveTest() {
        val p1 = property(3.0f)
        val p2 = 3.0f
        val p = p1 - p2
        assertEquals(p1.value - p2, p.value)
    }
    
    @Test
    fun propertyFloatTimesFloatPrimitiveTest() {
        val p1 = property(3.0f)
        val p2 = 3.0f
        val p = p1 * p2
        assertEquals(p1.value * p2, p.value)
    }
    
    @Test
    fun propertyFloatDivFloatPrimitiveTest() {
        val p1 = property(3.0f)
        val p2 = 3.0f
        val p = p1 / p2
        assertEquals(p1.value / p2, p.value)
    }
    
    @Test
    fun propertyFloatRemFloatPrimitiveTest() {
        val p1 = property(3.0f)
        val p2 = 3.0f
        val p = p1 % p2
        assertEquals(p1.value % p2, p.value)
    }
    
    @Test
    fun propertyFloatPlusDoublePrimitiveTest() {
        val p1 = property(3.0f)
        val p2 = 2.0
        val p = p1 + p2
        assertEquals(p1.value + p2, p.value)
    }
    
    @Test
    fun propertyFloatMinusDoublePrimitiveTest() {
        val p1 = property(3.0f)
        val p2 = 2.0
        val p = p1 - p2
        assertEquals(p1.value - p2, p.value)
    }
    
    @Test
    fun propertyFloatTimesDoublePrimitiveTest() {
        val p1 = property(3.0f)
        val p2 = 2.0
        val p = p1 * p2
        assertEquals(p1.value * p2, p.value)
    }
    
    @Test
    fun propertyFloatDivDoublePrimitiveTest() {
        val p1 = property(3.0f)
        val p2 = 2.0
        val p = p1 / p2
        assertEquals(p1.value / p2, p.value)
    }
    
    @Test
    fun propertyFloatRemDoublePrimitiveTest() {
        val p1 = property(3.0f)
        val p2 = 2.0
        val p = p1 % p2
        assertEquals(p1.value % p2, p.value)
    }
    
    @Test
    fun propertyFloatPlusShortPrimitiveTest() {
        val p1 = property(3.0f)
        val p2 = 6.toShort()
        val p = p1 + p2
        assertEquals(p1.value + p2, p.value)
    }
    
    @Test
    fun propertyFloatMinusShortPrimitiveTest() {
        val p1 = property(3.0f)
        val p2 = 6.toShort()
        val p = p1 - p2
        assertEquals(p1.value - p2, p.value)
    }
    
    @Test
    fun propertyFloatTimesShortPrimitiveTest() {
        val p1 = property(3.0f)
        val p2 = 6.toShort()
        val p = p1 * p2
        assertEquals(p1.value * p2, p.value)
    }
    
    @Test
    fun propertyFloatDivShortPrimitiveTest() {
        val p1 = property(3.0f)
        val p2 = 6.toShort()
        val p = p1 / p2
        assertEquals(p1.value / p2, p.value)
    }
    
    @Test
    fun propertyFloatRemShortPrimitiveTest() {
        val p1 = property(3.0f)
        val p2 = 6.toShort()
        val p = p1 % p2
        assertEquals(p1.value % p2, p.value)
    }
    
    @Test
    fun propertyFloatPlusBytePrimitiveTest() {
        val p1 = property(3.0f)
        val p2 = 1.toByte()
        val p = p1 + p2
        assertEquals(p1.value + p2, p.value)
    }
    
    @Test
    fun propertyFloatMinusBytePrimitiveTest() {
        val p1 = property(3.0f)
        val p2 = 1.toByte()
        val p = p1 - p2
        assertEquals(p1.value - p2, p.value)
    }
    
    @Test
    fun propertyFloatTimesBytePrimitiveTest() {
        val p1 = property(3.0f)
        val p2 = 1.toByte()
        val p = p1 * p2
        assertEquals(p1.value * p2, p.value)
    }
    
    @Test
    fun propertyFloatDivBytePrimitiveTest() {
        val p1 = property(3.0f)
        val p2 = 1.toByte()
        val p = p1 / p2
        assertEquals(p1.value / p2, p.value)
    }
    
    @Test
    fun propertyFloatRemBytePrimitiveTest() {
        val p1 = property(3.0f)
        val p2 = 1.toByte()
        val p = p1 % p2
        assertEquals(p1.value % p2, p.value)
    }
    
    @Test
    fun propertyDoublePlusIntPrimitiveTest() {
        val p1 = property(2.0)
        val p2 = 5
        val p = p1 + p2
        assertEquals(p1.value + p2, p.value)
    }
    
    @Test
    fun propertyDoubleMinusIntPrimitiveTest() {
        val p1 = property(2.0)
        val p2 = 5
        val p = p1 - p2
        assertEquals(p1.value - p2, p.value)
    }
    
    @Test
    fun propertyDoubleTimesIntPrimitiveTest() {
        val p1 = property(2.0)
        val p2 = 5
        val p = p1 * p2
        assertEquals(p1.value * p2, p.value)
    }
    
    @Test
    fun propertyDoubleDivIntPrimitiveTest() {
        val p1 = property(2.0)
        val p2 = 5
        val p = p1 / p2
        assertEquals(p1.value / p2, p.value)
    }
    
    @Test
    fun propertyDoubleRemIntPrimitiveTest() {
        val p1 = property(2.0)
        val p2 = 5
        val p = p1 % p2
        assertEquals(p1.value % p2, p.value)
    }
    
    @Test
    fun propertyDoublePlusLongPrimitiveTest() {
        val p1 = property(2.0)
        val p2 = 4L
        val p = p1 + p2
        assertEquals(p1.value + p2, p.value)
    }
    
    @Test
    fun propertyDoubleMinusLongPrimitiveTest() {
        val p1 = property(2.0)
        val p2 = 4L
        val p = p1 - p2
        assertEquals(p1.value - p2, p.value)
    }
    
    @Test
    fun propertyDoubleTimesLongPrimitiveTest() {
        val p1 = property(2.0)
        val p2 = 4L
        val p = p1 * p2
        assertEquals(p1.value * p2, p.value)
    }
    
    @Test
    fun propertyDoubleDivLongPrimitiveTest() {
        val p1 = property(2.0)
        val p2 = 4L
        val p = p1 / p2
        assertEquals(p1.value / p2, p.value)
    }
    
    @Test
    fun propertyDoubleRemLongPrimitiveTest() {
        val p1 = property(2.0)
        val p2 = 4L
        val p = p1 % p2
        assertEquals(p1.value % p2, p.value)
    }
    
    @Test
    fun propertyDoublePlusFloatPrimitiveTest() {
        val p1 = property(2.0)
        val p2 = 3.0f
        val p = p1 + p2
        assertEquals(p1.value + p2, p.value)
    }
    
    @Test
    fun propertyDoubleMinusFloatPrimitiveTest() {
        val p1 = property(2.0)
        val p2 = 3.0f
        val p = p1 - p2
        assertEquals(p1.value - p2, p.value)
    }
    
    @Test
    fun propertyDoubleTimesFloatPrimitiveTest() {
        val p1 = property(2.0)
        val p2 = 3.0f
        val p = p1 * p2
        assertEquals(p1.value * p2, p.value)
    }
    
    @Test
    fun propertyDoubleDivFloatPrimitiveTest() {
        val p1 = property(2.0)
        val p2 = 3.0f
        val p = p1 / p2
        assertEquals(p1.value / p2, p.value)
    }
    
    @Test
    fun propertyDoubleRemFloatPrimitiveTest() {
        val p1 = property(2.0)
        val p2 = 3.0f
        val p = p1 % p2
        assertEquals(p1.value % p2, p.value)
    }
    
    @Test
    fun propertyDoublePlusDoublePrimitiveTest() {
        val p1 = property(2.0)
        val p2 = 2.0
        val p = p1 + p2
        assertEquals(p1.value + p2, p.value)
    }
    
    @Test
    fun propertyDoubleMinusDoublePrimitiveTest() {
        val p1 = property(2.0)
        val p2 = 2.0
        val p = p1 - p2
        assertEquals(p1.value - p2, p.value)
    }
    
    @Test
    fun propertyDoubleTimesDoublePrimitiveTest() {
        val p1 = property(2.0)
        val p2 = 2.0
        val p = p1 * p2
        assertEquals(p1.value * p2, p.value)
    }
    
    @Test
    fun propertyDoubleDivDoublePrimitiveTest() {
        val p1 = property(2.0)
        val p2 = 2.0
        val p = p1 / p2
        assertEquals(p1.value / p2, p.value)
    }
    
    @Test
    fun propertyDoubleRemDoublePrimitiveTest() {
        val p1 = property(2.0)
        val p2 = 2.0
        val p = p1 % p2
        assertEquals(p1.value % p2, p.value)
    }
    
    @Test
    fun propertyDoublePlusShortPrimitiveTest() {
        val p1 = property(2.0)
        val p2 = 6.toShort()
        val p = p1 + p2
        assertEquals(p1.value + p2, p.value)
    }
    
    @Test
    fun propertyDoubleMinusShortPrimitiveTest() {
        val p1 = property(2.0)
        val p2 = 6.toShort()
        val p = p1 - p2
        assertEquals(p1.value - p2, p.value)
    }
    
    @Test
    fun propertyDoubleTimesShortPrimitiveTest() {
        val p1 = property(2.0)
        val p2 = 6.toShort()
        val p = p1 * p2
        assertEquals(p1.value * p2, p.value)
    }
    
    @Test
    fun propertyDoubleDivShortPrimitiveTest() {
        val p1 = property(2.0)
        val p2 = 6.toShort()
        val p = p1 / p2
        assertEquals(p1.value / p2, p.value)
    }
    
    @Test
    fun propertyDoubleRemShortPrimitiveTest() {
        val p1 = property(2.0)
        val p2 = 6.toShort()
        val p = p1 % p2
        assertEquals(p1.value % p2, p.value)
    }
    
    @Test
    fun propertyDoublePlusBytePrimitiveTest() {
        val p1 = property(2.0)
        val p2 = 1.toByte()
        val p = p1 + p2
        assertEquals(p1.value + p2, p.value)
    }
    
    @Test
    fun propertyDoubleMinusBytePrimitiveTest() {
        val p1 = property(2.0)
        val p2 = 1.toByte()
        val p = p1 - p2
        assertEquals(p1.value - p2, p.value)
    }
    
    @Test
    fun propertyDoubleTimesBytePrimitiveTest() {
        val p1 = property(2.0)
        val p2 = 1.toByte()
        val p = p1 * p2
        assertEquals(p1.value * p2, p.value)
    }
    
    @Test
    fun propertyDoubleDivBytePrimitiveTest() {
        val p1 = property(2.0)
        val p2 = 1.toByte()
        val p = p1 / p2
        assertEquals(p1.value / p2, p.value)
    }
    
    @Test
    fun propertyDoubleRemBytePrimitiveTest() {
        val p1 = property(2.0)
        val p2 = 1.toByte()
        val p = p1 % p2
        assertEquals(p1.value % p2, p.value)
    }
    
    @Test
    fun propertyShortPlusIntPrimitiveTest() {
        val p1 = property(6.toShort())
        val p2 = 5
        val p = p1 + p2
        assertEquals(p1.value + p2, p.value)
    }
    
    @Test
    fun propertyShortMinusIntPrimitiveTest() {
        val p1 = property(6.toShort())
        val p2 = 5
        val p = p1 - p2
        assertEquals(p1.value - p2, p.value)
    }
    
    @Test
    fun propertyShortTimesIntPrimitiveTest() {
        val p1 = property(6.toShort())
        val p2 = 5
        val p = p1 * p2
        assertEquals(p1.value * p2, p.value)
    }
    
    @Test
    fun propertyShortDivIntPrimitiveTest() {
        val p1 = property(6.toShort())
        val p2 = 5
        val p = p1 / p2
        assertEquals(p1.value / p2, p.value)
    }
    
    @Test
    fun propertyShortRemIntPrimitiveTest() {
        val p1 = property(6.toShort())
        val p2 = 5
        val p = p1 % p2
        assertEquals(p1.value % p2, p.value)
    }
    
    @Test
    fun propertyShortPlusLongPrimitiveTest() {
        val p1 = property(6.toShort())
        val p2 = 4L
        val p = p1 + p2
        assertEquals(p1.value + p2, p.value)
    }
    
    @Test
    fun propertyShortMinusLongPrimitiveTest() {
        val p1 = property(6.toShort())
        val p2 = 4L
        val p = p1 - p2
        assertEquals(p1.value - p2, p.value)
    }
    
    @Test
    fun propertyShortTimesLongPrimitiveTest() {
        val p1 = property(6.toShort())
        val p2 = 4L
        val p = p1 * p2
        assertEquals(p1.value * p2, p.value)
    }
    
    @Test
    fun propertyShortDivLongPrimitiveTest() {
        val p1 = property(6.toShort())
        val p2 = 4L
        val p = p1 / p2
        assertEquals(p1.value / p2, p.value)
    }
    
    @Test
    fun propertyShortRemLongPrimitiveTest() {
        val p1 = property(6.toShort())
        val p2 = 4L
        val p = p1 % p2
        assertEquals(p1.value % p2, p.value)
    }
    
    @Test
    fun propertyShortPlusFloatPrimitiveTest() {
        val p1 = property(6.toShort())
        val p2 = 3.0f
        val p = p1 + p2
        assertEquals(p1.value + p2, p.value)
    }
    
    @Test
    fun propertyShortMinusFloatPrimitiveTest() {
        val p1 = property(6.toShort())
        val p2 = 3.0f
        val p = p1 - p2
        assertEquals(p1.value - p2, p.value)
    }
    
    @Test
    fun propertyShortTimesFloatPrimitiveTest() {
        val p1 = property(6.toShort())
        val p2 = 3.0f
        val p = p1 * p2
        assertEquals(p1.value * p2, p.value)
    }
    
    @Test
    fun propertyShortDivFloatPrimitiveTest() {
        val p1 = property(6.toShort())
        val p2 = 3.0f
        val p = p1 / p2
        assertEquals(p1.value / p2, p.value)
    }
    
    @Test
    fun propertyShortRemFloatPrimitiveTest() {
        val p1 = property(6.toShort())
        val p2 = 3.0f
        val p = p1 % p2
        assertEquals(p1.value % p2, p.value)
    }
    
    @Test
    fun propertyShortPlusDoublePrimitiveTest() {
        val p1 = property(6.toShort())
        val p2 = 2.0
        val p = p1 + p2
        assertEquals(p1.value + p2, p.value)
    }
    
    @Test
    fun propertyShortMinusDoublePrimitiveTest() {
        val p1 = property(6.toShort())
        val p2 = 2.0
        val p = p1 - p2
        assertEquals(p1.value - p2, p.value)
    }
    
    @Test
    fun propertyShortTimesDoublePrimitiveTest() {
        val p1 = property(6.toShort())
        val p2 = 2.0
        val p = p1 * p2
        assertEquals(p1.value * p2, p.value)
    }
    
    @Test
    fun propertyShortDivDoublePrimitiveTest() {
        val p1 = property(6.toShort())
        val p2 = 2.0
        val p = p1 / p2
        assertEquals(p1.value / p2, p.value)
    }
    
    @Test
    fun propertyShortRemDoublePrimitiveTest() {
        val p1 = property(6.toShort())
        val p2 = 2.0
        val p = p1 % p2
        assertEquals(p1.value % p2, p.value)
    }
    
    @Test
    fun propertyShortPlusShortPrimitiveTest() {
        val p1 = property(6.toShort())
        val p2 = 6.toShort()
        val p = p1 + p2
        assertEquals(p1.value + p2, p.value)
    }
    
    @Test
    fun propertyShortMinusShortPrimitiveTest() {
        val p1 = property(6.toShort())
        val p2 = 6.toShort()
        val p = p1 - p2
        assertEquals(p1.value - p2, p.value)
    }
    
    @Test
    fun propertyShortTimesShortPrimitiveTest() {
        val p1 = property(6.toShort())
        val p2 = 6.toShort()
        val p = p1 * p2
        assertEquals(p1.value * p2, p.value)
    }
    
    @Test
    fun propertyShortDivShortPrimitiveTest() {
        val p1 = property(6.toShort())
        val p2 = 6.toShort()
        val p = p1 / p2
        assertEquals(p1.value / p2, p.value)
    }
    
    @Test
    fun propertyShortRemShortPrimitiveTest() {
        val p1 = property(6.toShort())
        val p2 = 6.toShort()
        val p = p1 % p2
        assertEquals(p1.value % p2, p.value)
    }
    
    @Test
    fun propertyShortPlusBytePrimitiveTest() {
        val p1 = property(6.toShort())
        val p2 = 1.toByte()
        val p = p1 + p2
        assertEquals(p1.value + p2, p.value)
    }
    
    @Test
    fun propertyShortMinusBytePrimitiveTest() {
        val p1 = property(6.toShort())
        val p2 = 1.toByte()
        val p = p1 - p2
        assertEquals(p1.value - p2, p.value)
    }
    
    @Test
    fun propertyShortTimesBytePrimitiveTest() {
        val p1 = property(6.toShort())
        val p2 = 1.toByte()
        val p = p1 * p2
        assertEquals(p1.value * p2, p.value)
    }
    
    @Test
    fun propertyShortDivBytePrimitiveTest() {
        val p1 = property(6.toShort())
        val p2 = 1.toByte()
        val p = p1 / p2
        assertEquals(p1.value / p2, p.value)
    }
    
    @Test
    fun propertyShortRemBytePrimitiveTest() {
        val p1 = property(6.toShort())
        val p2 = 1.toByte()
        val p = p1 % p2
        assertEquals(p1.value % p2, p.value)
    }
    
    @Test
    fun propertyBytePlusIntPrimitiveTest() {
        val p1 = property(1.toByte())
        val p2 = 5
        val p = p1 + p2
        assertEquals(p1.value + p2, p.value)
    }
    
    @Test
    fun propertyByteMinusIntPrimitiveTest() {
        val p1 = property(1.toByte())
        val p2 = 5
        val p = p1 - p2
        assertEquals(p1.value - p2, p.value)
    }
    
    @Test
    fun propertyByteTimesIntPrimitiveTest() {
        val p1 = property(1.toByte())
        val p2 = 5
        val p = p1 * p2
        assertEquals(p1.value * p2, p.value)
    }
    
    @Test
    fun propertyByteDivIntPrimitiveTest() {
        val p1 = property(1.toByte())
        val p2 = 5
        val p = p1 / p2
        assertEquals(p1.value / p2, p.value)
    }
    
    @Test
    fun propertyByteRemIntPrimitiveTest() {
        val p1 = property(1.toByte())
        val p2 = 5
        val p = p1 % p2
        assertEquals(p1.value % p2, p.value)
    }
    
    @Test
    fun propertyBytePlusLongPrimitiveTest() {
        val p1 = property(1.toByte())
        val p2 = 4L
        val p = p1 + p2
        assertEquals(p1.value + p2, p.value)
    }
    
    @Test
    fun propertyByteMinusLongPrimitiveTest() {
        val p1 = property(1.toByte())
        val p2 = 4L
        val p = p1 - p2
        assertEquals(p1.value - p2, p.value)
    }
    
    @Test
    fun propertyByteTimesLongPrimitiveTest() {
        val p1 = property(1.toByte())
        val p2 = 4L
        val p = p1 * p2
        assertEquals(p1.value * p2, p.value)
    }
    
    @Test
    fun propertyByteDivLongPrimitiveTest() {
        val p1 = property(1.toByte())
        val p2 = 4L
        val p = p1 / p2
        assertEquals(p1.value / p2, p.value)
    }
    
    @Test
    fun propertyByteRemLongPrimitiveTest() {
        val p1 = property(1.toByte())
        val p2 = 4L
        val p = p1 % p2
        assertEquals(p1.value % p2, p.value)
    }
    
    @Test
    fun propertyBytePlusFloatPrimitiveTest() {
        val p1 = property(1.toByte())
        val p2 = 3.0f
        val p = p1 + p2
        assertEquals(p1.value + p2, p.value)
    }
    
    @Test
    fun propertyByteMinusFloatPrimitiveTest() {
        val p1 = property(1.toByte())
        val p2 = 3.0f
        val p = p1 - p2
        assertEquals(p1.value - p2, p.value)
    }
    
    @Test
    fun propertyByteTimesFloatPrimitiveTest() {
        val p1 = property(1.toByte())
        val p2 = 3.0f
        val p = p1 * p2
        assertEquals(p1.value * p2, p.value)
    }
    
    @Test
    fun propertyByteDivFloatPrimitiveTest() {
        val p1 = property(1.toByte())
        val p2 = 3.0f
        val p = p1 / p2
        assertEquals(p1.value / p2, p.value)
    }
    
    @Test
    fun propertyByteRemFloatPrimitiveTest() {
        val p1 = property(1.toByte())
        val p2 = 3.0f
        val p = p1 % p2
        assertEquals(p1.value % p2, p.value)
    }
    
    @Test
    fun propertyBytePlusDoublePrimitiveTest() {
        val p1 = property(1.toByte())
        val p2 = 2.0
        val p = p1 + p2
        assertEquals(p1.value + p2, p.value)
    }
    
    @Test
    fun propertyByteMinusDoublePrimitiveTest() {
        val p1 = property(1.toByte())
        val p2 = 2.0
        val p = p1 - p2
        assertEquals(p1.value - p2, p.value)
    }
    
    @Test
    fun propertyByteTimesDoublePrimitiveTest() {
        val p1 = property(1.toByte())
        val p2 = 2.0
        val p = p1 * p2
        assertEquals(p1.value * p2, p.value)
    }
    
    @Test
    fun propertyByteDivDoublePrimitiveTest() {
        val p1 = property(1.toByte())
        val p2 = 2.0
        val p = p1 / p2
        assertEquals(p1.value / p2, p.value)
    }
    
    @Test
    fun propertyByteRemDoublePrimitiveTest() {
        val p1 = property(1.toByte())
        val p2 = 2.0
        val p = p1 % p2
        assertEquals(p1.value % p2, p.value)
    }
    
    @Test
    fun propertyBytePlusShortPrimitiveTest() {
        val p1 = property(1.toByte())
        val p2 = 6.toShort()
        val p = p1 + p2
        assertEquals(p1.value + p2, p.value)
    }
    
    @Test
    fun propertyByteMinusShortPrimitiveTest() {
        val p1 = property(1.toByte())
        val p2 = 6.toShort()
        val p = p1 - p2
        assertEquals(p1.value - p2, p.value)
    }
    
    @Test
    fun propertyByteTimesShortPrimitiveTest() {
        val p1 = property(1.toByte())
        val p2 = 6.toShort()
        val p = p1 * p2
        assertEquals(p1.value * p2, p.value)
    }
    
    @Test
    fun propertyByteDivShortPrimitiveTest() {
        val p1 = property(1.toByte())
        val p2 = 6.toShort()
        val p = p1 / p2
        assertEquals(p1.value / p2, p.value)
    }
    
    @Test
    fun propertyByteRemShortPrimitiveTest() {
        val p1 = property(1.toByte())
        val p2 = 6.toShort()
        val p = p1 % p2
        assertEquals(p1.value % p2, p.value)
    }
    
    @Test
    fun propertyBytePlusBytePrimitiveTest() {
        val p1 = property(1.toByte())
        val p2 = 1.toByte()
        val p = p1 + p2
        assertEquals(p1.value + p2, p.value)
    }
    
    @Test
    fun propertyByteMinusBytePrimitiveTest() {
        val p1 = property(1.toByte())
        val p2 = 1.toByte()
        val p = p1 - p2
        assertEquals(p1.value - p2, p.value)
    }
    
    @Test
    fun propertyByteTimesBytePrimitiveTest() {
        val p1 = property(1.toByte())
        val p2 = 1.toByte()
        val p = p1 * p2
        assertEquals(p1.value * p2, p.value)
    }
    
    @Test
    fun propertyByteDivBytePrimitiveTest() {
        val p1 = property(1.toByte())
        val p2 = 1.toByte()
        val p = p1 / p2
        assertEquals(p1.value / p2, p.value)
    }
    
    @Test
    fun propertyByteRemBytePrimitiveTest() {
        val p1 = property(1.toByte())
        val p2 = 1.toByte()
        val p = p1 % p2
        assertEquals(p1.value % p2, p.value)
    }
    
    @Test
    fun propertyIntPrimitivePlusIntTest() {
        val p1 = 5
        val p2 = property(5)
        val p = p1 + p2
        assertEquals(p1 + p2.value, p.value)
    }
    
    @Test
    fun propertyIntPrimitiveMinusIntTest() {
        val p1 = 5
        val p2 = property(5)
        val p = p1 - p2
        assertEquals(p1 - p2.value, p.value)
    }
    
    @Test
    fun propertyIntPrimitiveTimesIntTest() {
        val p1 = 5
        val p2 = property(5)
        val p = p1 * p2
        assertEquals(p1 * p2.value, p.value)
    }
    
    @Test
    fun propertyIntPrimitiveDivIntTest() {
        val p1 = 5
        val p2 = property(5)
        val p = p1 / p2
        assertEquals(p1 / p2.value, p.value)
    }
    
    @Test
    fun propertyIntPrimitiveRemIntTest() {
        val p1 = 5
        val p2 = property(5)
        val p = p1 % p2
        assertEquals(p1 % p2.value, p.value)
    }
    
    @Test
    fun propertyIntPrimitivePlusLongTest() {
        val p1 = 5
        val p2 = property(4L)
        val p = p1 + p2
        assertEquals(p1 + p2.value, p.value)
    }
    
    @Test
    fun propertyIntPrimitiveMinusLongTest() {
        val p1 = 5
        val p2 = property(4L)
        val p = p1 - p2
        assertEquals(p1 - p2.value, p.value)
    }
    
    @Test
    fun propertyIntPrimitiveTimesLongTest() {
        val p1 = 5
        val p2 = property(4L)
        val p = p1 * p2
        assertEquals(p1 * p2.value, p.value)
    }
    
    @Test
    fun propertyIntPrimitiveDivLongTest() {
        val p1 = 5
        val p2 = property(4L)
        val p = p1 / p2
        assertEquals(p1 / p2.value, p.value)
    }
    
    @Test
    fun propertyIntPrimitiveRemLongTest() {
        val p1 = 5
        val p2 = property(4L)
        val p = p1 % p2
        assertEquals(p1 % p2.value, p.value)
    }
    
    @Test
    fun propertyIntPrimitivePlusFloatTest() {
        val p1 = 5
        val p2 = property(3.0f)
        val p = p1 + p2
        assertEquals(p1 + p2.value, p.value)
    }
    
    @Test
    fun propertyIntPrimitiveMinusFloatTest() {
        val p1 = 5
        val p2 = property(3.0f)
        val p = p1 - p2
        assertEquals(p1 - p2.value, p.value)
    }
    
    @Test
    fun propertyIntPrimitiveTimesFloatTest() {
        val p1 = 5
        val p2 = property(3.0f)
        val p = p1 * p2
        assertEquals(p1 * p2.value, p.value)
    }
    
    @Test
    fun propertyIntPrimitiveDivFloatTest() {
        val p1 = 5
        val p2 = property(3.0f)
        val p = p1 / p2
        assertEquals(p1 / p2.value, p.value)
    }
    
    @Test
    fun propertyIntPrimitiveRemFloatTest() {
        val p1 = 5
        val p2 = property(3.0f)
        val p = p1 % p2
        assertEquals(p1 % p2.value, p.value)
    }
    
    @Test
    fun propertyIntPrimitivePlusDoubleTest() {
        val p1 = 5
        val p2 = property(2.0)
        val p = p1 + p2
        assertEquals(p1 + p2.value, p.value)
    }
    
    @Test
    fun propertyIntPrimitiveMinusDoubleTest() {
        val p1 = 5
        val p2 = property(2.0)
        val p = p1 - p2
        assertEquals(p1 - p2.value, p.value)
    }
    
    @Test
    fun propertyIntPrimitiveTimesDoubleTest() {
        val p1 = 5
        val p2 = property(2.0)
        val p = p1 * p2
        assertEquals(p1 * p2.value, p.value)
    }
    
    @Test
    fun propertyIntPrimitiveDivDoubleTest() {
        val p1 = 5
        val p2 = property(2.0)
        val p = p1 / p2
        assertEquals(p1 / p2.value, p.value)
    }
    
    @Test
    fun propertyIntPrimitiveRemDoubleTest() {
        val p1 = 5
        val p2 = property(2.0)
        val p = p1 % p2
        assertEquals(p1 % p2.value, p.value)
    }
    
    @Test
    fun propertyIntPrimitivePlusShortTest() {
        val p1 = 5
        val p2 = property(6.toShort())
        val p = p1 + p2
        assertEquals(p1 + p2.value, p.value)
    }
    
    @Test
    fun propertyIntPrimitiveMinusShortTest() {
        val p1 = 5
        val p2 = property(6.toShort())
        val p = p1 - p2
        assertEquals(p1 - p2.value, p.value)
    }
    
    @Test
    fun propertyIntPrimitiveTimesShortTest() {
        val p1 = 5
        val p2 = property(6.toShort())
        val p = p1 * p2
        assertEquals(p1 * p2.value, p.value)
    }
    
    @Test
    fun propertyIntPrimitiveDivShortTest() {
        val p1 = 5
        val p2 = property(6.toShort())
        val p = p1 / p2
        assertEquals(p1 / p2.value, p.value)
    }
    
    @Test
    fun propertyIntPrimitiveRemShortTest() {
        val p1 = 5
        val p2 = property(6.toShort())
        val p = p1 % p2
        assertEquals(p1 % p2.value, p.value)
    }
    
    @Test
    fun propertyIntPrimitivePlusByteTest() {
        val p1 = 5
        val p2 = property(1.toByte())
        val p = p1 + p2
        assertEquals(p1 + p2.value, p.value)
    }
    
    @Test
    fun propertyIntPrimitiveMinusByteTest() {
        val p1 = 5
        val p2 = property(1.toByte())
        val p = p1 - p2
        assertEquals(p1 - p2.value, p.value)
    }
    
    @Test
    fun propertyIntPrimitiveTimesByteTest() {
        val p1 = 5
        val p2 = property(1.toByte())
        val p = p1 * p2
        assertEquals(p1 * p2.value, p.value)
    }
    
    @Test
    fun propertyIntPrimitiveDivByteTest() {
        val p1 = 5
        val p2 = property(1.toByte())
        val p = p1 / p2
        assertEquals(p1 / p2.value, p.value)
    }
    
    @Test
    fun propertyIntPrimitiveRemByteTest() {
        val p1 = 5
        val p2 = property(1.toByte())
        val p = p1 % p2
        assertEquals(p1 % p2.value, p.value)
    }
    
    @Test
    fun propertyLongPrimitivePlusIntTest() {
        val p1 = 4L
        val p2 = property(5)
        val p = p1 + p2
        assertEquals(p1 + p2.value, p.value)
    }
    
    @Test
    fun propertyLongPrimitiveMinusIntTest() {
        val p1 = 4L
        val p2 = property(5)
        val p = p1 - p2
        assertEquals(p1 - p2.value, p.value)
    }
    
    @Test
    fun propertyLongPrimitiveTimesIntTest() {
        val p1 = 4L
        val p2 = property(5)
        val p = p1 * p2
        assertEquals(p1 * p2.value, p.value)
    }
    
    @Test
    fun propertyLongPrimitiveDivIntTest() {
        val p1 = 4L
        val p2 = property(5)
        val p = p1 / p2
        assertEquals(p1 / p2.value, p.value)
    }
    
    @Test
    fun propertyLongPrimitiveRemIntTest() {
        val p1 = 4L
        val p2 = property(5)
        val p = p1 % p2
        assertEquals(p1 % p2.value, p.value)
    }
    
    @Test
    fun propertyLongPrimitivePlusLongTest() {
        val p1 = 4L
        val p2 = property(4L)
        val p = p1 + p2
        assertEquals(p1 + p2.value, p.value)
    }
    
    @Test
    fun propertyLongPrimitiveMinusLongTest() {
        val p1 = 4L
        val p2 = property(4L)
        val p = p1 - p2
        assertEquals(p1 - p2.value, p.value)
    }
    
    @Test
    fun propertyLongPrimitiveTimesLongTest() {
        val p1 = 4L
        val p2 = property(4L)
        val p = p1 * p2
        assertEquals(p1 * p2.value, p.value)
    }
    
    @Test
    fun propertyLongPrimitiveDivLongTest() {
        val p1 = 4L
        val p2 = property(4L)
        val p = p1 / p2
        assertEquals(p1 / p2.value, p.value)
    }
    
    @Test
    fun propertyLongPrimitiveRemLongTest() {
        val p1 = 4L
        val p2 = property(4L)
        val p = p1 % p2
        assertEquals(p1 % p2.value, p.value)
    }
    
    @Test
    fun propertyLongPrimitivePlusFloatTest() {
        val p1 = 4L
        val p2 = property(3.0f)
        val p = p1 + p2
        assertEquals(p1 + p2.value, p.value)
    }
    
    @Test
    fun propertyLongPrimitiveMinusFloatTest() {
        val p1 = 4L
        val p2 = property(3.0f)
        val p = p1 - p2
        assertEquals(p1 - p2.value, p.value)
    }
    
    @Test
    fun propertyLongPrimitiveTimesFloatTest() {
        val p1 = 4L
        val p2 = property(3.0f)
        val p = p1 * p2
        assertEquals(p1 * p2.value, p.value)
    }
    
    @Test
    fun propertyLongPrimitiveDivFloatTest() {
        val p1 = 4L
        val p2 = property(3.0f)
        val p = p1 / p2
        assertEquals(p1 / p2.value, p.value)
    }
    
    @Test
    fun propertyLongPrimitiveRemFloatTest() {
        val p1 = 4L
        val p2 = property(3.0f)
        val p = p1 % p2
        assertEquals(p1 % p2.value, p.value)
    }
    
    @Test
    fun propertyLongPrimitivePlusDoubleTest() {
        val p1 = 4L
        val p2 = property(2.0)
        val p = p1 + p2
        assertEquals(p1 + p2.value, p.value)
    }
    
    @Test
    fun propertyLongPrimitiveMinusDoubleTest() {
        val p1 = 4L
        val p2 = property(2.0)
        val p = p1 - p2
        assertEquals(p1 - p2.value, p.value)
    }
    
    @Test
    fun propertyLongPrimitiveTimesDoubleTest() {
        val p1 = 4L
        val p2 = property(2.0)
        val p = p1 * p2
        assertEquals(p1 * p2.value, p.value)
    }
    
    @Test
    fun propertyLongPrimitiveDivDoubleTest() {
        val p1 = 4L
        val p2 = property(2.0)
        val p = p1 / p2
        assertEquals(p1 / p2.value, p.value)
    }
    
    @Test
    fun propertyLongPrimitiveRemDoubleTest() {
        val p1 = 4L
        val p2 = property(2.0)
        val p = p1 % p2
        assertEquals(p1 % p2.value, p.value)
    }
    
    @Test
    fun propertyLongPrimitivePlusShortTest() {
        val p1 = 4L
        val p2 = property(6.toShort())
        val p = p1 + p2
        assertEquals(p1 + p2.value, p.value)
    }
    
    @Test
    fun propertyLongPrimitiveMinusShortTest() {
        val p1 = 4L
        val p2 = property(6.toShort())
        val p = p1 - p2
        assertEquals(p1 - p2.value, p.value)
    }
    
    @Test
    fun propertyLongPrimitiveTimesShortTest() {
        val p1 = 4L
        val p2 = property(6.toShort())
        val p = p1 * p2
        assertEquals(p1 * p2.value, p.value)
    }
    
    @Test
    fun propertyLongPrimitiveDivShortTest() {
        val p1 = 4L
        val p2 = property(6.toShort())
        val p = p1 / p2
        assertEquals(p1 / p2.value, p.value)
    }
    
    @Test
    fun propertyLongPrimitiveRemShortTest() {
        val p1 = 4L
        val p2 = property(6.toShort())
        val p = p1 % p2
        assertEquals(p1 % p2.value, p.value)
    }
    
    @Test
    fun propertyLongPrimitivePlusByteTest() {
        val p1 = 4L
        val p2 = property(1.toByte())
        val p = p1 + p2
        assertEquals(p1 + p2.value, p.value)
    }
    
    @Test
    fun propertyLongPrimitiveMinusByteTest() {
        val p1 = 4L
        val p2 = property(1.toByte())
        val p = p1 - p2
        assertEquals(p1 - p2.value, p.value)
    }
    
    @Test
    fun propertyLongPrimitiveTimesByteTest() {
        val p1 = 4L
        val p2 = property(1.toByte())
        val p = p1 * p2
        assertEquals(p1 * p2.value, p.value)
    }
    
    @Test
    fun propertyLongPrimitiveDivByteTest() {
        val p1 = 4L
        val p2 = property(1.toByte())
        val p = p1 / p2
        assertEquals(p1 / p2.value, p.value)
    }
    
    @Test
    fun propertyLongPrimitiveRemByteTest() {
        val p1 = 4L
        val p2 = property(1.toByte())
        val p = p1 % p2
        assertEquals(p1 % p2.value, p.value)
    }
    
    @Test
    fun propertyFloatPrimitivePlusIntTest() {
        val p1 = 3.0f
        val p2 = property(5)
        val p = p1 + p2
        assertEquals(p1 + p2.value, p.value)
    }
    
    @Test
    fun propertyFloatPrimitiveMinusIntTest() {
        val p1 = 3.0f
        val p2 = property(5)
        val p = p1 - p2
        assertEquals(p1 - p2.value, p.value)
    }
    
    @Test
    fun propertyFloatPrimitiveTimesIntTest() {
        val p1 = 3.0f
        val p2 = property(5)
        val p = p1 * p2
        assertEquals(p1 * p2.value, p.value)
    }
    
    @Test
    fun propertyFloatPrimitiveDivIntTest() {
        val p1 = 3.0f
        val p2 = property(5)
        val p = p1 / p2
        assertEquals(p1 / p2.value, p.value)
    }
    
    @Test
    fun propertyFloatPrimitiveRemIntTest() {
        val p1 = 3.0f
        val p2 = property(5)
        val p = p1 % p2
        assertEquals(p1 % p2.value, p.value)
    }
    
    @Test
    fun propertyFloatPrimitivePlusLongTest() {
        val p1 = 3.0f
        val p2 = property(4L)
        val p = p1 + p2
        assertEquals(p1 + p2.value, p.value)
    }
    
    @Test
    fun propertyFloatPrimitiveMinusLongTest() {
        val p1 = 3.0f
        val p2 = property(4L)
        val p = p1 - p2
        assertEquals(p1 - p2.value, p.value)
    }
    
    @Test
    fun propertyFloatPrimitiveTimesLongTest() {
        val p1 = 3.0f
        val p2 = property(4L)
        val p = p1 * p2
        assertEquals(p1 * p2.value, p.value)
    }
    
    @Test
    fun propertyFloatPrimitiveDivLongTest() {
        val p1 = 3.0f
        val p2 = property(4L)
        val p = p1 / p2
        assertEquals(p1 / p2.value, p.value)
    }
    
    @Test
    fun propertyFloatPrimitiveRemLongTest() {
        val p1 = 3.0f
        val p2 = property(4L)
        val p = p1 % p2
        assertEquals(p1 % p2.value, p.value)
    }
    
    @Test
    fun propertyFloatPrimitivePlusFloatTest() {
        val p1 = 3.0f
        val p2 = property(3.0f)
        val p = p1 + p2
        assertEquals(p1 + p2.value, p.value)
    }
    
    @Test
    fun propertyFloatPrimitiveMinusFloatTest() {
        val p1 = 3.0f
        val p2 = property(3.0f)
        val p = p1 - p2
        assertEquals(p1 - p2.value, p.value)
    }
    
    @Test
    fun propertyFloatPrimitiveTimesFloatTest() {
        val p1 = 3.0f
        val p2 = property(3.0f)
        val p = p1 * p2
        assertEquals(p1 * p2.value, p.value)
    }
    
    @Test
    fun propertyFloatPrimitiveDivFloatTest() {
        val p1 = 3.0f
        val p2 = property(3.0f)
        val p = p1 / p2
        assertEquals(p1 / p2.value, p.value)
    }
    
    @Test
    fun propertyFloatPrimitiveRemFloatTest() {
        val p1 = 3.0f
        val p2 = property(3.0f)
        val p = p1 % p2
        assertEquals(p1 % p2.value, p.value)
    }
    
    @Test
    fun propertyFloatPrimitivePlusDoubleTest() {
        val p1 = 3.0f
        val p2 = property(2.0)
        val p = p1 + p2
        assertEquals(p1 + p2.value, p.value)
    }
    
    @Test
    fun propertyFloatPrimitiveMinusDoubleTest() {
        val p1 = 3.0f
        val p2 = property(2.0)
        val p = p1 - p2
        assertEquals(p1 - p2.value, p.value)
    }
    
    @Test
    fun propertyFloatPrimitiveTimesDoubleTest() {
        val p1 = 3.0f
        val p2 = property(2.0)
        val p = p1 * p2
        assertEquals(p1 * p2.value, p.value)
    }
    
    @Test
    fun propertyFloatPrimitiveDivDoubleTest() {
        val p1 = 3.0f
        val p2 = property(2.0)
        val p = p1 / p2
        assertEquals(p1 / p2.value, p.value)
    }
    
    @Test
    fun propertyFloatPrimitiveRemDoubleTest() {
        val p1 = 3.0f
        val p2 = property(2.0)
        val p = p1 % p2
        assertEquals(p1 % p2.value, p.value)
    }
    
    @Test
    fun propertyFloatPrimitivePlusShortTest() {
        val p1 = 3.0f
        val p2 = property(6.toShort())
        val p = p1 + p2
        assertEquals(p1 + p2.value, p.value)
    }
    
    @Test
    fun propertyFloatPrimitiveMinusShortTest() {
        val p1 = 3.0f
        val p2 = property(6.toShort())
        val p = p1 - p2
        assertEquals(p1 - p2.value, p.value)
    }
    
    @Test
    fun propertyFloatPrimitiveTimesShortTest() {
        val p1 = 3.0f
        val p2 = property(6.toShort())
        val p = p1 * p2
        assertEquals(p1 * p2.value, p.value)
    }
    
    @Test
    fun propertyFloatPrimitiveDivShortTest() {
        val p1 = 3.0f
        val p2 = property(6.toShort())
        val p = p1 / p2
        assertEquals(p1 / p2.value, p.value)
    }
    
    @Test
    fun propertyFloatPrimitiveRemShortTest() {
        val p1 = 3.0f
        val p2 = property(6.toShort())
        val p = p1 % p2
        assertEquals(p1 % p2.value, p.value)
    }
    
    @Test
    fun propertyFloatPrimitivePlusByteTest() {
        val p1 = 3.0f
        val p2 = property(1.toByte())
        val p = p1 + p2
        assertEquals(p1 + p2.value, p.value)
    }
    
    @Test
    fun propertyFloatPrimitiveMinusByteTest() {
        val p1 = 3.0f
        val p2 = property(1.toByte())
        val p = p1 - p2
        assertEquals(p1 - p2.value, p.value)
    }
    
    @Test
    fun propertyFloatPrimitiveTimesByteTest() {
        val p1 = 3.0f
        val p2 = property(1.toByte())
        val p = p1 * p2
        assertEquals(p1 * p2.value, p.value)
    }
    
    @Test
    fun propertyFloatPrimitiveDivByteTest() {
        val p1 = 3.0f
        val p2 = property(1.toByte())
        val p = p1 / p2
        assertEquals(p1 / p2.value, p.value)
    }
    
    @Test
    fun propertyFloatPrimitiveRemByteTest() {
        val p1 = 3.0f
        val p2 = property(1.toByte())
        val p = p1 % p2
        assertEquals(p1 % p2.value, p.value)
    }
    
    @Test
    fun propertyDoublePrimitivePlusIntTest() {
        val p1 = 2.0
        val p2 = property(5)
        val p = p1 + p2
        assertEquals(p1 + p2.value, p.value)
    }
    
    @Test
    fun propertyDoublePrimitiveMinusIntTest() {
        val p1 = 2.0
        val p2 = property(5)
        val p = p1 - p2
        assertEquals(p1 - p2.value, p.value)
    }
    
    @Test
    fun propertyDoublePrimitiveTimesIntTest() {
        val p1 = 2.0
        val p2 = property(5)
        val p = p1 * p2
        assertEquals(p1 * p2.value, p.value)
    }
    
    @Test
    fun propertyDoublePrimitiveDivIntTest() {
        val p1 = 2.0
        val p2 = property(5)
        val p = p1 / p2
        assertEquals(p1 / p2.value, p.value)
    }
    
    @Test
    fun propertyDoublePrimitiveRemIntTest() {
        val p1 = 2.0
        val p2 = property(5)
        val p = p1 % p2
        assertEquals(p1 % p2.value, p.value)
    }
    
    @Test
    fun propertyDoublePrimitivePlusLongTest() {
        val p1 = 2.0
        val p2 = property(4L)
        val p = p1 + p2
        assertEquals(p1 + p2.value, p.value)
    }
    
    @Test
    fun propertyDoublePrimitiveMinusLongTest() {
        val p1 = 2.0
        val p2 = property(4L)
        val p = p1 - p2
        assertEquals(p1 - p2.value, p.value)
    }
    
    @Test
    fun propertyDoublePrimitiveTimesLongTest() {
        val p1 = 2.0
        val p2 = property(4L)
        val p = p1 * p2
        assertEquals(p1 * p2.value, p.value)
    }
    
    @Test
    fun propertyDoublePrimitiveDivLongTest() {
        val p1 = 2.0
        val p2 = property(4L)
        val p = p1 / p2
        assertEquals(p1 / p2.value, p.value)
    }
    
    @Test
    fun propertyDoublePrimitiveRemLongTest() {
        val p1 = 2.0
        val p2 = property(4L)
        val p = p1 % p2
        assertEquals(p1 % p2.value, p.value)
    }
    
    @Test
    fun propertyDoublePrimitivePlusFloatTest() {
        val p1 = 2.0
        val p2 = property(3.0f)
        val p = p1 + p2
        assertEquals(p1 + p2.value, p.value)
    }
    
    @Test
    fun propertyDoublePrimitiveMinusFloatTest() {
        val p1 = 2.0
        val p2 = property(3.0f)
        val p = p1 - p2
        assertEquals(p1 - p2.value, p.value)
    }
    
    @Test
    fun propertyDoublePrimitiveTimesFloatTest() {
        val p1 = 2.0
        val p2 = property(3.0f)
        val p = p1 * p2
        assertEquals(p1 * p2.value, p.value)
    }
    
    @Test
    fun propertyDoublePrimitiveDivFloatTest() {
        val p1 = 2.0
        val p2 = property(3.0f)
        val p = p1 / p2
        assertEquals(p1 / p2.value, p.value)
    }
    
    @Test
    fun propertyDoublePrimitiveRemFloatTest() {
        val p1 = 2.0
        val p2 = property(3.0f)
        val p = p1 % p2
        assertEquals(p1 % p2.value, p.value)
    }
    
    @Test
    fun propertyDoublePrimitivePlusDoubleTest() {
        val p1 = 2.0
        val p2 = property(2.0)
        val p = p1 + p2
        assertEquals(p1 + p2.value, p.value)
    }
    
    @Test
    fun propertyDoublePrimitiveMinusDoubleTest() {
        val p1 = 2.0
        val p2 = property(2.0)
        val p = p1 - p2
        assertEquals(p1 - p2.value, p.value)
    }
    
    @Test
    fun propertyDoublePrimitiveTimesDoubleTest() {
        val p1 = 2.0
        val p2 = property(2.0)
        val p = p1 * p2
        assertEquals(p1 * p2.value, p.value)
    }
    
    @Test
    fun propertyDoublePrimitiveDivDoubleTest() {
        val p1 = 2.0
        val p2 = property(2.0)
        val p = p1 / p2
        assertEquals(p1 / p2.value, p.value)
    }
    
    @Test
    fun propertyDoublePrimitiveRemDoubleTest() {
        val p1 = 2.0
        val p2 = property(2.0)
        val p = p1 % p2
        assertEquals(p1 % p2.value, p.value)
    }
    
    @Test
    fun propertyDoublePrimitivePlusShortTest() {
        val p1 = 2.0
        val p2 = property(6.toShort())
        val p = p1 + p2
        assertEquals(p1 + p2.value, p.value)
    }
    
    @Test
    fun propertyDoublePrimitiveMinusShortTest() {
        val p1 = 2.0
        val p2 = property(6.toShort())
        val p = p1 - p2
        assertEquals(p1 - p2.value, p.value)
    }
    
    @Test
    fun propertyDoublePrimitiveTimesShortTest() {
        val p1 = 2.0
        val p2 = property(6.toShort())
        val p = p1 * p2
        assertEquals(p1 * p2.value, p.value)
    }
    
    @Test
    fun propertyDoublePrimitiveDivShortTest() {
        val p1 = 2.0
        val p2 = property(6.toShort())
        val p = p1 / p2
        assertEquals(p1 / p2.value, p.value)
    }
    
    @Test
    fun propertyDoublePrimitiveRemShortTest() {
        val p1 = 2.0
        val p2 = property(6.toShort())
        val p = p1 % p2
        assertEquals(p1 % p2.value, p.value)
    }
    
    @Test
    fun propertyDoublePrimitivePlusByteTest() {
        val p1 = 2.0
        val p2 = property(1.toByte())
        val p = p1 + p2
        assertEquals(p1 + p2.value, p.value)
    }
    
    @Test
    fun propertyDoublePrimitiveMinusByteTest() {
        val p1 = 2.0
        val p2 = property(1.toByte())
        val p = p1 - p2
        assertEquals(p1 - p2.value, p.value)
    }
    
    @Test
    fun propertyDoublePrimitiveTimesByteTest() {
        val p1 = 2.0
        val p2 = property(1.toByte())
        val p = p1 * p2
        assertEquals(p1 * p2.value, p.value)
    }
    
    @Test
    fun propertyDoublePrimitiveDivByteTest() {
        val p1 = 2.0
        val p2 = property(1.toByte())
        val p = p1 / p2
        assertEquals(p1 / p2.value, p.value)
    }
    
    @Test
    fun propertyDoublePrimitiveRemByteTest() {
        val p1 = 2.0
        val p2 = property(1.toByte())
        val p = p1 % p2
        assertEquals(p1 % p2.value, p.value)
    }
    
    @Test
    fun propertyShortPrimitivePlusIntTest() {
        val p1 = 6.toShort()
        val p2 = property(5)
        val p = p1 + p2
        assertEquals(p1 + p2.value, p.value)
    }
    
    @Test
    fun propertyShortPrimitiveMinusIntTest() {
        val p1 = 6.toShort()
        val p2 = property(5)
        val p = p1 - p2
        assertEquals(p1 - p2.value, p.value)
    }
    
    @Test
    fun propertyShortPrimitiveTimesIntTest() {
        val p1 = 6.toShort()
        val p2 = property(5)
        val p = p1 * p2
        assertEquals(p1 * p2.value, p.value)
    }
    
    @Test
    fun propertyShortPrimitiveDivIntTest() {
        val p1 = 6.toShort()
        val p2 = property(5)
        val p = p1 / p2
        assertEquals(p1 / p2.value, p.value)
    }
    
    @Test
    fun propertyShortPrimitiveRemIntTest() {
        val p1 = 6.toShort()
        val p2 = property(5)
        val p = p1 % p2
        assertEquals(p1 % p2.value, p.value)
    }
    
    @Test
    fun propertyShortPrimitivePlusLongTest() {
        val p1 = 6.toShort()
        val p2 = property(4L)
        val p = p1 + p2
        assertEquals(p1 + p2.value, p.value)
    }
    
    @Test
    fun propertyShortPrimitiveMinusLongTest() {
        val p1 = 6.toShort()
        val p2 = property(4L)
        val p = p1 - p2
        assertEquals(p1 - p2.value, p.value)
    }
    
    @Test
    fun propertyShortPrimitiveTimesLongTest() {
        val p1 = 6.toShort()
        val p2 = property(4L)
        val p = p1 * p2
        assertEquals(p1 * p2.value, p.value)
    }
    
    @Test
    fun propertyShortPrimitiveDivLongTest() {
        val p1 = 6.toShort()
        val p2 = property(4L)
        val p = p1 / p2
        assertEquals(p1 / p2.value, p.value)
    }
    
    @Test
    fun propertyShortPrimitiveRemLongTest() {
        val p1 = 6.toShort()
        val p2 = property(4L)
        val p = p1 % p2
        assertEquals(p1 % p2.value, p.value)
    }
    
    @Test
    fun propertyShortPrimitivePlusFloatTest() {
        val p1 = 6.toShort()
        val p2 = property(3.0f)
        val p = p1 + p2
        assertEquals(p1 + p2.value, p.value)
    }
    
    @Test
    fun propertyShortPrimitiveMinusFloatTest() {
        val p1 = 6.toShort()
        val p2 = property(3.0f)
        val p = p1 - p2
        assertEquals(p1 - p2.value, p.value)
    }
    
    @Test
    fun propertyShortPrimitiveTimesFloatTest() {
        val p1 = 6.toShort()
        val p2 = property(3.0f)
        val p = p1 * p2
        assertEquals(p1 * p2.value, p.value)
    }
    
    @Test
    fun propertyShortPrimitiveDivFloatTest() {
        val p1 = 6.toShort()
        val p2 = property(3.0f)
        val p = p1 / p2
        assertEquals(p1 / p2.value, p.value)
    }
    
    @Test
    fun propertyShortPrimitiveRemFloatTest() {
        val p1 = 6.toShort()
        val p2 = property(3.0f)
        val p = p1 % p2
        assertEquals(p1 % p2.value, p.value)
    }
    
    @Test
    fun propertyShortPrimitivePlusDoubleTest() {
        val p1 = 6.toShort()
        val p2 = property(2.0)
        val p = p1 + p2
        assertEquals(p1 + p2.value, p.value)
    }
    
    @Test
    fun propertyShortPrimitiveMinusDoubleTest() {
        val p1 = 6.toShort()
        val p2 = property(2.0)
        val p = p1 - p2
        assertEquals(p1 - p2.value, p.value)
    }
    
    @Test
    fun propertyShortPrimitiveTimesDoubleTest() {
        val p1 = 6.toShort()
        val p2 = property(2.0)
        val p = p1 * p2
        assertEquals(p1 * p2.value, p.value)
    }
    
    @Test
    fun propertyShortPrimitiveDivDoubleTest() {
        val p1 = 6.toShort()
        val p2 = property(2.0)
        val p = p1 / p2
        assertEquals(p1 / p2.value, p.value)
    }
    
    @Test
    fun propertyShortPrimitiveRemDoubleTest() {
        val p1 = 6.toShort()
        val p2 = property(2.0)
        val p = p1 % p2
        assertEquals(p1 % p2.value, p.value)
    }
    
    @Test
    fun propertyShortPrimitivePlusShortTest() {
        val p1 = 6.toShort()
        val p2 = property(6.toShort())
        val p = p1 + p2
        assertEquals(p1 + p2.value, p.value)
    }
    
    @Test
    fun propertyShortPrimitiveMinusShortTest() {
        val p1 = 6.toShort()
        val p2 = property(6.toShort())
        val p = p1 - p2
        assertEquals(p1 - p2.value, p.value)
    }
    
    @Test
    fun propertyShortPrimitiveTimesShortTest() {
        val p1 = 6.toShort()
        val p2 = property(6.toShort())
        val p = p1 * p2
        assertEquals(p1 * p2.value, p.value)
    }
    
    @Test
    fun propertyShortPrimitiveDivShortTest() {
        val p1 = 6.toShort()
        val p2 = property(6.toShort())
        val p = p1 / p2
        assertEquals(p1 / p2.value, p.value)
    }
    
    @Test
    fun propertyShortPrimitiveRemShortTest() {
        val p1 = 6.toShort()
        val p2 = property(6.toShort())
        val p = p1 % p2
        assertEquals(p1 % p2.value, p.value)
    }
    
    @Test
    fun propertyShortPrimitivePlusByteTest() {
        val p1 = 6.toShort()
        val p2 = property(1.toByte())
        val p = p1 + p2
        assertEquals(p1 + p2.value, p.value)
    }
    
    @Test
    fun propertyShortPrimitiveMinusByteTest() {
        val p1 = 6.toShort()
        val p2 = property(1.toByte())
        val p = p1 - p2
        assertEquals(p1 - p2.value, p.value)
    }
    
    @Test
    fun propertyShortPrimitiveTimesByteTest() {
        val p1 = 6.toShort()
        val p2 = property(1.toByte())
        val p = p1 * p2
        assertEquals(p1 * p2.value, p.value)
    }
    
    @Test
    fun propertyShortPrimitiveDivByteTest() {
        val p1 = 6.toShort()
        val p2 = property(1.toByte())
        val p = p1 / p2
        assertEquals(p1 / p2.value, p.value)
    }
    
    @Test
    fun propertyShortPrimitiveRemByteTest() {
        val p1 = 6.toShort()
        val p2 = property(1.toByte())
        val p = p1 % p2
        assertEquals(p1 % p2.value, p.value)
    }
    
    @Test
    fun propertyBytePrimitivePlusIntTest() {
        val p1 = 1.toByte()
        val p2 = property(5)
        val p = p1 + p2
        assertEquals(p1 + p2.value, p.value)
    }
    
    @Test
    fun propertyBytePrimitiveMinusIntTest() {
        val p1 = 1.toByte()
        val p2 = property(5)
        val p = p1 - p2
        assertEquals(p1 - p2.value, p.value)
    }
    
    @Test
    fun propertyBytePrimitiveTimesIntTest() {
        val p1 = 1.toByte()
        val p2 = property(5)
        val p = p1 * p2
        assertEquals(p1 * p2.value, p.value)
    }
    
    @Test
    fun propertyBytePrimitiveDivIntTest() {
        val p1 = 1.toByte()
        val p2 = property(5)
        val p = p1 / p2
        assertEquals(p1 / p2.value, p.value)
    }
    
    @Test
    fun propertyBytePrimitiveRemIntTest() {
        val p1 = 1.toByte()
        val p2 = property(5)
        val p = p1 % p2
        assertEquals(p1 % p2.value, p.value)
    }
    
    @Test
    fun propertyBytePrimitivePlusLongTest() {
        val p1 = 1.toByte()
        val p2 = property(4L)
        val p = p1 + p2
        assertEquals(p1 + p2.value, p.value)
    }
    
    @Test
    fun propertyBytePrimitiveMinusLongTest() {
        val p1 = 1.toByte()
        val p2 = property(4L)
        val p = p1 - p2
        assertEquals(p1 - p2.value, p.value)
    }
    
    @Test
    fun propertyBytePrimitiveTimesLongTest() {
        val p1 = 1.toByte()
        val p2 = property(4L)
        val p = p1 * p2
        assertEquals(p1 * p2.value, p.value)
    }
    
    @Test
    fun propertyBytePrimitiveDivLongTest() {
        val p1 = 1.toByte()
        val p2 = property(4L)
        val p = p1 / p2
        assertEquals(p1 / p2.value, p.value)
    }
    
    @Test
    fun propertyBytePrimitiveRemLongTest() {
        val p1 = 1.toByte()
        val p2 = property(4L)
        val p = p1 % p2
        assertEquals(p1 % p2.value, p.value)
    }
    
    @Test
    fun propertyBytePrimitivePlusFloatTest() {
        val p1 = 1.toByte()
        val p2 = property(3.0f)
        val p = p1 + p2
        assertEquals(p1 + p2.value, p.value)
    }
    
    @Test
    fun propertyBytePrimitiveMinusFloatTest() {
        val p1 = 1.toByte()
        val p2 = property(3.0f)
        val p = p1 - p2
        assertEquals(p1 - p2.value, p.value)
    }
    
    @Test
    fun propertyBytePrimitiveTimesFloatTest() {
        val p1 = 1.toByte()
        val p2 = property(3.0f)
        val p = p1 * p2
        assertEquals(p1 * p2.value, p.value)
    }
    
    @Test
    fun propertyBytePrimitiveDivFloatTest() {
        val p1 = 1.toByte()
        val p2 = property(3.0f)
        val p = p1 / p2
        assertEquals(p1 / p2.value, p.value)
    }
    
    @Test
    fun propertyBytePrimitiveRemFloatTest() {
        val p1 = 1.toByte()
        val p2 = property(3.0f)
        val p = p1 % p2
        assertEquals(p1 % p2.value, p.value)
    }
    
    @Test
    fun propertyBytePrimitivePlusDoubleTest() {
        val p1 = 1.toByte()
        val p2 = property(2.0)
        val p = p1 + p2
        assertEquals(p1 + p2.value, p.value)
    }
    
    @Test
    fun propertyBytePrimitiveMinusDoubleTest() {
        val p1 = 1.toByte()
        val p2 = property(2.0)
        val p = p1 - p2
        assertEquals(p1 - p2.value, p.value)
    }
    
    @Test
    fun propertyBytePrimitiveTimesDoubleTest() {
        val p1 = 1.toByte()
        val p2 = property(2.0)
        val p = p1 * p2
        assertEquals(p1 * p2.value, p.value)
    }
    
    @Test
    fun propertyBytePrimitiveDivDoubleTest() {
        val p1 = 1.toByte()
        val p2 = property(2.0)
        val p = p1 / p2
        assertEquals(p1 / p2.value, p.value)
    }
    
    @Test
    fun propertyBytePrimitiveRemDoubleTest() {
        val p1 = 1.toByte()
        val p2 = property(2.0)
        val p = p1 % p2
        assertEquals(p1 % p2.value, p.value)
    }
    
    @Test
    fun propertyBytePrimitivePlusShortTest() {
        val p1 = 1.toByte()
        val p2 = property(6.toShort())
        val p = p1 + p2
        assertEquals(p1 + p2.value, p.value)
    }
    
    @Test
    fun propertyBytePrimitiveMinusShortTest() {
        val p1 = 1.toByte()
        val p2 = property(6.toShort())
        val p = p1 - p2
        assertEquals(p1 - p2.value, p.value)
    }
    
    @Test
    fun propertyBytePrimitiveTimesShortTest() {
        val p1 = 1.toByte()
        val p2 = property(6.toShort())
        val p = p1 * p2
        assertEquals(p1 * p2.value, p.value)
    }
    
    @Test
    fun propertyBytePrimitiveDivShortTest() {
        val p1 = 1.toByte()
        val p2 = property(6.toShort())
        val p = p1 / p2
        assertEquals(p1 / p2.value, p.value)
    }
    
    @Test
    fun propertyBytePrimitiveRemShortTest() {
        val p1 = 1.toByte()
        val p2 = property(6.toShort())
        val p = p1 % p2
        assertEquals(p1 % p2.value, p.value)
    }
    
    @Test
    fun propertyBytePrimitivePlusByteTest() {
        val p1 = 1.toByte()
        val p2 = property(1.toByte())
        val p = p1 + p2
        assertEquals(p1 + p2.value, p.value)
    }
    
    @Test
    fun propertyBytePrimitiveMinusByteTest() {
        val p1 = 1.toByte()
        val p2 = property(1.toByte())
        val p = p1 - p2
        assertEquals(p1 - p2.value, p.value)
    }
    
    @Test
    fun propertyBytePrimitiveTimesByteTest() {
        val p1 = 1.toByte()
        val p2 = property(1.toByte())
        val p = p1 * p2
        assertEquals(p1 * p2.value, p.value)
    }
    
    @Test
    fun propertyBytePrimitiveDivByteTest() {
        val p1 = 1.toByte()
        val p2 = property(1.toByte())
        val p = p1 / p2
        assertEquals(p1 / p2.value, p.value)
    }
    
    @Test
    fun propertyBytePrimitiveRemByteTest() {
        val p1 = 1.toByte()
        val p2 = property(1.toByte())
        val p = p1 % p2
        assertEquals(p1 % p2.value, p.value)
    }
}
