package com.juanpicasti.practice.collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Map Exercises Test Suite")
class MapExercisesTest {

    private MapExercises exercises;

    @BeforeEach
    void setUp() {
        exercises = new MapExercises();
    }

    // ==================== EXERCISE 1: createHashMap ====================

    @Test
    @DisplayName("Ex1: Create HashMap with key-value pairs")
    void testCreateHashMap_normal() {
        String[] keys = {"A", "B", "C"};
        Integer[] values = {1, 2, 3};

        Map<String, Integer> result = exercises.createHashMap(keys, values);

        assertEquals(3, result.size());
        assertTrue(result instanceof HashMap);
        assertEquals(1, result.get("A"));
        assertEquals(2, result.get("B"));
        assertEquals(3, result.get("C"));
    }

    @Test
    @DisplayName("Ex1: Create empty HashMap")
    void testCreateHashMap_empty() {
        String[] keys = {};
        Integer[] values = {};

        Map<String, Integer> result = exercises.createHashMap(keys, values);

        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("Ex1: Throw exception for null arrays")
    void testCreateHashMap_nullArrays() {
        assertThrows(IllegalArgumentException.class, () ->
            exercises.createHashMap(null, new Integer[]{1, 2}));
        assertThrows(IllegalArgumentException.class, () ->
            exercises.createHashMap(new String[]{"A", "B"}, null));
    }

    @Test
    @DisplayName("Ex1: Throw exception for different length arrays")
    void testCreateHashMap_differentLengths() {
        String[] keys = {"A", "B"};
        Integer[] values = {1, 2, 3};

        assertThrows(IllegalArgumentException.class, () ->
            exercises.createHashMap(keys, values));
    }

    // ==================== EXERCISE 2: getValueOrDefault ====================

    @Test
    @DisplayName("Ex2: Get existing value")
    void testGetOrDefault_exists() {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 2);

        assertEquals(1, exercises.getValueOrDefault(map, "A", 999));
    }

    @Test
    @DisplayName("Ex2: Get default for non-existing key")
    void testGetOrDefault_notExists() {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 1);

