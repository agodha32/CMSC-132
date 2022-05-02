package staticBlock;

/**
 * Shows order in which initializations are executed.
 * 
 *
 */
public class VariableInitialization {
	/* Executed before next one, even though next one has the variable declaration */
	static {
		A = 1;
	}
	static int A = 2;
	static {
		A = 3;
	}
	{
		B = 4; /* Executed before next one that has variable declaration */
	}
	private int B = 5;
	{
		B = 6;
	}

	public VariableInitialization() {
		System.out.println("A: " + A);
		System.out.println("B: " + B);
	}

	public static void main(String[] args) {
		new VariableInitialization();
	}
}
