package com.juanpicasti.practice.sorting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Comparator Exercises Test Suite")
class ComparatorExercisesTest {

    private ComparatorExercises exercises;

    @BeforeEach
    void setUp() {
        exercises = new ComparatorExercises();
    }

    // ==================== EXERCISE 1: createAgeComparator ====================

    @Test
    @DisplayName("Ex1: Age comparator orders by age ascending")
    void testCreateAgeComparator_ordering() {
        Comparator<Person> comparator = exercises.createAgeComparator();
        Person younger = new Person("Alice", 25, 50000);
        Person older = new Person("Bob", 50, 60000);

        assertTrue(comparator.compare(younger, older) < 0, "Younger person should come first");
        assertTrue(comparator.compare(older, younger) > 0, "Older person should come last");
    }

    @Test
    @DisplayName("Ex1: Age comparator returns 0 for same age")
    void testCreateAgeComparator_equalAge() {
        Comparator<Person> comparator = exercises.createAgeComparator();
        Person person1 = new Person("Alice", 30, 50000);
        Person person2 = new Person("Bob", 30, 60000);

        assertEquals(0, comparator.compare(person1, person2), "Same age should return 0");
    }

    @Test
    @DisplayName("Ex1: Age comparator ignores name and salary")
    void testCreateAgeComparator_ignoresOtherFields() {
        Comparator<Person> comparator = exercises.createAgeComparator();
        Person p1 = new Person("Zoe", 25, 100000);
        Person p2 = new Person("Amy", 50, 30000);

        assertTrue(comparator.compare(p1, p2) < 0, "Should only compare by age");
    }

    // ==================== EXERCISE 2: createNameComparatorLambda ====================

    @Test
    @DisplayName("Ex2: Name comparator orders alphabetically")
    void testCreateNameComparatorLambda_ordering() {
        Comparator<Person> comparator = exercises.createNameComparatorLambda();
        Person alice = new Person("Alice", 30, 50000);
        Person bob = new Person("Bob", 25, 60000);

        assertTrue(comparator.compare(alice, bob) < 0, "Alice should come before Bob");
        assertTrue(comparator.compare(bob, alice) > 0, "Bob should come after Alice");
    }

    @Test
    @DisplayName("Ex2: Name comparator returns 0 for same name")
    void testCreateNameComparatorLambda_sameName() {
        Comparator<Person> comparator = exercises.createNameComparatorLambda();
        Person person1 = new Person("Alice", 30, 50000);
        Person person2 = new Person("Alice", 25, 60000);

        assertEquals(0, comparator.compare(person1, person2), "Same name should return 0");
    }

    @Test
    @DisplayName("Ex2: Name comparator is case-sensitive")
    void testCreateNameComparatorLambda_caseSensitive() {
        Comparator<Person> comparator = exercises.createNameComparatorLambda();
        Person lowercase = new Person("alice", 30, 50000);
        Person uppercase = new Person("Alice", 30, 50000);

        assertTrue(comparator.compare(uppercase, lowercase) < 0, "Should be case-sensitive");
    }

    // ==================== EXERCISE 3: createReversedAgeComparator ====================

    @Test
    @DisplayName("Ex3: Reversed age comparator orders descending")
    void testCreateReversedAgeComparator_descendingOrder() {
        Comparator<Person> comparator = exercises.createReversedAgeComparator();
        Person younger = new Person("Alice", 25, 50000);
        Person older = new Person("Bob", 50, 60000);

        assertTrue(comparator.compare(older, younger) < 0, "Older should come first (descending)");
        assertTrue(comparator.compare(younger, older) > 0, "Younger should come last (descending)");
    }

    @Test
    @DisplayName("Ex3: Reversed age comparator returns 0 for same age")
    void testCreateReversedAgeComparator_equalAge() {
        Comparator<Person> comparator = exercises.createReversedAgeComparator();
        Person person1 = new Person("Alice", 30, 50000);
        Person person2 = new Person("Bob", 30, 60000);

        assertEquals(0, comparator.compare(person1, person2), "Same age should return 0");
    }

    // ==================== EXERCISE 4: createPriceComparator ====================

    @Test
    @DisplayName("Ex4: Price comparator orders by price")
    void testCreatePriceComparator_ordering() {
        Comparator<Product> comparator = exercises.createPriceComparator();
        Product cheap = new Product("Widget", 10.0, 4.5);
        Product expensive = new Product("Gadget", 100.0, 4.0);

        assertTrue(comparator.compare(cheap, expensive) < 0, "Cheaper product should come first");
        assertTrue(comparator.compare(expensive, cheap) > 0, "Expensive product should come last");
    }

