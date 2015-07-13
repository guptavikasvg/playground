package scanner;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by vgupta on 5/25/15.
 */
public class ScannerTest2 {
    public void test1() {
        String s = "xyz: 123a-45";
        String patternStr = "xyz:[ \\t]*([\\S ]+)";
        Pattern p = Pattern.compile(patternStr);
        Matcher m = p.matcher(s);
        if (m.find()) {
            int count = m.groupCount();
            System.out.println("group count is " + count);
            for (int i = 1; i < count; i++) {
                System.out.println(m.group(i));
            }
        }
    }
}
