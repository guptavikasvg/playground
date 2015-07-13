import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Long integer division
 */
public class Division {
    public String divide(int N, int d, int places) {
        if (d == 0) {
            return "nan";
        }

        int Q = (N >= d) ? (N / d) : 0;

        return Q + "." + divide2(N%d, d, places);
    }

    private String divide2(int n, int d, int places) {
        if (places == 0) {
            return "";
        }
        if (n == 0) {
            StringBuilder sb = new StringBuilder(places);
            for (int i = 0; i < places; i++) {
                sb.append('0');
            }
            return sb.toString();
        }

        if (n>=d) {
            int Q = (n >= d) ? (n / d) : 0;
            return Q + divide2(n % d, d, places - 1);
        } else {
            return divide2(n * 10, d, places);
        }
    }

    @Test
    public void test1() throws Exception {
        assertEquals("1.00", divide(5,5,2));
        assertEquals("1.", divide(5,5,0));
        assertEquals("2.5000", divide(5,2,4));
        assertEquals("0.50000", divide(1,2,5));
        assertEquals("0.3", divide(1,3,1));
    }
}
