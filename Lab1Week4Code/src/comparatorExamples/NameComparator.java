package comparatorExamples;

import java.util.Comparator;

public class NameComparator implements Comparator<Student> {
	/* The Comparator interface defines a compare method */
	
	public int compare(Student a, Student b) {
		/* Why we need to use the getName() method? */
		/* How would you sort by decreasing alphabetical order */
		return (a.getName().compareTo(b.getName()));
	}
}
