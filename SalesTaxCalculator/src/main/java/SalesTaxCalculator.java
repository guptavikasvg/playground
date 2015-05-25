import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by vgupta on 5/24/15.
 */
public class SalesTaxCalculator {

    float roundUp(float amount) {
        return amount;
    }

    boolean isExemptFromBasicSalesTax(String[] input) {
        String exemptProducts[] = {
                "chocolate bar",
                "chocolates",
                "book",
                "headache pills"
        };

        String inputStr = Arrays.toString(input);

        for (String product : exemptProducts) {
            if (inputStr.equalsIgnoreCase(product))
                return true;
        }

        return false;
    }

    boolean isExemptFromBasicSalesTax(List<String> input, int start, int end) {
        //we can keep in a hash to make the search faster.
        String exemptProducts[] = {
                "chocolate bar",
                "chocolates",
                "book",
                "headache pills"
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

    void algo() {
        Scanner scanner = new Scanner(System.in);
        float totalTax = 0;
        float total    = 0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            Ret ret = processLine(line);

            System.out.println(ret.description);
            totalTax += ret.tax;
            total    += ret.amount;
        }
        System.out.println("Total tax: " + totalTax);
        System.out.println("Total : " + total);
    }

    public void processLine0(String line) {
        if (line != null) {
            String pattern = "(\\s*)(\\d+)(.*?)(\\d*.\\d*)(.*)";

            Pattern r = Pattern.compile(pattern);

            Matcher m = r.matcher(line);
            if (m.find()) {
                System.out.println(m.group(0));
                System.out.println(m.group(1));
                System.out.println(m.group(2));
                String amount = m.group(3);
                System.out.println(amount);
            }
        }
    }

    public Ret processLine(String line) {
        StringTokenizer st = new StringTokenizer(line, " \t\n\r", false);

        List<String> list = new ArrayList<String>(st.countTokens());

        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            list.add(token);
        }

        /*
        StringBuilder sb = new StringBuilder(line.length() + 1);
        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            if (st.hasMoreTokens()) {
                //this is not the last token.
                sb.append(' ');
                sb.append(token);
            } else {
                //this is the last one.

                //convert to float
                try {
                    Float aFloat = Float.valueOf(token);

                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException(e);
                }
            }
        }*/

        Float price = getPrice(list);


        //itemstart, itemend, description, IsImported
        return getDescription(list);
    }

    class Ret {
        float tax;
        float amount;
        String description;
    }

    private Ret getDescription(List<String> list) {
        int n = list.size();
        assert list != null && n >= 4;

        // 0 - amount
        // n-1 - price
        //

        int i = indexOf(list, "of");

        int amount;
        try {
            amount = Integer.valueOf(list.get(0));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(e);
        }

        int itemStart;
        int itemEnd;
        int containerIndex;

        boolean isImported = false;
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
            tax += tax * .1;
        }

        tax = roundUp(tax);

        float priceWithTax = price + tax;

        String description = amount + (isImported ? "imported" : "") + ' ' + (containerIndex != -1 ? list.get(containerIndex) + " of" : "") +
                toString(list, itemStart, itemEnd) + ": " + priceWithTax;
    }

    private int indexOf(List<String> list) {
        for (int i = 1; i <= list.size() - 3; i++) {
            if (list.get(i).equalsIgnoreCase("of")) return i;
        }
        return -1;
    }

    String toString(List<String> list, int start, int end) {
        assert start >= 0 && start <= list.size();
        assert end >= 0 && end <= list.size();

        for (int i = start; i <= end; i++) {
            list.get(i);
        }
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

    private boolean isItemImported(List<String> list) {
        assert list != null && list.size() >=4;

        for (String str : list) {
            if (str.equalsIgnoreCase("imported")) return true;
        }
        return false;
    }

}