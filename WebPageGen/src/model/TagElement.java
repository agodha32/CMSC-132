package model;

/**
 * 
 * Represents an HTML tag element (<<p>, <ul>, etc.). Each tag has an id 
 * (ids start at 1). By default the start tag will have an id 
 * (e.g., <<p id="a1"></p>) when the HTML for the tag is generated. This can be 
 * disabled by using enableId.
 * 
 * @author UMCP
 *
 */

public class TagElement implements Element {
	
	private String tagName, attributes;
	private boolean endTag;
	private Element content;
	private int uniqueId;
	public static int numOfTagElement = 0;
	private static boolean idOn;
	
	/**
	 * 
	 * Initializes a tag element. We can have tag elements with only a start tag. 
	 * Each time a new tag element is created it is assigned a unique id (starting at 1).
	 * 
	 * @param tagName
	 * @param attributes
	 * @param endTag
	 * @param content
	 * 
	 */
	
	public TagElement (String tagName, String attributes, boolean endTag, Element content) {
		
		this.attributes = attributes;
		this.tagName = tagName;
		this.content = content;
		this.endTag = endTag;
		numOfTagElement++;
		this.uniqueId = numOfTagElement;
				
	}
	
	/**
	 * 
	 * @return unique id
	 * 
	 */
	
	public int getId() {
		
		return this.uniqueId;
		
	}
	
	/**
	 * 
	 * @return tagname followed by the unique id
	 * 
	 */
	
	public String getStringId() {
		
		return this.tagName + this.uniqueId;
	
	}
	
	/**
	 * 
	 * Returns the start tag. It will not include the id if inclusion has been disabled.
	 * 
	 * @return string representing the start tag including attributes (if any).
	 * 
	 */
	
	public String getStartTag() {
		
		String startTag = "";
		
		if(idOn == false) {
		
			startTag = "<" + this.tagName + this.attributes + ">";
		
		} else if(idOn == true) {
			
			startTag = "<" + this.tagName + "id=\"" + this.getStringId() + "\""
			+ this.attributes + ">";
		
		}		
	
		return startTag;
		
	}
	
	/**
	 * 
	 * @return end tag or empty string (for tags with only start tag).
	 * 
	 */
	
	public String getEndTag() {
		
		if(this.endTag == true) {
		
			String toBeReturned = "";
			return toBeReturned + "</" + this.tagName + ">";
			
		} else {
			
			return "";
			
		}
		
	}
	
	/**
	 * 
	 * Updates attributes field.
	 * 
	 * @param attributes
	 * 
	 */
	
	public void setAttributes(String attributes) {
		
		this.attributes = attributes;
		
	}
	
	/**
	 * 
	 * Allow us to start assigning ids at 1 again.
	 * 
	 */
	
	public static void resetIds() {
		
		numOfTagElement = 0;
		
	}
	
	/**
	 * 
	 * @param choice
	 * 
	 */
	
	public static void enableId(boolean choice) {
		
		if(choice == true) {
			
			idOn = true;
			
		} else {
			
			idOn = false;
			
		}
		
	}
	
	
	
	
	public String genHTML(int indentation) {
		
		String stringToBeReturned = ""; // create an empty string	
		
		for(int x = indentation; x > 0; x--) {
			
			stringToBeReturned += " "; // adding the number of spaces in the indent
			
		}
		
		if(this.content != null & this.endTag == true) {
		
			stringToBeReturned = stringToBeReturned + this.getStartTag() + 
				this.content.genHTML(0) + this.getEndTag();
		
		} else if(this.content == null & this.endTag == true) {
			
			stringToBeReturned = stringToBeReturned + this.getStartTag() + this.getEndTag();
			
		} else if(this.content == null & this.endTag != true) {
			
			stringToBeReturned = stringToBeReturned + this.getStartTag();
			
		} else if(this.content != null & this.endTag != true) {
			
			stringToBeReturned = stringToBeReturned + this.getStartTag() + 
					this.content.genHTML(0);
			
		}
		
		return stringToBeReturned;
		
	}

}
