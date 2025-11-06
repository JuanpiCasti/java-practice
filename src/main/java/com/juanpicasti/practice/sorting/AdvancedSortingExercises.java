package com.juanpicasti.practice.sorting;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Advanced Sorting Exercises
 *
 * This class contains 12 progressive exercises to practice advanced sorting techniques in Java.
 * Focus: Collection sorting utilities, TreeSet/TreeMap, complex chaining, and real-world scenarios.
 *
 * Difficulty progression: Intermediate → Advanced
 */
public class AdvancedSortingExercises {

    // ==================== SORTING UTILITIES ====================

    /**
     * Exercise 1: Sort list using Collections.sort()
     * Difficulty: ⭐
     *
     * Key concepts:
     * - Collections.sort() method
     * - In-place sorting
     * - Custom Comparator
     *
     * Sort the given list of Person objects by salary (ascending) using Collections.sort().
     * The list should be sorted in-place.
     *
     * @param people the list of people to sort
     * @throws IllegalArgumentException if people is null
     */
    public void sortBySalaryUsingCollections(List<Person> people) {
        if (people == null) {
            throw new IllegalArgumentException();
        }
        people.sort(Comparator.comparing(Person::getSalary));
    }

    /**
     * Exercise 2: Sort array using Arrays.sort()
     * Difficulty: ⭐
     *
     * Key concepts:
     * - Arrays.sort() method
     * - Array sorting
     * - Comparator for arrays
     *
     * Sort the given array of Product objects by rating (descending) using Arrays.sort().
     * The array should be sorted in-place.
     *
     * @param products the array of products to sort
     * @throws IllegalArgumentException if products is null
     */
    public void sortByRatingUsingArrays(Product[] products) {
        if (products == null) {
            throw new IllegalArgumentException();
        }
        Arrays.sort(products, Comparator.comparing(Product::getRating).reversed());
    }

    /**
     * Exercise 3: Sort using List.sort()
     * Difficulty: ⭐
     *
     * Key concepts:
     * - List.sort() method (Java 8+)
     * - Instance method vs static method
     * - Comparator.comparing()
     *
     * Sort the given list of Book objects by year (ascending) using the List.sort() method.
     * The list should be sorted in-place.
     *
     * @param books the list of books to sort
     * @throws IllegalArgumentException if books is null
     */
    public void sortByYearUsingListSort(List<Book> books) {
        if (books == null) {
            throw new IllegalArgumentException();
        }
        books.sort(Comparator.comparingInt(Book::getYear));
    }

    // ==================== TREESET AND TREEMAP ====================

    /**
     * Exercise 4: Create TreeSet with custom Comparator
     * Difficulty: ⭐⭐
     *
     * Key concepts:
     * - TreeSet constructor with Comparator
     * - Automatic sorting
     * - SortedSet interface
     *
     * Create and return a TreeSet containing the given Employee objects,
     * sorted by name (alphabetically). Add all employees to the set.
     *
     * @param employees the array of employees
     * @return a TreeSet sorted by employee name
     * @throws IllegalArgumentException if employees is null
     */
    public Set<Employee> createEmployeeSetSortedByName(Employee[] employees) {
        if (employees == null) {
            throw new IllegalArgumentException();
        }
        Set<Employee> ts = new TreeSet<>(Comparator.comparing(Employee::getName));
        ts.addAll(Arrays.asList(employees));
        return ts;
    }

    /**
     * Exercise 5: Create TreeMap with custom Comparator
     * Difficulty: ⭐⭐
     *
     * Key concepts:
     * - TreeMap constructor with Comparator
     * - Sorted map keys
     * - Key-based sorting
     *
     * Create and return a TreeMap that maps Person objects (keys) to their department strings (values),
     * with keys sorted by age (ascending). Add all person-department pairs to the map.
     *
     * @param personDeptMap the original map to convert
     * @return a TreeMap with Person keys sorted by age
     * @throws IllegalArgumentException if personDeptMap is null
     */
    public Map<Person, String> createPersonMapSortedByAge(Map<Person, String> personDeptMap) {
        if (personDeptMap == null) {
            throw new IllegalArgumentException();
        }
        Map<Person, String> tm = new TreeMap<>(Comparator.comparing(Person::getAge));
        tm.putAll(personDeptMap);
        return tm;
    }

    // ==================== COMPLEX CHAINING ====================

