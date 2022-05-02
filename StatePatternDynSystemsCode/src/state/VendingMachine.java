package state;

public class VendingMachine {
	private int totalDollars = 0;
	private static int CANDYCOST = 2;
	private VMState READYTOSELL = new ReadyToSell();
	private VMState MAKESELECTION = new MakeSelection();
	private VMState currentState = READYTOSELL;

	public void insertMoney(int dollars) {
		currentState.insertMoney(dollars);
	}

	public void getCandy(String choice) {
		currentState.getCandy(choice);
	}

	public void cancel() {
		currentState.cancel();
	}

	private class ReadyToSell implements VMState {
		public void insertMoney(int dollars) {
			totalDollars += dollars;
			if (totalDollars >= CANDYCOST) {
				int change = totalDollars - CANDYCOST;
				if (change != 0)
					System.out.println("Returning " + change);
				totalDollars = 0;
				System.out.println("Make Selection");
				currentState = MAKESELECTION;
			}
		}

		public void getCandy(String choice) {
			System.out.println("You need to insert money");
		}

		public void cancel() {
			System.out.println("Returning " + totalDollars + " dollar(s)");
			totalDollars = 0;
		}
	}

	private class MakeSelection implements VMState {
		public void insertMoney(int dollars) {
			System.out.println("Returning " + dollars + " dollar(s)");
		}

		public void getCandy(String choice) {
			if (choice == "Chocolate" || choice == "Peanuts") {
				System.out.println("Your candy " + "(" + choice + ")" + " is now available.");
				currentState = READYTOSELL;
			} else
				System.out.println("Invalid candy choice");
		}

		public void cancel() {
			System.out.println("Returning " + CANDYCOST + " dollar(s)");
			currentState = READYTOSELL;
		}
	}
}
