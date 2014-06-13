public class ArrayRotation {
	
	//rotate arr[start] to arr[end] to the right k times
    static void rotate2(int[] arr, int start, int end, int k){
    	int n = end - start + 1;
    	
    	k = k % n;
    	
    	if (k > n- k) {
	//now k <= n-k
    	
	int a = start;
	int c = n - k + start;
    	
	swap(arr, a, c, k);
    	
	rotate2(arr, start, c - 1, k);
    		
    	} else {
    		
    	}
    	
    }
    
    static void swap(int[] arr, int start, int start2, int k){
    	for (int i = 0; i < k; i++){
    		int temp = arr[start+i];
    		arr[start+i] = arr[start2+i];
    		arr[start2+i] = temp;    		
    	}
    }
    
	public static void main(String[] args) {

	}

}
