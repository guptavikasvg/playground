//1) Given a string, check if it is a palindrome by ignoring spaces. E.g. race car 
//would be a palindrome.
 
import java.io.IOException;

public class PalindromeWithSpace {
 
    static boolean isPalindrome(String s) throws IOException {
        if(s == null) throw new IOException("String is null");
        if(s.length() < 1) return false;
        int i=0;
        int j= s.length()-1;
        while(i < j) {
            while(s.charAt(i) == ' ')
                i++;
            while(s.charAt(j) == ' ')
                j--;
            if(s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
    public static void main(String[] args) throws IOException{
        //true
        System.out.println(isPalindrome("race car"));  
        //true
        System.out.println(isPalindrome("race ca  r"));
        //true
        System.out.println(isPalindrome(" ra  ce car "));
        //false
        System.out.println(isPalindrome("ra ce ar"));
    }
}
