//
// Search an element in a sorted and pivoted array
//
public class RotatedArrayTest {

    public static int find(int[] array, int elem) {
        int l = 0;
        int r = array.length - 1;

        while (l<=r) {
            int left = array[l];
            int right = array[r];
            int m = (l+r)/2;

            int mid = array[m];

            //System.out.println(l + " " + r);
            if ( l == r || l + 1 == r) {
                if (elem == array[l])
                    return l;
                if (elem == array[r])
                    return r;

                break;
            }
            if (mid > left) {
                if (elem >= left && elem <= mid) {
                    r = m;
                } else {
                    l = m;
                }
            } else {
                if (elem >= mid && elem <= right) {
                    l = m;
                } else {
                    r = m;
                }
            }
        }
        return -1;
    }

    public static int findPivot(int[] array) {
        int l = 0;
        int r = array.length - 1;

        while (l<r) {
            int left = array[l];
            int right = array[r];
            int m = (l+r)/2;

            int mid = array[m];

            //System.out.println(l + " " + r);
            if ( l + 1 == r) {
                if (left > right)
                    return l;
                else
                    return -1;
            }

            if (mid > left) {
                l = m;
            } else {
                r = m;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int array[] = {5,6,7,1,2,3};
        
        for (int i = 0; i < array.length; i++){
            int index = RotatedArrayTest.find(array, array[i]);
            System.out.println(index);
        }

        {int array2[] = {5,6,7,1,2,3}; int index = RotatedArrayTest.findPivot(array2); System.out.println(index);}
        {int array2[] = {1,2,3}; int index = RotatedArrayTest.findPivot(array2); System.out.println(index);}
        {int array2[] = {1}; int index = RotatedArrayTest.findPivot(array2); System.out.println(index);}
        {int array2[] = {3,1}; int index = RotatedArrayTest.findPivot(array2); System.out.println(index);}
        {int array2[] = {3,1, 2}; int index = RotatedArrayTest.findPivot(array2); System.out.println(index);}
        {int array2[] = {3,4, 2}; int index = RotatedArrayTest.findPivot(array2); System.out.println(index);}

    }
}
