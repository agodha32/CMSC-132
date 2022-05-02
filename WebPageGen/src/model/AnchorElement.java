package model;


/**
 * 
 * Represents the <a> tag.
 * @author UMCP
 *
 */

public class AnchorElement extends TagElement {
	
	private String url, linkText;
	
	
	/**
	 * 
	 * Initializes the tag with the provided parameters.
	 * 
	 * @param url
	 * @param linkText
	 * @param attributes
	 * 
	 */

	public AnchorElement (String url, String linkText, String attributes) {
		
		super("a", " href="  + "\"" + url + "\"" , true, null);
		this.linkText = linkText;
		this.url = url;
		
	}
	
	/**
	 * 
	 * Returns the text used for the link.
	 * @return text
	 * 
	 */
	
	public String getLinkText() {
		
		return this.linkText;
		
	}
	
	/**
	 * 
	 *Returns the url associated with the link.
	 * @return url
	 * 
	 */
	
	public String getUrlText() {
		
		return this.url;
		
	}
	
	/**
	 * Returns a string that represents the HTML associated with the element. 
	 * The string is indented based on the parameter value.
	 * 
	 * @return HTML associated with the element.
	 * 
	 */

	@Override
	public String genHTML(int indentation) {

		String stringToBeReturned = ""; // create an empty string	
		
		for(int x = indentation; x > 0; x--) {
			
			stringToBeReturned += " "; // adding the number of spaces in the indent
			
		}
		
		stringToBeReturned = stringToBeReturned + this.getStartTag() + 
				this.linkText + this.getEndTag();
		
		return stringToBeReturned;
	
	}
	
}
