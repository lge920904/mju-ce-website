package kr.ac.mju.cs.bean;
import java.io.File;


public class Student extends User {
	private String study;

	public Student(){
		
	}
	public Student(String id, String password, String name, String email, File photo, int category, String study){
		super(id, password, name, email, photo, category);
		this.study = study;
	}
	
	public Student(User user, String study) {
		super(user.getId(), user.getPassword(), user.getName(), user.getEmail(), user.getPhoto(), user.getCategory() ,user.getActive());
		this.study = study;
	}
	public String getStudy() {
		return study;
	}

	public void setStudy(String study) {
		this.study = study;
	}
	
	public Student getStudent(){
		return this;
	}
}
