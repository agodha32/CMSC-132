package tests;

import implementation.Hotel;

public class MaxFloorOccupants {
	public static void main(String[] args) {
		  String hotelName = "TerpHotel", address = "CollegePark";
		  int maxFloors = 4, roomsPerFloor = 3, roomCapacity = 4;
		  int pentHouseCapacity = 10;
		  String pentHouseMembers = "Smith";
		  boolean hasPool = true;

		  Hotel hotelOne = new Hotel(hotelName, address, maxFloors, roomsPerFloor, roomCapacity, pentHouseMembers,
		    pentHouseCapacity, hasPool);

		  hotelOne.addOccupant("John", 1, 1);
		  hotelOne.addOccupant("Anastasia", 1, 1);
		  hotelOne.addOccupant("Peter", 1, 1);

		  hotelOne.addOccupant("Liv", 0, 1);
		  hotelOne.addOccupant("Karl", 0, 1);
		  
		  System.out.println(hotelOne);
		  
		  int[] maxResults = hotelOne.getFloorMaxOccupants();
		  System.out.println("getFloorMaxOccupantsResults[0]: " + maxResults[0]);
		  System.out.println("getFloorMaxOccupantsResults[1]: " + maxResults[1]);
		  
		  for(int x = 0; 50 > x; x++) {
			  System.out.println();
		  }
		  
		  hotelName = "TerpHotel";
		  address = "CollegePark";
		  maxFloors = 4;
		  roomsPerFloor = 3;
		  roomCapacity = 4;
		  pentHouseCapacity = 10;
		  pentHouseMembers = "Smith";
		  hasPool = true;

		  hotelOne = new Hotel(hotelName, address, maxFloors, roomsPerFloor, roomCapacity, pentHouseMembers,
		    pentHouseCapacity, hasPool);

		  hotelOne.addOccupant("A", 1, 0);
		  hotelOne.addOccupant("B", 1, 1);
		  hotelOne.addOccupant("C", 1, 2);

		  hotelOne.addOccupant("D", 0, 1);
		  hotelOne.addOccupant("E", 0, 1);
		  
		  System.out.println(hotelOne);
		  
		  maxResults = hotelOne.getFloorMaxOccupants();
		  System.out.println("getFloorMaxOccupantsResults[0]: " + maxResults[0]);
		  System.out.println("getFloorMaxOccupantsResults[1]: " + maxResults[1]);
		  
		 }
}
