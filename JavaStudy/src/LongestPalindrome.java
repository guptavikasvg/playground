public class LongestPalindrome {
    static void expandE(String str, int i, int[] longestPalindromeEven){
    	int span = 0;
		int index = i;
		int nextIndex = i + 1;
    	while(true){
    		if (index < 0 || nextIndex >= str.length())
    			break;
            if (str.charAt(index) == str.charAt(nextIndex)){
            	span += 2;
            	index --;
            	nextIndex++;
            } else {
            	break;
            }
    	}
    	longestPalindromeEven[i] = span;
    }

    static void expandO(String str, int i, int[] longestPalindromeOdd){
    	int span = 1;
		int index = i - 1;
		int nextIndex = i + 1;
    	while(true){
    		if (index < 0 || nextIndex >= str.length())
    			break;
            if (str.charAt(index) == str.charAt(nextIndex)){
            	span += 2;
            	index --;
            	nextIndex++;
            } else {
            	break;
            }
    	}
    	longestPalindromeOdd[i] = span;
    }
    
    static int[] getMax(int[] arr){
        int maxLength = 0;
        int maxIndex = -1;
        for (int i = 0; i < arr.length; i++){
        	int len = arr[i];
        	if (maxLength < len){
        		maxLength = len;
        		maxIndex = i;
        	}
        }
    	
        int[] retval = new int[2];
        retval[0] = maxLength;
        retval[1] = maxIndex;
        
        return retval;
    }
    
    static void longestPalindrome(String str) {
    	int[] longestPalindromeOdd  = new int[str.length()];
    	int[] longestPalindromeEven = new int[str.length()];
    	
        for (int i = 0; i < str.length(); i++){
        	expandE(str, i, longestPalindromeOdd);
        	expandO(str, i, longestPalindromeEven);
        }
    	
        int[] max = getMax(longestPalindromeEven);
        int[] max2 = getMax(longestPalindromeOdd);
        
        int maxIndex = -1;
        int maxLen = 0;
        String palin;
        if (max[0] > max2[0]){
        	maxIndex = max[1];
        	maxLen	 = max[0];
            palin = str.substring(maxIndex - maxLen/2 , maxIndex + maxLen/2 + 1);
        } else {
        	maxIndex = max2[1];
        	maxLen	 = max2[0];
            palin = str.substring(maxIndex - maxLen/2 + 1, maxIndex + maxLen/2 + 1);
        }
        
        System.out.println("str = " + str + " palin = " + palin);
    }
	
	public static void main(String[] args) {
        longestPalindrome("madap");
        longestPalindrome("mad");
        longestPalindrome("m");
        longestPalindrome("cabaeefeefee");
	}

}
