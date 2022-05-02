package processor;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;
import java.util.TreeMap;

public class ProcessOrder {
	
	TreeMap<String, Double> baseCost;
	TreeMap<String, Integer> numTimesOrdered;
	String resultFileName;
	String fileName;
	String baseFileName;
	int numOrder;

	
	public ProcessOrder(String resultFileName, String fileName, int numOrder, String baseFileName) {
		
		this.baseCost = new TreeMap<String, Double>();
		this.numTimesOrdered = new TreeMap<String, Integer>();
		this.resultFileName = resultFileName;
		this.baseFileName = baseFileName;
		this.fileName = fileName;
		this.numOrder = numOrder;

	}


	
	public void run() {
		
		String toReturn = "";
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(resultFileName);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		TreeMap<String, Integer> itemsOrdered = new TreeMap<String, Integer>();
		TreeMap<String, Integer> inventory = new TreeMap<String, Integer>();

		FileReader fileReader = null;
		
		try {
		
			fileReader = new FileReader(fileName);
		
		} catch (FileNotFoundException e) {
		
			e.printStackTrace();
		
		}
		
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		Scanner fileScanner = new Scanner(bufferedReader);

		while (fileScanner.hasNextLine()) {
			
			String itemName = fileScanner.next();
			double cost = fileScanner.nextDouble();
			
			this.baseCost.putIfAbsent(itemName, cost);
			
		}
		
		
		for(int num = 1; num <= numOrder; num++) {
			
			
			try {
				
				fileReader = new FileReader(baseFileName + num + ".txt");
			
			} catch (FileNotFoundException e) {
			
				e.printStackTrace();
			
			}
			
			bufferedReader = new BufferedReader(fileReader);
			fileScanner = new Scanner(bufferedReader);

			fileScanner.next();
			fileScanner.nextInt();
			
			while (fileScanner.hasNextLine()) {
								
				String toAdd = fileScanner.next();
				fileScanner.next();

				if(itemsOrdered.containsKey(toAdd)) {
										
					itemsOrdered.put(toAdd, itemsOrdered.get(toAdd) + 1);
					
				} else {
					
					itemsOrdered.put(toAdd, 1);
					
				}
				
				if(inventory.containsKey(toAdd)) {
					
					inventory.put(toAdd, inventory.get(toAdd) + 1);
					
				} else {
					
					inventory.put(toAdd, 1);
					
				}
				
		
			}
			
			toReturn += "----- Order details for client with Id: "+ (1000 + num)
			+ " ----- \n"; 
			double total = 0;
			
			for(String print : itemsOrdered.keySet()) {
				
				Double cost = baseCost.get(print);
				int number = itemsOrdered.get(print);
				
				total += (cost * number);
				
				toReturn += "Item's name: " + print + ", Cost per item: " +  
						NumberFormat.getCurrencyInstance(Locale.US).format(
						cost) + ", Quantity: " + number + ", Cost: " + 	
						NumberFormat.getCurrencyInstance(Locale.US).format(
						cost * number) + "\n"; 	
			
			}
			
			toReturn += "Order Total: " + NumberFormat.
			getCurrencyInstance(Locale.US).format(total) + "\n";
			
			
			itemsOrdered.clear();
			
		}

		Double total = 0.0;
		
		toReturn += "***** Summary of all orders ***** \n";
		
		for(String item : inventory.keySet()) {
			
			Double cost = baseCost.get(item);
			int number = inventory.get(item);
			
			total += (cost * number);
			
			toReturn += "Summary - Item's name: " + item + ", Cost per item: " +  
					NumberFormat.getCurrencyInstance(Locale.US).format(
					cost) + ", Number sold: " + number + ", Item's Total: " + 	
					NumberFormat.getCurrencyInstance(Locale.US).format(
					cost * number) + "\n";
			
		}
		
		toReturn += "Summary Grand Total: " + NumberFormat.
				getCurrencyInstance(Locale.US).format(total) + "\n";
		
		fileScanner.close();
		
		try {
			fileWriter.write(toReturn);
			fileWriter.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}