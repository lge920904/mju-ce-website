package tool;
import javax.swing.ImageIcon;

import controller.AccountController;


import bean.Professor;
import bean.Staff;
import bean.Student;
import bean.User;

public class LoginForm {
	private User user;
	private AccountController account;
	private String id = "hello3";
	private String password = "1234";
	private String name = "fuck";
	private String email = "hello3@naver.com";
	private ImageIcon photo = null;
	private String filePath = "./img/default.jpg";
	private int[] athority = {1,2,3,4};
	// student
	private Student student;
	private String study = "MAP";
	// professor
	private Professor professor;
	private String major = "object oriented programming";
	// staff
	private Staff staff;
	private int department = 1;

	private FileTool fileTool = new FileTool();
	
	/* 회원가입 순서
	 * 1. input을 입력받음.
	 * 2. doubleCheckId, doubleCheckEmail로 아이디와 이메일 중복확인함.
	 * 3. validateMember(authority, id, name)으로 학생or교수or직원임을 인증함.
	 * 4. return true -> 인증, false -> 실패
	 * 5. createUser(user)로 생성
	 */
	
	/* 회원정보 수정
	 * 1. validateLoginInfo(id, password)로 현재 세션등록된 유저인지 확인
	 * 2. 회원정보 수정
	 * 3. return true -> modifyUser(user), false -> 실패
	 */
	
	/* 회원 탈퇴
	 * 1. validateLoginInfo(id, password)로 현재 세션등록된 유저인지 확인
	 * 2. return true -> deleteUser(user), false -> 실패
	 */
	
	/* 로그인
	 * 1. validateLoginInfo(id, password)로 아이디 비밀번호 매치
	 * 2. return true -> 로그인 성공, false -> 실패
	 */
	
	public LoginForm(){
		account = new AccountController();
		// 이미지 리사이징
		photo = fileTool.resizeProfileImage(filePath);
		
		if(account.validateLoginInfo(id, password)){
			System.out.println("login");
		}
		
		
		/* 유저 생성 */
		if(!account.doubleCheckId(id) || !account.doubleCheckEmail(email)){
			user = new User(id, password, name, email, photo, athority[3]);

			account.createUser(user);
			System.out.println("create user");
			
		}else{
			System.out.println("아이디 혹은 이메일 중복");
		}

		/* 로그인*/
		account.validateLoginInfo(id, password);
		System.out.println("login");
		
		/* 유저 정보 수정 */
		user.setName("simson");
		user.setPassword("papapa");
		account.modifyUser(user);
		System.out.println("modify");
		
		/* 유저 삭제 */
		account.deleteUser(id);
		System.out.println("delete");
		
	}

	static public void main(String args[]){
		new LoginForm();

	}
}