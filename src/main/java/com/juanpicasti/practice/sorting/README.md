# Sorting and Comparators

This module contains **37 progressive exercises** to master sorting and comparison in Java. Learn how to implement natural ordering with Comparable, create custom comparators, chain multiple sort criteria, and handle advanced sorting scenarios.

## Quick Start

### Run All Sorting Tests
```bash
mvn test -Dtest="*sorting*"
```

### Run Tests by Class
```bash
# Comparable exercises
mvn test -Dtest=ComparableExercisesTest

# Comparator exercises
mvn test -Dtest=ComparatorExercisesTest

# Advanced sorting exercises
mvn test -Dtest=AdvancedSortingExercisesTest
```

### Run Specific Test
```bash
mvn test -Dtest=ComparableExercisesTest#testCreateComparableString_alphabeticalOrder
```

## How to Practice

1. **Start with Comparable exercises** (⭐) to understand natural ordering
2. **Move to Comparator exercises** (⭐-⭐⭐⭐) for custom sorting logic
3. **Tackle Advanced exercises** (⭐⭐-⭐⭐⭐⭐) for real-world scenarios
4. Run tests frequently to validate your implementation
5. Refer to the API Reference below for method signatures and examples

## Module Structure

This module is organized into three focused classes:

- **ComparableExercises**: Implementing natural ordering with the Comparable interface
- **ComparatorExercises**: Creating and using custom Comparators
- **AdvancedSortingExercises**: Collection utilities, TreeSet/TreeMap, and complex sorting patterns

## Exercises Overview

### ComparableExercises (10 exercises)

| # | Method | Difficulty | Key Concepts |
|---|--------|-----------|-------------|
| 1 | `createComparableString` | ⭐ | Implementing Comparable, compareTo() |
| 2 | `createComparablePersonByName` | ⭐ | String comparison, natural ordering |
| 3 | `createComparablePersonByNameThenAge` | ⭐⭐ | Multi-field comparison |
| 4 | `createComparableProductByPrice` | ⭐ | Double.compare(), numeric comparison |
| 5 | `createNullableComparableString` | ⭐⭐ | Null-safe comparison |
| 6 | `createComparableBookByYear` | ⭐ | Integer comparison |
| 7 | `sortComparablePersons` | ⭐ | Collections.sort() with Comparable |
| 8 | `createSortedProductSet` | ⭐⭐ | TreeSet with natural ordering |
| 9 | `createSafeComparableInteger` | ⭐⭐⭐ | Overflow protection, Integer.compare() |
| 10 | `createReversePersonByAge` | ⭐⭐⭐ | Reverse natural ordering |

### ComparatorExercises (15 exercises)

| # | Method | Difficulty | Key Concepts |
|---|--------|-----------|-------------|
| 1 | `createAgeComparator` | ⭐ | Comparator interface, compare() |
| 2 | `createNameComparatorLambda` | ⭐ | Lambda expressions |
| 3 | `createReversedAgeComparator` | ⭐⭐ | Comparator.reversed() |
| 4 | `createPriceComparator` | ⭐ | Comparator.comparing() |
| 5 | `createNullsFirstNameComparator` | ⭐⭐ | Comparator.nullsFirst() |
| 6 | `createNullsLastPriceComparator` | ⭐⭐ | Comparator.nullsLast() |
| 7 | `createNameThenAgeComparator` | ⭐⭐ | thenComparing() chaining |
| 8 | `createDepartmentSalaryNameComparator` | ⭐⭐ | Three-level chaining |
| 9 | `createCaseInsensitiveTitleComparator` | ⭐⭐ | String.CASE_INSENSITIVE_ORDER |
| 10 | `createReverseAlphabeticalComparator` | ⭐ | Comparator.reverseOrder() |
| 11 | `createCustomProductComparator` | ⭐⭐⭐ | Custom comparison logic |
| 12 | `createAuthorYearComparatorMethodRef` | ⭐⭐ | Method references |
| 13 | `sortProductsByPrice` | ⭐ | List.sort() with Comparator |
| 14 | `findHighestPaidPerson` | ⭐⭐ | Collections.max() with Comparator |
| 15 | `createPersonComparatorBuilder` | ⭐⭐⭐⭐ | Builder pattern for comparators |

### AdvancedSortingExercises (13 exercises)

