import java.util.Map;
import java.util.Set;

/**
 * Created by vgupta on 2/23/15.
 */
public class OverloadTest {
    public static Map getMap(int i){
        return null;
    }

    //cant overload a method and only have the return value be different.
    public static Set getMap(int i){
        return null;
    }
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
