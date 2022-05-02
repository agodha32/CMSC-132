package subtyping;

public class Fruit {
	private String name, color;

	public Fruit(String name, String color) {
		this.name = name;
		this.color = color;
	}

	public String getName() {
		return name;
	}

	public String getColor() {
		return color;
	}

	public String toString() {
		return name + " " + color;
	}
}
