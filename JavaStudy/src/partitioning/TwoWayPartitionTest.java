package partitioning;

import static org.junit.Assert.*;

import org.junit.Test;

public class TwoWayPartitionTest {

	void checkIfPartitioningIsCorrect(int[] array, int pivotIndex){
		if (pivotIndex < 0) return;
		int pivot = array[pivotIndex];
		for (int i = 0; i < pivotIndex; i++) {
			assertTrue(array[i] <= pivot);
		}
		for (int i = pivotIndex + 1; i < array.length; i++) {
			assertTrue(array[i] > pivot);
		}
	}
	
	private static void dump(int[] array){
		for (int i : array){
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
	@Test
	public void testPartition() {
		int[][] arrays = {
				{7,4,8,7,6,5,4},
				{7,8,8,9,8,4},
				{7,8,8,9,8,9},
				{17,8,8,9,8,9},
				{},
				{9},
				{9, 9},
				{8, 9},
				{9, 8},
		};
		for (int[] array : arrays){
			dump(array); 
			int pivotIndex = TwoWayPartition.partition(array); 
			dump(array);
			checkIfPartitioningIsCorrect(array, pivotIndex);
			System.out.println(pivotIndex);
		}
	}

}
