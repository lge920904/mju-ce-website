package kr.ac.mju.cs.servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
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

	public enum DEPARTMENT {
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

	public enum CATEGORY {
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

		User user = null;
		int size = 10 * 1024 * 1024;
		String uploadPath = getServletContext().getRealPath(
				"/resources/images/");
		System.out.println(uploadPath);
		MultipartRequest multipart = new MultipartRequest(request, uploadPath,
				size, "UTF-8", new DefaultFileRenamePolicy());

		String id = multipart.getParameter("user-id");
		String password = multipart.getParameter("user-password");
		String name = multipart.getParameter("user-name");
		String email = multipart.getParameter("user-email");
		String photoPath = "/default.jpg";
		File photo = new File(uploadPath + photoPath);
		String category = multipart.getParameter("user-category");

		System.out.println(photo.getAbsolutePath());
		System.out.println(category + " // " + id);
		if (category.equals(CATEGORY.STUDENT.getCategory())) {
			String study = multipart.getParameter("student-study");
			Student student = new Student(id, password, name, email, photo,
					CATEGORY.STUDENT.getValue(), study);
			accountController.createStudent(student);
		} else if (category.equals(CATEGORY.PROFESSOR.getCategory())) {
			String major = multipart.getParameter("professor-major");
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
			user = new User(id, password, name, email, photo,
					CATEGORY.NORMAL.getValue());

			accountController.createUser(user);
		} else {
			System.out.println("error");
		}

		/* RequestDispatcher rd = request.getRequestDispatcher("register.jsp"); */

		request.setAttribute("id", id);
		request.setAttribute("name", name);
		request.setAttribute("email", email);
		response.sendRedirect("register.jsp")/* (request, response) */;
	}
}
