package org.student.service;

import java.util.List;

import org.student.entity.Student;

public interface IStudentService {
	public boolean addStudent(Student student) ;
	//删除学生，先判断是否存在学生，在删除学生
	public boolean deleteStudentBySno(int sno) ;
	//根据学号修改学生信息，先判断学生是否存在，在修改
	public boolean updateStudentBySno(int sno,Student student) ;
	//根据学号查询学生
	public Student queryStudentBySno(int sno) ;
	//查询全部学生
	public List<Student> queryAllStudent();
}
