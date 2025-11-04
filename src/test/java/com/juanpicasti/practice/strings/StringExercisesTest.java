package com.juanpicasti.practice.strings;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Comprehensive test suite for StringExercises
 * Contains 60+ test cases covering all exercises and edge cases
 */
@DisplayName("String Manipulation Exercises Test Suite")
class StringExercisesTest {

    private StringExercises exercises;

    @BeforeEach
    void setUp() {
        exercises = new StringExercises();
    }

    // ==================== EXERCISE 1: getStringLength ====================

    @Test
    @DisplayName("Ex1: Get length of normal string")
    void testGetStringLength_normalString() {
        assertEquals(5, exercises.getStringLength("Hello"));
    }

    @Test
    @DisplayName("Ex1: Get length of empty string")
    void testGetStringLength_emptyString() {
        assertEquals(0, exercises.getStringLength(""));
    }

    @Test
    @DisplayName("Ex1: Get length of null string")
    void testGetStringLength_nullString() {
        assertEquals(0, exercises.getStringLength(null));
    }

    @Test
    @DisplayName("Ex1: Get length of string with spaces")
    void testGetStringLength_withSpaces() {
        assertEquals(11, exercises.getStringLength("Hello World"));
    }

    // ==================== EXERCISE 2: isNullOrEmpty ====================

    @Test
    @DisplayName("Ex2: Check null string")
    void testIsNullOrEmpty_null() {
        assertTrue(exercises.isNullOrEmpty(null));
    }

    @Test
    @DisplayName("Ex2: Check empty string")
    void testIsNullOrEmpty_empty() {
        assertTrue(exercises.isNullOrEmpty(""));
    }

    @Test
    @DisplayName("Ex2: Check non-empty string")
    void testIsNullOrEmpty_nonEmpty() {
        assertFalse(exercises.isNullOrEmpty("Hello"));
    }

    @Test
    @DisplayName("Ex2: Check string with only spaces")
    void testIsNullOrEmpty_onlySpaces() {
        assertFalse(exercises.isNullOrEmpty("   "));
    }

    // ==================== EXERCISE 3: isBlank ====================

    @Test
    @DisplayName("Ex3: Check null string is blank")
    void testIsBlank_null() {
        assertTrue(exercises.isBlank(null));
    }

    @Test
    @DisplayName("Ex3: Check empty string is blank")
    void testIsBlank_empty() {
        assertTrue(exercises.isBlank(""));
    }

    @Test
    @DisplayName("Ex3: Check string with only spaces is blank")
    void testIsBlank_onlySpaces() {
        assertTrue(exercises.isBlank("   "));
    }

    @Test
    @DisplayName("Ex3: Check string with tabs and newlines is blank")
    void testIsBlank_tabsAndNewlines() {
        assertTrue(exercises.isBlank("\t\n  \r"));
    }

    @Test
    @DisplayName("Ex3: Check non-blank string")
    void testIsBlank_nonBlank() {
        assertFalse(exercises.isBlank("Hello"));
    }

    @Test
    @DisplayName("Ex3: Check string with content and spaces")
    void testIsBlank_contentWithSpaces() {
        assertFalse(exercises.isBlank("  a  "));
    }

    // ==================== EXERCISE 4: getCharAt ====================

    @Test
    @DisplayName("Ex4: Get character at valid index")
    void testGetCharAt_validIndex() {
        assertEquals('e', exercises.getCharAt("Hello", 1));
    }

    @Test
    @DisplayName("Ex4: Get first character")
    void testGetCharAt_firstChar() {
        assertEquals('H', exercises.getCharAt("Hello", 0));
    }

    @Test
    @DisplayName("Ex4: Get last character")
    void testGetCharAt_lastChar() {
        assertEquals('o', exercises.getCharAt("Hello", 4));
    }

    @Test
    @DisplayName("Ex4: Throw exception for null string")
    void testGetCharAt_nullString() {
        assertThrows(IllegalArgumentException.class, () -> exercises.getCharAt(null, 0));
    }

