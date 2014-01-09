import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;


public class AccountDB extends DBAdapter{
	private User user;
	private Student student;
	private Professor professor;
	private Staff staff;

	private boolean result;

	public AccountDB(){
		super();
	}
	
	/* 유저 추가 */
	public boolean insertUserData(User user) {
		result = false;
		PreparedStatement pre = null;
		String id = user.getId();
		String password = user.getPassword();
		String name = user.getName();
		String email = user.getEmail();
		ImageIcon photo = user.getPhoto();
		
		File imgfile = new File("./img/default.jpg");
		try {
			FileInputStream fin;
			fin = new FileInputStream(imgfile);
			
			if(user instanceof Student){
				student = (Student)user;
				String study = student.getStudy();
				//	학생 정보 추가(id, password, name, email, photo, athority, study); 
				pre = con.prepareStatement("insert into user(id,password,name,email,photo,authority) values(?,?,?,?,?,?)");
				pre.setString(1, id);
				pre.setString(2, password);
				pre.setString(3, name);
				pre.setString(4, email);
				pre.setBinaryStream(5, fin, (int)imgfile.length());
				pre.setInt(6, 3);
				pre.executeUpdate();
				pre = con.prepareStatement("insert into student(study,email) values(?,?)");
				pre.setString(1, study);
				pre.setString(2, email);
				pre.executeUpdate();
				pre.close();
				con.close();
				result = true;
			}else if(user instanceof Professor){
				professor = (Professor)user;
				String major = professor.getMajor();
				// 교수 정보 추가 (id, password, name, email, photo, athority, major);
				pre = con.prepareStatement("insert into user(id,password,name,email,photo,authority) values(?,?,?,?,?,?)");
				pre.setString(1, id);
				pre.setString(2, password);
				pre.setString(3, name);
				pre.setString(4, email);
				pre.setBinaryStream(5, fin, (int)imgfile.length());
				pre.setInt(6, 3);
				pre.executeUpdate();
				pre = con.prepareStatement("insert into professor(major,email) values(?,?)");
				pre.setString(1, major);
				pre.setString(2, email);
				pre.executeUpdate();
				pre.close();
				con.close();
				result = true;
			}else if(user instanceof Staff){
				staff = (Staff)user;
				int department = staff.getDepartment();
				// 직원 정보 추가 (id, password, name, email, photo, athority, department);
				pre = con.prepareStatement("insert into user(id,password,name,email,photo,authority) values(?,?,?,?,?,?)");
				pre.setString(1, id);
				pre.setString(2, password);
				pre.setString(3, name);
				pre.setString(4, email);
				pre.setBinaryStream(5, fin, (int)imgfile.length());
				pre.setInt(6, 3);
				pre.executeUpdate();
				pre = con.prepareStatement("insert into staff(department,email) values(?,?)");
				pre.setInt(1, department);
				pre.setString(2, email);
				pre.executeUpdate();
				pre.close();
				con.close();
				result = true;
			}else {
				// 유저 정보 추가 (id, password, name, email, photo, athority,)
				pre = con.prepareStatement("insert into user(id,password,name,email,photo,authority) values(?,?,?,?,?,?)");
				pre.setString(1, id);
				pre.setString(2, password);
				pre.setString(3, name);
				pre.setString(4, email);
				pre.setBinaryStream(5, fin, (int)imgfile.length());
				pre.setInt(6, 4);
				pre.executeUpdate();
				pre.close();
				con.close();
				result = true;
			}
		}catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return result;
	}

