package com.juanpicasti.practice.sorting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Advanced Sorting Exercises Test Suite")
class AdvancedSortingExercisesTest {

    private AdvancedSortingExercises exercises;

    @BeforeEach
    void setUp() {
        exercises = new AdvancedSortingExercises();
    }

    // ==================== EXERCISE 1: sortBySalaryUsingCollections ====================

    @Test
    @DisplayName("Ex1: Sort by salary using Collections.sort()")
    void testSortBySalaryUsingCollections_sorting() {
        List<Person> people = new ArrayList<>(Arrays.asList(
            new Person("Alice", 30, 60000),
            new Person("Bob", 25, 50000),
            new Person("Charlie", 35, 70000)
        ));

        exercises.sortBySalaryUsingCollections(people);

        assertEquals(50000, people.get(0).getSalary(), "First should have salary 50000");
        assertEquals(60000, people.get(1).getSalary(), "Second should have salary 60000");
        assertEquals(70000, people.get(2).getSalary(), "Third should have salary 70000");
    }

    @Test
    @DisplayName("Ex1: Sort handles already sorted list")
    void testSortBySalaryUsingCollections_alreadySorted() {
        List<Person> people = new ArrayList<>(Arrays.asList(
            new Person("Alice", 30, 50000),
            new Person("Bob", 25, 60000)
        ));

        exercises.sortBySalaryUsingCollections(people);

        assertEquals(50000, people.get(0).getSalary(), "Order should remain unchanged");
    }

    @Test
    @DisplayName("Ex1: Sort throws exception for null list")
    void testSortBySalaryUsingCollections_nullList() {
        assertThrows(IllegalArgumentException.class,
            () -> exercises.sortBySalaryUsingCollections(null),
            "Should throw IllegalArgumentException for null list");
    }

    // ==================== EXERCISE 2: sortByRatingUsingArrays ====================

    @Test
    @DisplayName("Ex2: Sort array by rating descending using Arrays.sort()")
    void testSortByRatingUsingArrays_sorting() {
        Product[] products = {
            new Product("A", 10.0, 3.0),
            new Product("B", 20.0, 5.0),
            new Product("C", 30.0, 4.0)
        };

        exercises.sortByRatingUsingArrays(products);

        assertEquals(5.0, products[0].getRating(), "First should have rating 5.0 (highest)");
        assertEquals(4.0, products[1].getRating(), "Second should have rating 4.0");
        assertEquals(3.0, products[2].getRating(), "Third should have rating 3.0 (lowest)");
    }

    @Test
    @DisplayName("Ex2: Sort handles already sorted array")
    void testSortByRatingUsingArrays_alreadySorted() {
        Product[] products = {
            new Product("A", 10.0, 5.0),
            new Product("B", 20.0, 4.0)
        };

        exercises.sortByRatingUsingArrays(products);

        assertEquals(5.0, products[0].getRating(), "Order should remain unchanged");
    }

    @Test
    @DisplayName("Ex2: Sort throws exception for null array")
    void testSortByRatingUsingArrays_nullArray() {
        assertThrows(IllegalArgumentException.class,
            () -> exercises.sortByRatingUsingArrays(null),
            "Should throw IllegalArgumentException for null array");
    }

    // ==================== EXERCISE 3: sortByYearUsingListSort ====================

    @Test
    @DisplayName("Ex3: Sort by year using List.sort()")
    void testSortByYearUsingListSort_sorting() {
        List<Book> books = new ArrayList<>(Arrays.asList(
            new Book("Book C", "Author", 2020, 300),
            new Book("Book A", "Author", 1990, 400),
            new Book("Book B", "Author", 2005, 350)
        ));

        exercises.sortByYearUsingListSort(books);

        assertEquals(1990, books.get(0).getYear(), "First should be year 1990");
        assertEquals(2005, books.get(1).getYear(), "Second should be year 2005");
        assertEquals(2020, books.get(2).getYear(), "Third should be year 2020");
    }

    @Test
    @DisplayName("Ex3: Sort throws exception for null list")
    void testSortByYearUsingListSort_nullList() {
        assertThrows(IllegalArgumentException.class,
            () -> exercises.sortByYearUsingListSort(null),
            "Should throw IllegalArgumentException for null list");
    }

