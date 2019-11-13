package service;

import java.util.List;

import entity.Page;
import entity.Student;

public interface StudentService {
	
	public void add(Student student);
	
	public List<Student> list();
	
	public void delete(String studentId);
	
	public Student get(String studentId);
	
	public void edit(Student student);
	
	public Page<Student> page(int pageCurrent);

}
