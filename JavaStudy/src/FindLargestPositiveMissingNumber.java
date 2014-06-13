public class FindLargestPositiveMissingNumber {

	public static void main(String[] args) {
		{int arr[] = {2,3,4,7,1};System.out.println(minPositive2(arr));}
		{int arr[] = {2,-3,4,7,11};System.out.println(minPositive2(arr));}
	}

    static int minPositive2(int a[]) {
        int n = a.length;
        
        for (int v : a) System.out.print(v); System.out.println();
        
        for (int i = 0; i < n; i++){
        	//start at ith element and find its final place. The value that it replaces - we find its final place as well and so on..
        	
        	int value = a[i];
            while (true){
                int valueFinalIndex = value - 1;
            	if (valueFinalIndex < 0 || valueFinalIndex >= n) break;
                
            	//value is at its final index
            	if (value == a[valueFinalIndex]) break;
                
                int newValue = a[valueFinalIndex];
                
                a[valueFinalIndex] = value;
                value = newValue;
            }
            for (int v : a) System.out.print(v); System.out.println();
        }
    	
        //find the index which doesn't have index+1 in it.
        for (int i = 0; i < n; i++){
            if (a[i] != i+1) return i+1;
        }
        return n+1;
    }
}