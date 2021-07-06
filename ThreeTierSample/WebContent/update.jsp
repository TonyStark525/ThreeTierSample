<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Student Information</title>
</head>
<body>
	<%
		int sno = Integer.parseInt(request.getParameter("sno"));
	
	%>
	<form action="UpdateStudentServlet" method="post">
		Please enter the student number of the student to be modified:<input type="text" name="sno" value=<%=sno %> readonly="readonly"><br/>
		Please enter the modified Name:<input type="text" name="sname"><br/>
		Please enter the modified age:<input type="text" name="sage"><br/>
		Please enter the modified address:<input type="text" name="saddress"><br/>
		<input type="submit" value="修改"><br/>
	</form>
</body>
</html>