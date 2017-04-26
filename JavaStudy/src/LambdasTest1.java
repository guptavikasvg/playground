/**
 * Created by root1 on 4/23/17.
 */
public class LambdasTest1 {
}

interface Names {
    int sayName(String name);
}

class NameExample {

    public static void main(String[] args) {
        myName(n -> {
            System.out.println("My name is " + n);
            return 5;
        }, "John");
    }

    private static void myName(Names nameInstance, String name) {
        int p = nameInstance.sayName(name);
    }
}
