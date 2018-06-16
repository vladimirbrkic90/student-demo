<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>

<head>

	<title>List Students</title>
	
	<link type="text/css"
		  rel="stylesheet"
		  href="/resources/css/style.css" />

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>SRM - Student Relationship Manager</h2>
		</div>
	</div>
	
	<p>
		User: <security:authentication property="principal.username" />
	</p>
	
	<div id="container">
	
		<div id="content">

		<security:authorize access="hasAnyRole('ADMIN')">

			<input type="button" value="Add Student"
					onclick="window.location.href='showFormForAdd'; return false; "
					class="add-button"
			/>
			
		</security:authorize>

	<table>
	
		<tr>
			<th>First name</th>
			<th>Last name</th>
			<th>Email</th>
			<th>Action</th>
		</tr>
		
		<c:forEach var="tempStudent" items="${students}">
		
					<!-- Construct an "update" link with customer id -->
					<c:url var="updateLink" value="/student/showFormForUpdate">
						<c:param name="studentId" value="${tempStudent.id}" />
					</c:url>
					
					<!-- Construct an "delete" link with customer id -->
					<c:url var="deleteLink" value="/student/delete">
						<c:param name="studentId" value="${tempStudent.id}" />
					</c:url>
		
			<tr>
				<td> ${tempStudent.firstName} </td>
				<td> ${tempStudent.lastName} </td>
				<td> ${tempStudent.email} </td>
				
				
				<td>
					<!-- display the update link -->
					<a href="${updateLink}">Update</a>
							|
					<!-- display the delete link -->
					<a href="${deleteLink}"
					onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>
					
				</td>
				
			</tr>
		
		</c:forEach>
	
	</table>
	<br><br>
	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
		
		<input type="submit" value="Logout" class="add-button" />
	
	</form:form>
	
	</div>
	
</div>

</body>

</html>
