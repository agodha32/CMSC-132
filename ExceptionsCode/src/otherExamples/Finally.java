package otherExamples;

import java.util.*;

public class Finally {
	public static int getGasAverage() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter number of miles: ");
		int miles = scanner.nextInt();

		System.out.println("Enter number of gallons: ");
		int gallons = scanner.nextInt();

		try {
			int milesPerGallon = miles / gallons;
			System.out.println("Miles per gallon is: " + milesPerGallon);

			return milesPerGallon;
		} finally {
			scanner.close();
			System.out.println("Before leaving method getGasAverage() (finally message)");
		}
	}

	public static void main(String[] args) {
		try {
			System.out.println("Before calling method getGasAverage() (main)");
			System.out.println("Average: " + getGasAverage());
			System.out.println("After calling method getGasAverage() (main)");
		} catch (ArithmeticException e) {
			System.out.println("Invalid value provided (in main)");
			System.out.println("Default Message: " + e.getMessage());
		}
		System.out.println("Thank you for using our system");
	}
}
