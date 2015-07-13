package scanner;


import java.util.*;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ScannerTest1 {

    public static void main2(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int i = 0;
        while (sc.hasNext()) {
            System.out.println(i + ' ' + sc.nextLine());
            i++;
        }
    }

    public static void main(String[] args) {
        test1();
    }

    static void test2() {
        Scanner sc = new Scanner(System.in);
        MatchResult result;
        try {
            sc.findInLine("(\\d+)(\\s+)(\\w+)(\\s+)at(\\s+)(\\d+\\.\\d+)");
            result = sc.match();
        } catch (IllegalStateException e) {
            sc.findInLine("(\\d+)(\\s+)imported(\\s+)(\\w+)(\\s+)at(\\s+)(\\d+\\.\\d+)");
            result = sc.match();
        }
        for (int i = 1; i <= result.groupCount(); i++)
            System.out.println(result.group(i));
    }

    static void test1() {
        String regex = "(.*)(abc)(.*)";
        Pattern p = Pattern.compile(regex);

        Matcher matcher = p.matcher("xabcx");
        if (matcher.find()) {
            System.out.println(matcher.group(0));
            System.out.println(matcher.group(1));
            System.out.println(matcher.group(2));
            System.out.println(matcher.group(3));

            System.out.println(matcher.start(0));
            System.out.println(matcher.start(1));
            System.out.println(matcher.start(2));
            System.out.println(matcher.start(3));
        }

        matcher = p.matcher("xyabcxy");
        if (matcher.find()) {
            System.out.println(matcher.group(0));
            System.out.println(matcher.group(1));
            System.out.println(matcher.group(2));
            System.out.println(matcher.group(3));
        }
    }

    static void test3() {

//        "(\\d+)(\\s+)(\\w+)(\\s+)at(\\s+)(\\d+\\.\\d+)"
//        "(\\d+)(\\s+)imported(\\s+)(\\w+)(\\s+)at(\\s+)(\\d+\\.\\d+)"

    }
}
