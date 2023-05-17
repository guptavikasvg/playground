package enumsingleton;

enum EnumSingleton {

	INSTANCE;
//	INSTANCE2; //adding this line will create another
	private Resource resource;

	EnumSingleton() {
		resource = new Resource();
		System.out.println("init");
	}

    public void go() {
        System.out.println("go");
    }

	public static void goStatic() { //calling this static method will create the singleton
		System.out.println("goStatic");
	}

	static class Resource {
		public Resource() {
			System.out.println("resource created.");
		}
	}
}


public class EnumSingletonTest {

	public static void main(String[] args) {
		EnumSingleton.goStatic();
        EnumSingleton.INSTANCE.go();
        EnumSingleton.INSTANCE.go();
	}
}
