
public class asd {
	
	private static int num = 0;


	public static void main(String[] args) {

		uniqueIdCounter();
		System.out.println(uniqueId);
		
	}

	public int uniqueIdCounter() {
		
		int uniqueId = num++;
		num = uniqueId;
		
		return uniqueId;
		
	}
	
public static void resetIds() {
		
		num = 0;
		
	}
	
}
