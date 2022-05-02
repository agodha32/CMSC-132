package ex2maps;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class ListsAsKeysE4 {
	public static void main(String[] args) {
		/* Favorite dessert map; adding person's first and last name */
		HashMap<List<String>, String> favoriteDessertMap = new HashMap<>();

		ArrayList<String> johnSmith = new ArrayList<>();
		johnSmith.add("John");
		johnSmith.add("Smith");
		favoriteDessertMap.put(johnSmith, "Chocolate");

		ArrayList<String> rosePeterson = new ArrayList<>();
		rosePeterson.add("Rose");
		rosePeterson.add("Peterson");
		favoriteDessertMap.put(rosePeterson, "Ice Cream");

		System.out.println("**** Dessert Preferences ****");
		for (List<String> list : favoriteDessertMap.keySet()) {
			System.out.println(list + " " + favoriteDessertMap.get(list));
		}

		/* Retrieving */
		System.out.println("\n**** Retrieving someone's preference ****");
		ArrayList<String> temp = new ArrayList<>();
		temp.add("John");
		temp.add("Smith");
		if (favoriteDessertMap.containsKey(temp)) {
			System.out.println("John Smith's Favorite Dessert: " + favoriteDessertMap.get(temp));
		}

		/* Notice what happens after clearing the entry */
		johnSmith.clear();
		System.out.println("\n**** Listing Map Contents After Clearing: ****");
		for (List<String> list : favoriteDessertMap.keySet()) {
			System.out.println(list + " " + favoriteDessertMap.get(list));
		}
	}
}
