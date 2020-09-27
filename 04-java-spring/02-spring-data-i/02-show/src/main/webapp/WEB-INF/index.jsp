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
<h1>Welcome to the Library</h1>

<table class="table">
<thead>
<td>ID</td>
<td>Title</td>
<td>Description</td>
<td>Language</td>
<td>Number Of Pages</td>
</thead>

<tbody>
<c:forEach items="${allBooks}" var="book">
<tr>
<td><a href="/${book.id}">${book.id}</a></td>
<td>${book.title}</td>
<td>${book.description}</td>
<td>${book.language}</td>
<td>${book.pages}</td>
</tr>
</c:forEach>

</tbody>
</table>

<a href="/add"> Add A New Book</a>

</div>
</body>
</html>