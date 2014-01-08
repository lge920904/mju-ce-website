package kr.ac.mju.cs.bean;

public class User {
	private String id;
	private String password;
	private String name;
	private String email; 
	private String address;
	private String birth;
	private String phone;
	private String sex;
	private Student student;
	private Professor prof;
	private Staff staff;
	private Normal normal;
	
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Professor getProf() {
		return prof;
	}
	public void setProf(Professor prof) {
		this.prof = prof;
	}
	public Staff getStaff() {
		return staff;
	}
	public void setStaff(Staff staff) {
		this.staff = staff;
	}
	public Normal getNormal() {
		return normal;
	}
	public void setNormal(Normal normal) {
		this.normal = normal;
	}
}
