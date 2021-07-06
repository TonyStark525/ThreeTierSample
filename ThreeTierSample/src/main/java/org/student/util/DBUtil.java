package org.student.util;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

//数据库的常见增删改查
public class DBUtil {
	private static final String URL = "jdbc:mysql://localhost:3306/student";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "123456";
	public static Connection connection = null;
	public static  PreparedStatement pstmt = null;

	//获取连接
	public static Connection getConnection() throws ClassNotFoundException ,SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		return (Connection) DriverManager.getConnection(URL,USERNAME,PASSWORD);
	}
	//
	public static PreparedStatement createPreParedStatement(String sql,Object[] params) throws ClassNotFoundException, SQLException {
		pstmt = (PreparedStatement) getConnection().prepareStatement(sql);
        if(params!=null) {
        for(int i=0;i<params.length;i++) {
				pstmt.setObject(i+1, params[i]);
			}
        }
        return pstmt;
	}
	
	//通用的增删改查
	public static boolean executeUpdate(String sql,Object[] params) {
		try {
			PreparedStatement pstmt = createPreParedStatement(sql,params);
			int count = pstmt.executeUpdate();
	           if(count > 0)
	        	   return true;
	           else
	        	   return false;
		}catch (SQLException e) {
			e.printStackTrace();
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(connection!=null)connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	//通用的查
	public static ResultSet executeQuery(String sql,Object[] params) {
		ResultSet rs = null;
		try {
			PreparedStatement pstmt1 = createPreParedStatement(sql,params);
           rs = pstmt1.executeQuery();
           return rs;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
