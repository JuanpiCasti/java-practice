# Java Practice Playground

A comprehensive collection of Java programming exercises designed for learning and mastering core Java concepts through hands-on practice.

## Overview

This repository contains **126 progressive exercises** across four main modules, each focusing on essential Java programming skills. All exercises follow a test-driven learning approach where you implement methods to make failing tests pass.

## Modules

### 1. Strings (18 exercises)
Master String manipulation with exercises covering:
- Basic operations (length, concatenation, comparison)
- Extraction and access (charAt, substring)
- Case operations and trimming
- Searching, replacing, splitting, and joining

### 2. Collections (38 exercises)
Learn the Java Collections Framework through:
- Lists (ArrayList vs LinkedList)
- Sets (HashSet vs TreeSet)
- Maps (HashMap vs TreeMap)
- Queues, Deques, and PriorityQueues

### 3. Streams (33 exercises)
Practice functional programming with the Stream API:
- Stream creation and operations
- Filtering, mapping, and flatMapping
- Collectors and grouping
- Method references and reduction

### 4. Sorting (37 exercises)
Master comparison and sorting in Java:
- Implementing Comparable for natural ordering
- Creating custom Comparators
- Comparator chaining and null handling
- TreeSet, TreeMap, and advanced sorting patterns

## Getting Started

### Prerequisites
- Java 21
- Maven 3.x

### Running Tests

```bash
# Run all tests
mvn test

# Run tests for a specific module
mvn test -Dtest=StringExercisesTest
mvn test -Dtest="*collections*"
mvn test -Dtest=StreamExercisesTest
mvn test -Dtest="*sorting*"

# Run tests for a specific exercise class
mvn test -Dtest=ListExercisesTest
mvn test -Dtest=ComparatorExercisesTest

# Run a specific test method
mvn test -Dtest=StringExercisesTest#testGetStringLength*
```

### How to Practice

1. Navigate to an exercise class (e.g., `src/main/java/com/juanpicasti/practice/strings/StringExercises.java`)
2. Read the Javadoc for the exercise method
3. Replace the `throw new UnsupportedOperationException()` with your implementation
4. Run the tests to verify your solution
5. Refer to the module's README.md for API reference and examples

## Project Structure

```
practice/
├── src/main/java/com/juanpicasti/practice/
│   ├── strings/          # String manipulation exercises
│   ├── collections/      # Collections Framework exercises
│   ├── streams/          # Stream API exercises
│   └── sorting/          # Comparable and Comparator exercises
└── src/test/java/com/juanpicasti/practice/
    ├── strings/          # String exercise tests
    ├── collections/      # Collections exercise tests
    ├── streams/          # Stream exercise tests
    └── sorting/          # Sorting exercise tests
```

## Exercise Difficulty Levels

- ⭐ Beginner
- ⭐⭐ Intermediate
- ⭐⭐⭐ Advanced
- ⭐⭐⭐⭐ Expert

## Build Commands

```bash
# Compile the project
mvn compile

# Clean and rebuild
mvn clean compile

# Run all tests
mvn test
```

## Test Coverage

- **Total Exercises**: 126
- **Total Test Cases**: 400+
- **Coverage**: Every exercise includes comprehensive edge case testing

## Learning Approach

Each module is designed to progressively build your skills:
1. Start with basic exercises to learn fundamental concepts
2. Progress to intermediate exercises for practical applications
3. Challenge yourself with advanced exercises for real-world scenarios
4. Every exercise has detailed Javadoc explaining requirements and expectations

---

Happy coding!
