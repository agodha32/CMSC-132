package model;

import java.util.ArrayList;

public class WebPage {

	private ArrayList<Element> webPage;
	private String title;
	
	public WebPage(String title) {
		
		this.title = title;
		this.webPage = new ArrayList<Element> ();
		
	}
	
	public int addElement(Element element) {
		
		if(!(element instanceof TagElement)) {
			
			return -1;
			
		} else {
			
			TagElement elementPossible = (TagElement) element;
			this.webPage.add(element);
			return elementPossible.getId();
			
		}
		
	}
	
	public String getWebPageHTML(int indentation) {

		String stringToBeReturned = "";// create an empty string	
		String spaces = "";
		
		for(int x = indentation; x > 0; x--) {
			
			spaces += " "; // adding the number of spaces in the indent
			
		}
		
		stringToBeReturned = stringToBeReturned + "<!doctype html> \n<html> "
				+ "\n" + spaces + "<head> \n" + spaces +  spaces + "<meta charset=\"utf-8\"/>"
				+ "\n" + spaces + spaces + "<title>" + this.title + "</title> "
				+ "\n" + spaces + "</head> \n" + spaces + "<body>";
		
		for(Element findElement : this.webPage) {
			
			stringToBeReturned += "\n";
			stringToBeReturned += findElement.genHTML(indentation);
			
		}
		
		stringToBeReturned = stringToBeReturned + "\n" + spaces + "</body> \n</html>";
		
		
		return stringToBeReturned;
		
	}

	public void writeToFile(String fileName, int indentation) {
		
		this.writeToFile(fileName, indentation);
		
	}
	
	public Element findElem(int id) {
		
		Element toBeReturned = null;
		
		for(Element findingElement : this.webPage) {
			
			TagElement check = (TagElement) findingElement;
			
			if(check.getId() == id) {
				
				toBeReturned = findingElement;
				
			}
			
		}
		
		return toBeReturned;
		
	}
	
	public String stats() {
		
		double tableFullPercent = 0;
		int listCounter = 0;
		int paragraphCounter = 0;
		int tableCounter = 0;
		
		for(Element searchElement : this.webPage) {
			
			if(searchElement instanceof ListElement) {
				
				listCounter++;
				
			} else if(searchElement instanceof ParagraphElement) {
				
				paragraphCounter++;
				
			} else if(searchElement instanceof TableElement) {
				
				tableCounter++;
				TableElement check = (TableElement) searchElement;
				tableFullPercent += check.getTableUtilization();
				
			}
			
		}
		
		tableFullPercent = (tableFullPercent / tableCounter) * 100;
		
		return "List Count: " + listCounter + "\n"
				+ "Paragraph Count: " + paragraphCounter + "\n"
				+ "Table Count: " + tableCounter + "\n"
				+ "TableElement Utilization: " + tableFullPercent;
		
	}
	
	public int compareTo (WebPage webPage) {
		
		return this.compareTo(webPage);
		
	}
	
	public static void enableId(boolean choice) {
		
		
		
	}
	
}
