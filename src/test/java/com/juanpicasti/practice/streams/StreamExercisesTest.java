package com.juanpicasti.practice.streams;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Stream API Exercises Test Suite")
class StreamExercisesTest {

    private StreamExercises exercises;

    @BeforeEach
    void setUp() {
        exercises = new StreamExercises();
    }

    // ==================== EXERCISE 1: countElements ====================

    @Test
    @DisplayName("Ex1: Count elements in list")
    void testCount_normal() {
        List<String> list = Arrays.asList("A", "B", "C", "D");
        assertEquals(4, exercises.countElements(list));
    }

    @Test
    @DisplayName("Ex1: Count empty list")
    void testCount_empty() {
        assertEquals(0, exercises.countElements(new ArrayList<>()));
    }

    @Test
    @DisplayName("Ex1: Count null list")
    void testCount_null() {
        assertEquals(0, exercises.countElements(null));
    }

    // ==================== EXERCISE 2: filterGreaterThan ====================

    @Test
    @DisplayName("Ex2: Filter numbers greater than threshold")
    void testFilter_greaterThan() {
        List<Integer> numbers = Arrays.asList(1, 5, 10, 15, 20);
        List<Integer> result = exercises.filterGreaterThan(numbers, 10);

        assertEquals(Arrays.asList(15, 20), result);
    }

    @Test
    @DisplayName("Ex2: Filter with no matches")
    void testFilter_noMatches() {
        List<Integer> numbers = Arrays.asList(1, 2, 3);
        List<Integer> result = exercises.filterGreaterThan(numbers, 100);

        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("Ex2: Filter null list")
    void testFilter_null() {
        List<Integer> result = exercises.filterGreaterThan(null, 5);
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    // ==================== EXERCISE 3: toUpperCase ====================

    @Test
    @DisplayName("Ex3: Transform to uppercase")
    void testUpperCase_normal() {
        List<String> strings = Arrays.asList("hello", "world", "java");
        List<String> result = exercises.toUpperCase(strings);

        assertEquals(Arrays.asList("HELLO", "WORLD", "JAVA"), result);
    }

    @Test
    @DisplayName("Ex3: Transform empty list")
    void testUpperCase_empty() {
        assertTrue(exercises.toUpperCase(new ArrayList<>()).isEmpty());
    }

    @Test
    @DisplayName("Ex3: Transform null list")
    void testUpperCase_null() {
        List<String> result = exercises.toUpperCase(null);
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    // ==================== EXERCISE 4: collectToSet ====================

    @Test
    @DisplayName("Ex4: Collect to set removes duplicates")
    void testToSet_duplicates() {
        List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 3, 3, 4);
        Set<Integer> result = exercises.collectToSet(numbers);

        assertEquals(Set.of(1, 2, 3, 4), result);
    }

    @Test
    @DisplayName("Ex4: Collect empty list to set")
    void testToSet_empty() {
        assertTrue(exercises.collectToSet(new ArrayList<>()).isEmpty());
    }

    @Test
    @DisplayName("Ex4: Collect null list to set")
    void testToSet_null() {
        Set<Integer> result = exercises.collectToSet(null);
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    // ==================== EXERCISE 5: countLongStrings ====================

    @Test
    @DisplayName("Ex5: Count strings longer than threshold")
    void testCountLong_normal() {
        List<String> strings = Arrays.asList("Hi", "Hello", "World", "Java");
        assertEquals(3, exercises.countLongStrings(strings, 3)); // Hello, World, Java
    }

    @Test
    @DisplayName("Ex5: Count with no matches")
    void testCountLong_noMatches() {
        List<String> strings = Arrays.asList("Hi", "Ok", "No");
        assertEquals(0, exercises.countLongStrings(strings, 10));
    }

    @Test
    @DisplayName("Ex5: Count null list")
    void testCountLong_null() {
        assertEquals(0, exercises.countLongStrings(null, 5));
    }

    // ==================== EXERCISE 6: containsNumber ====================

    @Test
    @DisplayName("Ex6: anyMatch finds number")
    void testContains_found() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        assertTrue(exercises.containsNumber(numbers, 3));
    }

    @Test
    @DisplayName("Ex6: anyMatch doesn't find number")
    void testContains_notFound() {
        List<Integer> numbers = Arrays.asList(1, 2, 3);
        assertFalse(exercises.containsNumber(numbers, 10));
    }

    @Test
    @DisplayName("Ex6: anyMatch null list")
    void testContains_null() {
        assertFalse(exercises.containsNumber(null, 5));
    }

    // ==================== EXERCISE 7: allPositive ====================

    @Test
    @DisplayName("Ex7: allMatch all positive")
    void testAllPositive_true() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        assertTrue(exercises.allPositive(numbers, 0));
    }

    @Test
    @DisplayName("Ex7: allMatch not all positive")
    void testAllPositive_false() {
        List<Integer> numbers = Arrays.asList(1, -2, 3);
        assertFalse(exercises.allPositive(numbers, 0));
    }

    @Test
    @DisplayName("Ex7: allMatch null list")
    void testAllPositive_null() {
        assertFalse(exercises.allPositive(null, 0));
    }

    // ==================== EXERCISE 8: sumNumbers ====================

    @Test
    @DisplayName("Ex8: Sum numbers with reduce")
    void testSum_normal() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        assertEquals(15, exercises.sumNumbers(numbers));
    }

