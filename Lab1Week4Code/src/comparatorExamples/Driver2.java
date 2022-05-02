package comparatorExamples;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Driver2 {
	public static void printRoster(String tag, Collection<Student> collection) {
		System.out.println(tag);
		for (Student s : collection) {
			System.out.println(s);
		}
	}

	public static void main(String[] args) {
		/* We don't need to add Student to the right side */
		ArrayList<Student> roster = new ArrayList<>();

		roster.add(new Student("Mary", 10, 15));
		roster.add(new Student("Bob", 1, 18));
		roster.add(new Student("Laura", 17, 12));
		roster.add(new Student("Albert", 34, 6));

		/* Collection is sorted by id */
		Collections.sort(roster);
		printRoster("***** Sorted by id using compareTo() *****", roster);

		/* Collection is sorted by name */
		Collections.sort(roster, new NameComparator());
		printRoster("\n***** Sorted by name using comparator *****", roster);

		/* Collection is sorted by credits */
		Collections.sort(roster, new CreditsComparator());
		printRoster("\n***** Sorted by credits using comparator *****", roster);
	}
}
