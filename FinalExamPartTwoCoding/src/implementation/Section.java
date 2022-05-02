package implementation;

import java.util.*;

public class Section implements Comparable<Section>, Cloneable {
	private int sectionNumber;
	private HashSet<String> students;

	public Section(int sectionNumber) {

		this.sectionNumber = sectionNumber;
		this.students = new HashSet<String> ();
	
	}

	public Section add(String newStudent) {

		this.students.add(newStudent);
		return this;
	
	}

	public int getSectionNumber() {

		return this.sectionNumber;
	
	}

	public int getEnrollment() {

		return this.students.size();
	
	}

	public Set<String> getStudents(boolean sorted) {

		if(sorted == true) {
			
			TreeSet<String> toReturn = new TreeSet<String>();
			
			for(String student: this.students) {
				
				toReturn.add(student);
				
			}
			
			return toReturn;
			
		} else {
			
			return new HashSet<String>(this.students);
			
		}
	
	}

	@Override
	public boolean equals(Object obj) {

		if(obj == this) {
			
			return true;
			
		} else if(!(obj instanceof Section)) {
			
			return false;
			
		}
		
		Section section = (Section) obj;
	
		return (section.getSectionNumber() == this.getSectionNumber()) ?  true : false;
		
	}

	public int hashCode() {

		int size = this.getEnrollment();
		
		for(String student : this.students) {
			
			size *= student.indexOf(0);
			
		}
		
		return size;
	
	}

	public int compareTo(Section section) {

		int x = this.getSectionNumber();
		int y = section.getSectionNumber();
		
		if(x == y) {
			
			return 0;
			
		} else if(x > y) {
			
			return 1;
			
		} else {
			
			return -1;
			
		}
		
	}

	@Override
	public Section clone() {

		return this.clone();

	}

	/* Provided: do not modify */
	public String toString() {
		return "Section Number: " + sectionNumber + "-" + getStudents(true);
	}
}
