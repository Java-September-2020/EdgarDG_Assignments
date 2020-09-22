<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Submit here</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div>
	<form method="POST" action="/results">
		<p>Your Name: <input type="text" name="name"></p>
		<p>Dojo Location: </p>
		<select name="location">
			<option value="Arlington, VA">Arlington, VA</option>
			<option value="Boise, ID">Boise, ID</option>
			<option value="Los Angeles, CA">Los Angeles, CA</option>
			<option value="Silicon Valley, CA">Silicon Valley, CA</option>
		</select>
		<p>Favorite Language: </p>
		<select name="language">
			<option value="Java">Java</option>
			<option value="Python">Python</option>
			<option value="C">C</option>
			<option value="Javascript">Javascript</option>
		</select>
		<p>Comment (Optional): <textarea name="comment"></textarea></p>
		<button>Button</button>
	</form>
</div>
</body>
</html>