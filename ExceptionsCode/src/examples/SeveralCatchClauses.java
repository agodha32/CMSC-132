package examples;

import javax.swing.*;

public class SeveralCatchClauses {
	private static final int START_YEAR_INDEX = 3;
	private static final int END_YEAR_INDEX = 6;

	public static void main(String[] args) {
		String date = "";
		try {
			date = JOptionPane.showInputDialog("Enter date using format: (mm/yyyy)");

			// substring may throw IndexOutOfBoundsException (e.g., 10/20)
			String yearString = date.substring(START_YEAR_INDEX, END_YEAR_INDEX + 1);

			// parseInt may throw NumberFormatException (e.g., 10/AB)
			int year = Integer.parseInt(yearString);

			System.out.println("The year is " + year);

		} catch (IndexOutOfBoundsException e) {
			System.out.println("Index error: invalid year value");
		} catch (NumberFormatException e) {
			System.out.println("Number format exception: invalid year value");
		} finally {
			System.out.println("The original string: " + date);
		}
	}
}