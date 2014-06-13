package interview.godaddy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ArrayMultiplication {
//public class Solution {
//    static ArrayList<Integer> lineToArray2(String str){
//    	StringTokenizer st = new StringTokenizer(str, ", ");
//        ArrayList<Integer> retval = new ArrayList<Integer>();
//        
//        while(st.hasMoreTokens()){
//        	retval.add(Integer.parseInt(st.nextToken()));
//        }
//        
//        return retval;
//    }
    
//	private static void multiply2(ArrayList<Integer> arr1, ArrayList<Integer> arr2) {
//        int len1 = arr1.size();
//        int len2 = arr1.size();
//        int minSize = Math.min(len1, len2);
//        
//        long sum = 0;
//        for (int i = 0; i < minSize; i++){
//        	sum += arr1.get(i)*arr2.get(i);
//        }
//        System.out.println(sum);
//	}
	
    static ArrayList<BigInteger> lineToArray(String str){
    	StringTokenizer st = new StringTokenizer(str, ", ");
        ArrayList<BigInteger> retval = new ArrayList<BigInteger>();
        
        while(st.hasMoreTokens()){
        	retval.add(new BigInteger(st.nextToken()));
        }
        
        return retval;
    }
    
    public static void main2(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
        	String line1 = sc.nextLine();
            if(sc.hasNextLine()){
            	String line2 = sc.nextLine();
            	
            	//convert
                ArrayList<BigInteger> arr1 = lineToArray(line1);
                ArrayList<BigInteger> arr2 = lineToArray(line2);
                
                multiply(arr1, arr2);
                
            }
        }
        sc.close();
    }
    
    public static void main(String args[] ) throws Exception {
//        FileWriter fw = new FileWriter("a");
//        fw.write(100);
//        fw.close();
//        
//        FileReader fr = new FileReader("a");
//        int read = fr.read();
//        System.out.println(read);
//        fr.close();
        
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        while(sc.hasNextLine()){
        	String line1 = sc.nextLine();
            if(sc.hasNextLine()){
            	String line2 = sc.nextLine();
            	
            	//convert
                ArrayList<BigInteger> arr1 = lineToArray(line1);
                ArrayList<BigInteger> arr2 = lineToArray(line2);
                
                multiply(arr1, arr2);
            }
        }
        sc.close();
    }
    
	private static void multiply(ArrayList<BigInteger> arr1, ArrayList<BigInteger> arr2) {
        int len1 = arr1.size();
        int len2 = arr1.size();
        int minSize = Math.min(len1, len2);
        
        BigInteger sum = new BigInteger("0");
        for (int i = 0; i < minSize; i++){
            //BigInteger a = new BigInteger(arr1.get(i).toString()); BigInteger b = new BigInteger(arr2.get(i).toString()); sum = sum.add(a.multiply(b));
            sum = sum.add(arr1.get(i).multiply(arr2.get(i)));
        }
        System.out.println(sum);
	}
}