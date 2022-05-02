package appliance;

public class Refrigerator implements Appliance, Comparable<Refrigerator> {
	private String brand;
	private int bins;
	private StringBuffer items;
	private static final int DEFAULT_BINS_NUMBER = 10;

	/* Does this class have a default constructor? */
	
	public Refrigerator(String brand, int bins) {
		this.brand = brand;
		this.bins = bins;
		items = new StringBuffer();
	}

	public Refrigerator(String brand) {
		this(brand, DEFAULT_BINS_NUMBER);
	}

	public Refrigerator(Refrigerator refrigerator) {
		brand = refrigerator.brand;
		bins = refrigerator.bins;
		items = new StringBuffer(refrigerator.items);
	}

	public String getBrand() {
		return brand;
	}

	public int getBins() {
		return bins;
	}

	public Refrigerator addItem(String itemName) {
		if (itemName == null) {
			throw new IllegalArgumentException("Invalid");
		}

		items.append(itemName);

		return this;
	}

	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		Refrigerator ref = (Refrigerator) obj;

		return brand.equals(ref.brand) && bins == ref.bins;
	}

	public int compareTo(Refrigerator refrigerator) {
		return bins - refrigerator.bins;
	}

	public String toString() {
		return "Refrigerator [brand=" + brand + ", bins=" + bins + ", items=" + items + "]";
	}
}