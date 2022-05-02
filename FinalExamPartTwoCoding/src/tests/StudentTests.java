package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeMap;

import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import implementation.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class StudentTests {
	
    @Test
    public void testSection() {

    	Section one = new Section(101);
    	assertTrue(one.getSectionNumber() == 101);
    	assertTrue(one.getEnrollment() == 0);

    	
    	Section two = new Section(-101);
    	assertTrue(two.getSectionNumber() == -101);
    	assertTrue(two.getEnrollment() == 0);

    	
    	Section three = new Section(0);
    	assertTrue(three.getSectionNumber() == 0);
    	assertTrue(three.getEnrollment() == 0);
    
    }
    
    @Test
    public void testSectionAdd() {
    	
    	Section one = new Section(101);
    	
    	one.add("Arnav");
    	assertTrue(one.getEnrollment() == 1);

    }
    
    @Test
    public void testSectionSorted() {
    	
    	Section one = new Section(101);
    	
    	one.add("I");
    	one.add("A");
    	one.add("F");
    	one.add("G");
    	one.add("H");
    	one.add("B");
    	one.add("J");
    	one.add("E");
    	one.add("C");
    	one.add("D");
    	    	
    	Set<String> unsorted = one.getStudents(false);
    	Set<String> sorted = one.getStudents(true);
    	
    	assertTrue(unsorted.toString().equals(sorted.toString()));
    	
    }
    
    @Test
    public void testcourse() {
    	
    	Course testing = new Course();
    	
    	testing.addSection(10, null);
    	testing.addSection(50, "Mes");
    	testing.addSection(10, null);
    	testing.addSection(34, "Jack");
    	testing.addSection(10, "Jack");
    	testing.addSection(34, null);
    	
    	String toprint = testing.toString();
    	System.out.println(toprint);
    	
    	int sectionNumber = 10;
    	testing.addStudent(sectionNumber, "Marcos");
    	testing.addStudent(sectionNumber, "Rose");
    	testing.addStudent(sectionNumber, "Tom");
		sectionNumber = 50;
		testing.addStudent(sectionNumber, "Kelly");
		System.out.println(testing);

		sectionNumber = 0;
		testing.addStudent(sectionNumber, "Sabrina");
		testing.addStudent(sectionNumber, "Me");
		
		System.out.println(testing);

		try {
			
			testing.addStudent(-1, "Sabrina");
			
		} catch(IllegalArgumentException e) {
			
			System.out.println("Section Number not found");
		}
	
		TreeMap<Integer, Integer> answer = new TreeMap<Integer, Integer>();
		
		answer.put(5, 5);
		answer.put(6, 2);
		answer.put(1, 3);
		answer.put(7, 4);
		answer.put(8, 6);
		
		System.out.println(answer);
		System.out.println();
		
		testing.getEnrollmentPerSection(answer);
		
		System.out.println(answer);
		
		System.out.println(testing.getTAsHonorsSections());
		
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println(testing);
		
		testing.removeSection(50);
		
		System.out.println(testing);
		
	
		testing.removeSection(34);
		System.out.println(testing);
		
    }
    
    @Test
    public void testBST() {
    	
    	BinarySearchTree<Integer, String> tree = new BinarySearchTree<>();
		tree.add(50, "Five");
		tree.add(30, "Three");
		tree.add(40, "Four");
		tree.add(10, "One");
		tree.add(20, "Two");
		tree.add(80, "Eight");
		tree.add(60, "Six");
		tree.add(70, "Seven");
		tree.add(90, "Nine");
		tree.add(100, "Ten");

		System.out.println(tree.toString());
		
		GetKeysValuesTask<Integer, String> task = new GetKeysValuesTask<>();
		tree.processNodesTwoChildren(task);
		System.out.println("Processing for Nodes Two Children: " + task.getData() + "\n");
		
		ArrayList<Integer> path = tree.getPathKeysToFind(100);
		System.out.println("Path to find: " + 100);
		System.out.println("Path: " + path + "\n");
		path.clear();

		path = tree.getPathKeysToFind(10);
		System.out.println("Path to find: " + 10);
		System.out.println("Path: " + path + "\n");
		path.clear();
		
		path = tree.getPathKeysToFind(77);
		System.out.println("Path to find: " + 55);
		System.out.println("Path: " + path + "\n");
		
		Set<Integer> nodesKeysLevel = tree.getKeysNodesLevel(1);
		System.out.println("Keys of Nodes at level: " + 1);
		System.out.println("Keys: " + nodesKeysLevel);
		nodesKeysLevel.clear();
		
		nodesKeysLevel = tree.getKeysNodesLevel(2);
		System.out.println("Keys of Nodes at level: " + 2);
		System.out.println("Keys: " + nodesKeysLevel);
		nodesKeysLevel.clear();

		nodesKeysLevel = tree.getKeysNodesLevel(3);
		System.out.println("Keys of Nodes at level: " + 3);
		System.out.println("Keys: " + nodesKeysLevel);
		nodesKeysLevel.clear();

		nodesKeysLevel = tree.getKeysNodesLevel(4);
		System.out.println("Keys of Nodes at level: " + 4);
		System.out.println("Keys: " + nodesKeysLevel);
		nodesKeysLevel.clear();

		nodesKeysLevel = tree.getKeysNodesLevel(5);
		System.out.println("Keys of Nodes at level: " + 5);
		System.out.println("Keys: " + nodesKeysLevel);
		
    }
    
}