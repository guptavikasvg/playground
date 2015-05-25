import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.StringBufferInputStream;

/**
 * Created by vgupta on 5/24/15.
 */
public class SalesTaxCalculatorTest {
    @Test
    public void test1() throws Exception {
        String input = "1 book at 12.49\n1 music CD at 14.99\n1 chocolate bar at 0.85\n";
        InputStream in = new StringBufferInputStream(input);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream out2 = new PrintStream(out);
        new SalesTaxCalculator().algo(in, out2);
        System.out.println("Input:");
        System.out.println(input);
        System.out.println("Output:");
        System.out.println(out.toString());
    }
    @Test
    public void test2() throws Exception {
        String input = "1 imported box of chocolates at 10.00\n1 imported bottle of perfume at 47.50\n";
        InputStream in = new StringBufferInputStream(input);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream out2 = new PrintStream(out);
        new SalesTaxCalculator().algo(in, out2);
        System.out.println("Input:");
        System.out.println(input);
        System.out.println("Output:");
        System.out.println(out.toString());
    }
    @Test
    public void test3() throws Exception {
//        String input = "1 imported bottle of perfume at 27.99\n1 bottle of perfume at 18.99\n1 packet of headache pills at 9.75\n1 box of imported chocolates at 11.25\n";
        String input = "1 box of imported chocolates at 11.25\n";
        InputStream in = new StringBufferInputStream(input);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream out2 = new PrintStream(out);
        new SalesTaxCalculator().algo(in, out2);
        System.out.println("Input:");
        System.out.println(input);
        System.out.println("Output:");
        System.out.println(out.toString());
    }
}
