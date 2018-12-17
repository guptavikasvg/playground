import java.util.Vector;


public class InitializationTest {

    Vector v;
    int i;
    
    void go() {
    	Vector w;
    	int j;
    	
    	System.out.println(v + "" + i);
//    	System.out.println(w + "" ); 	//compile-time error - unitialized var on stack
//    	System.out.println( "" + j);    //-do-
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