    @Test
    @DisplayName("Ex4: Price comparator returns 0 for same price")
    void testCreatePriceComparator_samePrice() {
        Comparator<Product> comparator = exercises.createPriceComparator();
        Product product1 = new Product("A", 50.0, 4.5);
        Product product2 = new Product("B", 50.0, 3.0);

        assertEquals(0, comparator.compare(product1, product2), "Same price should return 0");
    }

    @Test
    @DisplayName("Ex4: Price comparator handles floating-point")
    void testCreatePriceComparator_floatingPoint() {
        Comparator<Product> comparator = exercises.createPriceComparator();
        Product p1 = new Product("A", 10.001, 5.0);
        Product p2 = new Product("B", 10.002, 5.0);

        assertTrue(comparator.compare(p1, p2) < 0, "Should handle small price differences");
    }

    // ==================== EXERCISE 5: createNullsFirstNameComparator ====================

    @Test
    @DisplayName("Ex5: NullsFirst comparator puts null before non-null")
    void testCreateNullsFirstNameComparator_nullFirst() {
        Comparator<Person> comparator = exercises.createNullsFirstNameComparator();
        Person person = new Person("Alice", 30, 50000);

        assertTrue(comparator.compare(null, person) < 0, "Null should come before non-null");
        assertTrue(comparator.compare(person, null) > 0, "Non-null should come after null");
    }

    @Test
    @DisplayName("Ex5: NullsFirst comparator treats two nulls as equal")
    void testCreateNullsFirstNameComparator_bothNull() {
        Comparator<Person> comparator = exercises.createNullsFirstNameComparator();

        assertEquals(0, comparator.compare(null, null), "Two nulls should be equal");
    }

    @Test
    @DisplayName("Ex5: NullsFirst comparator compares non-nulls by name")
    void testCreateNullsFirstNameComparator_bothNonNull() {
        Comparator<Person> comparator = exercises.createNullsFirstNameComparator();
        Person alice = new Person("Alice", 30, 50000);
        Person bob = new Person("Bob", 25, 60000);

        assertTrue(comparator.compare(alice, bob) < 0, "Should compare by name when both non-null");
    }

    // ==================== EXERCISE 6: createNullsLastPriceComparator ====================

    @Test
    @DisplayName("Ex6: NullsLast comparator puts null after non-null")
    void testCreateNullsLastPriceComparator_nullLast() {
        Comparator<Product> comparator = exercises.createNullsLastPriceComparator();
        Product product = new Product("Widget", 50.0, 4.5);

        assertTrue(comparator.compare(product, null) < 0, "Non-null should come before null");
        assertTrue(comparator.compare(null, product) > 0, "Null should come after non-null");
    }

    @Test
    @DisplayName("Ex6: NullsLast comparator treats two nulls as equal")
    void testCreateNullsLastPriceComparator_bothNull() {
        Comparator<Product> comparator = exercises.createNullsLastPriceComparator();

        assertEquals(0, comparator.compare(null, null), "Two nulls should be equal");
    }

    @Test
    @DisplayName("Ex6: NullsLast comparator compares non-nulls by price")
    void testCreateNullsLastPriceComparator_bothNonNull() {
        Comparator<Product> comparator = exercises.createNullsLastPriceComparator();
        Product cheap = new Product("A", 10.0, 5.0);
        Product expensive = new Product("B", 100.0, 3.0);

        assertTrue(comparator.compare(cheap, expensive) < 0, "Should compare by price when both non-null");
    }

    // ==================== EXERCISE 7: createNameThenAgeComparator ====================

    @Test
    @DisplayName("Ex7: NameThenAge comparator orders by name first")
    void testCreateNameThenAgeComparator_nameFirst() {
        Comparator<Person> comparator = exercises.createNameThenAgeComparator();
        Person alice = new Person("Alice", 50, 50000);
        Person bob = new Person("Bob", 25, 60000);

        assertTrue(comparator.compare(alice, bob) < 0, "Should order by name first");
    }

    @Test
    @DisplayName("Ex7: NameThenAge comparator orders by age when names equal")
    void testCreateNameThenAgeComparator_ageSecondary() {
        Comparator<Person> comparator = exercises.createNameThenAgeComparator();
        Person younger = new Person("Alice", 25, 50000);
        Person older = new Person("Alice", 50, 60000);

        assertTrue(comparator.compare(younger, older) < 0, "Should order by age when names equal");
    }

