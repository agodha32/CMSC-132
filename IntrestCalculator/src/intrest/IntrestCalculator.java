package intrest;

import java.text.NumberFormat;

public abstract class IntrestCalculator {

	
	/**
	 * 
	 * This class is doing all the calculations
	 *
	 */

	/**
	 * 
	 * Calculates the simple intrest
	 * 
	 */

	public static String simpleInterest(double OriginalAmount, double 
			ratePercentage, double years) {

		return NumberFormat.getCurrencyInstance()
				.format(OriginalAmount + (OriginalAmount * 
						(ratePercentage / 100) * years));

	}

	/**
	 * 
	 * To compute compound interest, use the following formula:
	 * 
	 */

	public static String compoundInterest(double OriginalAmount, double 
			ratePercentage, double years) {

		return NumberFormat.getCurrencyInstance().format((OriginalAmount * 
				Math.pow(1 + ratePercentage / 100, years)));

	}

	/**
	 * 
	 * Return a table with the simple intrest calculaitons
	 * 
	 */

	public static String simpleInterestTable(double OriginalAmount, double 
			ratePercentage, double years) {

		String toReturn = "Original Amount: " + OriginalAmount + ", Rate: " 
		+ ratePercentage + "\n Year, Simple Interest Amount";

		for (int row = 1; years >= row; row++) {

			toReturn += "\n" + row + " --> " + simpleInterest(OriginalAmount, 
					ratePercentage, row) + row;

		}

		return toReturn;

	}

	/**
	 * 
	 * Return the Compound Intrest Table
	 * 
	 */

	public static String compoundInterestTable(double OriginalAmount, double 
			ratePercentage, double years) {

		String toReturn = "Original Amount: " + OriginalAmount + ", Rate: " 
		+ ratePercentage + "\n Year, Compound Interest Amount";

		for (int row = 1; years >= row; row++) {

			toReturn = toReturn + "\n" + row + " --> " + compoundInterest(
					OriginalAmount, ratePercentage, row);

		}

		return toReturn;
	}

	/**
	 * 
	 * Return both the simple and compount intrest table
	 * 
	 */

	public abstract String bothInterestsTable(double OriginalAmount, double 
			ratePercentage, double years);

}
