<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Questions</title>
</head>
<body>
	<table border="1">
		<c:forEach items="${questions}" var="question">
		<tr>
		<td><a href="<c:url value="/answers?id=${question.id}" />">${question.title}</a><br/>
		${question.shortBody}
		</td>
		</tr>
		</c:forEach>
	</table>
	
</body>
</html>