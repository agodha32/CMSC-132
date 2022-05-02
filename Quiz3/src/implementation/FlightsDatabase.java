package implementation;

import java.util.*;

public class FlightsDatabase {
	private Map<String, Map<String, Integer>> flights;
	private String name;

	public FlightsDatabase(String name) {
		
		this.name = name;
		this.flights = new TreeMap<String, Map<String, Integer>>();

	}

	public FlightsDatabase() {
	
		this.name = "NONAME";
		this.flights = new TreeMap<String, Map<String, Integer>>();
	
	}

	public String getName() {
	
		return this.name;
		
	}

	public boolean isEmpty() {
	
		return flights.isEmpty();
	
	}

	@Override
	public boolean equals(Object obj) {
	
		if(this == obj) {
			
			return true;
			
		} else if(!(obj instanceof FlightsDatabase)) {
			
			return false;
			
		}
		
		FlightsDatabase flightDB = (FlightsDatabase) obj;
		
		return ((this.name.equals(flightDB.name)) && this.hashCode() == flightDB.hashCode()) 
				? true : false; 
	
	}

	@Override
	public int hashCode() {
	
		return (int) this.name.charAt(0);
		
	}
	
	public FlightsDatabase addFlight(String from, String destination, int flightCost) {
	
		Map<String, Integer> toAdd = new TreeMap<String, Integer>();
		
		if(flights.containsKey(from)) {
			
			toAdd = flights.get(from);
			
		}
		
		toAdd.put(destination, flightCost);
		
		flights.put(from, toAdd);
		
		return this;
		
	}

	public int getNumberOfFlightsFrom(String from) {
	
		return flights.get(from).size();
	
	}

	public TreeSet<String> getDestinationsFrom(String from) {
		
		TreeSet<String> treturn = new TreeSet<String>();
		
		if(flights.containsKey(from)) {

			Map<String, Integer> destination = flights.get(from);
		
		
			Set<String>toReturn = destination.keySet();
		
			for(String x : toReturn) {
			
				treturn.add(x);
			
			}
			
		}
		
		return treturn;
		
	}

	public int getDirectFlightCost(String from, String destination) {
	

		return  (flights.containsKey(from) && flights.get(from).containsKey(destination)) 
				? flights.get(from).get(destination) : -1;

	}

	public TreeSet<String> getAllFromAndDestinationsInDatabase() {
		
		TreeSet<String> toReturn = new TreeSet<String>();

		Set<String> from = flights.keySet();
		
		for(String toAdd : from) {
			
			toReturn.add(toAdd);

			TreeSet<String> destination = getDestinationsFrom(toAdd);
			
			toReturn.addAll(destination);
			
		}
		
		return toReturn;
		
	}

	/* Provided: do not modify */
	public String toString() {
		if (flights.size() == 0) {
			return "No Flights";
		} else {
			return flights.toString();
		}
	}
}
