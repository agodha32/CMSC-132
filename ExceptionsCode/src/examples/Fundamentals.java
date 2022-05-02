package examples;

import javax.swing.JOptionPane;

public class Fundamentals {
	public static void evenOdd() {
		String prompt = "Enter integer value";

		try {
			int value = Integer.parseInt(JOptionPane.showInputDialog(prompt));
			String message = "odd";
			if (value % 2 == 0) {
				message = "even";
			}
			JOptionPane.showMessageDialog(null, message);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "You must provide an integer value");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		evenOdd();
	}
}
