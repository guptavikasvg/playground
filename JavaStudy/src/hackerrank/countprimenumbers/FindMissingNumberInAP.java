package hackerrank.countprimenumbers;

import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class FindMissingNumberInAP {

    public static void main(String args[]) throws Exception {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i <= N; i++)
            arr[i] = s.nextInt();

        System.out.println(findMissingTerm(arr));
    }

    static int findMissingTerm(int[] arr) {
        int lastDiff = arr[1] - arr[0];
        int currentDiff;

        for (int i = 2; i < arr.length; i++) {
            currentDiff = arr[i] - arr[i - 1];
            if (currentDiff != lastDiff) {
                if ( currentDiff > 0) {
                    if (currentDiff > lastDiff) {
                        return arr[i] - lastDiff;
                    } else {
                        return arr[i - 1] - lastDiff;
                    }
                } else if (currentDiff < 0){
                    if (currentDiff > lastDiff) {
                        return arr[i-2] + currentDiff;
                    } else {
                        return arr[i-1] + lastDiff;
                    }
                }
            }
        }

        return arr[0];
    }

    static int findMissingTerm2(int[] arr) {
        if (arr[1] - arr[0] == 0) return arr[0]; //0 is the diff.

        boolean isIncreasing = arr[1] - arr[0] > 0;

        int lastDiff = arr[1] - arr[0];
        int currentDiff;

        for (int i = 2; i < arr.length; i++) {
            currentDiff = arr[i] - arr[i - 1];
            if (currentDiff != lastDiff) {
                if (isIncreasing) {
                    if (currentDiff > lastDiff) {
                        return arr[i] - lastDiff;
                    } else {
                        return arr[i - 1] - lastDiff;
                    }
                } else { //decreasing
                    if (currentDiff > lastDiff) {
                        return arr[i-2] + currentDiff;
                    } else {
                        return arr[i-1] + lastDiff;
                    }
                }
            }
        }

        return arr[0];
    }

    @Test
    public void test1() throws Exception {
        assertEquals(3, findMissingTerm(new int[]{1, 2, 4}));
        assertEquals(5, findMissingTerm(new int[]{1, 3, 7}));
        assertEquals(-5, findMissingTerm(new int[]{-1, -3, -7}));
        assertEquals(-9, findMissingTerm(new int[]{-7, -11, -13}));
    }
}