package com.juanpicasti.practice.sorting;

import java.util.List;
import java.util.Set;

/**
 * Comparable Exercises
 *
 * This class contains 10 progressive exercises to practice the Comparable interface in Java.
 * Focus: Understanding natural ordering, implementing compareTo(), and using Comparable objects in collections.
 *
 * Difficulty progression: Beginner → Intermediate → Advanced
 */
public class ComparableExercises {

    // ==================== IMPLEMENTING COMPARABLE ====================

    /**
     * Exercise 1: Create a ComparableString wrapper
     * Difficulty: ⭐
     *
     * Key concepts:
     * - Implementing Comparable<T> interface
     * - compareTo() method contract
     * - Natural ordering
     *
     * Create a wrapper class for String that implements Comparable<ComparableString>.
     * The natural ordering should be alphabetical (case-sensitive).
     *
     * @param value the string value to wrap
     * @return a new ComparableString instance
     */
    public ComparableString createComparableString(String value) {
        // TODO: Implement this method
        // Hint: Create an inner class ComparableString that implements Comparable
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Exercise 2: Create ComparablePerson by name
     * Difficulty: ⭐
     *
     * Key concepts:
     * - Implementing Comparable for custom classes
     * - String comparison
     * - Natural ordering definition
     *
     * Create a ComparablePerson class that implements Comparable<ComparablePerson>.
     * The natural ordering should be by name (alphabetically, case-sensitive).
     *
     * @param name the person's name
     * @param age the person's age
     * @param salary the person's salary
     * @return a new ComparablePerson instance
     */
    public ComparablePerson createComparablePersonByName(String name, int age, double salary) {
        // TODO: Implement this method
        // Hint: compareTo() should compare names using String's compareTo()
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Exercise 3: Create ComparablePerson with multiple fields
     * Difficulty: ⭐⭐
     *
     * Key concepts:
     * - Multi-field comparison
     * - Primary and secondary sort keys
     * - Consistent compareTo() implementation
     *
     * Create a ComparablePerson2 class that implements Comparable<ComparablePerson2>.
     * The natural ordering should be by name first, then by age if names are equal.
     *
     * @param name the person's name
     * @param age the person's age
     * @param salary the person's salary
     * @return a new ComparablePerson2 instance
     */
    public ComparablePerson2 createComparablePersonByNameThenAge(String name, int age, double salary) {
        // TODO: Implement this method
        // Hint: First compare names; if equal (== 0), then compare ages
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Exercise 4: Create ComparableProduct by price
     * Difficulty: ⭐
     *
     * Key concepts:
     * - Comparing primitive types
     * - Double.compare() for floating-point comparison
     * - Avoiding subtraction for comparison
     *
     * Create a ComparableProduct class that implements Comparable<ComparableProduct>.
     * The natural ordering should be by price (ascending).
     *
     * @param name the product name
     * @param price the product price
     * @param rating the product rating
     * @return a new ComparableProduct instance
     */
    public ComparableProduct createComparableProductByPrice(String name, double price, double rating) {
        // TODO: Implement this method
        // Hint: Use Double.compare(this.price, other.price) to safely compare doubles
        throw new UnsupportedOperationException("Not implemented yet");
    }

    // ==================== NULL HANDLING ====================

    /**
     * Exercise 5: Create ComparableString with null handling
     * Difficulty: ⭐⭐
     *
     * Key concepts:
     * - Null-safe comparison
     * - compareTo() with null values
     * - Ordering nulls (nulls first convention)
     *
     * Create a NullableComparableString class that implements Comparable<NullableComparableString>.
     * The string value can be null. Null values should be ordered before non-null values.
     * Non-null values are ordered alphabetically.
     *
     * @param value the string value (can be null)
     * @return a new NullableComparableString instance
     */
    public NullableComparableString createNullableComparableString(String value) {
        // TODO: Implement this method
        // Hint: Handle null cases first: if both null return 0, if this null return -1, if other null return 1
        throw new UnsupportedOperationException("Not implemented yet");
    }

    // ==================== USING COMPARABLE IN COLLECTIONS ====================

    /**
     * Exercise 6: Create ComparableBook by year
     * Difficulty: ⭐
     *
     * Key concepts:
     * - Implementing Comparable for domain objects
     * - Integer comparison
     * - Natural ordering by numeric field
     *
     * Create a ComparableBook class that implements Comparable<ComparableBook>.
     * The natural ordering should be by publication year (ascending).
     *
     * @param title the book title
     * @param author the book author
     * @param year the publication year
     * @param pages the number of pages
     * @return a new ComparableBook instance
     */
    public ComparableBook createComparableBookByYear(String title, String author, int year, int pages) {
        // TODO: Implement this method
        // Hint: Use Integer.compare(this.year, other.year) for safe integer comparison
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Exercise 7: Sort a list of Comparable objects
     * Difficulty: ⭐
     *
     * Key concepts:
     * - Collections.sort() with Comparable objects
     * - Natural ordering
     * - In-place sorting
     *
     * Sort the given list of ComparablePerson objects using their natural ordering.
     * The list should be sorted in-place (modify the original list).
     *
     * @param people the list of ComparablePerson objects to sort
     * @throws IllegalArgumentException if people is null
     */
    public void sortComparablePersons(List<ComparablePerson> people) {
        // TODO: Implement this method
        // Hint: Use Collections.sort() - it uses the natural ordering for Comparable objects
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Exercise 8: Create a TreeSet with Comparable objects
     * Difficulty: ⭐⭐
     *
     * Key concepts:
     * - TreeSet and natural ordering
     * - Sorted collections
     * - Automatic sorting on insertion
     *
     * Create and return a TreeSet containing the given ComparableProduct objects.
     * The TreeSet will automatically use the natural ordering (by price).
     *
     * @param products the array of ComparableProduct objects
     * @return a TreeSet containing the products, sorted by natural ordering
     * @throws IllegalArgumentException if products is null
     */
    public Set<ComparableProduct> createSortedProductSet(ComparableProduct[] products) {
        // TODO: Implement this method
        // Hint: Create a TreeSet and add all products; TreeSet maintains sorted order automatically
        throw new UnsupportedOperationException("Not implemented yet");
    }

    // ==================== ADVANCED COMPARABLE ====================

    /**
     * Exercise 9: Implement compareTo with overflow protection
     * Difficulty: ⭐⭐⭐
     *
     * Key concepts:
     * - Integer overflow in comparison
     * - Safe comparison techniques
     * - Integer.compare() vs subtraction
     *
     * Create a ComparableInteger class that implements Comparable<ComparableInteger>.
     * The comparison must be safe from integer overflow.
     * DO NOT use subtraction for comparison (i.e., avoid: this.value - other.value).
     *
     * @param value the integer value
     * @return a new ComparableInteger instance with overflow-safe comparison
     */
    public ComparableInteger createSafeComparableInteger(int value) {
        // TODO: Implement this method
        // Hint: Use Integer.compare() instead of subtraction to avoid overflow
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Exercise 10: Create Comparable with reverse natural ordering
     * Difficulty: ⭐⭐⭐
     *
     * Key concepts:
     * - Reverse ordering in compareTo()
     * - Inverting comparison results
     * - Descending vs ascending order
     *
     * Create a ReversePerson class that implements Comparable<ReversePerson>.
     * The natural ordering should be by age in DESCENDING order (highest age first).
     *
     * @param name the person's name
     * @param age the person's age
     * @return a new ReversePerson instance with reverse natural ordering
     */
    public ReversePerson createReversePersonByAge(String name, int age) {
        // TODO: Implement this method
        // Hint: Reverse the comparison by swapping the comparison order or negating the result
        throw new UnsupportedOperationException("Not implemented yet");
    }

    // ==================== INNER CLASSES (to be implemented in exercises) ====================

    /**
     * ComparableString wrapper class for Exercise 1.
     * Implements Comparable with natural alphabetical ordering.
     */
    public static class ComparableString implements Comparable<ComparableString> {
        private final String value;

        public ComparableString(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public int compareTo(ComparableString other) {
            // TODO: Implement natural ordering (alphabetical)
            throw new UnsupportedOperationException("Not implemented yet");
        }

        @Override
        public String toString() {
            return value;
        }
    }

    /**
     * ComparablePerson class for Exercise 2.
     * Natural ordering by name.
     */
    public static class ComparablePerson implements Comparable<ComparablePerson> {
        private final String name;
        private final int age;
        private final double salary;

        public ComparablePerson(String name, int age, double salary) {
            this.name = name;
            this.age = age;
            this.salary = salary;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public double getSalary() {
            return salary;
        }

        @Override
        public int compareTo(ComparablePerson other) {
            // TODO: Implement comparison by name
            throw new UnsupportedOperationException("Not implemented yet");
        }

        @Override
        public String toString() {
            return "ComparablePerson{name='" + name + "', age=" + age + ", salary=" + salary + "}";
        }
    }

    /**
     * ComparablePerson2 class for Exercise 3.
     * Natural ordering by name, then age.
     */
    public static class ComparablePerson2 implements Comparable<ComparablePerson2> {
        private final String name;
        private final int age;
        private final double salary;

        public ComparablePerson2(String name, int age, double salary) {
            this.name = name;
            this.age = age;
            this.salary = salary;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public double getSalary() {
            return salary;
        }

        @Override
        public int compareTo(ComparablePerson2 other) {
            // TODO: Implement comparison by name, then age
            throw new UnsupportedOperationException("Not implemented yet");
        }

        @Override
        public String toString() {
            return "ComparablePerson2{name='" + name + "', age=" + age + ", salary=" + salary + "}";
        }
    }

    /**
     * ComparableProduct class for Exercise 4.
     * Natural ordering by price.
     */
    public static class ComparableProduct implements Comparable<ComparableProduct> {
        private final String name;
        private final double price;
        private final double rating;

        public ComparableProduct(String name, double price, double rating) {
            this.name = name;
            this.price = price;
            this.rating = rating;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }

        public double getRating() {
            return rating;
        }

        @Override
        public int compareTo(ComparableProduct other) {
            // TODO: Implement comparison by price
            throw new UnsupportedOperationException("Not implemented yet");
        }

        @Override
        public String toString() {
            return "ComparableProduct{name='" + name + "', price=" + price + ", rating=" + rating + "}";
        }
    }

    /**
     * NullableComparableString class for Exercise 5.
     * Handles null values (nulls first).
     */
    public static class NullableComparableString implements Comparable<NullableComparableString> {
        private final String value;

        public NullableComparableString(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public int compareTo(NullableComparableString other) {
            // TODO: Implement null-safe comparison (nulls first)
            throw new UnsupportedOperationException("Not implemented yet");
        }

        @Override
        public String toString() {
            return value == null ? "null" : value;
        }
    }

    /**
     * ComparableBook class for Exercise 6.
     * Natural ordering by publication year.
     */
    public static class ComparableBook implements Comparable<ComparableBook> {
        private final String title;
        private final String author;
        private final int year;
        private final int pages;

        public ComparableBook(String title, String author, int year, int pages) {
            this.title = title;
            this.author = author;
            this.year = year;
            this.pages = pages;
        }

        public String getTitle() {
            return title;
        }

        public String getAuthor() {
            return author;
        }

        public int getYear() {
            return year;
        }

        public int getPages() {
            return pages;
        }

        @Override
        public int compareTo(ComparableBook other) {
            // TODO: Implement comparison by year
            throw new UnsupportedOperationException("Not implemented yet");
        }

        @Override
        public String toString() {
            return "ComparableBook{title='" + title + "', author='" + author + "', year=" + year + ", pages=" + pages + "}";
        }
    }

    /**
     * ComparableInteger class for Exercise 9.
     * Overflow-safe integer comparison.
     */
    public static class ComparableInteger implements Comparable<ComparableInteger> {
        private final int value;

        public ComparableInteger(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        @Override
        public int compareTo(ComparableInteger other) {
            // TODO: Implement overflow-safe comparison
            throw new UnsupportedOperationException("Not implemented yet");
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }

    /**
     * ReversePerson class for Exercise 10.
     * Natural ordering by age in DESCENDING order.
     */
    public static class ReversePerson implements Comparable<ReversePerson> {
        private final String name;
        private final int age;

        public ReversePerson(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        @Override
        public int compareTo(ReversePerson other) {
            // TODO: Implement reverse comparison by age (descending)
            throw new UnsupportedOperationException("Not implemented yet");
        }

        @Override
        public String toString() {
            return "ReversePerson{name='" + name + "', age=" + age + "}";
        }
    }
}
