package examples;

import junit.framework.TestCase;

public class TestsStringRecMethods extends TestCase {

	public void testPrint() {
		StringRecursiveMethods.printString("a");
		System.out.println();
		StringRecursiveMethods.printString2("aba");

		/* No assertion */
	}

	public void testFind() {
		boolean result = StringRecursiveMethods.find("abaFc", 'F');

		assertTrue(result);
	}

	public void testFind2() {
		boolean result = StringRecursiveMethods.find("abaFc", 'G');

		assertFalse(result);
	}

	public void testCount() {
		int result = StringRecursiveMethods.countChar("abaaac", 'a');

		assertTrue(result == 4);
	}

	public void testRemoveChar() {
		String result = StringRecursiveMethods.removeChar("abaaac", 'a');

		assertTrue(result.equals("bc"));
	}

	public void testReverse() {
		String result = StringRecursiveMethods.reverse("abc");

		assertTrue(result.equals("cba"));
	}
}