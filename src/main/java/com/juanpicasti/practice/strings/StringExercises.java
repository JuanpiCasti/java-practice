package com.juanpicasti.practice.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * String Manipulation Exercises
 *
 * This class contains 18 progressive exercises to practice Java String methods.
 * Each method is a TODO that you need to implement to make the tests pass.
 *
 * Difficulty progression: Easy → Medium
 */
public class StringExercises {

    // ==================== BASIC OPERATIONS ====================

    /**
     * Exercise 1: Get the length of a string
     *
     * @param str the input string
     * @return the length of the string, or 0 if null
     */
    public int getStringLength(String str) {
        if (str == null) return 0;
        return str.length();
    }

    /**
     * Exercise 2: Check if a string is empty or null
     *
     * @param str the input string
     * @return true if the string is null or empty, false otherwise
     */
    public boolean isNullOrEmpty(String str) {
        return str == null || str.isEmpty();
    }

    /**
     * Exercise 3: Check if a string is blank (null, empty, or only whitespace)
     * Use the String.isBlank() method introduced in Java 11
     *
     * @param str the input string
     * @return true if the string is null, empty, or contains only whitespace
     */
    public boolean isBlank(String str) {
        return str == null || str.isBlank();
    }

    // ==================== EXTRACTION & ACCESS ====================

    /**
     * Exercise 4: Get the character at a specific position
     *
     * @param str the input string
     * @param index the position (0-based)
     * @return the character at the specified index
     * @throws IllegalArgumentException if str is null or index is out of bounds
     */
    public char getCharAt(String str, int index) {
        if (str == null || index < 0 || index >= str.length()) throw new IllegalArgumentException();
        return str.charAt(index);
    }

    /**
     * Exercise 5: Extract a substring from start index to end index
     *
     * @param str the input string
     * @param start the starting index (inclusive)
     * @param end the ending index (exclusive)
     * @return the substring
     * @throws IllegalArgumentException if str is null or indices are invalid
     */
    public String getSubstring(String str, int start, int end) {
        if (isBlank(str) || start < 0 || end < start || end > str.length()) {
            throw new IllegalArgumentException();
        }
        return str.substring(start, end);
    }

    // ==================== CASE OPERATIONS ====================

    /**
     * Exercise 6: Convert string to uppercase
     *
     * @param str the input string
     * @return the uppercase version, or null if input is null
     */
    public String toUpperCase(String str) {
        if (str == null) return null;
        return str.toUpperCase();
    }

    /**
     * Exercise 7: Convert string to lowercase
     *
     * @param str the input string
     * @return the lowercase version, or null if input is null
     */
    public String toLowerCase(String str) {
        if (str == null) return null;
        return str.toLowerCase();
    }

    // ==================== TRIMMING & CLEANING ====================

    /**
     * Exercise 8: Remove leading and trailing whitespace
     *
     * @param str the input string
     * @return the trimmed string, or null if input is null
     */
    public String trimWhitespace(String str) {
        if (str == null) return null;
        return str.trim();
    }

    /**
     * Exercise 9: Remove leading whitespace only
     * Use stripLeading() method (Java 11+)
     *
     * @param str the input string
     * @return the string with leading whitespace removed, or null if input is null
     */
    public String removeLeadingWhitespace(String str) {
        if (str == null) return null;
        return str.stripLeading();
    }

    // ==================== SEARCHING ====================

    /**
     * Exercise 10: Find the first occurrence of a character
     *
     * @param str the input string
     * @param ch the character to find
     * @return the index of the first occurrence, or -1 if not found or str is null
     */
    public int findFirstOccurrence(String str, char ch) {
        if (str == null) return -1;
        return str.indexOf(ch);
    }

    /**
     * Exercise 11: Check if a string contains a substring
     *
     * @param str the input string
     * @param substring the substring to search for
     * @return true if str contains substring, false otherwise (or if either is null)
     */
    public boolean containsSubstring(String str, String substring) {
        if (str == null || substring == null) return false;
        return str.contains(substring);
    }

    /**
     * Exercise 12: Check if a string starts with a specific prefix
     *
     * @param str the input string
     * @param prefix the prefix to check
     * @return true if str starts with prefix, false otherwise (or if either is null)
     */
    public boolean startsWith(String str, String prefix) {
        if (str == null || prefix == null) return false;
        return str.startsWith(prefix);
    }

    /**
     * Exercise 13: Check if a string ends with a specific suffix
     *
     * @param str the input string
     * @param suffix the suffix to check
     * @return true if str ends with suffix, false otherwise (or if either is null)
     */
    public boolean endsWith(String str, String suffix) {
        if (str == null || suffix == null) return false;
        return str.endsWith(suffix);
    }

    // ==================== MODIFICATION ====================

    /**
     * Exercise 14: Replace all occurrences of a character with another
     *
     * @param str the input string
     * @param oldChar the character to replace
     * @param newChar the replacement character
     * @return the modified string, or null if input is null
     */
    public String replaceChar(String str, char oldChar, char newChar) {
        if (str == null) return null;
        return str.replace(oldChar, newChar);
    }

    /**
     * Exercise 15: Replace all occurrences of a substring with another
     *
     * @param str the input string
     * @param target the substring to replace
     * @param replacement the replacement substring
     * @return the modified string, or null if input is null
     * @throws IllegalArgumentException if target or replacement is null (when str is not null)
     */
    public String replaceSubstring(String str, String target, String replacement) {
        if (replacement == null || target == null) throw new IllegalArgumentException();
        if (str == null) return null;
        return str.replace(target, replacement);
    }

    // ==================== SPLITTING & JOINING ====================

    /**
     * Exercise 16: Split a string by a delimiter
     *
     * @param str the input string
     * @param delimiter the delimiter to split by
     * @return an array of strings split by the delimiter, or null if input is null
     */
    public String[] splitString(String str, String delimiter) {
        if (str == null || delimiter == null) return null;
        return str.split(delimiter);
    }

    /**
     * Exercise 17: Join an array of strings with a delimiter
     * Use String.join() method
     *
     * @param delimiter the delimiter to join with
     * @param elements the strings to join
     * @return the joined string, or empty string if elements is null/empty
     */
    public String joinStrings(String delimiter, String... elements) {
        if (delimiter == null || elements == null || elements.length == 0) {
            return "";
        }
        return String.join(delimiter, elements);
    }

    // ==================== ADVANCED ====================

    /**
     * Exercise 18: Count occurrences of a character in a string
     * This requires a loop or stream operation
     *
     * @param str the input string
     * @param ch the character to count
     * @return the number of occurrences, or 0 if str is null
     */
    public int countOccurrences(String str, char ch) {
        if (str == null) return 0;
        return (int) Arrays.stream(str.split("")).filter(c -> c.equals(String.valueOf(ch))).count();
    }
}
