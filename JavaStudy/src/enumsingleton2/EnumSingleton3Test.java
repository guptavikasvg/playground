package enumsingleton2;
/**
* Singleton pattern example using Java Enum
*/
enum EasySingleton3 {
    INSTANCE;
    
    static int i = 0;
    EasySingleton3() {
        System.out.println("enum singleton created");
	}

	public void go() {
        System.out.println(i);
        i++;
		
	}
}
public class EnumSingleton3Test {
    static {
        System.out.println("static initializer in EnumSingletonTest");
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
        System.out.println("main started");
        EasySingleton3.INSTANCE.go(); //EasySingleton created before calling go on it.
        EasySingleton3.INSTANCE.go(); //EasySingleton not constructed again.

	}
}