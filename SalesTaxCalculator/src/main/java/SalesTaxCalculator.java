import java.io.InputStream;
import java.io.PrintStream;
import java.util.*;

/**
 * Created by vgupta on 5/24/15.
 */
public class SalesTaxCalculator {

    float roundUp(float amount) {
        int amountAsInt = (int)amount;

        float amountTimes100 = amount * 100;
        int amountTimes100AsInt = (int) amountTimes100;

        int twoDigitFractionAsInt = amountTimes100AsInt % 100;

        int secondFranctionalDigit = twoDigitFractionAsInt % 10;

        int firstFractionalDigit = ((int)(amount * 10)) % 10;

        float i;
        if (secondFranctionalDigit < 2) {
            //drop secondFranctionalDigit
             i = amountAsInt + (float)firstFractionalDigit / 10f;
        } else if (secondFranctionalDigit >=2 && secondFranctionalDigit <= 7) {
            i = amountAsInt + (float)firstFractionalDigit/10f + .05f;
        } else {
            i = amountAsInt + (float)firstFractionalDigit/10f + .1f;
        }
        return i;
    }

    boolean isExemptFromBasicSalesTax(List<String> input, int start, int end) {
        //we can keep in a hash to make the search faster.
        String exemptProducts[] = {
                "chocolate bar",
                "chocolates",
                "book",
                "headache pills",
                "apple"
        };

        StringBuilder sb = new StringBuilder();

        for (int i =start; i <= end; i++) {
            sb.append(input.get(i));
            if ( i != end) {
                sb.append(' ');
            }
        }

        String inputStr = sb.toString();

        for (String product : exemptProducts) {
            if (inputStr.equalsIgnoreCase(product))
                return true;
        }

        return false;
    }

    /**
     * StringBufferInputStream
     * ByteArrayOutputStream
     */
    void algo(InputStream in, PrintStream out) {
        Scanner scanner = new Scanner(in);
        float totalTax = 0;
        float total    = 0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            Ret ret = processLine(line);

            out.append(ret.description);
            out.append('\n');
            totalTax += ret.tax;
            total    += ret.amount;
        }
        out.append("Sales taxes: ");
        out.append(String.format("%.02f", totalTax));
//        System.out.printf("%.2f", val);
        out.append('\n');
        out.append("Total: ");
        out.append(String.format("%.02f", total));
        out.append('\n');
    }

    public Ret processLine(String line) {
        StringTokenizer st = new StringTokenizer(line, " \t\n\r", false);

        List<String> list = new ArrayList<String>(st.countTokens());

        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            list.add(token);
        }

        //itemstart, itemend, description, IsImported
        return getDescription(list);
    }

    class Ret {
        float tax;
        float amount;
        String description;

        public Ret(float tax, float amount, String description) {
            this.tax = tax;
            this.amount = amount;
            this.description = description;
        }
    }

    private Ret getDescription(List<String> list) {
        int n = list.size();
        assert list != null && n >= 4;

        // 0 - count
        // n-1 - price
        //

        int i = indexOf(list, "of");

        int count;
        try {
            count = Integer.valueOf(list.get(0));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(e);
        }

        int itemStart;
        int itemEnd;
        int containerIndex;

        boolean isImported;
        if (i != -1) {
            //of is present
            String s = list.get(i + 1);
            if (s.equalsIgnoreCase("imported")) {
                //case 1
                containerIndex = i - 1;
                itemStart = i +2;
                itemEnd   = n-3;
                isImported = true;
            } else if (list.get(1).equalsIgnoreCase("imported")) {
                //case 0
                isImported = true;
                containerIndex = i - 1;
                itemStart = i+1;
                itemEnd = n-3;
            } else {
                isImported = false;
                containerIndex = i - 1;
                itemStart = i+1;
                itemEnd = n-3;
            }
        } else {
            //of is not present.
            String s = list.get(1);
            if (s.equalsIgnoreCase("imported")) {
                itemStart = 2;
                itemEnd   = n-3;
                isImported = true;
            } else {
                //not imported
                itemStart = 1;
                itemEnd   = n-3;
                isImported = false;
            }
            containerIndex = -1;
        }

        String priceAsStr = list.get(n - 1);
        float price = -1;
        try {
            price = Float.valueOf(priceAsStr);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(priceAsStr + " is not a float.", e);
        }

        float tax = 0;
        if (isImported) {
            tax = price * .05f;
        }

        if (!isExemptFromBasicSalesTax(list, itemStart, itemEnd)) {
            tax += price * .1;
        }

        tax = roundUp(tax);

        float priceWithTax = price + tax;

        String description = count + (isImported ? " imported" : "") + ' ' + (containerIndex != -1 ? list.get(containerIndex) + " of " : "") +
                toString(list, itemStart, itemEnd) + ": " + String.format("%.02f", priceWithTax);

        return new Ret(tax, priceWithTax, description);
    }

    private int indexOf(List<String> list, String str) {
        for (int i = 1; i <= list.size() - 3; i++) {
            if (list.get(i).equalsIgnoreCase(str)) return i;
        }
        return -1;
    }

    String toString(List<String> list, int start, int end) {
        assert start >= 0 && start <= list.size();
        assert end >= 0 && end <= list.size();

        StringBuilder sb = new StringBuilder();
        for (int i = start; i <= end; i++) {
            sb.append(list.get(i));
            sb.append(' '); //TODO
        }
        return sb.toString();
    }

    private Float getPrice(List<String> list) {
        assert list != null && list.size() >=4;

        String amount = list.get(list.size() - 1);

        //convert to float
        try {
            return Float.valueOf(amount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(e);
        }
    }
}