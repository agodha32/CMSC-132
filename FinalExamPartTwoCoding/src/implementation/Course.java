package implementation;

import java.util.*;

public class Course {
	protected class Node {
		public Section section;
		public Node next;

		protected Node(Section section) {
			this.section = section;
			next = null;
		}
	}

	protected Node head;

	public Course() {
		head = null;
	}

	public Course addSection(int sectionNumber, String taName) {
		Section val;
		boolean bool = false;
		if(taName != null) {
			val = new HonorSection(sectionNumber, taName);
		} else {
			val = new Section(sectionNumber);
		}
		
		Node as = new Node(val);
		
		if(head != null) {
			
if(head.section.getSectionNumber() == sectionNumber) {
				
				bool = true;
			
			}
			
			Node toCheck = head;
		
			while(toCheck.next != null) {
			
				toCheck = toCheck.next;
			
				if(toCheck.section.getSectionNumber() == sectionNumber) {
				
					bool = true;
					break;
				
				}
			
			}
		
			if(bool == false) {
			
				toCheck.next = as;
			
			}
		
		
			
		} else {
			
			head = as;
		}	

			return this;
	
	}

	public Course addStudent(int sectionNumber, String student) {

		boolean f = false;

		boolean bool = false;
		Node number = null;
		Integer inte = 50000000;
		Node valu = head;

		while (valu != null) {
			if (sectionNumber == 0 && valu.section.getEnrollment() < inte) {
				inte = valu.section.getEnrollment();
				number = valu;
			} else if (valu.section.getSectionNumber() == sectionNumber) {
				bool = true;
				valu.section.add(student);
				break;
			}
			valu = valu.next;

		}

		if (sectionNumber == 0) {
			number.section.add(student);
		} else if (bool == false && sectionNumber != 0) {
			throw new IllegalArgumentException("Error");
		}
		return this;
	}

	public int getEnrollmentPerSection(TreeMap<Integer, Integer> answer) {

		int stud = head.section.getEnrollment();

		Node Nelson = head.next;
		answer.clear();
		while (Nelson.next != null) {
			Nelson = Nelson.next;
			int value = Nelson.section.getEnrollment();
			int key = Nelson.section.getSectionNumber();
			stud = stud + value;
			answer.put(key, value);

		}
		int val = Nelson.section.getSectionNumber();
		int value = Nelson.section.getEnrollment();
		stud = stud + value;
		answer.put(val, value);

		return stud;
	}

	public ArrayList<String> getTAsHonorsSections() {
		List<String> list = new ArrayList<String>();
		Node value = head;

		while (value != null) {

			if (value.section instanceof HonorSection) {
				HonorSection val = (HonorSection) value.section;
				if (val.getTAName() != null) {
					list.add(val.getTAName());
				}
			}
			value = value.next;
		}
		return (ArrayList<String>) list;

	}

	public Course removeSection(int sectionNumber) {
		Node before = head;
		Node valu = head.next;

		if (!(head.section.getSectionNumber() == sectionNumber)) {

			while (!(before == null) && !(valu != null)) {

				if ((valu.section.getSectionNumber() == sectionNumber)) {
 

					if (!(valu.next == null)) {

						HashSet<String> hash = (HashSet<String>) valu.section.getStudents(false);
						before.next = valu.next;
						valu = valu.next;

						ArrayList<String> arr = new ArrayList<String>(hash);

						for (int val = 0; val < hash.size(); val++) {

							valu.section.add(arr.get(val));
						}
					} else {
						valu = null;
						before.next = null;
					}
				}
				if (valu == null) {
					break;
				} else {
					valu = valu.next;
				}
			}
		} else {
			HashSet<String> hash = (HashSet<String>) head.section.getStudents(false);
			head = head.next;

			ArrayList<String> list = new ArrayList<String>(hash);

			for (int val = 0; val < hash.size(); val++) {

				valu.section.add(list.get(val));

			}
		}
		return this;
	}

	/* Provided: do not modify */
	public String toString() {
		return toString(head);
	}

	/* Provided: do not modify */
	private String toString(Node headAux) {
		if (headAux != null) {
			return headAux.section + "\n" + toString(headAux.next);
		}
		return "";
	}
}