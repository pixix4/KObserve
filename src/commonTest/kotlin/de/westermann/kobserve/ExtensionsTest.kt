package de.westermann.kobserve

import de.westermann.kobserve.basic.property
import de.westermann.kobserve.list.observableListOf
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
    fun testInt() {
        val number1 = property(2)
        val number2 = property(3)

        assertEquals(number1.value + number2.value, (number1 + number2).value)
        assertEquals(number1.value - number2.value, (number1 - number2).value)
        assertEquals(number1.value * number2.value, (number1 * number2).value)
        assertEquals(number1.value / number2.value, (number1 / number2).value)
        assertEquals(number1.value % number2.value, (number1 % number2).value)
        assertEquals(-number1.value, (-number1).value)
    }

    @Test
    fun testLong() {
        val number1 = property(2L)
        val number2 = property(3L)

        assertEquals(number1.value + number2.value, (number1 + number2).value)
        assertEquals(number1.value - number2.value, (number1 - number2).value)
        assertEquals(number1.value * number2.value, (number1 * number2).value)
        assertEquals(number1.value / number2.value, (number1 / number2).value)
        assertEquals(number1.value % number2.value, (number1 % number2).value)
        assertEquals(-number1.value, (-number1).value)
    }

    @Test
    fun testDouble() {
        val number1 = property(2.0)
        val number2 = property(3.0)

        assertEquals(number1.value + number2.value, (number1 + number2).value)
        assertEquals(number1.value - number2.value, (number1 - number2).value)
        assertEquals(number1.value * number2.value, (number1 * number2).value)
        assertEquals(number1.value / number2.value, (number1 / number2).value)
        assertEquals(number1.value % number2.value, (number1 % number2).value)
        assertEquals(-number1.value, (-number1).value)
    }

    @Test
    fun testFloat() {
        val number1 = property(2.0F)
        val number2 = property(3.0F)

        assertEquals(number1.value + number2.value, (number1 + number2).value)
        assertEquals(number1.value - number2.value, (number1 - number2).value)
        assertEquals(number1.value * number2.value, (number1 * number2).value)
        assertEquals(number1.value / number2.value, (number1 / number2).value)
        assertEquals(number1.value % number2.value, (number1 % number2).value)
        assertEquals(-number1.value, (-number1).value)
    }

    @Test
    fun testIntLong() {
        val number1 = property(2)
        val number2 = property(3L)

        assertEquals(number1.value + number2.value, (number1 + number2).value)
        assertEquals(number1.value - number2.value, (number1 - number2).value)
        assertEquals(number1.value * number2.value, (number1 * number2).value)
        assertEquals(number1.value / number2.value, (number1 / number2).value)
        assertEquals(number1.value % number2.value, (number1 % number2).value)
    }

    @Test
    fun testLongInt() {
        val number1 = property(2L)
        val number2 = property(3)

        assertEquals(number1.value + number2.value, (number1 + number2).value)
        assertEquals(number1.value - number2.value, (number1 - number2).value)
        assertEquals(number1.value * number2.value, (number1 * number2).value)
        assertEquals(number1.value / number2.value, (number1 / number2).value)
        assertEquals(number1.value % number2.value, (number1 % number2).value)
    }

    @Test
    fun testIntFloat() {
        val number1 = property(2)
        val number2 = property(3.0F)

        assertEquals(number1.value + number2.value, (number1 + number2).value)
        assertEquals(number1.value - number2.value, (number1 - number2).value)
        assertEquals(number1.value * number2.value, (number1 * number2).value)
        assertEquals(number1.value / number2.value, (number1 / number2).value)
        assertEquals(number1.value % number2.value, (number1 % number2).value)
    }

    @Test
    fun testFloatInt() {
        val number1 = property(2.0F)
        val number2 = property(3)

        assertEquals(number1.value + number2.value, (number1 + number2).value)
        assertEquals(number1.value - number2.value, (number1 - number2).value)
        assertEquals(number1.value * number2.value, (number1 * number2).value)
        assertEquals(number1.value / number2.value, (number1 / number2).value)
        assertEquals(number1.value % number2.value, (number1 % number2).value)
    }

    @Test
    fun testIntDouble() {
        val number1 = property(2)
        val number2 = property(3.0)

        assertEquals(number1.value + number2.value, (number1 + number2).value)
        assertEquals(number1.value - number2.value, (number1 - number2).value)
        assertEquals(number1.value * number2.value, (number1 * number2).value)
        assertEquals(number1.value / number2.value, (number1 / number2).value)
        assertEquals(number1.value % number2.value, (number1 % number2).value)
    }

    @Test
    fun testDoubleInt() {
        val number1 = property(2.0)
        val number2 = property(3)

        assertEquals(number1.value + number2.value, (number1 + number2).value)
        assertEquals(number1.value - number2.value, (number1 - number2).value)
        assertEquals(number1.value * number2.value, (number1 * number2).value)
        assertEquals(number1.value / number2.value, (number1 / number2).value)
        assertEquals(number1.value % number2.value, (number1 % number2).value)
    }

    @Test
    fun testLongFloat() {
        val number1 = property(2L)
        val number2 = property(3.0F)

        assertEquals(number1.value + number2.value, (number1 + number2).value)
        assertEquals(number1.value - number2.value, (number1 - number2).value)
        assertEquals(number1.value * number2.value, (number1 * number2).value)
        assertEquals(number1.value / number2.value, (number1 / number2).value)
        assertEquals(number1.value % number2.value, (number1 % number2).value)
    }

    @Test
    fun testFloatLong() {
        val number1 = property(2.0F)
        val number2 = property(3L)

        assertEquals(number1.value + number2.value, (number1 + number2).value)
        assertEquals(number1.value - number2.value, (number1 - number2).value)
        assertEquals(number1.value * number2.value, (number1 * number2).value)
        assertEquals(number1.value / number2.value, (number1 / number2).value)
        assertEquals(number1.value % number2.value, (number1 % number2).value)
    }

    @Test
    fun testLongDouble() {
        val number1 = property(2L)
        val number2 = property(3.0)

        assertEquals(number1.value + number2.value, (number1 + number2).value)
        assertEquals(number1.value - number2.value, (number1 - number2).value)
        assertEquals(number1.value * number2.value, (number1 * number2).value)
        assertEquals(number1.value / number2.value, (number1 / number2).value)
        assertEquals(number1.value % number2.value, (number1 % number2).value)
    }

    @Test
    fun testDoubleLong() {
        val number1 = property(2.0)
        val number2 = property(3L)

        assertEquals(number1.value + number2.value, (number1 + number2).value)
        assertEquals(number1.value - number2.value, (number1 - number2).value)
        assertEquals(number1.value * number2.value, (number1 * number2).value)
        assertEquals(number1.value / number2.value, (number1 / number2).value)
        assertEquals(number1.value % number2.value, (number1 % number2).value)
    }

    @Test
    fun testFloatDouble() {
        val number1 = property(2.0F)
        val number2 = property(3.0)

        assertEquals(number1.value + number2.value, (number1 + number2).value)
        assertEquals(number1.value - number2.value, (number1 - number2).value)
        assertEquals(number1.value * number2.value, (number1 * number2).value)
        assertEquals(number1.value / number2.value, (number1 / number2).value)
        assertEquals(number1.value % number2.value, (number1 % number2).value)
    }

    @Test
    fun testDoubleFloat() {
        val number1 = property(2.0)
        val number2 = property(3.0F)

        assertEquals(number1.value + number2.value, (number1 + number2).value)
        assertEquals(number1.value - number2.value, (number1 - number2).value)
        assertEquals(number1.value * number2.value, (number1 * number2).value)
        assertEquals(number1.value / number2.value, (number1 / number2).value)
        assertEquals(number1.value % number2.value, (number1 % number2).value)
    }

    @Test
    fun testListSum() {
        val list = observableListOf(1, 2, 3, 4, 5)
        val sum = list.sumObservable()

        assertEquals(list.sum(), sum.value)

        list += 6

        assertEquals(list.sum(), sum.value)
    }

    @Test
    fun testListAverage() {
        val list = observableListOf(1, 2, 3, 4, 5)
        val average = list.averageObservable()

        assertEquals(list.average(), average.value)

        list += 6

        assertEquals(list.average(), average.value)
    }

    @Test
    fun test() {
        val number1 = property(2)
        val number2 = property(10)
        val number3 = property(5.0)
        val number4 = property(7)

        val calc = ((1 - number1) * number2 / 5) % number4 * number3 + 1337
        assertEquals(calc, calc)
    }
}
