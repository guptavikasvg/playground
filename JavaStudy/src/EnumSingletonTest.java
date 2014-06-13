/**
* Singleton pattern example using Java Enum
*/
enum EasySingleton{
    INSTANCE;
    
    static int i = 0;
    private EasySingleton() {
        System.out.println("enum singleton created");
	}

	public void go() {
        System.out.println(i);
        i++;
		
	}
}
public class EnumSingletonTest {
    static {
        System.out.println("static initializer in EnumSingletonTest");
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
        System.out.println("main started");
        EasySingleton.INSTANCE.go(); //EasySingleton created before calling go on it.
        EasySingleton.INSTANCE.go(); //EasySingleton not constructed again.

	}

}
