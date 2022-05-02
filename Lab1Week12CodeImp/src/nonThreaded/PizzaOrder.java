package nonThreaded;

import java.util.*;

public class PizzaOrder implements Iterable<Item> {
	private String id;
	private ArrayList<Item> items;

	public PizzaOrder(String id) {
		this.id = id;
		items = new ArrayList<Item>();
	}

	public String getId() {
		return id;
	}

	public void addItem(String description, int cost) {
		items.add(new Item(description, cost));
	}

	public Iterator<Item> iterator() {
		return items.iterator();
	}
	
	public String toString() {
		return id + ":" + items;
	}
}
