package tests;

import implementation.*;

/**
 * You can use this driver to write your tests.
 *
 */
public class SampleDriver {
	public static void main(String[] args) {
		System.out.println("======== Marker #1 ========");

		FlightsDatabase flightsDatabase = new FlightsDatabase("Sample");
		System.out.println(flightsDatabase);
		System.out.println("IsEmpty?: " + flightsDatabase.isEmpty());

		System.out.println("\n======== Marker #2 ========");
		FlightsDatabase flightsDatabaseTwo = new FlightsDatabase();
		System.out.println(flightsDatabaseTwo);
		System.out.println("Name: " + flightsDatabaseTwo.getName());

		System.out.println("\n======== Marker #3 ========");
		System.out.println("Equals?: " + flightsDatabase.equals(flightsDatabaseTwo));
		System.out.println("HashCode:? " + (Math.abs(flightsDatabaseTwo.hashCode()) >= 0));

		System.out.println("\n======== Marker #4 ========");
		String from = "DC", to = "VA";
		int flightCost = 30;
		flightsDatabase.addFlight(from, to, flightCost);
		flightsDatabase.addFlight("ID", "KS", 40);
		flightsDatabase.addFlight("ID", "NJ", 80);
		System.out.println("Flights: " + flightsDatabase);
		System.out.println("Number of flights from ID: " + flightsDatabase.getNumberOfFlightsFrom("ID"));
		System.out.println("Destinations from ID: " + flightsDatabase.getDestinationsFrom("ID"));
		System.out.println("Direct flight cost from ID to NJ: " + flightsDatabase.getDirectFlightCost("ID", "NJ"));
		System.out.println("All from and destinations: " + flightsDatabase.getAllFromAndDestinationsInDatabase());
	}
}
