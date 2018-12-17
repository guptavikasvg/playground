package arrays.problems;

import org.junit.Test;

import java.util.Arrays;

/**
 * Given a Timeseries that keeps information about Temperature readings for a city, return a Timeseries that tells you,
 * for a given day, how long has its value been the largest running value.
 *
 * eg: For temperature readings [30,50,60,20,10,40,60,90], the transformed timeseries would be [1,2,3,1,1,3,7,8]
 *
 * Created by root1 on 4/28/17.
 */
public class LongestRunningLengthFinder {
    public static int[] getLargestRunningVals(int[] arr) {
        if (arr == null) {
            throw new IllegalArgumentException();
        }

        int n = arr.length;
        int[] runningCount = new int[n];

        if (n == 0) {
            return runningCount;
        }

        runningCount[0] = 1;
        for (int i = 1; i < n; i++) {
            int counter = 1;
            for (int j = i - 1; j >= 0; ) {
                if (arr[j] > arr[i]) {
                    break;
                } else {
                    counter += runningCount[j];
                    j = j - runningCount[j];
                }
            }

            runningCount[i] = counter;
        }

        return runningCount;
    }

    private static void getLargestRunningValsWithLogging(int[] arr) {
        System.out.println("Input arr: " + Arrays.toString(arr));
        System.out.println("Running length: " + Arrays.toString(getLargestRunningVals(arr)));
    }

    @Test
    public void test1() throws Exception {
        getLargestRunningValsWithLogging(new int[]{30, 50, 60, 20, 10, 40, 60, 90});
        getLargestRunningValsWithLogging(new int[]{});
        getLargestRunningValsWithLogging(new int[]{10});
        getLargestRunningValsWithLogging(new int[]{10, 10});
        getLargestRunningValsWithLogging(new int[]{9, 9, 10, 10});
        getLargestRunningValsWithLogging(new int[]{100, 90, 80, 70, 60, 50, 150, 140, 130, 120, 110, 100, 200});
    }
}