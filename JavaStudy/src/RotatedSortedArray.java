/**
 * Created by vgupta on 2/21/15.
 */
public class RotatedSortedArray {
    //Find the index of the smallest element.
    public static int findStart(int[] array) {
        if (array == null || array.length == 0) {
            return -1;
        }

        int start = 0;
        int end   = array.length - 1;

        while (end - start > 1) {

            int mid = (start + end)/2;

            int midValue = array[mid];
            int endValue = array[end];

            if (midValue < endValue) {
                end = mid;
                continue;
            } else {
                start = mid;
                continue;
            }
        }

        int left = array[start];
        int right = array[end];

        int retval = left < right ? start : end;
        return retval;
    }

    public static void main(String[] args) {
        assert findStart(new int[]{1,2,3}) == 0;
        assert findStart(new int[]{1,}) == 0;
        assert findStart(new int[]{1,2}) == 0;
        assert findStart(new int[]{2,1}) == 1;
        assert findStart(new int[]{1,2,0}) == 2;
        assert findStart(new int[]{2,0,1}) == 1;
        assert findStart(new int[]{2,3,0,1}) == 2;
        assert findStart(new int[]{3,0,1,2}) == 1;
        assert findStart(new int[]{1,2,3,0}) == 3;

        //the same code should work for dups as well.
        //No, it wont work on one of theses: 2,2,2,0,2 OR 2,0,2,2,2
    }
}
