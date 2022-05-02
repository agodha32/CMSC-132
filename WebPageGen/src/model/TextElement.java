package model;

/**
 * 
 * Represents text that can appear in an HTML document
 * 
 * @author godha
 *
 */

public class TextElement implements Element {

	private String text;
	
	/**
	 * 
	 * @param text
	 * 
	 */

	public TextElement (String text) {
		
		this.text = text; //adding the text from the parameter
		
	}
	
	/**
	 * 
	 * Returns a string that represents the HTML associated with the element. 
	 * The string is indented based on the parameter value.
	 * 
	 * @param indentation
	 * 
	 * @return HTML associated with the element.
	 * 
	 */
	
	public String genHTML(int indentation) {
		
		String stringToBeReturned = ""; // create an empty string	
		
		for(int x = indentation; x > 0; x--) {
			
			stringToBeReturned += " "; // adding the number of spaces in the indent
			
		}
		
		return stringToBeReturned + this.text; // adding the text
				
	}
	
}
