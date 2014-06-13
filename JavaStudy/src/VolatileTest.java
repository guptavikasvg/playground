/**
 * 
 */

/**
 * @author vgupta
 *
 */
public class VolatileTest {

	volatile int i = 0;
	
	/**
	 * 
	 */
	public VolatileTest() {
		// TODO Auto-generated constructor stub
	}

	public void increment(){
		int j = i;
		j++;
		System.out.println(j);
		System.out.flush();
		i = j;
	}
	
	public void print(){
		System.out.println(i);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		VolatileTest vt = new VolatileTest();
		for (int i = 0; i < 2; i++)
			(new MyRunnable(vt)).start();
	}

}

class MyRunnable extends Thread  {

	private VolatileTest vt;
	public MyRunnable(VolatileTest vt) {
		this.vt = vt;
	}
	public void run() {
		for (int i = 0; i < 1000; i++){
			vt.increment();
		}
	}
	
}

