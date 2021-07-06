package org.student.service.impl;

import java.util.List;

import org.student.dao.IStudentDao;
import org.student.dao.impl.StudentDaoImpl;
import org.student.entity.Student;
import org.student.service.IStudentService;

//业务逻辑层 可拆分
public class StudentServiceImpl implements IStudentService{
	IStudentDao studentDao = new StudentDaoImpl();
	
	//增加学生，先判断是否存在学生，在增加学生
	public boolean addStudent(Student student) {
		if(!studentDao.isExist(student.getSno())) {
			studentDao.addStudent(student);
			return true;
		}else {
     	   System.out.println(student.getSno()+ student.getSname()+student.getSage() +student.getSaddress());
			System.out.println("此人已存在！增加失败!");
			return false;
		}
	}
	//删除学生，先判断是否存在学生，在删除学生
	public boolean deleteStudentBySno(int sno) {
		if(studentDao.isExist(sno)) {
			return studentDao.deleteStudentBySno(sno);
		}else {
			System.out.println("此人不存在！删除失败!");
			return false;
		}
	}
	//根据学号修改学生信息，先判断学生是否存在，在修改
	public boolean updateStudentBySno(int sno,Student student) {
		if(studentDao.isExist(sno)) {
			return studentDao.updateStudentBySno(sno, student);
		}else {
			System.out.println("此人不存在！修改失败!");
			return false;
		}
	}
	//根据学号查询学生
	public Student queryStudentBySno(int sno) {
		return studentDao.queryStudentBySno(sno);
	}
	//查询全部学生
	public List<Student> queryAllStudent(){
		return studentDao.queryAllStudent();
	}
}
