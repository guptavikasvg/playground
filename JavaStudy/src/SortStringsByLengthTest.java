import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortStringsByLengthTest {

    @Test
    public void test(String args[]){
    	List <String> list = Arrays.asList(args);
    	
    	Comparator<String> com = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                int len1 = s1 != null ? s1.length() : 0;
                int len2 = s2 != null ? s2.length() : 0;

                return len1 - len2;
            }
        };

    	/* lambda version */
        Comparator<String> stringComparator = (s1, s2) -> {

            int len1 = s1 != null ? s1.length() : 0;
            int len2 = s2 != null ? s2.length() : 0;

            return len1 - len2;
        };

        Collections.sort(list, com);
    }
}