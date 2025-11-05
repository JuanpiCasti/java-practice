package com.juanpicasti.practice.sorting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Comparable Exercises Test Suite")
class ComparableExercisesTest {

    private ComparableExercises exercises;

    @BeforeEach
    void setUp() {
        exercises = new ComparableExercises();
    }

    // ==================== EXERCISE 1: createComparableString ====================

    @Test
    @DisplayName("Ex1: ComparableString orders alphabetically")
    void testCreateComparableString_alphabeticalOrder() {
        ComparableExercises.ComparableString str1 = exercises.createComparableString("apple");
        ComparableExercises.ComparableString str2 = exercises.createComparableString("banana");

        assertTrue(str1.compareTo(str2) < 0, "apple should come before banana");
        assertTrue(str2.compareTo(str1) > 0, "banana should come after apple");
    }

    @Test
    @DisplayName("Ex1: ComparableString equal strings return 0")
    void testCreateComparableString_equalStrings() {
        ComparableExercises.ComparableString str1 = exercises.createComparableString("apple");
        ComparableExercises.ComparableString str2 = exercises.createComparableString("apple");

        assertEquals(0, str1.compareTo(str2), "Equal strings should return 0");
    }

    @Test
    @DisplayName("Ex1: ComparableString handles empty strings")
    void testCreateComparableString_emptyString() {
        ComparableExercises.ComparableString empty = exercises.createComparableString("");
        ComparableExercises.ComparableString nonEmpty = exercises.createComparableString("a");

        assertTrue(empty.compareTo(nonEmpty) < 0, "Empty string should come before non-empty");
    }

    @Test
    @DisplayName("Ex1: ComparableString is case-sensitive")
    void testCreateComparableString_caseSensitive() {
        ComparableExercises.ComparableString lower = exercises.createComparableString("apple");
        ComparableExercises.ComparableString upper = exercises.createComparableString("Apple");

        assertTrue(upper.compareTo(lower) < 0, "Uppercase letters should come before lowercase");
    }

    // ==================== EXERCISE 2: createComparablePersonByName ====================

    @Test
    @DisplayName("Ex2: ComparablePerson orders by name")
    void testCreateComparablePersonByName_ordering() {
        ComparableExercises.ComparablePerson alice = exercises.createComparablePersonByName("Alice", 30, 50000);
        ComparableExercises.ComparablePerson bob = exercises.createComparablePersonByName("Bob", 25, 60000);

        assertTrue(alice.compareTo(bob) < 0, "Alice should come before Bob");
        assertTrue(bob.compareTo(alice) > 0, "Bob should come after Alice");
    }

    @Test
    @DisplayName("Ex2: ComparablePerson with same name returns 0")
    void testCreateComparablePersonByName_sameName() {
        ComparableExercises.ComparablePerson person1 = exercises.createComparablePersonByName("Alice", 30, 50000);
        ComparableExercises.ComparablePerson person2 = exercises.createComparablePersonByName("Alice", 25, 60000);

        assertEquals(0, person1.compareTo(person2), "Same name should return 0 regardless of other fields");
    }

    @Test
    @DisplayName("Ex2: ComparablePerson ignores age and salary")
    void testCreateComparablePersonByName_ignoresOtherFields() {
        ComparableExercises.ComparablePerson younger = exercises.createComparablePersonByName("Zoe", 20, 30000);
        ComparableExercises.ComparablePerson older = exercises.createComparablePersonByName("Amy", 50, 100000);

        assertTrue(older.compareTo(younger) < 0, "Amy should come before Zoe regardless of age/salary");
    }

    // ==================== EXERCISE 3: createComparablePersonByNameThenAge ====================

    @Test
    @DisplayName("Ex3: ComparablePerson2 orders by name first")
    void testCreateComparablePersonByNameThenAge_nameFirst() {
        ComparableExercises.ComparablePerson2 alice = exercises.createComparablePersonByNameThenAge("Alice", 30, 50000);
        ComparableExercises.ComparablePerson2 bob = exercises.createComparablePersonByNameThenAge("Bob", 25, 60000);

        assertTrue(alice.compareTo(bob) < 0, "Alice should come before Bob");
    }

