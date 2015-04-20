/**
 * Created by vgupta on 2/23/15.
 */
public class SynchronizedOnNullInstance {
    public static void main(String[] args) {
        Object o = null;

        if (false) {
            o = new Object();
        }

        synchronized (o) { //THROWS NPE
            System.out.println(o);
        }
    }
}
