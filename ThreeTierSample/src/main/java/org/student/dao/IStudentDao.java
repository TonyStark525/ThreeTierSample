package org.student.dao;

import java.util.List;

import org.student.entity.Student;

public interface IStudentDao {
	public boolean isExist(int sno);
	
	//删除学生
	public boolean deleteStudentBySno(int sno) ;
	//增加学生
	public boolean addStudent(Student student);
	
	//根据学号查找学生
	public Student queryStudentBySno(int sno);
	
	//查询全部学生
	public List<Student> queryAllStudent() ;
	//根据学号修改学生信息
	public boolean updateStudentBySno(int sno,Student student) ;
}
