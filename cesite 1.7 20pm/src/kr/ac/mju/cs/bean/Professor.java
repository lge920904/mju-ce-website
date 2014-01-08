package kr.ac.mju.cs.bean;

public class Professor {
	private String professorId;
	private String position;
	private String major;
	private String room;
	private String lab;
	private String roomPhone;
	private String jobState;
	
	public String getProfessorId() {
		return professorId;
	}
	public void setProfessorId(String professorId) {
		this.professorId = professorId;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getRoom() {
		return room;
	}
	public void setRoom(String room) {
		this.room = room;
	}
	public String getLab() {
		return lab;
	}
	public void setLab(String lab) {
		this.lab = lab;
	}
	public String getRoomPhone() {
		return roomPhone;
	}
	public void setRoomPhone(String roomPhone) {
		this.roomPhone = roomPhone;
	}
	public String getJobState() {
		return jobState;
	}
	public void setJobState(String jobState) {
		this.jobState = jobState;
	}
}
