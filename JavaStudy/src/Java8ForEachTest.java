//import org.junit.jupiter.api.Test;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.function.Consumer;
//
///**
// * Created by root1 on 3/31/17.
// */
//public class Java8ForEachTest {
//
//    @Test
//    public void test1() throws Exception {
//        List<String> items = new ArrayList<>();
//        items.add("a");
//        items.add("b");
//        items.add("c");
//        items.add("d");
//        items.add("e");
//
//        Consumer<? super String> action =
//                (k) -> {
//            System.out.println(k);
//        };
//
//        items.forEach(action);
//    }
//}
