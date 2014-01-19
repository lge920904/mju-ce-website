package kr.ac.mju.cs.controller;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.ac.mju.cs.bean.NonMember;
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
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		adapter.disConnect(conn, pstmt);

	}

	/* 학생 정보 추가 */
	public void createStudent(Student student) {
		Connection conn = adapter.connect();
		PreparedStatement pstmt = null;
		createUser(student);
		try {
			pstmt = conn.prepareStatement(AccountConstants.INSERT_STUDENT);
			pstmt.setString(1, student.getStudy());
			pstmt.setString(2, student.getEmail());
			pstmt.executeUpdate();
			System.out.println("create Student : " + student.getId());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		adapter.disConnect(conn, pstmt);
	}

	public void createNonMember(NonMember nonMember) {
		Connection conn = adapter.connect();
		PreparedStatement pstmt = null;
		createUser(nonMember);
		try {
			pstmt = conn.prepareStatement(AccountConstants.INSERT_NON_MEMBER);
			pstmt.setInt(1, nonMember.getOption());
			pstmt.setString(2, nonMember.getEmail());
			pstmt.executeUpdate();
			System.out.println("create nonMember : " + nonMember.getId());
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
		/* update user set password=?, name=?, email=? where id=? */
		String sql = AccountConstants.MODIFY_USER;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getPassword());
			pstmt.setString(2, user.getName());
			pstmt.setString(3, user.getEmail());
			pstmt.setInt(4, user.getActive());
			pstmt.setString(5, user.getId());
			pstmt.executeUpdate();
			System.out.println("modify user : " + user.getId());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		adapter.disConnect(conn, pstmt);
	}

	// 아이디 중복 확인
	public User findUserById(String id) {
		Connection conn = adapter.connect();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		User user = null;
		String sql = AccountConstants.FIND_USER_BY_ID;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				user = new User(rs.getString(1), rs.getString(2),
						rs.getString(3), rs.getString(4), null, rs.getInt(6), rs.getInt(7));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		adapter.disConnect(conn, pstmt);
		return user;
	}

	// 이메일 중복 확인
	public User findUserByEmail(String email) {
		Connection conn = adapter.connect();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		User user = null;
		String sql = AccountConstants.FIND_USER_BY_EMAIL;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				user = new User(rs.getString(1), rs.getString(2),
						rs.getString(3), rs.getString(4), null, rs.getInt(6), rs.getInt(7));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		adapter.disConnect(conn, pstmt, rs);
		return user;
	}

	public Professor getProfessor(User user) {
		Connection conn = adapter.connect();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Professor professor = null;
		try {
			pstmt = conn.prepareStatement(AccountConstants.SELECT_PROFESSOR);
			pstmt.setString(1, user.getEmail());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				professor = new Professor(user, rs.getString(1));
			}
		} catch (Exception e) {
			adapter.disConnect(conn, pstmt, rs);
		}
		return professor;
	}

	public Staff getStaff(User user) {
		Connection conn = adapter.connect();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Staff staff = null;
		try {
			pstmt = conn.prepareStatement(AccountConstants.SELECT_STAFF);
			pstmt.setString(1, user.getEmail());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				staff = new Staff(user, rs.getInt(1));
			}
		} catch (Exception e) {
			adapter.disConnect(conn, pstmt, rs);
		}
		adapter.disConnect(conn, pstmt, rs);
		return staff;
	}

	public Student getStudent(User user) {
		Connection conn = adapter.connect();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Student student = null;
		try {
			pstmt = conn.prepareStatement(AccountConstants.SELECT_STUDENT);
			pstmt.setString(1, user.getEmail());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				student = new Student(user, rs.getString(1));
			}
		} catch (Exception e) {
			adapter.disConnect(conn, pstmt, rs);
		}
		adapter.disConnect(conn, pstmt, rs);
		return student;
	}

	public NonMember getNonMember(User user) {
		Connection conn = adapter.connect();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		NonMember nonMember = null;
		try {
			pstmt = conn.prepareStatement(AccountConstants.SELECT_NONMEMBER);
			pstmt.setString(1, user.getEmail());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				nonMember = new NonMember(user, rs.getInt(1));
			}
		} catch (Exception e) {
			adapter.disConnect(conn, pstmt, rs);
		}
		adapter.disConnect(conn, pstmt, rs);
		return nonMember;
	}

	public boolean isMemberEmail(String email, String name) {
		boolean result = false;
		Connection conn = adapter.connect();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			/* 학교사람인지 검증하는 쿼리 필요 */
			// result = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		adapter.disConnect(conn, pstmt, rs);
		return result;
	}

	public boolean isMemberId(String id, String name) {
		// TODO Auto-generated method stub
		boolean result = false;
		Connection conn = adapter.connect();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			/* 학교사람인지 검증하는 쿼리 필요 */
			// result = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		adapter.disConnect(conn, pstmt, rs);
		return result;
	}
}
