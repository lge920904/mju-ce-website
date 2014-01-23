//package kr.ac.mju.cs.servlet;
//
//import java.io.File;
//import java.io.IOException;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import kr.ac.mju.cs.bean.Professor;
//import kr.ac.mju.cs.bean.Staff;
//import kr.ac.mju.cs.bean.Student;
//import kr.ac.mju.cs.bean.User;
//import kr.ac.mju.cs.controller.AccountController;
//
//import com.oreilly.servlet.MultipartRequest;
//import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
//
///**
// * Servlet implementation class UserModifyServlet
// */
//@WebServlet("/UserModifyServlet")
//public class UserModifyServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//
//	private enum ACTION {
//		JOIN("join"), MODIFY("modify"), DELETE("delete"), LOGIN("login"), LOGOUT("logout");
//		private String action;
//		private ACTION(String action){
//			this.action = action;
//		}
//		public String getAction() {
//			return action;
//		}
//	}
//	private enum DEPARTMENT {
//		SEOUL_ACCORD(1, "seoul-accord"), DISTRIBUTIVE(2, "destributive"), ENGINEERING_AUTHENTICATION(
//				3, "engineering-authentication");
//		int value;
//		String department;
//		private DEPARTMENT(int value, String department) {
//			this.value = value;
//			this.department = department;
//		}
//		public int getValue() {
//			return value;
//		}
//		public String getDepartment() {
//			return department;
//		}
//	}
//
//	private enum CATEGORY {
//		PROFESSOR(1, "professor"), STAFF(2, "staff"), STUDENT(3, "student"), NORMAL(
//				4, "normal");
//		int value;
//		String category;
//
//		private CATEGORY(int value, String category) {
//			this.value = value;
//			this.category = category;
//		}
//		public int getValue() {
//			return value;
//		}
//		public String getCategory() {
//			return category;
//		}
//	}
//
//	private AccountController accountController;
//	public UserModifyServlet() {
//		super();
//		accountController = new AccountController();
//	}
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("UTF-8");
//		response.setCharacterEncoding("UTF-8");
//		String uploadPath = getServletContext().getRealPath(
//				"/resources/images/");
//
//		String action = request.getParameter("action");
//		System.out.println("action : " + request.getParameter("action"));
//
//		if (action.equals(ACTION.MODIFY.getAction())) {
//			User modifyUser = null;
//			int size = 10 * 1024 * 1024;
//
//			MultipartRequest modifyMultipart = new MultipartRequest(request,
//					uploadPath, size, "UTF-8", new DefaultFileRenamePolicy());
//
//			String id = modifyMultipart.getParameter("user-id");
//			String password = modifyMultipart.getParameter("user-password");
//			String name = modifyMultipart.getParameter("user-name");
//			String email = modifyMultipart.getParameter("user-email");
//			String photoPath = "/default.jpg";
//			File photo = new File(uploadPath + photoPath);
//			String category = modifyMultipart.getParameter("user-category");
//
//			if (category.equals(CATEGORY.STUDENT.getCategory())) {
//				String study = modifyMultipart.getParameter("student-study");
//				Student student = new Student(id, password, name, email, photo,
//						CATEGORY.STUDENT.getValue(), study);
//				accountController.modifyStudent(student);
//			} else if (category.equals(CATEGORY.PROFESSOR.getCategory())) {
//				String major = modifyMultipart.getParameter("professor-major");
//				Professor professor = new Professor(id, password, name, email,
//						photo, CATEGORY.PROFESSOR.getValue(), major);
//				accountController.modifyProfessor(professor);
//			} else if (category.equals(CATEGORY.STAFF.getCategory())) {
//				// String department = request.getParameter("staff-department");
//				Staff staff = new Staff(id, password, name, email, photo,
//						CATEGORY.STAFF.getValue(),
//						DEPARTMENT.SEOUL_ACCORD.getValue());
//				accountController.modifyStaff(staff);
//			} else if (category.equals(CATEGORY.NORMAL.getCategory())) {
//				modifyUser = new User(id, password, name, email, photo,
//						CATEGORY.NORMAL.getValue());
//				accountController.modifyUser(modifyUser);
//			}
//		}
//	}
//}
