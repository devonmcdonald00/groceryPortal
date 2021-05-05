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
	<form action="edit-customers" method="post">
	  <label for="customerId">Id:</label><br>
	  <input type="text" id="customerId" name="customerId"><br><br>
	  <input type="submit" value="submit query" name="button">
	</form> 

	<form action="edit-customers" method="post">
	  <label for="customerId">User Id:</label><br>
	  <input type="text" id="customerId" name="customerId" value="${customer.id}"><br>
	   <label for="name">Name:</label><br>
	  <input type="text" id="name" name="name" value="${customer.name}"><br>
	  <label for="email">Email:</label><br>
	  <input type="text" id="email" name="email" value="${customer.email}"><br>
	  
	  <br>
	  <input type="submit" value="submit edit" name="button">
	</form>
	<sql:setDataSource
        var="myDS"
        driver="com.mysql.jdbc.Driver"
        url="jdbc:mysql://localhost:3306/db_example"
        user="springuser" password="ThePassword"
    />
     
    <sql:query var="listUsers"   dataSource="${myDS}">
        SELECT * FROM customers;
    </sql:query>
     
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of customers</h2></caption>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
            </tr>
            <c:forEach var="customer" items="${listUsers.rows}">
                <tr>
                    <td><c:out value="${customer.id}" /></td>
                    <td><c:out value="${customer.name}" /></td>
                    <td><c:out value="${customer.email}" /></td>
                </tr>
            </c:forEach>
        </table>
        <br></br>
        <form action="edit" method="post">
			<input type="submit" id="back" name="button" value="back"/>
		</form>
    </div>
</body>
</html>