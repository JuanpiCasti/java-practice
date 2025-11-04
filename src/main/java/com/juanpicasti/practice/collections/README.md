# Java Collections Framework Practice

Comprehensive exercises to master Java Collections: Lists, Sets, Maps, and advanced collections.

---

## Quick Start

### Run All Collections Tests
```bash
mvn test -Dtest="*collections*"
```

### Run Individual Test Classes
```bash
mvn test -Dtest=ListExercisesTest
mvn test -Dtest=SetExercisesTest
mvn test -Dtest=MapExercisesTest
mvn test -Dtest=AdvancedCollectionsExercisesTest
```

---

## Exercises Overview

### 📋 ListExercises (10 exercises)
Practice ArrayList and LinkedList operations

| # | Method | Difficulty | Key Concepts |
|---|--------|-----------|-------------|
| 1 | `createAndPopulateArrayList` | ⭐ | ArrayList creation, add() |
| 2 | `getElementAtIndex` | ⭐ | get(), index validation |
| 3 | `removeElement` | ⭐⭐ | remove(), boolean return |
| 4 | `findFirstIndex` | ⭐⭐ | indexOf() |
| 5 | `containsElement` | ⭐ | contains() |
| 6 | `extractSublist` | ⭐⭐ | subList() |
| 7 | `replaceElement` | ⭐⭐ | set() |
| 8 | `clearList` | ⭐ | clear() |
| 9 | `convertListToArray` | ⭐⭐ | toArray() |
| 10 | `compareListPerformance` | ⭐⭐⭐ | ArrayList vs LinkedList |

### 🔢 SetExercises (10 exercises)
Practice HashSet and TreeSet operations

| # | Method | Difficulty | Key Concepts |
|---|--------|-----------|-------------|
| 1 | `createHashSet` | ⭐ | HashSet creation |
| 2 | `addElementToSet` | ⭐ | add(), duplicate handling |
| 3 | `containsElement` | ⭐ | contains() |
| 4 | `removeElement` | ⭐ | remove() |
| 5 | `createSortedSet` | ⭐⭐ | TreeSet, natural ordering |
| 6 | `createReverseOrderSet` | ⭐⭐⭐ | TreeSet with Comparator |
| 7 | `findIntersection` | ⭐⭐ | retainAll() |
| 8 | `findUnion` | ⭐⭐ | addAll() |
| 9 | `findDifference` | ⭐⭐ | removeAll() |
| 10 | `createSetWithNull` | ⭐⭐⭐ | Null handling differences |

### 🗺️ MapExercises (10 exercises)
Practice HashMap and TreeMap operations

| # | Method | Difficulty | Key Concepts |
|---|--------|-----------|-------------|
| 1 | `createHashMap` | ⭐ | HashMap creation, put() |
| 2 | `getValueOrDefault` | ⭐ | get(), getOrDefault() |
| 3 | `hasKey` | ⭐ | containsKey() |
| 4 | `hasValue` | ⭐ | containsValue() |
| 5 | `removeKey` | ⭐ | remove() |
| 6 | `getAllKeys` | ⭐⭐ | keySet() |
| 7 | `getAllValues` | ⭐⭐ | values() |
| 8 | `countEntriesAboveThreshold` | ⭐⭐⭐ | entrySet(), iteration |
| 9 | `createSortedMap` | ⭐⭐ | TreeMap ordering |
| 10 | `getFirstAndLastKey` | ⭐⭐⭐ | TreeMap special methods |

### 🚀 AdvancedCollectionsExercises (8 exercises)
Practice Queue, Deque, PriorityQueue, sorting, and iteration

| # | Method | Difficulty | Key Concepts |
|---|--------|-----------|-------------|
| 1 | `processQueue` | ⭐⭐ | Queue FIFO, offer/poll |
| 2 | `createDeque` | ⭐⭐ | Deque, addFirst/addLast |
| 3 | `sortWithPriorityQueue` | ⭐⭐ | PriorityQueue min-heap |
| 4 | `createMaxHeap` | ⭐⭐⭐ | PriorityQueue with Comparator |
| 5 | `sortList` | ⭐⭐ | Collections.sort() |
| 6 | `sortByLength` | ⭐⭐⭐ | Custom Comparator |
| 7 | `countLongStrings` | ⭐⭐ | Iteration patterns |
| 8 | `removeDuplicatesAndSort` | ⭐⭐⭐ | Collection conversions |

**Total: 38 exercises with 120+ test cases**

---

## Java Collections Framework Reference

### 🏗️ Collection Hierarchy