    // ==================== EXERCISE 4: createEmployeeSetSortedByName ====================

    @Test
    @DisplayName("Ex4: TreeSet maintains sorted order by name")
    void testCreateEmployeeSetSortedByName_sortedOrder() {
        Employee[] employees = {
            new Employee(3, "Charlie", "Engineering", 70000),
            new Employee(1, "Alice", "Sales", 50000),
            new Employee(2, "Bob", "Marketing", 60000)
        };

        Set<Employee> sortedSet = exercises.createEmployeeSetSortedByName(employees);
        List<Employee> list = new ArrayList<>(sortedSet);

        assertEquals("Alice", list.get(0).getName(), "First should be Alice");
        assertEquals("Bob", list.get(1).getName(), "Second should be Bob");
        assertEquals("Charlie", list.get(2).getName(), "Third should be Charlie");
    }

    @Test
    @DisplayName("Ex4: TreeSet contains all employees")
    void testCreateEmployeeSetSortedByName_containsAll() {
        Employee[] employees = {
            new Employee(1, "Alice", "Sales", 50000),
            new Employee(2, "Bob", "Marketing", 60000)
        };

        Set<Employee> sortedSet = exercises.createEmployeeSetSortedByName(employees);

        assertEquals(2, sortedSet.size(), "Set should contain 2 employees");
    }

    @Test
    @DisplayName("Ex4: TreeSet throws exception for null array")
    void testCreateEmployeeSetSortedByName_nullArray() {
        assertThrows(IllegalArgumentException.class,
            () -> exercises.createEmployeeSetSortedByName(null),
            "Should throw IllegalArgumentException for null array");
    }

    // ==================== EXERCISE 5: createPersonMapSortedByAge ====================

    @Test
    @DisplayName("Ex5: TreeMap maintains sorted order by age")
    void testCreatePersonMapSortedByAge_sortedOrder() {
        Map<Person, String> originalMap = new HashMap<>();
        Person p1 = new Person("Alice", 50, 50000);
        Person p2 = new Person("Bob", 25, 60000);
        Person p3 = new Person("Charlie", 35, 70000);
        originalMap.put(p1, "Engineering");
        originalMap.put(p2, "Sales");
        originalMap.put(p3, "Marketing");

        Map<Person, String> sortedMap = exercises.createPersonMapSortedByAge(originalMap);
        List<Person> keys = new ArrayList<>(sortedMap.keySet());

        assertEquals(25, keys.get(0).getAge(), "First key should have age 25");
        assertEquals(35, keys.get(1).getAge(), "Second key should have age 35");
        assertEquals(50, keys.get(2).getAge(), "Third key should have age 50");
    }

    @Test
    @DisplayName("Ex5: TreeMap contains all entries")
    void testCreatePersonMapSortedByAge_containsAll() {
        Map<Person, String> originalMap = new HashMap<>();
        Person p1 = new Person("Alice", 30, 50000);
        originalMap.put(p1, "Engineering");

        Map<Person, String> sortedMap = exercises.createPersonMapSortedByAge(originalMap);

        assertEquals(1, sortedMap.size(), "Map should contain 1 entry");
        assertEquals("Engineering", sortedMap.get(p1), "Should contain correct value");
    }

    @Test
    @DisplayName("Ex5: TreeMap throws exception for null map")
    void testCreatePersonMapSortedByAge_nullMap() {
        assertThrows(IllegalArgumentException.class,
            () -> exercises.createPersonMapSortedByAge(null),
            "Should throw IllegalArgumentException for null map");
    }

    // ==================== EXERCISE 6: createFourLevelEmployeeComparator ====================

    @Test
    @DisplayName("Ex6: Four-level comparator orders by department first")
    void testCreateFourLevelEmployeeComparator_departmentFirst() {
        Comparator<Employee> comparator = exercises.createFourLevelEmployeeComparator();
        Employee engr = new Employee(1, "Alice", "Engineering", 100000);
        Employee sales = new Employee(2, "Bob", "Sales", 100000);

        assertTrue(comparator.compare(engr, sales) < 0, "Engineering should come before Sales");
    }

