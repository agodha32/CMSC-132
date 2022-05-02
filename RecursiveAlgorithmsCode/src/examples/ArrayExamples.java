package examples;

import java.util.Arrays;

public class ArrayExamples {

	public static boolean findElement(int[] array, int target) {
		return findElementAuxiliary(array, 0, target);
	}

	public static boolean findElementAuxiliary(int[] array, int index, int target) {
		if (index > array.length - 1) { /* Empty array segment */
			return false;
		} else if (array[index] == target) {
			return true;
		} else {
			return findElementAuxiliary(array, index + 1, target);
		}
	}

	public static int instancesOfElement(int[] array, int element) {
		return instancesOfElementAuxiliary(array, 0, element);
	}

	public static int instancesOfElementAuxiliary(int[] array, int index, int element) {
		if (index > array.length - 1) { /* Empty array segment */
			return 0;
		} else if (array[index] == element) {
			return 1 + instancesOfElementAuxiliary(array, index + 1, element);
		} else {
			return instancesOfElementAuxiliary(array, index + 1, element);
		}
	}

	/* In previous examples you could have used a new array without the first */
	/* element in the recursive call, but not in the following */
	public static void setTo(int[] array, int target, int newValue) {
		setToAuxiliary(array, target, newValue, 0);
	}

	public static void setToAuxiliary(int[] array, int target, int newValue, int index) {
		if (index > array.length - 1) { /* Empty array segment */
			return;
		} else if (array[index] == target) {
			array[index] = newValue;
			setToAuxiliary(array, target, newValue, index + 1);
		} else {
			setToAuxiliary(array, target, newValue, index + 1);
		}
	}

	public static void main(String[] args) {
		int[] data = { 110, 20, 297, 349, 400, 20, 80, 20, 20 };
		int[] dataTwo = new int[0];

		System.out.println(findElement(data, 349));
		System.out.println(findElement(data, 200));
		System.out.println(findElement(dataTwo, 225));

		System.out.println("================================");
		System.out.println(instancesOfElement(data, 20));
		System.out.println(instancesOfElement(data, 777));
		System.out.println(instancesOfElement(dataTwo, 20));

		System.out.println("================================");
		setTo(data, 20, -1);
		System.out.println(Arrays.toString(data));
	}
}