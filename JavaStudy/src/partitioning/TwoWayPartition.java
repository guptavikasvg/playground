package partitioning;

public class TwoWayPartition {

	static int partition(int[] array){
		if (array.length == 0)
			return -1;
		if (array.length == 1)
			return 0;
		int pivot = array[0];
		int len = array.length;
		
		int L = 1;
		int R = len - 1;
		
		while(L <= R){
			
			//move L till u find something that needs to be swapped
			while (L <= len - 1){
				if (array[L] <= pivot) {
					L++;
				} else {
					break;
				}
			}
			
			//move R till u find something that needs to be swapped
			while (R >= 0){
				if (array[R] <= pivot) {
					break;
				} else {
					R--;
				}
			}
			
			if (L < R && R != 0){
				//now swap L & R
				swap(array, L, R);
			}
		}
		
		assert L == R + 1;
		if (R != 0){
			//now swap R & pivot
			swap(array, 0, R);
		}
		
		return R;
	}

	private static void swap(int[] array, int l, int r) {
		int temp = array[l];
		array[l] = array[r];
		array[r] = temp;
	}

	public static void main(String[] args) {
		int[] array={7,4,8,7,6,5,4}; 
		int pivotIndex = partition(array);
		System.out.println(pivotIndex);
	}
}
