package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Comparator;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import listClasses.BasicLinkedList;
import listClasses.SortedLinkedList;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)

/**
 * 
 * You need student tests if you are looking for help during office hours about
 * bugs in your code.
 * 
 * @author UMCP CS Department
 *
 */
public class StudentTests {

	@Test
	public void testBasicConstructor() {
		
		BasicLinkedList<Integer> basicList = new BasicLinkedList<Integer>();
		
		
		Assert.assertNull(basicList.getLast());
		Assert.assertNull(basicList.getFirst());
		assertTrue(basicList.getSize() == 0);
		
	}
	
	@Test
	public void testAddtoFrontandBack() {
		
		BasicLinkedList<Integer> basicList = new BasicLinkedList<Integer>();

		basicList.addToEnd(1);
		basicList.addToEnd(2);
		basicList.addToEnd(3);
		basicList.addToEnd(4);
		
		assertTrue(basicList.getFirst() == 1);
		assertTrue(basicList.getLast() == 4);
		assertTrue(basicList.getSize() == 4);
		
		basicList.addToFront(0);
		
		assertTrue(basicList.getFirst() == 0);
		
		basicList.addToEnd(5);
		assertTrue(basicList.getLast() == 5);
		
		assertTrue(basicList.getSize() == 6);

	}

	
	@Test
	public void testRetrieveFirstandLastElements () {
		
		BasicLinkedList<Integer> basicList = new BasicLinkedList<Integer>();
		basicList.addToEnd(1);
		basicList.addToEnd(2);
		basicList.addToEnd(3);
		basicList.addToEnd(4);
		basicList.addToEnd(5);
		
		basicList.retrieveFirstElement();
		assertTrue(basicList.getFirst() == 2);

		basicList.retrieveLastElement();
		assertTrue(basicList.getLast() == 4);
		
	}
	
	
	@Test
	public void testRemoveandIterator() {
		
		BasicLinkedList<String> basicList = new BasicLinkedList<String>();
		
		basicList.addToEnd("Red");
		basicList.addToEnd("Green");
		basicList.addToEnd("Blue");
		basicList.addToEnd("Violet");
		basicList.addToEnd("Red");
		basicList.addToEnd("Orange");
		basicList.addToEnd("Red");
		assertTrue(basicList.getSize() == 7);
		
		System.out.println("Before Remove");

		for(String x : basicList) {
			
			System.out.println(x);

		}
		
		System.out.println();
		System.out.println();
	
		basicList.remove("Indigo", String.CASE_INSENSITIVE_ORDER);
		
		basicList.remove("Blue", String.CASE_INSENSITIVE_ORDER);
		
		//assertTrue(basicList.getSize() == 6);
		
		System.out.println("After Remove");

		for(String x : basicList) {
			
			System.out.println(x);

		}
		
		System.out.println();
		System.out.println();
		
		
		basicList.remove("Red", String.CASE_INSENSITIVE_ORDER);
		
		System.out.println("After 2nd Remove");

		for(String x : basicList) {
			
			System.out.println(x);

		}
		
		assertTrue(basicList.getSize() == 3);
		
		for(int x = 0; x < 50; x++) {
			System.out.println();
		}
		
	}
	
	
	@Test
	public void testReverse() {
		
		BasicLinkedList<Integer> basicList = new BasicLinkedList<Integer>();
		
		basicList.addToEnd(0);
		basicList.addToEnd(1);
		basicList.addToEnd(2);
		basicList.addToEnd(3);
		basicList.addToEnd(4);
		basicList.addToEnd(5);
		
		for(Integer y : basicList) {
			System.out.println(y);
		}
		
		System.out.println();
		System.out.println();
		System.out.println("After Reverse: ");

		BasicLinkedList<Integer> z = basicList.getReverseList();
		
		for(Integer check : z) {
		
			System.out.println(check);		
		
		}
		
		System.out.println();
		System.out.println();
		System.out.println("After ArrayList Reverse: ");

		ArrayList<Integer> y = basicList.getReverseArrayList();
		
		for(Integer x : y) {
			
			System.out.println(x);
		
		}
		
	}
	
	@Test
	public void SortedTest() {
		
		SortedLinkedList<String> sortedList = new SortedLinkedList<String>(String.CASE_INSENSITIVE_ORDER);
	
		sortedList.add("Aryan").add("aryan").add("Arnav").add("Vikas");
		
		SortedLinkedList<String> srtedList = new SortedLinkedList<String>(String.CASE_INSENSITIVE_ORDER);
		srtedList.add("One");
		srtedList.add("Two");
		
		for(String x : srtedList) {
			
			System.out.println(x);
			
		}
		
		//assertTrue(sortedList.getFirst().equals("Arnav"));
		//assertTrue(sortedList.getLast().equals("Vikas"));
				
		System.out.println();
		System.out.println();

	}

}
