package implementation;

import java.util.Collections;
import java.util.Comparator;

public class FacilityComparator implements Comparator<Facility> {
	/* Feel free to add any instance variables or methods you might need */

	boolean increasing;
	
	public FacilityComparator(boolean increasing) {

		this.increasing = increasing;
	
	}

	public int compare(Facility facility1, Facility facility2) {
	
		return increasing ? (facility1.totalUnits - facility2.totalUnits) : (facility2.totalUnits - facility1.totalUnits);
			
	}

}
