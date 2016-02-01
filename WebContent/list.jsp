<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ems servlet</title>
</head>
<body>

	<div>
		<h4>Employee list</h4>
	</div>

	<div>
		<table border=1>
			<thead>
				<tr>
					<th>#</th>
					<th>Name</th>
					<th>Location</th>
					<th>Email</th>
					<th colspan=2>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${employees}" var="emp">
					<tr>
						<td><c:out value="${emp.id}" /></td>
						<td><c:out value="${emp.name}" /></td>
						<td><c:out value="${emp.location}" /></td>
						<td><c:out value="${emp.email}" /></td>
						<td><a
							href="empCtrl?action=edit&id=<c:out value="${emp.id}"/>">Update</a></td>
						<td><a
							href="empCtrl?action=delete&id=<c:out value="${emp.id}"/>">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<div>
		<p>
			<a href="empCtrl?action=insert">Add Employee</a>
		</p>
	</div>
</body>
</html>