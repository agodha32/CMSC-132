package lamdaExamples;

public class Driver {

	public static void printSize(Toy toy) {
		System.out.println(toy.getSize());
	}

	public static void main(String[] args) {
		// The expected output for this driver can be found in the file DriverOutput.txt
		// Initializes toy with a lambda expression that will return 40
		Toy toy = () -> 40;
		// Using toy
		System.out.println("Toy size: " + toy.getSize());

		// Initializes truck with a lambda expression that computes
		// the product of items by itemWeight
		Truck truck = (items, itemWeight) -> items * itemWeight;
		// Using truck
		int items = 20;
		double itemWeight = 10.50;
		System.out.println("Truck maxLoad: " + truck.computeMaxLoad(items, itemWeight));

		// Initializes report with a lambda expression that doubles the cost,
		// and prints the header and "Cost: " (followed by the cost). The header
		// and cost appear on separate lines
		Report report = (header, cost) -> {
			cost *= 2;
			System.out.println(header + "\nCost: " + cost);
		};
		String reportHeader = "Semi-Anual Report";
		double reportCost = 100000;
		report.printReport(reportHeader, reportCost);

		System.out.println("Calling printSize method");
		// Provides as argument to printSize() a lambda expression that
		// returns 100
		printSize(() -> 100);
	}
}
