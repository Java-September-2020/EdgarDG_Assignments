<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Secret Code</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<div>
	<p><c:out value="${errors}"/></p>
	<h1>What is the Code?</h1>
	<form method="POST" action="/code">
	<input type="text" name="password">
	<button>Try Code</button>
	</form>
	</div>
</body>
</html>