# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

This is a Java practice playground repository designed for learning Java programming concepts through progressive exercises. It contains four main learning modules with comprehensive test coverage:

- **Strings Module**: 18 exercises covering String manipulation methods
- **Collections Module**: 38 exercises covering Lists, Sets, Maps, Queues, and advanced collections
- **Streams Module**: 33 exercises covering Java Stream API and functional programming
- **Sorting Module**: 37 exercises covering Comparable, Comparator, and advanced sorting techniques

Each module follows a test-driven learning approach where exercises are implemented to make failing tests pass.

## Build System

**Java Version**: 21
**Build Tool**: Maven
**Testing Framework**: JUnit 5.10.1

## Common Commands

### Testing

```bash
# Run all tests
mvn test

# Run tests for a specific module
mvn test -Dtest=StringExercisesTest
mvn test -Dtest="*collections*"
mvn test -Dtest=StreamExercisesTest
mvn test -Dtest="*sorting*"

# Run individual exercise class tests
mvn test -Dtest=ListExercisesTest
mvn test -Dtest=SetExercisesTest
mvn test -Dtest=MapExercisesTest
mvn test -Dtest=AdvancedCollectionsExercisesTest
mvn test -Dtest=ComparableExercisesTest
mvn test -Dtest=ComparatorExercisesTest
mvn test -Dtest=AdvancedSortingExercisesTest

# Run specific test methods
mvn test -Dtest=StringExercisesTest#testGetStringLength*
mvn test -Dtest=StreamExercisesTest#testCount*
mvn test -Dtest=ComparableExercisesTest#testCreateComparableString*
```

### Build Operations

```bash
# Compile the project
mvn compile

# Compile tests
mvn test-compile

# Clean build artifacts
mvn clean

# Full clean and test
mvn clean test
```

## Code Architecture

### Package Structure

```
com.juanpicasti.practice/
├── strings/          # String manipulation exercises
├── collections/      # Collections Framework exercises
├── streams/          # Stream API exercises
└── sorting/          # Comparable, Comparator, and sorting exercises
```

Each package contains:
- Exercise class(es) with numbered methods (e.g., `StringExercises.java`)
- Corresponding test class(es) with comprehensive test coverage
- README.md with exercise details and API reference

### Exercise Pattern

All exercise classes follow a consistent pattern:

1. **Numbered Methods**: Each exercise is a method numbered sequentially (e.g., Exercise 1, Exercise 2, etc.)
2. **Javadoc Documentation**: Every exercise method has detailed Javadoc explaining requirements, parameters, returns, and exceptions
3. **Progressive Difficulty**: Exercises progress from basic (⭐) to advanced (⭐⭐⭐⭐)
4. **Initial State**: Methods throw `UnsupportedOperationException()` until implemented
5. **Test Coverage**: Each exercise has 3-6 test cases covering normal cases and edge cases

### Module-Specific Details

**Strings Module** (`strings/StringExercises.java`):
- Organized into sections: Basic Operations, Extraction & Access, Case Operations, Trimming & Cleaning, Searching, Modification, Splitting & Joining, and Advanced
- Focus on mastering String API methods like `length()`, `substring()`, `replace()`, `split()`, etc.
- Comprehensive null handling and edge case validation

**Collections Module**:
- Split into four classes: `ListExercises`, `SetExercises`, `MapExercises`, `AdvancedCollectionsExercises`
- Covers ArrayList vs LinkedList, HashSet vs TreeSet, HashMap vs TreeMap
- Includes Queue, Deque, PriorityQueue, and custom Comparators
- Emphasizes understanding time complexity trade-offs

**Streams Module** (`streams/StreamExercises.java`):
- Three difficulty levels: Basic (1-10), Intermediate (11-22), Advanced (23-33)
- Covers stream creation, intermediate operations (filter, map, flatMap, sorted), terminal operations (collect, reduce, match)
- Extensive use of Collectors (groupingBy, partitioningBy, joining, etc.)
- Method reference exercises (static, instance, constructor)
- Real-world scenarios with custom objects (Person, Product classes)

**Sorting Module**:
- Split into three classes: `ComparableExercises`, `ComparatorExercises`, `AdvancedSortingExercises`
- Covers natural ordering with Comparable, custom comparison with Comparator
- Includes comparator chaining, null handling, TreeSet/TreeMap, and multi-level sorting
- Exercises with Person, Product, Book, and Employee domain objects
- Emphasizes overflow-safe comparison and builder patterns for complex comparators

## Working with This Repository

When implementing exercises:

1. Locate the exercise method by number or name in the appropriate class
2. Read the Javadoc carefully to understand requirements
3. Consider edge cases (null inputs, empty collections, boundary conditions)
4. Run tests frequently to validate implementation
5. Refer to the module's README.md for API reference and examples

When debugging test failures:

- Test class names follow pattern `*ExercisesTest.java`
- Test methods use descriptive names like `testMethodName_scenario`
- Tests use JUnit 5 assertions and `@DisplayName` annotations for clarity

## Test Statistics

- **Total Exercises**: 126 across all modules (18 Strings + 38 Collections + 33 Streams + 37 Sorting)
- **Total Test Cases**: 400+
- **Coverage**: Every exercise has comprehensive edge case testing
