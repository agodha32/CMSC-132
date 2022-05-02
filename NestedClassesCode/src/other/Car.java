package other;

/* First Class */
public class Car {
	private String make;
	private Engine engine;

	public Car(String make, int hp) {
		this.make = make;
		engine = new Engine(hp);
	}

	public String toString() {
		return make + ", " + engine;
	}

	public static void main(String[] args) {
		Car car = new Car("Nelyota", 200);
		System.out.println(car);
	}
}

/* Second Class */
/* Try making this class public */
class Engine {
	private int hp;

	public Engine(int hp) {
		super();
		this.hp = hp;
	}

	@Override
	public String toString() {
		return "Engine [hp=" + hp + "]";
	}
}