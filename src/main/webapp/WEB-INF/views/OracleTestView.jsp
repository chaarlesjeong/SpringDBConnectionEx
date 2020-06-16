<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>OracleTestView</title>
</head>
<body>
	<h1>Oracle_TABEX</h1>
	<hr />

	<table border="1">
		<thead>
			<tr>
				<th>이름</th>
				<th>나이</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="array" items="${array}">
				<tr>
					<td>${array.name}</td>
					<td>${array.age}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<br />
	<hr />
	<a href="
<c:url value='index.jsp' />
">Home</a>

</body>
</html>