    @Test
    @DisplayName("Ex7: NameThenAge comparator returns 0 for identical name and age")
    void testCreateNameThenAgeComparator_identical() {
        Comparator<Person> comparator = exercises.createNameThenAgeComparator();
        Person person1 = new Person("Alice", 30, 50000);
        Person person2 = new Person("Alice", 30, 100000);

        assertEquals(0, comparator.compare(person1, person2), "Same name and age should return 0");
    }

    // ==================== EXERCISE 8: createDepartmentSalaryNameComparator ====================

    @Test
    @DisplayName("Ex8: Three-level comparator orders by department first")
    void testCreateDepartmentSalaryNameComparator_departmentFirst() {
        Comparator<Employee> comparator = exercises.createDepartmentSalaryNameComparator();
        Employee engr = new Employee(1, "Alice", "Engineering", 100000);
        Employee sales = new Employee(2, "Bob", "Sales", 50000);

        assertTrue(comparator.compare(engr, sales) < 0, "Engineering should come before Sales");
    }

    @Test
    @DisplayName("Ex8: Three-level comparator orders by salary descending when departments equal")
    void testCreateDepartmentSalaryNameComparator_salarySecondary() {
        Comparator<Employee> comparator = exercises.createDepartmentSalaryNameComparator();
        Employee higherPaid = new Employee(1, "Alice", "Engineering", 120000);
        Employee lowerPaid = new Employee(2, "Bob", "Engineering", 80000);

        assertTrue(comparator.compare(higherPaid, lowerPaid) < 0, "Higher salary should come first (descending)");
    }

    @Test
    @DisplayName("Ex8: Three-level comparator orders by name when department and salary equal")
    void testCreateDepartmentSalaryNameComparator_nameTertiary() {
        Comparator<Employee> comparator = exercises.createDepartmentSalaryNameComparator();
        Employee alice = new Employee(1, "Alice", "Engineering", 100000);
        Employee bob = new Employee(2, "Bob", "Engineering", 100000);

        assertTrue(comparator.compare(alice, bob) < 0, "Should order by name when dept and salary equal");
    }

    @Test
    @DisplayName("Ex8: Three-level comparator handles all equal fields")
    void testCreateDepartmentSalaryNameComparator_allEqual() {
        Comparator<Employee> comparator = exercises.createDepartmentSalaryNameComparator();
        Employee emp1 = new Employee(1, "Alice", "Engineering", 100000);
        Employee emp2 = new Employee(2, "Alice", "Engineering", 100000);

        assertEquals(0, comparator.compare(emp1, emp2), "All comparison fields equal should return 0");
    }

    // ==================== EXERCISE 9: createCaseInsensitiveTitleComparator ====================

    @Test
    @DisplayName("Ex9: Case-insensitive comparator ignores case")
    void testCreateCaseInsensitiveTitleComparator_ignoresCase() {
        Comparator<Book> comparator = exercises.createCaseInsensitiveTitleComparator();
        Book book1 = new Book("apple", "Author", 2000, 300);
        Book book2 = new Book("BANANA", "Author", 2000, 300);

        assertTrue(comparator.compare(book1, book2) < 0, "Should compare case-insensitively");
    }

    @Test
    @DisplayName("Ex9: Case-insensitive comparator treats same title with different case as equal")
    void testCreateCaseInsensitiveTitleComparator_sameIgnoringCase() {
        Comparator<Book> comparator = exercises.createCaseInsensitiveTitleComparator();
        Book book1 = new Book("Java", "Author", 2000, 300);
        Book book2 = new Book("JAVA", "Author", 2001, 400);

        assertEquals(0, comparator.compare(book1, book2), "Same title with different case should return 0");
    }

    @Test
    @DisplayName("Ex9: Case-insensitive comparator orders correctly")
    void testCreateCaseInsensitiveTitleComparator_ordering() {
        Comparator<Book> comparator = exercises.createCaseInsensitiveTitleComparator();
        Book book1 = new Book("zebra", "Author", 2000, 300);
        Book book2 = new Book("Apple", "Author", 2000, 300);

        assertTrue(comparator.compare(book2, book1) < 0, "Apple should come before zebra (case-insensitive)");
    }

    // ==================== EXERCISE 10: createReverseAlphabeticalComparator ====================

    @Test
    @DisplayName("Ex10: Reverse alphabetical comparator orders Z before A")
    void testCreateReverseAlphabeticalComparator_reverseOrder() {
        Comparator<String> comparator = exercises.createReverseAlphabeticalComparator();

        assertTrue(comparator.compare("zebra", "apple") < 0, "Z should come before A in reverse");
        assertTrue(comparator.compare("apple", "zebra") > 0, "A should come after Z in reverse");
    }

