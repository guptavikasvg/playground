import java.util.Scanner;

public class LongestIncreasingSubsequence2 {
    // pocketgems coding test problem from interviewstreet
    /**
     * 
    Question 2 / 2 (Increasing subsequence with maximum weight)
    
    Given A = [(a1, w1), (a2, w2), .., (an, wn)], find subsequence B = [(b1, v1), (b2, v2), …, (bk, vk)] such that b1 < b2 < … < bk and v1 + v2 + … + vk is maximized.
    
     
    
    Input format:
    
    The first line of each test case contains an integer n denoting the number of elements in the sequence.
    
    This is followed by a line containing n integers (space separated) denoting the values ai
    
    The next line contains n integers (space separated) denoting the values wi
    
    The input terminates when n = 0
    
    1 <= n <= 20000
    
    0 <= ai, wi <= 10000
    
    Output format:
    
    One line per test case containing the maximum value of the sum v1 + v2 + … + vk over all increasing subsequences.
    */
	public static void main2() {
		{int[] arr = {4,1,2,0}; int[] value = {100,1,2,3}; System.out.println(findLongestSubsequence2(arr, value, 4));}
		{int[] arr = {4,1,2,0}; int[] value = {1,1,4,3}; System.out.println(findLongestSubsequence2(arr, value, 4));}
		{int[] arr = {4,1,2,5}; int[] value = {4,1,4,4}; System.out.println(findLongestSubsequence2(arr, value, 4));}
		{int[] arr = {4,1,2,5}; int[] value = {6,1,4,4}; System.out.println(findLongestSubsequence2(arr, value, 4));}
		
		Scanner scanner = new Scanner(System.in);
		while (true){
    		int n = scanner.nextInt();
            if (n <= 0) break;
            int[] arr = new int[n];
    		for (int i = 0; i < n; i++){
    			arr[i] = scanner.nextInt();
    		}
            int[] value = new int[n];
    		for (int i = 0; i < n; i++){
    			value[i] = scanner.nextInt();
    		}
            
    		System.out.println(findLongestSubsequence2(arr, value, n));
		}
	}
	public static int findLongestSubsequence2(int[] arr, int[] value, int n) {
        int[] sum = value.clone();
        
        for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]){
                    //arr[i] increases the subsequence ending at arr[j]
                	sum[i] = Math.max(sum[i], sum[j] + value[i]);
                }
			}
		}
        
        int maxSum = Integer.MIN_VALUE;
        for (int i : sum) {
			maxSum = Math.max(maxSum, i);
		}
        return maxSum;
	}
    
	public static void main(String[] args) {
		main2();
	}
}