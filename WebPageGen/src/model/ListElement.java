package model;

import java.util.ArrayList;

public class ListElement extends TagElement {

	private ArrayList<Element> text;
	
	public ListElement (boolean ordered, String attributes) {
				
		super((ordered ? "ol " : "ul "), (attributes == null)? "" : attributes, true, null);
		this.text = new ArrayList <Element> ();

	}

	public void addItem(Element item) {
		
		this.text.add(item);
		
	}
	
	public String genHTML(int indentation) {
		
		String stringToBeReturned = ""; // create an empty string
		String spaces = "";
		
		for(int x = indentation; x > 0; x--) {
			
			spaces += " "; // adding the number of spaces in the indent
			
		}
		
		stringToBeReturned = spaces + this.getStartTag() + "\n";
		
		for(Element x : this.text ) {
			
			stringToBeReturned += (spaces + "   " + "<li>\n");
			stringToBeReturned += (spaces + "   " + x.genHTML(3));
			stringToBeReturned += "\n" + spaces + "   " + "</li>\n";
			
		}
		
		stringToBeReturned = stringToBeReturned + spaces + this.getEndTag();
		
		return stringToBeReturned;
		
	}
}
