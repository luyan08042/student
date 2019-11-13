package action;

import impl.StudentServiceImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Student;

import service.StudentService;

/**
 * Servlet implementation class ListServlet
 */
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		StudentService studentService = new StudentServiceImpl();
		List<Student> studentList=studentService.list();
		StringBuffer html=new StringBuffer();
		html.append("<table align='center' border='1' cellspacing='0'><tr><td>学号</td><td>姓名</td><td>年龄</td><td>性别</td><td>成绩</td></tr>");
		for(int i=0;i<studentList.size();i++){
			html.append("<tr><td>"+studentList.get(i).getCode()+"</td><td>"+studentList.get(i).getStudentName()+"</td><td>"+
					studentList.get(i).getAge()+"</td><td>"+studentList.get(i).getGender()+"</td><td>"+studentList.get(i).getScore()
					+"</td><td><a href='/student01/edit?studentId="+studentList.get(i).getStudentId()+"'>编辑</td>" +
							"<td><a href='/student01/delete?studentId="+studentList.get(i).getStudentId()+"'>删除</td></tr>");
		}
		html.append("</table><div align='center'><a href='/student01/add'>增加</div>");
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write(html.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
