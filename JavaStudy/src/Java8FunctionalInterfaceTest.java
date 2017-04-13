import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by root1 on 3/31/17.
 */
public class Java8FunctionalInterfaceTest {

    @FunctionalInterface
    interface FuncInterface {
        void compare(int a, int b);
        default int compare2(String a, String b) {
            return a.compareTo(b);
        }
    }

    @Test
    public void test1() throws Exception {
        List<String> items = new ArrayList<>();
        items.add("a");
        items.add("b");
        items.add("c");
        items.add("d");
        items.add("e");

        Consumer<? super String> action =
                (k) -> {
            System.out.println(k);
        };

        items.forEach(action);
        //items.forEach(FuncInterface::compare);
    }
}