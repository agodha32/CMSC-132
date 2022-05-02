package implementation;

import java.util.ArrayList;

public class Room implements Comparable<Room> {
	private int capacity;
	private ArrayList<String> occupants;

	public Room(int capacity) {

		this.capacity = capacity;
		this.occupants = new ArrayList<String>();
	
	}

	public boolean addOccupant(String name) {
		
		for(String nameFinder : occupants) {
			
			if(name.equals(nameFinder)) {
				
				return false;
				
			}
			
		}

		if(occupants.size() == this.capacity) {
			
			return false;
			
		} else if(name.isBlank() | name == null) {
			
			throw new IllegalArgumentException("Invalid Name");
			
		} else {
			
			this.occupants.add(name);
			return true;
			
		}
	
	}

	public int getCapacity() {

		return this.capacity;
	
	}

	public Room(Room room) {

		this.capacity = room.capacity;
		this.occupants = new ArrayList<String>();
		
		for(String occupantCopier: room.occupants) {
		
			this.occupants.add(occupantCopier);
			
		}
	
	}

	public ArrayList<String> getOccupants() {

		return new ArrayList<String>(this.occupants);
	
	}

	public int getNumberOfOccupants() {

		return occupants.size();
	
	}

	public int compareTo(Room room) {

		if(this.getNumberOfOccupants() == room.getNumberOfOccupants()) {
			
			return 0;
			
		} else if(this.getNumberOfOccupants() < room.getNumberOfOccupants()) {
			
			return -1;
			
		} else {
			
			return 1;
			
		}
	
	}

	public boolean equals(Object obj) {

		if(obj == this) {
			
			return true;
			
		} else if(!(obj instanceof Room)) {
			
			return false;
			
		}
		
		Room room = (Room) obj;
		
		int sameOccupents = 0;
		int sameNumOccupents = this.compareTo(room);
		
		if(sameNumOccupents == 0) {
			
			for(String roomOccupant : this.occupants) {
				
				for(int x = 0; room.occupants.size() > x; x++) {
					
					if(roomOccupant.equals(room.occupants.get(x))) {
						
						sameOccupents++;
						
					}
					
				}
				
			}
			
		} else {
			
			return false;
			
		}
		
		return (sameOccupents == this.occupants.size()) ? true : false;
		
	}

	/* Provided: Do not modify */
	@Override
	public String toString() {
		String answer = "Capacity: " + capacity + ", ";

		return answer += "Occupants: " + occupants;
	}
}
