package arrays;

import java.util.Arrays;

public class Driver {

	public static void main(String[] args) {
		String answer = "";

		int[][] data = { { 10, 30 }, null, { 8 }, null, {} };
		answer += "NumberRowsNullOrEmpty: " + ArrayUtilities.getNumberRowsSetToNullOrEmpty(data);
		answer += "\n==================================================\n\n";

		int[][] result = ArrayUtilities.getArrayCopyWithoutNullEmptyRows(data);
		answer += "ArrayCopyWithoutNullEmptyRows: ";
		for (int i = 0; i < result.length; i++) {
			answer += Arrays.toString(result[i]);
		}
		answer += "\n==================================================\n\n";

		System.out.println(answer);
	}
}