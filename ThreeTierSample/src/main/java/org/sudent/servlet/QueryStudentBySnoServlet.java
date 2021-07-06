package org.sudent.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.student.entity.Student;
import org.student.service.IStudentService;
import org.student.service.impl.StudentServiceImpl;
@WebServlet("/QueryStudentBySnoServlet")
public class QueryStudentBySnoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public QueryStudentBySnoServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("utf-8");
		int no = Integer.parseInt(request.getParameter("sno")) ;
		IStudentService studentService = new StudentServiceImpl();
		Student student = studentService.queryStudentBySno(no);
		System.out.println(student);
		request.setAttribute("student", student);
		request.getRequestDispatcher("detailsPage.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