    @Test
    @DisplayName("Ex4: Throw exception for negative index")
    void testGetCharAt_negativeIndex() {
        assertThrows(IllegalArgumentException.class, () -> exercises.getCharAt("Hello", -1));
    }

    @Test
    @DisplayName("Ex4: Throw exception for index out of bounds")
    void testGetCharAt_indexOutOfBounds() {
        assertThrows(IllegalArgumentException.class, () -> exercises.getCharAt("Hello", 10));
    }

    // ==================== EXERCISE 5: getSubstring ====================

    @Test
    @DisplayName("Ex5: Get substring from middle")
    void testGetSubstring_middle() {
        assertEquals("ell", exercises.getSubstring("Hello", 1, 4));
    }

    @Test
    @DisplayName("Ex5: Get substring from start")
    void testGetSubstring_fromStart() {
        assertEquals("Hel", exercises.getSubstring("Hello", 0, 3));
    }

    @Test
    @DisplayName("Ex5: Get substring to end")
    void testGetSubstring_toEnd() {
        assertEquals("llo", exercises.getSubstring("Hello", 2, 5));
    }

    @Test
    @DisplayName("Ex5: Get empty substring")
    void testGetSubstring_empty() {
        assertEquals("", exercises.getSubstring("Hello", 2, 2));
    }

    @Test
    @DisplayName("Ex5: Throw exception for null string")
    void testGetSubstring_nullString() {
        assertThrows(IllegalArgumentException.class, () -> exercises.getSubstring(null, 0, 1));
    }

    @Test
    @DisplayName("Ex5: Throw exception for invalid indices")
    void testGetSubstring_invalidIndices() {
        assertThrows(IllegalArgumentException.class, () -> exercises.getSubstring("Hello", 3, 2));
    }

    // ==================== EXERCISE 6: toUpperCase ====================

    @Test
    @DisplayName("Ex6: Convert to uppercase")
    void testToUpperCase_normal() {
        assertEquals("HELLO", exercises.toUpperCase("hello"));
    }

    @Test
    @DisplayName("Ex6: Convert mixed case to uppercase")
    void testToUpperCase_mixed() {
        assertEquals("HELLO WORLD!", exercises.toUpperCase("Hello World!"));
    }

    @Test
    @DisplayName("Ex6: Return null for null input")
    void testToUpperCase_null() {
        assertNull(exercises.toUpperCase(null));
    }

    @Test
    @DisplayName("Ex6: Handle already uppercase string")
    void testToUpperCase_alreadyUpper() {
        assertEquals("HELLO", exercises.toUpperCase("HELLO"));
    }

    // ==================== EXERCISE 7: toLowerCase ====================

    @Test
    @DisplayName("Ex7: Convert to lowercase")
    void testToLowerCase_normal() {
        assertEquals("hello", exercises.toLowerCase("HELLO"));
    }

    @Test
    @DisplayName("Ex7: Convert mixed case to lowercase")
    void testToLowerCase_mixed() {
        assertEquals("hello world!", exercises.toLowerCase("Hello World!"));
    }

    @Test
    @DisplayName("Ex7: Return null for null input")
    void testToLowerCase_null() {
        assertNull(exercises.toLowerCase(null));
    }

    @Test
    @DisplayName("Ex7: Handle already lowercase string")
    void testToLowerCase_alreadyLower() {
        assertEquals("hello", exercises.toLowerCase("hello"));
    }

    // ==================== EXERCISE 8: trimWhitespace ====================

    @Test
    @DisplayName("Ex8: Trim leading and trailing spaces")
    void testTrimWhitespace_spaces() {
        assertEquals("Hello", exercises.trimWhitespace("  Hello  "));
    }

    @Test
    @DisplayName("Ex8: Trim tabs and newlines")
    void testTrimWhitespace_tabsNewlines() {
        assertEquals("Hello", exercises.trimWhitespace("\t\nHello\r\n"));
    }

