package tests;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import implementation.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class StudentTests {
    @Test
    public void testRoom() {

    	Room x = new Room(4);
    	
    	assertTrue(x.getCapacity() == 4);
    	
    	assertTrue(x.addOccupant("Tatia"));
    	assertTrue(x.addOccupant("Parker"));
    	assertTrue(x.addOccupant("Larissa"));
    	assertTrue(x.addOccupant("Dalya"));
    	
    	assertFalse(x.addOccupant("A"));
    	assertFalse(x.addOccupant("Aryan"));
    	
    	x.getOccupants().remove(0);
    	
    	assertTrue(x.getNumberOfOccupants() == 4);
    	
    	Room y = new Room (4);
    	
    	y.addOccupant("Larissa");
    	y.addOccupant("Dalya");
    	y.addOccupant("Parker");
    	y.addOccupant("Tatia");

    	assertTrue(x.equals(y));
  
    	Room z = new Room (4);
    	
    	z.addOccupant("Larissa");
    	z.addOccupant("Dalya");
    	z.addOccupant("Parker");

    	assertFalse(x.equals(z));
    	
    }
    
    @Test
    public void testBuilding() {
    	
		Building x = new Building("Infinite Loop Blvd", 2, 4, 6);
		
		assertFalse(x.addOccupant("a", -1, 0));
		assertTrue(x.addOccupant("Aryan", 0, 0));
    	
    }
    
    @Test
    public void testHotel() {
    	
    	
    	
    }
    
}