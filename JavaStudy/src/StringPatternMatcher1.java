import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by root1 on 6/21/17.
 *
 * Coding question:

 Given 2 strings

 S [a-z]
 P [a-z, ., *]

 . matches 1 of any char.
 * matches 0 or more of the prev pattern char
 * is always preceded by a non star char

 Example:
 S     P
 ""    ""        true
 a     a         true
 ab    a         false
 abc   a.c       true
 abbc  ab*c      true
 abc   ab*c      true
 ac    ab*c      true

 boolean isMatch(String S, String P){}

 */
public class StringPatternMatcher1 {
    boolean isMatch(String str, String pattern){

        if (str == null || pattern == null) {
            return false;
        }

        int L = str.length();
        int l = pattern.length();

        int s = 0;
        int p = 0;

        while (s < L && p < l) {
            //case 1: lookahead exists and is = *
            if (hasValidLookAhead(pattern, l, p)) {
                //move s forward till it goes beyond the char at p
                while (s < L) {
                    if (str.charAt(s) == pattern.charAt(p)) {
                        s++;
                    } else {
                        //gone beyond the match
                        break;
                    }
                }
                p = p + 2;
            } else if (pattern.charAt(p) == '.' || pattern.charAt(p) == str.charAt(s)) {
                //case 2: no lookahead
                s++;
                p++;
            } else {
                return false;
            }
        }

        return s == L && (p == l || hasValidLookAhead(pattern, l, p));
    }

    private static boolean hasValidLookAhead(String pattern, int patternLen, int p) {
        return p + 1 < patternLen && pattern.charAt(p + 1) == '*';
    }

    @Test
    public void test1() throws Exception {
        assertTrue(isMatch("", ""));
        assertTrue(isMatch("a", "a"));
        assertTrue(isMatch("a", "."));
        assertTrue(isMatch("ab", "ab"));
        assertTrue(isMatch("ab", "a."));
        assertTrue(isMatch("ab", ".."));
        assertTrue(isMatch("a", "ab*"));
        assertTrue(isMatch("ab", "ab*"));
        assertTrue(isMatch("abb", "ab*"));
        assertTrue(isMatch("abbb", "ab*"));
    }
}