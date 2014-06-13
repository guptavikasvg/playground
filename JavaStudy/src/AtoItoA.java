import static org.junit.Assert.*;

import org.junit.Test;

public class AtoItoA {
	
	static int getDigit(char c){
		int digit = Character.getNumericValue(c);
		if (digit <0 || digit >9)
			throw new IllegalArgumentException();
		return digit;
	}
	
	//does not check for overflow
	static int atoi(String nums){
		int numi = 0;		
		int len = nums.length();
		
		char c = nums.charAt(0);
		boolean negative = c == '-';
		int startDigit = 0;
		if (negative){
			startDigit = 1;
		}
		
		if (startDigit >= len)
			throw new IllegalArgumentException();
		
		numi = 0;
		
		for (int i = startDigit ; i < nums.length();  i++){
			c = nums.charAt(i);
			
			numi = numi * 10 + getDigit(c);
		}
		
		if (negative)
			numi = -numi;
		
		return numi;
	}
	
	static int testOverflow(){
		int i = 1;
		while(true){
			i *= 2;
			System.out.println(i);
		}
	}
	
	public static void main(String[] args) {
		System.out.println(atoi("100"));
		System.out.println(atoi("-100"));
	}
}