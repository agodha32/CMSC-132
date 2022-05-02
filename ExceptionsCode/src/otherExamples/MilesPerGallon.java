package otherExamples;

import java.util.*;

public class MilesPerGallon {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter number of miles: ");
		int miles = scanner.nextInt();

		System.out.println("Enter number of gallons: ");
		int gallons = scanner.nextInt();

		int milesPerGallon = miles / gallons;

		System.out.println("Miles per gallon is: " + milesPerGallon);

		scanner.close();
	}
}
