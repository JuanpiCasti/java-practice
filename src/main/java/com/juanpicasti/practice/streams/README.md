# Java Stream API Practice

Comprehensive exercises to master Java Stream API for functional-style data processing.

---

## Quick Start

### Run All Stream Tests
```bash
mvn test -Dtest=StreamExercisesTest
```

### Run Specific Exercise Tests
```bash
# Run tests for exercise 1
mvn test -Dtest=StreamExercisesTest#testCount*

# Run tests for exercises 11-13 (method references)
mvn test -Dtest=StreamExercisesTest#testParse*,testLowerCaseRef*,testCreatePersons*
```

---

## Exercises Overview

### 📘 Basic Level (Exercises 1-10)
Foundation of stream operations

| # | Method | Difficulty | Key Concepts |
|---|--------|-----------|-------------|
| 1 | `countElements` | ⭐ | Stream creation, count() |
| 2 | `filterGreaterThan` | ⭐ | filter(), predicates |
| 3 | `toUpperCase` | ⭐ | map() transformation |
| 4 | `collectToSet` | ⭐ | Collectors.toSet() |
| 5 | `countLongStrings` | ⭐ | filter().count() chain |
| 6 | `containsNumber` | ⭐ | anyMatch() |
| 7 | `allPositive` | ⭐ | allMatch() |
| 8 | `sumNumbers` | ⭐⭐ | reduce() |
| 9 | `findFirstStartingWith` | ⭐⭐ | findFirst(), Optional |
| 10 | `getDistinct` | ⭐ | distinct() |

### 📙 Intermediate Level (Exercises 11-22)
Core patterns and method references

| # | Method | Difficulty | Key Concepts |
|---|--------|-----------|-------------|
| 11 | `parseIntegers` | ⭐⭐ | Static method reference |
| 12 | `toLowerCaseMethodRef` | ⭐⭐ | Instance method reference |
| 13 | `createPersons` | ⭐⭐ | Constructor reference |
| 14 | `flattenLists` | ⭐⭐ | flatMap() |
| 15 | `getNamesOfAdults` | ⭐⭐ | filter→map→collect |
| 16 | `sortByAge` | ⭐⭐ | sorted(Comparator) |
| 17 | `doubleWithPeek` | ⭐⭐ | peek() for debugging |
| 18 | `paginate` | ⭐⭐ | skip(), limit() |
| 19 | `groupByCity` | ⭐⭐⭐ | groupingBy() |
| 20 | `partitionByThreshold` | ⭐⭐⭐ | partitioningBy() |
| 21 | `joinStrings` | ⭐⭐ | joining() |
| 22 | `noneNegative` | ⭐⭐ | noneMatch() |

### 📕 Advanced Level (Exercises 23-33)
Complex operations and real-world scenarios

| # | Method | Difficulty | Key Concepts |
|---|--------|-----------|-------------|
| 23 | `personNameToAge` | ⭐⭐⭐ | toMap() |
| 24 | `getAgeStatistics` | ⭐⭐⭐ | summarizingInt() |
| 25 | `productOfNumbers` | ⭐⭐⭐ | reduce() with multiplication |
| 26 | `countPersonsByCity` | ⭐⭐⭐ | groupingBy with counting() |
| 27 | `getAllCharacters` | ⭐⭐⭐ | flatMap with chars() |
| 28 | `getAgeByName` | ⭐⭐⭐ | Optional integration |
| 29 | `getTotalPrice` | ⭐⭐⭐ | reduce() on objects |
| 30 | `groupByCategoryAndPrice` | ⭐⭐⭐⭐ | Nested grouping |
| 31 | `findOldestPerson` | ⭐⭐⭐ | max() with Comparator |
| 32 | `getAveragePrice` | ⭐⭐⭐ | averagingDouble() |
| 33 | `getAffordableProductNames` | ⭐⭐⭐⭐ | Complex multi-step pipeline |

