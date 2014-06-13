//http://www.geeksforgeeks.org/archives/767

public class StringPermutations {
    static void swap(StringBuilder str, int i, int j){
    	char c = str.charAt(i);
    	str.setCharAt(i, str.charAt(j));
    	str.setCharAt(j, c);
    }

    static boolean dup(StringBuilder str, int i, int j){
		if (i == j) return false;
		
        //explanation:
		//apepq
		//this method will return true when we try to swap the first a and last p, because there is a between them and p got a chance to be at pos 0
		for (int p = i; p <j ; p++) {
			if (str.charAt(j) == str.charAt(p)) return true;
		}
    	return false;
    }
    
    static void permute(StringBuilder str, int start, int end){
        if (start == end) {
    		System.out.println(str.toString());
            return;        	
        }
    	for (int i = start; i <=end; i++){
            //check for dup
            if (dup(str, start, i)) continue;
    		swap(str, start, i);
    		permute(str, start+1, end);
    		swap(str, start, i);
    	}
    }
    
	public static void main(String[] args) {
		StringBuilder str = new StringBuilder();
		str.append("apppp");
        permute(str, 0, 4);
	}
}
