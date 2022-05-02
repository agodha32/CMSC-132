package examples;

import java.util.*;

public class Fibonacci {
	public static long callsCounter = 0;

	public static long fib(long n) {
		callsCounter++;

		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		} else {
			return fib(n - 1) + fib(n - 2);
		}
	}

	public static long fibOptimized(long n) {
		int maxFibNumber = 92;

		if (n > maxFibNumber) {
			throw new IllegalArgumentException("Invalid argument");
		}

		long[] table = new long[maxFibNumber + 1];
		return fibOptimized(n, table);
	}

	public static long fibOptimized(long n, long[] table) {
		callsCounter++;
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		} else if (table[(int) n] != 0L) {
			return table[(int) n];
		} else {
			return table[(int) n] = fibOptimized(n - 1, table) + fibOptimized(n - 2, table);
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter limit (e.g., 5 or 42): ");
		long limit = scanner.nextLong();

		System.out.print("Enter yes for optimized, no otherwise: ");
		String choice = scanner.next();

		if (choice.equals("no")) {
			for (long i = 0; i <= limit; i++) {
				System.out.print("fib(" + i + "): " + fib(i));
				System.out.println(", Calls: " + callsCounter);
				callsCounter = 0;
			}
		} else {
			for (long i = 0; i <= limit; i++) {
				System.out.print("fibOptimized(" + i + "): " + fibOptimized(i));
				System.out.println(", Calls: " + callsCounter);
				callsCounter = 0;
			}
		}

		scanner.close();
	}
}
