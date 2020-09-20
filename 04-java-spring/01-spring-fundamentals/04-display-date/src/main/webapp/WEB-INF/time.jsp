<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>What Time is it?</title>
<script type='text/javascript' src='https://code.jquery.com/jquery-1.12.0.min.js'></script>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<body onload="alertMe()">
<h1><c:out value="${ dtFormat }" /></h1>
</body>
<script defer type="text/javascript" src="js/timeAlert.js"></script>
</html>