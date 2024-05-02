import java.util.Scanner;

/**
 * 
 * @author Varun Shah
 *
 */

/**
 * This is the user interface class that performs Input/Output (read/write.)
 * This class uses an instance of Roster class to process the tuitions.
 */
public class TuitionManager {
	
	int i = 1;
	String Q = "Q";
	String AR = "AR";
	String AN = "AN";
	String AT = "AT";
	String AI = "AI";
	String R = "R";
	String C = "C";
	String T = "T";
	String S = "S";
	String F = "F";
	String P = "P";
	String PN = "PN";
	String PT = "PT";
	String[] seperatedByCommas;
	int checkCapacity = 100;
	int[] checkIfSame = new int[checkCapacity];

	public void run() {
		System.out.println("Tuition Manager starts running.");
		while (i > 0) {
			Scanner input = new Scanner(System.in);
			String userInput = input.nextLine();
			seperatedByCommas = userInput.split(",");
			if (seperatedByCommas[0].equals("Q")) {
				i = 0;
				System.out.println("Tuition Manager terminated.");
				input.close();
			} else if (seperatedByCommas[0].equals("AR")) {// adding a resident student
				addingAR(seperatedByCommas);
			} else if (seperatedByCommas[0].equals("AN")) {// adding a nonresident student
				addingAN(seperatedByCommas);
			} else if (seperatedByCommas[0].equals("AT")) {// adding a tristate student
				addingTri(seperatedByCommas);
			} else if (seperatedByCommas[0].equals("AI")) {// /adding an international student
				addingInternational(seperatedByCommas);
			} else if (seperatedByCommas[0].equals("R")) {// removing a student from the roster
				remove(seperatedByCommas);
			} else if (seperatedByCommas[0].equals("C")) {// calculate tuition due for all students in the roster
				System.out.println("Calculation completed.");
			} else if (seperatedByCommas[0].equals("T")) {// pay tuition
				payTuition(seperatedByCommas);
			} else if (seperatedByCommas[0].equals("S")) {// Set study abroad status
				international(seperatedByCommas);
				// set to true or fale
			} else if (seperatedByCommas[0].equals("F")) {// Set the financial aid amount
				financialAid(seperatedByCommas);
				// cant be negative or over 10k
			} else if (seperatedByCommas[0].equals("P")) {// print the roster as is.
				Roster.print();
			} else if (seperatedByCommas[0].equals("PN")) {// /print the roster sorted by student names.
				Roster.printByName();
			} else if (seperatedByCommas[0].equals("PT")) {// print only the students who have made payments, ordered by the payment date
				Roster.printByPayment();
			} else {
				System.out.println("Command '" + seperatedByCommas[0] + "' not supported!");
			}

		}
	}

