[![Build Status](https://travis-ci.org/pixix4/KObserve.svg?branch=master)](https://travis-ci.org/pixix4/KObserve)
[![Download](https://api.bintray.com/packages/pixix4/maven/KObserve/images/download.svg) ](https://bintray.com/pixix4/maven/KObserve/_latestVersion)

# KObserve
An easy to use kotlin library for observable properties.

## Quick start
To use this library simply add this to your `build.gradle`
```groovy
repositories {
    jcenter()
}

dependencies {
    implementation "de.westermann:KObserve-jvm:0.1.0"
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
    implementation "de.westermann:KObserve:0.1.0"
}
```

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
