package exp;

import java.util.Scanner;

/**
 * Example relies on System.currentTimeMillis() (from Unix Epoch)
 * 
 * @author cmsc132
 *
 */
public class TimeExpQuadratic {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("\n**** We see quadratic behavior as n increases ****");
		for (long n : new long[] { 64, 128, 256, 2048, 4096, 8192, 16384, 32768, 65536 }) {
			long sum = 0;
			
			/* Starting to measure time at this point */
			long startTime = System.currentTimeMillis();
			for (long row = 1; row <= n; row++) {
				for (long col = 1; col <= n; col++) {
					sum += row + col;
				}
			}
			long endTime = System.currentTimeMillis();
			/* Stop measuring time */
			
			long duration = endTime - startTime;
			System.out.printf("n: %6d, time: %6d, sum: %20d\n", n, duration, sum);
		}
		System.out.println("Done");
		scanner.close();
	}
}
