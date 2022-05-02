package implementation;

public class Building {
	protected Room[][] allFloors;
	protected int maxFloors, roomsPerFloor, roomCapacity;
	private final String address;

	public Building(String address, int maxFloors, int roomsPerFloor, int roomCapacity) {

		this.address = address;
		this.maxFloors = maxFloors;
		this.roomCapacity = roomCapacity;
		this.roomsPerFloor = roomsPerFloor;
		
		this.allFloors = new Room[maxFloors][roomsPerFloor];
		
		for(int floor = 0; maxFloors > floor; floor++) {
			
			for(int room = 0; roomsPerFloor > room; room++) {
				
				allFloors[floor][room] = new Room(roomCapacity);
				
			}
			
		}
	
	}

	public Building() {
		
		this.address = "NOADDRESS";
		this.maxFloors = 1;
		this.roomCapacity = 1;
		this.roomsPerFloor = 1;

	}

	protected Room getRoom(int floorIndex, int roomNumberIndex) {

		if(floorIndex < 0 || floorIndex > this.maxFloors || roomNumberIndex < 0
			|| roomNumberIndex > this.roomsPerFloor) {
			
			throw new IllegalArgumentException ("Incorrect Number");
			
		} else {
			
			return allFloors[floorIndex][roomNumberIndex];
			
		}
	
	}

	public boolean addOccupant(String name, int floorIndex, int roomNumberIndex) {
		
		try {
			
			this.getRoom(floorIndex, roomNumberIndex);
			
		} catch (Exception IllegalArgumentException) {
			
			return false;
			
		}
		
		boolean addOrNot = allFloors[floorIndex][roomNumberIndex].addOccupant(name);
		
		return addOrNot;
	
	}

	/* Provided: Do not modify */
	@Override
	public String toString() {
		String answer = "Address: " + address + "\n";

		answer += "MaxFloors: " + maxFloors + ", ";
		answer += "RoomsPerFloor: " + roomsPerFloor + ", ";
		answer += "RoomCapacity:" + roomCapacity + "\n";

		for (int floorIndex = 0; floorIndex < maxFloors; floorIndex++) {
			answer += "\n****** Floor: " + floorIndex + " ******\n";
			for (int roomIndex = 0; roomIndex < roomsPerFloor; roomIndex++) {
				answer += "Room: " + roomIndex + ", ";
				answer += allFloors[floorIndex][roomIndex] + "\n";
			}
		}

		return answer;
	}
}