| # | Method | Difficulty | Key Concepts |
|---|--------|-----------|-------------|
| 1 | `sortBySalaryUsingCollections` | ⭐ | Collections.sort() |
| 2 | `sortByRatingUsingArrays` | ⭐ | Arrays.sort() |
| 3 | `sortByYearUsingListSort` | ⭐ | List.sort() |
| 4 | `createEmployeeSetSortedByName` | ⭐⭐ | TreeSet with custom Comparator |
| 5 | `createPersonMapSortedByAge` | ⭐⭐ | TreeMap with custom Comparator |
| 6 | `createFourLevelEmployeeComparator` | ⭐⭐⭐ | Complex multi-level chaining |
| 7 | `sortProductsConditionally` | ⭐⭐⭐ | Conditional sorting logic |
| 8 | `sortByAgeAndVerifyStability` | ⭐⭐⭐ | Sort stability verification |
| 9 | `sortByValueDensity` | ⭐⭐⭐ | Sorting by derived values |
| 10 | `groupByDepartmentAndSortBySalary` | ⭐⭐⭐⭐ | Group-by then sort pattern |
| 11 | `createComparatorFactory` | ⭐⭐⭐⭐ | Generic Comparator factory |
| 12 | `sortWithEdgeCaseHandling` | ⭐⭐⭐⭐ | Comprehensive null handling |
| 13 | `sortByScoreOptimized` | ⭐⭐⭐ | Key extraction optimization |

**Total: 37 exercises** covering beginner to advanced sorting and comparison techniques.

---

## API Reference

### 📘 Comparable Interface

The `Comparable<T>` interface defines **natural ordering** for a class.

#### Methods

```java
int compareTo(T other)
```
- Compares this object with another
- Returns: negative if `this < other`, zero if equal, positive if `this > other`
- Must be consistent with `equals()` for proper set/map behavior

#### Implementing Comparable

```java
public class Person implements Comparable<Person> {
    private String name;
    private int age;

    @Override
    public int compareTo(Person other) {
        // Single field comparison
        return this.name.compareTo(other.name);

        // Multi-field comparison
        int nameCompare = this.name.compareTo(other.name);
        if (nameCompare != 0) return nameCompare;
        return Integer.compare(this.age, other.age);
    }
}
```

#### Safe Comparison Methods

```java
// For primitives
Integer.compare(int1, int2)      // Safe from overflow
Long.compare(long1, long2)
Double.compare(double1, double2)  // Handles NaN correctly

// For objects
obj1.compareTo(obj2)              // Throws NPE if obj1 is null
Objects.compare(obj1, obj2, comparator)  // Null-safe
```

#### Anti-Patterns ❌

```java
// DON'T: Subtraction can overflow
return this.age - other.age;  // ❌ Overflow risk

// DO: Use comparison methods
return Integer.compare(this.age, other.age);  // ✓
```

---

### 🔧 Comparator Interface

The `Comparator<T>` interface defines **external comparison** logic.

#### Creating Comparators

```java
// Lambda expression
Comparator<Person> byAge = (p1, p2) -> Integer.compare(p1.getAge(), p2.getAge());

// Method reference
Comparator<Person> byName = Comparator.comparing(Person::getName);

// Anonymous class
Comparator<Person> bySalary = new Comparator<Person>() {
    public int compare(Person p1, Person p2) {
        return Double.compare(p1.getSalary(), p2.getSalary());
    }
};
```

#### Static Factory Methods

```java
// Create comparator from key extractor
Comparator.comparing(Person::getName)
Comparator.comparingInt(Person::getAge)
Comparator.comparingLong(Person::getId)
Comparator.comparingDouble(Product::getPrice)

// Natural order comparators
Comparator.naturalOrder()         // For Comparable types
Comparator.reverseOrder()         // Reverse natural order

// Null handling
Comparator.nullsFirst(comparator)  // Nulls before non-nulls
Comparator.nullsLast(comparator)   // Nulls after non-nulls
```

#### Chaining Comparators

```java
// Primary, then secondary sort
Comparator<Person> nameAge = Comparator
    .comparing(Person::getName)
    .thenComparing(Person::getAge);

// With reversed order
Comparator<Employee> deptSalary = Comparator
    .comparing(Employee::getDepartment)
    .thenComparing(Employee::getSalary, Comparator.reverseOrder());

// Multiple levels
Comparator<Employee> complex = Comparator
    .comparing(Employee::getDepartment)
    .thenComparingDouble(Employee::getSalary).reversed()
    .thenComparing(Employee::getName)
    .thenComparingInt(Employee::getId);
```

#### Instance Methods

```java
comparator.reversed()                    // Reverse the order
comparator.thenComparing(other)          // Chain another comparator
comparator.thenComparing(keyExtractor)   // Chain with key extraction
comparator.thenComparingInt(intExtractor)
comparator.thenComparingLong(longExtractor)
comparator.thenComparingDouble(doubleExtractor)
```

---

### 🗂️ Collection Sorting Utilities

#### Lists

```java
List<Person> people = new ArrayList<>();

// Using natural order (Comparable)
Collections.sort(people);
people.sort(null);  // Java 8+

// Using custom Comparator
Collections.sort(people, Comparator.comparing(Person::getAge));
people.sort(Comparator.comparing(Person::getAge));  // Java 8+

// Reverse order
Collections.reverse(people);
```

#### Arrays

```java
Person[] people = new Person[10];

// Using natural order
Arrays.sort(people);

// Using custom Comparator
Arrays.sort(people, Comparator.comparing(Person::getName));

// Sorting a range
Arrays.sort(people, 0, 5, comparator);  // Sort first 5 elements
```

