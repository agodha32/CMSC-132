package onlineTest;

import java.io.Serializable;

public class TrueAndFalse extends ExamQuestion implements Serializable  {

	private static final long serialVersionUID = 1L;
		
	public TrueAndFalse(int examId, int questionNumber, String text, double points, 
			boolean answer) {
		
		super(examId, questionNumber, text, points, null, answer, 0);

	}
	


}
