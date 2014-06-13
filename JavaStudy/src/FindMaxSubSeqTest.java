import static org.junit.Assert.*;

import org.junit.Test;

public class FindMaxSubSeqTest {

	@Test
	public void testGetMaxSubSeqNonAdjacent() {
		int[][] arrays = {
	        {10, -1, -20, 35},
	        {-10, -20, 35},
	        {1,1, -20, 35},
	        {-1, -1, 20, -35},
	        {4, 1, 20, 50},
	        {-3, 21, 20, -5, 100},
	        {-3, 21, 22, -5, 100},
	        {30, -21, -22, -5, -100},
	        {30, -21, -22, -5, 1},
	        {10, 1, 3, 25, 2, 4, 20}
        };
        int[] output = {
						45,
						35,
						36,
						20,
						54,
						121,
						122,
						30,
						31,
						55
        };
        
        for (int j = 0; j < arrays.length; j++){
            int maxsum = FindMaxSubSeq.getMaxSubSeqNonAdjacent(arrays[j]); 
            assertEquals(maxsum, output[j]); 
        }
	}
}
