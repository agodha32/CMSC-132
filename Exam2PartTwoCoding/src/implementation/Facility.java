package implementation;

import java.util.*;

public class Facility implements Iterable<String> {
	protected String name;

	protected class StorageUnit {
		public String unitId;
		public ArrayList<String> items;
		public StorageUnit next;
		public StorageUnit thread_next;

		public StorageUnit(String unitId) {
			this.unitId = unitId;
			this.items = new ArrayList<String>();
			next = null;
		}

		public void addItem(String singleItem) {
			items.add(singleItem);
		}
	}

	protected StorageUnit head;
	protected int totalUnits;
	protected StorageUnit thread_head;

	public Facility(String name) {

		if (Support.isValid(name)) {

			this.name = name;
			totalUnits = 0;
			head = null;

		}

	}

	public Facility() {

		this.name = "NONAME";
		totalUnits = 0;
		head = null;

	}

	public Facility addItemToStorageUnit(String unitId, String item) {

		if (Support.isValid(unitId) && Support.isValid(item)) {

			StorageUnit temp = head;
			StorageUnit toAdd = new StorageUnit(unitId);

			if (head == null) {

				head = toAdd;
				head.addItem(item);
				totalUnits++;

			} else {

				for (int unitCounter = 0; unitCounter < totalUnits; unitCounter++) {

					if (temp.unitId.equals(unitId)) {

						temp.addItem(item);
						break;

					}

					if (temp.next == null) {

						temp.next = toAdd;
						temp.next.addItem(item);
						totalUnits++;
						break;

					} else {

						temp = temp.next;

					}

				}

			}

		}

		return this;

	}

	public int getTotalUnits() {

		return this.totalUnits;

	}

	public String getName() {

		return this.name;

	}

	/*
	 * You will lose credit if you use addItemToStorageUnit during the
	 * implementation of this method.
	 */
	public Facility getFacilityWithFirstUnit(String facilityName) {

		Facility toReturn = new Facility(facilityName);
		StorageUnit toAddToReturn = new StorageUnit(this.head.unitId);

		toReturn.head = toAddToReturn;
		toAddToReturn.items.addAll(this.head.items);
		toReturn.totalUnits = 1;

		return toReturn;

	}

	/*
	 * Method must be implemented using recursion. You will lose credit if you use
	 * any iteration statement (e.g., for, while, do while).
	 */
	public int getTotalItemsInFacility() {

		StorageUnit header = head;

		return calculate(header, 0);

	}

	private int calculate(StorageUnit unitName, int total) {

		if (unitName == null) {

			return total;

		}

		return total + unitName.items.size() + calculate(unitName.next, total);

	}

	/*
	 * Method must be implemented using recursion. You will lose credit if you use
	 * any iteration statement (e.g., for, while, do while).
	 */
	public ArrayList<String> getItemsInUnitSorted(String unitId) {

		StorageUnit unitToGetItems = sortFail(head, unitId);

		if (unitToGetItems == null) {

			return null;

		} else {

			ArrayList<String> toReturn = unitToGetItems.items;
			Collections.sort(toReturn);

			return toReturn;

		}

	}

	private StorageUnit sortFail(StorageUnit findUnit, String unitId) {

		if (findUnit.unitId.equals(unitId)) {

			return findUnit;

		}

		return sortFail(findUnit.next, unitId);

	}

	public void setThread(int minimumItemsInUnit) {

	}

	public Iterator<String> iterator() {

		Iterator<String> iterator = new Iterator<String>() {

			private StorageUnit unitCheck = head;
			private int counter = 0;

			public boolean hasNext() {

				return unitCheck != null;

			}

			public String next() {

				String data = unitCheck.unitId;
				unitCheck = unitCheck.next;
				counter++;

				return data;

			}

		};

		return iterator;
	}

	/* Provided: Do not modify */
	public String toStringThreadedNodes() {
		String answer = "";

		if (thread_head == null) {
			answer = "NOT THREADED";
		} else {
			StorageUnit curr = thread_head;
			while (curr != null) {
				answer += "UnitId:" + curr.unitId + ", Items: " + curr.items + "\n";

				curr = curr.thread_next;
			}
		}

		return answer;
	}

	/* Provided: Do not modify */
	public String toString() {
		String answer = "Facility name: " + name + "\n";
		answer += "Total Units: " + totalUnits + "\n";
		StorageUnit curr = head;

		while (curr != null) {
			answer += "UnitId:" + curr.unitId + ", Items: " + curr.items + "\n";

			curr = curr.next;
		}

		return answer;
	}
}
