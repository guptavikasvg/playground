/**
 * Created by vgupta on 7/1/15.
 */
public class MemberInitializationTest {
    public void test1() {
        int i; //uninitialized
        int[] j; //uninitialized
        int[] k = new int[1]; //initialized

//        System.out.println(i); //not ok
//        System.out.println(j); //not ok
        System.out.println(k); //ok
    }
}