    @Test
    @DisplayName("Ex3: ComparablePerson2 orders by age when names equal")
    void testCreateComparablePersonByNameThenAge_ageSecondary() {
        ComparableExercises.ComparablePerson2 younger = exercises.createComparablePersonByNameThenAge("Alice", 25, 50000);
        ComparableExercises.ComparablePerson2 older = exercises.createComparablePersonByNameThenAge("Alice", 30, 60000);

        assertTrue(younger.compareTo(older) < 0, "When names are equal, should order by age");
        assertTrue(older.compareTo(younger) > 0, "Older age should come after younger age");
    }

    @Test
    @DisplayName("Ex3: ComparablePerson2 returns 0 for identical name and age")
    void testCreateComparablePersonByNameThenAge_identical() {
        ComparableExercises.ComparablePerson2 person1 = exercises.createComparablePersonByNameThenAge("Alice", 30, 50000);
        ComparableExercises.ComparablePerson2 person2 = exercises.createComparablePersonByNameThenAge("Alice", 30, 70000);

        assertEquals(0, person1.compareTo(person2), "Same name and age should return 0");
    }

    @Test
    @DisplayName("Ex3: ComparablePerson2 ignores salary")
    void testCreateComparablePersonByNameThenAge_ignoresSalary() {
        ComparableExercises.ComparablePerson2 lowSalary = exercises.createComparablePersonByNameThenAge("Alice", 30, 30000);
        ComparableExercises.ComparablePerson2 highSalary = exercises.createComparablePersonByNameThenAge("Alice", 30, 100000);

        assertEquals(0, lowSalary.compareTo(highSalary), "Salary should not affect comparison");
    }

    // ==================== EXERCISE 4: createComparableProductByPrice ====================

    @Test
    @DisplayName("Ex4: ComparableProduct orders by price")
    void testCreateComparableProductByPrice_ordering() {
        ComparableExercises.ComparableProduct cheap = exercises.createComparableProductByPrice("Widget", 10.0, 4.5);
        ComparableExercises.ComparableProduct expensive = exercises.createComparableProductByPrice("Gadget", 100.0, 4.0);

        assertTrue(cheap.compareTo(expensive) < 0, "Cheaper product should come first");
        assertTrue(expensive.compareTo(cheap) > 0, "Expensive product should come last");
    }

    @Test
    @DisplayName("Ex4: ComparableProduct with same price returns 0")
    void testCreateComparableProductByPrice_samePrice() {
        ComparableExercises.ComparableProduct product1 = exercises.createComparableProductByPrice("Widget", 50.0, 4.5);
        ComparableExercises.ComparableProduct product2 = exercises.createComparableProductByPrice("Gadget", 50.0, 3.0);

        assertEquals(0, product1.compareTo(product2), "Same price should return 0");
    }

    @Test
    @DisplayName("Ex4: ComparableProduct handles floating-point precision")
    void testCreateComparableProductByPrice_floatingPoint() {
        ComparableExercises.ComparableProduct product1 = exercises.createComparableProductByPrice("A", 10.001, 5.0);
        ComparableExercises.ComparableProduct product2 = exercises.createComparableProductByPrice("B", 10.002, 5.0);

        assertTrue(product1.compareTo(product2) < 0, "Should handle small price differences");
    }

    @Test
    @DisplayName("Ex4: ComparableProduct ignores rating")
    void testCreateComparableProductByPrice_ignoresRating() {
        ComparableExercises.ComparableProduct lowRating = exercises.createComparableProductByPrice("Widget", 50.0, 2.0);
        ComparableExercises.ComparableProduct highRating = exercises.createComparableProductByPrice("Gadget", 50.0, 5.0);

        assertEquals(0, lowRating.compareTo(highRating), "Rating should not affect comparison");
    }

    // ==================== EXERCISE 5: createNullableComparableString ====================

    @Test
    @DisplayName("Ex5: NullableComparableString both null returns 0")
    void testCreateNullableComparableString_bothNull() {
        ComparableExercises.NullableComparableString str1 = exercises.createNullableComparableString(null);
        ComparableExercises.NullableComparableString str2 = exercises.createNullableComparableString(null);

        assertEquals(0, str1.compareTo(str2), "Two nulls should be equal");
    }

