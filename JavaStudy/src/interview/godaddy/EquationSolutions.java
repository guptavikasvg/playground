/*
Please write complete compilable code.
Your class should be named Solution
Read input from standard input (STDIN) and print output to standard output(STDOUT).
For more details, please check https://www.interviewstreet.com/recruit/challenges/faq/view#stdio

https://www.hackerrank.com/challenges/equations

http://sharathpan.wordpress.com/2012/05/17/interview-street-equations-solution/


*/

package interview.godaddy;

import java.math.BigInteger;
import java.util.Scanner;
import java.util.Vector;

public class EquationSolutions {
    static int MODULO = 1000007;
    
	static Vector<Integer> getPrimesBeforeN(int N){
		boolean primes[]= new boolean[N+1];
        for (int i = 0; i < primes.length; i++) {
			primes[i] = true;
		}
		
		//seive
		for (int i=2; i*i <= N; i++) {
			if(primes[i]) {
				for(int j = i; j*i <= N; j++) primes[j*i] = false;
			}
		}

		Vector<Integer> primesCollection = new Vector<Integer>();
		for (int i=2; i<=N; i++) {
            if (primes[i]) primesCollection.add(i);
		}
        
		return primesCollection;
	}
    
	static int multiplicity(int primeFactor, int N){
		int m = 0;
        
        for (long factor = primeFactor; factor <= N; factor *= primeFactor){
        	m += N/factor;
        }
        
		return 2*m + 1;
	}
    
	static void solve(int N){
        Vector<Integer> primes = getPrimesBeforeN(N); 
		BigInteger result= new BigInteger("1");
		
        for (int primeNumber : primes) {
            BigInteger a = new BigInteger(multiplicity(primeNumber, N) +"");
			result = result.multiply(a);
    		result = result.mod(new BigInteger(MODULO + ""));
            
		}
        
		result = result.mod(new BigInteger(MODULO + ""));
		System.out.println(result);
	}
    
	public static void main(String args[]) throws Exception{
		Scanner sc= new Scanner(System.in);
		solve(sc.nextInt());
	}
}
