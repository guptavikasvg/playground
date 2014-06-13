//http://anandtechblog.blogspot.in/2011/01/dynamic-programming-qvh-quaint-valley.html
/*
 * Yuckdonald's is considering opening a series of restaurants along
Quaint Valley Highway (QVH).The n possible locations are along a
straight line, and the distances of these locations from the start of
QVH are, in miles and in increasing order,m1;m2; : : : ;mn. The
constraints are as follows:
1)At each location,Yuckdonald's may open at most one restaurant.The
expected profi t from opening a restaurant at location i is pi, where
pi > 0 and i = 1; 2; : : : ; n.
2)Any two restaurants should be at least k miles apart, where k is a
positive integer.
Give an effi cient algorithm to compute the maximum expected total
pro fit subject to the given
constraints.
 */
public class RestaurantPlanning {
    static int maxProfit(int[] profits, int[] distances, int minDistance){
 
    	int n = profits.length;
    	
    	int[] maxProfit = profits.clone();
    	
    	for (int i = 1; i < n; i++){
        	for (int j = 0; j < i; j++){
                int dist = distances[i] - distances[j];
                if (dist >= minDistance){
                	maxProfit[i] = Math.max(maxProfit[i], profits[i] + maxProfit[j]);
                }
        	}
    	}
    	
        int max = Integer.MIN_VALUE;
        
        for (int p : maxProfit) {
			max = Math.max(max, p);
		}
    	return max;
    }

	public static void main(String[] args) {
		{System.out.println(maxProfit(new int[]{1,10,1}, new int[]{1,3,5}, 2));}
		{System.out.println(maxProfit(new int[]{1,10,1}, new int[]{1,3,5}, 3));}
		{System.out.println(maxProfit(new int[]{20,9,10,8}, new int[]{0,1,11,12}, 10));}
		{System.out.println(maxProfit(new int[]{20,9,10,28}, new int[]{0,1,11,12}, 10));}
        
		{System.out.println(maxProfit(new int[]{20,9,10,28,1}, new int[]{0,1,11,12,13}, 1));}
        
		{System.out.println(maxProfit(new int[]{5,9,1,6,2,8,3}, new int[]{0,1,4,10,18,27,39}, 5));}
		{System.out.println(maxProfit(new int[]{10,9,1,6,2,8,3}, new int[]{0,1,4,10,18,27,39}, 5));}
	}
}