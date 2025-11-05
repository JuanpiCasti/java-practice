package com.juanpicasti.practice.collections;

import java.util.*;

/**
 * Advanced Collections Exercises
 *
 * This class contains 8 progressive exercises for advanced collection topics.
 * Focus: Queue, Deque, PriorityQueue, sorting, and iteration patterns
 *
 * Difficulty progression: Medium → Medium-Advanced
 */
public class AdvancedCollectionsExercises {

    // ==================== QUEUE OPERATIONS ====================

    /**
     * Exercise 1: Basic Queue operations (FIFO - First In First Out)
     *
     * Key concepts:
     * - offer(e) adds element to queue (returns false if full)
     * - poll() removes and returns head, or null if empty
     * - peek() returns head without removing, or null if empty
     *
     * Create a queue, add all elements, then return them in FIFO order
     *
     * @param elements varargs of elements to process
     * @return a list containing elements in the order they were removed from queue
     */
    public List<String> processQueue(String... elements) {
        Queue<String> q = new LinkedList<>(Arrays.asList(elements));

        List<String> result = new ArrayList<>();
        String e;
        while ((e = q.poll()) != null) {
            result.add(e);
        }
        return result;

    }

    /**
     * Exercise 2: Deque operations (Double-Ended Queue)
     *
     * Key concepts:
     * - addFirst(e) and addLast(e) add to front or back
     * - removeFirst() and removeLast() remove from front or back
     * - Can be used as Stack (LIFO) or Queue (FIFO)
     *
     * Add elements alternating between first and last positions
     *
     * @param elements varargs of elements to add
     * @return a Deque with elements added alternately (first element at first, second at last, etc.)
     */
    public Deque<String> createDeque(String... elements) {
        Deque<String> d = new ArrayDeque<>();
        for (int i = 0; i < elements.length; i++) {
            if (i % 2 == 0) {
                d.addFirst(elements[i]);
            } else {
                d.addLast(elements[i]);
            }
        }
        return d;
    }

    // ==================== PRIORITY QUEUE ====================

    /**
     * Exercise 3: PriorityQueue with natural ordering
     *
     * Key concepts:
     * - PriorityQueue is a min-heap by default (smallest element first)
     * - poll() always returns the smallest element
     * - Not FIFO - elements come out in priority order
     *
     * @param numbers varargs of integers
     * @return a list of numbers in ascending order (as they come out of PriorityQueue)
     */
    public List<Integer> sortWithPriorityQueue(Integer... numbers) {
        Queue<Integer> pq = new PriorityQueue<>(Arrays.asList(numbers));
        List<Integer> l = new ArrayList<>();
        Integer i;
        while ((i = pq.poll()) != null) {
            l.add(i);
        }
        return l;
    }

    /**
     * Exercise 4: PriorityQueue with custom Comparator (Max-Heap)
     *
     * Key concepts:
     * - Provide Comparator.reverseOrder() for max-heap
     * - poll() will return largest element first
     *
     * @param numbers varargs of integers
     * @return a list of numbers in descending order (max-heap behavior)
     */
    public List<Integer> createMaxHeap(Integer... numbers) {
        Queue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.addAll(Arrays.asList(numbers));
        List<Integer> l = new ArrayList<>();
        Integer i;
        while ((i = pq.poll()) != null) {
            l.add(i);
        }
        return l;
    }

    // ==================== SORTING ====================

    /**
     * Exercise 5: Sort list with Collections.sort() using natural ordering
     *
     * Key concepts:
     * - Collections.sort() sorts in-place
     * - Elements must implement Comparable
     *
     * @param list the list to sort (will be modified)
     * @throws IllegalArgumentException if list is null
     */
    public void sortList(List<Integer> list) {
        if (list == null) throw new IllegalArgumentException();
        Collections.sort(list);
    }

    /**
     * Exercise 6: Sort list with custom Comparator
     *
     * Key concepts:
     * - Collections.sort(list, comparator) uses custom comparison
     * - Comparator can be lambda: (a, b) -> comparison logic
     *
     * Sort strings by length (shortest first), then alphabetically if same length
     *
     * @param list the list to sort (will be modified)
     * @throws IllegalArgumentException if list is null
     */
    public void sortByLength(List<String> list) {
        if (list == null) throw new IllegalArgumentException();
        list.sort(Comparator.comparingInt(String::length).thenComparing(Comparator.naturalOrder()));
    }

    // ==================== ITERATION PATTERNS ====================

    /**
     * Exercise 7: Compare iteration methods
     *
     * Key concepts:
     * - Traditional for loop with index
     * - Enhanced for-each loop
     * - Iterator pattern
     * - forEach method with lambda
     * - Stream forEach
     *
     * Count how many elements in the list are longer than the threshold
     *
     * @param list the list to process
     * @param minLength minimum length (exclusive)
     * @return count of strings with length > minLength, or 0 if list is null
     */
    public int countLongStrings(List<String> list, int minLength) {
        if (list == null) return 0;
        return list.stream().filter(s -> s.length() > minLength).mapToInt(s -> 1).sum();
    }

    // ==================== COLLECTION CONVERSIONS ====================

    /**
     * Exercise 8: Convert between collection types
     *
     * Key concepts:
     * - List to Set removes duplicates
     * - Set to List allows indexing
     * - Constructor: new ArrayList<>(collection)
     * - Arrays.asList() creates fixed-size list
     *
     * Convert list to set (removing duplicates), then back to sorted list
     *
     * @param list the list to process (may contain duplicates)
     * @return a new sorted list with duplicates removed, or empty list if input is null
     */
    public List<String> removeDuplicatesAndSort(List<String> list) {
        if (list == null) return new ArrayList<>();
        return new ArrayList<>(new HashSet<>(list)).stream().sorted().toList();
    }
}
