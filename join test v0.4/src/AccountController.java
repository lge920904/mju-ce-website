public class AccountController {
	private Student student;
	private Professor professor;
	private Staff staff;

	private DBAdapter adapter;
	private AccountDB accountDB;
	public AccountController() {
		// TODO Auto-generated constructor stub
		adapter = new DBAdapter();
		accountDB = new AccountDB();
	}
	
	// 회원가입
	public void createUser(User user) {
		// TODO Auto-generated method stub
		
		accountDB.setConnection(adapter.connect());
		accountDB.insertUserData(user);
		adapter.disConnect();
	}
	
	// 회원탈퇴
	public void deleteUser(User user){
		accountDB.setConnection(adapter.connect());
		accountDB.deleteUserData(user);
		adapter.disConnect();
	}
	
	// 회원정보수정
	public void modifyUserData(User user){
		accountDB.setConnection(adapter.connect());
		accountDB.modifyUserData(user);
		adapter.disConnect();
	}
	
	// 아이디 중복 확인
	public boolean doubleCheckId(String id) {
		// TODO Auto-generated method stub
		boolean result = false;
		accountDB.setConnection(adapter.connect());
		if(accountDB.doubleCheckId(id)){
			result = true;
			return result;
		}
		adapter.disConnect();
		return result;
	}

	// 이메일 중복 확인
	public boolean doubleCheckEmail(String email) {
		// TODO Auto-generated method stub
		boolean result = false;
		accountDB.setConnection(adapter.connect());
		if(accountDB.doubleCheckEmail(email)){
			result = true;
			return result;
		}
		adapter.disConnect();
		return result;
	}
	
	/* 교수,직원,학생에 따른 학번과 이름을 매치함 */
	public boolean validateMember(int authority, String id, String name){
		boolean result = false;
		accountDB.setConnection(adapter.connect());
		if(accountDB.validateMember(authority, id, name)){
			result = true;
			return result;
		}
		adapter.disConnect();
		return result;
	}
	
	// 로그인시 아이디 비번 확인
	public boolean validateLoginInfo(String id, String password) {
		// TODO Auto-generated method stub
		boolean result = false;
		accountDB.setConnection(adapter.connect());
		if(accountDB.validateLoginInfo(id, password)){
			result = true;
			return result;
		}
		adapter.disConnect();
		return result;
	}
}

