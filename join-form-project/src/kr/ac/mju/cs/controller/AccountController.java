package kr.ac.mju.cs.controller;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.ac.mju.cs.bean.Professor;
import kr.ac.mju.cs.bean.Staff;
import kr.ac.mju.cs.bean.Student;
import kr.ac.mju.cs.bean.User;
//내꺼
public class AccountController {

	private DBAdapter adapter;

	public AccountController() {
		adapter = new DBAdapter();
	}

	// 회원가입
	public void createUser(User user) {
		Connection conn = adapter.connect();
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(AccountConstants.INSERT_USER);
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getName());
			pstmt.setString(4, user.getEmail());
			pstmt.setBinaryStream(5, new FileInputStream(user.getPhoto()),
					(int) (user.getPhoto()).length());
			pstmt.setInt(6, user.getCategory());
			pstmt.executeUpdate();
			System.out.println(user.getId() + user.getPassword() + user.getName() + user.getEmail() + user.getCategory());
			System.out.println("create User : " + user.getId());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		adapter.disConnect(conn, pstmt);

	}

	/* 학생 정보 추가 */
	public void createStudent(Student student) {
		Connection conn = adapter.connect();
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(AccountConstants.INSERT_USER);
			pstmt.setString(1, student.getId());
			pstmt.setString(2, student.getPassword());
			pstmt.setString(3, student.getName());
			pstmt.setString(4, student.getEmail());
			pstmt.setBinaryStream(5, new FileInputStream(student.getPhoto()),
					(int) (student.getPhoto()).length());
			pstmt.setInt(6, student.getCategory());
			pstmt.executeUpdate();
			pstmt = conn.prepareStatement(AccountConstants.INSERT_STUDENT);
			pstmt.setString(1, student.getStudy());
			pstmt.setString(2, student.getEmail());
			pstmt.executeUpdate();
			System.out.println(student.getId() + student.getPassword() + student.getName() + student.getEmail() + student.getCategory());
			System.out.println("create Student : " + student.getId());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		adapter.disConnect(conn, pstmt);
	}

	public void createProfessor(Professor professor) {
		Connection conn = adapter.connect();
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(AccountConstants.INSERT_USER);
			pstmt.setString(1, professor.getId());
			pstmt.setString(2, professor.getPassword());
			pstmt.setString(3, professor.getName());
			pstmt.setString(4, professor.getEmail());
			pstmt.setBinaryStream(5, new FileInputStream(professor.getPhoto()),
					(int) (professor.getPhoto()).length());
			pstmt.setInt(6, professor.getCategory());
			pstmt.executeUpdate();
			pstmt = conn.prepareStatement(AccountConstants.INSERT_PROFESSOR);
			pstmt.setString(1, professor.getMajor());
			pstmt.setString(2, professor.getEmail());
			pstmt.executeUpdate();
			System.out.println(professor.getId() + professor.getPassword() + professor.getName() + professor.getEmail() + professor.getCategory());
			System.out.println("create professor : " + professor.getId());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		adapter.disConnect(conn, pstmt);
	}

	public void createStaff(Staff staff) {
		Connection conn = adapter.connect();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(AccountConstants.INSERT_USER);
			pstmt.setString(1, staff.getId());
			pstmt.setString(2, staff.getPassword());
			pstmt.setString(3, staff.getName());
			pstmt.setString(4, staff.getEmail());
			pstmt.setBinaryStream(5, new FileInputStream(staff.getPhoto()),
					(int) (staff.getPhoto()).length());
			pstmt.setInt(6, staff.getCategory());
			pstmt.executeUpdate();
			pstmt = conn.prepareStatement(AccountConstants.INSERT_STAFF);
			pstmt.setInt(1, staff.getDepartment());
			pstmt.setString(2, staff.getEmail());
			pstmt.executeUpdate();
			System.out.println(staff.getId() + staff.getPassword() + staff.getName() + staff.getEmail() + staff.getCategory());
			System.out.println("create staff : " + staff.getId());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		adapter.disConnect(conn, pstmt);
	}

	// 회원탈퇴
	public void deleteUser(String id) {
		Connection conn = adapter.connect();
		PreparedStatement pstmt = null;
		String sql = null;

		try {
			if (id.contains("@")) {
				// 이메일로 아이디랑 비번 검증하는 부분
				sql = AccountConstants.DELETE_USER_BY_EMAIL;
			} else {
				// 아이디로 검증
				sql = AccountConstants.DELETE_USER_BY_ID;

			}
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		adapter.disConnect(conn, pstmt);

	}

	// 회원정보수정
	public void modifyUser(User user) {
		Connection conn = adapter.connect();
		PreparedStatement pstmt = null;

		adapter.connect();

		adapter.disConnect(conn, pstmt);
	}

	public void modifyStudent(Student student) {
		Connection conn = adapter.connect();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(AccountConstants.UPDATE_STUDENT);
			pstmt.setString(1, student.getId());
			pstmt.setString(2, student.getPassword());
			pstmt.setString(3, student.getName());
			pstmt.setString(4, student.getEmail());
			pstmt.setBinaryStream(5, new FileInputStream(student.getPhoto()),
					(int) (student.getPhoto()).length());
			pstmt.setString(6, student.getStudy());
			pstmt.setString(7, student.getEmail());
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void modifyProfessor(Professor professor) {
		Connection conn = adapter.connect();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(AccountConstants.UPDATE_PROFESSOR);
			pstmt.setString(1, professor.getId());
			pstmt.setString(2, professor.getPassword());
			pstmt.setString(3, professor.getName());
			pstmt.setString(4, professor.getEmail());
			pstmt.setBinaryStream(5, new FileInputStream(professor.getPhoto()),
					(int) (professor.getPhoto()).length());
			pstmt.setString(6, professor.getMajor());
			pstmt.setString(7, professor.getEmail());
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void modifyStaff(Staff staff) {
		Connection conn = adapter.connect();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(AccountConstants.UPDATE_STAFF);
			pstmt.setString(1, staff.getId());
			pstmt.setString(2, staff.getPassword());
			pstmt.setString(3, staff.getName());
			pstmt.setString(4, staff.getEmail());
			pstmt.setBinaryStream(5, new FileInputStream(staff.getPhoto()),
					(int) (staff.getPhoto()).length());
			pstmt.setInt(6, staff.getDepartment());
			pstmt.setString(7, staff.getEmail());
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// 아이디 중복 확인
	public boolean doubleCheckId(String id) {
		boolean result = false;
		Connection conn = adapter.connect();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = AccountConstants.DOUBLECHECK_BY_ID;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = true;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return result;
		}
		adapter.disConnect(conn, pstmt);
		return result;

	}

	// 이메일 중복 확인
	public boolean doubleCheckEmail(String email) {
		boolean result = false;
		Connection conn = adapter.connect();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = AccountConstants.DOUBLECHECK_BY_EMAIL;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = true;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return result;
		}
		adapter.disConnect(conn, pstmt, rs);
		return result;

	}

	// 로그인시 아이디 비번 확인
	public User validateLoginInfo(String id, String password) {
		Connection conn = adapter.connect();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		User user = null;

		if (id.contains("@")) {
			// 이메일로 아이디랑 비번 검증하는 부분
			sql = AccountConstants.LOGIN_BY_EMAIL;
		} else {
			// 아이디로 검증
			sql = AccountConstants.LOGIN_BY_ID;
		}
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				user = new User(rs.getString(1), rs.getString(2),
						rs.getString(3), rs.getString(4), null, rs.getInt(6));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		adapter.disConnect(conn, pstmt, rs);
		return user;
	}

	public Professor setSessionProfessor(User user) {
		Connection conn = adapter.connect();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Professor professor = null;
		try {
			pstmt = conn.prepareStatement("select * from professor where email=?");
			pstmt.setString(1, user.getEmail());
			rs = pstmt.executeQuery();
			professor = new Professor(user, rs.getString(1));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		adapter.disConnect(conn, pstmt, rs);
		return professor;
	}

	public Staff setSessionStaff(User user) {
		Connection conn = adapter.connect();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Staff staff = null;
		try {
			pstmt = conn.prepareStatement("select * from staff where email=?");
			pstmt.setString(1, user.getEmail());
			rs = pstmt.executeQuery();
			staff = new Staff(user, rs.getInt(1));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		adapter.disConnect(conn, pstmt, rs);
		return staff;
	}

	public Student setSessionStudent(User user) {
		Connection conn = adapter.connect();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Student student = null;
		try {
			pstmt = conn.prepareStatement("select * from student where email=?");
			pstmt.setString(1, user.getEmail());
			rs = pstmt.executeQuery();
			student = new Student(user, rs.getString(1));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		adapter.disConnect(conn, pstmt, rs);
		return student;
	}

	public boolean isMember(String id, String name) {
		boolean result = false;
		Connection conn = adapter.connect();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			/* 학교사람인지 검증하는 쿼리 필요*/
			result = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		adapter.disConnect(conn, pstmt, rs);
		return result;
	}
}
