import java.util.HashMap;

/**
 * Created by root1 on 5/14/17.
 */
public class TypeCastingTest {
    class A {
        int a;
    }

    class B extends A {
        int b;
    }

    void test() {
        A a = new A();
        B b = new B();

        A a2 = b;

        A a3 = b;

        B b2 = (B)a; //java compiler is fine with downcasting as it knows that B is a subclass of A.

        /*
        B b2 = (B)new HashMap(); //not compilable. Java compiler knows that HashMap can't be casted to B.
        */
    }
}