```
Collection (interface)
├── List (interface)
│   ├── ArrayList (class)
│   └── LinkedList (class)
├── Set (interface)
│   ├── HashSet (class)
│   └── TreeSet (class)
└── Queue (interface)
    ├── LinkedList (class)
    ├── PriorityQueue (class)
    └── Deque (interface)
        └── ArrayDeque (class)

Map (interface)
├── HashMap (class)
└── TreeMap (class)
```

---

## 📋 List Interface

### ArrayList vs LinkedList

| Feature | ArrayList | LinkedList |
|---------|-----------|------------|
| **Implementation** | Dynamic array | Doubly-linked list |
| **Random access (get)** | O(1) - Fast | O(n) - Slow |
| **Add at end** | O(1) amortized | O(1) |
| **Add/remove at index** | O(n) | O(n) |
| **Add/remove at start** | O(n) | O(1) |
| **Memory** | Compact | More overhead (node pointers) |
| **Best for** | Random access, iteration | Frequent insertion/deletion at ends |

### Common List Methods

#### Adding Elements
```java
List<String> list = new ArrayList<>();
list.add("Apple");                    // Add to end
list.add(0, "Banana");               // Add at index
list.addAll(Arrays.asList("C", "D")); // Add all from collection
```

#### Accessing Elements
```java
String first = list.get(0);           // Get by index
int index = list.indexOf("Apple");    // Find index (or -1)
int lastIdx = list.lastIndexOf("A");  // Find last occurrence
boolean has = list.contains("Apple"); // Check membership
```

#### Modifying Elements
```java
list.set(0, "Apricot");              // Replace at index
list.remove(0);                      // Remove by index
list.remove("Apple");                // Remove by object
list.clear();                        // Remove all
```

#### List Operations
```java
List<String> sub = list.subList(0, 2);  // Get view [0,2)
int size = list.size();                 // Get size
boolean empty = list.isEmpty();         // Check if empty
```

#### Conversions
```java
String[] array = list.toArray(new String[0]);  // List to array
List<String> list2 = Arrays.asList("A", "B");  // Array to list (fixed-size)
List<String> list3 = new ArrayList<>(list);    // Copy constructor
```

---

## 🔢 Set Interface

### HashSet vs TreeSet

| Feature | HashSet | TreeSet |
|---------|---------|---------|
| **Implementation** | Hash table | Red-Black tree |
| **Ordering** | No order | Sorted (ascending) |
| **Add/Remove/Contains** | O(1) average | O(log n) |
| **Null elements** | Allows one null | No null (with natural ordering) |
| **Best for** | Fast lookup, no ordering needed | Sorted iteration |

### Common Set Methods

#### Creating Sets
```java
Set<String> hashSet = new HashSet<>();
Set<Integer> treeSet = new TreeSet<>();
Set<String> reverseSet = new TreeSet<>(Comparator.reverseOrder());
```

#### Adding/Removing
```java
boolean added = set.add("Apple");     // Returns false if already present
boolean removed = set.remove("Apple"); // Returns false if not present
set.clear();                          // Remove all
```

#### Checking Membership
```java
boolean has = set.contains("Apple");
int size = set.size();
boolean empty = set.isEmpty();
```

#### Set Operations
```java
Set<String> set1 = new HashSet<>(Arrays.asList("A", "B", "C"));
Set<String> set2 = new HashSet<>(Arrays.asList("B", "C", "D"));

// Union (all elements from both sets)
Set<String> union = new HashSet<>(set1);
union.addAll(set2);  // {A, B, C, D}

// Intersection (common elements)
Set<String> intersection = new HashSet<>(set1);
intersection.retainAll(set2);  // {B, C}

// Difference (elements in set1 but not in set2)
Set<String> difference = new HashSet<>(set1);
difference.removeAll(set2);  // {A}
```

---

## 🗺️ Map Interface

### HashMap vs TreeMap

| Feature | HashMap | TreeMap |
|---------|---------|---------|
| **Implementation** | Hash table | Red-Black tree |
| **Key ordering** | No order | Sorted by key |
| **Get/Put/Remove** | O(1) average | O(log n) |
| **Null keys** | Allows one null key | No null key (with natural ordering) |
| **Null values** | Allows null values | Allows null values |
| **Best for** | Fast lookup | Sorted key iteration |

### Common Map Methods

#### Creating Maps
```java
Map<String, Integer> hashMap = new HashMap<>();
Map<String, Integer> treeMap = new TreeMap<>();
```

