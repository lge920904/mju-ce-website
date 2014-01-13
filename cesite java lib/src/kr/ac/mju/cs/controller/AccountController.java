package kr.ac.mju.cs.controller;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;

import kr.ac.mju.cs.bean.Professor;
import kr.ac.mju.cs.bean.Staff;
import kr.ac.mju.cs.bean.Student;
import kr.ac.mju.cs.bean.User;


public class AccountController {

	private FileInputStream fin;
	private File imgfile;
	private DBAdapter adapter;

	public AccountController() {
		adapter = new DBAdapter();
		imgfile = new File("./img/default.jpg");
		try {
			// 직원 정보 추가 (id, password, name, email, photo, athority, department);
			fin = new FileInputStream(imgfile);
		}catch(Exception e){

		}
	}

	// 회원가입
	public void createUser(User user) {

		Connection conn = adapter.connect();
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement("insert into user(id,password,name,email,photo,authority) values(?,?,?,?,?,?)");
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getName());
			pstmt.setString(4, user.getEmail());
			pstmt.setBinaryStream(5, fin, (int)imgfile.length());
			pstmt.setInt(6, 4);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		adapter.disConnect(conn, pstmt);

	}

	/* 학생 정보 추가 */
	public void createStudent(Student student){
		Connection conn = adapter.connect();
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement("insert into user(id,password,name,email,photo,authority) values(?,?,?,?,?,?)");
			pstmt.setString(1, student.getId());
			pstmt.setString(2, student.getPassword());
			pstmt.setString(3, student.getName());
			pstmt.setString(4, student.getEmail());
			pstmt.setBinaryStream(5, fin, (int)imgfile.length());
			pstmt.setInt(6, 3);
			pstmt.executeUpdate();
			pstmt = conn.prepareStatement("insert into student(study,email) values(?,?)");
			pstmt.setString(1, student.getStudy());
			pstmt.setString(2, student.getEmail());
			pstmt.executeUpdate();
		}catch(Exception e){
			e.getMessage();
		}

		adapter.disConnect(conn, pstmt);
	}

	public void createProfessor(Professor professor){
		Connection conn = adapter.connect();
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement("insert into user(id,password,name,email,photo,authority) values(?,?,?,?,?,?)");
			pstmt.setString(1, professor.getId());
			pstmt.setString(2, professor.getPassword());
			pstmt.setString(3, professor.getName());
			pstmt.setString(4, professor.getEmail());
			pstmt.setBinaryStream(5, fin, (int)imgfile.length());
			pstmt.setInt(6, 3);
			pstmt.executeUpdate();
			pstmt = conn.prepareStatement("insert into professor(major,email) values(?,?)");
			pstmt.setString(1, professor.getMajor());
			pstmt.setString(2, professor.getEmail());
			pstmt.executeUpdate();
		}catch(Exception e){
			e.getMessage();
		}		
		adapter.disConnect(conn, pstmt);
	}

	public void createStaff(Staff staff){
		Connection conn = adapter.connect();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement("insert into user(id,password,name,email,photo,authority) values(?,?,?,?,?,?)");
			pstmt.setString(1, staff.getId());
			pstmt.setString(2, staff.getPassword());
			pstmt.setString(3, staff.getName());
			pstmt.setString(4, staff.getEmail());
			pstmt.setBinaryStream(5, fin, (int)imgfile.length());
			pstmt.setInt(6, 3);
			pstmt.executeUpdate();
			pstmt = conn.prepareStatement("insert into staff(department,email) values(?,?)");
			pstmt.setInt(1, staff.getDepartment());
			pstmt.setString(2, staff.getEmail());
			pstmt.executeUpdate();
		}catch(Exception e){
			e.getMessage();
		}		
		adapter.disConnect(conn, pstmt);
	}

	// 회원탈퇴
	public void deleteUser(String id){	 
		Connection conn = adapter.connect();
		PreparedStatement pstmt = null;
		String sql = null;

		try {
			if(id.contains("@")){
				// 이메일로 아이디랑 비번 검증하는 부분
				sql = "delete from user where email=?";
			}else{
				// 아이디로 검증
				sql = "delete from user where id=?";

			}
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		adapter.disConnect(conn, pstmt);

	}

	// 회원정보수정
	public void modifyUser(User user){
		Connection conn = adapter.connect();
		PreparedStatement pstmt = null;
		String sql = null;

		adapter.connect();

		adapter.disConnect(conn, pstmt);
	}

	public void modifyStudent(Student student){
		Connection conn = adapter.connect();
		PreparedStatement pstmt = null;
		try{
			pstmt = conn.prepareStatement("update user natural join student set id=?, password=?, name=?, email=?, photo=?, study=? where email=?");
			pstmt.setString(1, student.getId());
			pstmt.setString(2, student.getPassword());
			pstmt.setString(3, student.getName());
			pstmt.setString(4, student.getEmail());
			pstmt.setBinaryStream(5, fin, (int)imgfile.length());
			pstmt.setString(6, student.getStudy());
			pstmt.setString(7, student.getEmail());
			pstmt.executeUpdate();
		}catch(Exception e){

		}
	}

	public void modifyProfessor(Professor professor){
		Connection conn = adapter.connect();
		PreparedStatement pstmt = null;
		try{
			pstmt = conn.prepareStatement("update user natural join professor set id=?, password=?, name=?, email=?, photo=?, major=? where email=?");
			pstmt.setString(1, professor.getId());
			pstmt.setString(2, professor.getPassword());
			pstmt.setString(3, professor.getName());
			pstmt.setString(4, professor.getEmail());
			pstmt.setBinaryStream(5, fin, (int)imgfile.length());
			pstmt.setString(6, professor.getMajor());
			pstmt.setString(7, professor.getEmail());
			pstmt.executeUpdate();
		}catch(Exception e){

		}
	}

	public void modifyStaff(Staff staff){
		Connection conn = adapter.connect();
		PreparedStatement pstmt = null;
		try{
			pstmt = conn.prepareStatement("update user natural join staff set id=?, password=?, name=?, email=?, photo=?, department=? where email=?");
			pstmt.setString(1, staff.getId());
			pstmt.setString(2, staff.getPassword());
			pstmt.setString(3, staff.getName());
			pstmt.setString(4, staff.getEmail());
			pstmt.setBinaryStream(5, fin, (int)imgfile.length());
			pstmt.setInt(6, staff.getDepartment());
			pstmt.setString(7, staff.getEmail());
			pstmt.executeUpdate();
		}catch(Exception e){

		}
	}

	// 아이디 중복 확인
	public boolean doubleCheckId(String id) {
		boolean result = false;
		Connection conn = adapter.connect();
		Statement stmt;
		ResultSet rs = null;
		String sql = "select id from user where id=\""+id+"\"";;

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()){
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return result;
		}
		adapter.disConnect(conn, stmt);
		return result;

	}

	// 이메일 중복 확인
	public boolean doubleCheckEmail(String email) {
		// email이 있는지 확인
		// 있으면 true, 없으면 false
		boolean result = false;
		Connection conn = adapter.connect();
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select email from user where id=\""+email+"\"";;

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()){
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		adapter.disConnect(conn, stmt, rs);
		return result;


	}

	// 로그인시 아이디 비번 확인
	public boolean validateLoginInfo(String id, String password) {
		boolean result = false;

		Connection conn = adapter.connect();
		Statement stmt = null;
		ResultSet rs = null;
		String sql = null;

		if(id.contains("@")){
			// 이메일로 아이디랑 비번 검증하는 부분
			sql = "select * from user where email=\""+id+"\" AND password=\""+password+"\"";
		}else{
			// 아이디로 검증
			sql = "select * from user where id=\""+id+"\" AND password=\""+password+"\"";
		}

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()){
				result = true;
				setUserSessionInfo(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		adapter.disConnect(conn, stmt, rs);
		return result;		 
	}

	public User setUserSessionInfo(ResultSet rs){
		try{
			String id = rs.getString(1);
			String password = rs.getString(2);
			String name = rs.getString(3);
			String email = rs.getString(4);
			ImageIcon photo = null;
			int category = rs.getInt(6);
			User user = new User(id, password, name, email, photo, category);
			return user;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
}


