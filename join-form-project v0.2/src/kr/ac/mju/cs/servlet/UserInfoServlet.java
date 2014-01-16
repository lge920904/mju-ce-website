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
		String action = request.getParameter("action");
		System.out.println("action : " + request.getParameter("action"));

		/* 로그인 */
	 if (action.equals(ACTION.LOGIN.getAction())) {
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
				response.sendRedirect("login.jsp");
			}else{
			}
		}
	}
}