    @Test
    @DisplayName("Ex8: Don't trim middle whitespace")
    void testTrimWhitespace_middleWhitespace() {
        assertEquals("Hello World", exercises.trimWhitespace("  Hello World  "));
    }

    @Test
    @DisplayName("Ex8: Return null for null input")
    void testTrimWhitespace_null() {
        assertNull(exercises.trimWhitespace(null));
    }

    @Test
    @DisplayName("Ex8: Handle string with no whitespace")
    void testTrimWhitespace_noWhitespace() {
        assertEquals("Hello", exercises.trimWhitespace("Hello"));
    }

    // ==================== EXERCISE 9: removeLeadingWhitespace ====================

    @Test
    @DisplayName("Ex9: Remove leading spaces only")
    void testRemoveLeadingWhitespace_spaces() {
        assertEquals("Hello  ", exercises.removeLeadingWhitespace("  Hello  "));
    }

    @Test
    @DisplayName("Ex9: Remove leading tabs")
    void testRemoveLeadingWhitespace_tabs() {
        assertEquals("Hello\t", exercises.removeLeadingWhitespace("\t\tHello\t"));
    }

    @Test
    @DisplayName("Ex9: Return null for null input")
    void testRemoveLeadingWhitespace_null() {
        assertNull(exercises.removeLeadingWhitespace(null));
    }

    @Test
    @DisplayName("Ex9: Handle string with no leading whitespace")
    void testRemoveLeadingWhitespace_noLeading() {
        assertEquals("Hello  ", exercises.removeLeadingWhitespace("Hello  "));
    }

    // ==================== EXERCISE 10: findFirstOccurrence ====================

    @Test
    @DisplayName("Ex10: Find character in string")
    void testFindFirstOccurrence_found() {
        assertEquals(1, exercises.findFirstOccurrence("Hello", 'e'));
    }

    @Test
    @DisplayName("Ex10: Find first of multiple occurrences")
    void testFindFirstOccurrence_multiple() {
        assertEquals(2, exercises.findFirstOccurrence("Hello", 'l'));
    }

    @Test
    @DisplayName("Ex10: Return -1 when not found")
    void testFindFirstOccurrence_notFound() {
        assertEquals(-1, exercises.findFirstOccurrence("Hello", 'x'));
    }

    @Test
    @DisplayName("Ex10: Return -1 for null string")
    void testFindFirstOccurrence_null() {
        assertEquals(-1, exercises.findFirstOccurrence(null, 'a'));
    }

    @Test
    @DisplayName("Ex10: Find character at start")
    void testFindFirstOccurrence_atStart() {
        assertEquals(0, exercises.findFirstOccurrence("Hello", 'H'));
    }

    // ==================== EXERCISE 11: containsSubstring ====================

    @Test
    @DisplayName("Ex11: String contains substring")
    void testContainsSubstring_found() {
        assertTrue(exercises.containsSubstring("Hello World", "World"));
    }

    @Test
    @DisplayName("Ex11: String contains substring at start")
    void testContainsSubstring_atStart() {
        assertTrue(exercises.containsSubstring("Hello World", "Hello"));
    }

    @Test
    @DisplayName("Ex11: String does not contain substring")
    void testContainsSubstring_notFound() {
        assertFalse(exercises.containsSubstring("Hello World", "Java"));
    }

    @Test
    @DisplayName("Ex11: Return false for null string")
    void testContainsSubstring_nullString() {
        assertFalse(exercises.containsSubstring(null, "test"));
    }

    @Test
    @DisplayName("Ex11: Return false for null substring")
    void testContainsSubstring_nullSubstring() {
        assertFalse(exercises.containsSubstring("Hello", null));
    }

    @Test
    @DisplayName("Ex11: Case sensitive check")
    void testContainsSubstring_caseSensitive() {
        assertFalse(exercises.containsSubstring("Hello World", "world"));
    }

