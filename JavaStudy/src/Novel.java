///////////////////////
/*
 * 
Problem: Novel String

Program: novel.java

Problem:

The K-doublets of a string of characters are the ordered pairs of characters that are K distance from each other. A string is K-singular if all its K- doublets are different. A string is Novel String if it is K-singular for all possible K distances.

For e.g. take the string FLBL, its 0-doublets are FL, LB and BL. Since all these are different, FLBL is 0-singular. Similarly, its 1-doublets are FB and LL, since they are different FLBL is 1-singular as well. Lastly, the only 2-doublet of FLBL is FL, so FLBL is 2-singular. Hence, FLBL is a Novel String.

Note that the fact that FL is both a 0-doublet and 2-doublet is insignificant as zero and two are different distances.

Input:

The input is one or more non-empty strings of at most 100 capital letters, each string on a line by itself, followed by a line containing only two dollars ($$) signaling the end of the input.

Output:

For each input line, output whether or not it is a Novel string using the exact output format shown below.

Sample Input: (Input File: novel.in)
FLBL
FFLL
ORDINARY
R
QYQRQYY
$$

Sample Output: (Output File: novel.out)
FLBL is a Novel string
FFLL is not a Novel string
ORDINARY is a Novel string
R is a Novel string
QYQRQYY is not a Novel string

 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Novel {
	
	public static boolean isKSingular(final String s, final int k){
		assert k >= 0;
        
		final int len = s.length();
		
		assert k < len - 1;
		
		if (k == len - 2){
			return true;
		}
		
		// compute all k-doublets and compare 
		Set<String> doublets = new HashSet<String>(len - k -1);
		
		for (int i = 0; i < len - k - 1; i++){
			//get substring from i to i+k - 1
			
            char c[] = new char[2];
            c[0] = s.charAt(i);
            c[1] = s.charAt(i+k+1);
            
			String doublet = new String(c);
//			System.out.println("doublet = " + doublet);
			
			if(false == doublets.add(doublet)){
//    			System.out.println("Already contains: " + doublet);
				return false;
			}else {
//    			System.out.println("Added to the hash: " + doublet);
			}
		}
		return true;
	}
    
	public static boolean isNovel(final String s){
		final int len = s.length();
		
		for (int i = 0; i < len - 1;  i++){
			if(false == isKSingular(s, i)){
				return false;
			}
		}
		return true;
	}
    
	public static void main(String[] args){
		assert args.length == 1 : "Name of input file reqd as first argument";
		
		try{
			FileInputStream fstream = new FileInputStream(args[0]);
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
            
			FileWriter outStream = new FileWriter("novel.out");
			BufferedWriter out = new BufferedWriter(outStream);
			  
			String strLine;
            while ((strLine = br.readLine()) != null)   {
                if(strLine.equals("$$"))
                    break;
        		if(isNovel(strLine)){
        			out.write(strLine + " is a Novel string\n");        			
        		} else {
        			out.write(strLine + " is not a Novel string\n");        			
        		}
            }
			//Close the streams
			in.close();
            out.close();
		} catch (Exception e){//Catch exception if any
			e.printStackTrace();
		}
	}
}