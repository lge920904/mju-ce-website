package kr.ac.mju.cs.bean;

import java.sql.Blob;

import javax.servlet.http.Part;

public class UserModel {
	/**  아이디 */
	private String id;
	/**  비밀번호 */
	private String password;
	/**  이름 */
	private String name;
	/**  이메일 */
	private String email;
	/**  이미지 파일 저장 */
    private Part image;
    /** 이미지 불러오기 용 */
    private Blob Bimage;
    /**  권한 */
    private int authority;
    /**  가입일 */
    private String joindate;
    
    public UserModel() {
		// TODO Auto-generated constructor stub
	}
	public String getId() {
		return id;
	}
	public String getPassword() {
		return password;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public Part getImage() {
		return image;
	}
	public Blob getBimage() {
		return Bimage;
	}
	public int getAuthority() {
		return authority;
	}
	public String getJoindate() {
		return joindate;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setImage(Part image) {
		this.image = image;
	}
	public void setBimage(Blob bimage) {
		Bimage = bimage;
	}
	public void setAuthority(int authority) {
		this.authority = authority;
	}
	public void setJoindate(String joindate) {
		this.joindate = joindate;
	}
	
}
