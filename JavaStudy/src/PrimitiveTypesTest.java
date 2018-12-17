import org.junit.Test;

/**
 * Created by root1 on 5/14/17.
 */
public class PrimitiveTypesTest {
    @Test
    public void test1() {
        int count = 0;
        for (byte b = -128; count <= 256; b++, count++) {
            System.out.println("count = " + count + ", byte = " + b);
        }
    }
}
