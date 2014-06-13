package interview.godaddy;

/*
Output: Count the number of words in W equal or greater in length than S.
Input 1: W (string of words)
Input 2: S (minimum size of over-sized word)

Constraints:
0 <= W.length <= 2^10
3 <= S <= 2^7
Words are delimited by any non alpha-numeric characters, and numeric characters are ignored at the beginning of a given word.

Example:
W: "hello good sir!"
S: 5
Output: 1
*/

public class GoDaddy3 {
	static boolean isAlpha(char c){
		return Character.isLetter(c);
	}
	
	static boolean isAlphaNumeric(char c){
		return Character.isLetter(c) || Character.isDigit(c);
	}
	
	static int getOversizedWords(String W, int S) {
	    if (W == null || W.length() == 0)
	        return 0;

	    int count = 0;
	    int i = 1;
	   
	    boolean insideValidWord = isAlpha(W.charAt(0));
	    int wordLen;
	    wordLen = insideValidWord ? 1 : 0;

	    while(i < W.length()) {
	       
	        char c = W.charAt(i);

	        boolean isAlphaNumeric = isAlphaNumeric(c);
        	boolean isAlpha = isAlpha(c);

	        if (insideValidWord) {
	            if (isAlphaNumeric){
                	wordLen++;
	            } else {
            	    if (wordLen >= S) {
                    	count++;
                	}
                	insideValidWord = false;
                    wordLen = 0;
                }
	        } else {
	            if (isAlpha) {
	                insideValidWord = true;
	                wordLen++;
	            }
	        }
	        i++;
	    }

	    if(insideValidWord) {
        	if (wordLen >= S) {
            	count++;
        	}
	    }
	    return count;
	}
    
	public static void main(String[] args) {
		System.out.println(getOversizedWords("apple", 3));
		System.out.println(getOversizedWords("apple", 5));
		System.out.println(getOversizedWords("apple", 6));
		System.out.println(getOversizedWords(" 123app12le 12bc34 ", 4));
		System.out.println(getOversizedWords(" 123app12le 12bc34 ", 3));
		System.out.println(getOversizedWords(" 123app12le 12bc34 ", 5));
		System.out.println(getOversizedWords("123 ", 1));
		System.out.println(getOversizedWords(null, 4));
		System.out.println(getOversizedWords("", 4));
	}
}
