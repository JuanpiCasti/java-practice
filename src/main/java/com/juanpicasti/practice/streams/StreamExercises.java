package com.juanpicasti.practice.streams;

import java.util.*;
import java.util.stream.*;

/**
 * Stream API Exercises
 *
 * This class contains 33 progressive exercises to practice Java Stream API.
 * Focus: Core operations, Collectors, method references, and real-world patterns
 *
 * Difficulty progression: Basic → Intermediate → Advanced
 */
public class StreamExercises {

    // ==================== HELPER CLASSES ====================

    /**
     * Person class for practicing stream operations
     */
    public static class Person {
        private String name;
        private int age;
        private String city;

        public Person(String name, int age, String city) {
            this.name = name;
            this.age = age;
            this.city = city;
        }

        public String getName() { return name; }
        public int getAge() { return age; }
        public String getCity() { return city; }

        @Override
        public String toString() {
            return "Person{name='" + name + "', age=" + age + ", city='" + city + "'}";
        }
    }

    /**
     * Product class for real-world scenarios
     */
    public static class Product {
        private int id;
        private String name;
        private double price;
        private String category;

        public Product(int id, String name, double price, String category) {
            this.id = id;
            this.name = name;
            this.price = price;
            this.category = category;
        }

        public int getId() { return id; }
        public String getName() { return name; }
        public double getPrice() { return price; }
        public String getCategory() { return category; }

        @Override
        public String toString() {
            return "Product{id=" + id + ", name='" + name + "', price=" + price + ", category='" + category + "'}";
        }
    }

    // ==================== BASIC LEVEL (Exercises 1-10) ====================

