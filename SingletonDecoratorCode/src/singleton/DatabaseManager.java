package singleton;

public final class DatabaseManager {
	/* Single DatabaseManager object created when class is loaded. */
	/* When is a class loaded? */
	private static DatabaseManager manager = new DatabaseManager();
	private StringBuffer transactions;

	private DatabaseManager() {
		transactions = new StringBuffer();
	}

	public void addTransaction(String transaction) {
		transactions.append("[" + transaction + "]");
	}

	public String getTransactions() {
		return transactions.toString();
	}

	public static DatabaseManager getDatabaseManager() {
		return manager;
	}
}
