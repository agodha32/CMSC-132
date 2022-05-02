package examples;

import java.util.*;

public class Propagation {
	public static void B() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter number of miles: ");
		int miles = scanner.nextInt();

		System.out.println("Enter number of gallons: ");
		int gallons = scanner.nextInt();

		int milesPerGallon = miles / gallons;
		System.out.println("Miles per gallon is: " + milesPerGallon);

		scanner.close();
	}

	public static void A() {
		System.out.println("Before calling method B");
		B();
		System.out.println("After calling method B");
	}

	public static void main(String[] args) {
		try {
			System.out.println("Before calling method A");
			A();
			System.out.println("After calling method A");
		} catch (Exception e) {
			System.out.println("Invalid value provided");
			System.out.println("Default Message: " + e.getMessage());
		}
		System.out.println("Thank you for using our system");
	}
}