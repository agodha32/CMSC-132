package model;

import java.util.ArrayList;

public class ParagraphElement extends TagElement {
	
	private ArrayList<Element> text;
	
	
	public ParagraphElement(String attributes) {
		
		super("p ", ((attributes == null) ? "" : attributes), true, null);
		this.text = new ArrayList<Element>() ;
		
	}
	
	public void addItem(Element item) {
		
		this.text.add(item);
		
	}
	
	public String genHTML(int indentation) {
		
		String stringToBeReturned = ""; // create an empty string
		String spaces = "";
		
		for(int x = indentation; x >= 0; x--) {
			
			spaces += " "; // adding the number of spaces in the indent
			
		}
		
		stringToBeReturned = spaces + this.getStartTag() + "\n" + spaces;
		
		for(Element x : this.text) {
			
			stringToBeReturned+= spaces;
			stringToBeReturned += (x.genHTML(3) + "\n");
			
		}
		
		stringToBeReturned = stringToBeReturned + "\n" + spaces + this.getEndTag();
		
		return stringToBeReturned;
		
	}
	
}
