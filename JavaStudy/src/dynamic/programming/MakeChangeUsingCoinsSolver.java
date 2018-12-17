package dynamic.programming;

import org.junit.Test;

import java.util.*;

/**
 * Created by root1 on 5/9/17.
 *
 * https://www.hackerrank.com/challenges/ctci-coin-change
 *
 *
 DP: Coin Change
 by alanl

 Problem
 Submissions
 Leaderboard
 Discussions
 Editorial

 Check out the resources on the page's right side to learn more about dynamic programming. The video tutorial is by Gayle Laakmann McDowell, author of the best-selling interview book Cracking the Coding Interview.

 Given a number of dollars, , and a list of dollar values for distinct coins, , find and print the number of different ways you can make change for dollars if each coin is available in an infinite quantity.

 Hints:

 You can solve this problem recursively, but you must optimize your solution to eliminate overlapping subproblems using Dynamic Programming if you wish to pass all test cases. More specifically, think of ways to store the checked solutions and use the stored values to avoid repeatedly calculating the same values.
 Think about the degenerate cases:
 How many ways can you make change for dollars?
 How many ways can you make change for less than dollars if you have no coins?
 If you are having trouble defining the storage for your precomputed values, then think about it in terms of the base case .

 Input Format

 The first line contain two space-separated integers describing the respective values of and .
 The second line contains space-separated integers describing the respective values of , where each integer denotes the dollar value of a distinct coin available in an infinite quantity.

 Constraints

 The list of coins contains distinct integers where each integer denotes the dollar value of a coin available in an infinite quantity.

 Output Format

 Print a single integer denoting the number of ways we can make change for dollars using an infinite supply of our types of coins.
 */
public class MakeChangeUsingCoinsSolver {
    public static long makeChange(long[] coins, long money) {
        int m = coins.length;

        long M[][] = new long[m][(int)money + 1];
        // no need to initialize to 0.

        for (int col = 0; col <= money; col++) {
            for (int ro = 0; ro < m; ro++) {
                if (ro == 0) {
                    if (col % coins[ro] == 0)
                        M[ro][col] = 1;
                    else
                        M[ro][col] = 0;
                    continue;
                }

                //ro >= 1

                //ways of making col using coins0 to coins (ro-1)
                M[ro][col] += M[ro-1][col];

                long index = col - coins[ro];
                while (index >= 0) {
                    M[ro][col] += M[ro-1][(int) index];
                    index = index - coins[ro];
                }
            }
        }

        if (true) {
            for (int ro = 0; ro < m; ro++) {
                for (int col = 0; col <= money; col++) {
                    System.out.print(M[ro][col]);
                    System.out.print(' ');
                }
                System.out.println();
            }
        }
        return M[m-1][(int) money];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        long coins[] = new long[m];
        for(int coins_i=0; coins_i < m; coins_i++){
            coins[coins_i] = in.nextInt();
        }
        System.out.println(makeChange(coins, n));
    }

    @Test
    public void test1() {
        //System.out.println(MakeChangeUsingCoinsSolver.makeChange(new long[]{1, 5, 10}, 10));
        System.out.println(MakeChangeUsingCoinsSolver.makeChange(new long[]{1, 2, 3}, 4));
        //System.out.println(MakeChangeUsingCoinsSolver.makeChange(new long[]{16, 30, 9, 17, 40, 13, 42, 5, 25, 49, 7, 23, 1, 44, 4, 11, 33, 12, 27, 2, 38, 24, 28, 32, 14, 50}, 245));
        //System.out.println(MakeChangeUsingCoinsSolver.makeChange(new int[]{1, 5}, 5));
    }
}