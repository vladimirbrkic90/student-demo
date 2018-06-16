<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<head>

	<title>Save student</title>
	
	<link type="text/css"
		  rel="stylesheet"
		  href="/resources/css/style.css" />
		  
	<link type="text/css"
		  rel="stylesheet"
		  href="/resources/css/add-student-style.css" />
	
	<style>
		.error{color:red}
	</style>

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>SRM - Student Relationship Manager</h2>
		</div>
	</div>
	
	<div id="container">
		<h3>Save student</h3>
	
		<form:form action="saveStudent" modelAttribute="student" method="POST">
		
			<!-- need to associate this data with student id -->
			<form:hidden path="id" />
		
			<table>
				<tbody>
					<tr>
						<td> <label>First name:</label> </td>
						<td> <form:input path="firstName"/> </td>
					</tr>
					
					<tr>
						<td> <label>Last name:</label> </td>
						<td> <form:input path="lastName"/> </td>
						<td> <form:errors path="lastName" cssClass="error" /> </td>
					</tr>
					
					<tr>
						<td> <label>Email:</label> </td>
						<td> <form:input path="email"/> </td>
					</tr>
					
					<tr>
						<td> <label></label> </td>
						<td> <input type="submit" value="Save" class="save" /> </td>
					</tr>
					
				</tbody>
			</table>
		
		</form:form>
		
		<div style="clear; both;"></div>
		
		<p>
			<a href="${pageContext.request.contextPath}/student/list">Back to List</a>
		</p>
		
	</div>

</body>

</html>