package streams;

import org.junit.Test;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamsTest {
    @Test
    public void test1() {
        List<Integer> list = Arrays.asList(1,2,3);

        Predicate<? super Integer> predicate = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return false;
            }
        };

        Stream<Integer> integerStream = list.stream().filter(predicate);

        System.out.println(integerStream);
    }
}
