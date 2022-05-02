package model;

public class TableElement extends TagElement {
	
	private Element [][] table;
	
	public TableElement(int row, int col, String attributes) {
		
		super("table", (attributes == null) ? "" : attributes, true, null);
		
		table = new Element [row][col];
		
	}

	public void addItem(int rowIndex, int colIndex, Element item) {
		
		table[rowIndex][colIndex] = item;
		
	}
	
	public double getTableUtilization() {
		
		double cellCounter = 0;
		double cellFilledCounter = 0;
		
		for(int rowCounter = 0; rowCounter < table.length; rowCounter++) {
			
			for(int colCounter = 0; colCounter < table[rowCounter].length; colCounter++) {
				
				cellCounter++;
				
				if(table[rowCounter][colCounter] != null) {
					
					cellFilledCounter++;
					
				}
				
			}
			
		}
		
		return (cellFilledCounter / cellCounter);
		
	}
	
	public String genHTML(int indentation) {
		
		String stringToBeReturned = ""; // create an empty string
		String spaces = "";
		
		for(int x = indentation; x > 0; x--) {
			
			spaces += " "; // adding the number of spaces in the indent
			
		}
		
		stringToBeReturned = spaces + this.getStartTag() + "\n";
		
		for(int rowCounter = 0; rowCounter < table.length; rowCounter++) {
			
			stringToBeReturned += (spaces + spaces + "<tr>");
			
			for(int colCounter = 0; colCounter < table[rowCounter].length; colCounter++) {
				
				if(table[rowCounter][colCounter] != null) {
				
					stringToBeReturned += "<td>";
					stringToBeReturned += table[rowCounter][colCounter].genHTML(0);
					stringToBeReturned += "</td>";
					
				} else {
					
					stringToBeReturned += "<td></td>";
					
				}
			
			}
		
			stringToBeReturned += ("</tr> \n");
			
		}
		
		stringToBeReturned += (spaces + this.getEndTag());
		
		return stringToBeReturned;
		
	}
	
}
