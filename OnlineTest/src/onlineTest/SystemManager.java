package onlineTest;

import java.io.*;
import java.util.*;

public class SystemManager implements Manager, Serializable {

	String[] letterGrades;
	double[] cutoff;
	private static final long serialVersionUID = 1L;

	Hashtable<Integer, String> exam = new Hashtable<Integer, String>();
	Hashtable<Integer, ArrayList<ExamQuestion>> questionBank = new Hashtable<Integer, ArrayList<ExamQuestion>>();
	Hashtable<String, ArrayList<Student>> roster = new Hashtable<String, ArrayList<Student>>();

	@Override
	public boolean addExam(int examId, String title) {
		int size = exam.size();
		exam.putIfAbsent(examId, title);
		if (size != exam.size()) {
			questionBank.put(examId, new ArrayList<ExamQuestion>());
		}
		return (size == exam.size()) ? false : true;
	}

	@Override
	public void addTrueFalseQuestion(int examId, int questionNumber, String text,
			double points, boolean answer) {
		TrueAndFalse questionToAdd = new TrueAndFalse(examId, questionNumber, text,
				points, answer);
		ArrayList<ExamQuestion> bank = questionBank.get(examId);
		bank = ExamQuestion.addQuestion(bank, questionToAdd);
	}

	@Override
	public void addMultipleChoiceQuestion(int examId, int questionNumber, String text, double points, String[] answer) {
		MultipleChoice questionToAdd = new MultipleChoice(examId, questionNumber, text,
				points, answer);
		ArrayList<ExamQuestion> bank = questionBank.get(examId);
		bank = ExamQuestion.addQuestion(bank, questionToAdd);
	}

	@Override
	public void addFillInTheBlanksQuestion(int examId, int questionNumber, String text, double points,
			String[] answer) {
		FillInTheBlank questionToAdd = new FillInTheBlank(examId, questionNumber, text,
				points, answer);
		ArrayList<ExamQuestion> bank = questionBank.get(examId);
		bank = ExamQuestion.addQuestion(bank, questionToAdd);

	}

	@Override
	public String getKey(int examId) {
		String answer = "";
		ArrayList<ExamQuestion> bank = questionBank.get(examId);
		if (bank == null) {
			return "Exam not found";
		}
		for (ExamQuestion question : bank) {
			answer += "Question Text: " + question.text;
			answer += "\nPoints: " + question.points + "\nCorrect Answer: ";
			if (question.questionType == 0) {
				if (question.answer1) {
					answer += "True";
				} else {
					answer += "False";
				}
			} else {
				answer += "[";
				Arrays.sort(question.answer);
				for (int x = 0; x < question.answer.length; x++) {
					answer += question.answer[x];
					if ((x + 1) != question.answer.length) {
						answer += ", ";
					}
				}
				answer += "]";
			}
			answer += "\n";
		}
		return answer;
	}

	@Override
	public boolean addStudent(String name) {
		int size = roster.size();
		roster.putIfAbsent(name, new ArrayList<Student>());
		return (size == roster.size()) ? false : true;
	}
	@Override
	public void answerTrueFalseQuestion(String studentName, int examId, int questionNumber, boolean answer) {
		Student answerInput = new Student(studentName, examId, questionNumber, answer, null);
		ArrayList<Student> bank = roster.get(studentName);
		bank = Student.answerAddQuestions(bank, answerInput);
	}

	@Override
	public void answerMultipleChoiceQuestion(String studentName, int examId, int questionNumber, String[] answer) {
		Student answerInput = new Student(studentName, examId, questionNumber, false, answer);
		ArrayList<Student> bank = roster.get(studentName);
		bank = Student.answerAddQuestions(bank, answerInput);
	}

	@Override
	public void answerFillInTheBlanksQuestion(String studentName, int examId, int questionNumber, String[] answer) {
		Student answerInput = new Student(studentName, examId, questionNumber, false, answer);
		ArrayList<Student> bank = roster.get(studentName);
		bank = Student.answerAddQuestions(bank, answerInput);
	}

	@Override
	public double getExamScore(String studentName, int examId) {
		double points = 0;
		ArrayList<Student> name = roster.get(studentName);
		ArrayList<ExamQuestion> qBank = this.questionBank.get(examId);
		for (int answer = 0; answer < name.size(); answer++) {
			for (int question = 0; question < qBank.size(); question++) {
				Student person = name.get(answer);
				ExamQuestion q = qBank.get(question);
				if (person.examId == examId && person.questionNumber == q.questionNumber) {
					if (q.questionType == 0 && person.answer1 == q.answer1) {
						points += q.points;
					} else if (q.questionType == 1 && Arrays.equals(q.answer, person.answer)) {
						points += q.points;
					} else if (q.questionType == 2 && Arrays.equals(q.answer, person.answer)) {
						points += q.points;
					} else if (q.questionType == 2) {
						int correct = 0;
						List<String> pList = Arrays.asList(person.answer);
						for (int x = 0; x < q.answer.length; x++) {
							if (pList.contains(q.answer[x])) {
								correct = correct + 1;
							}
						}
						points += Math.round(((correct / q.answer.length) * q.points));
					}
				}
			}
		}
		return points;
	}

