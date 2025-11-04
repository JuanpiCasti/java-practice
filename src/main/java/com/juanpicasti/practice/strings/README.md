# Java Practice Playground

A structured environment for practicing Java programming concepts with unit tests.

## Current Module: String Manipulation

This module contains 18 progressive exercises to master Java String methods, from basic to medium difficulty.

---

## Quick Start

### Run All Tests
```bash
mvn test
```

### Run Only String Tests
```bash
mvn test -Dtest=StringExercisesTest
```

### Watch Tests (Run on file changes)
```bash
mvn test -Dtest=StringExercisesTest -DforkCount=0
```

---

## How to Practice

1. Open `src/main/java/com/juanpicasti/practice/strings/StringExercises.java`
2. Choose an exercise method (they're numbered and organized by difficulty)
3. Read the Javadoc to understand what's required
4. Replace the `throw new UnsupportedOperationException()` with your implementation
5. Run the tests to verify your solution
6. Move to the next exercise!

**Tip:** Tests are initially failing (red). Your goal is to make them pass (green)!

---

## Exercises Overview

### Beginner (Exercises 1-5)
| # | Method | Difficulty | Concepts |
|---|--------|-----------|----------|
| 1 | `getStringLength` | ⭐ | `.length()`, null handling |
| 2 | `isNullOrEmpty` | ⭐ | null checks, `.isEmpty()` |
| 3 | `isBlank` | ⭐ | `.isBlank()` (Java 11+) |
| 4 | `getCharAt` | ⭐⭐ | `.charAt()`, exception handling |
| 5 | `getSubstring` | ⭐⭐ | `.substring()`, index validation |

### Easy (Exercises 6-9)
| # | Method | Difficulty | Concepts |
|---|--------|-----------|----------|
| 6 | `toUpperCase` | ⭐ | `.toUpperCase()` |
| 7 | `toLowerCase` | ⭐ | `.toLowerCase()` |
| 8 | `trimWhitespace` | ⭐ | `.trim()` |
| 9 | `removeLeadingWhitespace` | ⭐⭐ | `.stripLeading()` (Java 11+) |

### Intermediate (Exercises 10-15)
| # | Method | Difficulty | Concepts |
|---|--------|-----------|----------|
| 10 | `findFirstOccurrence` | ⭐⭐ | `.indexOf()` |
| 11 | `containsSubstring` | ⭐⭐ | `.contains()` |
| 12 | `startsWith` | ⭐⭐ | `.startsWith()` |
| 13 | `endsWith` | ⭐⭐ | `.endsWith()` |
| 14 | `replaceChar` | ⭐⭐ | `.replace()` |
| 15 | `replaceSubstring` | ⭐⭐ | `.replace()`, exception handling |

### Medium (Exercises 16-18)
| # | Method | Difficulty | Concepts |
|---|--------|-----------|----------|
| 16 | `splitString` | ⭐⭐⭐ | `.split()`, arrays |
| 17 | `joinStrings` | ⭐⭐⭐ | `String.join()`, varargs |
| 18 | `countOccurrences` | ⭐⭐⭐ | loops or streams, character counting |

---

## String Methods Reference

### 📏 Length & Size

#### `int length()`
Returns the number of characters in the string.
```java
"Hello".length()  // returns 5
"".length()       // returns 0
```

#### `boolean isEmpty()`
Returns true if the string has zero length.
```java
"".isEmpty()      // returns true
"Hello".isEmpty() // returns false
```

#### `boolean isBlank()` *(Java 11+)*
Returns true if the string is empty or contains only whitespace.
```java
"   ".isBlank()   // returns true
"  a ".isBlank()  // returns false
```

---

### 🔍 Character Access & Extraction

#### `char charAt(int index)`
Returns the character at the specified index (0-based).
```java
"Hello".charAt(1)  // returns 'e'
"Hello".charAt(0)  // returns 'H'
```

#### `String substring(int beginIndex)`
Returns a substring from beginIndex to the end.
```java
"Hello".substring(2)  // returns "llo"
```

#### `String substring(int beginIndex, int endIndex)`
Returns a substring from beginIndex (inclusive) to endIndex (exclusive).
```java
"Hello".substring(1, 4)  // returns "ell"
```

#### `char[] toCharArray()`
Converts the string to a character array.
```java
"Hi".toCharArray()  // returns ['H', 'i']
```

---

### 🔄 Case Conversion

#### `String toUpperCase()`
Converts all characters to uppercase.
```java
"Hello".toUpperCase()  // returns "HELLO"
```

#### `String toLowerCase()`
Converts all characters to lowercase.
```java
"Hello".toLowerCase()  // returns "hello"
```

---

### ✂️ Trimming & Stripping

#### `String trim()`
Removes leading and trailing whitespace (spaces ≤ U+0020).
```java
"  Hello  ".trim()  // returns "Hello"
```

#### `String strip()` *(Java 11+)*
Removes leading and trailing whitespace (Unicode-aware).
```java
"  Hello  ".strip()  // returns "Hello"
```

#### `String stripLeading()` *(Java 11+)*
Removes only leading whitespace.
```java
"  Hello  ".stripLeading()  // returns "Hello  "
```

#### `String stripTrailing()` *(Java 11+)*
Removes only trailing whitespace.
```java
"  Hello  ".stripTrailing()  // returns "  Hello"
```

---

### 🔎 Searching

#### `int indexOf(char ch)`
Returns the index of the first occurrence of ch, or -1 if not found.
```java
"Hello".indexOf('e')  // returns 1
"Hello".indexOf('x')  // returns -1
```

#### `int indexOf(String str)`
Returns the index of the first occurrence of substring, or -1.
```java
"Hello World".indexOf("World")  // returns 6
```

#### `int lastIndexOf(char ch)`
Returns the index of the last occurrence of ch, or -1.
```java
"Hello".lastIndexOf('l')  // returns 3
```

#### `boolean contains(CharSequence s)`
Returns true if the string contains the specified sequence.
```java
"Hello World".contains("World")  // returns true
"Hello World".contains("Java")   // returns false
```

#### `boolean startsWith(String prefix)`
Returns true if the string starts with the specified prefix.
```java
"Hello World".startsWith("Hello")  // returns true
```

#### `boolean endsWith(String suffix)`
Returns true if the string ends with the specified suffix.
```java
"Hello World".endsWith("World")  // returns true
```

---

### 🔧 Modification

#### `String replace(char oldChar, char newChar)`
Replaces all occurrences of oldChar with newChar.
```java
"Hello".replace('l', 'p')  // returns "Heppo"
```

#### `String replace(CharSequence target, CharSequence replacement)`
Replaces all occurrences of target with replacement.
```java
"Hello World".replace("World", "Java")  // returns "Hello Java"
```

#### `String replaceAll(String regex, String replacement)`
Replaces all matches of regex with replacement.
```java
"a1b2c3".replaceAll("\\d", "X")  // returns "aXbXcX"
```

#### `String replaceFirst(String regex, String replacement)`
Replaces the first match of regex with replacement.
```java
"a1b2c3".replaceFirst("\\d", "X")  // returns "aXb2c3"
```

---

### ✂️ Splitting & Joining

#### `String[] split(String regex)`
Splits the string around matches of the regex.
```java
"a,b,c".split(",")        // returns ["a", "b", "c"]
"Hello World".split(" ")  // returns ["Hello", "World"]
```

#### `String[] split(String regex, int limit)`
Splits with a limit on the number of splits.
```java
"a:b:c:d".split(":", 2)  // returns ["a", "b:c:d"]
```

#### `static String join(CharSequence delimiter, CharSequence... elements)`
Joins elements with the specified delimiter.
```java
String.join(", ", "a", "b", "c")  // returns "a, b, c"
String.join("-", "Hello", "World")  // returns "Hello-World"
```

---

### 🔢 Comparison

#### `boolean equals(Object obj)`
Compares strings for equality (case-sensitive).
```java
"Hello".equals("Hello")  // returns true
"Hello".equals("hello")  // returns false
```

#### `boolean equalsIgnoreCase(String str)`
Compares strings ignoring case differences.
```java
"Hello".equalsIgnoreCase("hello")  // returns true
```

#### `int compareTo(String str)`
Compares strings lexicographically. Returns 0 if equal, <0 if this string is less, >0 if greater.
```java
"abc".compareTo("abc")  // returns 0
"abc".compareTo("abd")  // returns -1
"abd".compareTo("abc")  // returns 1
```

#### `int compareToIgnoreCase(String str)`
Compares strings lexicographically, ignoring case.
```java
"ABC".compareToIgnoreCase("abc")  // returns 0
```

---

### 🎨 Formatting & Manipulation

#### `static String format(String format, Object... args)`
Returns a formatted string using the specified format string and arguments.
```java
String.format("Hello %s, you are %d years old", "Alice", 25)
// returns "Hello Alice, you are 25 years old"
```

#### `String repeat(int count)` *(Java 11+)*
Returns a string whose value is the concatenation of this string repeated count times.
```java
"Hi".repeat(3)  // returns "HiHiHi"
```

#### `String indent(int n)` *(Java 12+)*
Adjusts the indentation of each line.
```java
"Hello".indent(4)  // returns "    Hello\n"
```

#### `String concat(String str)`
Concatenates the specified string to the end of this string.
```java
"Hello".concat(" World")  // returns "Hello World"
```

---

### ✅ Content Checking

#### `boolean matches(String regex)`
Returns true if the string matches the given regex.
```java
"abc123".matches("\\w+")  // returns true
"abc".matches("\\d+")     // returns false
```

#### `boolean regionMatches(int toffset, String other, int ooffset, int len)`
Tests if two string regions are equal.
```java
"Hello World".regionMatches(6, "World", 0, 5)  // returns true
```

---

## Tips for Success

1. **Read the Javadoc carefully** - Each method has clear requirements and expected behavior
2. **Handle edge cases** - Consider null inputs, empty strings, and boundary conditions
3. **Run tests frequently** - Get immediate feedback on your implementation
4. **One method at a time** - Don't try to implement everything at once
5. **Check the String API docs** - When stuck, refer to the official Java documentation
6. **Understand before implementing** - Make sure you understand what the String method does

---

## Test Statistics

- **Total Tests:** 68
- **Tests per Exercise:** 3-6 (covering normal cases and edge cases)
- **Coverage:** All 18 exercises have comprehensive test coverage

---

## Next Steps

After completing String manipulation, you can add more practice modules:
- Collections (List, Set, Map)
- Streams and Lambda expressions
- Date and Time API
- File I/O
- And more!

---

## Resources

- [Java String API Documentation](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/String.html)
- [JUnit 5 User Guide](https://junit.org/junit5/docs/current/user-guide/)

---

Happy practicing!
