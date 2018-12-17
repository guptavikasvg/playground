package functional;

import org.junit.Test;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class FunctionalTest1 {
    @Test
    public void test1() {
        Function<Integer, Integer> function = i -> 2 * i;

        Integer integer = function.apply(10);

        System.out.println(integer);

        UnaryOperator<Integer> unaryOperator = null;
        function = unaryOperator;
    }
}
