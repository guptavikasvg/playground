package arrays.problems;

import org.junit.Test;

import static arrays.problems.Solution.mySqrt;
import static org.junit.Assert.assertEquals;

/**
 * Given a non-negative integer x, return the square root of x rounded down to the nearest integer. The returned integer should be non-negative as well.
 *
 * You must not use any built-in exponent function or operator.
 *
 * For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.
 *
 *
 * Example 1:
 *
 * Input: x = 4
 * Output: 2
 * Explanation: The square root of 4 is 2, so we return 2.
 * Example 2:
 *
 * Input: x = 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since we round it down to the nearest integer, 2 is returned.
 *
 *
 * Constraints:
 *
 * 0 <= x <= 231 - 1
 */

class Solution {
    public static int mySqrt(int x) {
        if (x == 0) return 0;

        long p = 1;
        long q = x;

        long mid;
        while (true) {
            mid = p + (q - p) / 2;
            if (mid == p || mid == q) {
                break;
            }

            long sq = mid * mid;

            if (sq > x) {
                q = mid;
            } else if (sq < x) {
                p = mid;
            } else {
                break;
            }
        }

        return (int) mid;
    }

}

public class Leetcode69SqrtX {
    @Test
    public void test() {
        assertEquals(0, mySqrt(0));
        assertEquals(1, mySqrt(1));
        assertEquals(1, mySqrt(2));
        assertEquals(1, mySqrt(3));
        assertEquals(2, mySqrt(4));
        assertEquals(3, mySqrt(10));
    }
}