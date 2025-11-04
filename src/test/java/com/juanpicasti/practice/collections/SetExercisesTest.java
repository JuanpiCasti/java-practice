package com.juanpicasti.practice.collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Set Exercises Test Suite")
class SetExercisesTest {

    private SetExercises exercises;

    @BeforeEach
    void setUp() {
        exercises = new SetExercises();
    }

    // ==================== EXERCISE 1: createHashSet ====================

    @Test
    @DisplayName("Ex1: Create HashSet with elements")
    void testCreateHashSet_withElements() {
        Set<String> result = exercises.createHashSet("A", "B", "C");

        assertEquals(3, result.size());
        assertTrue(result instanceof HashSet);
        assertTrue(result.contains("A"));
        assertTrue(result.contains("B"));
        assertTrue(result.contains("C"));
    }

    @Test
    @DisplayName("Ex1: Create empty HashSet")
    void testCreateHashSet_empty() {
        Set<String> result = exercises.createHashSet();

        assertEquals(0, result.size());
        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("Ex1: HashSet removes duplicates")
    void testCreateHashSet_duplicates() {
        Set<String> result = exercises.createHashSet("A", "B", "A", "C", "B");

        assertEquals(3, result.size());
    }

    // ==================== EXERCISE 2: addElementToSet ====================

    @Test
    @DisplayName("Ex2: Add new element returns true")
    void testAddElement_new() {
        Set<String> set = new HashSet<>();

        assertTrue(exercises.addElementToSet(set, "A"));
        assertEquals(1, set.size());
    }

    @Test
    @DisplayName("Ex2: Add duplicate element returns false")
    void testAddElement_duplicate() {
        Set<String> set = new HashSet<>();
        set.add("A");

        assertFalse(exercises.addElementToSet(set, "A"));
        assertEquals(1, set.size());
    }

    @Test
    @DisplayName("Ex2: Throw exception for null set")
    void testAddElement_nullSet() {
        assertThrows(IllegalArgumentException.class, () -> exercises.addElementToSet(null, "A"));
    }

    // ==================== EXERCISE 3: containsElement ====================

    @Test
    @DisplayName("Ex3: Element exists in set")
    void testContains_exists() {
        Set<String> set = new HashSet<>(Arrays.asList("A", "B", "C"));

        assertTrue(exercises.containsElement(set, "B"));
    }

    @Test
    @DisplayName("Ex3: Element does not exist")
    void testContains_notExists() {
        Set<String> set = new HashSet<>(Arrays.asList("A", "B", "C"));

        assertFalse(exercises.containsElement(set, "Z"));
    }

    @Test
    @DisplayName("Ex3: Return false for null set")
    void testContains_nullSet() {
        assertFalse(exercises.containsElement(null, "A"));
    }

    // ==================== EXERCISE 4: removeElement ====================

    @Test
    @DisplayName("Ex4: Remove existing element returns true")
    void testRemove_exists() {
        Set<String> set = new HashSet<>(Arrays.asList("A", "B", "C"));

        assertTrue(exercises.removeElement(set, "B"));
        assertEquals(2, set.size());
        assertFalse(set.contains("B"));
    }

    @Test
    @DisplayName("Ex4: Remove non-existing element returns false")
    void testRemove_notExists() {
        Set<String> set = new HashSet<>(Arrays.asList("A", "B", "C"));

        assertFalse(exercises.removeElement(set, "Z"));
        assertEquals(3, set.size());
    }

    @Test
    @DisplayName("Ex4: Throw exception for null set")
    void testRemove_nullSet() {
        assertThrows(IllegalArgumentException.class, () -> exercises.removeElement(null, "A"));
    }

    // ==================== EXERCISE 5: createSortedSet ====================

    @Test
    @DisplayName("Ex5: TreeSet maintains sorted order")
    void testTreeSet_sorted() {
        Set<Integer> result = exercises.createSortedSet(5, 2, 8, 1, 9);

        assertTrue(result instanceof TreeSet);
        assertEquals(5, result.size());

        // Convert to list to check order
        List<Integer> list = new ArrayList<>(result);
        assertEquals(Arrays.asList(1, 2, 5, 8, 9), list);
    }

    @Test
    @DisplayName("Ex5: TreeSet removes duplicates")
    void testTreeSet_duplicates() {
        Set<Integer> result = exercises.createSortedSet(5, 2, 5, 1, 2);

        assertEquals(3, result.size());
        List<Integer> list = new ArrayList<>(result);
        assertEquals(Arrays.asList(1, 2, 5), list);
    }

    @Test
    @DisplayName("Ex5: Empty TreeSet")
    void testTreeSet_empty() {
        Set<Integer> result = exercises.createSortedSet();

        assertTrue(result.isEmpty());
    }

    // ==================== EXERCISE 6: createReverseOrderSet ====================

    @Test
    @DisplayName("Ex6: TreeSet with reverse order")
    void testReverseOrderSet_sorted() {
        Set<String> result = exercises.createReverseOrderSet("Apple", "Banana", "Cherry");

        assertTrue(result instanceof TreeSet);
        List<String> list = new ArrayList<>(result);
        assertEquals(Arrays.asList("Cherry", "Banana", "Apple"), list);
    }

    @Test
    @DisplayName("Ex6: Reverse order with duplicates")
    void testReverseOrderSet_duplicates() {
        Set<String> result = exercises.createReverseOrderSet("C", "A", "B", "A", "C");

        assertEquals(3, result.size());
        List<String> list = new ArrayList<>(result);
        assertEquals(Arrays.asList("C", "B", "A"), list);
    }

    // ==================== EXERCISE 7: findIntersection ====================

    @Test
    @DisplayName("Ex7: Find intersection of two sets")
    void testIntersection_normal() {
        Set<String> set1 = new HashSet<>(Arrays.asList("A", "B", "C", "D"));
        Set<String> set2 = new HashSet<>(Arrays.asList("C", "D", "E", "F"));

        Set<String> result = exercises.findIntersection(set1, set2);

        assertEquals(2, result.size());
        assertTrue(result.contains("C"));
        assertTrue(result.contains("D"));
    }

    @Test
    @DisplayName("Ex7: Intersection with no common elements")
    void testIntersection_noCommon() {
        Set<String> set1 = new HashSet<>(Arrays.asList("A", "B"));
        Set<String> set2 = new HashSet<>(Arrays.asList("C", "D"));

        Set<String> result = exercises.findIntersection(set1, set2);

        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("Ex7: Throw exception for null sets")
    void testIntersection_nullSets() {
        Set<String> set = new HashSet<>();

        assertThrows(IllegalArgumentException.class, () -> exercises.findIntersection(null, set));
        assertThrows(IllegalArgumentException.class, () -> exercises.findIntersection(set, null));
    }

    // ==================== EXERCISE 8: findUnion ====================

    @Test
    @DisplayName("Ex8: Find union of two sets")
    void testUnion_normal() {
        Set<String> set1 = new HashSet<>(Arrays.asList("A", "B", "C"));
        Set<String> set2 = new HashSet<>(Arrays.asList("C", "D", "E"));

        Set<String> result = exercises.findUnion(set1, set2);

        assertEquals(5, result.size());
        assertTrue(result.containsAll(Arrays.asList("A", "B", "C", "D", "E")));
    }

    @Test
    @DisplayName("Ex8: Union with empty set")
    void testUnion_oneEmpty() {
        Set<String> set1 = new HashSet<>(Arrays.asList("A", "B"));
        Set<String> set2 = new HashSet<>();

        Set<String> result = exercises.findUnion(set1, set2);

        assertEquals(2, result.size());
        assertTrue(result.containsAll(Arrays.asList("A", "B")));
    }

    @Test
    @DisplayName("Ex8: Throw exception for null sets")
    void testUnion_nullSets() {
        Set<String> set = new HashSet<>();

        assertThrows(IllegalArgumentException.class, () -> exercises.findUnion(null, set));
        assertThrows(IllegalArgumentException.class, () -> exercises.findUnion(set, null));
    }

    // ==================== EXERCISE 9: findDifference ====================

    @Test
    @DisplayName("Ex9: Find difference of two sets")
    void testDifference_normal() {
        Set<String> set1 = new HashSet<>(Arrays.asList("A", "B", "C", "D"));
        Set<String> set2 = new HashSet<>(Arrays.asList("C", "D", "E"));

        Set<String> result = exercises.findDifference(set1, set2);

        assertEquals(2, result.size());
        assertTrue(result.contains("A"));
        assertTrue(result.contains("B"));
        assertFalse(result.contains("C"));
        assertFalse(result.contains("D"));
    }

    @Test
    @DisplayName("Ex9: Difference with no overlap")
    void testDifference_noOverlap() {
        Set<String> set1 = new HashSet<>(Arrays.asList("A", "B"));
        Set<String> set2 = new HashSet<>(Arrays.asList("C", "D"));

        Set<String> result = exercises.findDifference(set1, set2);

        assertEquals(2, result.size());
        assertTrue(result.containsAll(Arrays.asList("A", "B")));
    }

    @Test
    @DisplayName("Ex9: Throw exception for null sets")
    void testDifference_nullSets() {
        Set<String> set = new HashSet<>();

        assertThrows(IllegalArgumentException.class, () -> exercises.findDifference(null, set));
        assertThrows(IllegalArgumentException.class, () -> exercises.findDifference(set, null));
    }

    // ==================== EXERCISE 10: createSetWithNull ====================

    @Test
    @DisplayName("Ex10: HashSet allows null")
    void testNullHandling_hashSet() {
        Set<String> result = exercises.createSetWithNull(true);

        assertTrue(result instanceof HashSet);
        assertTrue(result.contains(null));
    }

    @Test
    @DisplayName("Ex10: TreeSet with null-safe comparator")
    void testNullHandling_treeSet() {
        Set<String> result = exercises.createSetWithNull(false);

        assertTrue(result instanceof TreeSet);
        assertTrue(result.contains(null));
    }
}
