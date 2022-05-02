package subtyping;

import java.util.ArrayList;

public class Driver {
	public static void main(String[] args) {
		arrays();
	}

	public static void lists() {
		// Next line does not compile
		// ArrayList<Fruit> fruitArrayList = new ArrayList<TropicalFruit>(); // Compilation error
		
	}

	public static void arrays() {
		TropicalFruit[] tropicalFruitArray = new TropicalFruit[2];
		
		tropicalFruitArray[0] = new TropicalFruit("mango", "yellow", "Caribbean");
		tropicalFruitArray[1] = new TropicalFruit("banana", "yellow", "Caribbean");
		
		// Compare the next assignment with the one in lists() method above
		Fruit[] fruitArray = tropicalFruitArray;
		
		for (Fruit fruit : fruitArray) {
			System.out.println(fruit);
		}
		// Next generates exception because at runtime 
		// java sees that fruitArray is an array of TropicalFruit references
		// fruitArray[0] = new Fruit("pear", "green"); // Generates exception 
		
		// tropicalFruitArray[0] = new Fruit("tomato", "red"); // Compilation error
	}
}
