package appliance;

public class Toaster implements Appliance {
	private String brand;
	private int cost, toastingLevel;

	public Toaster(String brand, int cost) {
		this.brand = brand;
		this.cost = cost;
	}

	public String getBrand() {
		return brand;
	}

	public int getCost() {
		return cost;
	}

	public void setToastingLevel(int toastingLevel) {
		this.toastingLevel = toastingLevel;
	}

	public String toString() {
		return "Toaster [brand=" + brand + ", cost=" + cost + ", toastingLevel=" + toastingLevel + "]";
	}
}