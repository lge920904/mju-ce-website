package kr.ac.mju.cs.bean;

import java.io.File;

public class Professor extends User {
	private String major;
	private String engName;
	private String roomPhone;
	private String position;
	private String comment;
	private int emid;
	private int profnum;
	private String homepage;

	public Professor(String id, String password, String name, String email,
			File photo, int category, String major) {
		super(id, password, name, email, photo, category);
		this.major = major;
	}

	public Professor(User user, String major) {
		super(user.getId(), user.getPassword(), user.getName(),
				user.getEmail(), user.getPhoto(), user.getCategory(), user
						.getActive());
		this.major = major;
	}

	public Professor(int profnum, String major, String email, String engName,
			String roomPhone, String position, String comment, int emid, String homepage) {
		super(email);
		this.engName = engName;
		this.major = major;
		this.roomPhone = roomPhone;
		this.position = position;
		this.comment = comment;
		this.profnum = profnum;
		this.emid = emid;
		this.homepage = homepage;
	}
	
	public Professor(String id, String email, String engName, String position, String roomPhone, String comment, String homepage, String major){
		super(id, email);
		this.engName = engName;
		this.position = position;
		this.roomPhone = roomPhone;
		this.major = major;
		this.homepage = homepage;
		this.comment = comment;
	}
	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public Professor getProfessor() {
		return this;
	}

	public String getEngName() {
		return engName;
	}

	public void setEngName(String engName) {
		this.engName = engName;
	}

	public String getRoomPhone() {
		return roomPhone;
	}

	public void setRoomPhone(String roomPhone) {
		this.roomPhone = roomPhone;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getEmid() {
		return emid;
	}

	public void setEmid(int emid) {
		this.emid = emid;
	}

	public int getProfnum() {
		return profnum;
	}

	public void setProfnum(int profnum) {
		this.profnum = profnum;
	}

	public String getHomepage() {
		return homepage;
	}

	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}

}