    @Test
    @DisplayName("Ex6: Four-level comparator orders by salary descending when departments equal")
    void testCreateFourLevelEmployeeComparator_salarySecondary() {
        Comparator<Employee> comparator = exercises.createFourLevelEmployeeComparator();
        Employee higher = new Employee(1, "Alice", "Engineering", 120000);
        Employee lower = new Employee(2, "Bob", "Engineering", 80000);

        assertTrue(comparator.compare(higher, lower) < 0, "Higher salary should come first");
    }

    @Test
    @DisplayName("Ex6: Four-level comparator orders by name when dept and salary equal")
    void testCreateFourLevelEmployeeComparator_nameThird() {
        Comparator<Employee> comparator = exercises.createFourLevelEmployeeComparator();
        Employee alice = new Employee(1, "Alice", "Engineering", 100000);
        Employee bob = new Employee(2, "Bob", "Engineering", 100000);

        assertTrue(comparator.compare(alice, bob) < 0, "Alice should come before Bob");
    }

    @Test
    @DisplayName("Ex6: Four-level comparator orders by ID when dept, salary, name equal")
    void testCreateFourLevelEmployeeComparator_idFourth() {
        Comparator<Employee> comparator = exercises.createFourLevelEmployeeComparator();
        Employee emp1 = new Employee(1, "Alice", "Engineering", 100000);
        Employee emp2 = new Employee(2, "Alice", "Engineering", 100000);

        assertTrue(comparator.compare(emp1, emp2) < 0, "Lower ID should come first");
    }

    // ==================== EXERCISE 7: sortProductsConditionally ====================

    @Test
    @DisplayName("Ex7: Conditional sort by price then rating")
    void testSortProductsConditionally_byPrice() {
        List<Product> products = new ArrayList<>(Arrays.asList(
            new Product("A", 30.0, 5.0),
            new Product("B", 10.0, 3.0),
            new Product("C", 20.0, 4.0)
        ));

        exercises.sortProductsConditionally(products, true);

        assertEquals(10.0, products.get(0).getPrice(), "First should have price 10.0");
        assertEquals(20.0, products.get(1).getPrice(), "Second should have price 20.0");
        assertEquals(30.0, products.get(2).getPrice(), "Third should have price 30.0");
    }

    @Test
    @DisplayName("Ex7: Conditional sort by rating then price")
    void testSortProductsConditionally_byRating() {
        List<Product> products = new ArrayList<>(Arrays.asList(
            new Product("A", 30.0, 3.0),
            new Product("B", 10.0, 5.0),
            new Product("C", 20.0, 4.0)
        ));

        exercises.sortProductsConditionally(products, false);

        assertEquals(5.0, products.get(0).getRating(), "First should have rating 5.0 (highest)");
        assertEquals(4.0, products.get(1).getRating(), "Second should have rating 4.0");
        assertEquals(3.0, products.get(2).getRating(), "Third should have rating 3.0");
    }

    @Test
    @DisplayName("Ex7: Conditional sort uses secondary criteria")
    void testSortProductsConditionally_secondaryCriteria() {
        List<Product> products = new ArrayList<>(Arrays.asList(
            new Product("A", 10.0, 3.0),
            new Product("B", 10.0, 5.0)
        ));

        exercises.sortProductsConditionally(products, true);

        // When prices equal, should sort by rating descending
        assertEquals(5.0, products.get(0).getRating(), "Higher rating should come first when prices equal");
    }

    // ==================== EXERCISE 8: sortByAgeAndVerifyStability ====================

    @Test
    @DisplayName("Ex8: Sort by age and verify stability")
    void testSortByAgeAndVerifyStability_stable() {
        List<Person> people = new ArrayList<>(Arrays.asList(
            new Person("Alice", 30, 50000),
            new Person("Bob", 25, 60000),
            new Person("Charlie", 30, 70000)
        ));

        boolean stable = exercises.sortByAgeAndVerifyStability(people);

        assertTrue(stable, "Sort should be stable");
        assertEquals(25, people.get(0).getAge(), "First should have age 25");
        assertEquals(30, people.get(1).getAge(), "Second should have age 30");
        assertEquals(30, people.get(2).getAge(), "Third should have age 30");
        // Verify stability: Alice should still come before Charlie (both age 30)
        assertEquals("Alice", people.get(1).getName(), "Alice should come before Charlie (stability)");
        assertEquals("Charlie", people.get(2).getName(), "Charlie should come after Alice (stability)");
    }

