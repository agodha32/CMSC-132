package tests;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import implementation.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class StudentTests {
   
	@Test
    public void testIsValid() {

    	String param = "";
    	String paramTwo = "Jack";
    	
    	try {
    		
    		assertFalse(Support.isValid(param));
    	
    	} catch (Exception IllegalArgumentException) {
    		
    		assertTrue(param.isBlank());
    		
    	}
    	
    	assertTrue(Support.isValid(paramTwo));
    	
    	try {
    		
    		assertFalse(Support.isValid(null)); 
	
    	} catch (Exception IllegalArgumentException) {
    		
    		assertTrue(param.isBlank());
    		
    	}
    	
    }
	
	@Test
	public void testFacilityConstructor() {
		
		Facility test = new Facility("Testing");
		
		assertTrue(test.getName() == "Testing");
		assertTrue(test.getTotalUnits() == 0);
		
	}
    
	@Test
	public void testFacilityConstructorNONAME() {
		
		Facility test = new Facility();
		
		assertTrue(test.getName() == "NONAME");
		assertTrue(test.getTotalUnits() == 0);
		
	}

	@Test
	public void test() {
		
	}
	
}