package onlineTest;

import java.io.Serializable;

public class MultipleChoice extends ExamQuestion implements Serializable  {
	
	private static final long serialVersionUID = 1L;

	public MultipleChoice(int examId, int questionNumber, String text, double points,
			String[] answer) {
	
		super(examId, questionNumber, text, points, answer, null, 1);

	}

}