**Total: 33 exercises with 100+ test cases**

---

## Java Stream API Reference

### 🌊 What is a Stream?

A Stream is a sequence of elements supporting sequential and parallel aggregate operations. It's not a data structure but a view of data that allows functional-style operations.

**Key Characteristics:**
- **Lazy evaluation**: Intermediate operations are not executed until a terminal operation is invoked
- **One-time use**: A stream can only be consumed once
- **No storage**: Streams don't store elements
- **Functional**: Operations produce results without modifying the source

---

### 🔄 Stream Pipeline

```
Source → Intermediate Op 1 → Intermediate Op 2 → ... → Terminal Op → Result
```

**Example:**
```java
List<String> result = list.stream()      // Source
    .filter(s -> s.length() > 3)         // Intermediate
    .map(String::toUpperCase)            // Intermediate
    .sorted()                            // Intermediate
    .collect(Collectors.toList());       // Terminal
```

---

### 📝 Stream Creation

```java
// From Collection
List<String> list = Arrays.asList("A", "B", "C");
Stream<String> stream = list.stream();

// From Array
String[] array = {"A", "B", "C"};
Stream<String> stream = Arrays.stream(array);

// From Values
Stream<String> stream = Stream.of("A", "B", "C");

// Empty Stream
Stream<String> empty = Stream.empty();

// Infinite Streams
Stream<Integer> infinite = Stream.iterate(0, n -> n + 1); // 0, 1, 2, 3, ...
Stream<Double> random = Stream.generate(Math::random);

// IntStream, LongStream, DoubleStream
IntStream numbers = IntStream.range(1, 10);  // 1 to 9
IntStream numbers2 = IntStream.rangeClosed(1, 10);  // 1 to 10
```

---

### ⚙️ Intermediate Operations

**Returns Stream<T> - Can be chained**

#### Filtering
```java
// filter(Predicate) - Keep elements matching predicate
stream.filter(s -> s.length() > 3)
stream.filter(n -> n % 2 == 0)  // Even numbers
```

#### Mapping
```java
// map(Function) - Transform each element
stream.map(String::toUpperCase)
stream.map(s -> s.length())

// mapToInt, mapToLong, mapToDouble - Convert to primitive stream
stream.mapToInt(String::length)
```

#### FlatMapping
```java
// flatMap(Function) - Flatten nested structures
Stream<List<Integer>> nested = Stream.of(
    Arrays.asList(1, 2),
    Arrays.asList(3, 4)
);
Stream<Integer> flat = nested.flatMap(List::stream); // 1, 2, 3, 4

// flatMap with Strings
stream.flatMap(s -> Arrays.stream(s.split("")))
```

#### Sorting
```java
// sorted() - Natural order
stream.sorted()

// sorted(Comparator) - Custom order
stream.sorted(Comparator.reverseOrder())
stream.sorted(Comparator.comparing(Person::getAge))
stream.sorted(Comparator.comparing(Person::getAge).reversed())
stream.sorted(Comparator.comparing(Person::getCity)
                        .thenComparing(Person::getName))
```

#### Distinct & Limit
```java
// distinct() - Remove duplicates
stream.distinct()

// limit(n) - Take first n elements
stream.limit(10)

// skip(n) - Skip first n elements
stream.skip(5)
```

#### Peeking
```java
// peek(Consumer) - Perform action without changing stream
stream.peek(System.out::println)  // Debug/logging
stream.peek(s -> System.out.println("Processing: " + s))
```

---

### 🎯 Terminal Operations

**Ends the stream - Returns result**

#### Collection
```java
// collect(Collector) - Collect to collection
List<String> list = stream.collect(Collectors.toList());
Set<String> set = stream.collect(Collectors.toSet());
String joined = stream.collect(Collectors.joining(", "));

// toArray()
String[] array = stream.toArray(String[]::new);
```