    /**
     * Exercise 6: Chain four or more comparators
     * Difficulty: ⭐⭐⭐
     *
     * Key concepts:
     * - Multiple thenComparing() calls
     * - Complex multi-level sorting
     * - Mixing ascending and descending orders
     *
     * Create and return a Comparator for Employee objects with the following criteria:
     * 1. Department (alphabetically)
     * 2. Salary (descending)
     * 3. Name (alphabetically)
     * 4. ID (ascending)
     *
     * @return a Comparator with four-level comparison
     */
    public Comparator<Employee> createFourLevelEmployeeComparator() {
        return Comparator.comparing(Employee::getDepartment)
                .thenComparing(Employee::getSalary, Comparator.reverseOrder())
                .thenComparing(Employee::getName)
                .thenComparing(Employee::getId);
    }

    /**
     * Exercise 7: Sort with conditional criteria
     * Difficulty: ⭐⭐⭐
     *
     * Key concepts:
     * - Dynamic comparator logic
     * - Conditional sorting
     * - Custom comparison rules
     *
     * Sort the given list of Product objects based on a flag:
     * - If sortByPrice is true: sort by price (ascending), then rating (descending)
     * - If sortByPrice is false: sort by rating (descending), then price (ascending)
     *
     * @param products the list of products to sort
     * @param sortByPrice the flag to determine primary sort field
     * @throws IllegalArgumentException if products is null
     */
    public void sortProductsConditionally(List<Product> products, boolean sortByPrice) {
        if (products == null) throw new IllegalArgumentException();
        var comparator = sortByPrice ?
                Comparator.comparing(Product::getPrice).thenComparing(Product::getRating, Comparator.reverseOrder()) :
                Comparator.comparing(Product::getRating, Comparator.reverseOrder()).thenComparing(Product::getPrice);
        products.sort(comparator);
    }

    // ==================== STABILITY AND DERIVED VALUES ====================

    /**
     * Exercise 8: Verify stable sort
     * Difficulty: ⭐⭐⭐
     *
     * Key concepts:
     * - Sort stability
     * - Preserving relative order
     * - Stable sorting algorithms
     *
     * Sort the given list of Person objects by age only. Return true if the sort
     * was stable (preserved the relative order of people with equal ages).
     * To verify stability, the method must check if people with the same age
     * maintain their original relative order.
     *
     * Note: Collections.sort() and List.sort() are stable.
     *
     * @param people the list of people to sort (will be modified)
     * @return always true (Java's sort is stable)
     * @throws IllegalArgumentException if people is null
     */
    public boolean sortByAgeAndVerifyStability(List<Person> people) {
        if (people == null) throw new IllegalArgumentException();
        // TODO: Implement validation
        people.sort(Comparator.comparing(Person::getAge));
        return true;
    }

    /**
     * Exercise 9: Sort by derived/calculated values
     * Difficulty: ⭐⭐⭐
     *
     * Key concepts:
     * - Sorting by computed properties
     * - Comparator with calculations
     * - Key extraction functions
     *
     * Sort the given list of Book objects by "value density": pages per year since publication.
     * Calculate as: pages / (currentYear - year + 1)
     * Higher value density should come first (descending).
     *
     * @param books the list of books to sort
     * @param currentYear the current year for calculation
     * @throws IllegalArgumentException if books is null
     */
    public void sortByValueDensity(List<Book> books, int currentYear) {
        if (books == null) {
            throw new IllegalArgumentException();
        }
        books.sort((b1, b2) -> {
            int yearsSinceB1 = currentYear - b1.getYear();
            int yearsSinceB2 = currentYear - b2.getYear();
            return Double.compare((double) b2.getPages() /yearsSinceB2, (double) b1.getPages() /yearsSinceB1);
        });
    }

