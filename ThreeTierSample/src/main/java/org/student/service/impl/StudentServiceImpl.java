package org.student.service.impl;

import java.util.List;

import org.student.dao.IStudentDao;
import org.student.dao.impl.StudentDaoImpl;
import org.student.entity.Student;
import org.student.service.IStudentService;

//ҵ���߼��� �ɲ��
public class StudentServiceImpl implements IStudentService{
	IStudentDao studentDao = new StudentDaoImpl();
	
	//����ѧ�������ж��Ƿ����ѧ����������ѧ��
	public boolean addStudent(Student student) {
		if(!studentDao.isExist(student.getSno())) {
			studentDao.addStudent(student);
			return true;
		}else {
     	   System.out.println(student.getSno()+ student.getSname()+student.getSage() +student.getSaddress());
			System.out.println("�����Ѵ��ڣ�����ʧ��!");
			return false;
		}
	}
	//ɾ��ѧ�������ж��Ƿ����ѧ������ɾ��ѧ��
	public boolean deleteStudentBySno(int sno) {
		if(studentDao.isExist(sno)) {
			return studentDao.deleteStudentBySno(sno);
		}else {
			System.out.println("���˲����ڣ�ɾ��ʧ��!");
			return false;
		}
	}
	//����ѧ���޸�ѧ����Ϣ�����ж�ѧ���Ƿ���ڣ����޸�
	public boolean updateStudentBySno(int sno,Student student) {
		if(studentDao.isExist(sno)) {
			return studentDao.updateStudentBySno(sno, student);
		}else {
			System.out.println("���˲����ڣ��޸�ʧ��!");
			return false;
		}
	}
	//����ѧ�Ų�ѯѧ��
	public Student queryStudentBySno(int sno) {
		return studentDao.queryStudentBySno(sno);
	}
	//��ѯȫ��ѧ��
	public List<Student> queryAllStudent(){
		return studentDao.queryAllStudent();
	}
}
