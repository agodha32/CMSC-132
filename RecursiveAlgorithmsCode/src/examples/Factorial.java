package examples;

public class Factorial {

	public static int factRecursive(int n) {
		if (n == 0) {
			return 1;
		} else {
			return n * factRecursive(n - 1);
		}
	}

	public static int factIterative(int n) {
		int i, res = 1;
		
		for (i = n; i > 0; i--) {
			res = res * i;
		}
		
		return res;
	}

	public static int factA(int n) {
		if (n == 0) {
			return 1;
		} else {
			return n * factB(n - 1);
		}
	}

	public static int factB(int n) {
		if (n == 0) {
			return 1;
		} else {
			return n * factA(n - 1);
		}
	}

	public static void main(String[] args) {
		System.out.println(factIterative(5));
		System.out.println(factRecursive(5));
		System.out.println(factA(5));
	}
}