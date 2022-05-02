
package examples;

import static org.junit.Assert.*;
import org.junit.Test;

import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class JUnitExample1Fundamentals {

	@Test
	public void test1Maximum() {
		int expectedResults = 20;
		assertEquals(expectedResults, AuxMath.maximum(20, 10));
	}

	@Test
	public void test2Maximum() {
		int expectedResults = 20;
		assertEquals(expectedResults, AuxMath.maximum(10, 20));
	}

	@Test
	public void test3Minimum() {
		int expectedResults = 5;
		assertEquals(expectedResults, AuxMath.minimum(5, 30));
	}

	@Test
	public void test4Minimum() {
		int expectedResults = 5;
		assertEquals(expectedResults, AuxMath.minimum(30, 5));
	}
}
