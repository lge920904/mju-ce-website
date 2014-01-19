package kr.ac.mju.cs.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.ac.mju.cs.bean.NonMember;
import kr.ac.mju.cs.bean.Professor;
import kr.ac.mju.cs.bean.Staff;
import kr.ac.mju.cs.bean.Student;
import kr.ac.mju.cs.bean.User;
import kr.ac.mju.cs.bean.User.ACTIVE;
import kr.ac.mju.cs.controller.AccountController;
import kr.ac.mju.cs.tool.EmailSender;

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
		LOGIN("login"), FIND_ID("findID"), FIND_PW("findPW"), DELETE("delete");
		private String action;

		private ACTION(String action) {
			this.action = action;
		}

		public String getAction() {
			return action;
		}
	}

	private AccountController accountController;
	private final static int MAX_INACTIVE_INTERVAL = 60 * 30;

	public UserInfoServlet() {
		super();
		accountController = new AccountController();
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
		PrintWriter out = response.getWriter();

		/* 로그인 */
		// 수정해야됌
		if (action.equals(ACTION.LOGIN.getAction())) {
			String id = request.getParameter("user-id");
			String password = request.getParameter("user-password");
			User user = null;
			HttpSession session = request.getSession();
			
			if(id.contains("@")){
				user = accountController.findUserByEmail(id);
			}else{
				user = accountController.findUserById(id);
			
			}
			System.out.println("user.category : " + user.getCategory());
			System.out.println("user.getActive : " + user.getActive());
			if(user.getPassword().equals(password) && user.getActive() == 2014){
				int category = user.getCategory();
				if(category == 1){
					Professor prof = accountController.getProfessor(user);
					session.setAttribute("sessionUser", prof);
				}else if(category == 2){
					Staff staff = accountController.getStaff(user);
					session.setAttribute("sessionUser", staff);
				}else if(category == 3){
					Student student = accountController.getStudent(user);
					session.setAttribute("sessionUser", student);
				}else if(category == 4){
					NonMember nonMember = accountController.getNonMember(user);
					session.setAttribute("sessionUser", nonMember);
				}
				System.out.println("login success! " + user.getId());
				response.sendRedirect("login.jsp");
				session.setMaxInactiveInterval(MAX_INACTIVE_INTERVAL);
			}
		} else if (action.equals(ACTION.FIND_ID.getAction())) {

		} else if (action.equals(ACTION.FIND_PW.getAction())) {
			String id = request.getParameter("id");
			User user = accountController.findUserById(id);
			if (user != null) {
				EmailSender emailSender = new EmailSender();
				String authenticode = makeRandomString();
				emailSender.sendMail(user.getEmail(), authenticode);
				user.setPassword(authenticode);
				user.setActive(ACTIVE.UNACTIVE.ordinal());
				accountController.modifyUser(user);
				out.println(true);
			} else {
				System.out.println("no email");
				out.println(false);
			}
		} else if(action.equals(ACTION.DELETE.getAction())){
			HttpSession session = request.getSession();
			User user = (User)session.getAttribute("sessionUser");
			accountController.deleteUser(user.getId());
			response.sendRedirect("index.jsp");
		}
	}

	private String makeRandomString() {
		// TODO Auto-generated method stub
		String randomString = "";
		for (int i = 0; i < 12; i++) {
			randomString += (int) (new Random().nextInt(10));
		}
		return randomString;
	}
}
