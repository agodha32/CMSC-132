package wildcard;

import java.util.*;

public class Wildcard {
	public static void printComputers(ArrayList<Computer> arrayListComputer) {
		for (Computer computer : arrayListComputer) {
			System.out.println(computer);
		}
	}

	public static void printComputersTwo(Collection<Computer> collectionComputer) {
		for (Computer computer : collectionComputer) {
			System.out.println(computer);
		}
	}

	public static void printObjects(ArrayList<Object> arrayListObjects) {
		for (Object object : arrayListObjects) {
			System.out.println(object);
		}
	}

	public static void printAny(ArrayList<?> arrayListInterrogationSign) {
		// ? imposes restriction that we cannot modify the ArrayList
		
		// arrayListInterrogationSign.add(new Integer(10)); // Would this work?
		// arrayListInterrogationSign.add(new Computer("CS", 10)); // Would this work?
		for (Object object : arrayListInterrogationSign) {
			System.out.println(object);
		}
	}

	public static void printAnyComputer(ArrayList<? extends Computer> arrayListAnythingComputer) {
		for (Computer computer : arrayListAnythingComputer) {
			System.out.println(computer);
		}
	}

	public static void printPortables(ArrayList<? extends PortableDevice> arrayListAnythingPortableDevice) {
		for (PortableDevice portableDevice : arrayListAnythingPortableDevice) {
			System.out.println(portableDevice);
		}
	}

	public static void main(String[] args) {
		Laptop laptop1 = new Laptop("Delly", 10, "BatA");
		Computer computer1 = new Computer("ICM", 20);
		ArrayList<Computer> computerList = new ArrayList<Computer>();
		ArrayList<PortableDevice> portableList = new ArrayList<PortableDevice>();
		
		portableList.add(laptop1);
		computerList.add(laptop1);
		computerList.add(computer1);
		
		// ArrayList<?> a1 = computerList;   // Valid or Invalid?
		// ArrayList<?> a2 = portableList;    // Valid or Invalid?
		// ArrayList<? extends Computer> a3 = portableList;  // Valid or Invalid?
		// ArrayList<Object> a4 = computerList;				 // Valid or Invalid?
		
		// printComputers(computerList);    // Valid or Invalid?
		// printComputersTwo(computerList); // Valid or Invalid?
		// printObjects(computerList);      // Valid or Invalid?
		// printAny(computerList);          // Valid or Invalid?
		// printAnyComputer(computerList);  // Valid or Invalid?
		// printAnyComputer(portableList);  // Valid or Invalid?
		// printPortables(computerList);    // Valid or Invalid?
		// printPortables(portableList);    // Valid or Invalid?
	}
}
