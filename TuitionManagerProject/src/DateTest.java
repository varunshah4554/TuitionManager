import static org.junit.Assert.*;

import org.junit.Test;

public class DateTest {
	@Test
	public void testIsValid() {
		// test case #1, a date with the year before 1980 should be invalid
		Date date = new Date("11/1/1979");
		assertFalse(date.isValid());
		// test case #2, a date with an invalid month.
		date = new Date("13/21/1999");
		assertFalse(date.isValid());
		// test case #3, a correct date
		date = new Date("7/23/2021");
		assertTrue(date.isValid());
		// test case #4, a future date
		date = new Date("12/23/2021");
		assertFalse(date.isValid());
		// test case #5, a year before 2021
		date = new Date("7/23/2020");
		assertFalse(date.isValid());
		// test case #6, a year after 2021
		date = new Date("12/23/2022");
		assertFalse(date.isValid());
	}

}
