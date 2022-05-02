package threaded;

public class Item {
	private String description;
	private int cost;
	
	public Item(String description, int cost) {
		this.description = description;
		this.cost = cost;
	}
	
	public String getDescription() {
		return description;
	}
	
	public int getCost() {
		return cost;
	}
	
	public String toString() {
		return description + "(" + cost + ")";
	}
}
