
public class ReverseString {

    private static final String str = "Reverse my string!";
    
    //str = null, "", "x", "xy", ....
    
    public String reverse(String str) {
        if (str == null || str.length == 0) {
            return str;
        }
        
        StringBuilder sb = new StringBuilder(str.length);
        
        for (int i = str.length - 1; i >= 0; i--) {
            sb.append(str.charAt(i));
        }
        
        return sb.toString();
    }
   
    public static void main(String[] args) {
 


    }
}}
