package cloning;

public class Mouse implements Cloneable {
	private String type;
	private int xPos, yPos;

	public Mouse(String type) {
		this.type = type;
		xPos = yPos = 0;
	}

	public void moveMouse(int xPos, int yPos) {
		this.xPos = xPos;
		this.yPos = yPos;
	}

	public String toString() {
		return type + "-> xPos: " + xPos + ", yPos: " + yPos;
	}

	/* Notice the return type */
	@Override
	public Mouse clone() {
		Mouse obj = null;

		/*
		 * There is nothing extra to do after calling super.clone() as shallow copy is
		 * enough in this case
		 */
		try {
			obj = (Mouse) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}

		return obj;
	}

	public static void main(String[] args) {
		Mouse mouse1 = new Mouse("Optical");
		System.out.println(mouse1);
		
		Mouse copy = mouse1.clone();
		System.out.println(copy);
	}
}