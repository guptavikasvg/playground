package strings;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReverseStringTest {

	public static String reverse(String str) {
		if (str == null || str.length() == 0) {
			return str;
		}

		StringBuilder sb = new StringBuilder(str.length());

		for (int i = str.length() - 1; i >= 0; i--) {
			sb.append(str.charAt(i));
		}

		return sb.toString();
	}

	public static String reverseStr(StringBuilder str){
		if (str == null) {
			return null;
		}
		int len = str.length();

		for (int i = 0; i < len/2; i++){
            char c = str.charAt(len-i-1);
            str.setCharAt(len-i-1, str.charAt(i));
			str.setCharAt(i, c);
		}

		return str.toString();
    }

	@Test
	public void test() {
//		assertEquals(null, reverseStr(new StringBuilder(null)));
		assertEquals("", reverseStr(new StringBuilder("")));
		assertEquals("cba", reverseStr(new StringBuilder("abc")));
		assertEquals("c", reverseStr(new StringBuilder("c")));
		assertEquals("ca", reverseStr(new StringBuilder("ac")));

		assertEquals("", reverse(""));
		assertEquals("cba", reverse("abc"));
		assertEquals("c", reverse("c"));
		assertEquals("ca", reverse("ac"));
	}
}
