// C:\Users\vgupta\Downloads\dp_2.swf

public class ChooseMinimumCoins {

    	
    public void findMinimumCoins(int[] denoms, int sum){
        int[] numberOfCoins;
        
    	numberOfCoins = new int[sum+1];
    	
        findMinimumCoins(denoms, numberOfCoins, nextLowerCoins, sum);
        
        System.out.println("sum = " + sum + " coins = " + numberOfCoins[sum]);
    }
    
    public void findMinimumCoins(
    	int[] denoms,
        int[] numberOfCoins,
        int sum) {
        
        //first lookup
        
    	if (sum <= 0 || numberOfCoins[sum] != 0)
    		return;
    	
        if (sum == 1){
        	numberOfCoins[1] = 1;
            return;
        }
    	int minSum = Integer.MAX_VALUE;
    	for (int i = 0; i < denoms.length; i++){
            if (denoms[i] > sum) continue;
            
            findMinimumCoins(denoms, numberOfCoins, sum - denoms[i]); 
            int newSum = numberOfCoins[sum - denoms[i]] + 1; 
    		if (minSum > newSum){
    			minSum = newSum;
    		}
    	}
    	
    	numberOfCoins[sum] = minSum;
    }
    	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
        ChooseMinimumCoins test = new ChooseMinimumCoins();
        
        int[] denoms = {1,5,50,51,52};
        test.findMinimumCoins(denoms, 56);
        test.findMinimumCoins(denoms, 4);
        test.findMinimumCoins(denoms, 5);
        test.findMinimumCoins(denoms, 53);
	}
}
