package tests;

import static org.junit.Assert.*;

import java.util.Comparator;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import implementation.BinarySearchTree;
import implementation.KeyValuePair;
import implementation.TreeIsEmptyException;
import implementation.TreeIsFullException;

/* The following directive executes tests in sorted order */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class StudentTests {
	
	/* Remove the following test and add your tests */
	@Test
	public void testMaxMinValue() {

		Comparator<String> comparator = String.CASE_INSENSITIVE_ORDER;

		BinarySearchTree<String, Integer> tree = new BinarySearchTree<String, Integer>
		(comparator, 10);
		
		try {
			KeyValuePair<String, Integer> maximum = tree.getMaximumKeyValue();
			KeyValuePair<String, Integer> minimum = tree.getMinimumKeyValue();
			System.out.println("Maximum: " + maximum.getKey() + "/" + maximum.getValue());
			System.out.println("Minimum: " + minimum.getKey() + "/" + minimum.getValue());
		} catch (TreeIsEmptyException e) {
			System.out.println("empty tree");
		}
		
		try {
		
			tree.add("Aryan", 1);
			tree.add("Arnav", 2);
			tree.add("Ritus", 3);
			tree.add("Vikas", 4);
			tree.add("Kimmy", 5);
			tree.add("Peter", 6);
			tree.add("AArpp", 7);
			tree.add("ZZARP", 8);
		
		} catch (TreeIsFullException e) {
			
			System.out.println("full tree");
		
		}
		
		try {
			KeyValuePair<String, Integer> maximum = tree.getMaximumKeyValue();
			KeyValuePair<String, Integer> minimum = tree.getMinimumKeyValue();
			System.out.println("Maximum: " + maximum.getKey() + "/" + maximum.getValue());
			System.out.println("Minimum: " + minimum.getKey() + "/" + minimum.getValue());
		} catch (TreeIsEmptyException e) {
			System.out.println("empty tree");
		}
		
	}
	
	@Test
	public void testFind() {

		Comparator<String> comparator = String.CASE_INSENSITIVE_ORDER;

		BinarySearchTree<String, Integer> tree = new BinarySearchTree<String, Integer>
		(comparator, 10);
		
		KeyValuePair<String, Integer> found = tree.find("Terry");

		String print = (found == null ? "NOT FOUND" : found.getKey() + "/" + found.getValue());
		
		
		System.out.println(print);
		
		try {
		
			tree.add("Aryan", 1);
			tree.add("Arnav", 2);
			tree.add("Ritus", 3);
			tree.add("Vikas", 4);
			tree.add("Kimmy", 5);
			tree.add("Peter", 6);
			tree.add("Terry", 7);
			tree.add("ZZARP", 8);
		
		} catch (TreeIsFullException e) {
			
			System.out.println("full tree");
		
		}
		
		found = tree.find("Terry");
		System.out.println(found == null ? "NOT FOUND" : found.getKey() + "/" + found.getValue());
		
		found = tree.find("Aryan");
		System.out.println(found == null ? "NOT FOUND" : found.getKey() + "/" + found.getValue());
		
		found = tree.find("AAryan");
		System.out.println(found == null ? "NOT FOUND" : found.getKey() + "/" + found.getValue());
		
		found = tree.find("Vikas");
		System.out.println(found == null ? "NOT FOUND" : found.getKey() + "/" + found.getValue());
		
	}
	
	@Test
	public void testSubTree() {

		Comparator<String> comparator = String.CASE_INSENSITIVE_ORDER;

		BinarySearchTree<String, Integer> tree = new BinarySearchTree<String, Integer>
		(comparator, 10);
		
		try {
			
			tree.add("Aryan", 1);
			tree.add("Arnav", 2);
			tree.add("Ritus", 3);
			tree.add("Vikas", 4);
			tree.add("Kimmy", 5);
			tree.add("Peter", 6);
			tree.add("Terry", 7);
			tree.add("ZZARP", 8);
		
		} catch (TreeIsFullException e) {
			
			System.out.println("full tree");
		
		}
		

		BinarySearchTree<String, Integer> subTree = tree.subTree("Aryan", "Terry");
		
		System.out.println(subTree);
		
		BinarySearchTree<String, Integer> subTree1 = tree.subTree("Ritu", "Aryan");
		
		System.out.println(subTree1);
		
		BinarySearchTree<String, Integer> subTree2 = tree.subTree("Ritus", "Ritus");
		
		System.out.println(subTree2);
		
		BinarySearchTree<String, Integer> subTree3 = tree.subTree("Ritu", "Jack");
		
		System.out.println(subTree3);
		
	}
		
}