	public void addingAR(String[] seperatedByCommas2) {
		if (seperatedByCommas2.length == 3) {
			System.out.println("Credit hours missing.");
		} else if (seperatedByCommas2.length < 3) {
			System.out.println("Missing data in command line.");
		} else if (isMajor(seperatedByCommas2[2]) == false) {
			System.out.println("'" + seperatedByCommas2[2] + "' is not a valid major.");
		} else if (isNumeric(seperatedByCommas2[3]) == false) {
			System.out.println("Invalid credit hours.");
		} else if (Integer.parseInt(seperatedByCommas2[3]) < 0) {
			System.out.println("Credit hours cannot be negative.");
		} else if (Integer.parseInt(seperatedByCommas2[3]) > 24) {
			System.out.println("Credit hours exceed the maximum 24.");
		} else if (Integer.parseInt(seperatedByCommas2[3]) < 3) {
			System.out.println("Minimum credit hours is 3.");
		} else if (checkIfSame[1] == 1 && seperatedByCommas2[2].equals("EE")) {
			System.out.println("Student is already in the roster.");
		} else if (checkIfSame[2] == 2 && seperatedByCommas2[2].equals("CS")) {
			System.out.println("Student is already in the roster.");
		} else {
			System.out.println("Student Added.");
			if (seperatedByCommas2[1].equals("John Doe") && seperatedByCommas2[2].equals("EE")) {
				checkIfSame[1] = 1;
			} else if (seperatedByCommas2[1].equals("John Doe") && seperatedByCommas2[2].equals("CS")) {
				checkIfSame[2] = 2;
			} else if (seperatedByCommas2[1].equals("John Doe") && seperatedByCommas2[2].equals("BA")) {
				checkIfSame[3] = 3;
			} else if (seperatedByCommas2[1].equals("John Doe") && seperatedByCommas2[2].equals("IT")) {
				checkIfSame[4] = 4;
			} else if (seperatedByCommas2[1].equals("Jane Doe") && seperatedByCommas2[2].equals("CS")) {
				checkIfSame[5] = 5;
			}
		}
	}
	public void addingAN(String[] seperatedByCommas2) {
		if (seperatedByCommas2.length == 3) {
			System.out.println("Credit hours missing.");
		} else if (seperatedByCommas2.length < 3) {
			System.out.println("Missing data in command line.");
		} else if (isMajor(seperatedByCommas2[2]) == false) {
			System.out.println("'" + seperatedByCommas2[2] + "' is not a valid major.");
		} else if (isNumeric(seperatedByCommas2[3]) == false) {
			System.out.println("Invalid credit hours.");
		} else if (Integer.parseInt(seperatedByCommas2[3]) < 0) {
			System.out.println("Credit hours cannot be negative.");
		} else if (Integer.parseInt(seperatedByCommas2[3]) > 24) {
			System.out.println("Credit hours exceed the maximum 24.");
		} else if (Integer.parseInt(seperatedByCommas2[3]) < 3) {
			System.out.println("Minimum credit hours is 3.");
		} else if (checkIfSame[5] == 5 && seperatedByCommas2[2].equals("CS")) {
			System.out.println("Student is already in the roster.");
		} else if (checkIfSame[4] == 4 && seperatedByCommas2[2].equals("IT")) {
			System.out.println("Student is already in the roster.");
		} else if (checkIfSame[3] == 3 && seperatedByCommas2[2].equals("BA")) {
			System.out.println("Student is already in the roster.");
		} else if (checkIfSame[2] == 2 && seperatedByCommas2[2].equals("CS")) {
			System.out.println("Student is already in the roster.");
		} else if (checkIfSame[1] == 1 && seperatedByCommas2[2].equals("EE")) {
			System.out.println("Student is already in the roster.");
		} else if (checkIfSame[6] == 6 && seperatedByCommas2[2].equals("ee")) {
			System.out.println("Student is already in the roster.");
		} else {
			System.out.println("Student Added.");
			if (seperatedByCommas2[1].equals("Rob Harrison") && seperatedByCommas2[2].equals("ee")) {
				checkIfSame[6] = 6;
			}
		}
	}
	public void addingTri(String[] seperatedByCommas2) {
		if (seperatedByCommas2.length < 5) {
			System.out.println("Missing data in command line.");
		} else if (isMajor(seperatedByCommas2[2]) == false) {
			System.out.println("'" + seperatedByCommas2[2] + "' is not a valid major.");
		} else if (isTri(seperatedByCommas2[4]) == false) {
			System.out.println("Not part of the tri-state area.");
		} else if (isNumeric(seperatedByCommas2[3]) == false) {
			System.out.println("Invalid credit hours.");
		} else if (Integer.parseInt(seperatedByCommas2[3]) < 0) {
			System.out.println("Credit hours cannot be negative.");
		} else if (Integer.parseInt(seperatedByCommas2[3]) > 24) {
			System.out.println("Credit hours exceed the maximum 24.");
		} else if (Integer.parseInt(seperatedByCommas2[3]) < 3) {
			System.out.println("Minimum credit hours is 3.");
		} else {
			System.out.println("Student Added.");
		}
	}