    @Test
    @DisplayName("Ex8: Sum empty list")
    void testSum_empty() {
        assertEquals(0, exercises.sumNumbers(new ArrayList<>()));
    }

    @Test
    @DisplayName("Ex8: Sum null list")
    void testSum_null() {
        assertEquals(0, exercises.sumNumbers(null));
    }

    // ==================== EXERCISE 9: findFirstStartingWith ====================

    @Test
    @DisplayName("Ex9: findFirst finds match")
    void testFindFirst_found() {
        List<String> strings = Arrays.asList("Apple", "Banana", "Apricot");
        Optional<String> result = exercises.findFirstStartingWith(strings, "Ap");

        assertTrue(result.isPresent());
        assertEquals("Apple", result.get());
    }

    @Test
    @DisplayName("Ex9: findFirst no match")
    void testFindFirst_notFound() {
        List<String> strings = Arrays.asList("Apple", "Banana");
        Optional<String> result = exercises.findFirstStartingWith(strings, "Z");

        assertFalse(result.isPresent());
    }

    @Test
    @DisplayName("Ex9: findFirst null list")
    void testFindFirst_null() {
        Optional<String> result = exercises.findFirstStartingWith(null, "A");
        assertFalse(result.isPresent());
    }

    // ==================== EXERCISE 10: getDistinct ====================

    @Test
    @DisplayName("Ex10: Get distinct elements")
    void testDistinct_normal() {
        List<String> strings = Arrays.asList("A", "B", "A", "C", "B");
        List<String> result = exercises.getDistinct(strings);

        assertEquals(Arrays.asList("A", "B", "C"), result);
    }

    @Test
    @DisplayName("Ex10: Distinct empty list")
    void testDistinct_empty() {
        assertTrue(exercises.getDistinct(new ArrayList<>()).isEmpty());
    }

