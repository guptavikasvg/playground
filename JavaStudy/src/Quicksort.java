//TODO do like in cormen. code is much much simpler
public class Quicksort {

    static void partition(int[] arr){
    	//partition around 0th element
        
    	int l = 0; //start of strictly large segment
    	
        int pivot = arr[0];
    	for (int c = 1; c< arr.length; c++){
    		if (arr[c] > pivot){
                //Found strictly larger element
                if (l == 0) l = c;
    		} else {
                //Found element that <= pivot
    			if (l >= 1)	{
    				//swap l and c
    				int temp = arr[l];
    				arr[l] = arr[c];
    				arr[c] = temp;
                    l++;
    			}
    		}
    	}
        
        int index = -1;
    	//move pivot into final position
    	if (l == 0){
    		//all elements from 0 to len-1 are smaller than or equal to pivot
    		//swap 0 with last element
            index = arr.length - 1;
    	} else if (l == 1) {
    		//all elements are larger than pivot    		
    	} else if (l >=2 && l < arr.length) {
    		//swap l-1 && 0
            index = l-1;
    	}
    
    	if (index != -1){
			int temp = arr[index];
			arr[index] = arr[0];
			arr[0] = temp;    		
    	}
    	
    }
    
    static void dump(int[] arr){
    	for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
    }
    
	public static void main(String[] args) {
		{int[] arr = {10,}; partition(arr);dump(arr);}
		{int[] arr = {10,11}; partition(arr);dump(arr);}
		{int[] arr = {11,10}; partition(arr);dump(arr);}
		{int[] arr = {10,9,8,7}; partition(arr);dump(arr);}
		{int[] arr = {10,15,20}; partition(arr);dump(arr);}
		{int[] arr = {10,15,5}; partition(arr);dump(arr);}
		{int[] arr = {10,5,20}; partition(arr);dump(arr);}
		{int[] arr = {10,5,1}; partition(arr);dump(arr);}
	}

}
