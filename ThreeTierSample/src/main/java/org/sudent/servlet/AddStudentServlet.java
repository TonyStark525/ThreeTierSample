package org.sudent.servlet;

//��ʾ�㣺Servlet
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.student.entity.Student;
import org.student.service.IStudentService;
import org.student.service.impl.StudentServiceImpl;

@WebServlet("/AddStudentServlet")
public class AddStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public AddStudentServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			response.setCharacterEncoding("utf-8");
			int no = Integer.parseInt(request.getParameter("sno")) ;
			String name = request.getParameter("sname");
			int age = Integer.parseInt(request.getParameter("sage"));
			String address = request.getParameter("saddress");
			Student student = new Student(no,name,age,address);
			//�ӿ� - = new ʵ����();
			IStudentService studentService = new StudentServiceImpl();
			boolean rs = studentService.addStudent(student);
			if(rs) {
				response.sendRedirect("QueryAllStudentServlet");
			}else {
				out.println("����ʧ�ܣ�");
			}
//
//			StudentDao studentDao = new StudentDao();
//			Student student1 = studentDao.queryStudentBySno(no);
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
