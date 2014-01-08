import java.sql.Connection;

import javax.swing.ImageIcon;


public class AccountDB {
	private Connection con;

	private User user;
	private Student student;
	private Professor professor;
	private Staff staff;

	public void setConnection(Connection con){
		// TODO Auto-generated method stub
		this.con = con;
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

	/* 유저 삭제 */
	public void deleteUserData(User user) {
		// TODO Auto-generated method stub
		// 세션의 id나 email 정보로 delete하는 쿼리 작성 
	}

	/* 유저 정보 수정 */
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

	/* 회원가입시, 아이디 중복확인 */
	public boolean doubleCheckId(String id) {
		boolean result = false;
		// TODO Auto-generated method stub
		// id가 있는지 확인
		// 있으면 true, 없으면 false
		return result;
	}

	/* 회원가입시, 이메일 중복확인 */
	public boolean doubleCheckEmail(String email) {
		boolean result = false;
		// TODO Auto-generated method stub
		// email이 있는지 확인
		// 있으면 true, 없으면 false
		return result;
	}

	/* 교수,직원,학생에 따른 학번과 이름을 매치함 */
	public boolean validateMember(int authority, String id, String name) {
		// TODO Auto-generated method stub
		boolean result = false;

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
		boolean result = false;
		if(id.contains("@")){
			// 이메일로 아이디랑 비번 검증하는 부분
		}else{
			// 아이디로 검증
		}
		return result;
	}
}
