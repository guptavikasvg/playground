/**
 * Created by root1 on 4/17/17.
 */
public class Knapsack01 {
    static int getMaxValue(int V[][], int[] values, int[] weights, int W, int n) {
        for (int j = 0; j <= W; j++) {
            V[0][j] = 0;
        }

        for (int i = 0; i <= n; i++) {
            V[i][0] = 0;
        }

        for (int j = 1; j <= W; j++) {
            for (int i = 1; i <= n; i++) {
                //case 1: exclude i
                int val1 = V[i-1][j];

                //case 2: include i
                int val2;
                if (weights[i] > j) {
                    val2 = 0;
                } else {
                    val2 = values[i] + V[i - 1][j - weights[i]];
                }

                V[i][j] = Math.max(val1, val2);
            }
        }

        return V[n][W];
    }

    static void solve(int n, int W, int[] values, int[] weights) {
        int[][] V = new int[n + 1][W + 1];
        System.out.println(getMaxValue(V, values, weights, W, n));
    }

    public static void main(String[] args) {
        solve(5, 8, new int[]{0, 7, 2, 1, 10, 15}, new int[]{0, 1, 5, 7, 15, 30});
        solve(5, 13, new int[]{0, 7, 2, 1, 10, 15}, new int[]{0, 1, 5, 7, 15, 30});
        solve(5, 15, new int[]{0, 7, 2, 1, 10, 15}, new int[]{0, 1, 5, 7, 15, 30});
        solve(5, 0, new int[]{0, 7, 2, 1, 10, 15}, new int[]{0, 1, 5, 7, 15, 30});
        solve(5, 1, new int[]{0, 7, 2, 1, 10, 15}, new int[]{0, 1, 5, 7, 15, 30});
        solve(5, 45, new int[]{0, 7, 2, 1, 10, 15}, new int[]{0, 1, 5, 7, 15, 30});
        solve(5, 46, new int[]{0, 7, 2, 1, 10, 15}, new int[]{0, 1, 5, 7, 15, 30});

        solve(5, 46, new int[]{0, 15, 7, 2, 1, 10}, new int[]{0, 30, 1, 5, 7, 15});
    }

}
