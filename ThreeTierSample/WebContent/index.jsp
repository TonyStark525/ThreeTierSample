<%@page import="org.student.entity.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index</title>
<style type="text/css">		
			table {
				width: 90%;
				background: #ccc;
				margin: 10px auto;
				border-collapse: collapse;/*border-collapse:collapse合并内外边距(去除表格单元格默认的2个像素内外边距*/	
			}				
			th{
				height: 25px;
				line-height: 25px;
				text-align: center;
				border: 1px solid #ccc;
			}		
			th {
				background: #eee;
				font-weight: normal;
			}		
			tr {
				background: #fff;
			}		
			tr:hover {
				background: #cc0;
			}		
		</style>
</head>
<body>
	<%

		request.setCharacterEncoding("utf-8");
		List<Student> students = (List<Student>)request.getAttribute("students");
		
	%>
	<table>
		<tr>
			<th>Student No</th>
			<th>Student Name</th>
			<th>Student Age</th>
			<th>Student Address</th>
			<th>Delete student</th>
			<th>Update student</th>
			<th>Details page</th>
		<tr>
		<%
			for(Student student:students){
		%>
		<tr>
			<th><%=student.getSno() %></th>
			<th><%=student.getSname() %></th>
			<th><%=student.getSage() %></th>
			<th><%=student.getSaddress() %></th>
			<th><a href="DeleteStudentServlet?sno=<%=student.getSno()%>">Delete</a></th>
			<th><a href="update.jsp?sno=<%=student.getSno()%>">Update</a></th>
			<th><a href="QueryStudentBySnoServlet?sno=<%=student.getSno()%>">Details</a></th>
		</tr>
		<%
			}
		%>
	</table>
	<a href="add.jsp" style="display: block; text-align: center;">Add Student</a>
</body>
</html>