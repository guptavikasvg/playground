package threads;

/**
 * Created by root1 on 4/14/17.
 */
public class ThreadTest extends Thread {
    @Override
    public void run() {
        System.out.println("INSIDE run()");

        System.out.println("EXIT run()");
    }

    public void finalize() throws Throwable {
        super.finalize();
    }

    public static void main(String[] args) throws Exception {
        ThreadTest threadTest = new ThreadTest();
        threadTest.start();
//        threadTest.join();

        Thread.sleep(5000);
        System.out.println("EXIT main()");

    }
}
