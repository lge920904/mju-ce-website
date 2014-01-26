package kr.ac.mju.cs.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.mju.cs.bean.NonMember;
import kr.ac.mju.cs.bean.Student;
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

	private AccountController accountController;

	public UserJoinServlet() {
		super();
		// TODO Auto-generated constructor stub
		accountController = new AccountController();
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();

		String action = request.getParameter("action");
		System.out.println("action : " + request.getParameter("action"));

		if (action.equals("isMember")) {
			System.out.println("들어왔어");
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			if (!accountController.isMemberId(id, name)
					&& accountController.findUserById(id) == null) {
				out.println(true);
			}
		}
		else if (action.equals("doubleCheckId")) {
			String id = request.getParameter("id");
			if (accountController.findUserById(id)  == null) {
				out.println(true);
			}
		} 
		else if (action.equals("passwordCertify")) {
			String pw1 = request.getParameter("pw");
			String pw2 = request.getParameter("pwc");
			if (pw1.equals(pw2)) {
				out.println(true);
			}
		} 
		else if (action.equals("isMemberEmail")) {
			String email = request.getParameter("email");
			String name = request.getParameter("name");
			if (!accountController.isMemberEmail(email, name)
					&& accountController.findUserByEmail(email)  == null) {
				String authenticode = makeRandomString();
				request.getSession().setAttribute("authenticode", authenticode);
				EmailSender emailSender = new EmailSender();
				emailSender.sendMail(email, authenticode);
				out.println(true);
			}
		} 
		else if (action.equals("doubleCheckEmail")) {
			String email = request.getParameter("email");
			if (accountController.findUserByEmail(email)  == null) {
				String authenticode = makeRandomString();
				request.getSession().setAttribute("authenticode", authenticode);
				EmailSender emailSender = new EmailSender();
				emailSender.sendMail(email, authenticode);
				out.println(true);
			}
		} 
		else if (action.equals("emailCertify")) {
			String confirm = request.getParameter("authcode");
			if (confirm.equals(request.getSession()
					.getAttribute("authenticode"))) {
				out.println(true);
			}
		} 
		else if (action.equals("member-join")) {
			int size = 10 * 1024 * 1024;
			String uploadPath = getServletContext().getRealPath(
					"/resources/images/");
			MultipartRequest multipartRequst = new MultipartRequest(request,
					uploadPath, size, "UTF-8", new DefaultFileRenamePolicy());

			String password = multipartRequst.getParameter("user-password");
			String photoPath = "/default.jpg";
			File photo = new File(uploadPath + photoPath);
			String category = multipartRequst.getParameter("user-category");

			if (category.equals("member")) {
				String id = multipartRequst.getParameter("user-member-id");
				String name = multipartRequst.getParameter("user-member-name");
				String email = multipartRequst.getParameter("user-member-email");
				Student student = new Student(id, password, name, email, photo,	3, "");
				accountController.createStudent(student);
			} else if (category.equals("non-member")) {
				String id = multipartRequst.getParameter("user-non-member-id");
				String name = multipartRequst.getParameter("user-non-member-name");
				String email = multipartRequst.getParameter("user-non-member-email");
				int option = Integer.parseInt(multipartRequst.getParameter("user-non-member-select"));
				NonMember nonMember = new NonMember(id, password, name, email, photo, 4, option);
				accountController.createNonMember(nonMember);
			}
			response.sendRedirect("register.jsp");
		}
	}

	private String makeRandomString() {
		String randomString = "";
		for (int i = 0; i < 4; i++) {
			randomString += (int) (new Random().nextInt(10));
		}
		return randomString;
	}
}
