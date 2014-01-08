package kr.ac.mju.cs.bean;

public class Student {
	private String studentId;
	private String grade;
	private String courseState;
	private int semester;
	
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getCourseState() {
		return courseState;
	}
	public void setCourseState(String courseState) {
		this.courseState = courseState;
	}
	public int getSemester() {
		return semester;
	}
	public void setSemester(int semester) {
		this.semester = semester;
	}
}
