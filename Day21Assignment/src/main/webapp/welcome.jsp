<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer List</title>
</head>
<body>
	<h1>Customer List</h1>

	<form action="customer">
		<input type="submit" value="Get All customers">
	</form>
	
	<c:forEach items="${custList}" var="cust">
		${cust.custId}&nbsp;&nbsp;&nbsp;&nbsp;${cust.custName}&nbsp;&nbsp;&nbsp;&nbsp;${cust.custEmail}<br/>
	</c:forEach>

</body>
</html>