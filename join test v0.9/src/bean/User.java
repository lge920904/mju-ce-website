package bean;
import javax.swing.ImageIcon;


public class User {
	private String id;
	private String password;
	private String name;
	private String email;
	// private ImageIcon photo;
	private ImageIcon photo;
	private int authority;
	
	public User(String id, String password, String name, String email, ImageIcon photo, int authority) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.password = password;
		this.name = name;
		this.email = email;
		this.photo = photo;
		this.authority = authority;
	}
	public User() {
		// TODO Auto-generated constructor stub
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public ImageIcon getPhoto() {
		return photo;
	}
	public void setPhoto(ImageIcon photo) {
		this.photo = photo;
	}
	public int getAuthority() {
		return authority;
	}
	public void setAuthority(int authority) {
		this.authority = authority;
	}
}
