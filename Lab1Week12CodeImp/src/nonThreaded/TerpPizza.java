package nonThreaded;

import java.io.*;
import java.util.*;
	
public class TerpPizza {
	public static ArrayList<PizzaOrder> readOrders() throws FileNotFoundException {
		ArrayList<PizzaOrder> orders = new ArrayList<PizzaOrder>();
		
		Scanner scanner = new Scanner(new File("orders.txt"));
		while (scanner.hasNext()) {
			String orderId = scanner.next();
			int numberOfItems = scanner.nextInt();
			scanner.nextLine(); // getting rid of ===========
			
			PizzaOrder pizzaOrder = new PizzaOrder(orderId);
			for (int i = 1; i <= numberOfItems; i++) {
				pizzaOrder.addItem(scanner.next(), scanner.nextInt());
			}
			orders.add(pizzaOrder);
		
		}
		scanner.close();
		
		System.out.println("Number of orders loaded: " + orders.size() + "\n");
		
		return orders;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		ArrayList<PizzaOrder> allOrders = readOrders();
		TreeMap<String, Integer> itemsCount = new TreeMap<>();
		Income totalIncome = new Income(0);
	
		for (PizzaOrder order : allOrders) {
			String bill = "Bill for order " + order.getId() + "\n";
			int totalOrder = 0;
			for (Item item : order) {
				String description = item.getDescription();
				int cost = item.getCost();
				
				/* Simulating time takes to process an item */
				try {
					Thread.sleep((int)(Math.random() * 3000));
				} catch (InterruptedException e) {
					e.printStackTrace();
				} 
				
				bill += description + " $" +  cost + "\n";
				totalOrder += cost;

				/* Keeping track of number of items count */
				Integer number = itemsCount.get(description);
				if (number == null) {
					itemsCount.put(description, 1);
				} else {
					itemsCount.put(description, number + 1);
				}
			}
			bill += "Total: $" + totalOrder + "\n";
			System.out.println(bill);
		
			totalIncome.add(totalOrder);
		}
		System.out.println("Total Income: $" + totalIncome);
		System.out.println("Items Sold: " + itemsCount);
		
	}
}
