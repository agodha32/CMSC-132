package otherExamples;

import java.util.Scanner;

public class Throwing {
	public static int getCourseCredits(String courseName) {
		/* Does the order of the following expressions matter? */
		if (courseName == null || courseName.equals("")) {
			throw new IllegalArgumentException("Invalid argument");
		} else if (courseName.equals("cmsc131")) {
			return 4;
		} else {
			return 3;
		}
	}

	public static double getTuitionCost(int credits) {
		throw new UnsupportedOperationException("Not implemented yet");
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter test number (1, 2, 3): ");
		int option = scanner.nextInt();

		if (option == 1) {
			System.out.println("Credits: " + getCourseCredits("cmsc131"));
		} else if (option == 2) {
			System.out.println("Credits: " + getCourseCredits(null));
		} else {
			System.out.println("Tuition Cost: " + getTuitionCost(100));
		}

		scanner.close();
	}
}