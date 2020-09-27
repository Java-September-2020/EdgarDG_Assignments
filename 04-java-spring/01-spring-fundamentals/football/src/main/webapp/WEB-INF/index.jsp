<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Football dot Com</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body>
<div class="container">
<h1>Welcome to Football dot Com</h1>
<hr>
<table class="table">
<thead>
<th>id</th>
<th>Name</th>
<th>City</th>
<th>Number of Players</th>
</thead>

<tbody>
<c:forEach items="${allTeams}" var="team">
<tr>
<td><a href="/${team.id}">${team.id}</a></td>
<td>${team.name}</td>
<td>${team.city}</td>
<td>${team.players}</td>
</tr>
</c:forEach>
</tbody>
</table>

</div>	
</body>
</html>