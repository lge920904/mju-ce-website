import javax.swing.ImageIcon;


public class Staff extends User{
	private String department;

	public Staff(String id, String password, String name, String email, ImageIcon photo, int athority, String department){
		super(id, password, name, email, photo, athority);
		this.department = department;
	}
	public Staff(){
		
	}
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
	public Staff getStaff(){
		return this;
	}
}