    @Test
    @DisplayName("Ex10: Reverse alphabetical comparator returns 0 for equal strings")
    void testCreateReverseAlphabeticalComparator_equal() {
        Comparator<String> comparator = exercises.createReverseAlphabeticalComparator();

        assertEquals(0, comparator.compare("apple", "apple"), "Equal strings should return 0");
    }

    // ==================== EXERCISE 11: createCustomProductComparator ====================

    @Test
    @DisplayName("Ex11: Custom comparator puts high-rated products first")
    void testCreateCustomProductComparator_ratingGroups() {
        Comparator<Product> comparator = exercises.createCustomProductComparator();
        Product highRated = new Product("A", 100.0, 4.5);
        Product lowRated = new Product("B", 10.0, 3.0);

        assertTrue(comparator.compare(highRated, lowRated) < 0, "High-rated (>=4.0) should come before low-rated");
    }

    @Test
    @DisplayName("Ex11: Custom comparator orders by price within rating groups")
    void testCreateCustomProductComparator_priceWithinGroup() {
        Comparator<Product> comparator = exercises.createCustomProductComparator();
        Product cheaper = new Product("A", 50.0, 4.5);
        Product expensive = new Product("B", 100.0, 4.2);

        assertTrue(comparator.compare(cheaper, expensive) < 0, "Within same rating group, cheaper comes first");
    }

    @Test
    @DisplayName("Ex11: Custom comparator orders by name when rating and price equal")
    void testCreateCustomProductComparator_nameWhenEqual() {
        Comparator<Product> comparator = exercises.createCustomProductComparator();
        Product productA = new Product("Alpha", 50.0, 4.5);
        Product productB = new Product("Beta", 50.0, 4.5);

        assertTrue(comparator.compare(productA, productB) < 0, "Should order by name when rating and price equal");
    }

    @Test
    @DisplayName("Ex11: Custom comparator handles boundary rating 4.0")
    void testCreateCustomProductComparator_boundaryRating() {
        Comparator<Product> comparator = exercises.createCustomProductComparator();
        Product exactly4 = new Product("A", 50.0, 4.0);
        Product justBelow4 = new Product("B", 50.0, 3.99);

        assertTrue(comparator.compare(exactly4, justBelow4) < 0, "Rating exactly 4.0 should be high-rated");
    }

    // ==================== EXERCISE 12: createAuthorYearComparatorMethodRef ====================

    @Test
    @DisplayName("Ex12: Author-year comparator orders by author first")
    void testCreateAuthorYearComparatorMethodRef_authorFirst() {
        Comparator<Book> comparator = exercises.createAuthorYearComparatorMethodRef();
        Book book1 = new Book("Book1", "AuthorA", 2020, 300);
        Book book2 = new Book("Book2", "AuthorB", 2010, 400);

        assertTrue(comparator.compare(book1, book2) < 0, "Should order by author first");
    }

    @Test
    @DisplayName("Ex12: Author-year comparator orders by year when authors equal")
    void testCreateAuthorYearComparatorMethodRef_yearSecondary() {
        Comparator<Book> comparator = exercises.createAuthorYearComparatorMethodRef();
        Book older = new Book("Book1", "Author", 1990, 300);
        Book newer = new Book("Book2", "Author", 2020, 400);

        assertTrue(comparator.compare(older, newer) < 0, "Should order by year when authors equal");
    }

    @Test
    @DisplayName("Ex12: Author-year comparator returns 0 for same author and year")
    void testCreateAuthorYearComparatorMethodRef_equal() {
        Comparator<Book> comparator = exercises.createAuthorYearComparatorMethodRef();
        Book book1 = new Book("Different Title 1", "Author", 2000, 300);
        Book book2 = new Book("Different Title 2", "Author", 2000, 400);

        assertEquals(0, comparator.compare(book1, book2), "Same author and year should return 0");
    }

    // ==================== EXERCISE 13: sortProductsByPrice ====================

    @Test
    @DisplayName("Ex13: Sort products by price in-place")
    void testSortProductsByPrice_sorting() {
        List<Product> products = new ArrayList<>(Arrays.asList(
            new Product("C", 30.0, 4.0),
            new Product("A", 10.0, 5.0),
            new Product("B", 20.0, 3.0)
        ));

        exercises.sortProductsByPrice(products);

        assertEquals(10.0, products.get(0).getPrice(), "First should have price 10.0");
        assertEquals(20.0, products.get(1).getPrice(), "Second should have price 20.0");
        assertEquals(30.0, products.get(2).getPrice(), "Third should have price 30.0");
    }

