package onlineTest;

import java.io.Serializable;

public class FillInTheBlank extends ExamQuestion implements Serializable  {
	
	private static final long serialVersionUID = 1L;

	public FillInTheBlank(int examId, int questionNumber, String text, double points,
			String[] answer) {

		super(examId, questionNumber, text, points, answer, null, 2);
		
	}

}
