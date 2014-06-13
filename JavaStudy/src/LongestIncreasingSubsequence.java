public class LongestIncreasingSubsequence {
	
	public static int findLongestSubsequence(int[] arr) {
        int[] lis = new int[arr.length];
        
        for (int i = 0; i < lis.length; i++) {
            lis[i] = 1;
		}
		
        for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]){
                    //arr[i] increases the subsequence ending at arr[j]
                	lis[i] = Math.max(lis[i], lis[j] + 1);
                }
			}
		}
        int maxSubLen = Integer.MIN_VALUE;
        for (int i : lis) {
			maxSubLen = Math.max(maxSubLen, i);
		}
        return maxSubLen;
	}
	
    /* 
     * http://www.geeksforgeeks.org/dynamic-programming-set-14-maximum-sum-increasing-subsequence/
     * 
     * Given an array of n positive integers. Write a program to find the sum of maximum
     * sum subsequence of the given array such that the intgers in the subsequence are 
     * sorted in increasing order. For example, if input is {1, 101, 2, 3, 100, 4, 5}, 
     * then output should be 106 (1 + 2 + 3 + 100), if the input array is {3, 4, 5, 10}, 
     * then output should be 22 (3 + 4 + 5 + 10) and if the input array is {10, 5, 4, 3}, 
     * then output should be 10 
     */
	public static int findLongestSubsequenceSum(int[] arr) {
        int[] lis = arr.clone();
		
        for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]){
                    //arr[i] increases the subsequence ending at arr[j]
                	lis[i] = Math.max(lis[i], lis[j] + arr[i]);
                }
			}
		}
        
        int maxSum = Integer.MIN_VALUE;
        for (int i : lis) {
			maxSum = Math.max(maxSum, i);
		}
        return maxSum;
	}
    
	public static void main(String[] args) {
        System.out.println(findLongestSubsequence(new int[] {11, 10, 12, 1, }));
        System.out.println(findLongestSubsequence(new int[] {11, 10, 12, 1, 2, 3}));
        System.out.println(findLongestSubsequenceSum(new int[] {-1, 10, 12, 1, 2, 3}));
        System.out.println(findLongestSubsequence(new int[] {0, 11, 10, 12, 1, 2, 13}));
        System.out.println(findLongestSubsequenceSum(new int[] {0, 11, 10, 12, 1, 2, 13, 3, 4}));
	}
}