    /**
     * Exercise 1: Create stream and count elements
     *
     * Key concepts:
     * - Stream creation from collection
     * - count() terminal operation
     *
     * @param list the list to count
     * @return the number of elements in the stream, or 0 if list is null
     */
    public long countElements(List<String> list) {
        // TODO: Implement this method
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Exercise 2: Filter elements greater than threshold
     *
     * Key concepts:
     * - filter() intermediate operation
     * - Predicate lambda
     *
     * @param numbers list of integers
     * @param threshold minimum value (exclusive)
     * @return list of numbers greater than threshold, or empty list if input is null
     */
    public List<Integer> filterGreaterThan(List<Integer> numbers, int threshold) {
        // TODO: Implement this method
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Exercise 3: Transform strings to uppercase
     *
     * Key concepts:
     * - map() transformation
     * - Function lambda
     *
     * @param strings list of strings
     * @return list of uppercase strings, or empty list if input is null
     */
    public List<String> toUpperCase(List<String> strings) {
        // TODO: Implement this method
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Exercise 4: Collect to Set (unique elements)
     *
     * Key concepts:
     * - Collectors.toSet()
     * - Removing duplicates
     *
     * @param numbers list with potential duplicates
     * @return set of unique numbers, or empty set if input is null
     */
    public Set<Integer> collectToSet(List<Integer> numbers) {
        // TODO: Implement this method
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Exercise 5: Count elements matching condition
     *
     * Key concepts:
     * - filter().count() chain
     * - Combining operations
     *
     * @param strings list of strings
     * @param minLength minimum length (exclusive)
     * @return count of strings with length > minLength, or 0 if input is null
     */
    public long countLongStrings(List<String> strings, int minLength) {
        // TODO: Implement this method
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Exercise 6: Check if any element matches condition
     *
     * Key concepts:
     * - anyMatch() short-circuiting terminal operation
     *
     * @param numbers list of integers
     * @param target value to search for
     * @return true if any number equals target, false otherwise (or if list is null)
     */
    public boolean containsNumber(List<Integer> numbers, int target) {
        // TODO: Implement this method
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Exercise 7: Check if all elements match condition
     *
     * Key concepts:
     * - allMatch() terminal operation
     * - Universal quantification
     *
     * @param numbers list of integers
     * @param threshold minimum value (inclusive)
     * @return true if all numbers >= threshold, false otherwise (or if list is null)
     */
    public boolean allPositive(List<Integer> numbers, int threshold) {
        // TODO: Implement this method
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Exercise 8: Sum numbers using reduce
     *
     * Key concepts:
     * - reduce(identity, accumulator)
     * - Binary operator
     *
     * @param numbers list of integers
     * @return sum of all numbers, or 0 if list is null/empty
     */
    public int sumNumbers(List<Integer> numbers) {
        // TODO: Implement this method
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Exercise 9: Find first element matching condition
     *
     * Key concepts:
     * - findFirst() returns Optional
     * - Short-circuiting
     * - Optional handling
     *
     * @param strings list of strings
     * @param prefix the prefix to search for
     * @return Optional containing first string starting with prefix, or empty if none found
     */
    public Optional<String> findFirstStartingWith(List<String> strings, String prefix) {
        // TODO: Implement this method
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Exercise 10: Get distinct elements
     *
     * Key concepts:
     * - distinct() removes duplicates
     * - Maintains encounter order
     *
     * @param strings list with potential duplicates
     * @return list of distinct strings, or empty list if input is null
     */
    public List<String> getDistinct(List<String> strings) {
        // TODO: Implement this method
        throw new UnsupportedOperationException("Not implemented yet");
    }

    // ==================== INTERMEDIATE LEVEL (Exercises 11-22) ====================

    /**
     * Exercise 11: Use static method reference
     *
     * Key concepts:
     * - Method reference ClassName::staticMethod
     * - Cleaner than lambda
     *
     * @param strings list of number strings (e.g., "123", "456")
     * @return list of parsed integers, or empty list if input is null
     */
    public List<Integer> parseIntegers(List<String> strings) {
        // TODO: Implement this method using Integer::parseInt
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Exercise 12: Use instance method reference
     *
     * Key concepts:
     * - Method reference String::toLowerCase
     * - Instance method on stream elements
     *
     * @param strings list of strings
     * @return list of lowercase strings, or empty list if input is null
     */
    public List<String> toLowerCaseMethodRef(List<String> strings) {
        // TODO: Implement this method using String::toLowerCase method reference
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Exercise 13: Use constructor reference
     *
     * Key concepts:
     * - Constructor reference ClassName::new
     * - Creating objects from stream
     *
     * @param names list of names
     * @param defaultAge age to assign to all persons
     * @param defaultCity city to assign to all persons
     * @return list of Person objects, or empty list if names is null
     */
    public List<Person> createPersons(List<String> names, int defaultAge, String defaultCity) {
        // TODO: Implement this method
        // Hint: Use map with lambda that creates new Person(name, defaultAge, defaultCity)
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Exercise 14: FlatMap to flatten nested lists
     *
     * Key concepts:
     * - flatMap() flattens stream of streams
     * - Handling nested structures
     *
     * @param listOfLists nested list structure
     * @return flattened list, or empty list if input is null
     */
    public List<Integer> flattenLists(List<List<Integer>> listOfLists) {
        // TODO: Implement this method
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Exercise 15: Complex chain - filter, map, collect
     *
     * Key concepts:
     * - Chaining multiple operations
     * - filter → map → collect pipeline
     *
     * Get names of persons older than age threshold
     *
     * @param persons list of Person objects
     * @param minAge minimum age (exclusive)
     * @return list of names, or empty list if persons is null
     */
    public List<String> getNamesOfAdults(List<Person> persons, int minAge) {
        // TODO: Implement this method
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Exercise 16: Sort with Comparator
     *
     * Key concepts:
     * - sorted(Comparator)
     * - Custom sorting logic
     *
     * @param persons list of Person objects
     * @return list sorted by age (ascending), or empty list if input is null
     */
    public List<Person> sortByAge(List<Person> persons) {
        // TODO: Implement this method
        // Hint: Use Comparator.comparingInt(Person::getAge)
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Exercise 17: Use peek for debugging
     *
     * Key concepts:
     * - peek() for side effects
     * - Intermediate operation
     *
     * @param numbers list of integers
     * @param consumer action to perform on each element (e.g., print)
     * @return list of numbers doubled, or empty list if input is null
     */
    public List<Integer> doubleWithPeek(List<Integer> numbers, java.util.function.Consumer<Integer> consumer) {
        // TODO: Implement this method
        // Use peek(consumer) before map
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Exercise 18: Limit and skip (pagination)
     *
     * Key concepts:
     * - skip(n) skips first n elements
     * - limit(n) takes only n elements
     *
     * @param list list of strings
     * @param page page number (0-based)
     * @param pageSize number of elements per page
     * @return list of elements for the specified page, or empty list if input is null
     */
    public List<String> paginate(List<String> list, int page, int pageSize) {
        // TODO: Implement this method
        // Skip page * pageSize elements, then limit to pageSize
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Exercise 19: Group by property
     *
     * Key concepts:
     * - Collectors.groupingBy()
     * - Creating Map from stream
     *
     * @param persons list of Person objects
     * @return Map with city as key and list of persons from that city, or empty map if input is null
     */
    public Map<String, List<Person>> groupByCity(List<Person> persons) {
        // TODO: Implement this method
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Exercise 20: Partition by predicate
     *
     * Key concepts:
     * - Collectors.partitioningBy()
     * - Boolean-based grouping
     *
     * @param numbers list of integers
     * @param threshold dividing value
     * @return Map with true/false keys, values are lists of numbers >= threshold (true) or < threshold (false)
     */
    public Map<Boolean, List<Integer>> partitionByThreshold(List<Integer> numbers, int threshold) {
        // TODO: Implement this method
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Exercise 21: Join strings with delimiter
     *
     * Key concepts:
     * - Collectors.joining()
     * - String concatenation
     *
     * @param strings list of strings
     * @param delimiter separator between strings
     * @return joined string, or empty string if input is null
     */
    public String joinStrings(List<String> strings, String delimiter) {
        // TODO: Implement this method
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Exercise 22: Check if none match condition
     *
     * Key concepts:
     * - noneMatch() terminal operation
     * - Negation of anyMatch
     *
     * @param numbers list of integers
     * @return true if no number is negative, false otherwise (or if list is null)
     */
    public boolean noneNegative(List<Integer> numbers) {
        // TODO: Implement this method
        throw new UnsupportedOperationException("Not implemented yet");
    }

    // ==================== ADVANCED LEVEL (Exercises 23-33) ====================

    /**
     * Exercise 23: Convert to Map with custom key/value
     *
     * Key concepts:
     * - Collectors.toMap(keyMapper, valueMapper)
     * - Creating Map from objects
     *
     * @param persons list of Person objects
     * @return Map with name as key and age as value, or empty map if input is null
     */
    public Map<String, Integer> personNameToAge(List<Person> persons) {
        // TODO: Implement this method
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Exercise 24: Get summary statistics
     *
     * Key concepts:
     * - Collectors.summarizingInt()
     * - IntSummaryStatistics (count, sum, min, max, average)
     *
     * @param persons list of Person objects
     * @return IntSummaryStatistics for ages, or null if input is null
     */
    public IntSummaryStatistics getAgeStatistics(List<Person> persons) {
        // TODO: Implement this method
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Exercise 25: Custom reduce operation
     *
     * Key concepts:
     * - reduce() with complex accumulator
     * - Combining values
     *
     * Find the product of all numbers (multiplication)
     *
     * @param numbers list of integers
     * @return product of all numbers, or 1 if list is null/empty
     */
    public int productOfNumbers(List<Integer> numbers) {
        // TODO: Implement this method
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Exercise 26: Group by with downstream collector
     *
     * Key concepts:
     * - Collectors.groupingBy(classifier, downstream)
     * - Counting elements in each group
     *
     * @param persons list of Person objects
     * @return Map with city as key and count of persons from that city, or empty map if input is null
     */
    public Map<String, Long> countPersonsByCity(List<Person> persons) {
        // TODO: Implement this method
        // Hint: Use groupingBy(Person::getCity, counting())
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Exercise 27: Complex flatMap with transformation
     *
     * Key concepts:
     * - flatMap() with additional map
     * - Processing nested data
     *
     * Extract all characters from all strings as a list
     *
     * @param strings list of strings
     * @return list of all individual characters, or empty list if input is null
     */
    public List<Character> getAllCharacters(List<String> strings) {
        // TODO: Implement this method
        // Hint: flatMap each string to chars().mapToObj(c -> (char) c)
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Exercise 28: Optional integration
     *
     * Key concepts:
     * - Optional.map()
     * - Optional.orElse()
     * - Handling absence gracefully
     *
     * @param persons list of Person objects
     * @param name name to search for
     * @return age of person with given name, or -1 if not found or input is null
     */
    public int getAgeByName(List<Person> persons, String name) {
        // TODO: Implement this method
        // Find person by name, map to age, return -1 if not found
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Exercise 29: Reduce objects to single result
     *
     * Key concepts:
     * - reduce() with object properties
     * - Aggregation
     *
     * Calculate total price of all products
     *
     * @param products list of Product objects
     * @return sum of all product prices, or 0.0 if input is null
     */
    public double getTotalPrice(List<Product> products) {
        // TODO: Implement this method
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Exercise 30: Multi-level grouping
     *
     * Key concepts:
     * - Nested groupingBy
     * - Complex data structures
     *
     * Group products by category, then by price range (< 50, >= 50)
     *
     * @param products list of Product objects
     * @return nested Map: category → (price < 50 → list of products), or empty map if input is null
     */
    public Map<String, Map<Boolean, List<Product>>> groupByCategoryAndPrice(List<Product> products) {
        // TODO: Implement this method
        // Hint: groupingBy(Product::getCategory, partitioningBy(p -> p.getPrice() < 50))
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Exercise 31: Find max with custom comparator
     *
     * Key concepts:
     * - max(Comparator) terminal operation
     * - Optional result
     *
     * @param persons list of Person objects
     * @return Optional containing oldest person, or empty if list is null/empty
     */
    public Optional<Person> findOldestPerson(List<Person> persons) {
        // TODO: Implement this method
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Exercise 32: Average of property
     *
     * Key concepts:
     * - Collectors.averagingDouble()
     * - Statistical operations
     *
     * @param products list of Product objects
     * @return average price of products, or 0.0 if input is null/empty
     */
    public double getAveragePrice(List<Product> products) {
        // TODO: Implement this method
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Exercise 33: Real-world scenario - Complex pipeline
     *
     * Key concepts:
     * - Multi-step transformation
     * - Combining filter, map, sorted, collect
     *
     * Get names of products in a specific category, priced under threshold, sorted by price
     *
     * @param products list of Product objects
     * @param category category to filter by
     * @param maxPrice maximum price (exclusive)
     * @return list of product names sorted by price, or empty list if input is null
     */
    public List<String> getAffordableProductNames(List<Product> products, String category, double maxPrice) {
        // TODO: Implement this method
        // Filter by category and price, sort by price, map to name
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
