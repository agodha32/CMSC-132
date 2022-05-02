package examples;

import javax.swing.*;

public class Caught {
	public static void main(String[] args) {
		test();
	}

	public static void test() {
		String message = "Percentage material understood", status = null;
		try {
			/* Double.parseDouble throws an unchecked exception we don't need to handle */
			double value = Double.parseDouble(JOptionPane.showInputDialog(message));
			if (value < 70) {
				status = "Problem";
				throw new NotPayingAttentionException("Lower than 70%");
			} else {
				status = "Good Progress";
			}
		} catch (NotPayingAttentionException e) {
			System.out.println(e.getMessage());
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "You must provide a number");
		} finally {
			/* Even if exception is thrown we want to see the status message */
			JOptionPane.showMessageDialog(null, status);
		}
	}
}
