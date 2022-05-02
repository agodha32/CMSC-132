package examples;

public class Factorial {

	public static int factorial(int n) {
		if (n == 0) { // What if we remove the base case?
			return 1;
		} else {
			return n * factorial(n - 1); // do not use n--
		}
	}

	public static void main(String[] args) {
		int x = 5, result;

		result = factorial(x);
		System.out.println(result);
	}
}
