package com.juanpicasti.practice.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * List Exercises - ArrayList and LinkedList
 *
 * This class contains 10 progressive exercises to practice Java List methods.
 * Focus: ArrayList vs LinkedList, list operations, and performance awareness
 *
 * Difficulty progression: Easy → Medium
 */
public class ListExercises {

    // ==================== BASIC OPERATIONS ====================

    /**
     * Exercise 1: Create an ArrayList and add elements
     *
     * Key concepts:
     * - ArrayList instantiation
     * - add() method to append elements
     *
     * @param elements varargs of elements to add
     * @return an ArrayList containing all the elements
     */
    public List<String> createAndPopulateArrayList(String... elements) {
        List<String> list = new ArrayList<>();
        Collections.addAll(list, elements);
        return list;
    }

    /**
     * Exercise 2: Access element by index
     *
     * Key concepts:
     * - get() method to access elements by index
     * - Index bounds checking
     *
     * @param list the list to access
     * @param index the index to retrieve
     * @return the element at the specified index
     * @throws IllegalArgumentException if list is null or index is out of bounds
     */
    public <T> T getElementAtIndex(List<T> list, int index) {
        if (list == null || index < 0 || index >= list.size()) {
            throw new IllegalArgumentException();
        }
        return list.get(index);
    }

    /**
     * Exercise 3: Remove element from list
     *
     * Key concepts:
     * - remove(int index) - removes by index
     * - remove(Object) - removes first occurrence
     *
     * @param list the list to modify
     * @param element the element to remove
     * @return true if element was removed, false otherwise
     * @throws IllegalArgumentException if list is null
     */
    public <T> boolean removeElement(List<T> list, T element) {
        if (list == null) {
            throw new IllegalArgumentException();
        }
        return list.remove(element);
    }

    // ==================== SEARCHING ====================

    /**
     * Exercise 4: Find index of element
     *
     * Key concepts:
     * - indexOf() returns first occurrence
     * - lastIndexOf() returns last occurrence
     *
     * @param list the list to search
     * @param element the element to find
     * @return the index of first occurrence, or -1 if not found or list is null
     */
    public <T> int findFirstIndex(List<T> list, T element) {
        if (list == null) return -1;
        return list.indexOf(element);
    }

    /**
     * Exercise 5: Check if element exists in list
     *
     * Key concepts:
     * - contains() method for membership testing
     *
     * @param list the list to check
     * @param element the element to find
     * @return true if list contains element, false otherwise (or if list is null)
     */
    public <T> boolean containsElement(List<T> list, T element) {
        if (list == null) return false;
        return list.contains(element);
    }

    // ==================== MODIFICATION ====================

    /**
     * Exercise 6: Extract a sublist
     *
     * Key concepts:
     * - subList(fromIndex, toIndex) returns a view (fromIndex inclusive, toIndex exclusive)
     * - Changes to sublist affect original list
     *
     * @param list the list to extract from
     * @param fromIndex starting index (inclusive)
     * @param toIndex ending index (exclusive)
     * @return a new ArrayList containing the sublist elements
     * @throws IllegalArgumentException if list is null or indices are invalid
     */
    public <T> List<T> extractSublist(List<T> list, int fromIndex, int toIndex) {
        if (list == null || fromIndex < 0 || toIndex > list.size() || toIndex < fromIndex) throw new IllegalArgumentException();
        return list.subList(
                fromIndex,
                toIndex
        );

    }

    /**
     * Exercise 7: Replace element at specific index
     *
     * Key concepts:
     * - set(index, element) replaces element and returns old value
     *
     * @param list the list to modify
     * @param index the index to replace at
     * @param newElement the new element
     * @return the old element that was replaced
     * @throws IllegalArgumentException if list is null or index is out of bounds
     */
    public <T> T replaceElement(List<T> list, int index, T newElement) {
        if (list == null || index < 0 || index >= list.size()) {
            throw new IllegalArgumentException();
        }
        return list.set(index, newElement);
    }

    /**
     * Exercise 8: Clear all elements from list
     *
     * Key concepts:
     * - clear() removes all elements
     * - After clear(), size() should be 0 and isEmpty() should be true
     *
     * @param list the list to clear
     * @throws IllegalArgumentException if list is null
     */
    public <T> void clearList(List<T> list) {
        if (list == null) throw new IllegalArgumentException();
        list.clear();
    }

    // ==================== CONVERSIONS ====================

    /**
     * Exercise 9: Convert list to array
     *
     * Key concepts:
     * - toArray() returns Object[]
     * - toArray(T[] a) returns typed array
     *
     * @param list the list to convert
     * @return a String array containing all elements, or empty array if list is null
     */
    public String[] convertListToArray(List<String> list) {
        if (list == null) return new String[0];
        return list.toArray(
               String[]::new
        );
    }

    /**
     * Exercise 10: Compare ArrayList vs LinkedList performance
     *
     * Key concepts:
     * - ArrayList: Fast random access O(1), slow insertion/deletion in middle O(n)
     * - LinkedList: Slow random access O(n), fast insertion/deletion O(1)
     *
     * This method should:
     * 1. Create an ArrayList and LinkedList
     * 2. Add 1000 elements to both
     * 3. Access element at index 500 from both
     * 4. Return "ArrayList" if ArrayList.get() is faster, "LinkedList" if LinkedList.get() is faster
     *
     * Note: This is educational - in practice, ArrayList is almost always faster for get()
     *
     * @return "ArrayList" or "LinkedList" based on which is faster for random access
     */
    public String compareListPerformance() {
        // TODO: Implement this method
        // Hint: Use System.nanoTime() to measure performance
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 1000; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }
        long alBefore = System.nanoTime();
        Integer i = arrayList.get(500);
        long alAfter = System.nanoTime();
        long alTime = alAfter - alBefore;

        long llBefore = System.nanoTime();
        Integer j = linkedList.get(500);
        long llAfter = System.nanoTime();
        long llTime = llAfter - llBefore;
        System.out.println(llTime);

        System.out.println(alTime);
        if (llTime > alTime) {
            return "ArrayList";
        }
        return "LinkedList";
    }
}