#### Adding/Updating
```java
map.put("Apple", 1);                    // Add or update
map.putIfAbsent("Banana", 2);          // Add only if key absent
Integer old = map.put("Apple", 10);    // Returns old value (or null)
```

#### Accessing
```java
Integer value = map.get("Apple");               // Get value (or null)
Integer value2 = map.getOrDefault("X", 0);     // Get or default
boolean hasKey = map.containsKey("Apple");      // Check key
boolean hasValue = map.containsValue(1);        // Check value
```

#### Removing
```java
Integer removed = map.remove("Apple");  // Remove and return value
map.clear();                           // Remove all
```

#### Iteration
```java
// Iterate over keys
for (String key : map.keySet()) {
    System.out.println(key);
}

// Iterate over values
for (Integer value : map.values()) {
    System.out.println(value);
}

// Iterate over entries (most efficient)
for (Map.Entry<String, Integer> entry : map.entrySet()) {
    String key = entry.getKey();
    Integer value = entry.getValue();
}
```

#### TreeMap Special Methods
```java
TreeMap<Integer, String> treeMap = new TreeMap<>();
treeMap.put(1, "One");
treeMap.put(5, "Five");
treeMap.put(3, "Three");

Integer firstKey = treeMap.firstKey();        // 1
Integer lastKey = treeMap.lastKey();          // 5
Integer floor = treeMap.floorKey(4);          // 3 (≤ 4)
Integer ceiling = treeMap.ceilingKey(4);      // 5 (≥ 4)
```

---

## 🚀 Queue and Deque

### Queue Interface (FIFO - First In First Out)

```java
Queue<String> queue = new LinkedList<>();

// Adding elements
queue.offer("A");  // Returns false if queue full (better than add)
queue.add("B");    // Throws exception if queue full

// Removing elements
String head = queue.poll();    // Remove and return head (or null if empty)
String head2 = queue.remove(); // Remove and return head (throws if empty)

// Peeking
String peek = queue.peek();    // Return head without removing (or null)
String peek2 = queue.element();// Return head without removing (throws if empty)
```

### Deque Interface (Double-Ended Queue)

```java
Deque<String> deque = new ArrayDeque<>();

// Add to front or back
deque.addFirst("A");
deque.addLast("B");
deque.offerFirst("C");  // Returns false if full
deque.offerLast("D");   // Returns false if full

// Remove from front or back
String first = deque.removeFirst();
String last = deque.removeLast();
String first2 = deque.pollFirst();  // Returns null if empty
String last2 = deque.pollLast();    // Returns null if empty

// Peek
String peekFirst = deque.peekFirst();
String peekLast = deque.peekLast();

// Can be used as Stack (LIFO)
deque.push("A");        // Add to front
String top = deque.pop(); // Remove from front
```

### PriorityQueue (Min-Heap by default)

```java
// Natural ordering (min-heap)
PriorityQueue<Integer> minHeap = new PriorityQueue<>();
minHeap.offer(5);
minHeap.offer(2);
minHeap.offer(8);
System.out.println(minHeap.poll()); // 2 (smallest)

// Custom comparator (max-heap)
PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
maxHeap.offer(5);
maxHeap.offer(2);
maxHeap.offer(8);
System.out.println(maxHeap.poll()); // 8 (largest)
```

---

## 🔄 Sorting and Comparators

### Collections.sort()

```java
List<Integer> numbers = Arrays.asList(5, 2, 8, 1);

// Natural ordering (ascending)
Collections.sort(numbers);  // [1, 2, 5, 8]

// Custom comparator (descending)
Collections.sort(numbers, Comparator.reverseOrder()); // [8, 5, 2, 1]
```

### Comparator Examples

```java
List<String> words = Arrays.asList("Apple", "Banana", "Fig", "Cherry");

// Sort by length
words.sort(Comparator.comparingInt(String::length));
// [Fig, Apple, Banana, Cherry]

// Sort by length, then alphabetically
words.sort(Comparator.comparingInt(String::length)
                     .thenComparing(Comparator.naturalOrder()));
// [Fig, Apple, Banana, Cherry]

// Custom lambda comparator
words.sort((a, b) -> Integer.compare(a.length(), b.length()));
```

### Comparable vs Comparator

```java
// Comparable: Natural ordering defined in the class
class Person implements Comparable<Person> {
    String name;
    int age;

    @Override
    public int compareTo(Person other) {
        return this.name.compareTo(other.name);
    }
}

// Comparator: External comparison logic
Comparator<Person> byAge = (p1, p2) -> Integer.compare(p1.age, p2.age);
Comparator<Person> byName = Comparator.comparing(p -> p.name);
```

