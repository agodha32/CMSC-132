package onlineTest;

import java.io.Serializable;
import java.util.ArrayList;

public class ExamQuestion implements Serializable  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	int examId;
	int questionNumber;
	String text;
	double points; 
	String[] answer;
	Boolean answer1;
	int questionType;
	
	public ExamQuestion (int examId, int questionNumber, String text, double 
			points, String[] answer, Boolean answer1, int questionType) {
	
		this.examId = examId;
		this.questionNumber = questionNumber;
		this.text = text;
		this.points = points;
		this.answer1 = answer1;
		this.answer = answer;
		this.questionType = questionType;
		
	}
	
	public static ArrayList<ExamQuestion> addQuestion(ArrayList<ExamQuestion> bank, 
			ExamQuestion questionToAdd) {
		
		ExamQuestion y = null;
		if (bank.size() != 0) {
			for(ExamQuestion x : bank) {
				if(x.questionNumber == questionToAdd.questionNumber) {
					y = x;
					break;
				}
			}
			bank.remove(y);
		}
		bank.add(questionToAdd);
		return bank;
	}

}
