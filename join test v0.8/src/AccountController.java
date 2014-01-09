public class AccountController {
	private Student student;
	private Professor professor;
	private Staff staff;

	private DBAdapter adapter;
	private AccountDB accountDB;
	private boolean result;
	
	public AccountController() {
		// TODO Auto-generated constructor stub
		accountDB = new AccountDB();
		adapter = new DBAdapter();
		result = false;
	}
	
	// 회원가입
	public boolean createUser(User user) {
		// TODO Auto-generated method stub
		result = false;
		accountDB.connect();
		if(accountDB.insertUserData(user)){
			result = true;
			return result;
		}
		accountDB.disConnect();
		return result;
	}
	
	// 회원탈퇴
	public boolean deleteUser(String idEmail){
		result = false;
		accountDB.connect();
		if(accountDB.deleteUserData(idEmail)){
			result = true;
			return result;
		}
		accountDB.disConnect();
		return result;
	}
	
	// 회원정보수정
	public boolean modifyUserData(User user){
		result = false;
		accountDB.connect();
		if(accountDB.modifyUserData(user)){
			result = true;
			return result;
		} 
		accountDB.disConnect();
		return result;
	}
	
	// 아이디 중복 확인
	public boolean doubleCheckId(String id) {
		// TODO Auto-generated method stub
		result = false;
		//accountDB.connect();
		accountDB.connect();
		if(accountDB.doubleCheckId(id)){
			result = true;
			return result;
		}
		accountDB.disConnect();
		return result;
	}

	// 이메일 중복 확인
	public boolean doubleCheckEmail(String email) {
		// TODO Auto-generated method stub
		result = false;
		accountDB.connect();
		if(accountDB.doubleCheckEmail(email)){
			result = true;
			return result;
		}
		accountDB.disConnect();
		return result;
	}
	
	/* 교수,직원,학생에 따른 학번과 이름을 매치함 */
	public boolean validateMember(int authority, String id, String name){
		result = false;
		accountDB.connect();
		if(accountDB.validateMember(authority, id, name)){
			result = true;
			return result;
		}
		accountDB.disConnect();
		return result;
	}
	
	// 로그인시 아이디 비번 확인
	public boolean validateLoginInfo(String id, String password) {
		// TODO Auto-generated method stub
		result = false;
		accountDB.connect();
		if(accountDB.validateLoginInfo(id, password)){
			result = true;
			return result;
		}
		accountDB.disConnect();
		return result;
	}
}

