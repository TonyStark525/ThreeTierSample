package org.student.dao;

import java.util.List;

import org.student.entity.Student;

public interface IStudentDao {
	public boolean isExist(int sno);
	
	//ɾ��ѧ��
	public boolean deleteStudentBySno(int sno) ;
	//����ѧ��
	public boolean addStudent(Student student);
	
	//����ѧ�Ų���ѧ��
	public Student queryStudentBySno(int sno);
	
	//��ѯȫ��ѧ��
	public List<Student> queryAllStudent() ;
	//����ѧ���޸�ѧ����Ϣ
	public boolean updateStudentBySno(int sno,Student student) ;
}
