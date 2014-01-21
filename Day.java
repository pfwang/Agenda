
public class Day { 

	String [] homework = new String [5];
	boolean [] homeworkstate = new boolean [5];
	int [] homeworkduedate = new int [5];
	String [] quiz = new String [5];
	boolean [] quizstate = new boolean [5];
	int [] quizduedate = new int [5];
	String [] test = new String [5];
	boolean [] teststate = new boolean [5];
	int [] testduedate = new int [5];
	String [] Assignment = new String [5];
	boolean [] assignmentstate = new boolean [5];
	int [] assignmentduedate = new int [5];

	/**
	 * @return the assignment
	 */
	public String getAssignment(int index) {
		return Assignment[index];
	}
	/**
	 * @param assignment the assignment to set
	 */
	public void setAssignment(int index, String assignment) {
		Assignment[index] = assignment;
	}
	/**
	 * @return the assignmentstate
	 */
	public boolean getAssignmentstate(int index) {
		return assignmentstate[index];
	}
	/**
	 * @param assignmentstate the assignmentstate to set
	 */
	public void setAssignmentstate(int index, boolean assignmentstate) {
		this.assignmentstate[index] = assignmentstate;
	}
	/**
	 * @return the assignmentduedate
	 */
	public int getAssignmentduedate(int index) {
		return assignmentduedate[index];
	}
	/**
	 * @param assignmentduedate the assignmentduedate to set
	 */
	public void setAssignmentduedate(int index, int assignmentduedate) {
		this.assignmentduedate[index] = assignmentduedate;
	}
	/**
	 * @return the homework
	 */

	public String getHomework(int index) {
		return homework [index];
	}
	/**
	 * @param homework the homework to set
	 */
	public void setHomework(int index, String homework) {
		this.homework[index] = homework;
	}
	/**
	 * @return the homeworkstate
	 */
	public boolean getHomeworkstate(int index) {
		return homeworkstate[index];
	}
	/**
	 * @param homeworkstate the homeworkstate to set
	 */
	public void setHomeworkstate(int index, boolean homeworkstate) {
		this.homeworkstate[index] = homeworkstate;
	}
	/**
	 * @return the homeworkduedate
	 */
	public int getHomeworkduedate(int index) {
		return homeworkduedate[index];
	}
	/**
	 * @param homeworkduedate the homeworkduedate to set
	 */
	public void setHomeworkduedate(int index, int homeworkduedate) {
		this.homeworkduedate[index] = homeworkduedate;
	}
	/**
	 * @return the quiz
	 */
	public String getQuiz(int index) {
		return quiz[index];
	}
	/**
	 * @param quiz the quiz to set
	 */
	public void setQuiz(int index, String quiz) {
		this.quiz[index] = quiz;
	}
	/**
	 * @return the quizstate
	 */
	public boolean getQuizstate(int index) {
		return quizstate[index];
	}
	/**
	 * @param quizstate the quizstate to set
	 */
	public void setQuizstate(int index, boolean quizstate) {
		this.quizstate[index] = quizstate;
	}
	/**
	 * @return the quizduedate
	 */
	public int getQuizduedate(int index) {
		return quizduedate[index];
	}
	/**
	 * @param quizduedate the quizduedate to set
	 */
	public void setQuizduedate(int index, int quizduedate) {
		this.quizduedate[index] = quizduedate;
	}
	/**
	 * @return the test
	 */
	public String getTest(int index) {
		return test[index];
	}
	/**
	 * @param test the test to set
	 */
	public void setTest(int index, String test) {
		this.test[index] = test;
	}
	/**
	 * @return the teststate
	 */
	public boolean getTeststate(int index) {
		return teststate[index];
	}
	/**
	 * @param teststate the teststate to set
	 */ 
	public void setTeststate(int index, boolean teststate) {
		this.teststate[index] = teststate;
	}
	/**
	 * @return the testduedate
	 */
	public int getTestduedate(int index) {
		return testduedate[index];
	}
	/**
	 * @param testduedate the testduedate to set
	 */
	public void setTestduedate(int index, int testduedate) {
		this.testduedate[index] = testduedate;
	}
}

