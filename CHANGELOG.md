# Changelog
All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [0.6.3] - 2019-01-08
### Changed
- implement `invalidate` for object property.

## [0.6.2] - 2019-01-07
### Added
- `isWritable` attribute to `Property`.

## [0.6.1] - 2018-12-16
### Changed
- Update javadoc.

## [0.6.0] - 2018-12-15
### Added
- Flat map transform property.

### Fixes
- Null pointer exception by flat map mutable property.

## [0.5.1] - 2018-11-28
### Added
- Math extensions for static numbers.

## [0.5.0] - 2018-11-27
### Added
- Property binding.
- Math extension bindings.

## [0.4.2] - 2018-11-26
### Changed
- Hide actual classes behind interfaces.

## [0.4.1] - 2018-11-26
### Changed
- `FunctionProperty` now implements `ValidationProperty`.

## [0.4.0] - 2018-11-26
### Added
- `ValidationProperty`.
- `FunctionProperty`. (Useful for custom getter and/or setter functions.)

## [0.3.0] - 2018-11-24
### Added
- Flat map for nested properties.
- Mapped observable list.
- Filtered observable list.
- Sorted observable list.

### Changed
- rename `map` to `mapBinding` to avoid conflicts with `List.map()`
- `ObservableList` now inherits from `ReadOnlyProperty` to allow `mapBinding` 

## [0.2.0] - 2018-11-21
### Added
- `ObservableList`.
- `ObservableListIterator`.
- Event listener reference.

### Changed
- `EventHandler.invoke()` now returns `Unit` to avoid confusions.

## [0.1.0] - 2018-11-19
### Added
- Event handler.
- Basic properties.
