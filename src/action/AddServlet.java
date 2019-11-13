package action;

import impl.StudentServiceImpl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.StudentService;

import entity.Student;

/**
 * Servlet implementation class AddServlet
 */
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("add.html").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		StudentService studentService=new StudentServiceImpl();
		
		Student student=new Student();
		student.setCode(request.getParameter("code"));
		student.setStudentName(request.getParameter("studentName"));
		student.setAge(Integer.valueOf(request.getParameter("age")));
		student.setGender(request.getParameter("gender"));
		student.setScore(Integer.valueOf(request.getParameter("score")));
		
		studentService.add(student);
		response.sendRedirect("/student01/list");
		
	}

}
