<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee List</title>
</head>
<body>
	<h1>Employee List</h1>

	<form action="employee">
		<input type="submit" value="Get All employees">
	</form>
	
	<c:forEach items="${empList}" var="emp">
		${emp.empId}&nbsp;&nbsp;&nbsp;&nbsp;${emp.empName}&nbsp;&nbsp;&nbsp;&nbsp;${emp.empSal}<br/>
	</c:forEach>

</body>
</html>