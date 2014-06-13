import java.util.HashSet;
import java.util.Set;

//Generate all possible combinations (of r elements) inside an array of size N
//Complexity seems to be n^k as each smaller subset is generated.

public class GenerateRSubset {

	public static void generateSubsets(Set s, int[] array, int start, int end, int subsetSize){
        if (subsetSize == 0) return;
        if (subsetSize == 1) {
        	for (int i = start; i <= end; i++){
        		s.add(Integer.toString(array[i]));
        	}
        	return;
        }
        
        if (subsetSize == end - start + 1){
        	StringBuilder s1 = new StringBuilder();
        	for (int i = start; i <= end; i++){
                s1.append(array[i]); 
        	}
            s.add(s1.toString());
            return;
        }
        
		//get all subsets of size r from array from 0 to end-1
		generateSubsets(s, array, start, end - 1, subsetSize);
		
		Set s2 = new HashSet();
		generateSubsets(s2, array, start, end - 1, subsetSize - 1);
        //now add array[end] to all elements in s2
        for (Object o: s2){
        	s.add( ((String)o).concat(array[end] + ""));
        }
	}
	
	public static void main(String[] args){
		int[] array = {0,1,2,3,4};
		Set s = new HashSet();
		generateSubsets(s, array, 0, 4, 4 );
        
        for (Object o: s){
            System.out.println(o);
        }
	}
}
