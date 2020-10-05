<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New License</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body>
<div class="container">
<h1>New License</h1>

<form:form action="/licenses/new" method="POST" modelAttribute="license">

<div class="form form-group">
<form:label path="person"> Person: 
<form:errors path="person"/>
<form:select path="person">
<c:forEach items="${person}" var="person">
<option value="${person.id}">${person.firstName} ${person.lastName}</option>
</c:forEach>
</form:select>
</form:label>
</div>

<div class="form form-group">
<form:label path="state"> State: 
<form:errors path="state"/>
<form:input path="state"/>
</form:label>
</div>

<div class="form form-group">
<form:label path="expiration_date"> Expiration Date: 
<form:errors path="expiration_date"/>
<form:input type="date" path="expiration_date"/>
</form:label>
</div>


<button class="btn btn-primary">Create</button>
</form:form>
</div>
</body>
</html>