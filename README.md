[![Build Status](https://travis-ci.org/pixix4/KObserve.svg?branch=master)](https://travis-ci.org/pixix4/KObserve)
[![Download](https://api.bintray.com/packages/pixix4/maven/KObserve/images/download.svg) ](https://bintray.com/pixix4/maven/KObserve/_latestVersion)
[![Maintainability](https://api.codeclimate.com/v1/badges/91165ae11f0fb42f143d/maintainability)](https://codeclimate.com/github/pixix4/KObserve/maintainability)
[![Test Coverage](https://api.codeclimate.com/v1/badges/91165ae11f0fb42f143d/test_coverage)](https://codeclimate.com/github/pixix4/KObserve/test_coverage)

# KObserve
An easy to use kotlin library for observable properties.

1. [Quick start](#quick-start)
2. [Event handler](#event-handler)
3. [Properties](#properties)
4. [Observable lists](#observable-lists)

## Quick start
To use this library simply add this to your `build.gradle`
```groovy
repositories {
    jcenter()
}

dependencies {
    implementation "de.westermann:KObserve-jvm:$version"
}
```

To use it with javascript or common modules replace `KObserve-jvm` with `KObserve-js` or `KObserve-metadata` respectively.

When you use this library in common modules you need to add the platform specific dependency to each depending module.

An easier method is to enable `gradle_metadata` an experimental feature for gradle 5. This will automatically determine the target platform and include the necessary dependency.

Add this to your `settings.gradle`
```groovy
enableFeaturePreview('GRADLE_METADATA')
```

And update your `build.gradle`

```groovy
repositories {
    jcenter()
}

dependencies {
    implementation "de.westermann:KObserve:$version"
}
```

## Event handler

```kotlin
val onRandomNumber = EventHandler<Int>()

onRandomNumber { number -> Int
    println("The random number is $number!")
}

onRandomNumber.emit(5)
```

For advanced usage you can obtain a event listener reference or combine event handlers.

```kotlin
val addedReference = onRandomNumber.reference {
    println("This listener can be removed easily.")
}
addedReference.remove()

val onFoo = EventHandler<Int>()
val onBar = EventHandler<Double>()

(onRandomNumber + onFoo) { number: Int ->
    println("The int is $number!")
}
onFoo.and<Number>(onFoo) { number: Number ->
    println("The number is $number!")
}
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

## Observable lists
```kotlin
val personList = observableListOf<Person>()

val mappedList = personList.mapObservable {
    it.name
}

val filteredList = personList.filterObservable {
    it.name.length > 5
}

val sortedList = personList.sortObservable(Comparator { p1, p2 -> 
    p1.name.compareTo(p2.name)
})
```

## Math extension
```kotlin
val number1 = property(5)
val number2 = property(10)

val calcProperty = (number1 + number2) * number1
```
