<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Coding Languages</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body>
<div class="container">
<h1>Coding Languages</h1>
<h3>Let's Code!</h3>

<table class="table table-dark">
<thead>
<td>Name</td>
<td>Creator</td>
<td>Version</td>
<td>Action</td>
</thead>

<tbody>
<c:forEach items="${allLangs}" var="language">
<tr>
<td><a href="/languages/${language.id}">${language.name}</a></td>
<td>${language.creator}</td>
<td>${language.version}</td>
<td><a href="/languages/edit/${language.id }">Edit</a> | <a href="/delete/${language.id }">Delete</a> </td>

</tr>
</c:forEach>
</tbody>
</table>

<c:forEach items="${errors}" var="err">
<p>${err}</p>
</c:forEach>

<form:form action="/languages" method="POST" modelAttribute="language">

<div class="form-data">
<p>
<form:label path="name">Name: 
<form:errors path="name"/>
<form:input path="name"/>
</form:label>
</p>

<p>
<form:label path="creator">Creator: 
<form:errors path="creator"/>
<form:input path="creator"/>
</form:label>
</p>

<p>
<form:label path="version">Version: 
<form:errors path="version"/>
<form:input path="version"/>
</form:label>
</p>


<button>Submit</button>
</div>
</form:form>
</div>
</body>
</html>