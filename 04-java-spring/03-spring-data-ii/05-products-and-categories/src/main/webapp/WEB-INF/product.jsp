<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body>

<div class="container">

<h1>${product.name}</h1>
<p>${ product.description }</p>
<p>${ product.price }</p>

<h4>Categories:</h4>

<ul>
<c:forEach items="${ product.categories }" var="category">
<li>${ category.name }</li>
</c:forEach>
</ul>

<div class="float-right">
<form:form>
<form:label path="category"> Add Category:        
<form:errors path="category"/>
<form:select path="category">
<c:forEach items="${category}" var="category">
<option value="${category.id}">${category.name}</option>
</c:forEach>
</form:select>
</form:label>
</form:form>

</div>


</div>

</body>
</html>