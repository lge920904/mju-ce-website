package kr.ac.mju.cs.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.mju.cs.constants.Alter;
import kr.ac.mju.cs.tool.Account;
import kr.ac.mju.cs.tool.EmailSender;
/**
 * Servlet implementation class UserJoinServlet
 */
@WebServlet("/UserJoinServlet")
public class UserJoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * Default constructor. 
	 */
	
	private Account account = new Account();
	private String authenticode = null;
	
	public UserJoinServlet() {
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();

		String query = request.getParameter("query");
		String action = request.getParameter("action");
		
		System.out.println("query : "+query);
		System.out.println("action : "+action);
		
		if(action.equals("id")){
			if(account.findUserId(query))
				out.println(Alter.WRONG_ALTER_OPEN_SPAN + Alter.ACCOUNT_ALREADY_ACTIVE_MESSAGE + Alter.CLOSE_SPAN); 
		}else if(action.equals("password")){
			if(!query.equals(request.getParameter("password")))
				out.println(Alter.RIGHT_ALTER_OPEN_SPAN+Alter.LEGAL_PASSWORD_ALTER_MESSAGE+Alter.CLOSE_SPAN);
		}else if(action.equals("stuid")){
			String name = request.getParameter("name");
			if(query.length() < 6 || query.length() > 20){
				out.println("<span> id length error </span>"); 
			}else{
				out.println("<span> id length ok </span>");
			}
		}else if(action.equals("email")){ 
			authenticode = new Random().nextInt(999999)+"";
			new EmailSender().sendMail(query+"@mju.ac.kr", authenticode);
		}else if(action.equals("email-confirm")){
			if(query.equals(authenticode)){
				out.println(Alter.RIGHT_ALTER_OPEN_SPAN+Alter.LEGAL_AUTHENTICODE_MESSAGE+Alter.CLOSE_SPAN);
			}
		}
		out.close();
	}

}
