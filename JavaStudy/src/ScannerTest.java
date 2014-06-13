import java.util.Scanner;


public class ScannerTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
        main2();
        
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
	    int i = sc.nextInt();
	    String k = sc.next();
	    int j = sc.nextInt();
	    
	    System.out.println(i+j);
	    

	}

	static void main2() {
		Scanner sc = new Scanner(System.in);//.useDelimiter("[b\s]");
	    int i = sc.nextInt();
	    String k = sc.next();
	    int j = sc.nextInt();
	    int l = sc.nextInt();
	    
	    System.out.println(i+j);
	    

	}
}
