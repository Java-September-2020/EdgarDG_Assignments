<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Book!</title>
</head>
<body>

<p>Current Information</p>
<hr>

<form:form method="POST" action="/edit/${book.id}" modelAttribute="book">
<p>
<form:label path="title">Title:
<form:errors path="title"/>
<form:input path="title"/>
</form:label>
</p>

<p>
<form:label path="description">Description:
<form:errors path="description"/>
<form:input path="description"/>
</form:label>
</p>

<p>
<form:label path="language">Language:
<form:errors path="language"/>
<form:input path="language"/>
</form:label>
</p>

<p>
<form:label path="pages">Number of Pages:
<form:errors path="pages"/>
<form:input path="pages"/>
</form:label>
</p>

<button>Edit Book</button>
</form:form>


</body>
</html>