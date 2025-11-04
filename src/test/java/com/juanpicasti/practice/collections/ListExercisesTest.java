package com.juanpicasti.practice.collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("List Exercises Test Suite")
class ListExercisesTest {

    private ListExercises exercises;

    @BeforeEach
    void setUp() {
        exercises = new ListExercises();
    }

    // ==================== EXERCISE 1: createAndPopulateArrayList ====================

    @Test
    @DisplayName("Ex1: Create ArrayList with elements")
    void testCreateArrayList_withElements() {
        List<String> result = exercises.createAndPopulateArrayList("Java", "Python", "C++");

        assertEquals(3, result.size());
        assertTrue(result instanceof ArrayList);
        assertEquals("Java", result.get(0));
        assertEquals("Python", result.get(1));
        assertEquals("C++", result.get(2));
    }

    @Test
    @DisplayName("Ex1: Create empty ArrayList")
    void testCreateArrayList_empty() {
        List<String> result = exercises.createAndPopulateArrayList();

        assertEquals(0, result.size());
        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("Ex1: Create ArrayList with one element")
    void testCreateArrayList_singleElement() {
        List<String> result = exercises.createAndPopulateArrayList("Hello");

        assertEquals(1, result.size());
        assertEquals("Hello", result.get(0));
    }

    // ==================== EXERCISE 2: getElementAtIndex ====================

    @Test
    @DisplayName("Ex2: Get element at valid index")
    void testGetElement_validIndex() {
        List<String> list = Arrays.asList("A", "B", "C");

        assertEquals("A", exercises.getElementAtIndex(list, 0));
        assertEquals("B", exercises.getElementAtIndex(list, 1));
        assertEquals("C", exercises.getElementAtIndex(list, 2));
    }

    @Test
    @DisplayName("Ex2: Throw exception for null list")
    void testGetElement_nullList() {
        assertThrows(IllegalArgumentException.class, () -> exercises.getElementAtIndex(null, 0));
    }

    @Test
    @DisplayName("Ex2: Throw exception for index out of bounds")
    void testGetElement_indexOutOfBounds() {
        List<String> list = Arrays.asList("A", "B");

        assertThrows(IllegalArgumentException.class, () -> exercises.getElementAtIndex(list, 5));
        assertThrows(IllegalArgumentException.class, () -> exercises.getElementAtIndex(list, -1));
    }

    // ==================== EXERCISE 3: removeElement ====================

    @Test
    @DisplayName("Ex3: Remove existing element")
    void testRemoveElement_exists() {
        List<String> list = new ArrayList<>(Arrays.asList("A", "B", "C"));

        assertTrue(exercises.removeElement(list, "B"));
        assertEquals(2, list.size());
        assertFalse(list.contains("B"));
    }

    @Test
    @DisplayName("Ex3: Remove non-existing element")
    void testRemoveElement_notExists() {
        List<String> list = new ArrayList<>(Arrays.asList("A", "B", "C"));

        assertFalse(exercises.removeElement(list, "Z"));
        assertEquals(3, list.size());
    }

    @Test
    @DisplayName("Ex3: Throw exception for null list")
    void testRemoveElement_nullList() {
        assertThrows(IllegalArgumentException.class, () -> exercises.removeElement(null, "A"));
    }

    @Test
    @DisplayName("Ex3: Remove null element")
    void testRemoveElement_nullElement() {
        List<String> list = new ArrayList<>(Arrays.asList("A", null, "C"));

        assertTrue(exercises.removeElement(list, null));
        assertEquals(2, list.size());
    }

    // ==================== EXERCISE 4: findFirstIndex ====================

    @Test
    @DisplayName("Ex4: Find index of existing element")
    void testFindIndex_exists() {
        List<String> list = Arrays.asList("A", "B", "C", "B");

        assertEquals(1, exercises.findFirstIndex(list, "B"));
        assertEquals(0, exercises.findFirstIndex(list, "A"));
    }

    @Test
    @DisplayName("Ex4: Return -1 for non-existing element")
    void testFindIndex_notExists() {
        List<String> list = Arrays.asList("A", "B", "C");

        assertEquals(-1, exercises.findFirstIndex(list, "Z"));
    }

    @Test
    @DisplayName("Ex4: Return -1 for null list")
    void testFindIndex_nullList() {
        assertEquals(-1, exercises.findFirstIndex(null, "A"));
    }

    // ==================== EXERCISE 5: containsElement ====================

    @Test
    @DisplayName("Ex5: Element exists in list")
    void testContains_exists() {
        List<String> list = Arrays.asList("A", "B", "C");

        assertTrue(exercises.containsElement(list, "B"));
    }

    @Test
    @DisplayName("Ex5: Element does not exist")
    void testContains_notExists() {
        List<String> list = Arrays.asList("A", "B", "C");

        assertFalse(exercises.containsElement(list, "Z"));
    }

    @Test
    @DisplayName("Ex5: Return false for null list")
    void testContains_nullList() {
        assertFalse(exercises.containsElement(null, "A"));
    }

    // ==================== EXERCISE 6: extractSublist ====================

    @Test
    @DisplayName("Ex6: Extract sublist from middle")
    void testSublist_middle() {
        List<String> list = Arrays.asList("A", "B", "C", "D", "E");
        List<String> result = exercises.extractSublist(list, 1, 4);

        assertEquals(3, result.size());
        assertEquals(Arrays.asList("B", "C", "D"), result);
    }

    @Test
    @DisplayName("Ex6: Extract sublist from start")
    void testSublist_fromStart() {
        List<String> list = Arrays.asList("A", "B", "C", "D");
        List<String> result = exercises.extractSublist(list, 0, 2);

        assertEquals(Arrays.asList("A", "B"), result);
    }

    @Test
    @DisplayName("Ex6: Extract empty sublist")
    void testSublist_empty() {
        List<String> list = Arrays.asList("A", "B", "C");
        List<String> result = exercises.extractSublist(list, 1, 1);

        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("Ex6: Throw exception for null list")
    void testSublist_nullList() {
        assertThrows(IllegalArgumentException.class, () -> exercises.extractSublist(null, 0, 1));
    }

    @Test
    @DisplayName("Ex6: Throw exception for invalid indices")
    void testSublist_invalidIndices() {
        List<String> list = Arrays.asList("A", "B", "C");

        assertThrows(IllegalArgumentException.class, () -> exercises.extractSublist(list, 2, 1));
        assertThrows(IllegalArgumentException.class, () -> exercises.extractSublist(list, -1, 2));
        assertThrows(IllegalArgumentException.class, () -> exercises.extractSublist(list, 0, 10));
    }

    // ==================== EXERCISE 7: replaceElement ====================

    @Test
    @DisplayName("Ex7: Replace element at index")
    void testReplace_validIndex() {
        List<String> list = new ArrayList<>(Arrays.asList("A", "B", "C"));
        String oldValue = exercises.replaceElement(list, 1, "X");

        assertEquals("B", oldValue);
        assertEquals("X", list.get(1));
    }

    @Test
    @DisplayName("Ex7: Throw exception for null list")
    void testReplace_nullList() {
        assertThrows(IllegalArgumentException.class, () -> exercises.replaceElement(null, 0, "X"));
    }

    @Test
    @DisplayName("Ex7: Throw exception for index out of bounds")
    void testReplace_indexOutOfBounds() {
        List<String> list = new ArrayList<>(Arrays.asList("A", "B"));

        assertThrows(IllegalArgumentException.class, () -> exercises.replaceElement(list, 5, "X"));
    }

    // ==================== EXERCISE 8: clearList ====================

    @Test
    @DisplayName("Ex8: Clear non-empty list")
    void testClear_nonEmpty() {
        List<String> list = new ArrayList<>(Arrays.asList("A", "B", "C"));
        exercises.clearList(list);

        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
    }

    @Test
    @DisplayName("Ex8: Clear already empty list")
    void testClear_alreadyEmpty() {
        List<String> list = new ArrayList<>();
        exercises.clearList(list);

        assertTrue(list.isEmpty());
    }

    @Test
    @DisplayName("Ex8: Throw exception for null list")
    void testClear_nullList() {
        assertThrows(IllegalArgumentException.class, () -> exercises.clearList(null));
    }

    // ==================== EXERCISE 9: convertListToArray ====================

    @Test
    @DisplayName("Ex9: Convert list to array")
    void testToArray_normal() {
        List<String> list = Arrays.asList("A", "B", "C");
        String[] result = exercises.convertListToArray(list);

        assertArrayEquals(new String[]{"A", "B", "C"}, result);
    }

    @Test
    @DisplayName("Ex9: Convert empty list")
    void testToArray_empty() {
        List<String> list = new ArrayList<>();
        String[] result = exercises.convertListToArray(list);

        assertEquals(0, result.length);
    }

    @Test
    @DisplayName("Ex9: Return empty array for null list")
    void testToArray_null() {
        String[] result = exercises.convertListToArray(null);

        assertNotNull(result);
        assertEquals(0, result.length);
    }

    // ==================== EXERCISE 10: compareListPerformance ====================

    @Test
    @DisplayName("Ex10: ArrayList should be faster for random access")
    void testPerformance_arrayListFasterForGet() {
        String result = exercises.compareListPerformance();

        // ArrayList should win for get() operations
        assertEquals("ArrayList", result);
    }
}
