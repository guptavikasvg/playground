package leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * https://leetcode.com/problems/valid-anagram/
 * <p>
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 * <p>
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * Example 2:
 * <p>
 * Input: s = "rat", t = "car"
 * Output: false
 */
public class Leetcode242_Valid_Anagram {

    public static boolean isAnagram(String s, String t) {
        if (s == null) s = "";
        if (t == null) s = "";
        // create sets with frequency count of each letter in s and t
        HashMap<Character, Integer> characterIntegerHashMap1 = computeCharFrequencyMap(s);
        HashMap<Character, Integer> characterIntegerHashMap2 = computeCharFrequencyMap(t);

        // check that the hashmaps are the same
        return checkFreqHashMap(characterIntegerHashMap1, characterIntegerHashMap2)
                && checkFreqHashMap(characterIntegerHashMap2, characterIntegerHashMap1);
    }

    private static boolean checkFreqHashMap(HashMap<Character, Integer> characterIntegerHashMap1,
                                            HashMap<Character, Integer> characterIntegerHashMap2) {
        for (Map.Entry<Character, Integer> entry1 : characterIntegerHashMap1.entrySet()) {
            char key1 = entry1.getKey();
            Integer value1 = entry1.getValue();

            if (!value1.equals(characterIntegerHashMap2.get(key1))) {
                return false;
            }
        }

        return true;
    }

    private static HashMap<Character, Integer> computeCharFrequencyMap(String s) {
        HashMap<Character, Integer> letterFrequencies1 = new HashMap<Character, Integer>();
        for (char c : s.toCharArray()) {
            Integer integer = letterFrequencies1.get(c);

            if (integer == null) {
                letterFrequencies1.put(c, 1);
            } else {
                letterFrequencies1.put(c, integer + 1);
            }
        }

        return letterFrequencies1;
    }

    @Test
    public void test1() {
        assertTrue(isAnagram("abc", "bac"));
        assertTrue(isAnagram("abc", "bac"));
        assertTrue(isAnagram("aabc", "abac"));
        assertTrue(isAnagram("abc", "abc"));
        assertFalse(isAnagram("abc", "bc"));
        assertFalse(isAnagram("abc", "dac"));
        assertTrue(isAnagram("", ""));
    }
}
