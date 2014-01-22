package kr.ac.mju.cs.bean;
import java.io.File;


public class Professor extends User {
	private String major;

	public Professor(String id, String password, String name, String email, File photo, int category, String major){
		super(id, password, name, email, photo, category);
		this.major = major;
	}
	public Professor(User user, String major){
		super(user.getId(), user.getPassword(), user.getName(), user.getEmail(), user.getPhoto(), user.getCategory() ,user.getActive());
		this.major = major;
	}
	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}
	
	public Professor getProfessor(){
		return this;
	}

}