---

## 🔁 Iteration Patterns

### 1. Traditional For Loop (indexed)
```java
for (int i = 0; i < list.size(); i++) {
    System.out.println(list.get(i));
}
// Good for: Lists with random access, when you need index
```

### 2. Enhanced For-Each Loop
```java
for (String item : list) {
    System.out.println(item);
}
// Good for: Simple iteration, any Iterable
```

### 3. Iterator
```java
Iterator<String> it = list.iterator();
while (it.hasNext()) {
    String item = it.next();
    System.out.println(item);
    // Can safely remove: it.remove();
}
// Good for: Safe removal during iteration
```

### 4. forEach Method (Java 8+)
```java
list.forEach(item -> System.out.println(item));
list.forEach(System.out::println);  // Method reference
// Good for: Functional style, concise code
```

### 5. Stream API (Java 8+)
```java
list.stream()
    .filter(s -> s.length() > 3)
    .map(String::toUpperCase)
    .forEach(System.out::println);
// Good for: Complex transformations, functional programming
```

---

## 🔄 Collection Conversions

### List ↔ Set
```java
// List to Set (removes duplicates)
List<String> list = Arrays.asList("A", "B", "A", "C");
Set<String> set = new HashSet<>(list);  // {A, B, C}

// Set to List (allows indexing)
Set<String> set = new HashSet<>(Arrays.asList("A", "B", "C"));
List<String> list = new ArrayList<>(set);
```

### Collection ↔ Array
```java
// List to Array
List<String> list = Arrays.asList("A", "B", "C");
String[] array = list.toArray(new String[0]);

// Array to List
String[] array = {"A", "B", "C"};
List<String> list = Arrays.asList(array);  // Fixed-size
List<String> mutableList = new ArrayList<>(Arrays.asList(array));
```

### Map ↔ Collections
```java
Map<String, Integer> map = new HashMap<>();
map.put("A", 1);
map.put("B", 2);

// Map to Set of keys
Set<String> keys = map.keySet();

// Map to Collection of values
Collection<Integer> values = map.values();

// Map to Set of entries
Set<Map.Entry<String, Integer>> entries = map.entrySet();
```

---

## 📊 Performance Characteristics Summary

### Time Complexity Cheat Sheet

| Operation | ArrayList | LinkedList | HashSet | TreeSet | HashMap | TreeMap |
|-----------|-----------|------------|---------|---------|---------|---------|
| **Add** | O(1)* | O(1) | O(1)* | O(log n) | O(1)* | O(log n) |
| **Remove** | O(n) | O(n) | O(1)* | O(log n) | O(1)* | O(log n) |
| **Get by index** | O(1) | O(n) | N/A | N/A | N/A | N/A |
| **Get by key** | N/A | N/A | N/A | N/A | O(1)* | O(log n) |
| **Contains** | O(n) | O(n) | O(1)* | O(log n) | O(1)* | O(log n) |
| **Iteration** | O(n) | O(n) | O(n) | O(n) | O(n) | O(n) |

*Amortized or average case

---

## 🎯 When to Use Which Collection?

### Use ArrayList when:
- You need fast random access by index
- You iterate frequently
- You add/remove mostly at the end

### Use LinkedList when:
- You add/remove frequently at the beginning
- You implement a queue or deque
- Random access is not important

### Use HashSet when:
- You need unique elements
- Order doesn't matter
- You need fast add/remove/contains

### Use TreeSet when:
- You need unique elements in sorted order
- You need operations like first(), last()

### Use HashMap when:
- You need key-value pairs
- Order doesn't matter
- You need fast lookup by key

### Use TreeMap when:
- You need key-value pairs in sorted key order
- You need navigation methods (firstKey, lastKey, etc.)

### Use PriorityQueue when:
- You need elements in priority order
- You're implementing a heap-based algorithm

---

## 💡 Tips for Success

1. **Understand time complexity** - Know when O(1) vs O(log n) vs O(n) matters
2. **Practice conversions** - Moving between List/Set/Map is common
3. **Master iteration** - Different patterns for different use cases
4. **Learn Comparators** - Essential for custom sorting
5. **Null handling** - Know which collections allow null and which don't
6. **Use the right collection** - Choosing the right one saves time and memory

---

## 📚 Resources

- [Java Collections Framework Documentation](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/doc-files/coll-overview.html)
- [List Interface](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/List.html)
- [Set Interface](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Set.html)
- [Map Interface](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Map.html)
- [Queue Interface](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Queue.html)

---

Happy practicing!
