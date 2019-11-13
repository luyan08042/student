package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

import entity.Page;
import entity.Student;

public class StudentDao extends BaseDao{
	
	public void add(String sql,List<Object> list){
		try{
			PreparedStatement ps=getConn().prepareStatement(sql);
			for(int i=0;i<list.size();i++){
				ps.setObject((i+1), list.get(i));				
			}
			ps.execute();
			ps.close();
			closeConn();
		}catch(Exception e){
			e.printStackTrace();
		}		
	}
	
	public List<Student> list(String sql){
		List<Student> list=new ArrayList<Student>();
		try{
			PreparedStatement ps = getConn().prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Student student=new Student();
				student.setStudentId(rs.getString("student_id"));
				student.setStudentName(rs.getString("student_name"));
				student.setAge(rs.getInt("age"));
				student.setGender(rs.getString("gender"));
				student.setScore(rs.getInt("score"));
				student.setPassword(rs.getString("password"));
				student.setCode(rs.getString("code"));
				list.add(student);
			}
			ps.close();
			closeConn();
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	
	public void delete(String sql,String studentId){
		try{
			PreparedStatement ps = getConn().prepareStatement(sql);
			ps.setString(1, studentId);
			ps.execute();
			ps.close();
			closeConn();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public Student get(String sql,String studentId){
		Student student = new Student();
		try{
			PreparedStatement ps = getConn().prepareStatement(sql);
			ps.setString(1, studentId);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				student.setStudentId(rs.getString("student_id"));
				student.setStudentName(rs.getString("student_name"));
				student.setAge(rs.getInt("age"));
				student.setGender(rs.getString("gender"));
				student.setScore(rs.getInt("score"));
				student.setCode(rs.getString("code"));
			}
			ps.close();
			closeConn();
		}catch(Exception e){
			e.printStackTrace();
		}
		return student;
	}
	
	public void edit(String sql,List<Object> list){
		try{
			PreparedStatement ps=getConn().prepareStatement(sql);
			for(int i=0;i<list.size();i++){
				ps.setObject((i+1), list.get(i));
			}
			ps.execute();
			ps.close();
			closeConn();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public Page<Student> page(String sql,int pageCurrent){
		List<Student> studentList=new ArrayList<Student>();
		String countSql="select count(1) from"+sql;
		Long count=0L;
		
		String listSql="select * from(select A.*,ROWNUM RN from"+sql+"A where ROWNUM<=?) where RN>?";
		try{
			PreparedStatement ps=getConn().prepareStatement(countSql);
			ResultSet rs= ps.executeQuery();
			while(rs.next()){
				count=rs.getLong(1);
			}
			ps.close();
			closeConn();
			
			ps=getConn().prepareStatement(listSql);
			ps.setInt(1, 2+((pageCurrent-1)*2));
			ps.setInt(2, (pageCurrent-1)*2);
			rs=ps.executeQuery();
			while(rs.next()){
				Student student=new Student();
				student.setStudentId(rs.getString("student_id"));
				student.setStudentName(rs.getString("student_name"));
				student.setAge(rs.getInt("age"));
				student.setGender(rs.getString("gender"));
				student.setScore(rs.getInt("score"));
				student.setPassword(rs.getString("password"));
				student.setCode(rs.getString("code"));
				studentList.add(student);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		Page<Student> page=new Page<Student>(studentList, pageCurrent, count.intValue());
		return page;
	}

}
