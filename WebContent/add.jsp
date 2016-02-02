<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ems-servlet</title>
</head>
<body>
	<div>
		<h4>Create a New Employee</h4>
		<form action="empCtrl" method="post">
			<input type="hidden" name="id" value="${employee.id}">
			<table>
				<tr>
					<td>Name :</td>
					<td><input type="text" name="name" value="${employee.name}"></td>
					<br>
				</tr>
				<tr>
					<td>Location :</td>
					<td><input type="text" name="location"
						value="${employee.location}"></td>
					<br>
				</tr>
				<tr>
					<td>Email :</td>
					<td><input type="text" name="email"
						value="${employee.email}"></td>
					<br>
				</tr>
				<tr>
					<td><input type="submit" value="Submit"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>