public class FindMaxContiguousProduct {

	static int maxProductBruteForce(int[] array){
        int max = 0;
		for (int i = 0; i < array.length; i++) {
            int product = 1;
            for (int j = i; j < array.length; j++) {
				product *= array[j];
			}
            max = Math.max(max,  product);
		}
		return max;
	}
    
	static int maxProduct(int[] array){
		int minProduct = array[0];
		int maxProduct = array[0];
		
		int max = maxProduct;
		
        int len = array.length;
        
		for (int i = 1; i < len; i++){
			int new1 = minProduct * array[i];
			int new2 = maxProduct * array[i];
			int new3 = array[i];
			
			maxProduct = Math.max(Math.max(new1, new2), new3);
			minProduct = Math.min(Math.min(new1, new2), new3);
            
			max = Math.max(max, maxProduct);
		}
		
        return max;
	}
	
    static int[] getRandArray(){
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++){
        	arr[i] = (int) (Math.random() * 10);
            if (Math.random() < .5) arr[i] = -arr[i];
        }
        return arr;
    }
    
	public static void main(String[] args) {
//		System.out.println(maxProduct(new int[]{-1}));
//		System.out.println(maxProduct(new int[]{-1, -2}));
//		System.out.println(maxProduct(new int[]{-1, -2, 0}));
//		System.out.println(maxProduct(new int[]{-1, -2, 0, 3}));
//		System.out.println(maxProduct(new int[]{-1, -2, 3}));
//		System.out.println(maxProduct(new int[]{-1, -2, 3, -4}));
//		System.out.println(maxProduct(new int[]{-2, 2, 3, -4}));
//		System.out.println(maxProduct(new int[]{-2, 0, -4}));
//		System.out.println(maxProduct(new int[]{-2, 0, -3, -4, 0, -4}));
        
		while(true){
			int[] arr = getRandArray();
			for (int i : arr) {
				//System.out.print(i +" ");
			}
			//System.out.println(maxProduct(arr));
			assert maxProduct(arr) == maxProductBruteForce(arr);
		}
	}

}