    @Test
    @DisplayName("Ex8: Sort throws exception for null list")
    void testSortByAgeAndVerifyStability_nullList() {
        assertThrows(IllegalArgumentException.class,
            () -> exercises.sortByAgeAndVerifyStability(null),
            "Should throw IllegalArgumentException for null list");
    }

    // ==================== EXERCISE 9: sortByValueDensity ====================

    @Test
    @DisplayName("Ex9: Sort by value density (pages per year)")
    void testSortByValueDensity_sorting() {
        List<Book> books = new ArrayList<>(Arrays.asList(
            new Book("Old Thin", "Author", 2000, 100),  // 100/(2025-2000+1) = 3.85
            new Book("Recent Thick", "Author", 2024, 500), // 500/(2025-2024+1) = 250
            new Book("Middle", "Author", 2010, 300)  // 300/(2025-2010+1) = 18.75
        ));

        exercises.sortByValueDensity(books, 2025);

        // Higher density should come first (descending)
        assertEquals("Recent Thick", books.get(0).getTitle(), "Highest density first");
        assertEquals("Middle", books.get(1).getTitle(), "Middle density second");
        assertEquals("Old Thin", books.get(2).getTitle(), "Lowest density last");
    }

    @Test
    @DisplayName("Ex9: Sort throws exception for null list")
    void testSortByValueDensity_nullList() {
        assertThrows(IllegalArgumentException.class,
            () -> exercises.sortByValueDensity(null, 2025),
            "Should throw IllegalArgumentException for null list");
    }

    // ==================== EXERCISE 10: groupByDepartmentAndSortBySalary ====================

    @Test
    @DisplayName("Ex10: Group by department and sort by salary")
    void testGroupByDepartmentAndSortBySalary_grouping() {
        List<Employee> employees = Arrays.asList(
            new Employee(1, "Alice", "Engineering", 80000),
            new Employee(2, "Bob", "Sales", 60000),
            new Employee(3, "Charlie", "Engineering", 100000),
            new Employee(4, "David", "Sales", 70000)
        );

        Map<String, List<Employee>> grouped = exercises.groupByDepartmentAndSortBySalary(employees);

        assertEquals(2, grouped.size(), "Should have 2 departments");
        assertTrue(grouped.containsKey("Engineering"), "Should contain Engineering");
        assertTrue(grouped.containsKey("Sales"), "Should contain Sales");
    }

    @Test
    @DisplayName("Ex10: Employees within department sorted by salary descending")
    void testGroupByDepartmentAndSortBySalary_sortedWithinGroup() {
        List<Employee> employees = Arrays.asList(
            new Employee(1, "Alice", "Engineering", 80000),
            new Employee(2, "Charlie", "Engineering", 100000),
            new Employee(3, "Bob", "Engineering", 90000)
        );

        Map<String, List<Employee>> grouped = exercises.groupByDepartmentAndSortBySalary(employees);
        List<Employee> engr = grouped.get("Engineering");

        assertEquals(3, engr.size(), "Engineering should have 3 employees");
        assertEquals(100000, engr.get(0).getSalary(), "Highest salary first");
        assertEquals(90000, engr.get(1).getSalary(), "Middle salary second");
        assertEquals(80000, engr.get(2).getSalary(), "Lowest salary last");
    }

    @Test
    @DisplayName("Ex10: Group throws exception for null list")
    void testGroupByDepartmentAndSortBySalary_nullList() {
        assertThrows(IllegalArgumentException.class,
            () -> exercises.groupByDepartmentAndSortBySalary(null),
            "Should throw IllegalArgumentException for null list");
    }

    // ==================== EXERCISE 11: createComparatorFactory ====================

