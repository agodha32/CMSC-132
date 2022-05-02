package ex2maps;

public class Department {
	private String name;
	private int phoneExtension;

	public Department(String name, int phoneExtension) {
		this.name = name;
		this.phoneExtension = phoneExtension;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPhoneExtension() {
		return phoneExtension;
	}

	public void setPhoneExtension(int phoneExtension) {
		this.phoneExtension = phoneExtension;
	}

	public String toString() {
		return "[Department: " + name + " PhoneExtension: " + phoneExtension + "]";
	}
}
