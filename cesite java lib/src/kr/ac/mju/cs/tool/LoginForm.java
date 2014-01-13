package kr.ac.mju.cs.tool;
import kr.ac.mju.cs.controller.AccountController;




public class LoginForm {
	private AccountController account;

	

	
	public LoginForm(){
		account = new AccountController();

		
	}

	static public void main(String args[]){
		new LoginForm();

	}
}