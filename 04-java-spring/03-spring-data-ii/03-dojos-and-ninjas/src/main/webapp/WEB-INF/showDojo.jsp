<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dojo Page</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body>
<div class="container">
<h1>${dojo.name} Location Ninjas</h1>

<table class="table table-hover">
<thead>
<td>First Name</td>
<td>Last Name</td>
<td>Age</td>
</thead>

<tbody>
<c:forEach items="${dojo.ninjas}" var="ninja">
<tr>
<td>${ninja.firstName}</td>
<td>${ninja.lastName}</td>
<td>${ninja.age}</td>
</tr>
</c:forEach>
</tbody>

</table>


</div>


</body>
</html>