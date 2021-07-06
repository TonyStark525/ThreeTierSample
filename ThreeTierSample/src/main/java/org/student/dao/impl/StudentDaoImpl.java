package org.student.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.student.dao.IStudentDao;
import org.student.entity.Student;
import org.student.util.DBUtil;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;


//���ݷ��ʲ㡪�������ݿ�
public class StudentDaoImpl implements IStudentDao{//ԭ���Եģ���ɾ�Ĳ� �޷����
	//����ѧ���ж��Ƿ���ڸ�ѧ�� 
	public boolean isExist(int sno) {
		return queryStudentBySno(sno)==null?false:true;
	}
	//DBUtil��ʵ��
	

	//����ѧ��
	public boolean addStudent(Student student){
		String sql = "insert into student(sno,sname,sage,saddress) values(?,?,?,?)";
		Object[] params = {student.getSno(),student.getSname(),student.getSage(),student.getSaddress() };
		return DBUtil.executeUpdate(sql, params);
	}
	
	//ɾ��ѧ��
	public boolean deleteStudentBySno(int sno) {
		String sql = "delete from student where sno=?";
		Object[] params = {sno};
		return DBUtil.executeUpdate(sql, params);
	}
	
	//����ѧ���޸�ѧ����Ϣ
	public boolean updateStudentBySno(int sno,Student student) {
		String sql = "update student set sname=?,sage=?,saddress=? where sno=?";
		Object[] params = {student.getSname(),student.getSage(),student.getSaddress(),sno};
		return DBUtil.executeUpdate(sql, params);
	}
	

	
	
	//����ѧ�Ų���ѧ��
	public Student queryStudentBySno(int sno) {
		Student student = null;
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from student where sno = ?";
			Object[] params = {sno};
           rs = DBUtil.executeQuery(sql, params);
           if(rs.next()) {
        	   int no = rs.getInt("sno");
        	   String name = rs.getString("sname");
        	   int age = rs.getInt("sage");
        	   String address = rs.getString("saddress");
//        	   System.out.println(no+name+age+address);
        	   student = new Student(no,name,age,address);
           }
           return student;
           
        } catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(connection!=null)connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	//��ѯȫ��ѧ��
	public List<Student> queryAllStudent() {
		List<Student> students = new ArrayList<>();
		Student student = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from student";
			rs = DBUtil.executeQuery(sql, null);
           while(rs.next()) {
        	   int no = rs.getInt("sno");
        	   String name = rs.getString("sname");
        	   int age = rs.getInt("sage");
        	   String address = rs.getString("saddress");
        	   student = new Student(no,name,age,address);
        	   students.add(student);
           }
           return students;
           
        } catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(DBUtil.connection!=null)DBUtil.connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
