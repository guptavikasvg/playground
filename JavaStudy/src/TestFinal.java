import java.util.HashMap;


public class TestFinal {
	public static final Object o;// = new Object();
	public final int i ;//= 7;

	static {
		System.out.println("1st static block");
		o = new HashMap();
	}

	static {
		System.out.println("2nd static block");
//		o = new HashMap();
	}
	public TestFinal() {
		super();
		this.i = 5;
	}

	public TestFinal(int i2) {
		super();
		this.i = 5;
	}

	public static void main(String[] args) {
		System.out.println("starting main");
        new TestFinal();
	}
}
