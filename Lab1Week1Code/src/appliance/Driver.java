package appliance;

import java.util.ArrayList;

public class Driver {

	public static void main(String[] args) {
		String answer = "", brand = "GE";
		int bins = 20;

		Refrigerator r1 = new Refrigerator(brand, bins);
		r1.addItem("milk").addItem("cheese");
		answer += r1 + "\n";

		Refrigerator r2 = new Refrigerator("Cheap", 5);
		answer += r2 + "\n";

		Refrigerator r3 = new Refrigerator("Sony", 20);
		r3.addItem("lettuce").addItem("tomato").addItem("cheese");
		answer += r3 + "\n";

		answer += "Brand: " + r1.getBrand() + "\n";
		answer += "Bins: " + r1.getBins() + "\n";

		answer += "Equality: " + r1.equals(r2) + "\n";
		answer += "Comparison: " + (r1.compareTo(r2) < 0 ? true : false) + "\n";
		answer += "==================================================\n";

		Toaster t1 = new Toaster("Sharp", 35);
		t1.setToastingLevel(50);
		answer += t1 + "\n";
		Toaster t2 = new Toaster("LG", 100);
		t2.setToastingLevel(10);
		answer += t2 + "\n";
		answer += "==================================================\n";

		int maxRefrigerators = 60;
		Store store = new Store("TerpMart", maxRefrigerators);
		store.addRefrigerator("Sony", 20).addRefrigerator("LG", 15);
		store.addRefrigerator("Sharp", 8).addRefrigerator("GE", 4);
		answer += "Store:\n";
		answer += store + "\n";
		answer += "Number of Refrigerators with bins in range: " + store.getCountWithBinsInRange(8, 16);
		answer += "\nRefrigerators in range:\n";
		Refrigerator[] found = store.getRefrigerators(8, 16);
		for (Refrigerator refrigerator : found) {
			answer += refrigerator + "\n";
		}
		answer += "==================================================\n";

		ArrayList<Appliance> appliances = new ArrayList<Appliance>();
		appliances.add(r1);
		appliances.add(r2);
		appliances.add(r3);
		appliances.add(t1);
		appliances.add(t2);
		answer += "\nAll Applicances:\n";
		answer += appliances + "\n\n";
		answer += "***Only Refrigerators with number of bins: " + bins + "\n";
		answer += Store.getRefrigeratorsWithNumberOfBins(appliances, bins);
		answer += "\n==================================================\n\n";

		System.out.println(answer);
	}
}