    @Test
    @DisplayName("Ex5: NullableComparableString null comes before non-null")
    void testCreateNullableComparableString_nullFirst() {
        ComparableExercises.NullableComparableString nullStr = exercises.createNullableComparableString(null);
        ComparableExercises.NullableComparableString nonNull = exercises.createNullableComparableString("value");

        assertTrue(nullStr.compareTo(nonNull) < 0, "Null should come before non-null");
        assertTrue(nonNull.compareTo(nullStr) > 0, "Non-null should come after null");
    }

    @Test
    @DisplayName("Ex5: NullableComparableString both non-null orders alphabetically")
    void testCreateNullableComparableString_bothNonNull() {
        ComparableExercises.NullableComparableString apple = exercises.createNullableComparableString("apple");
        ComparableExercises.NullableComparableString banana = exercises.createNullableComparableString("banana");

        assertTrue(apple.compareTo(banana) < 0, "Should order non-null values alphabetically");
    }

    @Test
    @DisplayName("Ex5: NullableComparableString equal non-null strings")
    void testCreateNullableComparableString_equalNonNull() {
        ComparableExercises.NullableComparableString str1 = exercises.createNullableComparableString("apple");
        ComparableExercises.NullableComparableString str2 = exercises.createNullableComparableString("apple");

        assertEquals(0, str1.compareTo(str2), "Equal non-null strings should return 0");
    }

    // ==================== EXERCISE 6: createComparableBookByYear ====================

    @Test
    @DisplayName("Ex6: ComparableBook orders by year")
    void testCreateComparableBookByYear_ordering() {
        ComparableExercises.ComparableBook older = exercises.createComparableBookByYear("Old Book", "Author A", 1990, 300);
        ComparableExercises.ComparableBook newer = exercises.createComparableBookByYear("New Book", "Author B", 2020, 400);

        assertTrue(older.compareTo(newer) < 0, "Older book should come first");
        assertTrue(newer.compareTo(older) > 0, "Newer book should come last");
    }

    @Test
    @DisplayName("Ex6: ComparableBook with same year returns 0")
    void testCreateComparableBookByYear_sameYear() {
        ComparableExercises.ComparableBook book1 = exercises.createComparableBookByYear("Book A", "Author A", 2000, 300);
        ComparableExercises.ComparableBook book2 = exercises.createComparableBookByYear("Book B", "Author B", 2000, 400);

        assertEquals(0, book1.compareTo(book2), "Same year should return 0");
    }

    @Test
    @DisplayName("Ex6: ComparableBook ignores title, author, pages")
    void testCreateComparableBookByYear_ignoresOtherFields() {
        ComparableExercises.ComparableBook book1 = exercises.createComparableBookByYear("ZZZZ", "ZZZZ", 1990, 1000);
        ComparableExercises.ComparableBook book2 = exercises.createComparableBookByYear("AAAA", "AAAA", 2000, 100);

        assertTrue(book1.compareTo(book2) < 0, "Should only compare by year");
    }

    // ==================== EXERCISE 7: sortComparablePersons ====================

    @Test
    @DisplayName("Ex7: Sort list of ComparablePerson objects")
    void testSortComparablePersons_sorting() {
        ComparableExercises.ComparablePerson charlie = exercises.createComparablePersonByName("Charlie", 30, 50000);
        ComparableExercises.ComparablePerson alice = exercises.createComparablePersonByName("Alice", 25, 60000);
        ComparableExercises.ComparablePerson bob = exercises.createComparablePersonByName("Bob", 35, 70000);

        List<ComparableExercises.ComparablePerson> people = new ArrayList<>(Arrays.asList(charlie, alice, bob));
        exercises.sortComparablePersons(people);

        assertEquals("Alice", people.get(0).getName(), "First should be Alice");
        assertEquals("Bob", people.get(1).getName(), "Second should be Bob");
        assertEquals("Charlie", people.get(2).getName(), "Third should be Charlie");
    }

