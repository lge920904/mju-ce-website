package bean;
import javax.swing.ImageIcon;


public class Professor extends User {
	private String major;

	public Professor(){
		
	}
	public Professor(String id, String password, String name, String email, ImageIcon photo, int authority, String major){
		super(id, password, name, email, photo, authority);
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
