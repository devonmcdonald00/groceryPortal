<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>   
<html>
<head>
<style>
table, th, td {
  border: 1px solid black;
}
</style>
</head>
<body>
<h2>View Only (Non-Admin)</h2>

<p>${message}</p>

<form action="view" method="post">
	<input type="submit" id="view sales" name="button" value="view customers"/>
	<br></br>
	<input type="submit" id="view sales" name="button" value="view sales"/>
	<br></br>
	
</form>

<form action="login" method="get">
	<input type="submit" id="login" name="button" value="Login"/>
</form>

</body>
</html>