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

import kr.ac.mju.cs.bean.Professor;
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

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	private AccountController accountController;

	public UserJoinServlet() {
		super();
		// TODO Auto-generated constructor stub
		accountController = new AccountController();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String uploadPath = getServletContext().getRealPath(
				"/resources/images/");
		PrintWriter out = response.getWriter();

		String action = request.getParameter("action");
		System.out.println("action : " + request.getParameter("action"));

		if (action.equals("isMember")) {
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			System.out.println("inmember" + id + name);
			if (!accountController.isMemberId(id, name)
					&& !accountController.doubleCheckId(id)) {
				out.println(true);
			}
		} else if (action.equals("doubleCheckId")) {
			String id = request.getParameter("id");
			if (!accountController.doubleCheckId(id)) {
				out.println(true);
			}
		} else if (action.equals("passwordCertify")) {
			String pw1 = request.getParameter("pw");
			String pw2 = request.getParameter("pwc");
			if (pw1.equals(pw2)) {
				out.println(true);
			}
		} else if (action.equals("isMemberEmail")) {
			String email = request.getParameter("email");
			String name = request.getParameter("name");
			if (!accountController.isMemberEmail(email, name)
					&& !accountController.doubleCheckEmail(email)) {
				System.out.println("email2 : " + email + name);
				String authenticode = makeRandomString();
				request.getSession().setAttribute("authenticode", authenticode);
				EmailSender emailSender = new EmailSender();
				emailSender.sendMail(email, authenticode);
				out.println(true);
			}
		} else if (action.equals("doubleCheckEmail")) {
			String email = request.getParameter("user-non-member-email");
			if (!accountController.doubleCheckEmail(email)) {
				String authenticode = makeRandomString();
				request.getSession().setAttribute("authenticode", authenticode);
				EmailSender emailSender = new EmailSender();
				emailSender.sendMail(email, authenticode);
				out.println(true);
			}
		} else if (action.equals("emailCertify")) {
			String confirm = request.getParameter("authcode");
			if (confirm.equals(request.getSession()
					.getAttribute("authenticode"))) {
				out.println(true);
			}
		} else if (action.equals("member-join")) {
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

			System.out.println(id + "," + password + "," + name + "," + email
					+ "," + category);

			if (category.equals("member")) {
				Student student = new Student(id, password, name, email, photo,	3, "");
				accountController.createStudent(student);
			} else if (category.equals("non-member")) {
				User user = new User(id, password, name, email, photo, 4);
				accountController.createUser(user);
			}
			response.sendRedirect("register.jsp");
		}
		else if (action.equals("non-member-join")) {
			
		}
	}

	private String makeRandomString() {
		// TODO Auto-generated method stub
		String randomString = "";
		for (int i = 0; i < 4; i++) {
			randomString += (int) (new Random().nextInt(10));
		}
		return randomString;
	}
}