#### Reduction
```java
// reduce(BinaryOperator) - Returns Optional
Optional<Integer> sum = stream.reduce((a, b) -> a + b);
Optional<Integer> sum2 = stream.reduce(Integer::sum);

// reduce(identity, BinaryOperator) - Returns value
int sum = stream.reduce(0, (a, b) -> a + b);
int product = stream.reduce(1, (a, b) -> a * b);

// reduce(identity, accumulator, combiner) - For parallel
int sum = stream.reduce(0,
    (acc, value) -> acc + value,
    (acc1, acc2) -> acc1 + acc2);
```

#### Matching
```java
// anyMatch(Predicate) - At least one matches
boolean hasLong = stream.anyMatch(s -> s.length() > 10);

// allMatch(Predicate) - All match
boolean allPositive = stream.allMatch(n -> n > 0);

// noneMatch(Predicate) - None match
boolean noneNegative = stream.noneMatch(n -> n < 0);
```

#### Finding
```java
// findFirst() - First element (respects order)
Optional<String> first = stream.findFirst();

// findAny() - Any element (non-deterministic in parallel)
Optional<String> any = stream.findAny();
```

#### Aggregation
```java
// count() - Number of elements
long count = stream.count();

// min(Comparator) - Minimum element
Optional<Integer> min = stream.min(Integer::compare);

// max(Comparator) - Maximum element
Optional<Integer> max = stream.max(Integer::compare);
```

#### Iteration
```java
// forEach(Consumer) - Perform action on each element
stream.forEach(System.out::println);

// forEachOrdered(Consumer) - Maintains encounter order
stream.parallel().forEachOrdered(System.out::println);
```

---

### 📦 Collectors Class

**Common Collectors for collect() operation**

#### Basic Collection
```java
// To List
Collectors.toList()

// To Set
Collectors.toSet()

// To specific collection
Collectors.toCollection(ArrayList::new)
Collectors.toCollection(TreeSet::new)
```

#### To Map
```java
// toMap(keyMapper, valueMapper)
Map<Integer, String> map = persons.stream()
    .collect(Collectors.toMap(
        Person::getId,
        Person::getName
    ));

// Handle duplicate keys with merge function
Map<String, Integer> map = persons.stream()
    .collect(Collectors.toMap(
        Person::getName,
        Person::getAge,
        (age1, age2) -> age1  // Keep first
    ));
```

#### Grouping
```java
// groupingBy(classifier)
Map<String, List<Person>> byCity = persons.stream()
    .collect(Collectors.groupingBy(Person::getCity));

// groupingBy with downstream collector
Map<String, Long> countByCity = persons.stream()
    .collect(Collectors.groupingBy(
        Person::getCity,
        Collectors.counting()
    ));

Map<String, Double> avgAgeByCity = persons.stream()
    .collect(Collectors.groupingBy(
        Person::getCity,
        Collectors.averagingInt(Person::getAge)
    ));

// Nested grouping
Map<String, Map<Integer, List<Person>>> byCityThenAge = persons.stream()
    .collect(Collectors.groupingBy(
        Person::getCity,
        Collectors.groupingBy(Person::getAge)
    ));
```

#### Partitioning
```java
// partitioningBy(predicate) - Split into true/false groups
Map<Boolean, List<Person>> partitioned = persons.stream()
    .collect(Collectors.partitioningBy(p -> p.getAge() >= 18));

List<Person> adults = partitioned.get(true);
List<Person> minors = partitioned.get(false);

// With downstream collector
Map<Boolean, Long> countByAdult = persons.stream()
    .collect(Collectors.partitioningBy(
        p -> p.getAge() >= 18,
        Collectors.counting()
    ));
```

#### String Operations
```java
// joining() - Concatenate strings
String result = stream.collect(Collectors.joining());  // "ABC"

// joining(delimiter)
String result = stream.collect(Collectors.joining(", "));  // "A, B, C"

// joining(delimiter, prefix, suffix)
String result = stream.collect(Collectors.joining(", ", "[", "]"));  // "[A, B, C]"
```

