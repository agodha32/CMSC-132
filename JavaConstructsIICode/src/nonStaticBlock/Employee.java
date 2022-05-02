package nonStaticBlock;

public class Employee {
	private String name;
	private int age;
	private double salary = 100;

	public Employee(String name, int age) {
		this.name = name;
		this.age = age;
		salary = 4567;  // Will override any previous initializations
	}

	public Employee() {
		this.name = "NONAME";
		this.age = 0;
		salary = 1234;  // Will override any previous initializations
	}

	{
		System.out.println("Before first init: " + salary);
		salary = 200;
		System.out.println("salaryInit1, sets salary to " + salary);
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", salary=" + salary + "]";
	}

	{
		salary = 400;
		System.out.println("salaryInit2, sets salary to " + salary);
	}

	public static void main(String[] args) {
		System.out.println("\n\n**** Using two parameters constructor");
		Employee employee1 = new Employee("John", 999);
		System.out.println(employee1);

		System.out.println("\n**** Using default constructor");
		System.out.println(new Employee());
	}
}
