package onlineTest;

import java.io.Serializable;
import java.util.ArrayList;

public class Student implements Serializable  {
	
	private static final long serialVersionUID = 1L;
	
	String name;
	int examId;
	int questionNumber;
	boolean answer1;
	String[] answer;
	
	public Student(String name,	int examId,	int questionNumber,	Boolean answer1,
	String[] answer) {
		
		this.name = name;
		this.examId = examId;
		this.questionNumber = questionNumber;
		this.answer1 = answer1;
		this.answer = answer;
		
	}
	
	public static ArrayList<Student> answerAddQuestions(ArrayList<Student> bank, Student name) {
		
		bank.add(name);
		
		return bank;
	
	}

}
