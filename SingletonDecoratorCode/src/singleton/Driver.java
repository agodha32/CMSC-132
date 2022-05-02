package singleton;

/* When testing a class, your driver should be the main method of
 * a class that resides in package different than the package where
 * the class you are testing resides. Be careful when defining a
 * driver as the main method of the class you are testing, as access
 * specifiers that work, may not work elsewhere.  For example, for
 * the Singleton class DatabaseManager.java, you don't want to
 * test the class by adding a main method to the DatabaseManager
 * class as the private constructor can be invoked in that method.
 */
public class Driver {

	public static void main(String[] args) {
		DatabaseManager manager = DatabaseManager.getDatabaseManager();

		// Following is not allowed (does not compile)
		// DatabaseManager managerTwo = new DatabaseManager();

		// managerTwo initialized to same object as manager
		DatabaseManager managerTwo = DatabaseManager.getDatabaseManager();
		manager.addTransaction("Deposit 200");
		manager.addTransaction("Withdraw 100");
		managerTwo.addTransaction("Withdraw 50");

		System.out.println(manager.getTransactions());
	}
}