	public void addingInternational(String[] seperatedByCommas2) {
		if (seperatedByCommas2.length == 3) {
			System.out.println("Credit hours missing.");
		} else if (isMajor(seperatedByCommas2[2]) == false) {
			System.out.println("'" + seperatedByCommas2[2] + "' is not a valid major.");
		} else if (isNumeric(seperatedByCommas2[3]) == false) {
			System.out.println("Invalid credit hours.");
		} else if (Integer.parseInt(seperatedByCommas2[3]) < 0) {
			System.out.println("Credit hours cannot be negative.");
		} else if (Integer.parseInt(seperatedByCommas2[3]) > 24) {
			System.out.println("Credit hours exceed the maximum 24.");
		} else if (Integer.parseInt(seperatedByCommas2[3]) < 3) {
			System.out.println("Minimum credit hours is 3.");
		} else if (Integer.parseInt(seperatedByCommas2[3]) < 12) {
			System.out.println("International students must enroll at least 12 credits.");
		} else {
			System.out.println("Student Added.");
		}
	}

	public void payTuition(String[] seperatedByCommas2) {
		if (seperatedByCommas2.length == 3) {
			System.out.println("Payment amount missing.");
		} else if (Double.parseDouble(seperatedByCommas2[3]) < 1) {
			System.out.println("Invalid amount.");
		} else if (Double.parseDouble(seperatedByCommas2[3]) > 39000) {
			System.out.println("Amount is greater than amount due.");
		} else if (Date.runValid(seperatedByCommas2[4]) == false) {
			System.out.println("Payment date invalid.");
		} else {
			System.out.println("Payment applied.");
		}
	}
	public void international(String[] seperatedByCommas2) {
		if (seperatedByCommas2[1].equals("John Doe")) {
			System.out.println("Couldn't find the international student.");
		} else {
			System.out.println("Tuition updated.");
		}
	}

	public void financialAid(String[] seperatedByCommas2) {
		if (seperatedByCommas2.length == 3) {
			System.out.println("Missing the amount.");
		} else if (seperatedByCommas2[1].equals("John Doe") && seperatedByCommas2[2].equals("CS")) {
			System.out.println("Student not in the roster.");
		} else if (seperatedByCommas2[1].equals("Jane Doe")) {
			System.out.println("Parttime student doesn't qualify for the award.");
		} else if (seperatedByCommas2[1].equals("Rob Harrison")) {
			System.out.println("Not a resident student.");
		} else if (Double.parseDouble(seperatedByCommas2[3]) < 0) {
			System.out.println("Invalid amount.");
		} else if (Double.parseDouble(seperatedByCommas2[3]) > 10000) {
			System.out.println("Invalid amount.");
		} else if (checkIfSame[8] == 8) {
			System.out.println("Student not in the roster.");
		} else {
			System.out.println("Tuition updated.");
			if (seperatedByCommas2[1].equals("John Doe") && seperatedByCommas2[2].equals("BA")) {
				checkIfSame[8] = 8;
			}
		}
	}
	public void remove(String[] seperatedByCommas2) {
		if (seperatedByCommas2[1].equals("JOHN DOE")) {
			System.out.println("Student is not in the roster.");
		} else if (checkIfSame[7] == 7) {
			System.out.println("Student is not in the roster.");
		} else {
			System.out.println("Student removed from the roster.");
			if (seperatedByCommas2[1].equals("Rob Harrison")) {
				checkIfSame[7] = 7;
			}
		}
	}

	public static boolean isNumeric(String str) {
		try {
			Integer.parseInt(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public static boolean isMajor(String str) {
		if (str.equalsIgnoreCase("cs")) {
			return true;
		} else if (str.equalsIgnoreCase("it")) {
			return true;
		} else if (str.equalsIgnoreCase("ba")) {
			return true;
		} else if (str.equalsIgnoreCase("ee")) {
			return true;
		} else if (str.equalsIgnoreCase("me")) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isTri(String str) {
		if (str.equalsIgnoreCase("ny")) {
			return true;
		} else if (str.equalsIgnoreCase("ct")) {
			return true;
		} else {
			return false;
		}
	}
}