    @Test
    @DisplayName("Ex11: ComparatorFactory creates ascending comparator")
    void testCreateComparatorFactory_ascending() {
        exercises.createComparatorFactory();
        Comparator<Person> comparator = AdvancedSortingExercises.ComparatorFactory.ascending(Person::getName);

        Person alice = new Person("Alice", 30, 50000);
        Person bob = new Person("Bob", 25, 60000);

        assertTrue(comparator.compare(alice, bob) < 0, "Should create ascending comparator");
    }

    @Test
    @DisplayName("Ex11: ComparatorFactory creates descending comparator")
    void testCreateComparatorFactory_descending() {
        exercises.createComparatorFactory();
        Comparator<Product> comparator = AdvancedSortingExercises.ComparatorFactory.descending(Product::getPrice);

        Product cheap = new Product("A", 10.0, 5.0);
        Product expensive = new Product("B", 100.0, 3.0);

        assertTrue(comparator.compare(expensive, cheap) < 0, "Should create descending comparator");
    }

    @Test
    @DisplayName("Ex11: ComparatorFactory creates null-safe ascending comparator")
    void testCreateComparatorFactory_nullSafe() {
        exercises.createComparatorFactory();
        Comparator<Person> comparator = AdvancedSortingExercises.ComparatorFactory.nullSafeAscending(Person::getName);

        Person alice = new Person("Alice", 30, 50000);

        assertTrue(comparator.compare(alice, null) < 0, "Non-null should come before null");
        assertTrue(comparator.compare(null, alice) > 0, "Null should come after non-null");
    }

    // ==================== EXERCISE 12: sortWithEdgeCaseHandling ====================

    @Test
    @DisplayName("Ex12: Edge case handling sorts correctly")
    void testSortWithEdgeCaseHandling_sorting() {
        List<Person> people = new ArrayList<>(Arrays.asList(
            new Person("Charlie", 30, 50000),
            null,
            new Person("Alice", 25, 60000),
            new Person(null, 35, 70000)
        ));

        exercises.sortWithEdgeCaseHandling(people);

        assertNotNull(people.get(0), "First should be non-null with non-null name");
        assertEquals("Alice", people.get(0).getName(), "First should be Alice");
        assertEquals("Charlie", people.get(1).getName(), "Second should be Charlie");
        assertNull(people.get(2).getName(), "Third should have null name");
        assertNull(people.get(3), "Last should be null element");
    }

    @Test
    @DisplayName("Ex12: Edge case handling with empty list")
    void testSortWithEdgeCaseHandling_emptyList() {
        List<Person> people = new ArrayList<>();

        assertDoesNotThrow(() -> exercises.sortWithEdgeCaseHandling(people),
            "Should handle empty list without error");
    }

    @Test
    @DisplayName("Ex12: Edge case handling throws exception for null list")
    void testSortWithEdgeCaseHandling_nullList() {
        assertThrows(IllegalArgumentException.class,
            () -> exercises.sortWithEdgeCaseHandling(null),
            "Should throw IllegalArgumentException for null list");
    }

    // ==================== EXERCISE 13: sortByScoreOptimized ====================

    @Test
    @DisplayName("Ex13: Sort by score (price * rating) optimized")
    void testSortByScoreOptimized_sorting() {
        List<Product> products = new ArrayList<>(Arrays.asList(
            new Product("A", 10.0, 5.0),  // score = 50
            new Product("B", 20.0, 3.0),  // score = 60
            new Product("C", 5.0, 4.0)    // score = 20
        ));

        exercises.sortByScoreOptimized(products);

        assertEquals("C", products.get(0).getName(), "Lowest score first (20)");
        assertEquals("A", products.get(1).getName(), "Middle score second (50)");
        assertEquals("B", products.get(2).getName(), "Highest score last (60)");
    }

    @Test
    @DisplayName("Ex13: Sort throws exception for null list")
    void testSortByScoreOptimized_nullList() {
        assertThrows(IllegalArgumentException.class,
            () -> exercises.sortByScoreOptimized(null),
            "Should throw IllegalArgumentException for null list");
    }
}
