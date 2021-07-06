<%@page import="org.student.entity.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Details Page</title>
</head>
<body>
	<%
		Student student = (Student)request.getAttribute("student");
	%>
	Student No Is : <%=student.getSno() %><br/>
	Student Name Is : <%=student.getSname() %><br/>
	Student Age Is : <%=student.getSage() %><br/>
	Student Address Is : <%=student.getSaddress() %><br/>
</body>
</html>