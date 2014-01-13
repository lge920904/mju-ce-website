package kr.ac.mju.cs.bean;
import java.util.ArrayList;

import javax.swing.ImageIcon;


public class User {
	public enum CATEGORY {PROFFESOR(1), STAFF(2), STUDENT(3), NORMAL(4);
		CATEGORY(int value){ this.value = value; }
		private final int value ;
		public int getValue(){ return value; }
	}
	
	
	private String id;
	private String password;
	private String name;
	private String email;
	// private ImageIcon photo;
	private ImageIcon photo;
	private int category;
	private ArrayList<String> readAuthority;
	private ArrayList<String> writeAuthority;
	
	public User(String id, String password, String name, String email, ImageIcon photo, int category) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.password = password;
		this.name = name;
		this.email = email;
		this.photo = photo;
		this.category = category;
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
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	public ArrayList<String> getReadAuthority() {
		return readAuthority;
	}
	public void setReadAuthority(ArrayList<String> readAuthority) {
		this.readAuthority = readAuthority;
	}
	public ArrayList<String> getWriteAuthority() {
		return writeAuthority;
	}
	public void setWriteAuthority(ArrayList<String> writeAuthority) {
		this.writeAuthority = writeAuthority;
	}
	
	
}
