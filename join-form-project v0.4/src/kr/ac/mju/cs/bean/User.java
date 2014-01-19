package kr.ac.mju.cs.bean;

import java.io.File;
import java.util.ArrayList;

public class User {

	public static enum ACTIVE{UNACTIVE, ACTIVE}
	private String id;
	private String password;
	private String name;
	private String email;
	// private File photo;
	private File photo;
	private int category;
	private int active;

	public User(String id, String password, String name, String email,
			File photo, int category) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.password = password;
		this.name = name;
		this.email = email;
		this.photo = photo;
		this.category = category;
	}
	
	public User(String id, String password, String name, String email,
			File photo, int category, int active) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.password = password;
		this.name = name;
		this.email = email;
		this.photo = photo;
		this.category = category;
		this.active = active;
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

	public File getPhoto() {
		return photo;
	}

	public void setPhoto(File photo) {
		this.photo = photo;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

}