	@Override
	public String getGradingReport(String studentName, int examId) {
		String toReturn = "";
		double pointsEarned = 0;
		double totalPoints = 0;
		ArrayList<Student> name = roster.get(studentName);
		ArrayList<ExamQuestion> qBank = questionBank.get(examId);
		for (int answer = 0; answer < name.size(); answer++) {
			for (int question = 0; question < qBank.size(); question++) {
				Student person = name.get(answer);
				ExamQuestion q = qBank.get(question);
				if (person.examId == examId && person.questionNumber == q.questionNumber) {
					toReturn += "Question #" + q.questionNumber;
					totalPoints += q.points;
					if (q.questionType == 0 && person.answer1 == q.answer1) {
						pointsEarned += q.points;
						toReturn += " " + q.points + " points out of ";
					} else if (q.questionType == 1 && Arrays.equals(q.answer, person.answer)) {
						pointsEarned += q.points;
						toReturn += " " + q.points + " points out of ";
					} else if (q.questionType == 2) {
						if (Arrays.equals(q.answer, person.answer)) {
							pointsEarned += q.points;
							toReturn += " " + q.points + " points out of ";
						} else {
							double correct = 0;
							List<String> pList = Arrays.asList(person.answer);
							for (int x = 0; x < q.answer.length; x++) {
								if (pList.contains(q.answer[x])) {
									correct = correct + 1.0;
								}
							}
							double point = (correct / q.answer.length) * q.points;
							pointsEarned += point;
							toReturn += " " + point + " points out of ";
						}
					} else {
						toReturn += " 0.0 points out of ";
					}
					toReturn += q.points + "\n";
				}
			}
		}
		toReturn += "Final Score: " + pointsEarned + " out of " + totalPoints;
		return toReturn;
	}

	@Override
	public void setLetterGradesCutoffs(String[] letterGrades, double[] cutoffs) {
		this.letterGrades = letterGrades;
		this.cutoff = cutoffs;
	}

	@Override
	public double getCourseNumericGrade(String studentName) {
		ArrayList<Student> student = roster.get(studentName);
		Hashtable<Integer, Double> examScore = new Hashtable<Integer, Double>();
		for (int x = 0; x < student.size(); x++) {
			int examId = student.get(x).examId;
			if (examScore.containsKey(examId)) {
				examScore.remove(examId);
				examScore.put(examId, this.getExamScore(studentName, examId));
			} else {
				examScore.put(examId, this.getExamScore(studentName, examId));
			}
		}

		Set<Integer> enumeration = examScore.keySet();
		Double pointsEarned = 0.0;
		Double totalPoints = 0.0;
		for (Integer z : enumeration) {
			pointsEarned += examScore.get(z);
			ArrayList<ExamQuestion> qBanks = questionBank.get(z);
			for (ExamQuestion w : qBanks) {
				totalPoints += w.points;
			}
		}
		return (pointsEarned / totalPoints) * 100;
	}

	@Override
	public String getCourseLetterGrade(String studentName) {
		double grade = this.getCourseNumericGrade(studentName);
		if (grade > cutoff[0]) {
			return letterGrades[0];
		} else {
			for (int x = 1; x <= cutoff.length; x++) {
				if (cutoff[x - 1] <= grade) {
					return letterGrades[x - 1];
				}
			}
		}
		return "";
	}

	@Override
	public String getCourseGrades() {
		String toReturn = "";
		List<String> listKeys = new ArrayList<String>(roster.keySet());
		Collections.sort(listKeys);
		for (String x : listKeys) {
			toReturn += x + " ";
			toReturn += this.getCourseNumericGrade(x);
			toReturn += " " + this.getCourseLetterGrade(x) + "\n";
		}
		return toReturn;
	}

	@Override
	public double getMaxScore(int examId) {
		double maxScore = 0.0;
		List<String> listKeys = new ArrayList<String>(roster.keySet());
		for (String x : listKeys) {
			ArrayList<Student> student = roster.get(x);
			for (int y = 0; y < student.size(); y++) {
				if (student.get(y).examId == examId) {
					if (this.getExamScore(x, examId) > maxScore) {
						maxScore = this.getExamScore(x, examId);
					}
				}
			}
		}
		return maxScore;
	}

	@Override
	public double getMinScore(int examId) {
		double minScore = 6000.0;
		List<String> listKeys = new ArrayList<String>(roster.keySet());
		for (String x : listKeys) {
			ArrayList<Student> student = roster.get(x);
			for (int y = 0; y < student.size(); y++) {
				if (student.get(y).examId == examId) {
					if (this.getExamScore(x, examId) < minScore) {
						minScore = this.getExamScore(x, examId);
					}
				}
			}
		}
		return minScore;
	}

	@Override
	public double getAverageScore(int examId) {
		int totalScore = 0;
		int size = 0;
		List<String> listKeys = new ArrayList<String>(roster.keySet());
		for (String x : listKeys) {
			ArrayList<Student> student = roster.get(x);
			for (int y = 0; y < student.size(); y++) {
				if (student.get(y).examId == examId) {
					totalScore += this.getExamScore(x, examId);
					size++;
				}
			}
		}
		return Math.round(totalScore / size);
	}

	@Override
	public void saveManager(Manager manager, String fileName) {
		File file = new File(fileName);
		ObjectOutputStream output;
		try {
			output = new ObjectOutputStream(new FileOutputStream(file));
			output.writeObject(manager);
			output.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Manager restoreManager(String fileName) {
		Manager toReturn = null;
		try {
			FileInputStream file = new FileInputStream(fileName);
			ObjectInputStream in = new ObjectInputStream(file);
			toReturn = (Manager) in.readObject();
			in.close();
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return toReturn;
	}

}
