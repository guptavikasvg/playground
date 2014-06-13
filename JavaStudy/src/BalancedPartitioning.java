import java.io.*;
import java.util.*;

/**
 * http://chinmaylokesh.wordpress.com/2011/02/10/balanced-partition-problem-finding-the-minimized-sum-between-two-partitions-of-a-set-of-positive-integers/
 *
 * In Balanced Partition problem,you have a set of n integers each in the range 0 … K. 
 * Partition these integers into two subsets such that you minimize |S1 – S2|, 
 * where S1 and S2 denote the sums of the elements in each of the two subsets.
 */
public class BalancedPartitioning
{
    public static void main (String [] args) throws IOException {
        int sum = 0;
        System.out.println("Enter the number of array elements");
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int[] array = new int[N];
        System.out.println("Enter the Positive elements of the array");
        for(int member = 0; member < N ; member++){
            array[member] = input.nextInt();
            sum += array[member];      
        }
       
        //sol[i] means that sum of i is possible with some subset of the array
        boolean [] sol = new boolean [sum / 2 + 1];
         
        sol[0] = true;//empty array
        for (int i : array){
            for (int j = sum / 2; j >= i; j--){
                if (sol [j - i])
                    sol [j] = true;
            }
        }
                      
        int halfsumcloser = sum / 2;
        
        for (; !sol [halfsumcloser]; halfsumcloser--);
        
        System.out.println ("The Minimum sum After partioning the array is :" +((sum - halfsumcloser) - halfsumcloser));
    }
}