    // ==================== EXERCISE 12: startsWith ====================

    @Test
    @DisplayName("Ex12: String starts with prefix")
    void testStartsWith_true() {
        assertTrue(exercises.startsWith("Hello World", "Hello"));
    }

    @Test
    @DisplayName("Ex12: String does not start with prefix")
    void testStartsWith_false() {
        assertFalse(exercises.startsWith("Hello World", "World"));
    }

    @Test
    @DisplayName("Ex12: Return false for null string")
    void testStartsWith_nullString() {
        assertFalse(exercises.startsWith(null, "test"));
    }

    @Test
    @DisplayName("Ex12: Return false for null prefix")
    void testStartsWith_nullPrefix() {
        assertFalse(exercises.startsWith("Hello", null));
    }

    @Test
    @DisplayName("Ex12: Case sensitive check")
    void testStartsWith_caseSensitive() {
        assertFalse(exercises.startsWith("Hello World", "hello"));
    }

    // ==================== EXERCISE 13: endsWith ====================

    @Test
    @DisplayName("Ex13: String ends with suffix")
    void testEndsWith_true() {
        assertTrue(exercises.endsWith("Hello World", "World"));
    }

    @Test
    @DisplayName("Ex13: String does not end with suffix")
    void testEndsWith_false() {
        assertFalse(exercises.endsWith("Hello World", "Hello"));
    }

    @Test
    @DisplayName("Ex13: Return false for null string")
    void testEndsWith_nullString() {
        assertFalse(exercises.endsWith(null, "test"));
    }

    @Test
    @DisplayName("Ex13: Return false for null suffix")
    void testEndsWith_nullSuffix() {
        assertFalse(exercises.endsWith("Hello", null));
    }

    @Test
    @DisplayName("Ex13: Case sensitive check")
    void testEndsWith_caseSensitive() {
        assertFalse(exercises.endsWith("Hello World", "world"));
    }

    // ==================== EXERCISE 14: replaceChar ====================

    @Test
    @DisplayName("Ex14: Replace character")
    void testReplaceChar_normal() {
        assertEquals("Hallo", exercises.replaceChar("Hello", 'e', 'a'));
    }

    @Test
    @DisplayName("Ex14: Replace multiple occurrences")
    void testReplaceChar_multiple() {
        assertEquals("Heooo", exercises.replaceChar("Hello", 'l', 'o'));
    }

    @Test
    @DisplayName("Ex14: Replace non-existent character")
    void testReplaceChar_notFound() {
        assertEquals("Hello", exercises.replaceChar("Hello", 'x', 'y'));
    }

    @Test
    @DisplayName("Ex14: Return null for null input")
    void testReplaceChar_null() {
        assertNull(exercises.replaceChar(null, 'a', 'b'));
    }

    // ==================== EXERCISE 15: replaceSubstring ====================

    @Test
    @DisplayName("Ex15: Replace substring")
    void testReplaceSubstring_normal() {
        assertEquals("Hello Java", exercises.replaceSubstring("Hello World", "World", "Java"));
    }

    @Test
    @DisplayName("Ex15: Replace multiple occurrences")
    void testReplaceSubstring_multiple() {
        assertEquals("Hi Hi Hi", exercises.replaceSubstring("Hello Hello Hello", "Hello", "Hi"));
    }

    @Test
    @DisplayName("Ex15: Replace with empty string")
    void testReplaceSubstring_withEmpty() {
        assertEquals("Heo", exercises.replaceSubstring("Hello", "ll", ""));
    }

    @Test
    @DisplayName("Ex15: Replace non-existent substring")
    void testReplaceSubstring_notFound() {
        assertEquals("Hello", exercises.replaceSubstring("Hello", "Java", "World"));
    }

    @Test
    @DisplayName("Ex15: Return null for null input")
    void testReplaceSubstring_null() {
        assertNull(exercises.replaceSubstring(null, "a", "b"));
    }