    @Test
    @DisplayName("Ex7: Sort handles already sorted list")
    void testSortComparablePersons_alreadySorted() {
        ComparableExercises.ComparablePerson alice = exercises.createComparablePersonByName("Alice", 25, 60000);
        ComparableExercises.ComparablePerson bob = exercises.createComparablePersonByName("Bob", 35, 70000);

        List<ComparableExercises.ComparablePerson> people = new ArrayList<>(Arrays.asList(alice, bob));
        exercises.sortComparablePersons(people);

        assertEquals("Alice", people.get(0).getName(), "Order should remain unchanged");
        assertEquals("Bob", people.get(1).getName(), "Order should remain unchanged");
    }

    @Test
    @DisplayName("Ex7: Sort handles single element")
    void testSortComparablePersons_singleElement() {
        ComparableExercises.ComparablePerson alice = exercises.createComparablePersonByName("Alice", 25, 60000);

        List<ComparableExercises.ComparablePerson> people = new ArrayList<>(Arrays.asList(alice));
        exercises.sortComparablePersons(people);

        assertEquals(1, people.size(), "Size should remain 1");
        assertEquals("Alice", people.get(0).getName(), "Element should be unchanged");
    }

    @Test
    @DisplayName("Ex7: Sort throws exception for null list")
    void testSortComparablePersons_nullList() {
        assertThrows(IllegalArgumentException.class,
            () -> exercises.sortComparablePersons(null),
            "Should throw IllegalArgumentException for null list");
    }

    // ==================== EXERCISE 8: createSortedProductSet ====================

    @Test
    @DisplayName("Ex8: TreeSet maintains sorted order by price")
    void testCreateSortedProductSet_sortedOrder() {
        ComparableExercises.ComparableProduct product1 = exercises.createComparableProductByPrice("C", 30.0, 4.0);
        ComparableExercises.ComparableProduct product2 = exercises.createComparableProductByPrice("A", 10.0, 5.0);
        ComparableExercises.ComparableProduct product3 = exercises.createComparableProductByPrice("B", 20.0, 3.0);

        ComparableExercises.ComparableProduct[] products = {product1, product2, product3};
        Set<ComparableExercises.ComparableProduct> sortedSet = exercises.createSortedProductSet(products);

        List<ComparableExercises.ComparableProduct> list = new ArrayList<>(sortedSet);
        assertEquals(10.0, list.get(0).getPrice(), "First should have price 10.0");
        assertEquals(20.0, list.get(1).getPrice(), "Second should have price 20.0");
        assertEquals(30.0, list.get(2).getPrice(), "Third should have price 30.0");
    }

    @Test
    @DisplayName("Ex8: TreeSet contains all products")
    void testCreateSortedProductSet_containsAll() {
        ComparableExercises.ComparableProduct product1 = exercises.createComparableProductByPrice("A", 10.0, 5.0);
        ComparableExercises.ComparableProduct product2 = exercises.createComparableProductByPrice("B", 20.0, 3.0);

        ComparableExercises.ComparableProduct[] products = {product1, product2};
        Set<ComparableExercises.ComparableProduct> sortedSet = exercises.createSortedProductSet(products);

        assertEquals(2, sortedSet.size(), "Set should contain 2 products");
        assertTrue(sortedSet.contains(product1), "Should contain product1");
        assertTrue(sortedSet.contains(product2), "Should contain product2");
    }

    @Test
    @DisplayName("Ex8: TreeSet removes duplicates based on natural ordering")
    void testCreateSortedProductSet_duplicates() {
        ComparableExercises.ComparableProduct product1 = exercises.createComparableProductByPrice("A", 10.0, 5.0);
        ComparableExercises.ComparableProduct product2 = exercises.createComparableProductByPrice("B", 10.0, 3.0);

        ComparableExercises.ComparableProduct[] products = {product1, product2};
        Set<ComparableExercises.ComparableProduct> sortedSet = exercises.createSortedProductSet(products);

        assertEquals(1, sortedSet.size(), "TreeSet should treat products with same price as duplicates");
    }

    @Test
    @DisplayName("Ex8: TreeSet throws exception for null array")
    void testCreateSortedProductSet_nullArray() {
        assertThrows(IllegalArgumentException.class,
            () -> exercises.createSortedProductSet(null),
            "Should throw IllegalArgumentException for null array");
    }

    // ==================== EXERCISE 9: createSafeComparableInteger ====================