#### Statistical Collectors
```java
// summarizingInt/Long/Double
IntSummaryStatistics stats = persons.stream()
    .collect(Collectors.summarizingInt(Person::getAge));

long count = stats.getCount();
int sum = stats.getSum();
int min = stats.getMin();
int max = stats.getMax();
double average = stats.getAverage();

// averagingInt/Long/Double
Double avgAge = persons.stream()
    .collect(Collectors.averagingInt(Person::getAge));

// summingInt/Long/Double
Integer totalAge = persons.stream()
    .collect(Collectors.summingInt(Person::getAge));
```

#### Reducing
```java
// reducing(BinaryOperator)
Optional<Integer> sum = stream.collect(Collectors.reducing((a, b) -> a + b));

// reducing(identity, BinaryOperator)
Integer sum = stream.collect(Collectors.reducing(0, (a, b) -> a + b));

// reducing(identity, mapper, BinaryOperator)
Integer totalAge = persons.stream()
    .collect(Collectors.reducing(
        0,
        Person::getAge,
        Integer::sum
    ));
```

---

### 🔗 Method References

**4 Types of Method References**

#### 1. Static Method Reference
```java
// ClassName::staticMethod
stream.map(Integer::parseInt)       // String -> Integer
stream.forEach(System.out::println) // Static println
```

#### 2. Instance Method Reference (on particular object)
```java
// object::instanceMethod
String prefix = "Hello ";
stream.map(prefix::concat)  // Prepend "Hello " to each
```

#### 3. Instance Method Reference (on parameter)
```java
// ClassName::instanceMethod
stream.map(String::toLowerCase)     // s -> s.toLowerCase()
stream.sorted(String::compareToIgnoreCase)
```

#### 4. Constructor Reference
```java
// ClassName::new
stream.map(Person::new)             // Create new Person
stream.toArray(String[]::new)       // Create array
```

**When to use Method References:**
- Use when lambda is just calling a method: `s -> s.toLowerCase()` → `String::toLowerCase`
- Don't use if lambda has additional logic: `s -> s.toLowerCase().trim()` (keep as lambda)

---

### 💡 Common Patterns

#### Pattern 1: Filter → Map → Collect
```java
List<String> names = persons.stream()
    .filter(p -> p.getAge() > 18)
    .map(Person::getName)
    .collect(Collectors.toList());
```

#### Pattern 2: GroupBy → Count
```java
Map<String, Long> countByCity = persons.stream()
    .collect(Collectors.groupingBy(
        Person::getCity,
        Collectors.counting()
    ));
```

#### Pattern 3: FlatMap for Nested
```java
List<Integer> allNumbers = listOfLists.stream()
    .flatMap(List::stream)
    .collect(Collectors.toList());
```

#### Pattern 4: Reduce for Aggregation
```java
int sum = numbers.stream()
    .reduce(0, Integer::sum);
```

#### Pattern 5: Optional Handling
```java
String name = persons.stream()
    .filter(p -> p.getId() == 123)
    .map(Person::getName)
    .findFirst()
    .orElse("Unknown");
```

#### Pattern 6: Sorting with Multiple Fields
```java
List<Person> sorted = persons.stream()
    .sorted(Comparator
        .comparing(Person::getCity)
        .thenComparing(Person::getAge)
        .thenComparing(Person::getName))
    .collect(Collectors.toList());
```

#### Pattern 7: Pagination
```java
List<T> page = list.stream()
    .skip(pageNumber * pageSize)
    .limit(pageSize)
    .collect(Collectors.toList());
```

---

### ⚡ Performance Considerations

#### Lazy Evaluation
```java
// Nothing happens here - no iteration!
Stream<String> stream = list.stream()
    .filter(s -> s.length() > 3)
    .map(String::toUpperCase);

// Only when terminal operation called does processing happen
List<String> result = stream.collect(Collectors.toList());
```

