package functional;

import org.junit.Test;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class PredicateTest1 {
    @Test
    public void test1() {
        Predicate<String> predicate = str -> str.contains("a");

        System.out.println(predicate.test("abc"));
        System.out.println(predicate.test("def"));

        Predicate<String> predicate2 = str -> str.contains("b");

        predicate.and(predicate2).negate().test("abcd");
    }
}