    @Test
    @DisplayName("Ex9: ComparableInteger orders correctly")
    void testCreateSafeComparableInteger_normalOrdering() {
        ComparableExercises.ComparableInteger small = exercises.createSafeComparableInteger(10);
        ComparableExercises.ComparableInteger large = exercises.createSafeComparableInteger(100);

        assertTrue(small.compareTo(large) < 0, "10 should come before 100");
        assertTrue(large.compareTo(small) > 0, "100 should come after 10");
    }

    @Test
    @DisplayName("Ex9: ComparableInteger equal values return 0")
    void testCreateSafeComparableInteger_equal() {
        ComparableExercises.ComparableInteger int1 = exercises.createSafeComparableInteger(42);
        ComparableExercises.ComparableInteger int2 = exercises.createSafeComparableInteger(42);

        assertEquals(0, int1.compareTo(int2), "Equal values should return 0");
    }

    @Test
    @DisplayName("Ex9: ComparableInteger handles overflow safely")
    void testCreateSafeComparableInteger_overflowProtection() {
        ComparableExercises.ComparableInteger maxInt = exercises.createSafeComparableInteger(Integer.MAX_VALUE);
        ComparableExercises.ComparableInteger minInt = exercises.createSafeComparableInteger(Integer.MIN_VALUE);

        assertTrue(minInt.compareTo(maxInt) < 0, "MIN_VALUE should come before MAX_VALUE");
        assertTrue(maxInt.compareTo(minInt) > 0, "MAX_VALUE should come after MIN_VALUE");
    }

    @Test
    @DisplayName("Ex9: ComparableInteger handles negative numbers")
    void testCreateSafeComparableInteger_negativeNumbers() {
        ComparableExercises.ComparableInteger negative = exercises.createSafeComparableInteger(-50);
        ComparableExercises.ComparableInteger positive = exercises.createSafeComparableInteger(50);

        assertTrue(negative.compareTo(positive) < 0, "Negative should come before positive");
    }

    // ==================== EXERCISE 10: createReversePersonByAge ====================

    @Test
    @DisplayName("Ex10: ReversePerson orders by age descending")
    void testCreateReversePersonByAge_descendingOrder() {
        ComparableExercises.ReversePerson younger = exercises.createReversePersonByAge("Alice", 25);
        ComparableExercises.ReversePerson older = exercises.createReversePersonByAge("Bob", 50);

        assertTrue(older.compareTo(younger) < 0, "Older person should come first (descending)");
        assertTrue(younger.compareTo(older) > 0, "Younger person should come last (descending)");
    }

    @Test
    @DisplayName("Ex10: ReversePerson with same age returns 0")
    void testCreateReversePersonByAge_sameAge() {
        ComparableExercises.ReversePerson person1 = exercises.createReversePersonByAge("Alice", 30);
        ComparableExercises.ReversePerson person2 = exercises.createReversePersonByAge("Bob", 30);

        assertEquals(0, person1.compareTo(person2), "Same age should return 0");
    }

    @Test
    @DisplayName("Ex10: ReversePerson sorting order verification")
    void testCreateReversePersonByAge_sortingVerification() {
        ComparableExercises.ReversePerson p1 = exercises.createReversePersonByAge("A", 20);
        ComparableExercises.ReversePerson p2 = exercises.createReversePersonByAge("B", 30);
        ComparableExercises.ReversePerson p3 = exercises.createReversePersonByAge("C", 40);

        List<ComparableExercises.ReversePerson> people = new ArrayList<>(Arrays.asList(p1, p2, p3));
        people.sort(ComparableExercises.ReversePerson::compareTo);

        assertEquals(40, people.get(0).getAge(), "First should be age 40 (descending)");
        assertEquals(30, people.get(1).getAge(), "Second should be age 30");
        assertEquals(20, people.get(2).getAge(), "Third should be age 20");
    }

    @Test
    @DisplayName("Ex10: ReversePerson ignores name")
    void testCreateReversePersonByAge_ignoresName() {
        ComparableExercises.ReversePerson person1 = exercises.createReversePersonByAge("Zoe", 30);
        ComparableExercises.ReversePerson person2 = exercises.createReversePersonByAge("Amy", 30);

        assertEquals(0, person1.compareTo(person2), "Name should not affect comparison");
    }
}