        assertEquals(999, exercises.getValueOrDefault(map, "Z", 999));
    }

    @Test
    @DisplayName("Ex2: Return default for null map")
    void testGetOrDefault_nullMap() {
        assertEquals(999, exercises.getValueOrDefault(null, "A", 999));
    }

    // ==================== EXERCISE 3: hasKey ====================

    @Test
    @DisplayName("Ex3: Key exists in map")
    void testHasKey_exists() {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 1);

        assertTrue(exercises.hasKey(map, "A"));
    }

    @Test
    @DisplayName("Ex3: Key does not exist")
    void testHasKey_notExists() {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 1);

        assertFalse(exercises.hasKey(map, "Z"));
    }

    @Test
    @DisplayName("Ex3: Return false for null map")
    void testHasKey_nullMap() {
        assertFalse(exercises.hasKey(null, "A"));
    }

    // ==================== EXERCISE 4: hasValue ====================

    @Test
    @DisplayName("Ex4: Value exists in map")
    void testHasValue_exists() {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 2);

        assertTrue(exercises.hasValue(map, 1));
    }

    @Test
    @DisplayName("Ex4: Value does not exist")
    void testHasValue_notExists() {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 1);

        assertFalse(exercises.hasValue(map, 999));
    }

    @Test
    @DisplayName("Ex4: Return false for null map")
    void testHasValue_nullMap() {
        assertFalse(exercises.hasValue(null, 1));
    }

    // ==================== EXERCISE 5: removeKey ====================

    @Test
    @DisplayName("Ex5: Remove existing key")
    void testRemove_exists() {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 2);

        Integer result = exercises.removeKey(map, "A");

        assertEquals(1, result);
        assertEquals(1, map.size());
        assertFalse(map.containsKey("A"));
    }

    @Test
    @DisplayName("Ex5: Remove non-existing key returns null")
    void testRemove_notExists() {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 1);

        Integer result = exercises.removeKey(map, "Z");

        assertNull(result);
        assertEquals(1, map.size());
    }

    @Test
    @DisplayName("Ex5: Throw exception for null map")
    void testRemove_nullMap() {
        assertThrows(IllegalArgumentException.class, () ->
            exercises.removeKey(null, "A"));
    }

    // ==================== EXERCISE 6: getAllKeys ====================

    @Test
    @DisplayName("Ex6: Get all keys from map")
    void testGetKeys_normal() {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);

        Set<String> result = exercises.getAllKeys(map);

        assertEquals(3, result.size());
        assertTrue(result.containsAll(Arrays.asList("A", "B", "C")));
    }

    @Test
    @DisplayName("Ex6: Return empty set for null map")
    void testGetKeys_nullMap() {
        Set<String> result = exercises.getAllKeys(null);

        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    // ==================== EXERCISE 7: getAllValues ====================

    @Test
    @DisplayName("Ex7: Get all values from map")
    void testGetValues_normal() {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 2); // duplicate value

        Collection<Integer> result = exercises.getAllValues(map);

        assertEquals(3, result.size());
        assertTrue(result.containsAll(Arrays.asList(1, 2)));
    }

    @Test
    @DisplayName("Ex7: Return empty collection for null map")
    void testGetValues_nullMap() {
        Collection<Integer> result = exercises.getAllValues(null);

        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    // ==================== EXERCISE 8: countEntriesAboveThreshold ====================

    @Test
    @DisplayName("Ex8: Count entries above threshold")
    void testCountAbove_normal() {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 5);
        map.put("B", 10);
        map.put("C", 15);
        map.put("D", 8);

        int result = exercises.countEntriesAboveThreshold(map, 7);

        assertEquals(3, result); // B=10, C=15, D=8
    }

    @Test
    @DisplayName("Ex8: Count with no entries above threshold")
    void testCountAbove_none() {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 2);

        int result = exercises.countEntriesAboveThreshold(map, 100);

        assertEquals(0, result);
    }

    @Test
    @DisplayName("Ex8: Return 0 for null map")
    void testCountAbove_nullMap() {
        assertEquals(0, exercises.countEntriesAboveThreshold(null, 5));
    }

    // ==================== EXERCISE 9: createSortedMap ====================

    @Test
    @DisplayName("Ex9: TreeMap maintains key order")
    void testTreeMap_sorted() {
        String[] keys = {"C", "A", "B"};
        Integer[] values = {3, 1, 2};

        Map<String, Integer> result = exercises.createSortedMap(keys, values);

        assertTrue(result instanceof TreeMap);
        assertEquals(3, result.size());

        // Check order
        List<String> keyList = new ArrayList<>(result.keySet());
        assertEquals(Arrays.asList("A", "B", "C"), keyList);
    }

    @Test
    @DisplayName("Ex9: Throw exception for null arrays")
    void testTreeMap_nullArrays() {
        assertThrows(IllegalArgumentException.class, () ->
            exercises.createSortedMap(null, new Integer[]{1, 2}));
    }

    // ==================== EXERCISE 10: getFirstAndLastKey ====================

    @Test
    @DisplayName("Ex10: Get first and last key from TreeMap")
    void testFirstLast_normal() {
        TreeMap<Integer, String> map = new TreeMap<>();
        map.put(5, "Five");
        map.put(1, "One");
        map.put(9, "Nine");
        map.put(3, "Three");

        String result = exercises.getFirstAndLastKey(map);

        assertEquals("first:1,last:9", result);
    }

    @Test
    @DisplayName("Ex10: Single entry map")
    void testFirstLast_single() {
        TreeMap<Integer, String> map = new TreeMap<>();
        map.put(5, "Five");

        String result = exercises.getFirstAndLastKey(map);

        assertEquals("first:5,last:5", result);
    }

    @Test
    @DisplayName("Ex10: Throw exception for null map")
    void testFirstLast_nullMap() {
        assertThrows(IllegalArgumentException.class, () ->
            exercises.getFirstAndLastKey(null));
    }

    @Test
    @DisplayName("Ex10: Throw exception for empty map")
    void testFirstLast_emptyMap() {
        assertThrows(IllegalArgumentException.class, () ->
            exercises.getFirstAndLastKey(new TreeMap<>()));
    }
}
