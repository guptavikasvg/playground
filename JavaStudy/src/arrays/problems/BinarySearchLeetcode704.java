package arrays.problems;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BinarySearchLeetcode704 {
    class Solution {
        public int search(int[] nums, int target) {
            int lo = 0;
            int hi = nums.length - 1;
            while (lo <= hi) {
                int mid = (lo + hi)/2;
                if (target < nums[mid]) {
                    hi = mid - 1;
                } else if (target > nums[mid]) {
                    lo = mid + 1;
                } else {
                    return mid;
                }
            }

            return -1;
        }
    }

    @Test
    public void test() {
        int[] nums = new int[]{0};
        assertEquals(0, new Solution().search(new int[]{0}, 0));
        assertEquals(-1, new Solution().search(new int[]{1}, 0));
        assertEquals(-1, new Solution().search(new int[]{1,2}, 0));
        assertEquals(0, new Solution().search(new int[]{1,2}, 1));
        assertEquals(1, new Solution().search(new int[]{1,2}, 2));
        assertEquals(-1, new Solution().search(new int[]{1,2}, 0));
        assertEquals(-1, new Solution().search(new int[]{-1,0,3,5,9,12}, 13));
    }
}
