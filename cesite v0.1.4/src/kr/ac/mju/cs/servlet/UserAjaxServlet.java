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

import kr.ac.mju.cs.bean.User;
import kr.ac.mju.cs.tool.EmailSender;

/**
 * Servlet implementation class UserAjaxServlet
 */
@WebServlet("/UserAjaxServlet")
public class UserAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
    public UserAjaxServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		String authenticode = null;
		
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("sessionUser");
		String action = request.getParameter("action");
		
		if(action.equals("confirm-session-password")){
			if(user.getPassword().equals(request.getParameter("password"))){
				out.println("<span class='confirm'>비밀번호가 일치합니다.</span>");
			}
		}else if(action.equals("send-email")){
			String recipietion = request.getParameter("email");
			Math.random();
			EmailSender emailSender = new EmailSender();
			authenticode = makeRandomString();
			emailSender.sendMail(recipietion, authenticode);
			out.println(authenticode);
		}else if(action.equals("email-confirm")){
			
		}
	}

	private String makeRandomString() {
		// TODO Auto-generated method stub
		String randomString = "";
		for(int i = 0; i<4; i++){
			randomString += (int)(new Random().nextInt()) * 10;
		}
		return randomString;
	}

}
