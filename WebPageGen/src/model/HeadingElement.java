package model;

/**
 * 
 * Represents a heading. We can have levels 1 thru 6 (e.g., <h1>, <h2>, etc.)
 * 
 * @author UMCP
 *
 */
public class HeadingElement extends TagElement {

	/**
	 * 
	 * Includes the content as part of the heading. Level can assume values 
	 * from 1 up to including 6.
	 * 
	 * @param content
	 * @param level
	 * @param attributes
	 * 
	 */
	
	public HeadingElement(Element content, int level, String attributes) {
	
		super("h" + level, (attributes == null)? "" : attributes, true, content);

	}

}
