/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package javapractice;

/**
 *
 * @author vgupta
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        factorial(10);
        factorial(20);
    }

    private static int factorial(int n) {
        if (n == 1 || n == 2) return 1;

        return factorial2(n-1) + factorial(n-2);
    }

    private static int factorial2(int n) {
        if (n == 1 || n == 2) return 1;

        return factorial(n-1) + factorial2(n-2);
    }

}
