package examples;

public class StringRecursiveMethods {
	/**
	 * Prints a string recursively (does not handle empty string)
	 * 
	 * @param str
	 */
	public static void printString(String str) {
		if (str.length() == 1) {
			System.out.print(str.charAt(0));
		} else {
			System.out.print(str.charAt(0));
			printString(str.substring(1));
		}
	}

	/**
	 * Prints a string recursively (handles empty string)
	 * 
	 * @param str
	 */
	public static void printString2(String str) {
		if (str.isEmpty()) {
			System.out.print("");
		} else {
			System.out.print(str.charAt(0));
			printString2(str.substring(1));
		}
	}

	/**
	 * Finds a character in a string recursively
	 * 
	 * @param str
	 */
	public static boolean find(String str, char target) {
		if (str.isEmpty()) {
			return false;
		} else if (str.charAt(0) == target) {
			return true;
		} else {
			return find(str.substring(1), target);
		}
	}

	/**
	 * Returns the number of instances of target in the string
	 * 
	 * @param str
	 * @param target
	 * @return
	 */
	public static int countChar(String str, char target) {
		if (str.isEmpty()) {
			return 0;
		} else if (str.charAt(0) == target) {
			return 1 + countChar(str.substring(1), target);
		} else {
			return countChar(str.substring(1), target);
		}
	}

	/**
	 * Returns a string without the specified target character
	 * 
	 * @param str
	 * @param target
	 * @return
	 */
	public static String removeChar(String str, char target) {
		if (str.isEmpty()) {
			return "";
		} else if (str.charAt(0) == target) {
			return removeChar(str.substring(1), target);
		} else {
			return str.charAt(0) + removeChar(str.substring(1), target);
		}
	}

	/**
	 * Returns a string that corresponds to reversing the str parameter
	 * 
	 * @param str
	 * @return
	 */
	public static String reverse(String str) {
		if (str.isEmpty()) {
			return "";
		} else {
			return reverse(str.substring(1)) + str.charAt(0);
		}

		/* How can we write this method in a single line? */
	}
}
