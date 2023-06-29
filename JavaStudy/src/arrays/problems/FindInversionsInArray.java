package arrays.problems;

public class FindInversionsInArray {

    static void updateInversionCount(int left1, int left2, int[] output, int l, int L, int m, int[] inversionCount){
        if ( l >= left1) {
        	int index = l - left1; 
            //going from index to m
        	if (m > index) {
        		inversionCount[0] += (m - index);
        	}
        } else if (L >=left2) {
        	int index = L - left1; 
            //going from index to m
        	if (m > index) {
        		inversionCount[0] += (m - index);
        	}
        }
    }
    
	static void merge(int[] array, int left1, int right1, int left2, int right2, int[] inversionCount){
        assert right1 == left1 + 1;
		int l = left1;
		int L = left2;
		
		int[] output = new int[right1-left1 + right2 - left2 +2];
        int m = 0;
		
		while ( l <= right1 && L <= right2){
			int p = array[l];
			int q = array[L];
            
			if (p < q){
				output[m] = p;
                m++;
				l++;
                updateInversionCount(left1, left2, output, l, -1, m, inversionCount);
			}
			else if (p > q){
				output[m] = q;
                m++;
				L++;
                updateInversionCount(left1, left2, output, -1, L, m, inversionCount);
			}
		}
        
		if (l > right1 && L > right2){
			assert m == output.length;
		}
        
		while ( l <= right1 ){
			int p = array[l];
			output[m] = p;
            m++;
			l++;
            updateInversionCount(left1, left2, output, l, -1, m, inversionCount);
		}
		while ( L <= right2 ){
			int p = array[L];
			output[m] = p;
            m++;
			L++;
            updateInversionCount(left1, left2, output, -1, L, m, inversionCount);
		}
        
        System.arraycopy(output, 0, array, left1, output.length);
	}
	
    static void swap(int[] array, int p, int q){
    	int temp = array[p];
    	array[p] = array[q];
    	array[q] = temp;
    }
    
    static void findInversions(int[] array, int left, int right, int[] inversionCount){
    	
    	if (left == right) return ;
    	if ( left == right - 1){
    		if (array[right] < array[left]){
    			swap(array, left, right);
    			inversionCount[0]++;
    			return;
    		}
    	}
    	        
    	int mid = (left + right) /2;
    	
    	findInversions(array, left, mid, inversionCount);
    	findInversions(array, mid + 1, right, inversionCount);
        
    	merge(array, left, mid, mid+1, right, inversionCount);
    }
    
	public static void main(String[] args) {
        int[] array = {7,3,1,6,2,0}; 
//        int[] array = {7,3,1,}; 
        for (int i : array){
        	System.out.print(i + "");
        }
        System.out.println();
        int[] inversions = new int[1];findInversions(array, 0, array.length - 1, inversions);
        for (int i : array){
        	System.out.print(i + "");
        }
    	System.out.println("\nInversions = " + inversions[0]);
	}
}
