<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>The Library</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body>
<div class="wrapper">

<form:form method="POST" action="/book" modelAttribute="book">
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

<button>Add Book</button>
</form:form>

</div>
</body>
</html>