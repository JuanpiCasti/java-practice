package com.juanpicasti.practice.collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Advanced Collections Exercises Test Suite")
class AdvancedCollectionsExercisesTest {

    private AdvancedCollectionsExercises exercises;

    @BeforeEach
    void setUp() {
        exercises = new AdvancedCollectionsExercises();
    }

    // ==================== EXERCISE 1: processQueue ====================

    @Test
    @DisplayName("Ex1: Process queue in FIFO order")
    void testQueue_fifo() {
        List<String> result = exercises.processQueue("A", "B", "C", "D");

        assertEquals(Arrays.asList("A", "B", "C", "D"), result);
    }

    @Test
    @DisplayName("Ex1: Process empty queue")
    void testQueue_empty() {
        List<String> result = exercises.processQueue();

        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("Ex1: Process single element")
    void testQueue_single() {
        List<String> result = exercises.processQueue("A");

        assertEquals(Arrays.asList("A"), result);
    }

    // ==================== EXERCISE 2: createDeque ====================

    @Test
    @DisplayName("Ex2: Create deque with alternating adds")
    void testDeque_alternating() {
        Deque<String> result = exercises.createDeque("A", "B", "C", "D");

        assertEquals(4, result.size());
        // A added first, B added last, C added first, D added last
        // Order should be: C, A, B, D
        assertEquals("C", result.removeFirst());
        assertEquals("A", result.removeFirst());
        assertEquals("B", result.removeFirst());
        assertEquals("D", result.removeFirst());
    }

    @Test
    @DisplayName("Ex2: Create empty deque")
    void testDeque_empty() {
        Deque<String> result = exercises.createDeque();

        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("Ex2: Create deque with single element")
    void testDeque_single() {
        Deque<String> result = exercises.createDeque("A");

        assertEquals(1, result.size());
        assertEquals("A", result.getFirst());
    }

    // ==================== EXERCISE 3: sortWithPriorityQueue ====================

    @Test
    @DisplayName("Ex3: PriorityQueue sorts in ascending order")
    void testPriorityQueue_ascending() {
        List<Integer> result = exercises.sortWithPriorityQueue(5, 2, 8, 1, 9, 3);

        assertEquals(Arrays.asList(1, 2, 3, 5, 8, 9), result);
    }

    @Test
    @DisplayName("Ex3: PriorityQueue with duplicates")
    void testPriorityQueue_duplicates() {
        List<Integer> result = exercises.sortWithPriorityQueue(5, 2, 5, 1, 2);

        assertEquals(Arrays.asList(1, 2, 2, 5, 5), result);
    }

    @Test
    @DisplayName("Ex3: Empty PriorityQueue")
    void testPriorityQueue_empty() {
        List<Integer> result = exercises.sortWithPriorityQueue();

        assertTrue(result.isEmpty());
    }

    // ==================== EXERCISE 4: createMaxHeap ====================

    @Test
    @DisplayName("Ex4: Max heap returns descending order")
    void testMaxHeap_descending() {
        List<Integer> result = exercises.createMaxHeap(5, 2, 8, 1, 9, 3);

        assertEquals(Arrays.asList(9, 8, 5, 3, 2, 1), result);
    }

    @Test
    @DisplayName("Ex4: Max heap with duplicates")
    void testMaxHeap_duplicates() {
        List<Integer> result = exercises.createMaxHeap(5, 2, 5, 1, 2);

        assertEquals(Arrays.asList(5, 5, 2, 2, 1), result);
    }

    @Test
    @DisplayName("Ex4: Empty max heap")
    void testMaxHeap_empty() {
        List<Integer> result = exercises.createMaxHeap();

        assertTrue(result.isEmpty());
    }

    // ==================== EXERCISE 5: sortList ====================

    @Test
    @DisplayName("Ex5: Sort list in natural order")
    void testSort_ascending() {
        List<Integer> list = new ArrayList<>(Arrays.asList(5, 2, 8, 1, 9));
        exercises.sortList(list);

        assertEquals(Arrays.asList(1, 2, 5, 8, 9), list);
    }

    @Test
    @DisplayName("Ex5: Sort already sorted list")
    void testSort_alreadySorted() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        exercises.sortList(list);

        assertEquals(Arrays.asList(1, 2, 3, 4), list);
    }

    @Test
    @DisplayName("Ex5: Throw exception for null list")
    void testSort_nullList() {
        assertThrows(IllegalArgumentException.class, () -> exercises.sortList(null));
    }

    // ==================== EXERCISE 6: sortByLength ====================

    @Test
    @DisplayName("Ex6: Sort by length then alphabetically")
    void testSortByLength_normal() {
        List<String> list = new ArrayList<>(Arrays.asList("Cherry", "Apple", "Banana", "Fig"));
        exercises.sortByLength(list);

        // Fig(3), Apple(5), Banana(6), Cherry(6)
        // Banana and Cherry both have length 6, so alphabetically: Banana, Cherry
        assertEquals(Arrays.asList("Fig", "Apple", "Banana", "Cherry"), list);
    }

    @Test
    @DisplayName("Ex6: Sort with same lengths")
    void testSortByLength_sameLengths() {
        List<String> list = new ArrayList<>(Arrays.asList("Cat", "Dog", "Ant", "Bee"));
        exercises.sortByLength(list);

        // All have length 3, so alphabetically
        assertEquals(Arrays.asList("Ant", "Bee", "Cat", "Dog"), list);
    }

    @Test
    @DisplayName("Ex6: Throw exception for null list")
    void testSortByLength_nullList() {
        assertThrows(IllegalArgumentException.class, () -> exercises.sortByLength(null));
    }

    // ==================== EXERCISE 7: countLongStrings ====================

    @Test
    @DisplayName("Ex7: Count strings longer than threshold")
    void testCountLong_normal() {
        List<String> list = Arrays.asList("Hi", "Hello", "World", "Java", "Programming");
        int result = exercises.countLongStrings(list, 4);

        // Hello(5), World(5), Programming(11) are > 4
        assertEquals(3, result);
    }

    @Test
    @DisplayName("Ex7: Count with no long strings")
    void testCountLong_none() {
        List<String> list = Arrays.asList("Hi", "Ok", "No");
        int result = exercises.countLongStrings(list, 10);

        assertEquals(0, result);
    }

    @Test
    @DisplayName("Ex7: Return 0 for null list")
    void testCountLong_nullList() {
        assertEquals(0, exercises.countLongStrings(null, 5));
    }

    @Test
    @DisplayName("Ex7: Count with empty list")
    void testCountLong_emptyList() {
        assertEquals(0, exercises.countLongStrings(new ArrayList<>(), 5));
    }

    // ==================== EXERCISE 8: removeDuplicatesAndSort ====================

    @Test
    @DisplayName("Ex8: Remove duplicates and sort")
    void testRemoveDupsAndSort_normal() {
        List<String> list = Arrays.asList("Banana", "Apple", "Cherry", "Apple", "Banana");
        List<String> result = exercises.removeDuplicatesAndSort(list);

        assertEquals(Arrays.asList("Apple", "Banana", "Cherry"), result);
    }

    @Test
    @DisplayName("Ex8: No duplicates to remove")
    void testRemoveDupsAndSort_noDuplicates() {
        List<String> list = Arrays.asList("C", "A", "B");
        List<String> result = exercises.removeDuplicatesAndSort(list);

        assertEquals(Arrays.asList("A", "B", "C"), result);
    }

    @Test
    @DisplayName("Ex8: Return empty list for null input")
    void testRemoveDupsAndSort_null() {
        List<String> result = exercises.removeDuplicatesAndSort(null);

        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("Ex8: All duplicates")
    void testRemoveDupsAndSort_allDuplicates() {
        List<String> list = Arrays.asList("A", "A", "A", "A");
        List<String> result = exercises.removeDuplicatesAndSort(list);

        assertEquals(Arrays.asList("A"), result);
    }
}
