package com.juanpicasti.practice.collections;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Set Exercises - HashSet and TreeSet
 *
 * This class contains 10 progressive exercises to practice Java Set methods.
 * Focus: HashSet vs TreeSet, unique elements, set operations
 *
 * Difficulty progression: Easy → Medium
 */
public class SetExercises {

    // ==================== BASIC OPERATIONS ====================

    /**
     * Exercise 1: Create a HashSet and add unique elements
     *
     * Key concepts:
     * - HashSet maintains unique elements (no duplicates)
     * - add() returns true if element was added, false if already present
     *
     * @param elements varargs of elements to add
     * @return a HashSet containing unique elements
     */
    public Set<String> createHashSet(String... elements) {
        // TODO: Implement this method
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Exercise 2: Demonstrate that HashSet prevents duplicates
     *
     * Key concepts:
     * - Adding duplicate elements returns false
     * - Set size doesn't increase for duplicates
     *
     * @param set the set to modify
     * @param element the element to add
     * @return true if element was newly added, false if it was already present
     * @throws IllegalArgumentException if set is null
     */
    public <T> boolean addElementToSet(Set<T> set, T element) {
        // TODO: Implement this method
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Exercise 3: Check if set contains an element
     *
     * Key concepts:
     * - contains() for membership testing
     * - HashSet: O(1) average time complexity
     *
     * @param set the set to check
     * @param element the element to find
     * @return true if set contains element, false otherwise (or if set is null)
     */
    public <T> boolean containsElement(Set<T> set, T element) {
        // TODO: Implement this method
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Exercise 4: Remove element from set
     *
     * Key concepts:
     * - remove() returns true if element was present and removed
     *
     * @param set the set to modify
     * @param element the element to remove
     * @return true if element was removed, false if not present
     * @throws IllegalArgumentException if set is null
     */
    public <T> boolean removeElement(Set<T> set, T element) {
        // TODO: Implement this method
        throw new UnsupportedOperationException("Not implemented yet");
    }

    // ==================== TREESET & ORDERING ====================

    /**
     * Exercise 5: Create TreeSet with natural ordering
     *
     * Key concepts:
     * - TreeSet maintains sorted order automatically
     * - Elements must implement Comparable or provide Comparator
     * - Iteration returns elements in sorted order
     *
     * @param elements varargs of integers to add
     * @return a TreeSet containing elements in sorted (ascending) order
     */
    public Set<Integer> createSortedSet(Integer... elements) {
        // TODO: Implement this method
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Exercise 6: Create TreeSet with custom Comparator
     *
     * Key concepts:
     * - TreeSet can use custom Comparator for ordering
     * - Useful for reverse order or custom sorting logic
     *
     * @param elements varargs of strings to add
     * @return a TreeSet sorted in reverse alphabetical order (Z to A)
     */
    public Set<String> createReverseOrderSet(String... elements) {
        // TODO: Implement this method
        // Hint: Use Comparator.reverseOrder() or (a, b) -> b.compareTo(a)
        throw new UnsupportedOperationException("Not implemented yet");
    }

    // ==================== SET OPERATIONS ====================

    /**
     * Exercise 7: Find intersection of two sets (common elements)
     *
     * Key concepts:
     * - retainAll() modifies the set to keep only common elements
     * - Creates new set to avoid modifying originals
     *
     * @param set1 first set
     * @param set2 second set
     * @return a new set containing only elements present in both sets
     * @throws IllegalArgumentException if either set is null
     */
    public <T> Set<T> findIntersection(Set<T> set1, Set<T> set2) {
        // TODO: Implement this method
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Exercise 8: Find union of two sets (all elements)
     *
     * Key concepts:
     * - addAll() adds all elements from another collection
     * - Duplicates are automatically handled (sets don't allow duplicates)
     *
     * @param set1 first set
     * @param set2 second set
     * @return a new set containing all elements from both sets (no duplicates)
     * @throws IllegalArgumentException if either set is null
     */
    public <T> Set<T> findUnion(Set<T> set1, Set<T> set2) {
        // TODO: Implement this method
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Exercise 9: Find difference of two sets (elements in set1 but not in set2)
     *
     * Key concepts:
     * - removeAll() removes all elements that are in another collection
     * - Creates new set to avoid modifying originals
     *
     * @param set1 first set
     * @param set2 second set
     * @return a new set containing elements in set1 but not in set2
     * @throws IllegalArgumentException if either set is null
     */
    public <T> Set<T> findDifference(Set<T> set1, Set<T> set2) {
        // TODO: Implement this method
        throw new UnsupportedOperationException("Not implemented yet");
    }

    // ==================== NULL HANDLING ====================

    /**
     * Exercise 10: Demonstrate null handling differences
     *
     * Key concepts:
     * - HashSet allows one null element
     * - TreeSet with natural ordering throws NullPointerException for null
     * - TreeSet with null-safe Comparator can handle null
     *
     * @param useHashSet if true, use HashSet; if false, use TreeSet with null-safe comparator
     * @return a set that contains a null element
     */
    public Set<String> createSetWithNull(boolean useHashSet) {
        // TODO: Implement this method
        // For TreeSet, use Comparator.nullsFirst(Comparator.naturalOrder())
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
