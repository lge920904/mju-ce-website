package kr.ac.mju.cs.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.ac.mju.cs.bean.User;
import kr.ac.mju.cs.controller.AccountController;


@WebServlet("/UserDeleteServlet")
public class UserDeleteServlet extends HttpServlet {
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
	private AccountController accountController;
	public UserDeleteServlet() {
		super();
		accountController = new AccountController();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		System.out.println("action : " + request.getParameter("action"));

		if(action.equals(ACTION.DELETE.getAction())){
			HttpSession session = request.getSession();
			User user = (User)session.getAttribute("sessionUser");
			accountController.deleteUser(user.getId());
			response.sendRedirect("index.jsp");
		}
	}

}
