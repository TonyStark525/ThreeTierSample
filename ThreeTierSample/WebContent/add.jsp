<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Student</title>
</head>
<body>
	Please enter the student Information of the student you want to add:
	<form action="AddStudentServlet" method="post">
		Number:<input type="text" name="sno"><br/>
		Name:<input type="text" name="sname"><br/>
		Age:<input type="text" name="sage"><br/>
		Address:<input type="text" name="saddress"><br/>
		<input type="submit" value="add"><br/>
	</form>
</body>
</html>