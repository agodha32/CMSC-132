package nestedStatic;

public class Driver {

	public static void main(String[] args) {
		
		/* We are not creating OuterClass instance */

		System.out.println("yStaticField: " + OuterClass.yStaticField);

		/* Creating static inner class instance */
		OuterClass.NestedExample nestedExample = new OuterClass.NestedExample();

		/* Calling method of static inner class instance */
		nestedExample.someMethod();

		System.out.println("yStaticField: " + OuterClass.yStaticField);
	}
}
