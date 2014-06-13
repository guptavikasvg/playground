
public class CountWords2 {

	enum STATE {
		LETTER,
		WHITESPACE,
		NONE
	};
	
    static int count(String str){
    
        int count = 0;
            
//    	if (str == null) return 0;
    	
    	STATE state = STATE.NONE;
        
    	for (int i = 0; i < str.length(); i++){
        	STATE newState = Character.isWhitespace(str.charAt(i)) ? STATE.WHITESPACE : STATE.LETTER;
			
        	if (state != STATE.LETTER && newState == STATE.LETTER) 
        		count++;
        	
        	state = newState;
    	}
    	
    	return count;
    }
    
	public static void main(String[] args) {
        System.out.println(count(" abc def\t efg "));
        System.out.println(count(""));
        System.out.println(count(null));
        System.out.println(count(" \n\t"));
        System.out.println(count("abc"));
        System.out.println(count("\nabc    def    \t  egg \t\n"));

	}

}
