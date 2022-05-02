package implementation;

import java.util.ArrayList;
import java.util.Collections;

public class Hotel extends Building {
	private String hotelName, pentHouseMembers;
	private Room pentHouseRoom;
	private boolean hasPool;

	public Hotel(String hotelName, String address, int maxFloors, int roomsPerFloor, int roomCapacity,
			String pentHouseMembers, int pentHouseCapacity, boolean hasPool) {

		super(address, maxFloors, roomsPerFloor, roomCapacity);
		
		this.hotelName = hotelName; 
		this.pentHouseMembers = pentHouseMembers;
		this.hasPool = hasPool;
		this.pentHouseRoom = new Room(pentHouseCapacity);
	
	}

	@Override
	public boolean addOccupant(String name, int floorIndex, int roomNumberIndex) {
		
		Boolean action = false;
		
		try {
			
			this.getRoom(floorIndex, roomNumberIndex);
			
		} catch (Exception IllegalArgumentException) {
			
			return false;
			
		} 
		
		if(name.contains(pentHouseMembers)) {
			
			if(this.pentHouseRoom.getCapacity() > this.pentHouseRoom.getNumberOfOccupants()) {
				
				
				try {
					
					action = this.pentHouseRoom.addOccupant(name);
				
				} catch (Exception IllegalArgumentException) {
					
					return false;
					
				}
				
			}
			
		} else {
			
			try {
				
				action = this.allFloors[floorIndex][roomNumberIndex].addOccupant(name);
			
			} catch (Exception IllegalArgumentException) {
				
				return false;
				
			}
					
		}
		
		return action;
		
	}

	public ArrayList<String> getOccupants(boolean pentHouse, int floorIndex, int roomIndex, boolean sorted) {

			ArrayList <String> toReturn;
			
			if(pentHouse == true) {
				
				toReturn = this.pentHouseRoom.getOccupants();
				
			} else {
				
				toReturn = this.allFloors[floorIndex][roomIndex].getOccupants();
				
			}
			
			if(sorted == true) {
				
				Collections.sort(toReturn);
				return toReturn;
				
			} else {
				
				return toReturn;
				
			}
	
	}

	public boolean hotelHasPool() {

		return this.hasPool;
	
	}

	/* Does not include penthouse; if two have the same value the lower level one */
	public int[] getFloorMaxOccupants() {

		int floorwithMaxOccupents = 0;
		int roomwithMaxOccupents = 0;
		
		int[] toReturn = new int [2];
		
		for(int floor = 0; maxFloors > floor; floor++) {
			
			int occupants = 0;
				
			for(int room = 0; roomsPerFloor > room; room++) {
					
				occupants += allFloors[floor][room].getNumberOfOccupants();
									
			}
			
			if(occupants > roomwithMaxOccupents) {
				
				roomwithMaxOccupents = occupants;
				floorwithMaxOccupents = floor;
				
			}
						
		}
		
		toReturn[0] = floorwithMaxOccupents;
		toReturn[1] = roomwithMaxOccupents;
		
		return toReturn;
		
	}

	public static int totalNumberHotelsWithPool(ArrayList<Building> buildings) {
		
		int totalNumPools = 0;

		for(Building hotelWithPool : buildings) {
			
			if(hotelWithPool instanceof Hotel) {
				
				if(((Hotel) hotelWithPool).hotelHasPool() == true) {
					
					totalNumPools++;
					
				}
				
			}
			
		}
		
		return totalNumPools;
	
	}

	/* Provided: do not modify */
	@Override
	public String toString() {
		String answer = "Hotel: " + hotelName + "\n";

		answer += "PentHouseMembers: " + pentHouseMembers + "\n";
		answer += "PentHouseRoom: " + pentHouseRoom + "\n";
		answer += "Pool: " + (hasPool ? "Yes" : "No") + "\n";
		answer += super.toString();

		return answer;
	}
}
