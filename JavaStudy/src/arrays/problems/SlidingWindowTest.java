package arrays.problems;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SlidingWindowTest {

    private int[] findSW(int[] a, int k) {
        if (k > a.length) return new int[0];

        Deque dq = new ArrayDeque();
        for (int i = 0; i < k; i++) {
            if (!dq.isEmpty()) {
                int maxi = (int)dq.getFirst();
                if (a[maxi] < a[i]) {
                    updateQ(a, dq, i);
                }
            } else {
                dq.add(i);
            }
        }

        int b[] = new int[a.length];
        int n = a.length;
        for (int i = 0; i <= n - k; i++) {
            b[i] = (int) dq.getFirst();
            int s = i + 1;
            int e = i + k;

            if (e >= n) {
                break;
            }

            //remove the element that just got out of the sliding window
            if (dq.getFirst() == i) {
                dq.removeFirst();
            }

            if (dq.isEmpty() || (a[s] > (int)dq.getFirst())) {
                updateQ(a, dq, s);
            }
        }

        return b;
    }

    private void updateQ(int[] a, Deque dq, int s) {
        while (!dq.isEmpty() && a[((int) dq.getLast())] <= a[s] ) {
            dq.removeLast();
        }
        dq.addLast(s);
    }

    @Test
    public void test1() throws Exception {
        Arrays.equals(findSW(new int[]{1, 2, 3, 4}, 3), new int[] {3,4});
        Arrays.equals(findSW(new int[]{4, 1, 2, 3, 4}, 3), new int[] {4,3,4});
        Arrays.equals(findSW(new int[]{1,4, 1, 2, 3, 4}, 3), new int[] {4, 4,3,4});
        Arrays.equals(findSW(new int[]{1,4, 1, 2, 3, 4}, 6), new int[] {4, });
        Arrays.equals(findSW(new int[]{1,4, 1, 2, 3, 4}, 7), new int[] { });
    }
}