    @Test
    @DisplayName("Ex15: Throw exception for null target")
    void testReplaceSubstring_nullTarget() {
        assertThrows(IllegalArgumentException.class,
            () -> exercises.replaceSubstring("Hello", null, "World"));
    }

    // ==================== EXERCISE 16: splitString ====================

    @Test
    @DisplayName("Ex16: Split by comma")
    void testSplitString_comma() {
        String[] result = exercises.splitString("a,b,c", ",");
        assertArrayEquals(new String[]{"a", "b", "c"}, result);
    }

    @Test
    @DisplayName("Ex16: Split by space")
    void testSplitString_space() {
        String[] result = exercises.splitString("Hello World Java", " ");
        assertArrayEquals(new String[]{"Hello", "World", "Java"}, result);
    }

    @Test
    @DisplayName("Ex16: Split with no delimiter found")
    void testSplitString_noDelimiter() {
        String[] result = exercises.splitString("Hello", ",");
        assertArrayEquals(new String[]{"Hello"}, result);
    }

    @Test
    @DisplayName("Ex16: Return null for null input")
    void testSplitString_null() {
        assertNull(exercises.splitString(null, ","));
    }

    @Test
    @DisplayName("Ex16: Split empty string")
    void testSplitString_empty() {
        String[] result = exercises.splitString("", ",");
        assertArrayEquals(new String[]{""}, result);
    }

    // ==================== EXERCISE 17: joinStrings ====================

    @Test
    @DisplayName("Ex17: Join with comma")
    void testJoinStrings_comma() {
        assertEquals("a,b,c", exercises.joinStrings(",", "a", "b", "c"));
    }

    @Test
    @DisplayName("Ex17: Join with space")
    void testJoinStrings_space() {
        assertEquals("Hello World", exercises.joinStrings(" ", "Hello", "World"));
    }

    @Test
    @DisplayName("Ex17: Join with empty delimiter")
    void testJoinStrings_noDelimiter() {
        assertEquals("abc", exercises.joinStrings("", "a", "b", "c"));
    }

    @Test
    @DisplayName("Ex17: Join single element")
    void testJoinStrings_singleElement() {
        assertEquals("Hello", exercises.joinStrings(",", "Hello"));
    }

    @Test
    @DisplayName("Ex17: Return empty string for null array")
    void testJoinStrings_nullArray() {
        assertEquals("", exercises.joinStrings(",", (String[]) null));
    }

    @Test
    @DisplayName("Ex17: Return empty string for empty array")
    void testJoinStrings_emptyArray() {
        assertEquals("", exercises.joinStrings(","));
    }

    // ==================== EXERCISE 18: countOccurrences ====================

    @Test
    @DisplayName("Ex18: Count single occurrence")
    void testCountOccurrences_single() {
        assertEquals(1, exercises.countOccurrences("Hello", 'H'));
    }

    @Test
    @DisplayName("Ex18: Count multiple occurrences")
    void testCountOccurrences_multiple() {
        assertEquals(2, exercises.countOccurrences("Hello", 'l'));
    }

    @Test
    @DisplayName("Ex18: Count zero occurrences")
    void testCountOccurrences_zero() {
        assertEquals(0, exercises.countOccurrences("Hello", 'x'));
    }

    @Test
    @DisplayName("Ex18: Return 0 for null string")
    void testCountOccurrences_null() {
        assertEquals(0, exercises.countOccurrences(null, 'a'));
    }

    @Test
    @DisplayName("Ex18: Count in string with all same characters")
    void testCountOccurrences_allSame() {
        assertEquals(5, exercises.countOccurrences("aaaaa", 'a'));
    }

    @Test
    @DisplayName("Ex18: Count spaces")
    void testCountOccurrences_spaces() {
        assertEquals(2, exercises.countOccurrences("Hello World Java", ' '));
    }
}
