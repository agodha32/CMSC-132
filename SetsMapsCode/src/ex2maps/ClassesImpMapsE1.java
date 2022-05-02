/*
 * Example showing how to use maps.
 */
package ex2maps;

import java.util.*;

public class ClassesImpMapsE1 {

	public static void main(String[] args) {
		System.out.println("************* HashMap test *************");
		test(new HashMap<>());

		System.out.println("\n\n************* TreeMap test *************");
		test(new TreeMap<>());

		System.out.println("\n\n************* LinkedHashMap test *************");
		test(new LinkedHashMap<>());
	}

	/* Notice the parameter is a Map, which is an interface */
	public static void test(Map<String, Department> map) {

		/* Adding <key,value> pairs to the map */
		map.put("Mary", new Department("Electronics", 5000));
		map.put("Peter", new Department("Music", 4500));
		Department shoeDepartment = new Department("Shoe", 6000);
		map.put("Zoe", shoeDepartment);
		map.put("Laura", shoeDepartment);

		/* Printing the contents */
		/* Cannot get a direct iterator on map (e.g., map.iterator()) */
		Set<String> nameSet = map.keySet();
		for (String name : nameSet) {
			/* Finding the department that maps to the name */
			Department dept = map.get(name);
			System.out.println(name + " " + dept);
		}

		/* Membership test */
		if (map.containsKey("Mary"))
			System.out.println("Mary found");

		if (!map.containsKey("Laura"))
			System.out.println("Laura not found");

		/* Getting all the values */
		System.out.println("All departments (NOT UNIQUE DEPARTMENTS)");
		Collection<Department> collection = map.values();
		for (Department dept : collection) {
			System.out.println(dept);
		}

		/* Another alternative to iterate accessing key and value */
		System.out.println("*Another alternative*");
		/* Using iterator over Map.Entry */
		for (Map.Entry<String, Department> elem : map.entrySet()) {
			System.out.println(elem.getKey() + " " + elem.getValue());
		}
	}
}