#### Finding Extremes

```java
// With Comparable
Person youngest = Collections.min(people);
Person oldest = Collections.max(people);

// With Comparator
Person richest = Collections.max(people, Comparator.comparing(Person::getSalary));

// Java 8+ streams
Optional<Person> youngest = people.stream()
    .min(Comparator.comparing(Person::getAge));
```

---

### 🌲 Sorted Collections

#### TreeSet

```java
// Natural ordering (requires Comparable)
Set<Person> people = new TreeSet<>();

// Custom ordering
Set<Person> byAge = new TreeSet<>(Comparator.comparing(Person::getAge));

// Methods
SortedSet<Person> headSet = byAge.headSet(limitPerson);  // Elements < limit
SortedSet<Person> tailSet = byAge.tailSet(limitPerson);  // Elements >= limit
Person first = byAge.first();
Person last = byAge.last();
```

#### TreeMap

```java
// Natural key ordering
Map<String, Person> map = new TreeMap<>();

// Custom key ordering
Map<Person, String> byAge = new TreeMap<>(Comparator.comparing(Person::getAge));

// Methods
SortedMap<Person, String> headMap = byAge.headMap(limitPerson);
SortedMap<Person, String> tailMap = byAge.tailMap(limitPerson);
Person firstKey = byAge.firstKey();
Person lastKey = byAge.lastKey();
```

---

### 📊 Comparable vs Comparator Comparison

| Aspect | Comparable | Comparator |
|--------|-----------|------------|
| **Location** | Inside the class being compared | External to the class |
| **Method** | `compareTo(T other)` | `compare(T o1, T o2)` |
| **Purpose** | Define **one** natural ordering | Define **multiple** custom orderings |
| **Modification** | Requires modifying the class | No class modification needed |
| **Collections** | `Collections.sort(list)` | `Collections.sort(list, comparator)` |
| **TreeSet** | `new TreeSet<>()` | `new TreeSet<>(comparator)` |
| **When to use** | One obvious ordering | Multiple sort criteria or can't modify class |

---

## Tips for Success

1. **Use safe comparison methods** - Always use `Integer.compare()`, `Double.compare()`, etc. instead of subtraction to avoid overflow
2. **Start with Comparable for natural ordering** - If there's one obvious way to sort objects, implement Comparable
3. **Use Comparator for flexibility** - When you need multiple sort orders or can't modify the class
4. **Leverage Comparator.comparing()** - More readable and less error-prone than manual comparison
5. **Chain with thenComparing()** - Build multi-level sorts by chaining comparators
6. **Handle nulls explicitly** - Use `nullsFirst()` or `nullsLast()` to avoid NullPointerException
7. **Be consistent with equals()** - For TreeSet/TreeMap to work correctly, `compareTo()` should be consistent with `equals()`
8. **Understand stability** - Java's sorting algorithms are stable (preserve relative order of equal elements)
9. **Consider performance** - TreeSet/TreeMap are O(log n) for operations, while sorting a list is O(n log n)
10. **Test edge cases** - Always test with empty collections, single elements, all equal elements, and nulls

---

## Common Patterns

### Pattern 1: Sort by multiple fields
```java
Comparator<Employee> comparator = Comparator
    .comparing(Employee::getDepartment)
    .thenComparing(Employee::getName);
```

### Pattern 2: Conditional sorting
```java
Comparator<Product> comparator = sortByPrice
    ? Comparator.comparing(Product::getPrice)
    : Comparator.comparing(Product::getRating);
```

### Pattern 3: Reverse specific field
```java
Comparator<Employee> comparator = Comparator
    .comparing(Employee::getDepartment)
    .thenComparing(Employee::getSalary, Comparator.reverseOrder());
```

### Pattern 4: Null-safe comparison
```java
Comparator<Person> comparator = Comparator
    .nullsLast(Comparator.comparing(Person::getName,
        Comparator.nullsLast(Comparator.naturalOrder())));
```

### Pattern 5: Sort by derived value
```java
Comparator<Book> comparator = Comparator.comparing(
    book -> (double) book.getPages() / (currentYear - book.getYear() + 1)
);
```

---

## Resources

- [Comparable Javadoc](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/Comparable.html)
- [Comparator Javadoc](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Comparator.html)
- [Collections Javadoc](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Collections.html)
- [Arrays Javadoc](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Arrays.html)
- [TreeSet Javadoc](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/TreeSet.html)
- [TreeMap Javadoc](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/TreeMap.html)

---

## Test Statistics

- **Total Exercises**: 37 (10 Comparable + 15 Comparator + 13 Advanced)
- **Total Test Cases**: ~120
- **Test Coverage**: 3-4 tests per exercise covering normal cases, edge cases, and null handling
- **Difficulty Range**: ⭐ (Beginner) to ⭐⭐⭐⭐ (Advanced)
