package model;

/**
 * Represents an HTML element
 * @author UMCP
 *
 */

public interface Element {
	
	/**
	 * 
	 * Returns a string that represents the HTML associated with the element.
	 * @param indentation
	 * 
	 */
	
	public String genHTML(int indentation);
	
}
