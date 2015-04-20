import java.util.Vector;

public class FindMaxSubSeq {

	// http://www.careercup.com/question?id=14960045
	// Given unsorted array (contains -ve numbers also), write a method to return max sum. Condition is two numbers should not adjacent to each other.
    static int getMaxSubSeqNonAdjacent(int[] array) {
        int sumTillBoundary   = array[1];
        int sumBeforeBoundary = array[0];

        for (int i = 2; i < array.length; i++){
            int sumBeforeBoundary2 = sumBeforeBoundary;
            
            sumBeforeBoundary = Math.max(sumTillBoundary, sumBeforeBoundary);
            sumTillBoundary   = Math.max(sumBeforeBoundary2 + array[i], array[i]); 
        }
        
        return Math.max(sumTillBoundary, sumBeforeBoundary);
    }
    
    static int getMaxSubSeq2(int[] array) {
        int sumTillBoundary   = array[0];
        int sumBeforeBoundary = array[0];

        for (int i = 1; i < array.length; i++){
            sumTillBoundary = Math.max(sumTillBoundary + array[i], array[i]);
            sumBeforeBoundary = Math.max(sumBeforeBoundary, sumTillBoundary);
        }
        
        return Math.max(sumTillBoundary, sumBeforeBoundary);
    }
    
    //find max subseq in rotated array
    static int getMaxSubSeq3(int[] array){
        int sum = getMaxSubSeq2(array);

//        System.out.println("sum = " + sum);

        //now negate the array
        int[] arrayNegated = new int[array.length];
        int sumOfAllElements = 0;
        for (int i = 0; i < arrayNegated.length; i++){
        	arrayNegated[i] = -array[i];
            sumOfAllElements += array[i];
        }
        
        int sumInNegatedArray = getMaxSubSeq2(arrayNegated);
//        System.out.println("sumInNegatedArray = " + sumInNegatedArray);
        
        int sum3 = sumInNegatedArray + sumOfAllElements;
//        System.out.println("sum3 = " + sum3);
        if (sum3 == 0)
        	return sum;
        
        return Math.max(sum, sum3);    	
    }
    
    public static void main(String[] args) {
        Vector<int[]> arrays = new Vector<int[]>();
        
        arrays.add(new int[] {10, -1, -20, 35});
        arrays.add(new int[] {-10, -1, -20, 35});
        arrays.add(new int[] {1,1, -20, 35});
        arrays.add(new int[] {-1, -1, 20, -35});
        arrays.add(new int[] {-4, -1, 20, -5});
        arrays.add(new int[] {-3, -1, 20, -5, 100});
        
        for (int[] array : arrays){
            for (int i : array) {
            	System.out.print(i +" ");
            }
            int maxsum = FindMaxSubSeq.getMaxSubSeq3(array); System.out.println("sum= " + maxsum);
        }
    }
}
