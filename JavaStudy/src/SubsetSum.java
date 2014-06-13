import java.util.HashMap;
import java.util.Map;

/**
 * Handles negative numbers and negative k as well
 * 
 * @author vgupta
 *
 */
public class SubsetSum {

	static boolean solve(int[] arr, int k) {
		int min = Integer.MIN_VALUE;
		
		int maxSum = 0;
		for (int i : arr) {
            if (i > 0) maxSum += i;
		}
        
		int minSum = 0;
		for (int i : arr) {
            if (i < 0) minSum += i;
		}
		Map map = new HashMap();
        
		map.put(0, Boolean.TRUE);
		
		for (int i : arr) {
            for (int j = maxSum; j >= minSum; j--) {
            	if (map.get(j-i) != null) {
            		map.put(j, Boolean.TRUE);
            	}
            }
		}
		
		return map.get(k) != null;
	}
	
	public static void main(String[] args) {
        System.out.println(solve(new int[] {11, 10, 12, 1, }, 33));
        System.out.println(solve(new int[] {-11, 10, 12, 1, }, -1));
        System.out.println(solve(new int[] {-5, 10, 12, 1, }, 18));
        System.out.println(solve(new int[] {-5, 10, 12, 1, }, 19));
        System.out.println(solve(new int[] {-5, 10, 12, 1, }, 17));
        System.out.println(solve(new int[] {-5, -10, 12, 1, }, -14));
        System.out.println(solve(new int[] {-5, -10, 12, 1, }, 3));
        System.out.println(solve(new int[] {-5, -10, 12, 1, }, 2));
        System.out.println(solve(new int[] {-5, -10, 12, 1, }, -1));
        System.out.println(solve(new int[] {-5, -10, 12, 1, }, -15));
        System.out.println(solve(new int[] {-5, -10, 12, 1, }, -16));
        System.out.println(solve(new int[] {-11, -10, -12, 1, }, -33));

	}

}
