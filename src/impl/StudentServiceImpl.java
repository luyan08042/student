package impl;

import java.util.ArrayList;
import java.util.List;

import dao.StudentDao;
import entity.Page;
import entity.Student;
import service.StudentService;

public class StudentServiceImpl implements StudentService{
	
	private StudentDao studentDao=new StudentDao();

	@Override
	public void add(Student student) {
		// TODO Auto-generated method stub
		String sql="insert into student values (student_s.nextval,?,?,?,?,'123',?)";
		List<Object> list=new ArrayList<Object>();
		list.add(student.getStudentName());
		list.add(student.getAge());
		list.add(student.getGender());
		list.add(student.getScore());
		list.add(student.getCode());
		studentDao.add(sql, list);
	}

	@Override
	public List<Student> list() {
		// TODO Auto-generated method stub
		String sql="select * from student order by code asc";
		List<Student> studentList=new ArrayList<Student>();
		studentList=studentDao.list(sql);
		return studentList;
	}

	@Override
	public void delete(String studentId) {
		// TODO Auto-generated method stub
		String sql="delete student where student_id=?";
		studentDao.delete(sql,studentId);
	}

	@Override
	public Student get(String studentId) {
		// TODO Auto-generated method stub
		String sql="select * from student where student_id=?";
		
		Student student=studentDao.get(sql,studentId);
		return student;
	}

	@Override
	public void edit(Student student) {
		// TODO Auto-generated method stub
		String sql="update student set student_name=?,age=?,gender=?,score=?,code=? where student_id=?";
		List<Object> list=new ArrayList<Object>();
		list.add(student.getStudentName());
		list.add(student.getAge());
		list.add(student.getGender());
		list.add(student.getScore());
		list.add(student.getCode());
		list.add(student.getStudentId());
		
		studentDao.edit(sql,list);
	}

	@Override
	public Page<Student> page(int pageCurrent) {
		// TODO Auto-generated method stub
		String sql="(select * from student order by code asc)";
		Page<Student> page = studentDao.page(sql,pageCurrent);
		return page;
	}

}
