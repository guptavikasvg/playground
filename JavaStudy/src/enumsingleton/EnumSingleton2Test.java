package enumsingleton;

/**
 * Singleton pattern example using Java Enum
 */
enum EasySingleton2 {
    INSTANCE;

    static int i = 0;

    EasySingleton2() {
        System.out.println("enum singleton created");
    }

    public void go() {
        System.out.println(i);
        i++;

    }
}

public class EnumSingleton2Test {
    static {
        System.out.println("static initializer in EnumSingletonTest");
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("main started");
        EasySingleton2.INSTANCE.go(); //EasySingleton created before calling go on it.
        EasySingleton2.INSTANCE.go(); //EasySingleton not constructed again.

    }
}