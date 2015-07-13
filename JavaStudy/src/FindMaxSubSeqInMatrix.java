import java.util.Vector;

public class FindMaxSubSeqInMatrix {

    static int getMaxSubSeq2(int[][] array, int rows, int columns) {
        int[][] maxSum = new int[rows][columns];
        
        for (int i = 0; i < rows; i++)
        	maxSum[i][0] = array[i][0];
        
        for (int i = 0; i < columns; i++)
        	maxSum[0][i] = array[0][i];
        
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
//            	maxSum[i][j] =
            			
                        
//            			ABORTED
            			
            			
            }
        }
        
    }
    
    public static void main(String[] args) {
    }
}