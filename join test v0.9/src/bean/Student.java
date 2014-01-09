package bean;
import javax.swing.ImageIcon;


public class Student extends User {
	private String study;

	public Student(){
		
	}
	public Student(String id, String password, String name, String email, ImageIcon photo, int athority, String study){
		super(id, password, name, email, photo, athority);
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
