package threads;

public class DeadlockExample {

	static Object lock1 = new Object();
	static Object lock2 = new Object();
	static int i = 0;
	static int j = 0;

	static void func1() {
		System.out.println("INSIDE func1");
		i++;
		synchronized(lock1){
			System.out.println("INSIDE func1 Got first lock");
			synchronized(lock2){
				System.out.println("INSIDE func1 Got second lock");
				System.out.println("func1 " + i);
			}
		}
	}
	
	static void func2() {
		System.out.println("INSIDE func2");
		j++;
		synchronized(lock2){
			System.out.println("INSIDE func2 Got first lock");
			synchronized(lock1){
				System.out.println("INSIDE func2 Got second lock");
				System.out.println("func2 " + j);
			}
		}
	}
	
	
	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable(){
			public void run() {
				while(true)
					func1();
			}
		});
		t1.start();
		
		while(true){
			func2();
		}
	}

}
