package state;

public class Driver {
	public static void main(String[] args) {
		VendingMachine vendingMachine = new VendingMachine();

		System.out.println("***** First Transaction *****");
		vendingMachine.getCandy("Peanuts");
		vendingMachine.insertMoney(1);
		vendingMachine.getCandy("Peanuts");
		vendingMachine.cancel();

		System.out.println("\n\n***** Second Transaction *****");
		vendingMachine.insertMoney(5);
		vendingMachine.getCandy("Peanuts");
		vendingMachine.insertMoney(10);
		vendingMachine.getCandy("Chocolate");

		System.out.println("\n\n***** Third Transaction *****");
		vendingMachine.insertMoney(5);
		vendingMachine.insertMoney(10);
		vendingMachine.getCandy("Peanuts");
	}
}
