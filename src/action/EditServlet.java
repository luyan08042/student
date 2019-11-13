package action;

import impl.StudentServiceImpl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Student;

import service.StudentService;

/**
 * Servlet implementation class editServlet
 */
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		StudentService studentService=new StudentServiceImpl();
		String studentId=request.getParameter("studentId");
		Student student=studentService.get(studentId);
		StringBuffer html=new StringBuffer();
		html.append("<form  action='/student01/edit' method='post'> ");
		html.append("<input type='hidden' name='studentId'  value="+student.getStudentId()+"><br>");
		html.append("学号：<input type='text' name='code' value="+student.getCode()+"><br>");
		html.append("姓名：<input type='text' name='studentName' value="+student.getStudentName()+"><br>");
		html.append("年龄：<input type='text' name='age' value="+student.getAge()+"><br>");
		html.append("性别：<input type='text' name='gender' value="+student.getGender()+"><br>");
		html.append("成绩：<input type='text' name='score' value="+student.getScore()+"><br>");
		html.append("<input type='submit' name='更新'></form>");
		
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write(html.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		StudentService studentService=new StudentServiceImpl();
		Student student=new Student();
		student.setStudentName(request.getParameter("studentName"));
		student.setAge(Integer.valueOf(request.getParameter("age")));
		student.setGender(request.getParameter("gender"));
		student.setScore(Integer.valueOf(request.getParameter("score")));
		student.setCode(request.getParameter("code"));
		student.setStudentId(request.getParameter("studentId"));
		studentService.edit(student);
		response.sendRedirect("/student01/list");
	}

}
