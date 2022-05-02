package cloning;

/* See what happens when you remove implements Cloneable */
/* and try to run the example again */

public class Computer implements Cloneable {
	private String brand;
	private Mouse mouse;

	public Computer(String brand, Mouse mouse) {
		this.brand = brand;
		this.mouse = mouse;
	}

	public Mouse getMouse() {
		return mouse; /* Would it make sense to return a copy? */
	}

	@Override
	public Computer clone() {
		Computer obj = null; // Pacifies the compiler

		/* After super.clone() we need to duplicate mouse otherwise
		 * two computers will be associated with the same mouse.
		 */
		try {
			obj = (Computer) super.clone(); // We need casting as clone() returns Object
			if (mouse != null) {
				obj.mouse = mouse.clone(); /* computer has its own mouse */
			}
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}

		return obj;
	}

	public String toString() {
		return "Brand: " + brand + ", Mouse: " + mouse;
	}

	public static void main(String[] args) {
		Computer computer1 = new Computer("Dell", new Mouse("Optical"));
		Computer computersCopy = computer1.clone();

		/* Moving mouse on copy does not affect original */
		computersCopy.getMouse().moveMouse(10, 20);

		System.out.println("Original----> " + computer1);
		System.out.println("Copy:---->" + computersCopy);
	}
}
