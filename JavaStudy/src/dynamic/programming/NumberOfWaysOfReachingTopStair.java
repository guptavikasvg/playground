package dynamic.programming;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * 70. Climbing Stairs
 *
 * You are climbing a staircase. It takes n steps to reach the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 *
 *
 * Example 1:
 *
 * Input: n = 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * Example 2:
 *
 * Input: n = 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 */
public class NumberOfWaysOfReachingTopStair {
    @Test
    public void test1() {
        assertEquals(1, Solution.climbStairs(1));
        assertEquals(2, Solution.climbStairs(2));
        assertEquals(3, Solution.climbStairs(3));
        assertEquals(5, Solution.climbStairs(4));
    }

    class Solution {

        private static int[] numberOfWays;

        public static int climbStairs(int n) {
            numberOfWays = new int[n + 1];
            numberOfWays[0] = 1;
            numberOfWays[1] = 1;

            return climbStairs2(n);
        }

        public static int climbStairs2(int n) {
            for (int i = 2; i <= n; i++) {
                numberOfWays[i] = numberOfWays[i-1] + numberOfWays[i-2];
            }

            return numberOfWays[n];
        }
    }
}