    @Test
    @DisplayName("Ex10: Distinct null list")
    void testDistinct_null() {
        List<String> result = exercises.getDistinct(null);
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    // ==================== EXERCISE 11: parseIntegers ====================

    @Test
    @DisplayName("Ex11: Parse integers with method reference")
    void testParse_normal() {
        List<String> strings = Arrays.asList("1", "2", "3", "4");
        List<Integer> result = exercises.parseIntegers(strings);

        assertEquals(Arrays.asList(1, 2, 3, 4), result);
    }

    @Test
    @DisplayName("Ex11: Parse empty list")
    void testParse_empty() {
        assertTrue(exercises.parseIntegers(new ArrayList<>()).isEmpty());
    }

    @Test
    @DisplayName("Ex11: Parse null list")
    void testParse_null() {
        List<Integer> result = exercises.parseIntegers(null);
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    // ==================== EXERCISE 12: toLowerCaseMethodRef ====================

    @Test
    @DisplayName("Ex12: Lowercase with method reference")
    void testLowerCaseRef_normal() {
        List<String> strings = Arrays.asList("HELLO", "WORLD");
        List<String> result = exercises.toLowerCaseMethodRef(strings);

        assertEquals(Arrays.asList("hello", "world"), result);
    }

    @Test
    @DisplayName("Ex12: Lowercase null list")
    void testLowerCaseRef_null() {
        List<String> result = exercises.toLowerCaseMethodRef(null);
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    // ==================== EXERCISE 13: createPersons ====================

    @Test
    @DisplayName("Ex13: Create persons with constructor reference")
    void testCreatePersons_normal() {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        List<StreamExercises.Person> result = exercises.createPersons(names, 25, "NYC");

        assertEquals(3, result.size());
        assertEquals("Alice", result.get(0).getName());
        assertEquals(25, result.get(0).getAge());
        assertEquals("NYC", result.get(0).getCity());
    }

    @Test
    @DisplayName("Ex13: Create persons null list")
    void testCreatePersons_null() {
        List<StreamExercises.Person> result = exercises.createPersons(null, 25, "NYC");
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    // ==================== EXERCISE 14: flattenLists ====================

    @Test
    @DisplayName("Ex14: Flatten nested lists")
    void testFlatten_normal() {
        List<List<Integer>> nested = Arrays.asList(
            Arrays.asList(1, 2),
            Arrays.asList(3, 4),
            Arrays.asList(5, 6)
        );
        List<Integer> result = exercises.flattenLists(nested);

        assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6), result);
    }

    @Test
    @DisplayName("Ex14: Flatten empty nested list")
    void testFlatten_empty() {
        assertTrue(exercises.flattenLists(new ArrayList<>()).isEmpty());
    }

    @Test
    @DisplayName("Ex14: Flatten null list")
    void testFlatten_null() {
        List<Integer> result = exercises.flattenLists(null);
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    // ==================== EXERCISE 15: getNamesOfAdults ====================

    @Test
    @DisplayName("Ex15: Get names of adults")
    void testAdultNames_normal() {
        List<StreamExercises.Person> persons = Arrays.asList(
            new StreamExercises.Person("Alice", 25, "NYC"),
            new StreamExercises.Person("Bob", 17, "LA"),
            new StreamExercises.Person("Charlie", 30, "SF")
        );
        List<String> result = exercises.getNamesOfAdults(persons, 18);

        assertEquals(Arrays.asList("Alice", "Charlie"), result);
    }

    @Test
    @DisplayName("Ex15: Get names null list")
    void testAdultNames_null() {
        List<String> result = exercises.getNamesOfAdults(null, 18);
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    // ==================== EXERCISE 16: sortByAge ====================

    @Test
    @DisplayName("Ex16: Sort persons by age")
    void testSortByAge_normal() {
        List<StreamExercises.Person> persons = Arrays.asList(
            new StreamExercises.Person("Alice", 30, "NYC"),
            new StreamExercises.Person("Bob", 20, "LA"),
            new StreamExercises.Person("Charlie", 25, "SF")
        );
        List<StreamExercises.Person> result = exercises.sortByAge(persons);

        assertEquals("Bob", result.get(0).getName());
        assertEquals("Charlie", result.get(1).getName());
        assertEquals("Alice", result.get(2).getName());
    }

    @Test
    @DisplayName("Ex16: Sort null list")
    void testSortByAge_null() {
        List<StreamExercises.Person> result = exercises.sortByAge(null);
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    // ==================== EXERCISE 17: doubleWithPeek ====================

    @Test
    @DisplayName("Ex17: Double numbers with peek")
    void testPeek_normal() {
        List<Integer> numbers = Arrays.asList(1, 2, 3);
        List<Integer> peeked = new ArrayList<>();
        List<Integer> result = exercises.doubleWithPeek(numbers, peeked::add);

        assertEquals(Arrays.asList(2, 4, 6), result);
        assertEquals(Arrays.asList(1, 2, 3), peeked); // Original values seen in peek
    }

    @Test
    @DisplayName("Ex17: Peek null list")
    void testPeek_null() {
        List<Integer> result = exercises.doubleWithPeek(null, x -> {});
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    // ==================== EXERCISE 18: paginate ====================

    @Test
    @DisplayName("Ex18: Paginate - page 0")
    void testPaginate_firstPage() {
        List<String> list = Arrays.asList("A", "B", "C", "D", "E", "F");
        List<String> result = exercises.paginate(list, 0, 2);

        assertEquals(Arrays.asList("A", "B"), result);
    }

    @Test
    @DisplayName("Ex18: Paginate - page 1")
    void testPaginate_secondPage() {
        List<String> list = Arrays.asList("A", "B", "C", "D", "E", "F");
        List<String> result = exercises.paginate(list, 1, 2);

        assertEquals(Arrays.asList("C", "D"), result);
    }

    @Test
    @DisplayName("Ex18: Paginate null list")
    void testPaginate_null() {
        List<String> result = exercises.paginate(null, 0, 2);
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    // ==================== EXERCISE 19: groupByCity ====================

    @Test
    @DisplayName("Ex19: Group persons by city")
    void testGroupByCity_normal() {
        List<StreamExercises.Person> persons = Arrays.asList(
            new StreamExercises.Person("Alice", 25, "NYC"),
            new StreamExercises.Person("Bob", 30, "LA"),
            new StreamExercises.Person("Charlie", 35, "NYC")
        );
        Map<String, List<StreamExercises.Person>> result = exercises.groupByCity(persons);

        assertEquals(2, result.size());
        assertEquals(2, result.get("NYC").size());
        assertEquals(1, result.get("LA").size());
    }

    @Test
    @DisplayName("Ex19: Group null list")
    void testGroupByCity_null() {
        Map<String, List<StreamExercises.Person>> result = exercises.groupByCity(null);
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    // ==================== EXERCISE 20: partitionByThreshold ====================

    @Test
    @DisplayName("Ex20: Partition by threshold")
    void testPartition_normal() {
        List<Integer> numbers = Arrays.asList(1, 5, 10, 15, 20);
        Map<Boolean, List<Integer>> result = exercises.partitionByThreshold(numbers, 10);

        assertEquals(Arrays.asList(10, 15, 20), result.get(true));
        assertEquals(Arrays.asList(1, 5), result.get(false));
    }

    @Test
    @DisplayName("Ex20: Partition null list")
    void testPartition_null() {
        Map<Boolean, List<Integer>> result = exercises.partitionByThreshold(null, 10);
        assertNotNull(result);
        assertTrue(result.get(true).isEmpty());
        assertTrue(result.get(false).isEmpty());
    }

    // ==================== EXERCISE 21: joinStrings ====================

    @Test
    @DisplayName("Ex21: Join strings with delimiter")
    void testJoin_normal() {
        List<String> strings = Arrays.asList("A", "B", "C");
        assertEquals("A,B,C", exercises.joinStrings(strings, ","));
    }

    @Test
    @DisplayName("Ex21: Join empty list")
    void testJoin_empty() {
        assertEquals("", exercises.joinStrings(new ArrayList<>(), ","));
    }

    @Test
    @DisplayName("Ex21: Join null list")
    void testJoin_null() {
        assertEquals("", exercises.joinStrings(null, ","));
    }

    // ==================== EXERCISE 22: noneNegative ====================

    @Test
    @DisplayName("Ex22: noneMatch - all positive")
    void testNoneNegative_true() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
        assertTrue(exercises.noneNegative(numbers));
    }

    @Test
    @DisplayName("Ex22: noneMatch - has negative")
    void testNoneNegative_false() {
        List<Integer> numbers = Arrays.asList(1, -2, 3);
        assertFalse(exercises.noneNegative(numbers));
    }

    @Test
    @DisplayName("Ex22: noneMatch null list")
    void testNoneNegative_null() {
        assertFalse(exercises.noneNegative(null));
    }

    // ==================== EXERCISE 23: personNameToAge ====================

    @Test
    @DisplayName("Ex23: Convert to map name->age")
    void testNameToAge_normal() {
        List<StreamExercises.Person> persons = Arrays.asList(
            new StreamExercises.Person("Alice", 25, "NYC"),
            new StreamExercises.Person("Bob", 30, "LA")
        );
        Map<String, Integer> result = exercises.personNameToAge(persons);

        assertEquals(2, result.size());
        assertEquals(25, result.get("Alice"));
        assertEquals(30, result.get("Bob"));
    }

    @Test
    @DisplayName("Ex23: Convert null list to map")
    void testNameToAge_null() {
        Map<String, Integer> result = exercises.personNameToAge(null);
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    // ==================== EXERCISE 24: getAgeStatistics ====================

    @Test
    @DisplayName("Ex24: Get age statistics")
    void testStatistics_normal() {
        List<StreamExercises.Person> persons = Arrays.asList(
            new StreamExercises.Person("Alice", 20, "NYC"),
            new StreamExercises.Person("Bob", 30, "LA"),
            new StreamExercises.Person("Charlie", 40, "SF")
        );
        IntSummaryStatistics stats = exercises.getAgeStatistics(persons);

        assertEquals(3, stats.getCount());
        assertEquals(90, stats.getSum());
        assertEquals(20, stats.getMin());
        assertEquals(40, stats.getMax());
        assertEquals(30.0, stats.getAverage(), 0.01);
    }

    @Test
    @DisplayName("Ex24: Statistics null list")
    void testStatistics_null() {
        assertNull(exercises.getAgeStatistics(null));
    }

    // ==================== EXERCISE 25: productOfNumbers ====================

    @Test
    @DisplayName("Ex25: Product of numbers")
    void testProduct_normal() {
        List<Integer> numbers = Arrays.asList(2, 3, 4);
        assertEquals(24, exercises.productOfNumbers(numbers));
    }

    @Test
    @DisplayName("Ex25: Product empty list")
    void testProduct_empty() {
        assertEquals(1, exercises.productOfNumbers(new ArrayList<>()));
    }

    @Test
    @DisplayName("Ex25: Product null list")
    void testProduct_null() {
        assertEquals(1, exercises.productOfNumbers(null));
    }

    // ==================== EXERCISE 26: countPersonsByCity ====================

    @Test
    @DisplayName("Ex26: Count persons by city")
    void testCountByCity_normal() {
        List<StreamExercises.Person> persons = Arrays.asList(
            new StreamExercises.Person("Alice", 25, "NYC"),
            new StreamExercises.Person("Bob", 30, "NYC"),
            new StreamExercises.Person("Charlie", 35, "LA")
        );
        Map<String, Long> result = exercises.countPersonsByCity(persons);

        assertEquals(2L, result.get("NYC"));
        assertEquals(1L, result.get("LA"));
    }

    @Test
    @DisplayName("Ex26: Count null list")
    void testCountByCity_null() {
        Map<String, Long> result = exercises.countPersonsByCity(null);
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    // ==================== EXERCISE 27: getAllCharacters ====================

    @Test
    @DisplayName("Ex27: Get all characters from strings")
    void testGetChars_normal() {
        List<String> strings = Arrays.asList("AB", "CD");
        List<Character> result = exercises.getAllCharacters(strings);

        assertEquals(Arrays.asList('A', 'B', 'C', 'D'), result);
    }

    @Test
    @DisplayName("Ex27: Get characters null list")
    void testGetChars_null() {
        List<Character> result = exercises.getAllCharacters(null);
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    // ==================== EXERCISE 28: getAgeByName ====================

    @Test
    @DisplayName("Ex28: Get age by name - found")
    void testGetAgeByName_found() {
        List<StreamExercises.Person> persons = Arrays.asList(
            new StreamExercises.Person("Alice", 25, "NYC"),
            new StreamExercises.Person("Bob", 30, "LA")
        );
        assertEquals(25, exercises.getAgeByName(persons, "Alice"));
    }

    @Test
    @DisplayName("Ex28: Get age by name - not found")
    void testGetAgeByName_notFound() {
        List<StreamExercises.Person> persons = Arrays.asList(
            new StreamExercises.Person("Alice", 25, "NYC")
        );
        assertEquals(-1, exercises.getAgeByName(persons, "Bob"));
    }

    @Test
    @DisplayName("Ex28: Get age null list")
    void testGetAgeByName_null() {
        assertEquals(-1, exercises.getAgeByName(null, "Alice"));
    }

    // ==================== EXERCISE 29: getTotalPrice ====================

    @Test
    @DisplayName("Ex29: Get total price of products")
    void testTotalPrice_normal() {
        List<StreamExercises.Product> products = Arrays.asList(
            new StreamExercises.Product(1, "A", 10.0, "Cat1"),
            new StreamExercises.Product(2, "B", 20.0, "Cat2"),
            new StreamExercises.Product(3, "C", 30.0, "Cat1")
        );
        assertEquals(60.0, exercises.getTotalPrice(products), 0.01);
    }

    @Test
    @DisplayName("Ex29: Total price null list")
    void testTotalPrice_null() {
        assertEquals(0.0, exercises.getTotalPrice(null), 0.01);
    }

    // ==================== EXERCISE 30: groupByCategoryAndPrice ====================

    @Test
    @DisplayName("Ex30: Multi-level grouping")
    void testMultiGroup_normal() {
        List<StreamExercises.Product> products = Arrays.asList(
            new StreamExercises.Product(1, "A", 30.0, "Electronics"),
            new StreamExercises.Product(2, "B", 60.0, "Electronics"),
            new StreamExercises.Product(3, "C", 40.0, "Books")
        );
        Map<String, Map<Boolean, List<StreamExercises.Product>>> result =
            exercises.groupByCategoryAndPrice(products);

        assertEquals(2, result.size());
        assertEquals(1, result.get("Electronics").get(true).size()); // < 50
        assertEquals(1, result.get("Electronics").get(false).size()); // >= 50
    }

    @Test
    @DisplayName("Ex30: Multi-level grouping null list")
    void testMultiGroup_null() {
        Map<String, Map<Boolean, List<StreamExercises.Product>>> result =
            exercises.groupByCategoryAndPrice(null);
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    // ==================== EXERCISE 31: findOldestPerson ====================

    @Test
    @DisplayName("Ex31: Find oldest person")
    void testOldest_normal() {
        List<StreamExercises.Person> persons = Arrays.asList(
            new StreamExercises.Person("Alice", 25, "NYC"),
            new StreamExercises.Person("Bob", 40, "LA"),
            new StreamExercises.Person("Charlie", 30, "SF")
        );
        Optional<StreamExercises.Person> result = exercises.findOldestPerson(persons);

        assertTrue(result.isPresent());
        assertEquals("Bob", result.get().getName());
    }

    @Test
    @DisplayName("Ex31: Find oldest in empty list")
    void testOldest_empty() {
        Optional<StreamExercises.Person> result = exercises.findOldestPerson(new ArrayList<>());
        assertFalse(result.isPresent());
    }

    @Test
    @DisplayName("Ex31: Find oldest null list")
    void testOldest_null() {
        Optional<StreamExercises.Person> result = exercises.findOldestPerson(null);
        assertFalse(result.isPresent());
    }

    // ==================== EXERCISE 32: getAveragePrice ====================

    @Test
    @DisplayName("Ex32: Get average price")
    void testAveragePrice_normal() {
        List<StreamExercises.Product> products = Arrays.asList(
            new StreamExercises.Product(1, "A", 10.0, "Cat1"),
            new StreamExercises.Product(2, "B", 20.0, "Cat2"),
            new StreamExercises.Product(3, "C", 30.0, "Cat1")
        );
        assertEquals(20.0, exercises.getAveragePrice(products), 0.01);
    }

    @Test
    @DisplayName("Ex32: Average price null list")
    void testAveragePrice_null() {
        assertEquals(0.0, exercises.getAveragePrice(null), 0.01);
    }

    // ==================== EXERCISE 33: getAffordableProductNames ====================

    @Test
    @DisplayName("Ex33: Get affordable product names sorted")
    void testAffordable_normal() {
        List<StreamExercises.Product> products = Arrays.asList(
            new StreamExercises.Product(1, "Laptop", 80.0, "Electronics"),
            new StreamExercises.Product(2, "Mouse", 20.0, "Electronics"),
            new StreamExercises.Product(3, "Keyboard", 40.0, "Electronics"),
            new StreamExercises.Product(4, "Book", 15.0, "Books")
        );
        List<String> result = exercises.getAffordableProductNames(products, "Electronics", 50.0);

        assertEquals(Arrays.asList("Mouse", "Keyboard"), result);
    }

    @Test
    @DisplayName("Ex33: Affordable null list")
    void testAffordable_null() {
        List<String> result = exercises.getAffordableProductNames(null, "Electronics", 50.0);
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }
}
