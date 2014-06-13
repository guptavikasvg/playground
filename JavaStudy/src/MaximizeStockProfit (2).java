//http://stackoverflow.com/questions/7086464/interview-question-maximum-single-sell-profit

public class MaximizeStockProfit {

	static int findMax(int[] arr){
		int min = arr[0];
		int max = arr[0];
		int bestProfit = max - min;
		int n = arr.length;
		for (int i = 1; i < n; i++ ){
			int p = arr[i];
			
			if (p > max) {
				max = p;
				bestProfit = Math.max(bestProfit, max-min);
			} 
			if (p < min){
				min = max = p;				
			}
		}
		
        return bestProfit;
	}
	
	public static void main(String[] args) {
		{int[] prices = {40, 100, 150, 30, 100, 1, 200}; int profit = findMax(prices); System.out.println(profit);}
		{int[] prices = {40, 100, 150, 30, 100, 1, 5}; int profit = findMax(prices); System.out.println(profit);}
		{int[] prices = {40}; int profit = findMax(prices); System.out.println(profit);}
		{int[] prices = {50, 40}; int profit = findMax(prices); System.out.println(profit);}
		{int[] prices = {50, 60}; int profit = findMax(prices); System.out.println(profit);}
	}

    
}
