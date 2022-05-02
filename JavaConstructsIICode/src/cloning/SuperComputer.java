package cloning;

/* It is not implementing Cloneable */
public class SuperComputer extends Computer {
	private StringBuffer users;
	private int coolingFactor;

	public SuperComputer(String brand, Mouse mouse, int coolingFactor) {
		super(brand, mouse);
		this.coolingFactor = coolingFactor;
		users = new StringBuffer();
	}

	public int getCoolingFactor() {
		return coolingFactor;
	}

	public void addUser(String name) {
		users.append(name);
	}

	public void printUsers() {
		System.out.println("Users: " + users);
	}

	@Override
	public SuperComputer clone() {
		SuperComputer obj = (SuperComputer) super.clone();
		obj.users = new StringBuffer(users);

		return obj;
	}

	public static void main(String[] args) {
		Mouse mouse = new Mouse("Optical");
		SuperComputer superComputer = new SuperComputer("ibm", mouse, 10);
		SuperComputer superComputerCopy;

		superComputer.addUser("John");
		superComputerCopy = superComputer.clone();
		
		/* Adding users to copy will not affect users of original computer */
		superComputerCopy.addUser("Mary");

		System.out.println("Users original supercomputer: ");
		superComputer.printUsers();

		System.out.println("Users copy of supercomputer: ");
		superComputerCopy.printUsers();
	}
}
