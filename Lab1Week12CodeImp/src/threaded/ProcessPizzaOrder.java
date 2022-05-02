package threaded;

import java.util.TreeMap;

import nonThreaded.Income;

public class ProcessPizzaOrder implements Runnable {
	private TreeMap<String, Integer> itemsCount;
	private Income totalIncome;
	private PizzaOrder order;

	public ProcessPizzaOrder(PizzaOrder order, TreeMap<String, Integer> itemsCount, Income totalIncome) {
		this.itemsCount = itemsCount;
		this.totalIncome = totalIncome;
		this.order = order;
	}

	public void run() {
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
			
			bill += description + " $" + cost + "\n";
			totalOrder += cost;

			/* Keeping track of number of items count */
			synchronized (itemsCount) {
				Integer number = itemsCount.get(description);
				if (number == null) {
					itemsCount.put(description, 1);
				} else {
					itemsCount.put(description, number + 1);
				}
			}
		}
		bill += "Total: $" + totalOrder + "\n";
		System.out.println(bill);

		synchronized(totalIncome) {
			totalIncome.add(totalOrder);
		}
	}
}
