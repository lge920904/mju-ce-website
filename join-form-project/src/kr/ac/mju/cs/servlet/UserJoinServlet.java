package kr.ac.mju.cs.servlet;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.mju.cs.bean.Professor;
import kr.ac.mju.cs.bean.Staff;
import kr.ac.mju.cs.bean.Student;
import kr.ac.mju.cs.bean.User;
import kr.ac.mju.cs.controller.AccountController;
import kr.ac.mju.cs.tool.EmailSender;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class UserJoinServlet
 */
@WebServlet("/UserJoinServlet")
public class UserJoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private enum ACTION {
		JOIN("join"), MODIFY("modify"), DELETE("delete"), LOGIN("login"), LOGOUT("logout");
		private String action;
		private ACTION(String action){
			this.action = action;
		}
		public String getAction() {
			return action;
		}
	}
	private enum DEPARTMENT {
		SEOUL_ACCORD(1, "seoul-accord"), DISTRIBUTIVE(2, "destributive"), ENGINEERING_AUTHENTICATION(
				3, "engineering-authentication");
		int value;
		String department;
		private DEPARTMENT(int value, String department) {
			this.value = value;
			this.department = department;
		}
		public int getValue() {
			return value;
		}
		public String getDepartment() {
			return department;
		}
	}

	private enum CATEGORY {
		PROFESSOR(1, "professor"), STAFF(2, "staff"), STUDENT(3, "student"), NORMAL(
				4, "normal");
		int value;
		String category;

		private CATEGORY(int value, String category) {
			this.value = value;
			this.category = category;
		}
		public int getValue() {
			return value;
		}
		public String getCategory() {
			return category;
		}
	}

	private AccountController accountController;
	public UserJoinServlet() {
		super();
		accountController = new AccountController();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String uploadPath = getServletContext().getRealPath(
				"/resources/images/");

		String action = request.getParameter("action");
		System.out.println("action : " + request.getParameter("action"));

		/* insert */
		if (action.equals(ACTION.JOIN.getAction())) {
			User insertUser = null;
			int size = 10 * 1024 * 1024;

			MultipartRequest insertMultipart = new MultipartRequest(request,
					uploadPath, size, "UTF-8", new DefaultFileRenamePolicy());

			String id = insertMultipart.getParameter("user-id");
			String password = insertMultipart.getParameter("user-password");
			String name = insertMultipart.getParameter("user-name");
			String email = insertMultipart.getParameter("user-email");
			String photoPath = "/default.jpg";
			File photo = new File(uploadPath + photoPath);
			String category = insertMultipart.getParameter("user-category");
			
			System.out.println(id + "," + password  + "," + name  + "," + email  + "," + category);

			if (category.equals(CATEGORY.STUDENT.getCategory())) {
				String study = insertMultipart.getParameter("student-study");
				Student student = new Student(id, password, name, email, photo,
						CATEGORY.STUDENT.getValue(), study);
				accountController.createStudent(student);
			} else if (category.equals(CATEGORY.PROFESSOR.getCategory())) {
				String major = insertMultipart.getParameter("professor-major");
				Professor professor = new Professor(id, password, name, email,
						photo, CATEGORY.PROFESSOR.getValue(), major);
				accountController.createProfessor(professor);
			} else if (category.equals(CATEGORY.STAFF.getCategory())) {
				Staff staff = new Staff(id, password, name, email, photo,
						CATEGORY.STAFF.getValue(),
						DEPARTMENT.SEOUL_ACCORD.getValue());
				accountController.createStaff(staff);
			} else if (category.equals(CATEGORY.NORMAL.getCategory())) {
				insertUser = new User(id, password, name, email, photo,
						CATEGORY.NORMAL.getValue());
				accountController.createUser(insertUser);
			}
			response.sendRedirect("register.jsp");
		}
		else if(action.equals("isMember")){
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			//if(!accountController.doubleCheckId(id) && accountController.isMember(id,name)){
				response.getWriter().println(true);
			//}
		}
		else if(action.equals("passwordCertify")){
			String pw1 = request.getParameter("pw");
			String pw2 = request.getParameter("pwc");
			if(pw1.equals(pw2)){
				response.getWriter().println(true);
			}
		}
		else if(action.equals("emailCertify")){
			String email = request.getParameter("email");
			if(!accountController.doubleCheckEmail(email)){
				String authenticode = makeRandomString();
				request.getSession().setAttribute("authenticode", authenticode);
				EmailSender emailSender = new EmailSender();
				emailSender.sendMail(email, authenticode);
				response.getWriter().println(true);
			}else{
				response.getWriter().println(false);
			}
		}
		else if(action.equals("emailAuthcodeCertify")){
			String confirm = request.getParameter("auth");
			if(confirm.equals(request.getSession().getAttribute("authenticode"))){
				response.getWriter().println(true);
			}
		}
	}
	private String makeRandomString() {
		// TODO Auto-generated method stub
		String randomString = "";
		for(int i = 0; i<4; i++){
			randomString += (int)(new Random().nextInt(10));
		}
		return randomString;
	}
}
