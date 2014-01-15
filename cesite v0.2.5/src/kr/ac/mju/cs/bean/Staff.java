package kr.ac.mju.cs.bean;
import java.io.File;


public class Staff extends User{
	private int department;

	public Staff(String id, String password, String name, String email, File photo, int category, int department){
		super(id, password, name, email, photo, category);
		this.department = department;
	}

	public Staff(User user, int department) {
		super(user.getId(), user.getPassword(), user.getName(), user.getEmail(), user.getPhoto(), user.getCategory());
		this.department = department;
	}
	public int getDepartment() {
		return department;
	}

	public void setDepartment(int department) {
		this.department = department;
	}
	
	public Staff getStaff(){
		return this;
	}
}