    @Test
    @DisplayName("Ex13: Sort handles already sorted list")
    void testSortProductsByPrice_alreadySorted() {
        List<Product> products = new ArrayList<>(Arrays.asList(
            new Product("A", 10.0, 5.0),
            new Product("B", 20.0, 3.0)
        ));

        exercises.sortProductsByPrice(products);

        assertEquals(10.0, products.get(0).getPrice(), "Order should remain unchanged");
    }

    @Test
    @DisplayName("Ex13: Sort throws exception for null list")
    void testSortProductsByPrice_nullList() {
        assertThrows(IllegalArgumentException.class,
            () -> exercises.sortProductsByPrice(null),
            "Should throw IllegalArgumentException for null list");
    }

    // ==================== EXERCISE 14: findHighestPaidPerson ====================

    @Test
    @DisplayName("Ex14: Find highest paid person")
    void testFindHighestPaidPerson_findsMax() {
        List<Person> people = Arrays.asList(
            new Person("Alice", 30, 50000),
            new Person("Bob", 25, 80000),
            new Person("Charlie", 35, 60000)
        );

        Person highest = exercises.findHighestPaidPerson(people);

        assertNotNull(highest, "Should find a person");
        assertEquals("Bob", highest.getName(), "Bob has the highest salary");
        assertEquals(80000, highest.getSalary(), "Highest salary is 80000");
    }

    @Test
    @DisplayName("Ex14: Returns null for empty list")
    void testFindHighestPaidPerson_emptyList() {
        List<Person> people = new ArrayList<>();

        Person highest = exercises.findHighestPaidPerson(people);

        assertNull(highest, "Should return null for empty list");
    }

    @Test
    @DisplayName("Ex14: Returns null for null list")
    void testFindHighestPaidPerson_nullList() {
        Person highest = exercises.findHighestPaidPerson(null);

        assertNull(highest, "Should return null for null list");
    }

    @Test
    @DisplayName("Ex14: Handles single person")
    void testFindHighestPaidPerson_singlePerson() {
        List<Person> people = Arrays.asList(new Person("Alice", 30, 50000));

        Person highest = exercises.findHighestPaidPerson(people);

        assertNotNull(highest, "Should find the single person");
        assertEquals("Alice", highest.getName(), "Should return the only person");
    }

    // ==================== EXERCISE 15: createPersonComparatorBuilder ====================

    @Test
    @DisplayName("Ex15: Builder creates name comparator")
    void testCreatePersonComparatorBuilder_byName() {
        ComparatorExercises.PersonComparatorBuilder builder = exercises.createPersonComparatorBuilder();
        Comparator<Person> comparator = builder.byName().ascending().build();

        Person alice = new Person("Alice", 30, 50000);
        Person bob = new Person("Bob", 25, 60000);

        assertTrue(comparator.compare(alice, bob) < 0, "Should order by name ascending");
    }

    @Test
    @DisplayName("Ex15: Builder creates age comparator descending")
    void testCreatePersonComparatorBuilder_byAgeDescending() {
        ComparatorExercises.PersonComparatorBuilder builder = exercises.createPersonComparatorBuilder();
        Comparator<Person> comparator = builder.byAge().descending().build();

        Person younger = new Person("Alice", 25, 50000);
        Person older = new Person("Bob", 50, 60000);

        assertTrue(comparator.compare(older, younger) < 0, "Should order by age descending");
    }

    @Test
    @DisplayName("Ex15: Builder chains name then age")
    void testCreatePersonComparatorBuilder_nameThenAge() {
        ComparatorExercises.PersonComparatorBuilder builder = exercises.createPersonComparatorBuilder();
        Comparator<Person> comparator = builder.byName().ascending().thenByAge().ascending().build();

        Person younger = new Person("Alice", 25, 50000);
        Person older = new Person("Alice", 50, 60000);

        assertTrue(comparator.compare(younger, older) < 0, "Should order by name, then age");
    }

    @Test
    @DisplayName("Ex15: Builder creates complex three-level comparator")
    void testCreatePersonComparatorBuilder_complex() {
        ComparatorExercises.PersonComparatorBuilder builder = exercises.createPersonComparatorBuilder();
        Comparator<Person> comparator = builder
            .byName().ascending()
            .thenBySalary().descending()
            .thenByAge().ascending()
            .build();

        Person p1 = new Person("Alice", 25, 80000);
        Person p2 = new Person("Alice", 30, 80000);
        Person p3 = new Person("Alice", 30, 60000);

        assertTrue(comparator.compare(p1, p2) < 0, "Higher salary should come first when names equal");
        assertTrue(comparator.compare(p1, p3) < 0, "Higher salary should come first");
        assertTrue(comparator.compare(p3, p2) > 0, "When name and salary equal, younger age first");
    }
}
