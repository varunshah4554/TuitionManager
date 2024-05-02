import static org.junit.Assert.*;

import org.junit.Test;

public class InternationalTest {

	@Test
	public void testTuitionDue() {
		int capacity = 2;
		String [] international = new String[capacity];
		international[0] = "12";
		international[1] = "true";
		// show international student pays 2650 if study abroad
		assertEquals(tuitionDue(international), 2650);
	}

	private Object tuitionDue(String[] international) {
		// TODO Auto-generated method stub
		return null;
	}

}
