<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Question</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">
</head>
<body>

<div class="container">
<h1>What is your question?</h1>	
<hr>
	
	<c:forEach items="${ errors }" var="err">
	${err}
	</c:forEach>
	<form:form action="/questions/new" method="POST" methodAttribute="question">
	
<div class="form form-group">
<form:label path="question"> Question: 
<form:errors path="question"/>
<form:textarea path="question"/>
</form:label>
</div>

<div class="form form-group">
<form:label path="tags"> Tags: 
<form:errors path="tags"/>
<form:input path="tags"/>
</form:label>
</div>

<button class="btn btn-primary">Submit</button>
</form:form>
</div>
	
	
<%-- 	<form action="/questions/new" method="POST"> --%>
	
<!-- 	<div class="form-group"> -->
<!-- 	<label for="question">Question: </label> -->
<!-- 	<textarea rows="5" cols="50" name="question"></textarea> -->
<!-- 	</div> -->
	
<!-- 	<div class="form-group"> -->
<!-- 	<label for="tag">Tags: </label> -->
<!-- 	<input type="text" name="tag"> -->
<!-- 	</div> -->
	
<!-- 	<button class="btn btn-primary">Submit</button> -->
	
<%-- 	</form> --%>
		
</div>

</body>
</html>