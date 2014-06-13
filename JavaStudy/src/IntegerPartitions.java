// http://www.careercup.com/question?id=14947116

/*
Given an integer (assume it's smaller than 50), write an algorithm that will generate all possible combinations of integers greater than 1 and they produce a sum equals to this number. The same number can appear more than once in a combination. What's the time complexity of your algorithm?

For example:
<=1 -> {}
2 -> {2},
3->{3},
4->{[4], [2, 2]},
5->{[5], [3, 2]},
6->{[6], [4, 2], [3, 3], [2, 2, 2]}
7->{[7], [5, 2], [4, 3], [3, 2, 2]}
8->{[8], [6, 2], [5, 3], [4, 4], [4, 2, 2], [3, 3, 2], [2, 2, 2, 2]}
*/
import java.util.ArrayList;
import java.util.List;

public class IntegerPartitions {
	   public static List<String> partition(int n) {
	    	List<String> partitions = new ArrayList<String>();
	        partition(n, n, "", partitions);
	        return partitions;
	    }

	public static void partition(int n, int max, String prefix, List<String> partitions) {
		if (n == 0) {
			partitions.add(prefix);
			return;
		}

		for (int i = Math.min(max, n); i > 1; i--) {
			partition(n-i, i, prefix + " " + i, partitions);
		}
	}

	public static void main(String[] args) {
		for(String partition: partition(8)){
			System.out.println(partition);
		}
	}
}