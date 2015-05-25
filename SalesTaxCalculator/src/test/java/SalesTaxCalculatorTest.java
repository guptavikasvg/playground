import org.junit.Test;

/**
 * Created by vgupta on 5/24/15.
 */
public class SalesTaxCalculatorTest {
    @Test
    public void test1() throws Exception {

        new SalesTaxCalculator().processLine(" 1 apples at 10.00 ");

    }
}