#### Short-Circuiting
Operations that don't need to process entire stream:
- `anyMatch()`, `allMatch()`, `noneMatch()`
- `findFirst()`, `findAny()`
- `limit()`

```java
// Stops after finding first match - doesn't process entire list
boolean hasLongName = persons.stream()
    .anyMatch(p -> p.getName().length() > 20);
```

#### Stateless vs Stateful
**Stateless** (good for parallel):
- `filter()`, `map()`, `flatMap()`

**Stateful** (may have overhead):
- `distinct()`, `sorted()`, `limit()`, `skip()`

#### Parallel Streams
```java
// Use parallelStream() for large datasets
long count = largeList.parallelStream()
    .filter(predicate)
    .count();
```

**When to use parallel:**
- Large datasets (thousands+ elements)
- Expensive operations per element
- Stateless operations
- Order doesn't matter

**When NOT to use parallel:**
- Small datasets (overhead > benefit)
- I/O operations
- Stateful operations
- Need predictable ordering

---

### 🚫 When NOT to Use Streams

**Use traditional loops when:**

1. **Need to break early**
   ```java
   // Loop is clearer
   for (String s : list) {
       if (s.equals("target")) break;
   }
   ```

2. **Need indexes**
   ```java
   // Loop is clearer
   for (int i = 0; i < list.size(); i++) {
       System.out.println(i + ": " + list.get(i));
   }
   ```

3. **Very small collections**
   ```java
   // For 2-3 elements, loop may be faster
   if (list.size() < 5) {
       for (String s : list) process(s);
   }
   ```

4. **Need to modify external state**
   ```java
   // Avoid side effects in streams
   int[] count = {0};  // BAD - mutable state
   stream.forEach(s -> count[0]++);
   ```

5. **Complex debugging needed**
   - Streams can be harder to debug
   - Use `peek()` for simple debugging
   - Consider loops for complex logic

---

### 🎓 Best Practices

#### 1. Keep it Simple
```java
// Good - clear intent
names.stream()
    .filter(n -> n.startsWith("A"))
    .collect(Collectors.toList());

// Bad - overly complex
names.stream()
    .filter(n -> {
        if (n != null && !n.isEmpty()) {
            return n.charAt(0) == 'A';
        }
        return false;
    })
    .collect(Collectors.toList());
```

#### 2. Avoid Side Effects
```java
// Bad - modifies external state
List<String> results = new ArrayList<>();
stream.forEach(s -> results.add(s.toUpperCase()));  // DON'T

// Good - use collect
List<String> results = stream
    .map(String::toUpperCase)
    .collect(Collectors.toList());
```

#### 3. Use Method References
```java
// Good
stream.map(String::toUpperCase)

// Less clear
stream.map(s -> s.toUpperCase())
```

#### 4. Handle Optional Properly
```java
// Good
String name = findPerson(id)
    .map(Person::getName)
    .orElse("Unknown");

// Bad
String name = findPerson(id).get().getName();  // Can throw!
```

#### 5. Don't Reuse Streams
```java
// Bad
Stream<String> stream = list.stream();
stream.count();
stream.forEach(System.out::println);  // IllegalStateException!

// Good
list.stream().count();
list.stream().forEach(System.out::println);
```

---

### 📚 Resources

- [Java Stream API Documentation](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/stream/Stream.html)
- [Collectors Documentation](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/stream/Collectors.html)
- [Optional Documentation](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Optional.html)

---

## Tips for Success

1. **Start with Basic Operations** - Master filter, map, collect before moving to advanced
2. **Practice Method References** - They make code more readable
3. **Understand Lazy Evaluation** - Know when operations actually execute
4. **Use Collectors** - Don't collect manually, use built-in collectors
5. **Handle Optional** - Always use orElse/orElseGet, never get() without checking
6. **Debug with peek()** - Use peek() to inspect intermediate values
7. **Think Functionally** - Immutable transformations, no side effects

---

Happy streaming!
