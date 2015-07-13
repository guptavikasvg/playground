import org.junit.Test;

public class IntegerNullabilityTest {

    @Test
    public void test1() {
        Integer a = null;
        boolean isNull = a != null ? true : false;
    }
}

