import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.Assert.assertEquals;

/**
 * Created by root1 on 5/16/17.
 */
public class IslandFinder {
    static class Pair {
        int ro;
        int col;

        Pair(int ro, int col) {
            this.ro = ro;
            this.col = col;
        }
    }

    static int findNumberOfIslands(int[][] M, int m, int n) {
        if (M == null) {
            return 0;
        }

        boolean[][] visited = new boolean[m][n];

        int islands = 0;
        for (int ro = 0; ro < m; ro++) {
            for (int col = 0; col < n; col++) {
                if (M[ro][col] == 0 || visited[ro][col] == true) {
                    continue;
                }

                BFS(M, visited, m, n, ro, col);
                islands++;
            }
        }
        return islands;
    }

    private static void BFS(int[][] M, boolean[][] visited, int m, int n, int startRo, int startCol) {
        assert M[startRo][startCol] == 1 && visited[startRo][startCol] == false;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(startRo, startCol));

        while (!q.isEmpty()) {
            Pair pair = q.poll();
            int ro = pair.ro;
            int col = pair.col;

            if (visited[ro][col]) {
                continue;
            }

            //add neighbors if their value is 1 and not visited

            //left
            if (col - 1 >= 0 && M[ro][col-1] == 1 && visited[ro][col - 1] == false) {
                q.add(new Pair(ro, col-1));
            }
            //right
            if (col + 1 < n && M[ro][col+1] == 1 && visited[ro][col + 1] == false) {
                q.add(new Pair(ro, col+1));
            }
            //up
            if (ro - 1 >= 0 && M[ro-1][col] == 1 && visited[ro - 1][col] == false) {
                q.add(new Pair(ro - 1, col));
            }
            //down
            if (ro + 1 < m && M[ro + 1][col] == 1 && visited[ro + 1][col] == false) {
                q.add(new Pair(ro + 1, col));
            }

            visited[ro][col] = true;
        }
    }

    @Test
    public void test() {
        assertEquals(1, findNumberOfIslands(new int[][]{{1}},1, 1));
        assertEquals(0, findNumberOfIslands(new int[][]{{0}},1, 1));
        assertEquals(1, findNumberOfIslands(new int[][]{{1, 1}, {1, 1}},2, 2));
        assertEquals(2, findNumberOfIslands(new int[][]{{1, 0}, {0, 1}},2, 2));
        assertEquals(1, findNumberOfIslands(new int[][]{{1, 1, 0}, {0, 1, 0}},2, 3));
        assertEquals(5, findNumberOfIslands(new int[][]{{1, 0, 1, 1}, {0, 1, 0, 0}, {1, 0, 1, 1}, {1, 0, 0, 1}},4, 4));
    }
}