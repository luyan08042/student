package action;

import impl.StudentServiceImpl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Page;
import entity.Student;

import service.StudentService;

/**
 * Servlet implementation class PageServlet
 */
public class PageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		StudentService studentService=new StudentServiceImpl();
		int pageCurrent=Integer.valueOf(request.getParameter("pageCurrent")!=null?request.getParameter("pageCurrent"):"1");
		Page<Student> page=studentService.page(pageCurrent);
		
		List<Student> studentList=page.getList();
		StringBuffer html=new StringBuffer();
		html.append("<table align='center' border='1' cellspacing='0'><tr><td>学号</td><td>姓名</td></tr>");
		for(int i=0;i<studentList.size();i++){
			html.append("<tr><td>"+studentList.get(i).getCode()+"</td><td>"+studentList.get(i).getStudentName()+"</td></tr>");
		}
		html.append("</table><div align='center'>");
		if(pageCurrent>1){
			html.append("<a href='/student01/page?pageCurrent=1'>首页</a> ");
			html.append("<a href='/student01/page?pageCurrent="+(pageCurrent-1)+"'>上一页</a>  ");
		}
		for(int i=0;i<page.getPageCount();i++){
			html.append("<a href='/student01/page?pageCurrent="+(i+1)+"'>"+(i+1)+"</a>  ");
		}
		if(pageCurrent<page.getPageCount()){
			html.append("<a href='/student01/page?pageCurrent="+(pageCurrent+1)+"'>下一页</a>");
			html.append(" <a href='/student01/page?pageCurrent="+ page.getPageCount() +"'>末页</a> ");
		}
		html.append("第 【"+page.getPageCurrent()+"】页</div>");
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().write(html.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
