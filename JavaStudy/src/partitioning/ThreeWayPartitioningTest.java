package partitioning;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by root1 on 4/26/17.
 */
public class ThreeWayPartitioningTest {
    /**
     * Returns an index. All elements from 0 to index are <= pivot.
     * All elements from index + 1 to the end are > pivot.
     */
    private static int partition (int[] arr, int start, int end, int pivot) {
        if (arr == null || arr.length == 0 || start < 0 || end >= arr.length) {
            throw new IllegalArgumentException("Invalid inputs");
        }

        int i = start;
        int k = end;

         while (i < k) { //or i <= k - it doesn't matter. When i ==k, the if/else won't do anything useful.
             if (arr[i] <= pivot) {
                 i++;
             } else {
                 swap(arr, i, k);
                 k--;
             }
         }

         //i and k will be equal now
         if (arr[i] <= pivot) {
             return i;
         }
         return i-1;
    }

    private static void dutchNationalFlagThreeWayPartition(int[] arr, int pivot1, int pivot2) {
        if (arr == null) {
            throw new IllegalArgumentException("Invalid inputs");
        }

        int i = 0, j = 0, k = arr.length - 1;

        while (j <= k) {
            int item = arr[j];
            if (item <= pivot1) {
                swap(arr, i, j);
                i++;
                j++;
            } else if (item <= pivot2) {// pivot1 < item <= pivot2
                j++;
            } else { //item > pivot2
                swap(arr, j, k);
                k--;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void ThreeWayPartition(int[] arr, int L, int M) {
        System.out.println(Arrays.toString(arr));
        int pivot1index = partition(arr, 0, arr.length - 1, L);
        partition (arr, pivot1index + 1, arr.length - 1, M);
        System.out.println(String.format("After partition around pivots %d %d : %s", L, M, Arrays.toString(arr)));
    }

    static void DNFThreeWayPartition(int[] arr, int L, int M) {
        System.out.println(Arrays.toString(arr));
        dutchNationalFlagThreeWayPartition(arr, L, M);
        System.out.println(String.format("After partition around pivots %d %d : %s", L, M, Arrays.toString(arr)));
    }
    @Test
    public void test1() {
        ThreeWayPartition(new int[]{0, 23, 6, 9, 1, 2, 10, 0, 8, 5, 6, 12, 17, 44}, 6, 10);
        DNFThreeWayPartition(new int[]{0, 23, 6, 9, 1, 2, 10, 0, 8, 5, 6, 12, 17, 44}, 6, 10);
        ThreeWayPartition(new int[]{0, 23, 6, 9, 1, 2, 10, 0, 8, 5, 6, 12, 17, 44}, 0, 10);
        DNFThreeWayPartition(new int[]{0, 23, 6, 9, 1, 2, 10, 0, 8, 5, 6, 12, 17, 44}, 0, 10);
        ThreeWayPartition(new int[]{0, 23, 6, 9, 1, 2, 10, 0, 8, 5, 6, 12, 17, 44}, 40, 41);
        DNFThreeWayPartition(new int[]{0, 23, 6, 9, 1, 2, 10, 0, 8, 5, 6, 12, 17, 44}, 40, 41);
        ThreeWayPartition(new int[]{60, 60, 50, 40, 30, 20, 20, 10}, 25, 55);
        DNFThreeWayPartition(new int[]{60, 60, 50, 40, 30, 20, 20, 10}, 25, 55);
        ThreeWayPartition(new int[]{60, 60, 50, 40, 30, 20, 20, 10}, 25, 25);
        DNFThreeWayPartition(new int[]{60, 60, 50, 40, 30, 20, 20, 10}, 25, 25);
        ThreeWayPartition(new int[]{0, 1, 2, 3, 4, 5, 6, 7}, 2, 5);
        DNFThreeWayPartition(new int[]{0, 1, 2, 3, 4, 5, 6, 7}, 2, 5);
    }
 }
