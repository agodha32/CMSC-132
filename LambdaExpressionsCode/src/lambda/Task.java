package lambda;

public interface Task {
	public int compute(int x);
	
	public default int version() {
		return 10;
	}
}
