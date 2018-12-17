//package generics;
//
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Stack;
//import java.util.Vector;
//
//class MyType<T> {
//
//}
//
//class GenericsClassTest<T> {
//	static void go(MyType<? super String> arg){}
//	static void go2(MyType<? extends String> arg){}
//	static void go3(MyType<? super Vector> arg){}
//
//	public static void main(String[] args){
//		MyType<Object> o = new MyType<Object>();
//		MyType<String> s = new MyType<String>();
//		MyType<Stack> st = new MyType<Stack>();
//		MyType<Vector> v = new MyType<Vector>();
//
//		go(o);
//		go(s);
//		go2(o);
//		go2(s);
//		go3(st);
//		go3(v);
//	}
//
//}
//
//class GenericsTest {
//	static <A, B> void go(A a, B b){
//		System.out.println(a.toString() + b.toString());
//	}
//
//	static <A, B extends A> void go2(A a, B b){
//		System.out.println(a.toString() + b.toString());
//	}
//
//	static <B extends Vector> void go3(B b){
//		b.capacity();
//	}
//
//	public static void main(String[] args){
//        Stack st = new Stack();
//        go3(st);
//	}
//}
//
//class MyTest {
//	public void test1() {
//		//Map<> m = new HashMap<String, String>(); //doesn't compile
//        Map m2 = new HashMap<String, String>(); //fine
//        Map m22;
//        m22 = new HashMap<String, String>(); //fine
//        Map<String, String> m3 = new HashMap<>(); //fine
//	}
//}