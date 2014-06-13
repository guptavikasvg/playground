/**
 * 
 */

/**
 * @author vgupta
 *
 */
public class CharTest {

	/**
	 * 
	 */
	public CharTest() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		char c = 'X';
		System.out.println("c = " + c);
		c++; 	//you can increment chars
		System.out.println("c = " + c);
		int i = 'A';
		c = (char) i; //cant assign int to/from char without a cast
		System.out.println("c = " + c);
		
		char d = 65; 	//you can initialize a char with an integer value not a int variable
		//char d = i;   //cant assign without a cast
		System.out.println("d = " + d);
		
		int e = (c+d); //you can add 2 characters but result is integer
	}
}
