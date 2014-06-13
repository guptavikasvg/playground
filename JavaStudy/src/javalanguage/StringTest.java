package javalanguage;

public class StringTest {

    static void equals(String s1, String s2, String print){
        if (s1 == s2) {
        	System.out.println(print + " is true");
        } else {
        	System.out.println(print + " is not true");
        }
    	
    }
	public static void main(String[] args) {
        String s1 = new String("abc");
        String s2 = new String("abc");
        String s3 = "abc";
        String s4 = "abc";
        
        equals(s3, s4, "s3 == s4"); //EQUAL
        equals(s1, s3, "s1 == s3"); //NOTEQUAL
        equals(s1, s2, "s1 == s2"); //NOTEQUAL
        //char[] chars = "abc"; //"abc" is a String. Can't assign to char[]
        
        s1 = s1.intern();
        s2 = s2.intern();
        equals(s1, s2, "s1 == s2"); //EQUAL
        equals(s1, s3, "s1 == s3"); //EQUAL
	}
}