# Changelog
All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [0.3.0] - 2019-11-24
### Added
- Flat map for nested properties.
- Mapped observable list.
- Filtered observable list.
- Sorted observable list.

### Changed
- rename `map` to `mapBinding` to avoid conflicts with `List.map()`
- `ObservableList` now inherits from `ReadOnlyProperty` to allow `mapBinding` 

## [0.2.0] - 2019-11-21
### Added
- Observable list.
- Observable list iterator.
- Event listener reference.

### Changed
- `EventHandler.invoke()` now returns `Unit` to avoid confusions.

## [0.1.0] - 2018-11-19
### Added
- Event handler.
- Basic properties.
