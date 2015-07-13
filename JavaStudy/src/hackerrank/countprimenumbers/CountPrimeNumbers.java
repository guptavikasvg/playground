/**
 * Find the number of primes < N
 */
package hackerrank.countprimenumbers;

import java.io.IOException;

import java.io.*;
        import java.util.*;
        import java.text.*;
        import java.math.*;
        import java.util.regex.*;

public class CountPrimeNumbers {

    static int getNumberOfPrimes(int n) {
        int count = 0;
        for (int i = 2; i < n ; i++ ) {
            if (isPrime(i)) {
                count++;
            }
        }
        return count;
    }


    static boolean isPrime(int p) {
        if (p == 1) return false;

        for (int i = 2; i < Math.min(Math.sqrt(p)+1, p); i++) {
            if (p % i == 0) return false;
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        final String fileName = System.getenv("OUTPUT_PATH");
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        int res;
        int _n;
        _n = Integer.parseInt(in.nextLine());

        res = getNumberOfPrimes(_n);
        bw.write(String.valueOf(res));
        bw.newLine();

        bw.close();
    }
}
