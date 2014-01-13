package kr.ac.mju.cs.bean;
import javax.swing.ImageIcon;


public class Staff extends User{
	private int department;

	public Staff(String id, String password, String name, String email, ImageIcon photo, int category, int department){
		super(id, password, name, email, photo, category);
		this.department = department;
	}
	public Staff(){
		
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
