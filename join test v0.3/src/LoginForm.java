import javax.swing.ImageIcon;



public class LoginForm {
	private User user;
	private Account account;
	private String id = "lge920904";
	private String password = "1234";
	private String name = "leegaeul";
	private String email = "lge920904@naver.com";
	private ImageIcon photo = null;
	private String filePath = "./default.jpg";
	private int[] athority = {1,2,3,4};
	// student
	private Student student;
	private String study = "MAP";
	// professor
	private Professor professor;
	private String major = "object oriented programming";
	// staff
	private Staff staff;
	private String department = "seoul accord";

	public LoginForm(){
		account = new Account();
		// 이미지 리사이징
		photo = account.resizeProfileImage(filePath);

		student = new Student(id, password, name, email, photo, athority[0], study);
		professor = new Professor(id, password, name, email, photo, athority[1], major);
		staff = new Staff(id, password, name, email, photo, athority[2], department);
		user = new User(id, password, name, email, photo, athority[3]);
		
		// 유저 생성
		account.createUser(student);
		account.createUser(professor);
		account.createUser(staff);
		account.createUser(user);
	}

	static public void main(String args[]){
		new LoginForm();

	}
}