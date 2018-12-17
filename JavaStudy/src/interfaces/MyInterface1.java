package interfaces;

/**
 * Created by root1 on 10/8/17.
 */
public interface MyInterface1 {
    void go();
    default void go2() {
        System.out.println("inside go2()");
    }
    static void go3() {
        System.out.println("inside MyInterface1.go3()");
    }
}
