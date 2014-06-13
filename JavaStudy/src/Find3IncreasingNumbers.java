// 1) You are given an array of integers, say a. 
// Find i, j, k in the array such that a[i] < a[j] < a[k]. 
// Expected time complexity is O(n), and space complexity is O(1).
public class Find3IncreasingNumbers {

    static void findIncreasingSubsequence(int[] arr){
    	
    	boolean up = arr[1] > arr[0];
    	int i = 0;
    	int j = 1;
        
    	for (int p = 2; p < arr.length; p++) {
            if (up) {
            	if (arr[p] > arr[j]) {
            		//found
                    System.out.println(i + "," + j + "," + p);
                    break;
            	}else if (arr[p] > arr[i]){
            		j = p;
            	} else {
                	//compare p with p-1
                	if (arr[p] > arr[p-1]){
                		up = true;
                		i = p-1;
                		j = p;
                	}
            	}
            } else {
            	//compare p with p-1
            	if (arr[p] > arr[p-1]){
            		up = true;
            		i = p-1;
            		j = p;
            	}
            }
		}
    }
    
	public static void main(String[] args) {
		{int[] arr = {1,2,3}; findIncreasingSubsequence(arr);}
		{int[] arr = {1,3,2,4}; findIncreasingSubsequence(arr);}
		{int[] arr = {1,3,0,1,4}; findIncreasingSubsequence(arr);}
		{int[] arr = {1,3,0,1,2}; findIncreasingSubsequence(arr);}
		{int[] arr = {10,9,1,8, 7, 2, 6,5}; findIncreasingSubsequence(arr);}

	}
}