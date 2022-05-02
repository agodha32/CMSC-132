package threaded;

import java.io.*;
import java.util.*;

import nonThreaded.Income;
	
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
	
	public static void main(String[] args) throws FileNotFoundException, InterruptedException {
		ArrayList<PizzaOrder> allOrders = readOrders();
		TreeMap<String, Integer> itemsCount = new TreeMap<>();
		Income totalIncome = new Income(0);
		
		/* Creating Threads */
		ArrayList<Thread> allThreads = new ArrayList<Thread>();
		for (PizzaOrder order : allOrders) {
			allThreads.add(new Thread(new ProcessPizzaOrder(order, itemsCount, totalIncome)));
		}
		
		/* Starting Threads */
		for (Thread thread : allThreads) {
			thread.start();
		}

		/* Joining (Waiting for threads to finish) */
		for (Thread thread : allThreads) {
			thread.join();
		}

		System.out.println("Total Income: $" + totalIncome);
		System.out.println("Items Sold: " + itemsCount);
	}
}
