package org.student.service;

import java.util.List;

import org.student.entity.Student;

public interface IStudentService {
	public boolean addStudent(Student student) ;
	//ɾ��ѧ�������ж��Ƿ����ѧ������ɾ��ѧ��
	public boolean deleteStudentBySno(int sno) ;
	//����ѧ���޸�ѧ����Ϣ�����ж�ѧ���Ƿ���ڣ����޸�
	public boolean updateStudentBySno(int sno,Student student) ;
	//����ѧ�Ų�ѯѧ��
	public Student queryStudentBySno(int sno) ;
	//��ѯȫ��ѧ��
	public List<Student> queryAllStudent();
}
