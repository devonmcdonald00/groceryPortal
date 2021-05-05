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
	<sql:setDataSource
        var="myDS"
        driver="com.mysql.jdbc.Driver"
        url="jdbc:mysql://localhost:3306/db_example"
        user="springuser" password="ThePassword"
    />
     
    <sql:query var="listSales"   dataSource="${myDS}">
        SELECT * FROM sales;
    </sql:query>
     
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Sales</h2></caption>
            <tr>
                <th>ID</th>
                <th>Product</th>
                <th>Name</th>
                <th>Total</th>
            </tr>
            <c:forEach var="sale" items="${listSales.rows}">
                <tr>
                    <td><c:out value="${sale.id}" /></td>
                    <td><c:out value="${sale.product}" /></td>
                    <td><c:out value="${sale.customer_name}" /></td>
                    <td><c:out value="${sale.total}" /></td>
                </tr>
            </c:forEach>
        </table>
        <br></br>
        <form action="view" method="post">
			<input type="submit" id="back" name="button" value="back"/>
		</form>
    </div>
</body>
</html>