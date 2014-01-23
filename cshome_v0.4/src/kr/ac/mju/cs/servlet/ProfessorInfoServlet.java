package kr.ac.mju.cs.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.sun.mail.handlers.multipart_mixed;

import kr.ac.mju.cs.bean.Professor;
import kr.ac.mju.cs.controller.ProfInfoController;

/**
 * Servlet implementation class ProfessorInfoServlet
 */
@WebServlet("/ProfessorInfoServlet")
public class ProfessorInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfessorInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProfInfoController profInfo = new ProfInfoController();
		ArrayList<Professor> profList = profInfo.selecProfInfo();
		request.setAttribute("profList", profList);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/profinfo.jsp");
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		ProfInfoController profInfo = new ProfInfoController();
		
		String id = request.getParameter("user-id");
		String email = request.getParameter("user-email");
		String engName = request.getParameter("prof-engName");
		System.out.println(id);
		String position = new String(request.getParameter("prof-position").getBytes("iso-8859-1"), "UTF-8");
		String roomPhone = request.getParameter("prof-roomPhone");
		String comment = new String(request.getParameter("prof-comment").getBytes("iso-8859-1"), "UTF-8");
		String homepage = request.getParameter("prof-homepage");
		String major = new String(request.getParameter("prof-major").getBytes("iso-8859-1"), "UTF-8");
		

		Professor prof = new Professor(id, email, engName, position, roomPhone, comment, homepage, major);
		profInfo.modifyProfInfo(prof);
		
		response.sendRedirect("ProfessorInfoServlet");
	}

}
