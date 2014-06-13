import static org.junit.Assert.*;

import org.junit.Test;


public class AtoItoATest {

	@Test
	public void testAoI() {
		assertEquals(AtoItoA.atoi("0"), 0);
		assertEquals(AtoItoA.atoi("-10"), -10);
		assertEquals(AtoItoA.atoi("--10"), -10);
	}

}