	/* 유저 삭제 */
	public boolean deleteUserData(String id) {
		// 세션의 id나 email 정보로 delete하는 쿼리 작성 
		result = false;
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
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			System.out.println(sql);
			pstmt.close();
			con.close();
			result = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	/* 유저 정보 수정 */
	public boolean modifyUserData(User user) {
		result = false;
		// 세션의 id나 email 정보로 update하는 쿼리 작성 
		PreparedStatement pre = null;
		String id = user.getId();
		String password = user.getPassword();
		String name = user.getName();
		String email = user.getEmail();
		ImageIcon photo = user.getPhoto();
		
		File imgfile = new File("./img/default.jpg");
		FileInputStream fin;
		try {
			fin = new FileInputStream(imgfile);
			
			if(user instanceof Student){
				student = (Student)user;
				String study = student.getStudy();
				// 학생 정보 수정(id, password, name, email, photo, athority, study);
				pre = con.prepareStatement("update user natural join student set id=?, password=?, name=?, email=?, photo=?, study=? where email=?");
				pre.setString(1, id);
				pre.setString(2, password);
				pre.setString(3, name);
				pre.setString(4, email);
				pre.setBinaryStream(5, fin, (int)imgfile.length());
				pre.setString(6, study);
				pre.setString(7, email);
				pre.executeUpdate();
				pre.close();
				con.close();
				result = true;

			}else if(user instanceof Professor){
				professor = (Professor)user;
				String major = professor.getMajor();
				// 교수 정보 수정 (id, password, name, email, photo, athority, major); 
				pre = con.prepareStatement("update user natural join professor set id=?, password=?, name=?, email=?, photo=?, major=? where email=?");
				pre.setString(1, id);
				pre.setString(2, password);
				pre.setString(3, name);
				pre.setString(4, email);
				pre.setBinaryStream(5, fin, (int)imgfile.length());
				pre.setString(6, major);
				pre.setString(7, email);
				pre.executeUpdate();
				pre.close();
				con.close();
				result = true;
			}else if(user instanceof Staff){
				staff = (Staff)user;
				int department = staff.getDepartment();
				// 직원 정보 수정 (id, password, name, email, photo, athority, department); 
				pre = con.prepareStatement("update user natural join staff set id=?, password=?, name=?, email=?, photo=?, department=? where email=?");
				pre.setString(1, id);
				pre.setString(2, password);
				pre.setString(3, name);
				pre.setString(4, email);
				pre.setBinaryStream(5, fin, (int)imgfile.length());
				pre.setInt(6, department);
				pre.setString(7, email);
				pre.executeUpdate();
				pre.close();
				con.close();
				result = true;
			}else {
				// 유저 정보 수정 (id, password, name, email, photo, athority,)
				pre = con.prepareStatement("update user set id=?, password=?, name=?, email=?, photo=? where email=?");
				pre.setString(1, id);
				pre.setString(2, password);
				pre.setString(3, name);
				pre.setString(4, email);
				pre.setBinaryStream(5, fin, (int)imgfile.length());
				pre.setString(6, email);
				pre.executeUpdate();
				pre.close();
				con.close();
				result = true;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	/* 회원가입시, 아이디 중복확인 */
	public boolean doubleCheckId(String id) {
		// TODO Auto-generated method stub
		// id가 있는지 확인
		// 있으면 true, 없으면 false
		result = false;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select id from user where id=\""+id+"\"";;

		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()){
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	/* 회원가입시, 이메일 중복확인 */
	public boolean doubleCheckEmail(String email) {
		result = false;
		// TODO Auto-generated method stub
		// email이 있는지 확인
		// 있으면 true, 없으면 false
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select email from user where id=\""+email+"\"";;

		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()){
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	/* 교수,직원,학생에 따른 학번과 이름을 매치함 */
	public boolean validateMember(int authority, String id, String name) {
		// TODO Auto-generated method stub
		result = false;

		if(authority == 1){
			// 교수일 경우
		}else if(authority == 2){
			// 직원일 경우
		}else if(authority == 3){
			// 학생일 경우
		}
		return result;
	}

	/* 로그인 */
	public boolean validateLoginInfo(String id, String password){
		result = false;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;

		if(id.contains("@")){
			// 이메일로 아이디랑 비번 검증하는 부분
			sql = "select password from user where email=\""+id+"\" AND password=\""+password+"\"";
		}else{
			// 아이디로 검증
			sql = "select password from user where id=\""+id+"\" AND password=\""+password+"\"";
		}

		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()){
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