    /**
     * Exercise 10: Multi-level group sorting
     * Difficulty: ⭐⭐⭐⭐
     *
     * Key concepts:
     * - Group-by then sort within groups
     * - Stream grouping
     * - Complex data organization
     *
     * Group the given employees by department, then within each department sort by salary (descending).
     * Return a Map where keys are department names and values are lists of employees
     * sorted by salary within that department.
     *
     * @param employees the list of employees
     * @return a map of department -> sorted list of employees
     * @throws IllegalArgumentException if employees is null
     */
    public Map<String, List<Employee>> groupByDepartmentAndSortBySalary(List<Employee> employees) {
        if (employees == null) throw new IllegalArgumentException();
        Map<String, List<Employee>> groups = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment));
        groups.values().forEach(g -> {
            g.sort(Comparator.comparing(Employee::getSalary, Comparator.reverseOrder()));
        });
        return groups;
    }

    // ==================== REUSABLE PATTERNS ====================

    /**
     * Exercise 11: Create reusable Comparator factory
     * Difficulty: ⭐⭐⭐⭐
     *
     * Key concepts:
     * - Generic Comparator factory
     * - Reusable sorting utilities
     * - Type-safe key extraction
     *
     * Create a ComparatorFactory class that provides static methods to create comparators
     * for any type T based on a key extraction function. Support:
     * - ascending(keyExtractor): creates ascending comparator
     * - descending(keyExtractor): creates descending comparator
     * - nullSafeAscending(keyExtractor): creates null-safe ascending comparator
     *
     * Example:
     *   ComparatorFactory.ascending(Person::getName)
     *   ComparatorFactory.descending(Product::getPrice)
     *
     * @return a new ComparatorFactory instance (or null if using static methods)
     */
    public ComparatorFactory createComparatorFactory() {
        return new ComparatorFactory();
    }

    /**
     * Exercise 12: Handle complex edge cases
     * Difficulty: ⭐⭐⭐⭐
     *
     * Key concepts:
     * - Edge case handling
     * - Null safety
     * - Empty collection handling
     *
     * Sort the given list of Person objects with comprehensive edge case handling:
     * - Handle null list (throw IllegalArgumentException)
     * - Handle empty list (no-op)
     * - Handle null elements (nulls last)
     * - Handle null names within Person objects (nulls last)
     * - Sort by name (ascending) for non-null names
     *
     * @param people the list of people to sort (may contain nulls)
     * @throws IllegalArgumentException if people list itself is null
     */
    public void sortWithEdgeCaseHandling(List<Person> people) {
        if (people == null) throw new IllegalArgumentException();
        people.sort(Comparator.nullsLast((p1, p2) -> Objects.compare(p1.getName(), p2.getName(), Comparator.nullsLast(Comparator.naturalOrder()))));

    }

    // ==================== PERFORMANCE OPTIMIZATION ====================

    /**
     * Exercise 13: Optimize sorting with extracted keys
     * Difficulty: ⭐⭐⭐
     *
     * Key concepts:
     * - Key extraction optimization
     * - Avoiding repeated computations
     * - Schwartzian transform
     *
     * Sort the given list of Product objects by a calculated "score": price * rating.
     * Optimize to avoid recalculating the score multiple times during sorting.
     * Lower scores should come first (ascending).
     *
     * @param products the list of products to sort
     * @throws IllegalArgumentException if products is null
     */
    public void sortByScoreOptimized(List<Product> products) {
        if (products == null) throw new IllegalArgumentException();
        products.sort(Comparator.comparingDouble(p -> p.getPrice() * p.getRating()));
    }

    // ==================== HELPER CLASSES ====================

    /**
     * ComparatorFactory for Exercise 11.
     * Provides reusable static methods for creating comparators.
     */
    public static class ComparatorFactory {
        // TODO: Implement factory methods

        /**
         * Creates an ascending comparator based on the given key extractor.
         *
         * @param keyExtractor function to extract the comparable key
         * @param <T> the type of objects to compare
         * @param <U> the type of the comparable key
         * @return an ascending comparator
         */
        public static <T, U extends Comparable<? super U>> Comparator<T> ascending(Function<T, U> keyExtractor) {
            return Comparator.comparing(keyExtractor);
        }

        /**
         * Creates a descending comparator based on the given key extractor.
         *
         * @param keyExtractor function to extract the comparable key
         * @param <T> the type of objects to compare
         * @param <U> the type of the comparable key
         * @return a descending comparator
         */
        public static <T, U extends Comparable<? super U>> Comparator<T> descending(Function<T, U> keyExtractor) {
            return Comparator.comparing(keyExtractor, Comparator.reverseOrder());
        }

        /**
         * Creates a null-safe ascending comparator (nulls last).
         *
         * @param keyExtractor function to extract the comparable key
         * @param <T> the type of objects to compare
         * @param <U> the type of the comparable key
         * @return a null-safe ascending comparator
         */
        public static <T, U extends Comparable<? super U>> Comparator<T> nullSafeAscending(Function<T, U> keyExtractor) {
            return Comparator.nullsLast(Comparator.comparing(keyExtractor));
        }
    }
}
