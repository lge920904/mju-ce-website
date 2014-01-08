package kr.ac.mju.cs.tool;

public class Account {
	private DBAdapter dbAdapter;
	
	public Account(){
		dbAdapter = new DBAdapter();
	}
	
	// 회원가입할 때 아이디 중복 체크
	public boolean findUserId(String userId){
		boolean result = false;
		dbAdapter.connect();
		if(dbAdapter.findUserId(userId)){
			result = true;
		}
		dbAdapter.disconnect();
		return result;
	}

	// 로그인할때 아이디 비밀번호 검증
	public boolean login(String userId, String password) {
		// TODO Auto-generated method stub
		boolean result = false;
		//dbAdapter.connect();
		if(dbAdapter.login(userId, password)){
			result = true;
		}
		//dbAdapter.disconnect();
		return result;
	}
}
