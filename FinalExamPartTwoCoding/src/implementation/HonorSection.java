package implementation;

public class HonorSection extends Section {
	private String taName;
	
	public HonorSection(int sectionNumber, String taName) {
		
		super(sectionNumber); // Do not remove this super call
		this.taName = taName;
		
	}
	
	public String getTAName() {

		return this.taName;
	
	}
	
	/* Provided: do not modify */
	public String toString() {
		return super.toString() + ", " + "TaName: " + taName;
	}
}
