package withAbstractClass;

public class Rectangle extends Shape {
	private int width, length;

	public Rectangle(String color, int width, int length) {
		super(color);
		this.width = width;
		this.length = length;
	}

	public void drawMe() {
		System.out.print("Drawing Rectangle with dimensions (W/L): ");
		System.out.println(width + " " + length);
	}
}
