package nestedStatic;

public class OuterClass {
	private int x;
	public static int yStaticField = 2;

	public OuterClass() {
		x = 1;
		yStaticField = 4;
	}

	public static class NestedExample {
		private int w = 10;

		public void someMethod() {
			w = yStaticField * 2;
			// x=5; // Cannot access x (will not compile) as x is not static
			yStaticField = 20;
			System.out.println("w: " + w);
		}
	}
}
