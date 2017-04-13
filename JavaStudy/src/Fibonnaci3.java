//‘N’ Story Building, with 1,2,3 steps how many ways can a person reach top of building.
//		Posted on April 13, 2015 by Dave — No Comments ↓
//
//		A building has n steps. A person can take 1,2 or 3 steps. In how many ways can a person reach top of building. Continue reading →

import org.junit.Test;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

//1 2 ..7 8 9 10
//
//		S(10) = S(9) + S(8) + S (7)
public class Fibonnaci3 {

	long getFloor(int n) {
		long[] Steps = {0, 1, 2, 3};

		if (n <= 3) return Steps[n];

		long S[] = new long[n+1];

		for (int i = 0; i <= 3; i++)
			S[i] = Steps[i];

		for (int i = 4; i <= n; i++) {
			S[i] = S[i - 1] + S[i - 2] + S[i - 3];
		}
		return S[n];

	}

	@Test
	public void testGetFloor() {
		assertEquals(0, getFloor(0));
		assertEquals(1, getFloor(1));
		assertEquals(2, getFloor(2));
		assertEquals(3, getFloor(3));
		System.out.println(getFloor(4));
		System.out.println(getFloor(100));
	}
}