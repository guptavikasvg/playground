import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * Created by vgupta on 4/20/15.
 */
public class CelebrityFinder {

    /*
     * Returns the celebrity in arr
     * The bad thing is that it destroys the input array.
     */
    int findCelebrity(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        for (int i = 1; i < arr.length; i++) {
            if (knows(arr[i], arr[i-1])) { //does i know i-1
                swap(arr, i, i-1);
            }
        }

        //In case celebrity is not present, we need to check that this is indeed the celebrity
        return arr[arr.length - 1];

    }

    //TODO - do without destroying the array
    int findCelebrityPreservesArray(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int celebrity = 0;
        for (int i = 1; i < arr.length; i++) {
            if (knows(arr[i], arr[i-1])) { //does i know i-1
                celebrity = i;
            } else {
                //TODO
//                celebrity =
            }
        }

        //In case celebrity is not present, we need to check that this is indeed the celebrity
        return arr[arr.length - 1];

    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    boolean knows(int a, int b) { //does a know b?
        if (b == 100) return true;
        else if (a == 100) return false;
        return new Random().nextBoolean();
    }


    //TODO implement above without destroying the arr.

    @Test
    public void test1() {
        assertEquals(-1, findCelebrity(new int[]{}));
        assertEquals(-1, findCelebrity(null));
        assertEquals(100, findCelebrity(new int[]{100}));
        assertEquals(100, findCelebrity(new int[]{1, 10, 100}));
        assertEquals(100, findCelebrity(new int[]{100, 10, 1}));
        assertEquals(100, findCelebrity(new int[]{10, 100, 1}));

        assertEquals(100, findCelebrity(new int[]{5, 10, 100, 1}));
        assertEquals(100, findCelebrity(new int[]{5, 10, 15, 100, 1}));
    }

}