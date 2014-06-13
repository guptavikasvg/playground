package strings;

public class ReverseString {

    static void reverseStr(StringBuilder str){
    	int len = str.length();
    	
    	for (int i = 0; i < len/2; i++){
            char c = str.charAt(len-i-1);
            str.setCharAt(len-i-1, str.charAt(i));
    		str.setCharAt(i, c);
    	}
    }
    
	public static void main(String[] args) {
		{StringBuilder str = new StringBuilder("abc"); reverseStr(str); System.out.println(str);}
		{StringBuilder str = new StringBuilder("c"); reverseStr(str); System.out.println(str);}
		{StringBuilder str = new StringBuilder("ca"); reverseStr(str); System.out.println(str);}
	}
}
