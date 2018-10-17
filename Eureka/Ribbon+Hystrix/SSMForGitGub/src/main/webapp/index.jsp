<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page!</title>

<script type="text/javascript" src="statics/js/jquery-1.9.1.js"></script>

<script type="text/javascript">

$(document).ready(function(e){
	console.log("Hello World!");
	alert("Hello World!")
});

</script>
</head>
<body>

<h1>HelloWorld</h1>

<h2>${requestScope.girl}</h2>
</body>
</html>