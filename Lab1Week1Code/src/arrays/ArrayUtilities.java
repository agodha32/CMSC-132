package arrays;

public class ArrayUtilities {
	public static int[] makeArrayCopy(int[] data) {
		int[] copy = new int[data.length];

		for (int i = 0; i < data.length; i++) {
			copy[i] = data[i];
		}

		return copy;
	}

	public static int getNumberRowsSetToNullOrEmpty(int[][] data) {
		int cnt = 0;

		for (int i = 0; i < data.length; i++) {
			if (data[i] == null || data[i].length == 0) {
				cnt++;
			}
		}

		return cnt;
	}

	public static int[][] getArrayCopyWithoutNullEmptyRows(int[][] data) {
		int size = data.length - getNumberRowsSetToNullOrEmpty(data);

		int[][] answer = new int[size][];
		for (int i = 0, k = 0; i < data.length; i++) {
			if (data[i] != null && data[i].length != 0) {
				answer[k++] = makeArrayCopy(data[i]);
			}
		}

		return answer;
	}
}