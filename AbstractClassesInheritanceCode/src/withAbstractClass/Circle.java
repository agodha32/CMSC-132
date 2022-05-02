package withAbstractClass;

public class Circle extends Shape {
	private double radius;

	public Circle(String color, double radius) {
		super(color);
		this.radius = radius;
	}

	public void drawMe() {
		System.out.println("Drawing Circle with radius " + radius);
	} 

	/*
	 * Defined as final as we don't want classes extending Circle to change the area
	 * computation.
	 */
	public final double getArea() {
		return radius * radius * Math.PI;
	}
}
