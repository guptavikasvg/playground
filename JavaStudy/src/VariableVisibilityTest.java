class B {
	public int a = 1;
	
	void print(){
		System.out.println(a);
	}
}

class D extends B {
	public int a = 2;
	
	void print(){
		System.out.println(a);
	}
}

public class VariableVisibilityTest {
	public static void main(String[] args) {
		B t = new D();
		System.out.println(t.a); //t.a is statically bound to B's version of a
		t.print();
	}
}