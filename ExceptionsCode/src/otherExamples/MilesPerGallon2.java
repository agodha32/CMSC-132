package otherExamples;

import java.util.*;

public class MilesPerGallon2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter number of miles: ");
		int miles = scanner.nextInt();

		System.out.println("Enter number of gallons: ");
		int gallons = scanner.nextInt();

		try {
			int milesPerGallon = miles / gallons;
			System.out.println("Miles per gallon is: " + milesPerGallon);
		} catch (ArithmeticException e) {
			System.out.println("Invalid value provided");
			System.out.println("Default Message: " + e.getMessage());
		}
		System.out.println("Thank you for using our system");

		scanner.close();
	}
}
