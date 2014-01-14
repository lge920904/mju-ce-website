package kr.ac.mju.cs.servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.ac.mju.cs.bean.Professor;
import kr.ac.mju.cs.bean.Staff;
import kr.ac.mju.cs.bean.Student;
import kr.ac.mju.cs.bean.User;
import kr.ac.mju.cs.controller.AccountController;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class UserInfoServlet
 */
@WebServlet("/UserInfoServlet")
public class UserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

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
	private final static int MAX_INACTIVE_INTERVAL = 60*30;

	public UserInfoServlet() {
		super();
		accountController = new AccountController();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

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
				// String department = request.getParameter("staff-department");
				Staff staff = new Staff(id, password, name, email, photo,
						CATEGORY.STAFF.getValue(),
						DEPARTMENT.SEOUL_ACCORD.getValue());
				accountController.createStaff(staff);
			} else if (category.equals(CATEGORY.NORMAL.getCategory())) {
				insertUser = new User(id, password, name, email, photo,
						CATEGORY.NORMAL.getValue());
				accountController.createUser(insertUser);
			} else {
				System.out.println("error");
			}
			request.setAttribute("id", id);
			request.setAttribute("name", name);
			request.setAttribute("email", email);
			response.sendRedirect("register.jsp");
			
		/* update */
		} else if (action.equals(ACTION.MODIFY.getAction())) {
			User modifyUser = null;
			int size = 10 * 1024 * 1024;

			MultipartRequest modifyMultipart = new MultipartRequest(request,
					uploadPath, size, "UTF-8", new DefaultFileRenamePolicy());

			String id = modifyMultipart.getParameter("user-id");
			String password = modifyMultipart.getParameter("user-password");
			String name = modifyMultipart.getParameter("user-name");
			String email = modifyMultipart.getParameter("user-email");
			String photoPath = "/default.jpg";
			File photo = new File(uploadPath + photoPath);
			String category = modifyMultipart.getParameter("user-category");

			if (category.equals(CATEGORY.STUDENT.getCategory())) {
				String study = modifyMultipart.getParameter("student-study");
				Student student = new Student(id, password, name, email, photo,
						CATEGORY.STUDENT.getValue(), study);
				accountController.modifyStudent(student);
			} else if (category.equals(CATEGORY.PROFESSOR.getCategory())) {
				String major = modifyMultipart.getParameter("professor-major");
				Professor professor = new Professor(id, password, name, email,
						photo, CATEGORY.PROFESSOR.getValue(), major);
				accountController.modifyProfessor(professor);
			} else if (category.equals(CATEGORY.STAFF.getCategory())) {
				// String department = request.getParameter("staff-department");
				Staff staff = new Staff(id, password, name, email, photo,
						CATEGORY.STAFF.getValue(),
						DEPARTMENT.SEOUL_ACCORD.getValue());
				accountController.modifyStaff(staff);
			} else if (category.equals(CATEGORY.NORMAL.getCategory())) {
				modifyUser = new User(id, password, name, email, photo,
						CATEGORY.NORMAL.getValue());
				accountController.modifyUser(modifyUser);
			}
			
		/* delete */
		} else if(action.equals(ACTION.DELETE.getAction())){
			HttpSession session = request.getSession();
			User user = (User)session.getAttribute("sessionUser");
			accountController.deleteUser(user.getId());
			response.sendRedirect("index.jsp");
			
		/* login */
		} else if (action.equals(ACTION.LOGIN.getAction())) {
			String id = request.getParameter("user-id");
			String password = request.getParameter("user-password");
			User user = null;
			HttpSession session = request.getSession();

			if((user = accountController.validateLoginInfo(id, password))!=null){
				if(user.getCategory() == 1){
					user = accountController.setSessionProfessor(user);
				}else if(user.getCategory() == 2){
					user = accountController.setSessionStaff(user);
				}else if(user.getCategory() == 3){
					user = accountController.setSessionStudent(user);
				}
				session.setAttribute("sessionUser", user);
				session.setMaxInactiveInterval(MAX_INACTIVE_INTERVAL ); //session 30분 유지.
				response.sendRedirect("index.jsp");
			}else{
			}
		}
	}
}
