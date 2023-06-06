package strings.anagrams;

import java.util.Arrays;

/**
 * Detect if anagram of small String is present in large String.
 */
public class SearchAnagrams {
    /**
     * Detect if anagram of small is present in large.
     */
    public static boolean isAnagram(String small, String large) {
        if (small == null) {
            small = "";
        }

        if (large == null) {
            large = "";
        }

        int n1 = small.length();
        int n2 = large.length();

        if (n2 < n1) {
            return false;
        }

        char[] s1CharArray = small.toCharArray();
        Arrays.sort(s1CharArray);

        for (int i = 0; i <= n2 - n1; i++) {
            // create a sliding window of length n1
            String largeFragment = large.substring(i, i + n1);

            char[] s2CharArray = largeFragment.toCharArray();
            Arrays.sort(s2CharArray);

            if (Arrays.equals(s1CharArray, s2CharArray)) {
                return true;
            }
        }

        return false;
    }

    public static void isAnagramWithPrint(String small, String large) {
        boolean isAnagram = isAnagram(small, large);
        if (isAnagram) {
            System.out.println("Anagram of \"" + small + "\" is present in \"" + large + "\"");
        } else {
            System.out.println("Anagram of \"" + small + "\" is not present in \"" + large + "\"");
        }
    }

    /**
     * This program prints:
     * <p>
     * Anagram of "" is present in ""
     * Anagram of "null" is present in "a"
     * Anagram of "b" is not present in "null"
     * Anagram of "null" is present in "null"
     * Anagram of "abc" is present in "abc"
     * Anagram of "abc" is present in "bac"
     * Anagram of "abc" is not present in "b"
     * Anagram of "abc" is present in "bacd"
     * Anagram of "abc" is not present in "acd"
     * Anagram of "abcd" is not present in "acd"
     */
    public static void main(String[] args) {
        isAnagramWithPrint("", "");
        isAnagramWithPrint(null, "a");
        isAnagramWithPrint("b", null);
        isAnagramWithPrint(null, null);
        isAnagramWithPrint("abc", "abc");
        isAnagramWithPrint("abc", "bac");
        isAnagramWithPrint("abc", "b");
        isAnagramWithPrint("abc", "bacd");
        isAnagramWithPrint("abc", "acd");
        isAnagramWithPrint("abcd", "acd");
    }
}