package com.juanpicasti.practice.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Collection;

/**
 * Map Exercises - HashMap and TreeMap
 *
 * This class contains 10 progressive exercises to practice Java Map methods.
 * Focus: HashMap vs TreeMap, key-value operations, ordering
 *
 * Difficulty progression: Easy → Medium
 */
public class MapExercises {

    // ==================== BASIC OPERATIONS ====================

    /**
     * Exercise 1: Create HashMap and put key-value pairs
     *
     * Key concepts:
     * - HashMap stores key-value pairs
     * - put(key, value) adds or updates entry
     * - Keys must be unique
     *
     * @param keys array of keys
     * @param values array of values
     * @return a HashMap with the key-value pairs
     * @throws IllegalArgumentException if arrays are null or have different lengths
     */
    public Map<String, Integer> createHashMap(String[] keys, Integer[] values) {
        // TODO: Implement this method
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Exercise 2: Get value by key
     *
     * Key concepts:
     * - get(key) returns value or null if key doesn't exist
     * - getOrDefault(key, defaultValue) returns default if key absent
     *
     * @param map the map to search
     * @param key the key to look up
     * @param defaultValue value to return if key not found
     * @return the value associated with key, or defaultValue if key absent or map is null
     */
    public <K, V> V getValueOrDefault(Map<K, V> map, K key, V defaultValue) {
        // TODO: Implement this method
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Exercise 3: Check if key exists
     *
     * Key concepts:
     * - containsKey() checks for key presence
     * - Useful before calling get() to distinguish null value from absent key
     *
     * @param map the map to check
     * @param key the key to find
     * @return true if map contains key, false otherwise (or if map is null)
     */
    public <K, V> boolean hasKey(Map<K, V> map, K key) {
        // TODO: Implement this method
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Exercise 4: Check if value exists
     *
     * Key concepts:
     * - containsValue() checks for value presence
     * - Slower than containsKey() - O(n) vs O(1) for HashMap
     *
     * @param map the map to check
     * @param value the value to find
     * @return true if map contains value, false otherwise (or if map is null)
     */
    public <K, V> boolean hasValue(Map<K, V> map, V value) {
        // TODO: Implement this method
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Exercise 5: Remove key-value pair
     *
     * Key concepts:
     * - remove(key) removes entry and returns old value (or null if absent)
     *
     * @param map the map to modify
     * @param key the key to remove
     * @return the value that was removed, or null if key wasn't present
     * @throws IllegalArgumentException if map is null
     */
    public <K, V> V removeKey(Map<K, V> map, K key) {
        // TODO: Implement this method
        throw new UnsupportedOperationException("Not implemented yet");
    }

    // ==================== ITERATION ====================

    /**
     * Exercise 6: Get all keys from map
     *
     * Key concepts:
     * - keySet() returns a Set view of keys
     * - Changes to keySet affect the map
     *
     * @param map the map to extract keys from
     * @return a Set containing all keys, or empty set if map is null
     */
    public <K, V> Set<K> getAllKeys(Map<K, V> map) {
        // TODO: Implement this method
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Exercise 7: Get all values from map
     *
     * Key concepts:
     * - values() returns a Collection view of values
     * - Collection (not Set) because values can have duplicates
     *
     * @param map the map to extract values from
     * @return a Collection containing all values, or empty collection if map is null
     */
    public <K, V> Collection<V> getAllValues(Map<K, V> map) {
        // TODO: Implement this method
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Exercise 8: Count entries matching a condition
     *
     * Key concepts:
     * - entrySet() returns Set of Map.Entry<K,V> for efficient iteration
     * - Map.Entry has getKey() and getValue() methods
     *
     * Count how many entries have values greater than the threshold
     *
     * @param map the map to search
     * @param threshold the minimum value (exclusive)
     * @return count of entries where value > threshold, or 0 if map is null
     */
    public int countEntriesAboveThreshold(Map<String, Integer> map, int threshold) {
        // TODO: Implement this method
        // Hint: Use entrySet() and iterate through entries
        throw new UnsupportedOperationException("Not implemented yet");
    }

    // ==================== TREEMAP & ORDERING ====================

    /**
     * Exercise 9: Create TreeMap with sorted keys
     *
     * Key concepts:
     * - TreeMap maintains keys in sorted order
     * - Iteration over keySet(), values(), or entrySet() is in key order
     *
     * @param keys array of keys
     * @param values array of values
     * @return a TreeMap with keys in natural sorted order
     * @throws IllegalArgumentException if arrays are null or have different lengths
     */
    public Map<String, Integer> createSortedMap(String[] keys, Integer[] values) {
        // TODO: Implement this method
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Exercise 10: Use TreeMap special methods
     *
     * Key concepts:
     * - TreeMap has NavigableMap methods: firstKey(), lastKey(), floorKey(), ceilingKey()
     * - firstKey() returns smallest key
     * - lastKey() returns largest key
     *
     * @param map a TreeMap of integers to strings
     * @return a String in format "first:X,last:Y" where X is the smallest key and Y is the largest
     * @throws IllegalArgumentException if map is null or empty
     */
    public String getFirstAndLastKey(TreeMap<Integer, String> map) {
        // TODO: Implement this method
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
