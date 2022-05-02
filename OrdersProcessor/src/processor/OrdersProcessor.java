package processor;

import java.util.ArrayList;
import java.util.Scanner;

public class OrdersProcessor {	
	
public static void main(String [] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter item's data file name: ");
		String fileName = scanner.nextLine();
		
		System.out.println("Enter 'y' for multiple threads, any other character otherwise: ");
		char threads = scanner.nextLine().charAt(0);

		System.out.println("Enter number of orders to process: ");
		int numOrder = scanner.nextInt();

		System.out.println("Enter order's base filename: ");
		scanner.nextLine();
		String baseFileName = scanner.nextLine();

		System.out.println("Enter result's filename: ");
		String resultFileName = scanner.nextLine();
		
		ArrayList<ProcessOrder> allOrders = new ArrayList<ProcessOrder>();
		
		scanner.close();
		
		long startTime = System.currentTimeMillis();
		
			if(threads != 'y') {
		
				for(int x = 1; x <= numOrder; x++) {
				

					allOrders.add(new ProcessOrder(resultFileName, fileName, numOrder, baseFileName));
					allOrders.get(x - 1).run();
				
					System.out.println("Reading Order for Client with id: " + (1000 + x));
				
				}
			
			}
				
		long endTime = System.currentTimeMillis();
			
		System.out.println("Processing time (msec): " + (endTime - startTime) + "\n");
		
	}
	

}