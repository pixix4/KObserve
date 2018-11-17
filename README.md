# KObserve
An easy to use kotlin library for observable properties.

## Event handler

```kotlin
val onRandomNumber = EventHandler<Int>()

onRandomNumber {
    println("The random number is $it!")
}

onRandomNumber.emit(5)
```

## Properties

Create a simple object property with the `property(T)` function:
```kotlin
val numberProperty: ObjectProperty<Int> = property(0)
var number: Int by numberProperty

numberProperty.onChange {
    println("Number has been changed!")
}

number = 2
```

or use the `observe()` extension function:
```kotlin
val numberProperty: ObjectProperty<Int> = 0.observe()
```

You can map each property to observe a member property:
```kotlin
class Person(
    var name: String
)
val personProperty = Person("John Doe").observe()

val nameProperty = personProperty.map(Person::name)
var name: String by namePropery
```

or a computed value:
```kotlin
val nameLengthProperty = nameProperty.map { it.length }
```
