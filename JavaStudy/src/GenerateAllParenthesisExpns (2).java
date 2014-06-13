import java.util.Stack;

//0 - (
//1 - {
//2 - [
public class GenerateAllParenthesisExpns {

    static char[][] map;
	static {
		
		map = new char[3][2];
		map[0][0] = '(';
		map[1][0] = '{';
		map[2][0] = '[';
        
		map[0][1] = ')';
		map[1][1] = '}';
		map[2][1] = ']';
	}
    
    static boolean noMoreBracketsAvailable(int[] openAvailable, int[] closeAvailable)
    {
    	for (int i = 0; i < 3; i++){
    		if (openAvailable[i] > 0 || closeAvailable[i] > 0)
    			return false;
    	}
        return true;    	
    }
    
    // returns true if e.g. c1 = ( and c2 = ) etc.
    static boolean arePairs(Character c1, Character c2){
    	for (int i = 0; i < 3; i++){
            if (c1 == map[i][0] && c2 == map[i][1])
            	return true;
    	}
    	return false;
    	
    }
    
    static int findPossibleCloseBracket(String s){
    	Stack<Character> stack = new Stack<Character>();
    	for (int i = s.length() - 1; i >= 0; i--){
    		char c = s.charAt(i);
            if (stack.size() == 0){
            	// check if we have found our bracket
        		for (int j = 0; j < 3; j++){
        			if (map[j][0] == c)
        				return j;
        		}
            } else if (stack.size() >= 1){
            	//check if we can remove pairs
            	char peek = stack.peek();
                if (arePairs(c, peek)) {
                	stack.pop();
                	continue;
                } 
            }
        	stack.add(c);
    	}
    	return -1;
    }
    
    static void printExpns(String s, int[] openAvailable, int[] closeAvailable)
    {
    	if (noMoreBracketsAvailable(closeAvailable, closeAvailable)){
    		System.out.println(s);
    		return;
    	}
    	
    	//try adding any of the 3 open brackets
        if (openAvailable[0] > 0) {
        	openAvailable[0]--;
        	printExpns(s + "(", openAvailable, closeAvailable);
        	openAvailable[0]++;
        }
        if (openAvailable[1] > 0) {
        	openAvailable[1]--;
        	printExpns(s + "{", openAvailable, closeAvailable);
        	openAvailable[1]++;
        }
        if (openAvailable[2] > 0) {
        	openAvailable[2]--;
        	printExpns(s + "[", openAvailable, closeAvailable);
        	openAvailable[2]++;
        }
        
    	//try adding any of the 3 close brackets
        int closeBracketType = findPossibleCloseBracket(s);
        if (closeBracketType != -1){
            assert (closeAvailable[closeBracketType] > 0);
        	closeAvailable[closeBracketType]--;
        	printExpns(s + map[closeBracketType][1], openAvailable, closeAvailable);
        	closeAvailable[closeBracketType]++;
        }
    }
    
	public static void main(String[] args) {
		{int[] openAvailable = {1,1,1}; printExpns("", openAvailable, openAvailable.clone());}
		{int[] openAvailable = {2,1,1}; printExpns("", openAvailable, openAvailable.clone());}
	}

}
