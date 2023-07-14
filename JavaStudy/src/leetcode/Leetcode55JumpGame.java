package leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * ou are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.
 * <p>
 * Return true if you can reach the last index, or false otherwise.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Example 2:
 * <p>
 * Input: nums = [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 104
 * 0 <= nums[i] <= 105
 */
class Solution {
    public boolean canJump(int[] nums) {
        int maxReachableIndex = Integer.MIN_VALUE;

        int n = nums.length;

        for (int i = 0; i < n; i++) {
            maxReachableIndex = Math.max(maxReachableIndex, i + nums[i]);

            if (maxReachableIndex >= n - 1) return true;

            if (i == maxReachableIndex) return false;
        }

        return false;
    }
}

public class Leetcode55JumpGame {

    @Test
    public void test1() {
        assertTrue(new Solution().canJump(new int[]{0}));
        assertFalse(new Solution().canJump(new int[]{0, 0}));
        assertTrue(new Solution().canJump(new int[]{1, 0}));
        assertTrue(new Solution().canJump(new int[]{1, 1}));
        assertTrue(new Solution().canJump(new int[]{1, 1, 0}));
        assertFalse(new Solution().canJump(new int[]{1, 0, 0}));
        assertTrue(new Solution().canJump(new int[]{4, 3, 2, 1, 0}));
        assertTrue(new Solution().canJump(new int[]{4, 3, 2, 2, 0, 0}));
        assertFalse(new Solution().canJump(new int[]{4, 3, 2, 1, 0, 0}));
        assertTrue(new Solution().canJump(new int[]{2, 3, 1, 1, 4}));
        assertFalse(new Solution().canJump(new int[]{3, 2, 1, 0, 4}));
    }
}