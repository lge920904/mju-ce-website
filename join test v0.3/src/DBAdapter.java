import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;


public class DBAdapter {
	
	private User user;
	private Student student;
	private Professor professor;
	private Staff staff;
	
	protected Connection con = null;
	private final static String dbUrl = "jdbc:mysql://ce.mju.ac.kr/testD";
	private final static String dbUser = "lgetest";
	private final static String dbPassword = "dlrkdmf0904";

	private void loadDriver() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver").newInstance();	
	}
	
	public void connect() {
		try {
			loadDriver();
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException e1) {
			e1.printStackTrace();
		}
		try {
			con = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		}
	}
	
	protected void closeStatement(Statement stmt) {
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	protected void closeResultSet(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception e) {
			}
		}
	}	
	
	public void disConnect() {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
			}
		}
	}
	
	/* 로그인 */
	public boolean validateUserInfo(String id, String password){
		boolean result = false;
		if(id.contains("@")){
			// 이메일로 아이디랑 비번 검증하는 부분
		}else{
			// 아이디로 검증
		}
		return result;
	}

	/* 유저 추가 */
	public void insertUserData(User user) {
		// TODO Auto-generated method stub
		
		String id = user.getId();
		String password = user.getPassword();
		String name = user.getName();
		String email = user.getPassword();
		ImageIcon photo = user.getPhoto();
		
		if(user instanceof Student){
			student = (Student)user;
			String study = student.getStudy();
			// 학생 정보 추가(id, password, name, email, photo, athority, study); 
		}else if(user instanceof Professor){
			professor = (Professor)user;
			String major = professor.getMajor();
			// 교수 정보 추가 (id, password, name, email, photo, athority, major); 
		}else if(user instanceof Staff){
			staff = (Staff)user;
			String department = staff.getDepartment();
			// 직원 정보 추가 (id, password, name, email, photo, athority, department); 
		}else {
			// 유저 정보 추가 (id, password, name, email, photo, athority,)
		}
	}

	public void deleteUserData(User user) {
		// TODO Auto-generated method stub
		// 세션의 id나 email 정보로 delete하는 쿼리 작성 
	}

	public void modifyUserData(User user) {
		// TODO Auto-generated method stub
		// 세션의 id나 email 정보로 update하는 쿼리 작성 
		
		String id = user.getId();
		String password = user.getPassword();
		String name = user.getName();
		String email = user.getPassword();
		ImageIcon photo = user.getPhoto();
		
		if(user instanceof Student){
			student = (Student)user;
			String study = student.getStudy();
			// 학생 정보 수정(id, password, name, email, photo, athority, study); 
		}else if(user instanceof Professor){
			professor = (Professor)user;
			String major = professor.getMajor();
			// 교수 정보 수정 (id, password, name, email, photo, athority, major); 
		}else if(user instanceof Staff){
			staff = (Staff)user;
			String department = staff.getDepartment();
			// 직원 정보 수정 (id, password, name, email, photo, athority, department); 
		}else {
			// 유저 정보 수정 (id, password, name, email, photo, athority,)
		}
	}
}
