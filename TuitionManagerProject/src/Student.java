/**
 * 
 * @author Varun Shah
 *
 */

/**
 *  Defines the common data items and operations for all student instances
 *
 */
public class Student {

	private Profile profile;
	private double tuition = 0;

	// make major enum?
	public Student(String name, Major major) {
		profile = new Profile(name, major, 0);
	}

	@Override
	public String toString() {
		return null;
	}

	@Override
	public boolean equals(Object obj) {

		return false;
	}

	public void tuitionDue() {
	}

	public void setTuition(double tuition) {
		this.tuition = tuition;
	}

}
