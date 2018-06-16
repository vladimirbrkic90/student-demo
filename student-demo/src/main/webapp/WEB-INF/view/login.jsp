<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

    <head>
        <title>Spring Security Example </title>
        
        <style type="text/css">
        	.failed {
        		color: red;
        	}
        </style>
        
    </head>
    
    <body>
        
        <form:form action="${pageContext.request.contextPath}/authenticateTheUser" method="post">
        
        	<!-- Check for login error -->
        	
        	<c:if test="${param.error != null}">
        		<i class="failed">Invalid username or password.</i>
        	</c:if>
        	
            <p> 
                User Name : <input type="text" name="username"/> 
            </p>
            
            <p> 
                Password: <input type="password" name="password"/> 
            </p>
            
            <input type="submit" value="Sign In"/>
            
        </form:form>
        
    </body>
    
</html>
