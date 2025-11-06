package com.juanpicasti.practice.sorting;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Comparator Exercises
 *
 * This class contains 12 progressive exercises to practice the Comparator interface in Java.
 * Focus: Creating custom comparators, using lambda expressions, chaining comparators, and null handling.
 *
 * Difficulty progression: Beginner → Intermediate → Advanced
 */
public class ComparatorExercises {

    // ==================== BASIC COMPARATOR CREATION ====================

    /**
     * Exercise 1: Create a Comparator for Person by age
     * Difficulty: ⭐
     *
     * Key concepts:
     * - Comparator<T> interface
     * - compare() method
     * - External comparison
     *
     * Create and return a Comparator that orders Person objects by age (ascending).
     *
     * @return a Comparator that compares Person objects by age
     */
    public Comparator<Person> createAgeComparator() {
        return new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return Integer.compare(o1.getAge(), o2.getAge());
            }
        };
    }

    /**
     * Exercise 2: Create a Comparator using lambda expression
     * Difficulty: ⭐
     *
     * Key concepts:
     * - Lambda expressions
     * - Functional interface
     * - Concise comparator syntax
     *
     * Create and return a Comparator that orders Person objects by name (alphabetically)
     * using a lambda expression.
     *
     * @return a Comparator that compares Person objects by name
     */
    public Comparator<Person> createNameComparatorLambda() {
        return (p1, p2) -> p1.getName().compareTo(p2.getName());
    }

    /**
     * Exercise 3: Create a reversed Comparator
     * Difficulty: ⭐⭐
     *
     * Key concepts:
     * - Comparator.reversed()
     * - Descending order
     * - Comparator chaining
     *
     * Create and return a Comparator that orders Person objects by age in descending order.
     * Use the reversed() method.
     *
     * @return a Comparator that compares Person objects by age (descending)
     */
    public Comparator<Person> createReversedAgeComparator() {
        return new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return Integer.compare(o1.getAge(), o2.getAge());
            }
        }.reversed();
    }

    /**
     * Exercise 4: Use Comparator.comparing()
     * Difficulty: ⭐
     *
     * Key concepts:
     * - Comparator.comparing() static method
     * - Key extractor function
     * - Method reference
     *
     * Create and return a Comparator that orders Product objects by price using
     * Comparator.comparing().
     *
     * @return a Comparator that compares Product objects by price
     */
    public Comparator<Product> createPriceComparator() {
        return Comparator.comparingDouble(Product::getPrice);
    }

    // ==================== NULL HANDLING ====================

    /**
     * Exercise 5: Create null-safe Comparator
     * Difficulty: ⭐⭐
     *
     * Key concepts:
     * - Comparator.nullsFirst()
     * - Comparator.nullsLast()
     * - Null handling in comparisons
     *
     * Create and return a Comparator that orders Person objects by name,
     * with null Person objects appearing first (before all non-null objects).
     * If both objects are non-null, compare by name.
     *
     * @return a null-safe Comparator that puts nulls first
     */
    public Comparator<Person> createNullsFirstNameComparator() {
        return Comparator.nullsFirst(Comparator.comparing(Person::getName));
    }

    /**
     * Exercise 6: Create Comparator with nullsLast
     * Difficulty: ⭐⭐
     *
     * Key concepts:
     * - Comparator.nullsLast()
     * - Null ordering preference
     * - Combining null handling with field comparison
     *
     * Create and return a Comparator that orders Product objects by price,
     * with null Product objects appearing last (after all non-null objects).
     * If both objects are non-null, compare by price.
     *
     * @return a null-safe Comparator that puts nulls last
     */
    public Comparator<Product> createNullsLastPriceComparator() {
        return Comparator.nullsLast(Comparator.comparing(Product::getPrice));
    }

    // ==================== COMPARATOR CHAINING ====================

    /**
     * Exercise 7: Compare by multiple fields using thenComparing
     * Difficulty: ⭐⭐
     *
     * Key concepts:
     * - Comparator.thenComparing()
     * - Multi-level sorting
     * - Primary and secondary sort keys
     *
     * Create and return a Comparator that orders Person objects first by name,
     * then by age (if names are equal).
     *
     * @return a Comparator that compares by name, then age
     */
    public Comparator<Person> createNameThenAgeComparator() {
        return Comparator.comparing(Person::getName).thenComparing(Person::getAge);
    }

    /**
     * Exercise 8: Chain three comparators
     * Difficulty: ⭐⭐
     *
     * Key concepts:
     * - Multiple thenComparing() calls
     * - Three-level sorting
     * - Comparator composition
     *
     * Create and return a Comparator that orders Employee objects first by department,
     * then by salary (descending), then by name.
     *
     * @return a Comparator that compares by department, salary (desc), then name
     */
    public Comparator<Employee> createDepartmentSalaryNameComparator() {
        return Comparator
                .comparing(Employee::getDepartment)
                .thenComparing(Comparator.comparingDouble(Employee::getSalary).reversed())
                .thenComparing(Employee::getName);
    }

    // ==================== SPECIAL COMPARATORS ====================

    /**
     * Exercise 9: Create case-insensitive String Comparator
     * Difficulty: ⭐⭐
     *
     * Key concepts:
     * - String.CASE_INSENSITIVE_ORDER
     * - Case-insensitive comparison
     * - Comparator.comparing() with key extractor
     *
     * Create and return a Comparator that orders Book objects by title,
     * ignoring case differences (case-insensitive).
     *
     * @return a case-insensitive title Comparator for Book objects
     */
    public Comparator<Book> createCaseInsensitiveTitleComparator() {
        return Comparator.comparing(Book::getTitle, String.CASE_INSENSITIVE_ORDER);
    }

    /**
     * Exercise 10: Use Comparator.naturalOrder() and reverseOrder()
     * Difficulty: ⭐
     *
     * Key concepts:
     * - Comparator.naturalOrder()
     * - Comparator.reverseOrder()
     * - Natural ordering for Comparable types
     *
     * Create and return a Comparator for String objects that uses reverse natural ordering
     * (reverse alphabetical order).
     *
     * @return a Comparator for reverse alphabetical String ordering
     */
    public Comparator<String> createReverseAlphabeticalComparator() {
        return Comparator.reverseOrder();
    }

    // ==================== ADVANCED COMPARATORS ====================

    /**
     * Exercise 11: Create Comparator with custom logic
     * Difficulty: ⭐⭐⭐
     *
     * Key concepts:
     * - Custom comparison logic
     * - Multi-field comparison
     * - Business rules in comparators
     *
     * Create and return a Comparator for Product objects with the following logic:
     * 1. Products with rating >= 4.0 come before products with rating < 4.0
     * 2. Within each rating group, sort by price (ascending)
     * 3. If both rating group and price are equal, sort by name
     *
     * @return a Comparator with custom product sorting logic
     */
    public Comparator<Product> createCustomProductComparator() {
        return new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                if (o1.getRating() >= 4.0 && o2.getRating() < 4.0) return -1;
                else if (o2.getRating() >= 4.0 && o1.getRating() < 4.0) return 1;

                int comparingPrice = Double.compare(o1.getPrice(), o2.getPrice());
                if (comparingPrice != 0) return comparingPrice;

                return o1.getName().compareTo(o2.getName());
            }
        };
    }

    /**
     * Exercise 12: Create Comparator using method references
     * Difficulty: ⭐⭐
     *
     * Key concepts:
     * - Method references (Class::method)
     * - Comparator.comparing() with method reference
     * - Code readability
     *
     * Create and return a Comparator that orders Book objects first by author,
     * then by year, using method references (not lambda expressions).
     *
     * @return a Comparator that compares by author, then year
     */
    public Comparator<Book> createAuthorYearComparatorMethodRef() {
        return Comparator.comparing(Book::getAuthor).thenComparing(Book::getYear);
    }

    // ==================== PRACTICAL APPLICATIONS ====================

    /**
     * Exercise 13: Sort a list using custom Comparator
     * Difficulty: ⭐
     *
     * Key concepts:
     * - List.sort() method
     * - Using Comparator with collections
     * - In-place sorting
     *
     * Sort the given list of Product objects by price using a Comparator.
     * The list should be sorted in-place.
     *
     * @param products the list of products to sort
     * @throws IllegalArgumentException if products is null
     */
    public void sortProductsByPrice(List<Product> products) {
        if (products == null) {
            throw new IllegalArgumentException();
        }
        products.sort(Comparator.comparing(Product::getPrice));
    }

    /**
     * Exercise 14: Find min/max using Comparator
     * Difficulty: ⭐⭐
     *
     * Key concepts:
     * - Collections.min() and max() with Comparator
     * - Custom comparison for extremes
     * - Optional usage
     *
     * Find and return the Person with the highest salary from the given list.
     * Return null if the list is null or empty.
     *
     * @param people the list of people
     * @return the person with the highest salary, or null if list is null/empty
     */
    public Person findHighestPaidPerson(List<Person> people) {
        if (people == null || people.isEmpty()) return null;
        return Collections.max(people, Comparator.comparing(Person::getSalary));
    }

    /**
     * Exercise 15: Create a ComparatorBuilder pattern
     * Difficulty: ⭐⭐⭐⭐
     *
     * Key concepts:
     * - Builder pattern
     * - Flexible comparator construction
     * - Multiple comparison criteria
     *
     * Implement a PersonComparatorBuilder class that allows building complex
     * Person comparators with fluent API. Support:
     * - byName(), byAge(), bySalary() methods
     * - ascending() and descending() modifiers
     * - build() method to create the final Comparator
     *
     * Example usage:
     *   new PersonComparatorBuilder()
     *       .byName().ascending()
     *       .thenByAge().descending()
     *       .build()
     *
     * @return a new PersonComparatorBuilder instance
     */
    public PersonComparatorBuilder createPersonComparatorBuilder() {
        return new PersonComparatorBuilder();
    }

    // ==================== HELPER CLASSES ====================

    /**
     * PersonComparatorBuilder for Exercise 15.
     * Implements a fluent API for building complex Person comparators.
     */
    public static class PersonComparatorBuilder {
        Comparator<Person> comparator;

        Comparator<Person> lastComparator;

        public PersonComparatorBuilder byName() {
            this.lastComparator = Comparator.comparing(Person::getName);
            return this;
        }

        public PersonComparatorBuilder byAge() {
            this.lastComparator = Comparator.comparing(Person::getAge);
            return this;
        }

        public PersonComparatorBuilder bySalary() {
            this.lastComparator = Comparator.comparing(Person::getSalary);
            return this;
        }

        public PersonComparatorBuilder ascending() {
            if (this.comparator != null) {
                this.comparator = this.comparator.thenComparing(lastComparator);
            } else {
                this.comparator = lastComparator;
            }
            return this;
        }

        public PersonComparatorBuilder descending() {
            if (this.comparator != null) {
                this.comparator = this.comparator.thenComparing(lastComparator.reversed());
            } else {
                this.comparator = lastComparator.reversed();
            }
            return this;
        }

        public PersonComparatorBuilder thenByName() {
            this.lastComparator = Comparator.comparing(Person::getName);
            return this;
        }

        public PersonComparatorBuilder thenByAge() {
            this.lastComparator = Comparator.comparing(Person::getAge);
            return this;
        }

        public PersonComparatorBuilder thenBySalary() {
            this.lastComparator = Comparator.comparing(Person::getSalary);
            return this;
        }

        public Comparator<Person> build() {
            return this.comparator;
        }
    }
}
