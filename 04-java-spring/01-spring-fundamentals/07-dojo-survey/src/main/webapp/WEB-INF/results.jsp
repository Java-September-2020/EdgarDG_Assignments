<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Results</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div>
	<p>Name: <c:out value="${name}"/></p>
	<p>Dojo Location: <c:out value="${location}"/></p>
	<p>Favorite Language: <c:out value="${language}"/></p>
	<br>
	<p>Comment: <c:out value="${comment}"/></p>
</div>
</body>
</html>